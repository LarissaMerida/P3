package user;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import payament.PaymentSchedule;
import payament.Point;
import payament.Venda;

import enums.MethodPay;


public class Empregado
{
	public Scanner input = new Scanner(System.in);
	public int id;
	public String nome;
	public String endereco;

	public MethodPay metodoPagam;
	public Date ultimoPagamento;
	public float salarioFixo;
	
	public boolean sindicalizado;
	public int codigoSindicato;
	public float taxaSind;
	public float taxaServicos;
	
	public boolean deleted;
	public PaymentSchedule paymentSchedule;

	public Empregado() {
		super();
		this.setTaxaServicos(0);
		this.ultimoPagamento = new Date();
		this.deleted = false;
		this.sindicalizado = false;
		this.paymentSchedule = new PaymentSchedule();
	}
	public Empregado(int id, String nome, String endereco, String paymentSchedule, float salarioFixo)
	{
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		setPaymentSchedule(paymentSchedule);
		setSalarioFixo(salarioFixo);
	}
	
	
	public void editFinicialInfo() {

		System.out.println("Digite 1(cheque) 2(conta bancaria): ");
		int metodo = Integer.valueOf( input.nextLine() );

		if(metodo == 1)
		{
			System.out.println("Receber por 1(correios) ou 2(em maos): ");
			int receber = Integer.valueOf( input.nextLine() );
			if(receber == 1)
				setMetodo(MethodPay.MAIL);
			else if(receber == 2)
				setMetodo(MethodPay.DIRECT);
			else
				System.out.println("Metodo invalido!");
		}
		else if(metodo == 2)
			setMetodo(MethodPay.ACCOUNT);
		else
		{
			System.out.println("Metodo invalido!");
		}
	}

	public void editSindicateInfo() {

		System.out.println("Pertence ao sindicato?");
		System.out.println("Digite 1(sim) ou 0(nao)");
		int sindicatoInt = Integer.valueOf( input.nextLine() );

		if(sindicatoInt == 1) {

			setSindicalizado( true );

			System.out.println("Digite o id do empregado no sindicato:");
			setIdSindicado( Integer.valueOf( input.nextLine() ) );

			System.out.println("Digite a taxa mensal do sindicato: ");
			 setTaxaSind( Float.valueOf( input.nextLine() ) );
		}
	}
	
	public void editPersonalInfo() {

		System.out.println("Digite o nome do empregado:");
		setNome( input.nextLine() );

		System.out.println("Digite o endereco:");
		setEndereco( input.nextLine() );
	}
	
	public PaymentSchedule getPaymentSchedule() {
		return paymentSchedule;
	}

	public void setPaymentSchedule(String pay) {
		this.paymentSchedule.setPaymentSchedule(pay);
	}

	public boolean isDayToPay(Date today) {
		return paymentSchedule.isDayToPay(today, ultimoPagamento);
	}

	public void addServiceRate(Float rate) {
		this.setTaxaServicos(this.getTaxaServicos() + rate);
	}
	public void setSalarioFixo(float salary)
 	{
 		this.salarioFixo = salary;
 	}
	public float getSalarioFixo() 
	 {
		return this.salarioFixo;
	 }
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getNome()
	{
		return this.nome;
	}

	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
	public String getEndereco()
	{
		return this.endereco;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return this.id;
	}

	public void setIdSindicado(int id)
	{
		this.codigoSindicato = id;
	}
	public int getIdSindicato()
	{
		return this.codigoSindicato;
	}

	public void setTaxaSind(float rate)
	{
		this.taxaSind = rate;
	}
	public float getTaxa()
	{
		return this.taxaSind;
	}

	public void setSindicalizado(boolean sind)
	{
		this.sindicalizado = sind;
	}
	public boolean getSindicalizado()
	{
		return this.sindicalizado;
	}

	public void setMetodo(MethodPay method)
	{
		this.metodoPagam = method;
	}
	
	public MethodPay getMetodo()
	{
		return this.metodoPagam;
	}

	public void setUltimoPagamento(Date ultimo)
	{
		this.ultimoPagamento = ultimo;
	}
	public Date getUltimoPagamento()
	{
		return this.ultimoPagamento;
	}

	public float getTaxaServicos() {
		return taxaServicos;
	}

	public void setTaxaServicos(float taxaServicos) {
		this.taxaServicos = taxaServicos;
	}
}