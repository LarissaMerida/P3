

import java.util.ArrayList;
import java.util.Scanner;


public class Perfil
{
	private String data_nascimento;
	private String apelido;
	private String sobre;

	public Perfil()
	{
		this.data_nascimento = "00/00/0000";
		this.apelido = "sem apelido";
		this.sobre = "nada a declarar";
	}

	public void setPerfils(String apelido, String dataNasc, String sobre)
	{
		this.apelido = apelido;
		this.data_nascimento = dataNasc;
		this.sobre = sobre;
	}

	public void setData()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a data no formato dd/mm/yyy");
		this.data_nascimento = input.nextLine();
	}

	public void setApelido()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o apelido: ");
		this.apelido = input.nextLine();
	}

	public void setSobre()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Deseja escrever algo sobre voce? 1[sim] 0[nao]");
		int escolha = input.nextInt();

		if(escolha == 1)
			this.sobre = input.nextLine();
		else
			this.sobre = "nada a declarar";
	}

	public void editar(Conta novo)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Deseja editar: ");
		System.out.println("Digite 1[Data de nascimento]:");
		System.out.println("Digite 2[Apelido]: ");
		System.out.println("Digite 3[Sobre]");
		System.out.println("Digite 4[Nome] ");
		System.out.println("Digite 5[Login] ");
		System.out.println("Digite 6[Senha] ");
		int edite = input.nextInt();
		input.nextLine();

		switch(edite)
		{
			case 1:
				setData();
				break;
			case 2:
				setApelido();
				break;
			case 3:
				setSobre();
				break;
			case 4:
				novo.setNome();
				break;
			case 5:
				novo.setLogin();
				break;
			case 6:
				novo.setSenha();
				break;
			default:
				System.out.println("Opcao invalida.");
		}
		if(edite >= 1 && edite < 7)
			System.out.println("Concluido.");
	}

	public void setAmigos(ArrayList<Conta> contas, ArrayList<Conta> amigos, Conta conta1)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Digite o nome: ");
		String nome = input.nextLine();
		
		Conta conta = new Conta();
		int exist = conta.searchName(nome, contas);
		
		if(exist != -1)
		{
			boolean resposta = false;
			conta1.getAmigo().enviarConvite();
			
			resposta = conta1.getAmigo().getConvite();
			System.out.println("Aguardando resposta....");
			if(resposta == true)
			{
				amigos.add(contas.get(exist));
				System.out.println("Amigo aceito.");
			}
		}
		else
			System.out.println("Conta inexistente.");
	}

	public void printPerfil(Conta conta)
	{
		System.out.println("Apelido: " + conta.getPerfil().apelido);
		System.out.println("Data de nascimento: " + conta.getPerfil().data_nascimento);
		System.out.println("Sobre: " + conta.getPerfil().sobre);
	}

}