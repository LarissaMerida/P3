package model;

import java.util.Calendar;

public class Perfil {
	private String cidade;
	private Calendar dataNascimento;
	private String descricao;
	
	public Perfil(String cidade, Calendar dataNascimento, String descricao) {
		this.cidade = cidade;
		this.dataNascimento = dataNascimento;
		this.descricao = descricao;
	}
	
	public Perfil(){
		this.dataNascimento = null;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getIdade() {
		if(dataNascimento != null) {
			Calendar now = Calendar.getInstance();
			
			long millis = now.getTimeInMillis() - dataNascimento.getTimeInMillis();
			
			now.setTimeInMillis(millis);
			return now.get(Calendar.YEAR);
		}
		
		return 0;
	}
	
}
