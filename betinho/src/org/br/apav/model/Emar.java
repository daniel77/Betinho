package org.br.apav.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.br.apav.framework.DataUtility;
import org.br.apav.framework.ObjetoPersistivel;

public class Emar extends ObjetoPersistivel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3273443337552442925L;

    private int codEmar;

    private java.util.Date dataInicio;

    private java.util.Date dataFim;

    private List<Remedio> remedios = new ArrayList<Remedio>();

    private boolean ativo;

    private Crianca crianca;

    private Cid10 cid10;

    /**
     * Retorna o valor de ativo
     * @return  ativo
     */
    public boolean isAtivo() {
	return ativo;
    }

    /**
     * @param ativo é atribuido a ativo
     */
    public void setAtivo(boolean ativo) {
	this.ativo = ativo;
    }

    /**
     * Retorna o valor de cid10
     * @return  cid10
     */
    public Cid10 getCid10() {
	return cid10;
    }

    /**
     * @param cid10 é atribuido a cid10
     */
    public void setCid10(Cid10 cid10) {
	this.cid10 = cid10;
    }

    /**
     * Retorna o valor de codEmar
     * @return  codEmar
     */
    public int getCodEmar() {
	return codEmar;
    }

    /**
     * @param codEmar é atribuido a codEmar
     */
    public void setCodEmar(int codEmar) {
	this.codEmar = codEmar;
    }

    /**
     * Retorna o valor de crianca
     * @return  crianca
     */
    public Crianca getCrianca() {
	return crianca;
    }

    /**
     * @param crianca é atribuido a crianca
     */
    public void setCrianca(Crianca crianca) {
	this.crianca = crianca;
    }

    /**
     * Retorna o valor de dataFim
     * @return  dataFim
     */
    public java.util.Date getDataFim() {
	return dataFim;
    }

    /**
     * @param dataFim é atribuido a dataFim
     */
    public void setDataFim(java.util.Date dataFim) {
	this.dataFim = dataFim;
    }

    /**
     * Retorna o valor de dataInicio
     * @return  dataInicio
     */
    public java.util.Date getDataInicio() {
	return dataInicio;
    }

    /**
     * @param dataInicio é atribuido a dataInicio
     */
    public void setDataInicio(java.util.Date dataInicio) {
	this.dataInicio = dataInicio;
    }

    /**
     * Retorna o valor de remedios
     * @return  remedios
     */
    public List<Remedio> getRemedios() {
	return remedios;
    }

    /**
     * @param remedios é atribuido a remedios
     */
    public void setRemedios(List<Remedio> remedios) {
	this.remedios = remedios;
    }

    public boolean adicionarRemedios(Remedio ant) {
	return remedios.add(ant);
    }

    public boolean removerRemedios(Remedio ant) {
	return remedios.remove(ant);
    }

    public void removerTodosRemedios() {
	remedios.clear();
    }

    public Remedio getRemedio1() {
	try {
	    return remedios.get(0);
	} catch (Exception e) {
	    // TODO: handle exception
	}
	return null;
    }

    public Remedio getRemedio2() {
	try {
	    return remedios.get(1);
	} catch (Exception e) {
	    // TODO: handle exception
	}
	return null;
    }

    public Remedio getRemedio3() {
	try {
	    return remedios.get(2);
	} catch (Exception e) {
	    // TODO: handle exception
	}
	return null;

    }
    
    public String getDataInicioStr() {
	return DataUtility.dateToString(dataInicio);
    }
    
    public String getDataFinalStr() {
	return DataUtility.dateToString(dataFim);
    }
    
    public String getSituacao(){
	return ativo?"ATIVO":"DESATIVADO";
    }
    
    

}
