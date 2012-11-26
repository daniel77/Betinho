package org.br.apav.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.br.apav.framework.ObjetoPersistivel;

public class Remedio extends ObjetoPersistivel implements Serializable  {
	
	private static final long serialVersionUID = -1286206805159884771L;
	
	public Remedio(){
                EAN ="" ;
	    	descricao = "";
		formula = "";
		qtdeEmbalagem=0;
		tipoQtde="";
	}

	private int codRemedio;	
	private String EAN;
	private String descricao;
	private String formula;
	private int qtdeEmbalagem;
	private String tipoQtde;

	    private List<Emar> emars = new ArrayList<Emar>();
	
	/**
	     * Retorna o valor de emars
	     * @return  emars
	     */
	    public List<Emar> getEmars() {
	        return emars;
	    }

	    /**
	     * @param emars é atribuido a emars
	     */
	    public void setEmars(List<Emar> emars) {
	        this.emars = emars;
	    }

	/**
	 * @return the desc
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDescricao(String desc) {
		this.descricao = desc.toUpperCase();
	}



	/**
	 * @return the formula
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * @param formula
	 *            the formula to set
	 */
	public void setFormula(String formula) {
		this.formula = formula.toUpperCase();
	}

	/**
	 * @return the qtdeEmbalagem
	 */
	public int getQtdeEmbalagem() {
		return qtdeEmbalagem;
	}

	/**
	 * @param qtdeEmbalagem
	 *            the qtdeEmbalagem to set
	 */
	public void setQtdeEmbalagem(int qtdeEmbalagem) {
		this.qtdeEmbalagem = qtdeEmbalagem;
	}

	/**
	 * @return the tipoQtde
	 */
	public String getTipoQtde() {
		return tipoQtde;
	}

	/**
	 * @param tipoQtde
	 *            the tipoQtde to set
	 */
	public void setTipoQtde(String tipoQtde) {
		this.tipoQtde = tipoQtde.toUpperCase();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    return this.descricao;
	    
	}

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }
    
    
    public String getEAN() {
        return EAN;
    }

    public int getCodRemedio() {
        return codRemedio;
    }

    public void setCodRemedio(int codRemedio) {
        this.codRemedio = codRemedio;
    }
	
	
}