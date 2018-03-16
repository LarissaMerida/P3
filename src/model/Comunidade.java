package model;

import java.util.ArrayList;

public class Comunidade {
	private int id;
	private String nome;
	private String descricao;
	private Usuario usuario;
	private ArrayList<Usuario> listParticipantes;
	private ArrayList<Mensagem> listMensagens;
	

	public Comunidade(int id, Usuario usuario, String nome, String descricao) {
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.descricao = descricao;
		this.listParticipantes = new ArrayList<Usuario>();
		this.listMensagens = new ArrayList<Mensagem>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public ArrayList<Usuario> getListParticipantes() {
		return listParticipantes;
	}

	public void setListParticipantes(ArrayList<Usuario> listParticipantes) {
		this.listParticipantes = listParticipantes;
	}

	public ArrayList<Mensagem> getListMensagens() {
		return listMensagens;
	}

	public void setListMensagens(ArrayList<Mensagem> listMensagens) {
		this.listMensagens = listMensagens;
	}

	

}
