package org.br.apav.model;

import java.util.ArrayList;
import java.util.List;

import org.br.apav.framework.ObjetoPersistivel;

public class Tratamento extends ObjetoPersistivel {

    /**
         * 
         */
    private static final long serialVersionUID = 1L;

    private int codTratamento;

    private List<Medicacao> medicacao = new ArrayList<Medicacao>();// array

    // n medicacoes a crianca tomar varios remedios
    // cada remedio eh medicacao
    // pq tem data e hora.. tudo posologo

    private Crianca crianca;

    private Cid10 cid10;

    // tratar a doenca

    /**
         * @return the cid10
         */
    public Cid10 getCid10() {
	return cid10;
    }

    /**
         * @param cid10
         *                the cid10 to set
         */
    public void setCid10(Cid10 cid10) {
	this.cid10 = cid10;
    }

    /**
         * @return the crianca
         */
    public Crianca getCrianca() {
	return crianca;
    }

    /**
         * @param crianca
         *                the crianca to set
         */
    public void setCrianca(Crianca crianca) {
	this.crianca = crianca;
    }

    /**
         * Retorna o valor de medicacao
         * 
         * @return medicacao
         */
    public List<Medicacao> getMedicacao() {
	return medicacao;
    }

    /**
         * @param medicacao
         *                é atribuido a medicacao
         */
    public void setMedicacao(List<Medicacao> medicacao) {
	this.medicacao = medicacao;
    }

    /**
         * Retorna o valor de codTratamento
         * 
         * @return codTratamento
         */
    public int getCodTratamento() {
	return codTratamento;
    }

    /**
         * @param codTratamento
         *                é atribuido a codTratamento
         */
    public void setCodTratamento(int codTratamento) {
	this.codTratamento = codTratamento;
    }

    public boolean adicionarMedicacao(Medicacao tra) {
	return medicacao.add(tra);
    }

    public boolean removerMedicacao(Medicacao med) {
	return medicacao.remove(med);
    }

}