package resources;
import user.Conta;


public class Amigo
{
	private Conta conta;
	private boolean conviteAceito;

	public Amigo(Conta conta) {
		this.conta = conta;
		this.conviteAceito = false;
	}

	public Amigo(Conta conta, boolean convite) {
		this.conta = conta;
		this.conviteAceito = convite;
	}

	public void enviarConvite()
	{
		this.conviteAceito = false;
	}

	public boolean getConvite()
	{
		return this.conviteAceito;
	}

	public void setConviteAceito(boolean conviteAceito) {
		this.conviteAceito = conviteAceito;
	}

	public void setConta(Conta conta)
	{
		this.conta = conta;
	}
	public Conta getConta()
	{
		return this.conta;
	}

}
