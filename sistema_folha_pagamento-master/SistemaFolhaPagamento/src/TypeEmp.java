import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class TypeEmp {
	
	public int editFinancialEmp(Employee emp) {
		Scanner input = new Scanner(System.in);
		System.out.println("Defina o tipo:\n" +
				   "1 - Horista\n" +
				   "2 - Assalariado\n" +
				   "3 - Comissionado");
		int type = Integer.valueOf( input.nextLine() );
		int invalid= 0;
		if(type == 1) {
			emp.setType(Type.HOURLY);
			System.out.println("Digite quanto recebe por hora trabalhada: ");
			emp.setHourly( Float.valueOf( input.nextLine() ));
			emp.setIndexSchedule(1);
		} else if(type == 2 || type == 3){
			System.out.println("Digite o salario: ");
			emp.setSalary( Float.valueOf( input.nextLine() ));

			if(type == 2) {
				emp.setType(Type.SALARIED);
				emp.setIndexSchedule(0);
			}else if(type == 3){
				System.out.println("Digite o valor da comissao: ");
				emp.setCommission( Float.valueOf( input.nextLine() ));
				emp.setType(Type.COMMISIONED);
				emp.setIndexSchedule(2);
			}
		}else {
			System.out.println("Opcao invalida.");
			invalid = 1;
		}
		
		if(invalid == 0){
			System.out.println("Defina o metodo de pagamento:\n" +
					   "1 - Cheque pelos Correios\n" +
					   "2 - Cheque em maos\n" +
					   "3 - Deposito em conta bancaria");
			int method = Integer.valueOf( input.nextLine() );
			if(method == 1)
				emp.setPag(MethodPag.MAIL);
			else if(method == 2)
				emp.setPag(MethodPag.DIRECTLY);
			else
				emp.setPag(MethodPag.DEPOSIT);
		}
		return invalid;
	}
}
