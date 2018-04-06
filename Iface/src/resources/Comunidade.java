package resources;


import java.util.ArrayList;
import java.util.Scanner;

import user.Conta;

public class Comunidade
{
	private String nome;
	private String descricao;
	private Conta adm;
	private ArrayList<Conta> membros;

	public Comunidade(String nome, String descricao, Conta adm)
	{
		this.adm = adm;
		this.nome = nome;
		this.descricao = descricao;
		this.membros = new ArrayList<Conta>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getAdm() {
		return adm;
	}

	public void setAdm(Conta adm) {
		this.adm = adm;
	}

	public ArrayList<Conta> getMembros() {
		return membros;
	}

	public void setMembros(ArrayList<Conta> membros) {
		this.membros = membros;
	}

	public void printComunidade()
	{
    	System.out.println("Comunidade ");
    	System.out.println("Administrador: " + this.adm);
		System.out.println("Descricao: " + this.descricao);
		System.out.println("\tMembros");


		if(this.membros.size() == 0)
			System.out.println("Sem membros.");
		else
			for(Conta i: this.membros)
				System.out.println("Nome: " + i.getNome());
	}


}
