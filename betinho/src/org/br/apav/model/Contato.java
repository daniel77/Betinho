package org.br.apav.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.br.apav.framework.ObjetoPersistivel;
import org.br.apav.framework.Pesquisa;

public class Contato extends ObjetoPersistivel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1286206805159884771L;

    public Contato() {
	nome = "";

	parentesco = "";

	endereco = "";

	bairro = "";

	cidade = "";

	uf = "";

	telefoneResidencial = "";

	telefoneCelular = "";
    }

    private int codContato;

    private String nome;

    private String parentesco;

    private String endereco;

    private String bairro;

    private String cidade;

    private String uf;

    private String telefoneResidencial;

    private String telefoneCelular;

    private Crianca crianca;

    public static ArrayList<Contato> listarTodos() {
	return (ArrayList<Contato>) Pesquisa.pesquisa("from Contato");
    }

    public Crianca getCrianca() {
	return crianca;
    }

    public void setCrianca(Crianca crianca) {
	this.crianca = crianca;
    }

    public String getBairro() {
	return bairro;
    }

    public void setBairro(String bairro) {
	this.bairro = bairro.toUpperCase();
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade.toUpperCase();
    }

    public int getCodContato() {
	return codContato;
    }

    public void setCodContato(int codContato) {
	this.codContato = codContato;
    }

    public String getEndereco() {
	return endereco;
    }

    public void setEndereco(String endereco) {
	this.endereco = endereco.toUpperCase();
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome.toUpperCase();
    }

    public String getTelefoneCelular() {
	return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
	this.telefoneCelular = telefoneCelular.toUpperCase();
    }

    public String getTelefoneResidencial() {
	return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
	this.telefoneResidencial = telefoneResidencial.toUpperCase();
    }

    public String getUf() {
	return uf;
    }

    public void setUf(String uf) {
	this.uf = uf.toUpperCase();
    }

    /**
     * @return the parentesco
     */
    public String getParentesco() {
	return parentesco;
    }

    /**
     * @param parentesco the parentesco to set
     */
    public void setParentesco(String parentesco) {
	this.parentesco = parentesco.toUpperCase();
    }

}
