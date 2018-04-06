package user;


import java.util.ArrayList;
import java.util.Scanner;

import resources.Amigo;
import resources.Comunidade;
import resources.Mensagem;

import main.Perfil;


public class Conta
{
	private String login;
	private String senha;
	private String nome;
	private Perfil perfil;
	private ArrayList<Mensagem> listaMensagens;
	private ArrayList<Comunidade> listaComunidades;
	private ArrayList<Amigo> listaAmigos;
	private Scanner input;


	public Conta()
	{
		this.perfil = new Perfil();
		this.listaMensagens = new ArrayList<Mensagem>();
		this.listaComunidades = new ArrayList<Comunidade>();
		this.listaAmigos = new ArrayList<Amigo>();
	}
	
	public Conta(String nome, String login, String senha)
	{
		this.login = login;
		this.nome = nome;
		this.senha = senha;
	}
	
	public int abrirConta(ArrayList<Conta> contas)
	{
		input = new Scanner(System.in);
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
		    exist = searchPerson(login, senha, contas);
		    
			if(exist == 1)
				System.out.println("Logado com sucesso!");
			else
			{
				System.out.println("Usuario inexistente.");
				exist = 2;
			}
		}
		return exist;
	}
	
	public Perfil getPerfil()
	{
		return this.perfil;
	}
	
	public int searchPerson(String login, String senha, ArrayList<Conta> contas)
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
	
	public void setNome()
	{
		input = new Scanner(System.in);

		System.out.println("Digite o nome: ");
		this.nome = input.nextLine();
	}
	public String getNome()
	{
		return this.nome;
	}

	public void setSenha()
	{
		input = new Scanner(System.in);

		System.out.println("Digite a senha: ");
		this.senha = input.nextLine();
	}
	public String getSenha()
	{
		return this.senha;
	}

	public void setLogin()
	{
		input = new Scanner(System.in);

		System.out.println("Digite o login: ");
		this.login = input.nextLine();
	}
	
	public String getLogin()
	{
		return login;
	}
	
	public void editar()
	{
		input = new Scanner(System.in);

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
				this.perfil.setData();
				break;
			case 2:
				this.perfil.setApelido();
				break;
			case 3:
				this.perfil.setSobre();
				break;
			case 4:
				this.setNome();
				break;
			case 5:
				this.setLogin();
				break;
			case 6:
				this.setSenha();
				break;
			default:
				System.out.println("Opcao invalida.");
		}
		if(edite >= 1 && edite < 7)
			System.out.println("Concluido.");
	}
	
	public void setAmigos(ArrayList<Conta> contas)
	{
		input = new Scanner(System.in);

		System.out.println("Digite o nome: ");
		String nome = input.nextLine();

		Conta conta = new Conta();
		int exist = conta.searchName(nome, contas);

		if(exist != -1)
		{
			boolean resposta = false;

			this.listaAmigos.add(new Amigo(contas.get(exist)));
			contas.get(exist).listaAmigos.add(new Amigo(this));

			resposta = this.getListaAmigos().get(this.getListaAmigos().size()-1).getConvite();

			System.out.println("Aguardando resposta....");
			if(resposta == true)
			{
				System.out.println("Amigo aceito.");
			}
		}
		else
			System.out.println("Conta inexistente.");
	}
	
	public ArrayList<Amigo> getListaAmigos() 
	{
		return listaAmigos;
	}
	
	public int searchName(String nome, ArrayList<Conta> contas)
	{
		int exist = -1;
		for(int i = 0; i < contas.size(); i++)
		{
			if(contas.get(i).getNome().equals(nome))
			{
				exist = i;
				break;
			}
		}
		return exist;
	}
	
	public void enviarMensagem(ArrayList<Conta> contas) 
	{
		input = new Scanner(System.in);

		System.out.println("Digite o nome do usuario que deseja enviar a mensagem: ");
		String nome = input.nextLine();

		int exist = searchName(nome, contas);
		while(exist == -1) {
			System.out.println("Usuario nao encontrado, informe novamente o nome:");
			nome = input.nextLine();
			exist = searchName(nome, contas);
		}


		System.out.println("Digite a mensagem que deseja enviar:");
		String mensagem =  input.nextLine();

		Mensagem novaMensagem = new Mensagem(this, contas.get(exist), mensagem);
		contas.get(exist).getListaMensagens().add(novaMensagem);
		this.getListaMensagens().add(novaMensagem);
		System.out.println("Mensagem enviada com sucesso!");
	}
	
	public void convite(ArrayList<Conta> contas)
	{
		input = new Scanner(System.in);

		for(Amigo amigo : this.listaAmigos)
		{
			if(!amigo.getConvite())
			{
				System.out.println(amigo.getConta().getNome() + " quer ser seu amigo(a):");
				System.out.println("Deseja 1(aceitar) ou 2(recusar)");
				int op = input.nextInt();
				if(op == 1)
				{
					aceitarConvite(amigo);
					System.out.println("Aceito com sucesso");
				}
				else
					System.out.println("Solicitacao recusada com sucesso");
			}
		}

		System.out.println("Sem solicitacoes.");

	}
	
	private void aceitarConvite(Amigo amigo)
	{
		amigo.setConviteAceito(true);

		for(Amigo amigoAceito : amigo.getConta().getListaAmigos())
		{
			if(amigoAceito.getConta().getLogin().equals(this.getLogin()))
			{
				amigoAceito.setConviteAceito(true);
				break;
			}
		}
	}
	
	public ArrayList<Mensagem> getListaMensagens() 
	{
		return listaMensagens;
	}
	
	public void criarComunidade()
	{
		input = new Scanner(System.in);
		System.out.println("Digite o nome da comunidade:");
		String nome = input.nextLine();
		System.out.println("Descreva a comunidade: ");
		String descricao = input.nextLine();

		Comunidade comunidade = new Comunidade(nome,descricao, this);
		this.listaComunidades.add(comunidade);

		System.out.println("Comunidade criada.");
	}
	
	public void addComunidadeMembros(ArrayList<Conta> contas)
	{
		input = new Scanner(System.in);
		System.out.println("Informe o nome da comunidade: ");
		String nome = input.nextLine();

		for(Comunidade comunidade : this.listaComunidades) {
			if(comunidade.getNome().equals(nome)) {
				System.out.println("Informe o nome do membro que voce deseja adicionar:");
				String nomeMembro = input.next();
				int exist = this.searchName(nomeMembro, contas);

				if(exist != -1) {
					comunidade.getMembros().add(contas.get(exist));
					contas.get(exist).getListaComunidades().add(comunidade);
					System.out.println("Membro adicionado com sucesso!");
				}else
					System.out.println("Nao foi possivel encontrar esse usuario");

				return;
			}
		}

		System.out.println("Nao foi possivel encontrar esta comunidade");
	}
	
	public ArrayList<Comunidade> getListaComunidades() 
	{
		return listaComunidades;
	}
	
	public void backup(ArrayList<Conta> listaContasRemovidas)
	{
		input = new Scanner(System.in);

		for(Conta conta : listaContasRemovidas) {
			if(conta.getLogin().equals(this.getLogin())) {
				this.setListaAmigos(conta.getListaAmigos());

				for(Amigo amigo : this.getListaAmigos())
					amigo.getConta().getListaAmigos().add(new Amigo(this, true));

				this.setListaComunidades(conta.getListaComunidades());
				this.setListaMensagens(conta.getListaMensagens());
				listaContasRemovidas.remove(conta);
			}
		}
	}

	public void remove(ArrayList<Conta> contas)
	{
		for(Amigo amigo : this.listaAmigos) {
			for(Amigo i : amigo.getConta().getListaAmigos()) {
				if(i.getConta().getLogin().equals(this.getLogin())) {
					amigo.getConta().getListaAmigos().remove(i);
					break;
				}
			}
		}

		for(Comunidade comunidade : this.listaComunidades) {
			if(comunidade.getAdm().equals(this))
				for(Conta conta : comunidade.getMembros())
					conta.listaComunidades.remove(comunidade);
		}

		System.out.println("Removido com sucesso!");
	}
	
	public void setListaAmigos(ArrayList<Amigo> listaAmigos) 
	{
		this.listaAmigos = listaAmigos;
	}
	
	public void printMensagem()
	{
		Mensagem mensagem1 = null;
		mensagem1.printMensagem(this.listaMensagens);
	}

	public void setListaMensagens(ArrayList<Mensagem> listaMensagens)
	{
		this.listaMensagens = listaMensagens;
	}

	public void setListaComunidades(ArrayList<Comunidade> listaComunidades)
	{
		this.listaComunidades = listaComunidades;
	}
}
