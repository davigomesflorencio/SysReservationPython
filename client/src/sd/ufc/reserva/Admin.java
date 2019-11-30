package sd.ufc.reserva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin {

	private Proxy proxy;

	public Admin() {
		this.proxy = new Proxy();
	}

	public int selecionaOperacao() {

		int operacao = 0;

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String opt = null;
		do {
			try {
				opt = stdin.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());

		operacao = Integer.parseInt(opt);

		switch (operacao) {
		case 1:
			if (proxy.isLogado() == false) {
				System.out.println("Digite seu nome de usuario : ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String usuarioLogin = opt;

				System.out.println("Digite sua senha: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String senhaLogin = opt;

				System.out.println(proxy.LogarAdmin(usuarioLogin, senhaLogin));
			} else {
				System.out.println("Operação não existe");
			}
			break;
		case 2:
			proxy.ListarTodosPedidosReservas();
			break;
		case 3:
			System.out.println("Digite o id do pedido de reserva para ser aceito: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String id_pedido = opt;
			System.out.println(proxy.AceitarPedidoReserva(id_pedido));
			break;
		case 4:
			System.out.println("Digite o id do pedido de reserva para ser cancelado: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			id_pedido = opt;
			System.out.println(proxy.CancelarPedidoReserva(id_pedido));
			break;
		case 5:
			System.out.println("Digite o nome usuário que você deseja: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			
			String usuCad = opt;

			System.out.println("Digite a senha que voce deseja: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String senCad = opt;

			System.out.println(proxy.CadastrarAdmin(usuCad, senCad));

			break;
		case 6:
			if (proxy.isLogado()) {
				System.out.println(proxy.Deslogar());
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;
		case 7:
			System.out.println("Bye");
			System.exit(0);
			break;

		default:
			System.out.println("Operação invalida, tente outra.");
			break;
		}
		return operacao;
	}

	public static void main(String[] args) {
		Admin admin = new Admin();
		int operacao = -1;
		do {
			admin.proxy.MenuAdmin();
			operacao = admin.selecionaOperacao();
		} while (operacao != 0);
	}
}
