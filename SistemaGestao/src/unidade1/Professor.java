package unidade1;

import java.util.ArrayList;
import java.util.Scanner;

public class Professor
{
	private String nome;
	private String disciplina;
	private String email;

	public Professor(String nome)
	{
		this.nome = nome;
	}

	public void input()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Digite a disciplina:");
		this.disciplina = input.nextLine();
		System.out.println("Digite o email:");
		this.email = input.nextLine();
	}

	public String getDisciplina()
	{
		return this.disciplina;
	}
	public String getEmail()
	{
		return this.email;
	}

	public void all(String nome, String disciplina, String email)
	{
		this.nome = nome;
		this.disciplina = disciplina;
		this.email = email;
	}
	public String getNome()
	{
		return this.nome;
	}

	public boolean procuraProfessor(ArrayList<Professor> professores, String nome)
	{
		boolean tem = false;
		for(int i = 0; i < professores.size(); i++)
		{
			if(professores.get(i).getNome().equals(nome))
			{
				System.out.println("Nome: " + nome);
				System.out.println("Disciplina: "+ professores.get(i).getDisciplina());
				System.out.println("Email: "+ professores.get(i).getEmail());
				tem = true;
				break;
			}
		}
		return tem;
	}
}
