package main;

import java.util.ArrayList;
import java.util.Scanner;

import recurso.Atividade;
import recurso.Recurso;

import usuario.Adm;
import usuario.Aluno;
import usuario.Person;
import usuario.Pesquisador;
import usuario.Professor;

public class Main
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		ArrayList<Professor> professores = new ArrayList<Professor>();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		ArrayList<Pesquisador> pesquisadores   =  new ArrayList<Pesquisador>();
		ArrayList<Recurso> recursos = new ArrayList<Recurso>();
		ArrayList<Atividade> atividades = new ArrayList<Atividade>();

		cadastrado(professores, alunos, pesquisadores, recursos, atividades);
		menu(professores,alunos, pesquisadores, recursos, atividades);
	}

	private static void cadastrado(ArrayList<Professor> professores,  ArrayList<Aluno> alunos,
			ArrayList<Pesquisador> pesquisadores, ArrayList<Recurso> recursos, ArrayList<Atividade> atividades) {

		Person adm1 = new Adm("adm", 123,"adm@gmail.com");

		Person prof = new Professor("Carlos", "IA", "carlos@gmail.com");
		professores.add((Professor) prof);

		Person pesq1 = new Pesquisador("Ana", "IOT",  "ana@hotmail.com");
		pesquisadores.add((Pesquisador) pesq1);

		Person aluno1 = new Aluno("Mauro", "1611", "engenharia da computacao", "mauro@gmail.com");
		alunos.add((Aluno) aluno1);

		Recurso recurso1 = new Recurso(0);
		recurso1.setEmProcessoDeAlocacao();
		Person responsavel = new Pesquisador("Ana", "ana@gmail.com");
		recurso1.setResponsavel(responsavel, "pesquisador", false);

		Atividade ativ1 = new Atividade(0);
		ativ1.all("projetor", "apresentacao", "Inovacoes em IOT", "", "", "todos");
		recurso1.setAtividade(ativ1);
		atividades.add(ativ1);
		recursos.add(recurso1);

		Recurso recurso2 = new Recurso(1);
		recurso2.setEmProcessoDeAlocacao();
		Person responsavel2 = new Professor("Laura", "laura@gmail.com");
		recurso2.setResponsavel(responsavel2, "professor", false);

		Atividade ativ2 = new Atividade(1);
		ativ2.all("laboratorio", "aula", "Redes", "", "", "todos");
		recurso2.setAtividade(ativ2);
		atividades.add(ativ2);
		recursos.add(recurso2);

	}

	private static void menu(ArrayList<Professor> professores, ArrayList<Aluno> alunos,
			ArrayList<Pesquisador> pesquisadores, ArrayList<Recurso> recursos, ArrayList<Atividade> atividades) {

		Scanner input = new Scanner(System.in);
		int id = 2, continuar = 1, realizar;
		Consulta novaConsulta = new Consulta();
		String nome = null, email = null;
		Person novoUsuario;
		
		while(continuar == 1)
		{
			System.out.println("Digite 1[adicionar professor]");
			System.out.println("Digite 2[adicionar pesquisador]");
			System.out.println("Digite 3[adicionar aluno]");
			System.out.println("Digite 4[alocar recurso]");
			System.out.println("Digite 5[consultar por nome]");
			System.out.println("Digite 6[consultar por recurso]");
			System.out.println("Digite 7[imprimir relatorio]");
			realizar = input.nextInt();
			input.nextLine();
			if(realizar == 1 || realizar == 2 || realizar == 3)
			{
				System.out.println("Digite o nome:");
				nome = input.nextLine();
				System.out.println("Digite o email:");
				email = input.nextLine();
				
			}
			
			switch(realizar)
			{
				case 1:
					novoUsuario = new Professor(nome, email);
					((Professor) novoUsuario).input();
					professores.add((Professor) novoUsuario);
					System.out.println("Adicionado com sucesso.");
					break;
				case 2:
					novoUsuario = new Pesquisador(nome, email);
					((Pesquisador)novoUsuario).input();
					pesquisadores.add((Pesquisador) novoUsuario);
					System.out.println("Adicionado com sucesso.");
					break;
				case 3:
					novoUsuario = new Aluno(nome, email);
					((Aluno) novoUsuario).input();
					alunos.add((Aluno)novoUsuario);
					System.out.println("Adicionado com sucesso.");
					break;
				case 4:
					Recurso recurso1 = new Recurso(id);
					recurso1.input();
					recursos.add(recurso1);
					System.out.println("Adicionado com sucesso.");
					id++;
					break;
				case 5:
					novaConsulta.consultarNome(professores, pesquisadores, alunos, recursos, atividades);
					break;
				case 6:
					novaConsulta.consultarRecurso(professores, pesquisadores, alunos, recursos, atividades);
					break;
				case 7:
					novaConsulta.printRelatorio(professores, pesquisadores, alunos, recursos, atividades);
					break;
				default:
					System.out.println("Erro! opcao invalida.");
			}
			System.out.println("Deseja 0[encerrar] ou 1[continuar] ?");
			continuar = input.nextInt();
		}
		System.out.println("Fim de programa.");
	}
}
