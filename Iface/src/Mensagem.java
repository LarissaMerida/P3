
import java.util.ArrayList;
import java.util.Scanner;


public class Mensagem
{
	private String mensagem;
	private String remetente;
	private String destinatario;


	public void setRemetente(String nome)
	{
		this.remetente = nome;
	}
	public void setMensagem(ArrayList<Conta> amigos)
	{
	   Scanner input = new Scanner(System.in);

	   System.out.println("Digite o nome do amigo:");
       this.destinatario = input.nextLine();

		System.out.println("Digite a mensagem :");
		this.mensagem = input.nextLine();
		System.out.println("Mensagem enviada.");
	}

	public String getMensagem()
	{
		return this.mensagem;
	}
	public String getRemetente()
	{
		return this.remetente;
	}
	public String getDestinatario()
	{
		return this.destinatario;
	}
	public void removerMensagem(ArrayList<Mensagem> mensagens, ArrayList<Conta> amigos)
	{
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < mensagens.size(); i++)
		{
			System.out.println(mensagens.get(i).mensagem);
			System.out.println("Deseja 1(remover) ou 2( responder)");
			 int op = input.nextInt();
			 if(op == 1)
			 {
				 mensagens.remove(i);
				 System.out.println("Removido com sucesso.");
			 }
			 else
				 setMensagem(amigos);
		}
	}

	public void printMensagem(ArrayList<Mensagem> mensagens)
	{
		for(Mensagem i: mensagens)
		{
			System.out.println(" ");
			System.out.println("Mensagem: " +i.getMensagem());
			System.out.println("Remetente: " + i.getRemetente());
			System.out.println("Destinatario: " + i.getDestinatario());
		}
		if(mensagens.size() == 0)
		{
			System.out.println("Sem mensagens.");
		}
	}
}
