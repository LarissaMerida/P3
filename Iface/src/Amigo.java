

import java.util.ArrayList;
import java.util.Scanner;


public class Amigo
{
	private String nome;
	private boolean conviteAceito;


	public void enviarConvite()
	{
		this.conviteAceito = false;
	}
	public boolean getConvite()
	{
		return this.conviteAceito;
	}
	public void convite(ArrayList<Conta> solicitacoes, ArrayList<Conta> amigos)
	{
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < solicitacoes.size(); i++)
		{
			System.out.println(solicitacoes.get(i).getNome() + " quer ser seu amigo(a):");
			System.out.println("Deseja 1(aceitar) ou 2(excluir)");
			int op = input.nextInt();
			if(op == 1)
			{
				amigos.add(solicitacoes.get(i));
				solicitacoes.remove(i);
				System.out.println("Aceito com sucesso");
			}
			else
			{
				solicitacoes.remove(i);
				System.out.println("Removido com sucesso");
			}
		}
		if(solicitacoes.size() == 0)
			System.out.println("Sem solicitacoes.");
		
	}
	
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getNome()
	{
		return this.nome;
	}
	public void printAmigos(ArrayList<Conta> amigos, Conta conta)
	{
		System.out.println("  Amigos");
		for(int i =0; i < amigos.size(); i++)
		{
			System.out.println(amigos.get(i));
		}
		if(amigos.size() == 0)
		{
			System.out.println("Sem amigos.");
		}
	}

}
