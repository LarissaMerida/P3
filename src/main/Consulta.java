package main;

import java.util.ArrayList;
import java.util.Scanner;

import recurso.Atividade;
import recurso.Recurso;

import usuario.Aluno;
import usuario.Person;
import usuario.Pesquisador;
import usuario.Professor;

public class Consulta
{

	public void consultarNome(ArrayList<Professor> professores, ArrayList<Pesquisador> pesquisadores,
			ArrayList<Aluno> alunos, ArrayList<Recurso> recursos, ArrayList<Atividade> atividades)
	{
		Scanner input = new Scanner(System.in);
		String email, nome;
		System.out.println("Digite o nome: ");
		nome = input.nextLine();
		email = procuraEmail(nome, professores,pesquisadores,alunos);
		
		System.out.println("Digite 1[professor]");
		System.out.println("Digite 2[pesquisador]");
		System.out.println("Digite 3[aluno]");
		int profissao = input.nextInt();

		boolean tem = false;
		switch(profissao)
		{
			case 1:
				Person prof = new Professor(nome, email);
				tem = ((Professor) prof).procuraProfessor(professores, nome);
				break;
			case 2:
				Person pesq = new Pesquisador(nome, email);
				if(tem == false)
					tem = ((Pesquisador)pesq).procuraPesquisador(pesquisadores, nome);
				break;
			case 3:
				Person aluno1 = new Aluno(nome, email);
				if(tem == false)
					tem = ((Aluno)aluno1).procuraAluno(alunos, nome);
				break;
			default:
				System.out.println("Erro! opcao invalida.");
		}
		if(tem == false)
			System.out.println("Nome inexistente.");
		else
		{
			Recurso recurso1 = new Recurso(33);
			recurso1.historicoRecursos(nome, recursos, atividades);
		}
	}

	public void consultarRecurso(ArrayList<Professor> professores, ArrayList<Pesquisador> pesquisadores,ArrayList<Aluno> alunos, ArrayList<Recurso> recursos, ArrayList<Atividade> atividades)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Digite 1[sala de aula]:");
		System.out.println("Digite 2[projetor]:");
		System.out.println("Digite 3[laboratorio]:");
		System.out.println("Digite 4[auditorio]:");
		int recurso = input.nextInt();
		String recursoString, email;

		switch(recurso)
		{
			case 1:
				recursoString = "sala de aula";
				break;
			case 2:
				recursoString = "projetor";
				break;
			case 3:
				recursoString = "laboratorio";
				break;
			case 4:
				recursoString = "auditorio";
				break;
			default:
				recursoString = "null";
				System.out.println("Opcao invalida.");
		}

		System.out.println("Digite a identificacao do recurso:");
		int ident = input.nextInt();
		boolean tem = false;

		for(int i =0; i < recursos.size(); i++)
		{
			System.out.println(i);
			if(recursos.get(i).getIdentificacao() ==  ident && recursos.get(i).getAtividade().getRecurso().equals(recursoString))
			{
				email = procuraEmail(recursos.get(i).getResponsavel().getName(), professores, pesquisadores, alunos);
				
				Person aluno1 = new Aluno(recursos.get(i).getResponsavel().getName(), email);
				tem = ((Aluno)aluno1).procuraAluno(alunos, recursos.get(i).getResponsavel().getName());

				if(tem == false)
				{
					Person pesq = new Pesquisador(recursos.get(i).getResponsavel().getName(), email);
					tem = ((Pesquisador)pesq).procuraPesquisador(pesquisadores, recursos.get(i).getResponsavel().getName());
				}
				if(tem == false)
				{
					Person prof = new Professor(recursos.get(i).getResponsavel().getName(), email);
					tem = ((Professor)prof).procuraProfessor(professores, recursos.get(i).getResponsavel().getName());
				}

				for(int j = 0; j < atividades.size(); j++)
				{
					if(atividades.get(j).getId() == ident && atividades.get(j).getRecurso().equals(recursoString))
					{
						tem = true;
						System.out.println("Recurso: " + atividades.get(j).getRecurso());
						System.out.println("Alocacao: "+recursos.get(i).getAlocacao());
						System.out.println("Atividade: "+ atividades.get(j).getTipo());
						System.out.println("Participantes: " + atividades.get(j).getParticipantes());
					}
				}
			}
		}
		if(tem == false)
			System.out.println("Sem historico");
	}
	
	private String procuraEmail(String nome, ArrayList<Professor> professores,
			ArrayList<Pesquisador> pesquisadores, ArrayList<Aluno> alunos) 
	{
		ArrayList <Person> people = new ArrayList<Person>();
		people.addAll(professores);
		people.addAll(pesquisadores);
		people.addAll(alunos);
		
		for(Person i: people)
		{
			if(i.getName().equals(nome))
			{
				return i.getEmail();
			}
		}
		return "email nao cadastrado";
	}

	public void contaAlocacao(ArrayList<Recurso> recursos, String estado)
	{
		int cont = 0;
		for(int i = 0; i < recursos.size(); i+=1)
		{
			if(recursos.get(i).getAlocacao().equals(estado))
				cont+=1;
		}
		System.out.printf("  %s: %d\n" ,estado, cont);
	}
	public void totalAlocacao(ArrayList<Recurso> recursos)
	{
		int cont = 0;
		for(int i = 0; i < recursos.size(); i+=1)
			cont+=1;
		System.out.println("  Total de alocacoes: "+ cont);
	}

	public void printRelatorio(ArrayList<Professor> professores, ArrayList<Pesquisador> pesquisadores,
			ArrayList<Aluno> alunos, ArrayList<Recurso> recursos, ArrayList<Atividade> atividades) {

		System.out.println("Relatorio:");
		System.out.println("  Quantidade de usuarios:" + (1 + professores.size() + alunos.size() + pesquisadores.size()));
		contaAlocacao(recursos, "Em processo de alocacao");
		contaAlocacao(recursos, "Alocado");
		contaAlocacao(recursos, "Em andamento");
		contaAlocacao(recursos, "Concluido");
		totalAlocacao(recursos);

		System.out.println(" ");
		Atividade ativid = new Atividade(-1);
		ativid.contaTipo(atividades, "laboratorio");
		ativid.contaTipo(atividades, "sala de aula");
		ativid.contaTipo(atividades, "projetor");
		ativid.contaTipo(atividades, "auditorio");
		System.out.println(" ");
	}

}
