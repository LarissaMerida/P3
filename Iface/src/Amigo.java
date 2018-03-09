

import java.util.ArrayList;


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
