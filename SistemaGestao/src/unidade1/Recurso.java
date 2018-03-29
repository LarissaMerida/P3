package unidade1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Recurso
{
	private int identificacao;
	private String responsavel;
	private String alocacao;
	public Atividade ativid;
	private Data data;

	public Recurso(int identificacao)
	{
		this.identificacao = identificacao;
	}
	public void input()
	{
		Scanner input = new Scanner(System.in);

		setEmProcessoDeAlocacao();
		this.identificacao = identificacao;
		System.out.println(identificacao);
		this.ativid = new Atividade(identificacao);

		System.out.println("Digite sala de aula, projetor, auditorio ou laboratorio:");
		String recurso = input.nextLine();
		this.ativid.setRecurso(recurso);

		this.data = new Data();
		this.data.setDataHora();

		System.out.println("Digite o nome do responsavel:");
		String nome = input.nextLine();
		this.responsavel = nome;

		setAlocado();

		long intervalo = data.getTermino().getTimeInMillis() - data.getInicio().getTimeInMillis();

		if(intervalo <= 0)
		{
			System.out.println("Confirma alocacao? Digite: 1[sim] 0[nao]");
			int confirmar = input.nextInt();
			if(confirmar == 1)
				setEmAndamentoAlocacao();
			else
				setEmAndamentoAlocacao();
		}

		System.out.println("Digite 1[professor]");
		System.out.println("Digite 2[pesquisador]");
		System.out.println("Digite 3[adm]");
		int escolha = input.nextInt();

		System.out.println("Escolha a atividade:");
		if(escolha == 1)
		{
			System.out.println("Digite 1[aula tradiciconal]");
			System.out.println("Digite 2[apresentacao]");
			System.out.println("Digite 3[laboratorio]");
			int atividadeInt = input.nextInt();
			switch(atividadeInt)
			{
				case 1:
					this.ativid.setTipo("aula tradicional");
					sobreAtividade();
					break;
				case 2:
					this.ativid.setTipo("apresentacao");
					sobreAtividade();
					break;
				case 3:
					this.ativid.setTipo("laboratorio");
					sobreAtividade();
					break;
				default:
					System.out.println("Opcao invalida.");
			}
		}
		else if(escolha == 2 || escolha == 3)
		{
			sobreAtividade();
			this.ativid.setTipo("apresentacao");
		}
		else
			System.out.println("Opcao invalida.");
	}

	private void sobreAtividade()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Deseja incluir informacao sobre a atividade? 1[sim] 0[nao]");
		int incluir = input.nextInt();
		if(incluir == 1)
		{
			System.out.println("Digite o titulo da atividade:");
			String titulo = input.nextLine();
			this.ativid.setTitulo(titulo);

			System.out.println("Digite uma breve descricao:");
			String descricao = input.nextLine();
			this.ativid.setDescricao(descricao);

			System.out.println("Digite quem sao os participantes:");
			String participantes = input.nextLine();
			this.ativid.setParticipantes(participantes);

			System.out.println("Digite o material de apoio:");
			String material = input.nextLine();
			this.ativid.setMaterial(material);

			System.out.println("Digite a senha de adm para concluir a alocacao:");
			int senha = input.nextInt();
			if(senha == 123)
			{
				setConcluido();
				System.out.println("Alocacao concluida com sucesso.");
			}
			else
				System.out.println("Senha invalida.");
		}
	}

	public boolean setResponsavel(String responsavel, String funcao, boolean recurso)
	{
		if(this.alocacao == "Em processo de alocacao" &&
				((funcao == "professor" && recurso == false) || (funcao == "pesquisador" && recurso == false) || (funcao == "adm" && recurso == false)))
		{
			this.responsavel = responsavel;
			recurso = true;
		}
		return recurso;
	}
	public String getResponsavel()
	{
		return this.responsavel;
	}

	public void setIdentificacao(int identificacao)
	{
		this.identificacao = identificacao;
	}
	public int getIdentificacao()
	{
		return this.identificacao;
	}

	public void setEmProcessoDeAlocacao()
	{
		this.alocacao = "Em processo de alocacao";
	}
	public void setEmAndamentoAlocacao()
	{
		this.alocacao = "Em andamento";
	}
	public void setAlocado()
	{
		this.alocacao =  "Alocado";
	}
	public void setConcluido( )
	{
		int adm = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("Digite a senha de adm:");
		adm = input.nextInt();

		if(adm == 123)
		{
			this.alocacao  = "Concluido";
			System.out.println("Concluido");
		}
		else
			System.out.println("Acesso invalido!! Nao tem permissao concluir.");
	}
	public String getAlocacao()
	{
		return this.alocacao;
	}
	public void setAtividade(Atividade ativ)
	{
		this.ativid = ativ;
	}
	public Atividade getAtividade()
	{
		return this.ativid;
	}

	public void historicoRecursos(String nome, ArrayList<Recurso> recursos, ArrayList<Atividade> atividades)
	{
		System.out.println("Historico de recursos:");

		int tem = 0;
		for(int j =0 ; j < recursos.size(); j++)
		{
			if(recursos.get(j).getResponsavel().equals(nome))
			{
				System.out.println("Id: " + recursos.get(j).getIdentificacao());
				System.out.println("Alocacao: "+ recursos.get(j).getAlocacao());
				System.out.println("Atividade:" + atividades.get(j).getTipo());
				System.out.println(" ");
				tem = 1;
				break;
			}
		 }
		if(tem == 0)
				System.out.println("Sem historico");
	}
}
