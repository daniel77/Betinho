package org.br.apav.model;

import java.io.Serializable;
import java.util.List;

import org.br.apav.framework.ObjetoPersistivel;

public class Padrinho extends ObjetoPersistivel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1286206805159884771L;

    public Padrinho() {
	nome = "";
	cpf = "";
	rg = "";
	endereco = "";
	bairro = "";
	telefoneResidencial = "";
	telefoneCelular = "";
	telefoneComercial = "";
	estadoCivil = "";
	sexo = "";
	cidade = "";
	uf = "";
	email = "";
    }

    private int codPadrinho;

    private String nome;

    private java.util.Date dataNascimento;

    private String cpf;

    private String rg;

    private String endereco;

    private String bairro;

    private String telefoneResidencial;

    private String telefoneCelular;

    private String telefoneComercial;

    private String estadoCivil;

    private String sexo;

    private String cidade;

    private String uf;

    private String email;

    private List<Crianca> criancas;

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

    public int getCodPadrinho() {
	return codPadrinho;
    }

    public void setCodPadrinho(int codPadrinho) {
	this.codPadrinho = codPadrinho;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public java.util.Date getDataNascimento() {
	return dataNascimento;
    }

    public void setDataNascimento(java.util.Date dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getEndereco() {
	return endereco;
    }

    public void setEndereco(String endereco) {
	this.endereco = endereco.toUpperCase();
    }

    public String getEstadoCivil() {
	return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
	this.estadoCivil = estadoCivil.toUpperCase();
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome.toUpperCase();
    }

    public String getRg() {
	return rg;
    }

    public void setRg(String rg) {
	this.rg = rg.toUpperCase();
    }

    public String getSexo() {
	return sexo;
    }

    public void setSexo(String sexo) {
	this.sexo = sexo;
    }

    public String getTelefoneCelular() {
	return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
	this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneComercial() {
	return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
	this.telefoneComercial = telefoneComercial;
    }

    public String getTelefoneResidencial() {
	return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
	this.telefoneResidencial = telefoneResidencial;
    }

    public String getUf() {
	return uf;
    }

    public void setUf(String uf) {
	this.uf = uf;
    }

    /**
     * Retorna o valor de criancas
     * @return  criancas
     */
    public List<Crianca> getCriancas() {
	return criancas;
    }

    /**
     * @param criancas é atribuido a criancas
     */
    public void setCriancas(List<Crianca> criancas) {
	this.criancas = criancas;
    }

}
