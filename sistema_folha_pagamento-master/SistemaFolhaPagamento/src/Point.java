import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Point {
	
	private Date date;
	private boolean overtime;
	
	public Point() {
		this.date = new Date();
		this.overtime = false;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isOvertime() {
		return overtime;
	}
	public void setOvertime(boolean overtime) {
		this.overtime = overtime;
	}
	
	public  void addPointCard(ArrayList<Employee>employees) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o id do empregado");
		Employee emp = new Employee();
		int index = emp.searchEmployee( Integer.valueOf( input.nextLine() ), employees );
		if(index < 0) {
			System.out.println("Empregado nao encontrado!");
			return;
		}

	    emp = employees.get(index);
		System.out.println("---------------------------------");
		System.out.println(emp.getId()+" - "+emp.getName());
		System.out.println("---------------------------------");
	}
}
