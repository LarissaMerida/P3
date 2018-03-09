import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;

public class Employee {
	private int id;
	private String name;
	private String address;
	private Type type;
	private TypeEmp typeEmp;
	private Pag pag;
	private MethodPag method;
	private ArrayList<Point> points;
	private int indexSchedule;
	private Date lastPayment;
	private float hourly;
	private float salary;
	private float commission;
	private float salesValue;
	private Syndicate syndicate;

	public Employee(int id, String name, String address, Type type, MethodPag mail, int indexSchedule,
			Date lastPayment) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.type = type;
		this.method = mail;
		this.indexSchedule = indexSchedule;
		this.lastPayment = lastPayment;
		this.points = new ArrayList<Point>();
		this.salesValue = 0;
		this.commission = 0;
		this.syndicate = new Syndicate();
		this.pag = new Pag();
		this.typeEmp = new TypeEmp();
	}

	public Employee() {
		this.points = new ArrayList<Point>();
		this.salesValue = 0;
		this.commission = 0;
		this.lastPayment = new Date();
		this.pag = new Pag();
		this.typeEmp = new TypeEmp();
		this.syndicate = new Syndicate();
	}

	public Date getLastPayment() {
		return lastPayment;
	}
	public void setLastPayment(Date lastPayment) {
		this.lastPayment = lastPayment;
	}
	
	public void setSyndicate(Syndicate syndicate) {
		this.syndicate = syndicate;
	}
	public Syndicate getSyndicate() {
		return this.syndicate;
	}
	
	public int getIndexSchedule() {
		return indexSchedule;
	}
	public void setIndexSchedule(int indexSchedule) {
		this.indexSchedule = indexSchedule;
	}
	
	public TypeEmp getTypeEmp() {
		return this.typeEmp;
	}
    public Type getType() {
		return type;
	}
    public void setType(Type salaried) {
		this.type = salaried;
	}
	
    public float getHourly() {
		return hourly;
	}
    public void setHourly(float hourly) {
		this.hourly = hourly;
	}
	
    public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public float getCommission() {
		return commission;
	}
	public void setCommission(float comission) {
		this.commission = comission;
	}
	
    public float getSalesValue() {
		return salesValue;
	}
	public void setSalesValue(float salesValue) {
		this.salesValue = salesValue;
	}
	 
	public void addSalesValue() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o valor da venda: ");
		float increment = input.nextFloat();
		this.salesValue = this.salesValue + increment;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}
	public void setPoints(ArrayList<Point> arrayList) {
		this.points = arrayList;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    public void editPersonalEmp() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		setName( input.nextLine() );
		System.out.println("Digite o endereco: ");
		setAddress( input.nextLine() );
	}

	public void addEmployee(int count, ArrayList<Employee> employees) {
		Employee emp = new Employee();
		this.syndicate = new Syndicate();
		editPersonalEmp();	   
		int invalid = typeEmp.editFinancialEmp(emp);
		if(invalid == 0) {
			syndicate.editSyndicateEmp(emp);
			setId( count++ );
			employees.add(emp);
			System.out.println("ID: "+(count-1)+"\nFeito!\n");
		}
	}	
	
    public Pag getPag() {
		return pag;
	}
    public void setPag(MethodPag mail) {
		this.method = mail;
	}
	public void addSalesValue(ArrayList<Employee> employees) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o id do empregado");
		int index = searchEmployee( Integer.valueOf( input.nextLine() ), employees );
		if(index < 0) {
			System.out.println("Empregado nao encontrado!");
			return;
		}
		Employee emp = employees.get(index);
		emp.addSalesValue(  );

		System.out.println("Feito!");
	}
	
	public void addServiceRate(ArrayList<Employee> employees) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o id do empregado");
		int index = searchEmployee( Integer.valueOf( input.nextLine() ), employees);
		if(index < 0) {
			System.out.println("Empregado nao encontrado!");
			return;
		}
		Employee emp = new Employee();
		emp = employees.get(index);
		System.out.println("Digite a taxa de servico");
		float rate = input.nextFloat();

		emp.getSyndicate().setRateSynd( emp.getSyndicate().getRateSynd() + rate );
		System.out.println("Feito!");
	}
	
	public void editEmployee(ArrayList<Employee> employees , ArrayList<String> schedule) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o id do empregado: ");
		int id = Integer.valueOf( input.nextLine() );
		int index = searchEmployee(id, employees);

		if(index < 0) {
			System.out.println("Usuario inexistente!");
			return;
		}
		Employee emp = employees.get(index);

		int ans = -1;
		while(ans != 0) {
			System.out.println("Digite que tipo dados deseja alterar: \n" +
								"1 - Dados pessoais\n" +
								"2 - Dados financeiros\n" +
								"3 - Dados sindicais\n" +
								"Digite 0 para concluir");
			ans = Integer.valueOf( input.nextLine( ) );
			if(ans == 1)
				editPersonalEmp();
			else if(ans == 2) {
				emp.getPag().checkPending(emp, schedule, employees);
				emp.getTypeEmp().editFinancialEmp(emp);
			}
			else if(ans == 3)
				emp.getSyndicate().editSyndicateEmp(emp);
		}
		System.out.println("Feito!\n");
	}
	
	public int countDays(Calendar calendarActual, Calendar calendar) {
		long timeActual = calendarActual.getTime().getTime();
		long time = calendar.getTime().getTime();

		return (int)(timeActual - time) / 86400000 ;
	}
	
	public int searchEmployee(int id, ArrayList<Employee> employees) {
		int size = employees.size();
		for(int i = 0; i<size; i++) {
			if(id == employees.get(i).getId())
				return i;
		}
		return -1;
	}
	
	public void deleteEmployee(ArrayList<Employee> employees) {Scanner input = new Scanner(System.in);
		System.out.println("Digite o id do empregado: ");
		int id = Integer.valueOf( input.nextLine() );
		int index = searchEmployee(id, employees);
		if(index < 0) {
			System.out.println("Usuário não encontrado!");
			return;
		}
		employees.remove(index);
		System.out.println("Feito!");
	}
}
