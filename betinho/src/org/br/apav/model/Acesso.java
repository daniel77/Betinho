package org.br.apav.model;

import java.util.Date;

import static org.br.apav.framework.Pesquisa.*;

import org.br.apav.framework.ObjetoPersistivel;

public class Acesso extends ObjetoPersistivel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Acesso() {

    }

    public Acesso(int codAcesso) {
	Acesso acesso = (Acesso) carregar(Acesso.class, codAcesso);
	this.setCodAcesso(acesso.getCodAcesso());
	this.setDataAcesso(acesso.getDataAcesso());
	this.setVoluntario(acesso.getVoluntario());

    }

    public boolean equals(Object obj) {

	return super.equals(obj);

    }

    private int codAcesso;

    private Date dataAcesso;

    private Voluntario voluntario;

    /**
     * 
     */

    /**
     * @return the codAcesso
     */
    public int getCodAcesso() {
	return codAcesso;
    }

    /**
     * @param codAcesso
     *                the codAcesso to set
     */
    public void setCodAcesso(int codAcesso) {
	this.codAcesso = codAcesso;
    }

    /**
     * @return the voluntario
     */
    public Voluntario getVoluntario() {
	return voluntario;
    }

    /**
     * @param voluntario
     *                the voluntario to set
     */
    public void setVoluntario(Voluntario voluntario) {
	this.voluntario = voluntario;
    }

    /**
     * @return the dataAcesso
     */
    public Date getDataAcesso() {
	return dataAcesso;
    }

    /**
     * @param dataAcesso
     *                the dataAcesso to set
     */
    public void setDataAcesso(Date dataAcesso) {
	this.dataAcesso = dataAcesso;
    }
}