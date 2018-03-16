package model;

public class Mensagem {
	private Usuario usuario;
	private String descricao;
	
	public Mensagem(Usuario usuario, String descricao) {
		this.usuario = usuario;
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
