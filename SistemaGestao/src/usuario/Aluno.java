package usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Person
{
	private String matricula;
	private String curso;

	public Aluno(String nome, String email)
	{
		super(nome, email);
	}
	public Aluno(String nome, String matricula, String curso, String email)
	{
		super(nome, email);
		
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public void input()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a matricula:");
		this.matricula = input.nextLine();
		System.out.println("Digite o curso:");
		this.curso = input.nextLine();
		System.out.println("Digite o email:");
		this.email = input.nextLine();
	}
	
	public String  getMatricula()
	{
		return this.matricula;
	}
	
	public String getCurso()
	{
		return this.curso;
	}
	
	public boolean procuraAluno(ArrayList<Aluno> alunos, String name)
	{
		boolean tem = false;
		for(Aluno i : alunos)
		{
			if(i.getName().equals(name))
			{
				System.out.println("Nome: " + name);
				System.out.println("Matricula: " + i.getMatricula());
				System.out.println("Curso: " + i.getCurso());
				System.out.println("Email: " + i.getEmail());
				tem = true;
				break;
			}
		}		
		return tem;
	}	
}
