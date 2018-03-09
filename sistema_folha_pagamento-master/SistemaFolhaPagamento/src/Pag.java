import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Pag {
	
	public  void employeePaymentHourly(Employee emp) {
		float count = emp.getPoints().size();
		for(Point p : emp.getPoints()) {
			if(p.isOvertime())
				count += 0.5;
		}
		System.out.printf(emp.getId()+" - "+emp.getName()+" - R$ %.2f - R$ %.2f\n",count * emp.getHourly(), emp.getSyndicate().getRateSynd());
		emp.setPoints(new ArrayList<Point>());
		emp.setLastPayment(new Date());
	}
	public void checkPending(Employee emp, ArrayList<String> schedule, ArrayList<Employee> employees) {

		System.out.println("Pendencia a ser paga\n");
		if(emp.getType() == Type.HOURLY)
			employeePaymentHourly(emp);
		else {
			Calendar calendarActual = Calendar.getInstance();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(emp.getLastPayment());

			String empSched = schedule.get(emp.getIndexSchedule());

			if(empSched.charAt(0) == 'm')
				employeePaymentVariable(emp, calendar, calendarActual, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			else if( empSched.charAt(8) == '1')
					employeePaymentVariable(emp, calendar, calendarActual, 7);

			else if( empSched.charAt(8) == '2')
				employeePaymentVariable(emp, calendar, calendarActual, 14);
		}
		emp.setSalary(0);
		emp.setCommission(0);
	}
	
    public void editPaymentSchedule(ArrayList<Employee> employees, ArrayList<String> schedule) {
		Scanner input = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("Digite o id do empregado:");
		int index = emp.searchEmployee( Integer.valueOf( input.nextLine() ), employees);
		if(index == -1){
			System.out.println("Usuario nao encontrado");
			return;
		}
		emp = employees.get(index);

		int size = schedule.size();
		System.out.println("Digite o id da agenda de pagamento desejada: ");
		for(int i=0; i<size; i++) {
			System.out.println(i+" - "+schedule.get(i));
		}
		int op = Integer.valueOf( input.nextLine() );
		if(op < 0 || op >=size) {
			System.out.println("Id invalido");
			return;
		}

		int lastSched = emp.getIndexSchedule();
		emp.setIndexSchedule(op);

		if(schedule.get(lastSched).charAt(0) == 'm' && schedule.get(op).charAt(0) == 's') {
			if(schedule.get(op).charAt(8) == '1')
				emp.setSalary( emp.getSalary() / 4);
			else
				emp.setSalary( emp.getSalary() / 2);
		}
		else if(schedule.get(lastSched).charAt(0) == 's' && schedule.get(op).charAt(0) == 'm') {

			if(schedule.get(lastSched).charAt(8) == '1')
				emp.setSalary( emp.getSalary() * 4);
			else
				emp.setSalary( emp.getSalary() * 2);
		}
		System.out.println("Feito!");
	}
	
	public void employeePaymentVariable(Employee emp, Calendar calendar, Calendar calendarActual, int factor) {

		float daily = emp.getSalary() / factor;
		int workedDays = emp.countDays(calendarActual, calendar);
		float commission = emp.getSalesValue() * emp.getCommission() / 100;

		System.out.printf(emp.getId()+" - "+emp.getName()+" - R$ %.2f - R$ %.2f\n",( daily * workedDays )+commission, emp.getSyndicate().getRateSynd());
		emp.setLastPayment(calendarActual.getTime());
		emp.setPoints(new ArrayList<Point>());
		emp.setSalesValue(0);

	}
	
	public void addPaymentSchedule(ArrayList<String> schedule) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a nova agenda de pagamento:");
		schedule.add( input.nextLine() );
		System.out.println("Feito!");
	}
	
	public int getConstantCalendar(String dayOfWeek) {

		if(dayOfWeek.equals("segunda"))
			return Calendar.MONDAY;
		else if(dayOfWeek.equals("terca"))
			return Calendar.TUESDAY;
		else if(dayOfWeek.equals("quarta"))
			return Calendar.WEDNESDAY;
		else if(dayOfWeek.equals("quinta"))
			return Calendar.THURSDAY;
		else if(dayOfWeek.equals("sexta"))
			return Calendar.FRIDAY;
		else if(dayOfWeek.equals("sabado"))
			return Calendar.SATURDAY;
		return Calendar.SUNDAY;
	}
    public void runPayroll(ArrayList<Employee> employees, ArrayList<String> schedule) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a data: [dd/mm/aaaa]");
		String dateS = input.nextLine();

		System.out.println("	FOLHA DE PAGAMENTO");
		System.out.println("-------------------------------------------------");
		System.out.println("ID | NOME | VALOR BRUTO | TRIBUTO");
		System.out.println("-------------------------------------------------");

		int day = Integer.valueOf( dateS.substring(0, 2) );
		int month = Integer.valueOf( dateS.substring(3, 5) );
		int year = Integer.valueOf( dateS.substring(6) );

		Calendar calendarActual = Calendar.getInstance();
		calendarActual.set(year, month -1 , day);
		int dayOfWeek = calendarActual.get(Calendar.DAY_OF_WEEK);
		int maxDaysMonth = calendarActual.getActualMaximum(Calendar.DAY_OF_MONTH);

		int size = employees.size();
		Employee emp;
		for(int i=0; i<size; i++) {

			emp = employees.get(i);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(emp.getLastPayment());

			String empSched = schedule.get(emp.getIndexSchedule());

			if(day == calendar.get(Calendar.DAY_OF_MONTH) && ( month - 1 ) == calendar.get(Calendar.MONTH))
				continue;
			if(empSched.charAt(0) == 'm' ) {

				if(empSched.charAt(7) != '$') {

					int dayToPay = 0;
					if(empSched.charAt(8) != ' ')
						dayToPay = Integer.valueOf( empSched.substring(7, 9) );
					else
						dayToPay = empSched.charAt(7) - 48;
					if(dayToPay == day ) {
						
						if(emp.getType() == Type.HOURLY)
							employeePaymentHourly(emp);
						
						else if(dayToPay == calendar.get(Calendar.DAY_OF_MONTH) && (month - 1) != calendar.get(Calendar.MONTH))
							employeePayment(emp, calendar, calendarActual);

						else if(dayToPay != calendar.get(Calendar.DAY_OF_MONTH)){
							employeePaymentVariable(emp, calendar, calendarActual, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
						}
					}
				} else if(day == maxDaysMonth){

					if(emp.getType() == Type.HOURLY)
						employeePaymentHourly(emp);

					else if( calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH) )
						employeePayment(emp, calendar, calendarActual);

					else
						employeePaymentVariable(emp, calendar, calendarActual, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
				}
			} else if( getConstantCalendar(empSched.substring(10) ) == dayOfWeek ){

				if( empSched.charAt(8) == '1') {

					if(emp.getType() == Type.HOURLY)
						employeePaymentHourly(emp);
					else
						employeePaymentVariable(emp, calendar, calendarActual, 7);

				} else if( empSched.charAt(8) == '2'){

					if(emp.countDays(calendarActual, calendar) >= 14) {

						if(emp.getType() == Type.HOURLY)
							employeePaymentHourly(emp);
						else
							employeePaymentVariable(emp, calendar, calendarActual, 14);
					}
				}
			}
		}
		System.out.println("-------------------------------------------------");
	}
	
    public void employeePayment(Employee emp, Calendar calendar, Calendar calendarActual) {

		float commission = emp.getSalesValue() * emp.getCommission() / 100;
		System.out.printf(emp.getId()+" - "+emp.getName()+" - R$ %.2f - R$ %.2f\n",emp.getSalary()+commission, emp.getSyndicate().getRateSynd());
		emp.setLastPayment(calendarActual.getTime());
		emp.setPoints(new ArrayList<Point>());
		emp.setSalesValue(0);
	}
}
