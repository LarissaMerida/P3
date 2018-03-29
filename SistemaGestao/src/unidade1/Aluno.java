package unidade1;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno
{
	private String nome;
	private String matricula;
	private String curso;
	private String email;

	public Aluno(String nome)
	{
		this.nome = nome;
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
	
	
	public void all(String nome, String matricula, String curso, String email)
	{
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.email = email;
	}

	public String getCurso()
	{
		return this.curso;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getNome()
	{
		return this.nome;
	}
	public boolean procuraAluno(ArrayList<Aluno> alunos, String nome)
	{
		boolean tem = false;
		for(Aluno i : alunos)
		{
			
			if(i.getNome().equals(nome))
			{
				System.out.println("Nome"+ i.getEmail());
				System.out.println("Nome: " + nome);
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
