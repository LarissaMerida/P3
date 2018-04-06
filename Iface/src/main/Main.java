package main;


import java.util.ArrayList;
import java.util.Scanner;

import user.Conta;


public class Main{
	private static ArrayList<Conta> contas = new ArrayList<Conta>();
	private static ArrayList<Conta> contasRemovidas = new ArrayList<Conta>();
	private static Scanner input;

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
			input = new Scanner(System.in);
			int exist = 0;
			Conta  usuario = new Conta();
			exist = usuario.abrirConta(contas);
			

			if(exist == 0 || exist == 1)
			{
				if(exist == 0)
					contas.add(usuario);
				else
					usuario = contas.get(0);

				int escolha = 1;
				while(escolha != 0)
				{
					System.out.println(usuario.getNome());
					System.out.println("Digite 1 para editar atributos ");
					System.out.println("Digite 2 para adicionar amigos ");
					System.out.println("Digite 3 para aceitar amigos ");
					System.out.println("Digite 4 para enviar mensagem ");
					System.out.println("Digite 5 para ver a caixa de mensagem");
					System.out.println("Digite 6 para criar comunidade ");
					System.out.println("Digite 7 para se tornar membro ");
					System.out.println("Digite 8 para recuperar informacoes ");
					System.out.println("Digite 9 para desativar a conta ");
					System.out.println("Digite 10 para  sair da conta");
					escolha = input.nextInt();

					switch(escolha)
					{
						case 1:
							input.nextLine();
							usuario.editar();
							break;
						case 2:
							input.nextLine();
							usuario.setAmigos(contas);
							break;
						case 3:
							usuario.convite(contas);
							break;
						case 4:
							usuario.enviarMensagem(contas);
							break;
						case 5:
							usuario.printMensagem();
							break;
						case 6:
							usuario.criarComunidade();
							break;
						case 7:
							usuario.addComunidadeMembros(contas);
							break;
						case 8:
							usuario.backup(contasRemovidas);
							break;
						case 9:
							usuario.remove(contas);
							usuario = null;
							escolha = 0;
							break;
						case 10:
							System.out.println("Conta fechada com sucesso.");
							usuario = null;
							escolha = 0;
							break;
					}
				}

				System.out.println("Digite:");
				System.out.println("0 - encerrar ");
				System.out.println("1 - continuar ");
				fim = Integer.parseInt(input.nextLine());
			}		
		}
		System.out.println("Programa encerrado.");
	}

	public static void cadastrado()
	{
		Conta novo = new Conta("adm" , "adm", "123");
		novo.getPerfil().setPerfils("nc", "12/09/1990" , "Nada a declarar");
		contas.add(novo);

		Conta novo2 = new Conta("ana", "Rony", "934");
		
		novo2.getPerfil().setPerfils("aninha", "13/04/2000", "estudante");
		contas.add(novo2);
	}
}
