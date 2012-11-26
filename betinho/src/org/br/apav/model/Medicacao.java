package org.br.apav.model;

//import Apadrinhamento;
import java.util.Date;

import org.br.apav.framework.DataUtility;
import org.br.apav.framework.ObjetoPersistivel;

public class Medicacao extends ObjetoPersistivel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int codMedicacao;

    private Remedio remedio;

    private String dosagem;

    private String poslogia;

    private Date horario;

    private int diasSemana;

    private Date dataInicio;

    private Date dataFim;

 //   private Tratamento tratamento;
    /**
     * Essa relação não é uma relação bidirecionao
     * trtamento possui suas medicações
     */
    
    
    public Medicacao(){
	poslogia = "";
	dosagem = "";
    }
    
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	
	return this.remedio.getDescricao()+" - "+this.poslogia;
    }

    /**
         * @return the codMedicacao
         */
    public int getCodMedicacao() {
	return codMedicacao;
    }

    /**
         * @param codMedicacao
         *                the codMedicacao to set
         */
    public void setCodMedicacao(int codMedicacao) {
	this.codMedicacao = codMedicacao;
    }


    /**
         * @return the dataInicio
         */
    public Date getDataInicio() {
	return dataInicio;
    }

    /**
         * @param dataInicio
         *                the dataInicio to set
         */
    public void setDataInicio(Date dataInicio) {
	this.dataInicio = dataInicio;
    }



    /**
         * @return the diasSemana
         */
    public int getDiasSemana() {
	return diasSemana;
    }

    /**
         * @param diasSemana
         *                the diasSemana to set
         */
    public void setDiasSemana(int diasSemana) {
	this.diasSemana = diasSemana;
    }

    /**
         * @return the dosagem
         */
    public String getDosagem() {
	return dosagem;
    }

    /**
         * @param dosagem
         *                the dosagem to set
         */
    public void setDosagem(String dosagem) {
	this.dosagem = dosagem;
    }

    /**
         * @return the horario
         */
    public Date getHorario() {
	return horario;
    }

    /**
         * @param horario
         *                the horario to set
         */
    public void setHorario(Date horario) {
	this.horario = horario;
    }


    /**
         * @return the poslogia
         */
    public String getPoslogia() {
	return poslogia;
    }

    /**
     * @param poslogia the poslogia to set
     */
    public void setPoslogia(String poslogia) {
	this.poslogia = poslogia;
    }

    /**
     * @return the remedio
     */
    public Remedio getRemedio() {
	return remedio;
    }

    /**
     * @param remedio the remedio to set
     */
    public void setRemedio(Remedio remedio) {
	this.remedio = remedio;
    }

/*    *//**
     * Retorna o valor de tratamento
     * @return  tratamento
     *//*
    public Tratamento getTratamento() {
        return tratamento;
    }

    *//**
     * @param tratamento é atribuido a tratamento
     *//*
    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }*/

    /**
     * Retorna o valor de dataFim
     * @return  dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim é atribuido a dataFim
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    

    public String getDataInicioStr() {
	return DataUtility.dateToString(dataInicio);
    }
    
    public String getDataFinalStr() {
	return DataUtility.dateToString(dataFim);
    }
    
     
}