package user;

import java.util.Scanner;

public class Salaried extends Empregado {
	
	public Scanner input = new Scanner(System.in);
	
	public Salaried(int id, String nome, String endereco, float salarioFixo)
	{
		super(id, nome, endereco, "mensal $", salarioFixo);
	}
	

}
