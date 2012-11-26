package org.br.apav.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import static org.br.apav.framework.Pesquisa.*;

import org.br.apav.framework.DataUtility;
import org.br.apav.framework.ObjetoPersistivel;

public class Antropometria extends ObjetoPersistivel implements Serializable {

    public Antropometria() {
       peso = "";
       altura = "";
       numeroRoupa = "";
       numeroSapato = "";
      
	
    }

    /**
         * 
         */
    private static final long serialVersionUID = 2375634237298445107L;

    private int codAntropometria;

    private Date data;

    private String peso;

    private String altura;

    private String numeroRoupa;

    private String numeroSapato;

    private Crianca crianca;

    public static ArrayList<Crianca> listarTodos() {
	return (ArrayList<Crianca>) pesquisa("from Crianca");
    }

    public static ArrayList<Antropometria> listarPorNome(int codCrianca) {
	return (ArrayList<Antropometria>) pesquisa("from Antropometria cri where cri.codCrianca = '%"
			+ codCrianca + "'");
    }

    public String getAltura() {
	return altura;
    }

    public void setAltura(String altura) {
	this.altura = altura;
    }

    public int getCodAntropometria() {
	return codAntropometria;
    }

    public void setCodAntropometria(int codAntropometria) {
	this.codAntropometria = codAntropometria;
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

    public String getNumeroRoupa() {
	return numeroRoupa;
    }

    public void setNumeroRoupa(String numeroRoupa) {
	this.numeroRoupa = numeroRoupa;
    }

    public String getNumeroSapato() {
	return numeroSapato;
    }

    public void setNumeroSapato(String numeroSapato) {
	this.numeroSapato = numeroSapato;
    }

    public String getPeso() {
	return peso;
    }

    public void setPeso(String peso) {
	this.peso = peso;
    }
    
    public String getDataExameStr() {
	return DataUtility.dateToString(this.data);
    }
}