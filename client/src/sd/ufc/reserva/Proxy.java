package sd.ufc.reserva;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import sd.ufc.reserva.model.ObjectAuthUsuario.AuthUsuario;
import sd.ufc.reserva.model.ObjectCadastroUsuario.CadastroUsuario;
import sd.ufc.reserva.model.ObjectIdentificacao;
import sd.ufc.reserva.model.ObjectIdentificacao.Identificacao;
import sd.ufc.reserva.model.ObjectListaReserva.ListaReserva;
import sd.ufc.reserva.model.ObjectListaSala.ListaSala;
import sd.ufc.reserva.model.ObjectMensagem.Mensagem;
import sd.ufc.reserva.model.ObjectMessageResponse.MessageResponse;
import sd.ufc.reserva.model.ObjectReserva.Reserva;

public class Proxy {

	UDPClient udpclient;
	private int id_usuario = -1;
	private static int id_request = 0;

	public Proxy() {
		udpclient = new UDPClient("localhost", 20001);
	}

	public void ListarSalas() {

		byte[] args = new byte[1024];
		args = EmpacotaArg();

		Mensagem aux = doOperation("ReferenceSala", "Metodo_listar_salas", args);

		ListaSala listsala = null;
		try {
			listsala = ListaSala.parseFrom(aux.getArguments());
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		} catch (java.lang.NullPointerException e) {
			System.out.println("Servidor n�o respondeu!");
		}

		if (listsala != null) {
			int t = listsala.getListCount();
			for (int i = 0; i < t; i++) {
				System.out
						.println("ID: " + listsala.getList(i).getIdSala() + " Nome: " + listsala.getList(i).getNome());
			}
		}

	}

	public void ListarReservas() {
		byte[] args = new byte[1024];
		args = EmpacotaArg();

		ObjectIdentificacao.Identificacao iden;
		iden = ObjectIdentificacao.Identificacao.newBuilder().setId(id_usuario).build();

		ByteArrayOutputStream mensagem_em_bytes = new ByteArrayOutputStream(1024);

		try {
			iden.writeDelimitedTo(mensagem_em_bytes);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		args = mensagem_em_bytes.toByteArray();

		Mensagem aux = doOperation("ReferenceReserva", "Metodo_listar_reservas", args);

		ListaReserva listreserva = null;

		try {
			listreserva = ListaReserva.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
		} catch (java.lang.NullPointerException e) {
			System.out.println("Servidor n�o respondeu!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (listreserva != null) {
			int t = listreserva.getReservasCount();
			for (int i = 0; i < t; i++) {
				System.out.println("Sala : " + listreserva.getReservas(i).getIdSala() + " Horario: "
						+ listreserva.getReservas(i).getHorario() + " Data: " + listreserva.getReservas(i).getData());
			}
		}
	}

	public void ListarPedidosReservas() {
		byte[] args = new byte[1024];
		args = EmpacotaArg();

		Identificacao iden;
		iden = Identificacao.newBuilder().setId(id_usuario).build();

		ByteArrayOutputStream mensagem_em_bytes = new ByteArrayOutputStream(1024);

		try {
			iden.writeDelimitedTo(mensagem_em_bytes);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		args = mensagem_em_bytes.toByteArray();

		Mensagem aux = doOperation("ReferenceReserva", "Metodo_listar_pedido_reservas", args);

		ListaReserva listreserva = null;

		try {
			listreserva = ListaReserva.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
		} catch (java.lang.NullPointerException e) {
			System.out.println("Servidor n�o respondeu!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (listreserva != null) {
			int t = listreserva.getReservasCount();
			for (int i = 0; i < t; i++) {
				System.out.println("Sala : " + listreserva.getReservas(i).getIdSala() + " Horario: "
						+ listreserva.getReservas(i).getHorario() + " Data: " + listreserva.getReservas(i).getData());
			}
		}

	}

	private byte[] EmpacotaArg() {
		byte[] args = new byte[1024];
		args = new String("").getBytes();

		return args;
	}

	public String CadastrarUsuario(String nome, String usuario, String senha, String cpf, String matricula,
			String curso) {// cad proto
		byte[] args = new byte[1024];
		args = empacotaCadastro(nome, usuario, senha, cpf, matricula, curso);

		Mensagem aux = doOperation("ReferenceAuth", "Metodo_cadastro_usuario", args);

		MessageResponse msgResposta = null;

		try {
			msgResposta = MessageResponse
					.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msgResposta.getMensagem();// string
	}

	private byte[] empacotaCadastro(String nome, String usuario, String senha, String cpf, String matricula,
			String curso) {
		CadastroUsuario cad = CadastroUsuario.newBuilder().setNome(nome).setUsuario(usuario).setSenha(senha).setCpf(cpf)
				.setMatricula(matricula).setCurso(curso).build();

		ByteArrayOutputStream cad_em_bytes = new ByteArrayOutputStream(1024);
		try {
			cad.writeDelimitedTo(cad_em_bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cad_em_bytes.toByteArray();
	}

	public String RealizarPedidoReserva(String id_sala, String data, String horario) {

		byte[] args = new byte[1024];
		args = EmpacotaPedReserva(id_sala, data, horario);

		Mensagem aux = doOperation("ReferenceReserva", "Metodo_adicionar_pedido_reserva", args);

		MessageResponse msgcallback = null;
		try {
			msgcallback = MessageResponse
					.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msgcallback.getMensagem();
	}

	private byte[] EmpacotaPedReserva(String id_sala, String data, String horario) {
		Reserva res = Reserva.newBuilder().setId(0).setIdUsuario(id_usuario).setIdSala(Integer.parseInt(id_sala))
				.setData(data).setHorario("A").build();

		byte[] args = new byte[1024];

		ByteArrayOutputStream mensagem_em_bytes = new ByteArrayOutputStream(1024);
		try {
			res.writeDelimitedTo(mensagem_em_bytes);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		args = mensagem_em_bytes.toByteArray();

		return args;
	}

	public String CancelarPedidoReserva(String id) {
		byte[] args = new byte[1024];
		args = EmpacotaCancelReserva(id);

		Mensagem aux = doOperation("ReferenceReserva", "Metodo_cancelar_pedido_reserva", args);

		MessageResponse msgcallback = null;
		try {
			msgcallback = MessageResponse
					.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
		} catch (java.lang.NullPointerException e) {
			System.out.println("Servidor N�o Respondeu!");

		} catch (IOException e) {

			e.printStackTrace();
		}

		if (msgcallback != null) {
			return msgcallback.getMensagem();
		} else {
			return "";
		}

	}

	public String VerPedidoReserva(String id) {
		Reserva res = Reserva.newBuilder().setId(Integer.parseInt(id)).setIdUsuario(id_usuario).setIdSala(0).setData("")
				.setHorario("").build();

		byte[] args = new byte[1024];
		ByteArrayOutputStream mensagem_em_bytes = new ByteArrayOutputStream(1024);
		try {
			res.writeDelimitedTo(mensagem_em_bytes);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		args = mensagem_em_bytes.toByteArray();

		Mensagem aux = doOperation("ReferenceReserva", "Metodo_ver_pedido_reserva", args);

		MessageResponse msgcallback = null;
		try {
			msgcallback = MessageResponse
					.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
		} catch (java.lang.NullPointerException e) {
			System.out.println("Servidor N�o Respondeu!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (msgcallback != null) {
			return msgcallback.getMensagem();
		} else {
			return "";
		}
	}

	private byte[] EmpacotaCancelReserva(String id) {
		Reserva res = Reserva.newBuilder().setId(Integer.parseInt(id)).setIdUsuario(id_usuario).setIdSala(0).setData("")
				.setHorario("").build();

		byte[] args = new byte[1024];
		ByteArrayOutputStream mensagem_em_bytes = new ByteArrayOutputStream(1024);
		try {
			res.writeDelimitedTo(mensagem_em_bytes);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		args = mensagem_em_bytes.toByteArray();

		return args;
	}

	public String Logar(String usuario, String senha) {

		byte[] args = new byte[1024];
		args = EmpacotaLogin(usuario, senha);

		Mensagem aux = doOperation("ReferenceAuth", "Metodo_autenticar", args);

		try {
			Identificacao ident = Identificacao
					.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			id_usuario = ident.getId();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (id_usuario > 0) {
			return "Login realizado com sucesso";
		}
		return "N�o foi possivel realizar o login: Usuario ou senha incorretos";
	}

	private byte[] EmpacotaLogin(String usuario, String senha) {
		AuthUsuario auth = AuthUsuario.newBuilder().setUsuario(usuario).setSenha(senha).build();
		byte[] args = new byte[1024];
		ByteArrayOutputStream mensagem_em_bytes = new ByteArrayOutputStream(1024);
		try {
			auth.writeDelimitedTo(mensagem_em_bytes);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		args = mensagem_em_bytes.toByteArray();
		return args;
	}

	public String Deslogar() {
		id_usuario = -1;
		return "Voce deslogou";
	}

	private Mensagem doOperation(String objectRef, String method, byte[] args) {

		byte[] data = empacotaMensagem(objectRef, method, args);

		udpclient.sendRequest(data);

		boolean estouro = true;

		Mensagem resposta = null;
		for (int i = 0; i < 3; i++) {
			if (estouro) {
				estouro = false;
				byte[] m;
				try {
					m = udpclient.getReplay();
					resposta = desempacotaMensagem(m);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					if (e.getMessage().equals("SocketTimeoutException")) {
						// retransmite
						System.out.println("Estouro : " + i);
						estouro = true;
						udpclient.sendRequest(data);
					}
//					e.printStackTrace();
				}
			}
		}

		id_request += 1;
		return resposta;

	}

	private byte[] empacotaMensagem(String objectRef, String method, byte[] args) {
		Mensagem msg = Mensagem.newBuilder().setMessageType(0).setRequestId(id_request).setObjectReference(objectRef)
				.setMethod(method).setArguments(ByteString.copyFrom(args)).build();
		ByteArrayOutputStream mensagem_em_bytes = new ByteArrayOutputStream(1024);
		try {
			msg.writeDelimitedTo(mensagem_em_bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mensagem_em_bytes.toByteArray();
	}

	private Mensagem desempacotaMensagem(byte[] args) {
		Mensagem msg = null;
		try {
			msg = Mensagem.parseDelimitedFrom(new ByteArrayInputStream(args));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return msg;
	}

	void finaliza() {
		udpclient.finaliza();
	}
}