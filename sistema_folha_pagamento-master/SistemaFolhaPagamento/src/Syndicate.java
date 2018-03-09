import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Syndicate {
	public boolean assocSynd;
	public int idSynd;
	public float rateSynd;
	
	public Syndicate() {
		this.assocSynd = false;
		this.idSynd = 0;
		this.rateSynd = 0f;
	}

	public Syndicate(boolean assocSynd, int idSynd, float rateSynd) {
		this.assocSynd = assocSynd;
		this.idSynd = idSynd;
		this.rateSynd = rateSynd;
	}

	public boolean isAssocSynd() {
		return this.assocSynd;
	}
	
	public void setAssocSynd(boolean assocSynd) {
		this.assocSynd = assocSynd;
	}
	
    public int getIdSynd() {
		return this.idSynd;
	}
   
    public void setIdSynd(int idSynd) {
		this.idSynd = idSynd;
	}
	
    public float getRateSynd() {
		return this.rateSynd;
	}
	
    public void setRateSynd(float rateSynd) {
		this.rateSynd = rateSynd;
	}
	
    public Employee editSyndicateEmp(Employee emp) {
		Scanner input = new Scanner(System.in);
		System.out.println("Associacao com sidicato:\n" +
				   "1 - Sim\n" +
				   "2 - Nao\n");
		int ans = Integer.valueOf( input.nextLine() );
		setAssocSynd( ans == 1 ? true : false );

		if( isAssocSynd() ) {
			System.out.println("Digite a identificacao no sindicato: ");
			setIdSynd( Integer.valueOf( input.nextLine() ) );
			System.out.println("Digite a taxa sindical: ");
			setRateSynd( Integer.valueOf( input.nextLine() ) );
		}
		return emp;
	}
}
