package org.br.apav.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.br.apav.framework.DataUtility;
import org.br.apav.framework.ObjetoPersistivel;
import org.br.apav.framework.Pesquisa;

public class Crianca extends ObjetoPersistivel implements Serializable {

    public Crianca() {

	nome = "";

	nomePai = "";
	nomeMae = "";
	avoMaterno = "";
	avoPaterno = "";
	avohMaterno = "";
	avohPaterno = "";
	encaminhadoPor = "";

	motivoDesabrigamento = "";
	certidaoNascimento = "";
	rg = "";
	cpf = "";
	sexo = "";
	cidade = "";
	uf = "";
	carteiraHc = "";
	carteiraSus = "";
	tipoSanguineo = "";
	fatorRh = "";
	cartorio = "";
	email = "";

    }

    private static final long serialVersionUID = 2375634237298445107L;

    private int codCrianca;

    private String nome;

    private Date dataNascimento;

    private String nomePai;

    private String nomeMae;

    private String avoMaterno;

    private String avoPaterno;

    private String avohMaterno;

    private String avohPaterno;

    private String encaminhadoPor;

    private Date dataAbrigamento;

    private Date dataDesabrigamento;

    private String motivoDesabrigamento;

    private String certidaoNascimento;

    private String rg;

    private String cpf;

    private String sexo;

    private String cidade;

    private String uf;

    private String carteiraHc;

    private String carteiraSus;

    private String tipoSanguineo;

    private String fatorRh;

    private String cartorio;

    private String email;

    private List<CargaViral> cargaVirais = new ArrayList<CargaViral>();

    private List<Contato> contatos = new ArrayList<Contato>();

    private List<Padrinho> padrinhos = new ArrayList<Padrinho>();

    private PCR myPCR;

    private List<Antropometria> antropometrias = new ArrayList<Antropometria>();

    private List<Emar> emars = new ArrayList<Emar>();

    private List<Tratamento> tratamentos = new ArrayList<Tratamento>();

    //TODO RELACIONAMENTOS ERRADOS. 

    private Contato myContato;

    public static ArrayList<Crianca> listarTodos() {
	return (ArrayList<Crianca>) Pesquisa
		.pesquisa("from Crianca order by nome");
    }

    public static ArrayList<Crianca> listarPorNome(String nome) {
	return (ArrayList<Crianca>) Pesquisa
		.pesquisa("from Crianca cri where cri.nome like '"
			+ nome.toUpperCase() + "%'");
    }

    /**
     * Retorna o valor de antropometrias
     * @return  antropometrias
     */
    public List<Antropometria> getAntropometrias() {
	return antropometrias;
    }

    /**
     * @param antropometrias é atribuido a antropometrias
     */
    public void setAntropometrias(List<Antropometria> antropometrias) {
	this.antropometrias = antropometrias;
    }

    public String getAvohMaterno() {
	return avohMaterno;
    }

    public void setAvohMaterno(String avohMaterno) {
	this.avohMaterno = avohMaterno;
    }

    public String getAvohPaterno() {
	return avohPaterno;
    }

    public void setAvohPaterno(String avohPaterno) {
	this.avohPaterno = avohPaterno;
    }

    public String getAvoMaterno() {
	return avoMaterno;
    }

    public void setAvoMaterno(String avoMaterno) {
	this.avoMaterno = avoMaterno;
    }

    public String getAvoPaterno() {
	return avoPaterno;
    }

    public void setAvoPaterno(String avoPaterno) {
	this.avoPaterno = avoPaterno;
    }

    public String getCarteiraHc() {
	return carteiraHc;
    }

    public void setCarteiraHc(String carteiraHc) {
	this.carteiraHc = carteiraHc;
    }

    public String getCarteiraSus() {
	return carteiraSus;
    }

    public void setCarteiraSus(String carteiraSus) {
	this.carteiraSus = carteiraSus;
    }

    public String getCartorio() {
	return cartorio;
    }

    public void setCartorio(String cartorio) {
	this.cartorio = cartorio;
    }

    public String getCertidaoNascimento() {
	return certidaoNascimento;
    }

    public void setCertidaoNascimento(String certidaoNascimento) {
	this.certidaoNascimento = certidaoNascimento;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public int getCodCrianca() {
	return codCrianca;
    }

    public void setCodCrianca(int codCrianca) {
	this.codCrianca = codCrianca;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public Date getDataAbrigamento() {
	return dataAbrigamento;
    }

    public void setDataAbrigamento(Date dataAbrigamento) {
	this.dataAbrigamento = dataAbrigamento;
    }

    public Date getDataDesabrigamento() {
	return dataDesabrigamento;
    }

    public void setDataDesabrigamento(Date dataDesabrigamento) {
	this.dataDesabrigamento = dataDesabrigamento;
    }

    public Date getDataNascimento() {
	return dataNascimento;
    }

    public String getDataNascimentoStr() {
	return DataUtility.dateToString(dataNascimento);
    }

    public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getEncaminhadoPor() {
	return encaminhadoPor;
    }

    public void setEncaminhadoPor(String encaminhadoPor) {
	this.encaminhadoPor = encaminhadoPor;
    }

    public String getFatorRh() {
	return fatorRh;
    }

    public void setFatorRh(String fatorRh) {
	this.fatorRh = fatorRh;
    }

    public String getMotivoDesabrigamento() {
	return motivoDesabrigamento;
    }

    public void setMotivoDesabrigamento(String motivoDesabrigamento) {
	this.motivoDesabrigamento = motivoDesabrigamento;
    }

    public Contato getMyContato() {
	return myContato;
    }

    public void setMyContato(Contato myContato) {
	this.myContato = myContato;
    }

    public PCR getPcr() {
	return myPCR;
    }

    public void setPcr(PCR myPCR) {
	this.myPCR = myPCR;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getNomeMae() {
	return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
	this.nomeMae = nomeMae;
    }

    public String getNomePai() {
	return nomePai;
    }

    public void setNomePai(String nomePai) {
	this.nomePai = nomePai;
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

    public String getTipoSanguineo() {
	return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
	this.tipoSanguineo = tipoSanguineo;
    }

    public String getUf() {
	return uf;
    }

    public void setUf(String uf) {
	this.uf = uf;
    }

    public boolean adicionarExameCargaViral(CargaViral cargaviral) {
	this.getCargaVirais();

	return cargaVirais.add(cargaviral);

    }

    public boolean removerExameCargaViral(CargaViral cargaviral) {
	return cargaVirais.remove(cargaviral);
    }

    public boolean adicionarPadrinho(Padrinho padrinho) {
	return padrinhos.add(padrinho);
    }

    public boolean removerPadrinho(Padrinho padrinho) {
	return padrinhos.remove(padrinho);
    }

    public boolean adicionarAntropometria(Antropometria ant) {
	return antropometrias.add(ant);
    }

    public boolean removerAntropometria(Antropometria ant) {
	return antropometrias.remove(ant);
    }

    public boolean adicionarTratamento(Tratamento ant) {
	return tratamentos.add(ant);
    }

    public boolean removerTratamento(Tratamento ant) {
	return tratamentos.remove(ant);
    }

    public boolean adicionarContato(Contato contato) {
	this.getContatos();

	return contatos.add(contato);

    }

    public boolean removerContato(Contato contato) {
	return contatos.remove(contato);
    }

    /**
     * Retorna o valor de cargaVirais
     * @return  cargaVirais
     */
    public List<CargaViral> getCargaVirais() {
	return cargaVirais;
    }

    /**
     * @param cargaVirais é atribuido a cargaVirais
     */
    public void setCargaVirais(List<CargaViral> cargaVirais) {
	this.cargaVirais = cargaVirais;
    }

    /**
     * Retorna o valor de padrinhos
     * @return  padrinhos
     */
    public List<Padrinho> getPadrinhos() {
	return padrinhos;
    }

    /**
     * @param padrinhos é atribuido a padrinhos
     */
    public void setPadrinhos(List<Padrinho> padrinhos) {
	this.padrinhos = padrinhos;
    }

    /**
     * @return the emars
     */
    public List<Emar> getEmars() {
	return emars;
    }

    /**
     * @param emars the emars to set
     */
    public void setEmars(List<Emar> emars) {
	this.emars = emars;
    }

    public boolean adicionarEmar(Emar emar) {
	this.getEmars();

	return emars.add(emar);

    }

    public boolean removerEmar(Emar emar) {
	return emars.remove(emar);
    }

    /**
     * Retorna o valor de tratamentos
     * @return  tratamentos
     */
    public List<Tratamento> getTratamentos() {
	return tratamentos;
    }

    /**
     * @param tratamentos é atribuido a tratamentos
     */
    public void setTratamentos(List<Tratamento> tratamentos) {
	this.tratamentos = tratamentos;
    }

    /**
     * Retorna o valor de contatos
     * @return  contatos
     */
    public List<Contato> getContatos() {
	return contatos;
    }

    /**
     * @param contatos é atribuido a contatos
     */
    public void setContatos(List<Contato> contatos) {
	this.contatos = contatos;
    }

}