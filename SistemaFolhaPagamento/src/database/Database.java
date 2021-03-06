package database;



import java.util.ArrayList;
import java.util.Date;

import payament.PaymentSchedule;
import user.Empregado;
import user.Salaried;

import enums.DB_Used;


public class Database {

	public ArrayList<Empregado> principal = new ArrayList<Empregado>();
	public ArrayList<Empregado> secondary = new ArrayList<Empregado>();
	public ArrayList<Empregado> actual;

	public ArrayList<PaymentSchedule> schedules = new ArrayList<>();

	public DB_Used actual_DB;
	public int idLastDeleted;

	public static Database database = new Database();

	public Database() {
		actual = principal;
		actual_DB = DB_Used.PRINCIPAL;
		idLastDeleted = -1;
	}

	public static Database getInstance() {
		return database;
	}

	public Empregado searchEmployee(int id) {

		for(Empregado emp : actual) {
			if(emp.getId() == id) {

				if(emp.isDeleted())
					return null;

				return emp;
			}
		}

		return null;

	}

	public void addSchedule(PaymentSchedule sched) {
		schedules.add(sched);
	}

	public ArrayList<PaymentSchedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(ArrayList<PaymentSchedule> schedules) {
		this.schedules = schedules;
	}

	public int addEmployee(Empregado emp) {

		update();

		int id = actual.size();
		emp.setId( id );
		actual.add(emp);
		return id;
	}

	public void editEmployee(Empregado emp) {

		update();

		actual.set(emp.getId(), emp);
	}

	public boolean removeEmployee(int id) {

		if( id < actual.size() && actual.get( id ).isDeleted() != true ) {
			actual.get( id ).setDeleted( true );
			idLastDeleted = id;
			return true;
		}

		return false;

	}

	public ArrayList<Empregado> getEmployees() {
		return actual;
	}

	public void setEmployees( ArrayList<Empregado> emps) {

		update();

		if(actual_DB == DB_Used.SECONDARY) {
			secondary = new ArrayList<>();
			actual = secondary;

		} else {
			principal = new ArrayList<>();
			actual = principal;
		}

		actual.addAll( emps );

	}

	public void undo() {

		if( idLastDeleted != -1 ) {
			actual.get(idLastDeleted).setDeleted( false );
		} else {
			actual = secondary;
			actual_DB = DB_Used.SECONDARY;
		}
	}

	public void redo() {

		if( idLastDeleted != -1 ) {
			actual.get(idLastDeleted).setDeleted( true );
		} else {
			actual = principal;
			actual_DB = DB_Used.PRINCIPAL;
		}
	}

	public void update() {

		idLastDeleted = -1;

		if(actual_DB == DB_Used.PRINCIPAL) {
			secondary = new ArrayList<>();
			secondary.addAll( principal );

		} else {
			principal = new ArrayList<>();
			principal.addAll( secondary );
		}

	}

}
