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
	private static int id_usuario = -1;
	private static int id_request = 0;

	public Proxy() {
		udpclient = new UDPClient("localhost", 20001);
	}

	public boolean isLogado() {
		return id_usuario == -1 ? false : true;
	}

	public void MenuAdmin() {
		if (isLogado() == false) {
			System.out.println("\nDigite o nº da operação que deseja executar: ");
			System.out.println("1. Logar");
		} else {
			System.out.println("\nDigite o n# da operação que deseja executar: ");
			System.out.println("2. Listar pedidos pendentes de reservas");
			System.out.println("3. Aceitar pedido pendente de reserva");
			System.out.println("4. Recusar pedido pendente de reserva");
		}
	}

	public void Menu() {
		if (isLogado() == false) {
			System.out.println("\nDigite o nº da operação que deseja executar: ");
			System.out.println("1. Listar Salas");
			System.out.println("2. Logar");
			System.out.println("\nAPLICAÇÃO");
			System.out.println("10. Cadastro no sistema");
			System.out.println("11. Finalizar programa");
		} else {
			System.out.println("\nDigite o n# da operação que deseja executar: ");
			System.out.println("1. Listar Salas");
			System.out.println("\nPEDIDOS");
			System.out.println("3. Realizar pedido de reserva");
			System.out.println("4. Ver informações de um pedido pendente");
			System.out.println("5. Listar pedidos de reservas pendentes");
			System.out.println("\nRESERVAS");
			System.out.println("6. Listar reservas futuras");
			System.out.println("7. Cancelar reserva futura");
			System.out.println("8. Listar historico de reservas ");
			System.out.println("\nAPLICAÇÃO");
			System.out.println("9. Deslogar");
			System.out.println("11. Finalizar programa");
		}
	}

	// M�TODOS DO ADMINISTRADOR
	// --------------------------------------------------------------------------
	public String AceitarPedidoReserva(String id) {
		if (isLogado()) {
			byte[] args = new byte[1024];
			args = EmpacotaReserva(id);

			Mensagem aux = doOperation("ReferenceReserva", "Metodo_aceita_pedido_reserva", args);

			MessageResponse msgcallback = null;
			try {
				msgcallback = MessageResponse
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			} catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (msgcallback != null) {
				return msgcallback.getMensagem();
			} else {
				return "";
			}
		} else {
			return "Operação não executada: Por favor você deve-se logar";
		}
	}

	public String RejeitarPedidoReserva(String id) {
		if (isLogado()) {
			byte[] args = new byte[1024];
			args = EmpacotaReserva(id);

			Mensagem aux = doOperation("ReferenceReserva", "Metodo_rejeita_pedido_reserva", args);

			MessageResponse msgcallback = null;
			try {
				msgcallback = MessageResponse
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			} catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (msgcallback != null) {
				return msgcallback.getMensagem();
			} else {
				return "";
			}
		} else {
			return "Operação não executada: Por favor você deve-se logar";
		}
	}

	public void ListarTodosPedidosReservas() {
		if (isLogado()) {

			byte[] args = new byte[1024];

			args = EmpacotaArg();

			Mensagem aux = doOperation("ReferenceReserva", "Metodo_listar_todos_pedido_reservas", args);

			ListaReserva listreserva = null;

			try {
				listreserva = ListaReserva
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			} catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (listreserva.getReservasCount() != 0) {
				int t = listreserva.getReservasCount();
				for (int i = 0; i < t; i++) {
					System.out.println("ID : " + listreserva.getReservas(i).getId() + " Sala : "
							+ listreserva.getReservas(i).getIdSala() + " Horario: "
							+ listreserva.getReservas(i).getHorario() + " Data: "
							+ listreserva.getReservas(i).getData());
				}
			} else {
				System.out.println("Lista de pedidos reservas\n vazia");
			}
		} else {
			System.out.println("Operação não executada: Por favor você deve-se logar");
		}
	}

	// ------------------------------------------------------------------------------------------------------------------

	// M�TODOS DO CLIENTE
	// ------------------------------------------------------------------------------------------------

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
			System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
		} catch (IOException e) {
			e.printStackTrace();
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
		if (isLogado()) {
			byte[] args = new byte[1024];
			args = empacotaId();

			Mensagem aux = doOperation("ReferenceReserva", "Metodo_listar_reservas", args);
			ListaReserva listreserva = null;

			try {
				listreserva = ListaReserva
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			} catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (listreserva.getReservasCount() != 0) {
				int t = listreserva.getReservasCount();
				for (int i = 0; i < t; i++) {
					System.out.println("Sala : " + listreserva.getReservas(i).getIdSala() + " Horario: "
							+ listreserva.getReservas(i).getHorario() + " Data: "
							+ listreserva.getReservas(i).getData());
				}
			} else {
				System.out.println("Lista de reservas futuras vazia");
			}
		} else {
			System.out.println("Operação não executada: Por favor você deve-se logar");
		}
	}

	public void ListarHistorico() {
		if (isLogado()) {
			byte[] args = new byte[1024];
			args = empacotaId();

			Mensagem aux = doOperation("ReferenceReserva", "Metodo_listar_historico", args);
			ListaReserva listreserva = null;

			try {
				listreserva = ListaReserva
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			}catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (listreserva.getReservasCount() != 0) {
				int t = listreserva.getReservasCount();
				for (int i = 0; i < t; i++) {
					System.out.println("Sala : " + listreserva.getReservas(i).getIdSala() + " Horario: "
							+ listreserva.getReservas(i).getHorario() + " Data: "
							+ listreserva.getReservas(i).getData());
				}
			} else {
				System.out.println("Lista do historico de reservas vazia");
			}
		} else {
			System.out.println("Operação não executada: Por favor você deve-se logar");
		}
	}

	public void ListarPedidosReservas() {
		if (isLogado()) {

			byte[] args = new byte[1024];

			args = empacotaId();

			Mensagem aux = doOperation("ReferenceReserva", "Metodo_listar_pedido_reservas", args);

			ListaReserva listreserva = null;

			try {
				listreserva = ListaReserva
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			} catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (listreserva.getReservasCount() != 0) {
				int t = listreserva.getReservasCount();
				for (int i = 0; i < t; i++) {
					System.out.println("ID : " + listreserva.getReservas(i).getId() + " Sala : "
							+ listreserva.getReservas(i).getIdSala() + " Horario: "
							+ listreserva.getReservas(i).getHorario() + " Data: "
							+ listreserva.getReservas(i).getData());
				}
			} else {
				System.out.println("Lista de pedidos reservas\n vazia");
			}
		} else {
			System.out.println("Operação não executada: Por favor você deve-se logar");
		}
	}

	public String CadastrarUsuario(String nome, String usuario, String senha, String cpf, String matricula,
			String curso) {// cad proto
		if (!isLogado()) {
			byte[] args = new byte[1024];
			args = empacotaCadastro(nome, usuario, senha, cpf, matricula, curso);

			Mensagem aux = doOperation("ReferenceAuth", "Metodo_cadastro_usuario", args);

			MessageResponse msgResposta = null;

			try {
				msgResposta = MessageResponse
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			} catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return msgResposta.getMensagem();// string
		} else {
			return "Operação invalida";
		}
	}

	public String RealizarPedidoReserva(String id_sala, String data, String horario) {
		if (isLogado()) {
			byte[] args = new byte[1024];
			args = EmpacotaPedReserva(id_sala, data, horario);

			Mensagem aux = doOperation("ReferenceReserva", "Metodo_adicionar_pedido_reserva", args);

			MessageResponse msgcallback = null;
			try {
				msgcallback = MessageResponse
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			} catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return msgcallback.getMensagem();
		} else {
			return "Operação não executada: Por favor você deve-se logar";
		}
	}

	public String CancelarPedidoReserva(String id) {
		if (isLogado()) {
			byte[] args = new byte[1024];

			args = EmpacotaReserva(id);

			Mensagem aux = doOperation("ReferenceReserva", "Metodo_cancelar_reserva", args);

			MessageResponse msgcallback = null;
			try {
				msgcallback = MessageResponse
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			} catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (msgcallback != null) {
				return msgcallback.getMensagem();
			} else {
				return "";
			}
		} else {
			return "Operação não executada: Por favor você deve-se logar";
		}
	}

	public String VerPedidoReserva(String id) {
		if (isLogado()) {
			byte[] args = new byte[1024];
			args = EmpacotaReserva(id);

			Mensagem aux = doOperation("ReferenceReserva", "Metodo_ver_pedido_reserva", args);

			MessageResponse msgcallback = null;
			try {
				msgcallback = MessageResponse
						.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			} catch (java.lang.NullPointerException e) {
				System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (msgcallback != null) {
				return msgcallback.getMensagem();
			} else {
				return "";
			}
		} else {
			return "Operação não executada: Por favor você deve-se logar";
		}
	}

	public String Logar(String usuario, String senha) {

		byte[] args = new byte[1024];
		args = EmpacotaLogin(usuario, senha);

		Mensagem aux = doOperation("ReferenceAuth", "Metodo_autenticar", args);
		Identificacao ident = null;
		try {
			ident = Identificacao.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
			id_usuario = ident.getId();
			if (id_usuario != -1) {
				return "Login realizado com sucesso";
			}
			return "Não foi possivel realizar o login: Usuario ou senha incorretos";
		} catch (java.lang.NullPointerException e) {
			System.out.println("Servidor não respondeu!, Tente novamente mais tarde.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String Deslogar() {
		id_usuario = -1;
		return "Voce deslogou";
	}

	// -------------------------------------------------------------------------------------------------------------------------------

	// M�TODOS DE EMPACOTAMENTO
	// --------------------------------------------------------------------------------------------------------------

	private byte[] EmpacotaPedReserva(String id_sala, String data, String horario) {
		Reserva res = Reserva.newBuilder().setId(0).setIdUsuario(id_usuario).setIdSala(Integer.parseInt(id_sala))
				.setData(data).setHorario(horario).build();

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

	private byte[] EmpacotaArg() {
		byte[] args = new byte[1024];
		args = new String("").getBytes();

		return args;
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

	public byte[] empacotaId() {
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

		return mensagem_em_bytes.toByteArray();
	}

	private byte[] EmpacotaReserva(String id) {
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
			if (msg.getMessageType() == 1) {
//				System.out.println("Mensagem de resposta");
			} else {
				msg = null;
//				System.out.println("Mensagem de requisição : ErroMsg - era esperado uma mensagem de resposta");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return msg;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------

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
				} catch (SocketTimeoutException e) {
					estouro = true;
					udpclient.sendRequest(data);
				}
			}
		}

		id_request += 1;
		return resposta;

	}

	void finaliza() {
		udpclient.finaliza();
	}
}