package unidade1;

import java.util.ArrayList;
import java.util.Scanner;

public class Pesquisador
{
	private String nome;
	private String areaPesquisa;
	private String email;

	public Pesquisador(String nome)
	{
		this.nome = nome;
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
	public String getEmail()
	{
		return this.email;
	}
	public void all(String nome, String areaPesquisa, String email) 
	{
		this.nome = nome;
		this.areaPesquisa = areaPesquisa;
		this.email = email;
	}
	public String getNome()
	{
		return this.nome;
	}
	
	public boolean procuraPesquisador(ArrayList<Pesquisador> pesquisadores, String nome)
	{
		boolean tem = false;
		for(Pesquisador i : pesquisadores)
		{
			if(i.getNome().equals(nome))
			{
				System.out.println("Nome: "+ nome);
				System.out.println("Area de Pesquisa: "+ i.getAreaPesquisa());
				System.out.println("Email: "+ i.getEmail());
				tem = true;
				break;
			}
		}
		return tem;
	}
}
