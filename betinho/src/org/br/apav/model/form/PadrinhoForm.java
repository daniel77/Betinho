package org.br.apav.model.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class PadrinhoForm extends ValidatorForm {

    public PadrinhoForm() {
	super();
    }

    private static final long serialVersionUID = 1L;

    private String nome;

   // private java.util.Date dataNascimento;

    /**
         * Retorna o valor de nome
         * 
         * @return nome
         */
    public String getNome() {
	return nome;
    }

    /**
         * @param nome
         *                é atribuido a nome
         */
    public void setNome(String nome) {
	this.nome = nome;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
	nome = null;
    }
}
