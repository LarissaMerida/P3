package usuario;

import java.util.ArrayList;

public class Adm extends Person
{
	private int cpf;

	public Adm(String name, int cpf, String email)
	{
		super(name, email);
		this.cpf = cpf;
	}

	public void procuraAdm(ArrayList<Adm> adms , String name)
	{
		for(int i = 0; i < adms.size(); i+=1)
		{
			if(adms.get(i).getName().equals(name))
			{
				System.out.println("Nome:" + adms.get(i).name);
				System.out.println("CPF:"+ adms.get(i).cpf);
				System.out.println("Email:"+ adms.get(i).email);
			}
		}		
	}
}
