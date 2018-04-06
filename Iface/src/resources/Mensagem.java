package resources;
import java.util.ArrayList;
import java.util.Scanner;

import user.Conta;


public class Mensagem
{
	private String mensagem;
	private Conta remetente;
	private Conta destinatario;
	private Scanner input = new Scanner(System.in);

	public Mensagem(Conta remetente, Conta destinatario, String mensagem) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.mensagem = mensagem;
	}

	public Conta getRemetente() {
		return remetente;
	}

	public void setRemetente(Conta remetente) {
		this.remetente = remetente;
	}

	public Conta getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Conta destinatario) {
		this.destinatario = destinatario;
	}

	public String getMensagem()
	{
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	public void printMensagem(ArrayList<Mensagem> listaMensagens)
	{
		if(listaMensagens.size() > 0)
		{
			for(Mensagem i: listaMensagens)
			{
				System.out.println("Remetente: " + i.getRemetente().getNome());
				System.out.println("Mensagem: " + i.getMensagem());
			}
		}else
			System.out.println("Sem mensagens");
	}

	

}
