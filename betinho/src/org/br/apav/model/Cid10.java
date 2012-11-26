package org.br.apav.model;

import java.io.Serializable;

import org.br.apav.framework.ObjetoPersistivel;

public class Cid10 extends ObjetoPersistivel implements Serializable {

    /**
         * 
         */
    private static final long serialVersionUID = 8477557455185280967L;

    private String cid10;

    private String opc;

    private String cat;

    private String subcat;

    private String descr;

    private String restrsexo;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return this.cid10+" - "+this.descr;
    }

    /**
         * Retorna o valor de cat
         * 
         * @return cat
         */
    public String getCat() {
	return cat;
    }

    /**
         * @param cat
         *                é atribuido a cat
         */
    public void setCat(String cat) {
	this.cat = cat;
    }

    /**
         * Retorna o valor de cid10
         * 
         * @return cid10
         */
    public String getCid10() {
	return cid10;
    }

    /**
         * @param cid10
         *                é atribuido a cid10
         */
    public void setCid10(String cid10) {
	this.cid10 = cid10;
    }

    /**
         * Retorna o valor de descr
         * 
         * @return descr
         */
    public String getDescr() {
	return descr;
    }

    /**
         * @param descr
         *                é atribuido a descr
         */
    public void setDescr(String descr) {
	this.descr = descr;
    }

    /**
         * Retorna o valor de opc
         * 
         * @return opc
         */
    public String getOpc() {
	return opc;
    }

    /**
         * @param opc
         *                é atribuido a opc
         */
    public void setOpc(String opc) {
	this.opc = opc;
    }

    /**
         * Retorna o valor de restrsexo
         * 
         * @return restrsexo
         */
    public String getRestrsexo() {
	return restrsexo;
    }

    /**
         * @param restrsexo
         *                é atribuido a restrsexo
         */
    public void setRestrsexo(String restrsexo) {
	this.restrsexo = restrsexo;
    }

    /**
         * Retorna o valor de subcat
         * 
         * @return subcat
         */
    public String getSubcat() {
	return subcat;
    }

    /**
     * @param subcat é atribuido a subcat
     */
    public void setSubcat(String subcat) {
	this.subcat = subcat;
    }

}