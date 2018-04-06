package user;

import java.util.ArrayList;
import java.util.Scanner;

import payament.Point;

public class Hourly extends Empregado{
	public ArrayList<Point> cartao;
	public float salarioHora;
	public Scanner input = new Scanner(System.in);
	
	public Hourly(int id, String nome, String endereco)
	{
		super(id, nome, endereco, "semanal 1 sexta", 0f);
		System.out.println("Valor da hora trabalhada:");
		setSalarioHora( Float.valueOf( input.nextLine() ) );
	}
	
	public ArrayList<Point> getCartao() {
		return cartao;
	}

	public void setCartao(ArrayList<Point> cartao) {
		this.cartao = cartao;
	}
	
	public void resetPointsCard() {
		this.cartao = new ArrayList<>();
	}

	public void addPointCard() {

		Point point = new Point(true);

		int size = cartao.size();
		if(size >= 8) {
			//Converte o intervalo de tempo de milisegundos para horas
			long time = (point.getDate().getTime() - cartao.get( size - 8 ).getDate().getTime()) / 3600000;

			if(time < 24)
				point.setOvertime(true);
		}

		this.cartao.add(point);
	}
	
	public void setSalarioHora(float salario)
	{
		this.salarioHora = salario;
	}
	public float getSalarioHora()
	{
		return this.salarioHora;
	}

}
