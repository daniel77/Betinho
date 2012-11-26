package org.br.apav.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.br.apav.framework.AbstractAction;
import org.br.apav.framework.Constants;
import org.br.apav.framework.DataUtility;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Crianca;


public class CriancaAction extends AbstractAction{
    
    private Crianca crianca;
    
    public void listar(HttpServletRequest request){
        String nomePesquisa = request.getParameter("nomePesquisa");
        ArrayList<Crianca> criancas;
        
        if(nomePesquisa != null && !"".equals(nomePesquisa)){
            criancas = Crianca.listarPorNome(nomePesquisa);
        }else { //TODO Será mesmo que precisa listar todos? ou começa em branco
            criancas = Crianca.listarTodos();
        }
        
        request.setAttribute("criancas", criancas.toArray());
    }
    
    public void carregar(HttpServletRequest request){
        crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")));
        //new Crianca( new Integer(request.getParameter("codCrianca")).intValue());
        request.setAttribute("crianca", crianca);
    }
    
    
    public String inserir(HttpServletRequest request){
        Crianca crianca = new Crianca();
        carregarCrianca(request, crianca);
        crianca.insert();
        return Constants.SUCCESS;
        
    }
    
    public String excluir(HttpServletRequest request){
        int cod = new Integer(request.getParameter("codCrianca")).intValue();
        Crianca crianca = (Crianca)Pesquisa.carregar(Crianca.class, cod);
        crianca.delete();
        return Constants.SUCCESS;
    }
    
    public String atualizar(HttpServletRequest request){
        int cod = new Integer(request.getParameter("codCrianca")).intValue();
        Crianca crianca = (Crianca)Pesquisa.carregar(Crianca.class, cod);
        carregarCrianca(request, crianca);
        crianca.update();
        return Constants.SUCCESS;
    }
    
    private void carregarCrianca(HttpServletRequest request, Crianca crianca) {
        crianca.setNome(request.getParameter("nome").toUpperCase());
        
        crianca.setDataNascimento(DataUtility.stringToDate(request.getParameter("dataNascimento")));
        
        
        crianca.setNomePai(request.getParameter("nomePai"));
        crianca.setNomeMae(request.getParameter("nomeMae"));
        crianca.setAvoMaterno(request.getParameter("avoMaterno"));
        crianca.setAvoPaterno(request.getParameter("avoPaterno"));
        crianca.setAvohMaterno(request.getParameter("avohMaterno"));
        crianca.setAvohPaterno(request.getParameter("avohPaterno"));
        crianca.setEncaminhadoPor(request.getParameter("encaminhadoPor"));
        
        
        crianca.setDataAbrigamento(DataUtility.stringToDate(request.getParameter("dataAbrigamento")));
        crianca.setDataDesabrigamento(DataUtility.stringToDate(request.getParameter("dataDesabrigamento")));
        
        crianca.setMotivoDesabrigamento(request.getParameter("motivoDesabrigamento"));
        crianca.setCertidaoNascimento(request.getParameter("certidaoNascimento"));
        crianca.setRg(request.getParameter("rg"));
        crianca.setCpf(request.getParameter("cpf"));
        crianca.setSexo(request.getParameter("sexo"));
        crianca.setCidade(request.getParameter("cidade"));
        crianca.setUf(request.getParameter("uf"));
        crianca.setCarteiraHc(request.getParameter("carteiraHc"));
        crianca.setCarteiraSus(request.getParameter("carteiraSus"));
        crianca.setTipoSanguineo(request.getParameter("tipoSanguineo"));
        crianca.setFatorRh(request.getParameter("fatorRh"));
        crianca.setCartorio(request.getParameter("cartorio"));
        crianca.setEmail(request.getParameter("email"));
    }
    
    @Override
    public String caminhoAlternativo(HttpServletRequest request) {
        if("pcr".equals(request.getParameter("event"))){
            carregar(request);
            if(crianca.getPcr() != null){
                request.setAttribute("pcr", crianca.getPcr());
                request.setAttribute("event_", "update");
            }else{
                request.setAttribute("event_", "insert");
            }
            return "pcr";
        }if("cargaviral".equals(request.getParameter("event"))){
            carregar(request);
            if(crianca.getCargaVirais()!= null){
                request.setAttribute("crianca", crianca);
                request.setAttribute("cargasVirais", crianca.getCargaVirais());
            }
            
            
            return "cargaviral";
        }if("antropometria".equals(request.getParameter("event"))){
            carregar(request);
            if(crianca.getAntropometrias()!= null){
                request.setAttribute("crianca", crianca);
                request.setAttribute("antropometrias", crianca.getAntropometrias());
            }
            
            return "antropometria";
        }if("emar".equals(request.getParameter("event"))){
            carregar(request);
            if(crianca.getEmars()!= null){
                request.setAttribute("crianca", crianca);
                request.setAttribute("emars", crianca.getEmars());
            }
            return "emar";
        }
        if("tratamento".equals(request.getParameter("event"))){
            carregar(request);
            if(crianca.getTratamentos()!= null){
                request.setAttribute("crianca", crianca);
                request.setAttribute("tratamentos", crianca.getTratamentos());
            }
            return "tratamento";
        }if("contato".equals(request.getParameter("event"))){
	    carregar(request);
	    if(crianca.getContatos()!= null){
		request.setAttribute("contato", crianca);
		request.setAttribute("contatos", crianca.getContatos());
	    }
	    return "contato";
	}
        
        
        
        
        return null;
    }
}