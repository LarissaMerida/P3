package unidade1;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal
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

		Adm adm1 = new Adm("adm", 123,"adm@gmail.com");

		Professor prof = new Professor("Carlos");
		prof.all("Carlos", "IA", "carlos@gmail.com");
		professores.add(prof);

		Pesquisador pesq1 = new Pesquisador("Ana");
		pesq1.all("Ana", "IOT",  "ana@hotmail.com");
		pesquisadores.add(pesq1);

		Aluno aluno1 = new Aluno("Mauro");
		aluno1.all("Mauro", "1611", "engenharia da computacao", "mauro@gmail.com");
		alunos.add(aluno1);

		Recurso recurso1 = new Recurso(0);
		recurso1.setEmProcessoDeAlocacao();
		recurso1.setResponsavel("Ana", "pesquisador", false);

		Atividade ativ1 = new Atividade(0);
		ativ1.all("projetor", "apresentacao", "Inovacoes em IOT", "", "", "todos");
		recurso1.setAtividade(ativ1);
		atividades.add(ativ1);
		recursos.add(recurso1);

		Recurso recurso2 = new Recurso(1);
		recurso2.setEmProcessoDeAlocacao();
		recurso2.setResponsavel("Laura", "professor", false);

		Atividade ativ2 = new Atividade(1);
		ativ1.all("laboratorio", "apresentacao", "Redes", "", "", "todos");
		recurso2.setAtividade(ativ2);
		atividades.add(ativ2);
		recursos.add(recurso2);
		for(int i =0; i < recursos.size(); i++)
		{
			System.out.println(recursos.get(i).getResponsavel());
			System.out.println(recursos.get(i).getIdentificacao());
			System.out.println(recursos.get(i).getAtividade().getTipo());
		}

	}

	private static void menu(ArrayList<Professor> professores, ArrayList<Aluno> alunos,
			ArrayList<Pesquisador> pesquisadores, ArrayList<Recurso> recursos, ArrayList<Atividade> atividades) {

		Scanner input = new Scanner(System.in);
		int id = 2, continuar = 1, realizar;
		Consulta print = new Consulta();
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
			switch(realizar)
			{
				case 1:
					System.out.println("Digite o nome:");
					String nome = input.nextLine();
					Professor prof = new Professor(nome);
					prof.input();
					professores.add(prof);
					System.out.println("Adicionado com sucesso.");
					break;
				case 2:
					System.out.println("Digite o nome:");
					nome = input.nextLine();
					Pesquisador pesq = new Pesquisador(nome);
					pesq.input();
					pesquisadores.add(pesq);
					System.out.println("Adicionado com sucesso.");
					break;
				case 3:
					System.out.println("Digite o nome:");
					nome = input.nextLine();
					Aluno aluno1 = new Aluno(nome);
					aluno1.input();
					alunos.add(aluno1);
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
					print.consultarNome(professores, pesquisadores, alunos, recursos, atividades);
					break;
				case 6:
					print.consultarRecurso(professores, pesquisadores, alunos, recursos, atividades);
					break;
				case 7:
					print.printRelatorio(professores, pesquisadores, alunos, recursos, atividades);
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
