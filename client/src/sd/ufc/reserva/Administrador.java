package sd.ufc.reserva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Administrador {
	
	private Proxy proxy;

	public Administrador() {
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
				System.out.println("Digite seu Usuario: ");
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

				System.out.println(proxy.Logar(usuarioLogin, senhaLogin));
			} else {
				System.out.println("Operação não existe");
			}
			break;

		case 2:
			proxy.ListarTodosPedidosReservas();
			break;

		case 3:			
			if (proxy.isLogado()) {
				System.out.println("Digite o id do pedido: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String pedCR = opt;
				System.out.println(proxy.AceitarPedidoReserva(pedCR));
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;

		case 4:
			if (proxy.isLogado()) {
				System.out.println("Digite o id do pedido: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String pedCR = opt;
				System.out.println(proxy.RejeitarPedidoReserva(pedCR));
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;

		case 5:
			
			break;
		case 6:
			
			break;

		case 7:
			
			break;
		case 8:
			
			break;

		case 9:
			if (proxy.isLogado()) {
				System.out.println(proxy.Deslogar());
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;

		case 10:
			
			break;
		case 11:
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
		Administrador cli = new Administrador();
		int operacao = -1;
		do {
			cli.proxy.MenuAdmin();
			operacao = cli.selecionaOperacao();
		} while (operacao != 0);
	}
}
