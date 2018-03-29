package usuario;

import java.util.ArrayList;
import java.util.Scanner;


public class Professor extends Person
{
	private String discipline;

	public Professor(String name, String email)
	{
		super(name, email);
	}
	public Professor(String name, String discipline, String email)
	{
		super(name, email);
		this.discipline = discipline;
	}

	public void input()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Digite a disciplina:");
		this.discipline = input.nextLine();
		System.out.println("Digite o email:");
		this.email = input.nextLine();
	}

	public String getDiscipline()
	{
		return this.discipline;
	}

	public boolean procuraProfessor(ArrayList<Professor> teachers, String name)
	{
		boolean has = false;
		for(int i = 0; i < teachers.size(); i++)
		{
			if(teachers.get(i).getName().equals(name))
			{
				System.out.println("Nome: " + name);
				System.out.println("Disciplina: "+ teachers.get(i).getDiscipline());
				System.out.println("Email: "+ teachers.get(i).getEmail());
				has = true;
				break;
			}
		}
		return has;
	}
}
