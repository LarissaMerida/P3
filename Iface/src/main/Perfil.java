package main;

import java.util.Scanner;

import user.Conta;


public class Perfil
{
	private String data_nascimento;
	private String apelido;
	private String sobre;
	private Scanner input;

	public Perfil()
	{
		this.data_nascimento = "00/00/0000";
		this.apelido = "sem apelido";
		this.sobre = "nada a declarar";
	}

	public void setPerfils(String apelido, String dataNasc, String sobre)
	{
		this.apelido = apelido;
		this.data_nascimento = dataNasc;
		this.sobre = sobre;
	}

	public void setData()
	{
		input = new Scanner(System.in);
		System.out.println("Digite a data no formato dd/mm/yyy");
		this.data_nascimento = input.nextLine();
	}

	public void setApelido()
	{
		input = new Scanner(System.in);
		System.out.println("Digite o apelido: ");
		this.apelido = input.nextLine();
	}

	public void setSobre()
	{
		input = new Scanner(System.in);

		System.out.println("Deseja escrever algo sobre voce? 1[sim] 0[nao]");
		int escolha = input.nextInt();

		if(escolha == 1)
			this.sobre = input.nextLine();
		else
			this.sobre = "nada a declarar";
	}

	public void printPerfil(Conta conta)
	{
		System.out.println("Apelido: " + conta.getPerfil().apelido);
		System.out.println("Data de nascimento: " + conta.getPerfil().data_nascimento);
		System.out.println("Sobre: " + conta.getPerfil().sobre);
	}

}