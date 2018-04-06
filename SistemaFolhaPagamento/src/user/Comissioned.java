package user;

import java.util.ArrayList;
import java.util.Scanner;

import payament.Venda;

public class Comissioned extends Empregado
{
     public  ArrayList<Venda> sales;
     public Scanner input = new Scanner(System.in);
     
     public Comissioned(int id, String nome, String endereco, float salarioFixo)
     {
    	 super(id, nome, endereco, "semanal 2 sexta", salarioFixo);
  
     }
     
    public ArrayList<Venda> getSales() 
    {
 		return sales;
    }

 	public void resetSales() 
 	{
 		this.sales = new ArrayList<>();
 	}

 	public void addSale(Venda sale)
 	{
		sales.add(sale);
	}
 	

}
