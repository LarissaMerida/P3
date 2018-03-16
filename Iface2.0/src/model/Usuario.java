package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Usuario {
	private String email;
	private String senha;
	private String nome;
	private Perfil perfilUsuario;
	private ArrayList<Usuario> listAmigos;
	private ArrayList<Comunidade> listComunidades;
	private ArrayList<Usuario> listSolicitacaoAmizade;
	private ArrayList<Mensagem> listMensagens;

	public Usuario(String email, String senha, String nome) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.perfilUsuario = new Perfil();
		this.listAmigos = new ArrayList<Usuario>();
		this.listComunidades = new ArrayList<Comunidade>();
		this.listSolicitacaoAmizade = new ArrayList<Usuario>();
		this.listMensagens = new ArrayList<Mensagem>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Perfil getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(Perfil perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public ArrayList<Usuario> getListAmigos() {
		return listAmigos;
	}

	public void setListAmigos(ArrayList<Usuario> listAmigos) {
		this.listAmigos = listAmigos;
	}

	public Comunidade getComunidadeByName(String nome){
		for(Comunidade comunidade : this.listComunidades){
			if(comunidade.getNome().equals(nome))
				return comunidade;
		}
		
		return null;
	}
	
	public ArrayList<Comunidade> getListComunidades() {
		return listComunidades;
	}

	public void setListComunidades(ArrayList<Comunidade> listComunidades) {
		this.listComunidades = listComunidades;
	}

	public ArrayList<Usuario> getListSolicitacaoAmizade() {
		return listSolicitacaoAmizade;
	}

	public void setListSolicitacaoAmizade(ArrayList<Usuario> listSolicitacaoAmizade) {
		this.listSolicitacaoAmizade = listSolicitacaoAmizade;
	}
	
	public ArrayList<Mensagem> getListMensagensByUser(Usuario remetente){
		ArrayList<Mensagem> listMensagem = new ArrayList<Mensagem>();
		
		for(Mensagem mensagem : this.listMensagens){
			if(mensagem.getUsuario().equals(remetente))
				listMensagem.add(mensagem);
		}
		
		return listMensagem;
	}

	public ArrayList<Mensagem> getListMensagens() {
		return listMensagens;
	}

	public void setListMensagens(ArrayList<Mensagem> listMensagens) {
		this.listMensagens = listMensagens;
	}
	
	public void editarPerfil(String novoValor, int opcao){
		if(opcao == 1){
			this.perfilUsuario.setCidade(novoValor);
		}else{
			this.perfilUsuario.setDescricao(novoValor);
		}
	}
	
	public void editarPerfil(Calendar dataNascimento){
		this.perfilUsuario.setDataNascimento(dataNascimento);
	}
	
}
