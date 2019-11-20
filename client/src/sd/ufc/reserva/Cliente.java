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
			System.out.println("Digite Seu Usu�rio: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String usuarioLogin=opt;
			
			System.out.println("Digite Sua Senha: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String senhaLogin=opt;
			
			System.out.println(proxy.Logar(usuarioLogin, senhaLogin));
			break;

		case 3:
			System.out.println("Digite a Sala Desejada: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String idSala=opt;
			
			System.out.println("Digite a Data: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String data=opt;
			
			System.out.println("Digite o Horario: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String horario=opt;
			System.out.println(proxy.RealizarPedidoReserva(idSala, data, horario));
			break;

		case 4:
			System.out.println("Digite o id do pedido: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String pedC=opt;
			
			System.out.println(proxy.CancelarPedidoReserva(pedC));
			break;
		case 5:
			System.out.println("Digite o id do pedido: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String pedCR=opt;
			System.out.println(proxy.VerPedidoReserva(pedCR));
			break;

		case 6:
			System.out.println(proxy.ListarPedidosReservas());
			break;
		case 7:
			System.out.println(proxy.ListarReservas());
			break;

		case 8:
			
			break;

		case 9:
			break;

		case 10:
			System.out.println(proxy.Deslogar());
			break;

		case 11:
			System.out.println("Digite seu nome: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String nomeCad=opt;
			
			System.out.println("Digite seu usuario: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String usuCad=opt;
			
			System.out.println("Digite sua senha: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String senCad=opt;
			
			System.out.println("Digite seu CPF: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String cpfCad=opt;
			
			System.out.println("Digite sua matricula: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String matCad=opt;
			
			System.out.println("Digite seu curso: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String curCad=opt;
			
			System.out.println(proxy.CadastrarUsuario(nomeCad,usuCad,senCad,cpfCad,matCad, curCad) );
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

	public void printMenu() {
		System.out.println("\nDigite o n# da operação que deseja executar: ");
		System.out.println("1. Listar Salas");
		System.out.println("2. Logar");
		System.out.println("\nPEDIDOS");
		System.out.println("3. Realizar pedido de reserva");
		System.out.println("4. Cancelar pedido de reserva");
		System.out.println("5. Ver pedido de reserva");
		System.out.println("6. Listar pedidos de reservas");
		System.out.println("\nRESERVAS");
		System.out.println("7. Listar reservas");
		System.out.println("8. Cancelar reserva");
		System.out.println("9. Listar historico de reservas");
		System.out.println("\nAPLICAÇÃO");
		System.out.println("10. Deslogar");
		System.out.println("11. Cadastro no sistema");
		System.out.println("12. Finalizar programa");
	}

	public static void main(String[] args) {
		Cliente cli = new Cliente();
		int operacao = -1;
		do {
			cli.printMenu();
			operacao = cli.selecionaOperacao();
		} while (operacao != 0);
	}
}
