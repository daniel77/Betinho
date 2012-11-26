package org.br.apav.framework;

public class PersistenciaException extends Exception {
	
	static final long serialVersionUID = 101;
	
	public PersistenciaException(){
		super("ERRO-1"); //problemas ao salvar
	}
}
