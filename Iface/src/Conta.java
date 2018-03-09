

import java.util.ArrayList;
import java.util.Scanner;


public class Conta
{
	private String login;
	private String senha;
	private String nome;
	private Perfil perfil;
	private Mensagem mensagem;
	private Comunidade comunidade;
	private Amigo amigo;


	public Conta()
	{
		this.perfil = new Perfil();
		this.mensagem = new Mensagem();
		this.comunidade = new Comunidade();
		this.amigo = new Amigo();
	}

	public int abrirConta(ArrayList<Conta> contas)
	{
		Scanner input = new Scanner(System.in);
		int exist = 0;
		System.out.println("Digite : ");
		System.out.println("1 - cadastrar ");
		System.out.println("2 - fazer login ");
		int op = input.nextInt();
		input.nextLine();

		if(op == 1)
		{
			System.out.println("Digite o nome: ");
			this.nome = input.nextLine();
			System.out.println("Digite o login: ");
			this.login = input.nextLine();
			System.out.println("Digite a senha: ");
			this.senha = input.nextLine();
			
			System.out.println("Usuario cadastrado");
			exist = 0;
			this.perfil = new Perfil();
		}
		else if(op == 2)
		{
			System.out.println("Digite o login: ");
			String login = input.nextLine();
			System.out.println("Digite a senha: ");
			String senha = input.nextLine();
		    exist = search(login, senha, contas);
			if(exist == 1)
			{
				System.out.println("Logado com sucesso!");
			}
			else
			{
				System.out.println("Usuario inexistente.");
				exist = 2;
			}
		}
		return exist;
	}

	public int search(String login, String senha, ArrayList<Conta> contas)
	{
		int exist = 0;

		for(Conta i: contas)
		{
			if(i.getLogin().equals(login) && i.getSenha().equals(senha))
			{
				exist =1;
				break;
			}
		}
		return exist;
	}

	public void setInfo(String nome, String login, String senha)
	{
		this.login = login;
		this.nome = nome;
		this.senha = senha;
	}

	public Perfil getPerfil()
	{
		return this.perfil;
	}

	public void setNome()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Digite o nome: ");
		this.nome = input.nextLine();
	}
	public String getNome()
	{
		return this.nome;
	}

	public void setSenha()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Digite a senha: ");
		this.senha = input.nextLine();
	}
	public String getSenha()
	{
		return this.senha;
	}

	public void setLogin()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Digite o login: ");
		this.login = input.nextLine();
	}

	public Amigo getAmigo()
	{
		return this.amigo;
	}
	public Mensagem getMensagem(ArrayList<Conta> amigos, Conta conta)
	{
		this.mensagem.setRemetente(conta.getNome());
		this.mensagem.setMensagem(amigos);
		return this.mensagem;
	}

	public String getLogin()
	{
		return login;
	}
	public Comunidade getComunidade()
	{
		return this.comunidade;
	}
	public int searchName(String nome, ArrayList<Conta> contas)
	{
		int exist = -1;
		for(int i = 0; i < contas.size(); i++)
		{
			if(contas.get(i).getNome().equals(nome))
			{
				//System.out.println("Nome: " + nome);
				exist = i;
				break;
			}
		}
		return exist;
	}
	
	public void backup(ArrayList<Conta> amigos, ArrayList<Conta> contas, ArrayList<String> membros)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		String nome = input.nextLine();
		int exist = searchName(nome, contas);

		if(exist != -1)
		{
			System.out.println("Nome: " + nome);
			perfil.printPerfil(contas.get(exist));
			comunidade.printComunidade(contas.get(exist), membros);
			getAmigo().printAmigos(amigos, contas.get(exist));
		}
		else
			System.out.println("Usuario inexistente.");
	}
	public void remove(ArrayList<Conta> contas, ArrayList<Conta> amigos, ArrayList<Mensagem> mensagens, ArrayList<String> membros)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Digite o nome:");
		String nome = input.nextLine();
		int exist = 1;
		for(int i=0; i < contas.size(); i++)
		{
			if(contas.get(i).getNome().equals(nome))
			{
				contas.remove(i);
				exist = 0;
				for(int j =0; i < membros.size(); i++)
				{
					if(membros.get(i).equals(nome))
						membros.remove(i);
				}
				for(int j=0; i < mensagens.size(); i++)
				{
					if(mensagens.get(i).getDestinatario().equals(nome) || mensagens.get(i).getRemetente().equals(nome))
						mensagens.remove(i);
				}
				for(int j=0; i < amigos.size(); i++)
				{
					if(amigos.get(i).nome.equals(nome))
						amigos.remove(i);
				}
				System.out.println("Removido com sucesso!");
			}
		}
		if(exist == 1)
			System.out.println("Usuario inexistente.");

	}
}
