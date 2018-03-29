package unidade1;

import java.util.ArrayList;

public class Adm
{
	private String nome;
	private int cpf;
	private String email;

	public Adm(String nome, int cpf, String email)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public void procuraAdm(ArrayList<Adm> adms , String nome)
	{
		for(int i = 0; i < adms.size(); i+=1)
		{
			if(adms.get(i).nome.equals(nome))
			{
				System.out.println("Nome:" + adms.get(i).nome);
				System.out.println("CPF:"+ adms.get(i).cpf);
				System.out.println("Email:"+ adms.get(i).email);
			}
		}		
	}
}
