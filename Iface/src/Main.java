
import java.util.ArrayList;
import java.util.Scanner;


public class Main
{
	private static ArrayList<Conta> amigos = new ArrayList<Conta>();
	private static ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
	private static ArrayList<Conta> contas = new ArrayList<Conta>();
	private static ArrayList<String> membros = new ArrayList<String>();

	public static void main(String[] args)
	{
		cadastrado();
		realizarLogin();
	}

	public static void realizarLogin()
	{
		int fim = 1;
		while(fim != 0)
		{
			Scanner input = new Scanner(System.in);
			int exist = 0;
			Conta  usuario = new Conta();
			exist = usuario.abrirConta(contas);
			String nome ;
			

			if(exist == 0 || exist == 1)
			{
				if(exist == 0)
					contas.add(usuario);
				else
					usuario = contas.get(0);

				int escolha = 1;
				while(escolha != 0)
				{
					System.out.println("Digite 1 para editar atributos ");
					System.out.println("Digite 2 para adicionar amigos ");
					System.out.println("Digite 3 para enviar mensagem ");
					System.out.println("Digite 4 para criar comunidade ");
					System.out.println("Digite 5 para se tornar membro ");
					System.out.println("Digite 6 para recuperar informações ");
					System.out.println("Digite 7 para desativar a conta ");
					System.out.println("Digite 8 para  sair da conta");
					escolha = input.nextInt();

					switch(escolha)
					{
						case 1:
							input.nextLine();
							usuario.getPerfil().editar(usuario);
							break;
						case 2:
							input.nextLine();
							usuario.getPerfil().setAmigos(contas, amigos, usuario);
							break;
						case 3:
							mensagens.add(usuario.getMensagem(amigos, usuario));
							break;
						case 4:
							usuario.getComunidade().criarComunidade(usuario, membros);
							break;
						case 5:
							usuario.getComunidade().addMembros(usuario, membros);
							break;
						case 6:
							usuario.backup(amigos , contas, membros);
							break;
						case 7:
							usuario.remove(contas, amigos, mensagens, membros);
							break;
						case 8:
							System.out.println("Conta fechada com sucesso.");
							escolha = 0;
							break;
					}
				}

				System.out.println("Digite:");
				System.out.println("0 - encerrar ");
				System.out.println("1 - continuar ");
				fim = input.nextInt();
			}		
		}
		System.out.println("Programa encerrado.");
	}

	public static void cadastrado()
	{
		Conta novo = new Conta();
		novo.setInfo("adm" , "adm", "123");
		novo.getPerfil().setPerfils("nc", "12/09/1990" , "Nada a declarar");
		contas.add(novo);

		Conta novo2 = new Conta();
		novo2.setInfo("ana", "Rony", "934");
		novo2.getPerfil().setPerfils("aninha", "13/04/2000", "estudante");
		contas.add(novo2);
	}
}
