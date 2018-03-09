import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

	private static int count = 0;
	private static final Scanner input = new Scanner(System.in);
	private static  ArrayList<Employee> employees = new ArrayList<Employee>();
	private static  ArrayList<String> schedule = new ArrayList<String>();
	
	public static void main(String[] args) {

	    schedule.add("mensal $");
		schedule.add("semanal 1 sexta");
		schedule.add("semanal 2 sexta");

		Employee emp = new Employee(count++, "Maria", "UFAL", Type.SALARIED, MethodPag.DEPOSIT, 0, new Date());
		emp.setSalary(1000);
		employees.add(emp);
		emp = new Employee(count++, "Joao", "UFAL", Type.COMMISIONED, MethodPag.MAIL, 2, new Date());
		emp.setSalary(600);
		emp.setCommission(15);
		employees.add(emp);
		emp = new Employee(count++, "Joana", "UFAL", Type.HOURLY,MethodPag.DIRECTLY, 1, new Date());
		emp.setHourly(10);
		employees.add(emp);

		 menu();
	}

	public static void menu() {
		int op = -1;
		while(op != 0) {
			System.out.println("Digite a opcao desejada:\n\n"
							 + "1 - Adicionar empregado\n"
							 + "2 - Remover empregado\n"
							 + "3 - Lancar um cartao de ponto\n"
							 + "4 - Lancar um resultado de venda\n"
							 + "5 - Lancar uma taxa de servico\n"
							 + "6 - Alterar detalhes de um empregado\n"
							 + "7 - Rodar a folha de pagamento para hoje\n"
							 + "8 - Undo/redo\n"
							 + "9 - Alterar agenda de pagamento de um empregado\n"
							 + "10 - Criar nova agenda de pagamento\n"
							 + "0 - Parar");
			op = Integer.valueOf(input.nextLine());
			Employee emp = new Employee() ;
			Point point = new Point();
			switch (op){

				case 1:
					emp.addEmployee(employees.size(),employees);
					break;
				case 2:
					emp.deleteEmployee(employees);
					break;
				case 3:
					point.addPointCard(employees);
					break;
				case 4:
					emp.addSalesValue();
					break;
				case 5:
					emp.addServiceRate(employees);
					break;
				case 6:
					emp.editEmployee(employees, schedule);
					break;
				case 7:
					emp.getPag().runPayroll(employees,schedule);
					break;
				case 8:
					undo_redo();
					break;
				case 9:
					emp.getPag().editPaymentSchedule(employees,schedule);
					break;
				case 10:
					emp.getPag().addPaymentSchedule(schedule);
					break;
				default:
					System.out.println("Programa encerrado.");
					break;
			}
		}
	}
	public static void undo_redo() {}
}
