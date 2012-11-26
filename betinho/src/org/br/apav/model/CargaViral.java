package org.br.apav.model;

import java.io.Serializable;
import java.util.Date;

import org.br.apav.framework.DataUtility;
import org.br.apav.framework.ObjetoPersistivel;

public class CargaViral extends ObjetoPersistivel implements Serializable  {
	
    public CargaViral(){
	    
	
	    log ="";
    }

    
    /**
     * 
     */
    private static final long serialVersionUID = 2375634237298445107L;
    
    private int codCargaViral;
    private Date data;
    private int cd8;
    private int cd4;
    private String log;
    private Crianca crianca;
    
    
    public int getCd4() {
    	return cd4;
    }
    public void setCd4(int cd4) {
    	this.cd4 = cd4;
    }
    public int getCd8() {
    	return cd8;
    }
    public void setCd8(int cd8) {
    	this.cd8 = cd8;
    }
    public int getCodCargaViral() {
    	return codCargaViral;
    }
    public void setCodCargaViral(int codCargaViral) {
    	this.codCargaViral = codCargaViral;
    }
    public Crianca getCrianca() {
    	return crianca;
    }
    public void setCrianca(Crianca crianca) {
    	this.crianca = crianca;
    }
    public Date getData() {
    	return data;
    }
    public void setData(Date data) {
    	this.data = data;
    }
    public String getLog() {
    	return log;
    }
    public void setLog(String log) {
    	this.log = log;
    }
    public String getDataExameStr() {
	return DataUtility.dateToString(this.data);
    }

}