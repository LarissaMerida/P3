package unidade1;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Data 
{
	private Calendar inicio;
	private Calendar termino;
	private Scanner input;
	
	public Data()
	{
		
	}
	public void setDataHora()
	{
		input = new Scanner(System.in);
		
		Calendar inicio = Calendar.getInstance();
		
		int dia, mes, ano;
		System.out.println("Digite a data de inicio no formato dd mm yyyy:");
		dia = input.nextInt();
		mes = input.nextInt();
		ano = input.nextInt();
		
		System.out.println("Digite a hora de inicio no formato hh mm:");
		int hora = input.nextInt();
		int minuto = input.nextInt();
		
		if(mes == 0)
			mes = 12;
		
		if((dia > 0 && dia <= 31) && (mes > 0  && mes <= 12) && ano >= 0)
		{
			inicio.set(inicio.DATE, dia);
			inicio.set(inicio.MONTH, mes);
			if((hora > 0 && hora <= 24) && (minuto >= 0 && minuto < 60))
			{
				inicio.set(inicio.HOUR_OF_DAY,hora);
				inicio.set(inicio.MINUTE, minuto);
				this.inicio =  Calendar.getInstance();
				this.inicio = inicio;
				setDataHoraFim();
			}
			else
				System.out.println("Hora invalida.");
		}
		else
			System.out.println("Data invalida");
	}	
	
	public void setDataHoraFim()
	{
		input = new Scanner(System.in);
		int dia, mes, ano;
		Calendar termino = Calendar.getInstance();
		System.out.println("Digite a data de termino no formato dd mm yyyy:");
		dia = input.nextInt();
		mes = input.nextInt();
		ano = input.nextInt();
		
		System.out.println("Digite a hora de termino no formato hh mm:");
		int hora = input.nextInt();
		int minuto = input.nextInt();
		
		if(mes == 0)
			mes = 12;
		
		if((dia > 0 && dia <= 31) && (mes > 0  && mes <= 12) && ano >= 0)
		{
			termino.set(termino.DATE, dia);
			termino.set(termino.MONTH, mes);
			termino.set(termino.YEAR, ano);
			if((hora > 0 && hora <= 24) && (minuto >= 0 && minuto < 60))
			{
				termino.set(termino.HOUR_OF_DAY, hora);
				termino.set(termino.MINUTE, minuto);
				this.termino = Calendar.getInstance();
				this.termino = termino;
			}
			else
				System.out.println("Hora invalida.");
		}
		else
			System.out.println("Data invalida");
	}	
	public Calendar getInicio()
	{
		return this.inicio;
	}
	public Calendar getTermino()
	{
		return this.termino;
	}
}
