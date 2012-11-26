package org.br.apav.model;

import java.io.Serializable;

import org.br.apav.framework.ObjetoPersistivel;

public class Funcionario extends ObjetoPersistivel implements Serializable {

    /**
         * 
         */

    private static final long serialVersionUID = -1286206805159884771L;

    public Funcionario() {
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


    private int codFuncionario;

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

    public String getBairro() {
	return bairro;
    }

    public void setBairro(String bairro) {
	this.bairro = bairro;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public int getCodFuncionario() {
	return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
	this.codFuncionario = codFuncionario;
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
	this.endereco = endereco;
    }

    public String getEstadoCivil() {
	return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
	this.estadoCivil = estadoCivil;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getRg() {
	return rg;
    }

    public void setRg(String rg) {
	this.rg = rg;
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

}
