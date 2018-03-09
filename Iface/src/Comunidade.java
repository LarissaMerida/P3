
import java.util.ArrayList;
import java.util.Scanner;


public class Comunidade
{
	private String nome;
	private String descrição;
	private String adm;

	public Comunidade()
	{
		this.adm = "nenhum";
	}
	public void criarComunidade(Conta usuario, ArrayList<String> membros)
	{
		this.adm = usuario.getNome();
		membros.add(usuario.getNome());
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome da comunidade:");
		this.nome = input.nextLine();
		System.out.println("Descreva a comunidade: ");
		this.descrição = input.nextLine();
		System.out.println("Comunidade criada.");
	}

	public void addMembros(Conta usuario, ArrayList<String> membros )
	{
		membros.add(usuario.getNome());
		System.out.println("Membro adicionado.");
	}
	public void printComunidade(Conta conta, ArrayList<String> membros)
	{

        if(conta.getComunidade().adm.equals("nenhum") == false)
        {
        	System.out.println("  Comunidade ");
        	System.out.println("Adm: " + conta.getComunidade().adm);
    		System.out.println("Descricao: " + conta.getComunidade().descrição);
    		System.out.println("   Membros");
    		for(String i: membros)
    		{
    			System.out.println("Nome: " + i);
    		}
    		if(membros.size() == 0)
    			System.out.println("Sem membros.");
        }
        else
        	System.out.println("Sem comunidade.");

	}

}
