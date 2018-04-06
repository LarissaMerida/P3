package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import database.Database;

import payament.PaymentSchedule;
import payament.Payroll;
import payament.Venda;
import user.Comissioned;
import user.Empregado;
import user.Hourly;
import user.Salaried;

import enums.MethodPay;

public class Interface {

	public Scanner input = new Scanner(System.in);
	public Database database = Database.getInstance();
	public Payroll payroll = Payroll.getInstance();
	public Calendar calendar = Calendar.getInstance();

	public void initialize() {

		PaymentSchedule pay = new PaymentSchedule();
		pay.setPaymentSchedule("mensal $");
		database.addSchedule( pay );

		pay = new PaymentSchedule();
		pay.setPaymentSchedule("semanal 1 sexta");
		database.addSchedule( pay );

		pay = new PaymentSchedule();
		pay.setPaymentSchedule("semanal 2 sexta");
		database.addSchedule( pay );

		showInitialMenu();

	}

	public ArrayList<Salaried> salarieds = new ArrayList<Salaried>();
	public ArrayList<Comissioned> comissioneds = new ArrayList<Comissioned>();
	public ArrayList<Hourly> hourlys = new ArrayList<Hourly>();
	
	public void showInitialMenu()
	{
		int continuar = 1;
		int realizar, escolha;

		boolean undoing = false;
		boolean redoing = false;

		while(continuar != 0)
		{
			System.out.println("Digite 1(empregado) 2(lancar) 3(folha) 0(sair)");
			if(undoing)
				System.out.println("4 (undo)");
			else if(redoing)
				System.out.println("4 (redo)");
			realizar = Integer.valueOf( input.nextLine() );

			if(realizar == 1)
			{
				System.out.println("Digite 1(incluir) ou 2(editar) ou 3(remover)");
				escolha = Integer.valueOf( input.nextLine() );

				if(escolha == 1){
					addEmployee();
					undoing = true;
				} else if(escolha == 2) {
					editEmployee();
					undoing = true;
				} else if(escolha == 3) {
					removeEmployee();
					undoing = true;
				}else
				{
					System.out.println("Opcao invalida!!");
					continue;
				}
			}
			else if(realizar == 2)
			{
				System.out.println("Digite: 1(Cartao de Ponto) 2(Venda) 3(Taxa de servico)");
				int lancar = Integer.valueOf( input.nextLine() );

				System.out.println("Digite o id: ");
				Empregado emp = database.searchEmployee( Integer.valueOf( input.nextLine() ) );
				if( emp == null ) {
					System.out.println("Usuario inexistente!");
					continue;
				}

				if(lancar == 1){
					((Hourly)emp).addPointCard();
					undoing = true;
				}else if(lancar == 2){
					lancarVenda( emp );
					undoing = true;
				}else if(lancar == 3)
				{
					lancarTaxaServico( emp );
					undoing = true;
				}
				else
					System.out.println("Numero digitado invalido!");
					continue;
			}
			else if(realizar == 3)
			{
				System.out.println("Digite: 1(Folha de hoje) 2(criacao de agenda)");
				int folha= Integer.valueOf( input.nextLine() );

				if(folha == 1)
				{
					System.out.println("Digite o dia: ");
					int day = Integer.valueOf( input.nextLine() );
					System.out.println("Digite o mes: ");
					int month = Integer.valueOf( input.nextLine() );
					System.out.println("Digite o ano: ");
					int year = Integer.valueOf( input.nextLine() );

					calendar.set(year, month - 1, day);

					payroll.run( calendar.getTime(), salarieds, comissioneds, hourlys );
				}
				else if(folha == 2)
				{
					criaAgenda();
				}
				else
				{
					System.out.println("Opcao invalida!!");
					continue;
				}
			}
			else if(realizar == 4){
				if(undoing) {
					database.undo();
					undoing = false;
					redoing = true;
					System.out.println("Feito");
				} else if(redoing) {
					database.redo();
					redoing = false;
					undoing = true;
					System.out.println("Feito");
				}
			}
			else
			{
				System.out.println("Opcao invalida.");
				continue;
			}

		}
		System.out.println("Programa encerrado.");
	}
	
	public void editEmployee() {

		System.out.println("Digite o id do empregado: ");
		int id =  Integer.valueOf( input.nextLine() );
		Empregado emp = database.searchEmployee(id);

		if( emp == null ) {
			System.out.println("Empregado inexistente!");
			return;
		}
		
		System.out.println("Digite 1 para editar as informacoes pessoais do empregado ou 0 para continuar:");
		int option = Integer.valueOf( input.nextLine() );
		if( option == 1 )
			emp.editPersonalInfo();

		System.out.println("Digite 1 para editar as informacoes financeiras do empregado ou 0 para continuar:");
		option = Integer.valueOf( input.nextLine() );
		if( option == 1 )
			emp.editFinicialInfo();

		System.out.println("Digite 1 para editar as informacoes sindicais do empregado ou 0 para continuar:");
		option = Integer.valueOf( input.nextLine() );
		if( option == 1 )
			emp.editSindicateInfo();

		database.editEmployee(emp);
		System.out.println("Feito!");

	}

	public void addEmployee() {

		System.out.println("Escolha o tipo de empregado: ");
		System.out.println("1 - Assalariado ");
		System.out.println("2 - Comissionado ");
		System.out.println("3 - Horista ");
		int tipo = input.nextInt();
		int exist = 0;
		Empregado emp =  null;
		
		System.out.println("Digite o nome do empregado:");
		String nome = input.nextLine() ;

		System.out.println("Digite o endereco:");
		String endereco = input.nextLine() ;
		int id = 0;
		float salarioFixo = 0;
		while(exist == 0)
		{
			switch(tipo)
			{
				case 1:
					System.out.println("Digite o salario fixo: ");
					salarioFixo = Float.valueOf( input.nextLine() );
					emp = new Salaried(id, nome, endereco, salarioFixo);
					salarieds.add((Salaried) emp);
					exist = 1;
					break;
				case 2:
					System.out.println("Digite o salario fixo: ");
					salarioFixo = Float.valueOf( input.nextLine() );
					emp = new Comissioned(id, nome, endereco, salarioFixo);
					comissioneds.add((Comissioned) emp);
					exist = 1;
					break;
				case 3:
					emp = new Hourly(id, nome, endereco);
					hourlys.add((Hourly) emp);
					exist = 1;
					break;
				default:
					System.out.println("Tipo inexistente. ");
					id--;
			}
			id++;
		}
		
		if(exist == 1)
		{
			emp.editFinicialInfo();
			emp.editSindicateInfo();
			
			System.out.println("Empregado cadastrado! ID do novo empregado:" + database.addEmployee(emp));
		}
	}

	public void removeEmployee() {

		System.out.println("Digite o id do empregado:");
		int id = input.nextInt();
		input.nextLine();
		if (database.removeEmployee(id) )
			System.out.println("Feito!");
		else
			System.out.println("Empregado inexistente!");

	}

	public void criaAgenda()
	{
		PaymentSchedule sched = new PaymentSchedule();
		System.out.println("Digite a nova agenda: ");
		boolean returned = sched.setPaymentSchedule( input.nextLine() );
		if(returned) {
			database.addSchedule(sched);
			System.out.println("Feito");
		} else {
			System.out.println("Entrada invalida");
		}

	}

	public void lancarTaxaServico(Empregado emp)
	{
		System.out.println("Digite a taxa de servico: ");
		emp.addServiceRate( Float.valueOf( input.nextLine() ) );

	}

	public void lancarVenda(Empregado emp)
	{
		Venda sale = new Venda();

		System.out.println("Digite o valor da venda:");
		sale.setValor(Float.valueOf( input.nextLine() ) );
		System.out.println("Digite o valor da comissao [Ex.: Se for 10%, digite 0.1]: ");
		sale.setComissao(Float.valueOf( input.nextLine() ) );

		((Comissioned)emp).addSale(sale);
		database.editEmployee(emp);
	}

}
