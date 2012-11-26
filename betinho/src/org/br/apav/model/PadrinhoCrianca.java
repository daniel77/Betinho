package org.br.apav.model;

public class PadrinhoCrianca {
	private int codPadrinho;
	private int codCrianca;
	
	
	public PadrinhoCrianca(){}
	
	public PadrinhoCrianca(Integer codCrianca, Integer codPadrinho){
		this.setCodCrianca(codCrianca);
		this.setCodPadrinho(codPadrinho);
		
	}
	public int getCodCrianca() {
		return codCrianca;
	}
	public void setCodCrianca(int codCrianca) {
		this.codCrianca = codCrianca;
	}
	public int getCodPadrinho() {
		return codPadrinho;
	}
	public void setCodPadrinho(int codPadrinho) {
		this.codPadrinho = codPadrinho;
	}
	
	
}
