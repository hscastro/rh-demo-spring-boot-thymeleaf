package br.ce.desen.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity<Long> {
	
	private String login;
	
	private String senha;
	
	private boolean admin;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String login, String senha, boolean admin) {
		this.login = login;
		this.senha = senha;
		this.admin = admin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


}
