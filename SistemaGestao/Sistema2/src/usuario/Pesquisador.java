package usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Pesquisador extends Person
{
	private String areaPesquisa;


	public Pesquisador(String name, String email)
	{
		super(name, email);
	}
	public Pesquisador(String name, String areaPesquisa, String email) 
	{
		super(name, email);
		this.areaPesquisa = areaPesquisa;
	}
	
	public void input()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a area de pesquisa:");
		this.areaPesquisa = input.nextLine();
		System.out.println("Digite o email:");
		this.email = input.nextLine();		
	}
	public String getAreaPesquisa()
	{
		return this.areaPesquisa;
	}
	
	public boolean procuraPesquisador(ArrayList<Pesquisador> researchers, String name)
	{
		boolean has = false;
		for(Pesquisador i : researchers)
		{
			if(i.getName().equals(name))
			{
				System.out.println("Nome: "+ name);
				System.out.println("Area de Pesquisa: "+ i.getAreaPesquisa());
				System.out.println("Email: "+ i.getEmail());
				has = true;
				break;
			}
		}
		return has;
	}
}
