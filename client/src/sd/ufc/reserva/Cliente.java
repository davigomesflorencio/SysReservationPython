package sd.ufc.reserva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cliente {

	private Proxy proxy;

	public Cliente() {
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
			proxy.ListarSalas();
			break;

		case 2:
			if (proxy.isLogado() == false) {
<<<<<<< HEAD
				System.out.println("Digite seu nome de usuário: ");
=======
				System.out.println("Digite sua matricula: ");
>>>>>>> 56b917ff15441702bec6d1a2d3887c43553edcae
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

		case 3:
			if (proxy.isLogado()) {
				System.out.println("Digite o id da sala desejada: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String idSala = opt;

				System.out.println("Digite a data: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String data = opt;

				System.out.println("Digite o horario: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String horario = opt;
				System.out.println(proxy.RealizarPedidoReserva(idSala, data, horario));
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
				String pedC = opt;

				System.out.println(proxy.CancelarPedidoReserva(pedC));
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;
		case 5:
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
				System.out.println(proxy.VerPedidoReserva(pedCR));
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;

		case 6:
			if (proxy.isLogado()) {
				proxy.ListarPedidosReservas();
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;
		case 7:
			if (proxy.isLogado()) {
				proxy.ListarReservas();
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;

		case 8:

			break;

		case 9:
			break;

		case 10:
			if (proxy.isLogado()) {
				System.out.println(proxy.Deslogar());
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;

		case 11:
			if (proxy.isLogado() == false) {
				System.out.println("Digite seu nome: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String nomeCad = opt;

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

				System.out.println("Digite seu CPF: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String cpfCad = opt;

				System.out.println("Digite sua matricula: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String matCad = opt;

				System.out.println("Digite seu curso: ");
				do {
					try {
						opt = stdin.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				String curCad = opt;

				System.out.println(proxy.CadastrarUsuario(nomeCad, usuCad, senCad, cpfCad, matCad, curCad));
			} else {
				System.out.println("Operação não existe: Por favor você deve-se logar");
			}
			break;
		case 12:
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
		Cliente cli = new Cliente();
		int operacao = -1;
		do {
			cli.proxy.Menu();
			operacao = cli.selecionaOperacao();
		} while (operacao != 0);
	}
}
