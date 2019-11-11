package sd.ufc.reserva;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import sd.ufc.reserva.model.ObjectAuthUsuario.AuthUsuario;
import sd.ufc.reserva.model.ObjectIdentificacao;
import sd.ufc.reserva.model.ObjectIdentificacao.Identificacao;
import sd.ufc.reserva.model.ObjectListaReserva.ListaReserva;
import sd.ufc.reserva.model.ObjectListaSala.ListaSala;
import sd.ufc.reserva.model.ObjectMensagem.Mensagem;
import sd.ufc.reserva.model.ObjectMessageCallback.MessageCallback;
import sd.ufc.reserva.model.ObjectReserva.Reserva;

public class Proxy {

	UDPClient udpclient;
	private int id_usuario = -1;
	private static int id_request = 0;

	public Proxy() {
		udpclient = new UDPClient("localhost", 20001);
	}

	public String ListarSalas() {
		byte[] args = new byte[1024];
		args = new String("").getBytes();
		Mensagem aux = doOperation("ReferenceSala", "Metodo_listar_salas", args);

		ListaSala listsala = null;
		try {
			listsala = ListaSala.parseFrom(aux.getArguments());
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}

		return listsala.toString();
	}

	public String ListarReservas() {
		byte[] args = new byte[1024];
		args = new String("").getBytes();

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
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listreserva.toString();
	}

	public String ListarPedidosReservas() {
		byte[] args = new byte[1024];
		args = new String("").getBytes();

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
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listreserva.toString();
	}

	public String RealizarPedidoReserva(String id_sala, String data, String horario) {
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

		Mensagem aux = doOperation("ReferenceReserva", "Metodo_adicionar_pedido_reserva", args);

		MessageCallback msgcallback = null;
		try {
			msgcallback = MessageCallback
					.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msgcallback.getMensagem();
	}

	public String CancelarPedidoReserva(String id) {
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

		Mensagem aux = doOperation("ReferenceReserva", "Metodo_cancelar_pedido_reserva", args);

		MessageCallback msgcallback = null;
		try {
			msgcallback = MessageCallback
					.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msgcallback.getMensagem();
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

		MessageCallback msgcallback = null;
		try {
			msgcallback = MessageCallback
					.parseDelimitedFrom(new ByteArrayInputStream(aux.getArguments().toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msgcallback.getMensagem();
	}

	public String Logar(String usuario, String senha) {
		AuthUsuario auth = AuthUsuario.newBuilder().setUsuario(usuario).setSenha(senha).build();
		byte[] args = new byte[1024];
		ByteArrayOutputStream mensagem_em_bytes = new ByteArrayOutputStream(1024);
		try {
			auth.writeDelimitedTo(mensagem_em_bytes);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		args = mensagem_em_bytes.toByteArray();
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
		return "Não foi possivel realizar o login: Usuario ou senha incorretos";
	}

	public String Deslogar() {
		id_usuario = -1;
		return "Voce deslogou";
	}

	private Mensagem doOperation(String objectRef, String method, byte[] args) {

		byte[] data = empacotaMensagem(objectRef, method, args);

		udpclient.sendRequest(data);

		Mensagem resposta = desempacotaMensagem(udpclient.getReplay());

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
