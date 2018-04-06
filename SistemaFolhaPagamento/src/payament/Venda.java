package payament;

import java.util.Date;

public class Venda
{
	public Date data;
	public float valor;
	public float comissao;

	public Venda() {
		this.data = new Date();
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	public float getValueCommission() {
		return valor*comissao;
	}
}