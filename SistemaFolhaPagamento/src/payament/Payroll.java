package payament;



import java.util.ArrayList;
import java.util.Date;

import user.Comissioned;
import user.Empregado;
import user.Hourly;
import user.Salaried;

import database.Database;



public class Payroll {

	private static Payroll payroll = new Payroll();;
	private Database database = Database.getInstance();;
	private static final int MILLISECONDS_PER_HOUR = 3600000;
	
	private Payroll() {}
	
	public static Payroll getInstance() {
		return payroll;
	}
	
	public void run(Date today, ArrayList<Salaried> salarieds, ArrayList<Comissioned> comissioneds, ArrayList<Hourly> hourlys) {
		
		ArrayList<Empregado> employees = database.getEmployees();
		
		float amountCommision;
		float amountSalary;
		float amountHourly;
		float grossSalary;
		float liquidSalary;
		float sindRate;
		
		float total = 0;
		
		for(Empregado emp : employees) {
			
			if(emp.isDayToPay(today)) {
				
				amountCommision = 0;
				amountSalary = 0;
				amountHourly = 0;
				
				for(Comissioned emp2 : comissioneds)
				{
					if(emp == emp2)
					{
						for(Venda sale :  emp2.getSales()) {
							amountCommision += sale.getValueCommission();
						}
						
						emp2.resetSales();
					}
				}
				
				
				ArrayList<Point> cartao = ((Hourly)emp).getCartao();
				int sizePoints = cartao.size();
				for(int i=0; i<sizePoints; i++ ) {
					
					Point point = cartao.get(i);
					if( point.isHourly() ) {
						
						amountHourly += 1;
						if( ( i - 8 ) >= 0 && isSameDay( cartao.get( i - 8 ), point ) ) 
							amountHourly += 0.5;
					} else {
						amountSalary += 1;
					}
					
				}
				
				grossSalary = amountCommision + amountHourly * ((Hourly)emp).getSalarioHora() + amountSalary * avarageSalary( emp );
				sindRate = emp.getTaxa() + emp.getTaxaServicos();
				liquidSalary = grossSalary - sindRate;
				total += grossSalary;
				
				((Hourly)emp).resetPointsCard();
				emp.setUltimoPagamento( today );
				
				System.out.println("---------------------------------------------");
				System.out.printf("[%d] %s\n"
								+ "     Salario: R$ %.2f\n"
								+ "     Descontos sindicais: R$ %.2f\n"
								+ "     Salario liquido: R$ %.2f\n", grossSalary, sindRate, liquidSalary);
				System.out.println("---------------------------------------------");
				
			}
			
		}
		
		System.out.printf("TOTAL : R$ %.2f\n", total);
		database.setEmployees(employees);
		
	}
	
	private float avarageSalary( Empregado emp ) {
		return emp.getSalarioFixo() / 25;		
	}
	
	private boolean isSameDay(Point p1, Point p2) {
		
		long hoursDistance = ( p1.getDate().getTime() - p2.getDate().getTime() ) / MILLISECONDS_PER_HOUR;
		if( hoursDistance < 24 )
			return true;
		return false;
		
	}
	
}
