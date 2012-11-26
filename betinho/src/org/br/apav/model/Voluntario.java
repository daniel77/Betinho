package org.br.apav.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.br.apav.framework.ObjetoPersistivel;

import static org.br.apav.framework.Pesquisa.*;

public class Voluntario extends ObjetoPersistivel implements Serializable {

	static final long serialVersionUID = 300;
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		
		return(((Voluntario)obj).getLogin().equals(this.getSenha()) && 
				((Voluntario)obj).getSenha().equals(this.getSenha()));
		
	}

	public Voluntario(){
		
	}
	
	public Voluntario(String login){
		Voluntario vol = (Voluntario)carregar(Voluntario.class,login);
		this.setLogin(vol.getLogin());
		this.setSenha(vol.getSenha());
		
	}
	
	private String login;
	private String senha;



	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}


	
	public static ArrayList<Voluntario> listagem(String pk){
		StringBuffer hql = new StringBuffer("from Voluntario");
		return (ArrayList<Voluntario>) pesquisa(hql);
	}

}