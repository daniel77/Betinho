package org.br.apav.model;

import java.io.Serializable;
import java.util.Date;

import org.br.apav.framework.ObjetoPersistivel;
import org.br.apav.model.Crianca;

public class PCR extends ObjetoPersistivel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codPCR;
	
	private Crianca crianca;

	private boolean pcr;

	private Date data;

	/**
	 * @return the crianca
	 */
	public Crianca getCrianca() {
		return crianca;
	}

	/**
	 * @param crianca
	 *            the crianca to set
	 */
	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the pcr
	 */
	public boolean getPcr() {
		return pcr;
	}

	/**
	 * @param pcr
	 *            the pcr to set
	 */
	public void setPcr(boolean pcr) {
		this.pcr = pcr;
	}

	public int getCodPCR() {
		return codPCR;
	}

	public void setCodPCR(int codPCR) {
		this.codPCR = codPCR;
	}

}