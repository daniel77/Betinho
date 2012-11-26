package org.br.apav.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.br.apav.framework.Constants;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Crianca;
import org.br.apav.model.Emar;
import org.br.apav.model.Remedio;
import org.br.apav.model.Tratamento;


public class RelatoriosAction extends Action {



    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	
	
	String perform = request.getParameter(Constants.PERFORM);
	String relatorioRetorno = "";
	
	if("relCriancas".equals(perform)){
	    //criar aqui metodos... 
	    relatorioRetorno = listarCriancas(request);
	}else if("relContatos".equals(perform)){
	    relatorioRetorno = listarContatos(request);
	}else if("cid10".equals(perform)){
	    relatorioRetorno = listarCid(request);
	}else if("emar".equals(perform)){
	    relatorioRetorno = listarEmar(request);
	}else if("tratamentos".equals(perform)){
	    relatorioRetorno = listarTratamentos(request);
	}
	
	return mapping.findForward(relatorioRetorno);
	
	
    }

    private String listarTratamentos(HttpServletRequest request) {
	String relatorioRetorno;
	
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request
		.getParameter("codCrianca")));
	
	List<Tratamento> tra = crianca.getTratamentos();
	
	request.setAttribute("crianca", crianca);
	request.setAttribute("tratamentos", tra);
	
	return "relTratamento";
    }
    
    private String listarEmar(HttpServletRequest request) {
	String relatorioRetorno;
	
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request
		.getParameter("codCrianca")));

	List<Emar> emars = crianca.getEmars();
	// (ArrayList<CargaViral>)pesquisa("from CargaViral");

	ArrayList<Remedio> remedios = (ArrayList<Remedio>) Pesquisa
		.pesquisa("from Remedio");

	request.setAttribute("remedios", remedios);

	request.setAttribute("crianca", crianca);
	request.setAttribute("emars", emars);

	relatorioRetorno = "relEmar";
	return relatorioRetorno;
    }
    

    private String listarCriancas(HttpServletRequest request) {
	String relatorioRetorno;
	//senao existir metodo de pesquisa ..
	//utilizar hql .. capitulo 15 do livro referencia... 
	//atraves do metodo Pesquisa.pesquis...
	ArrayList<Crianca> criancas = Crianca.listarTodos();
	request.setAttribute("criancas", criancas);
	relatorioRetorno = "relCriancas";
	return relatorioRetorno;
    }
    
    private String listarContatos(HttpServletRequest request) {
	String relatorioRetorno;
	
	request.setAttribute("contatos", Pesquisa.pesquisa("from Contato"));
	relatorioRetorno = "relContatos";
	return relatorioRetorno;
    }
    
    private String listarCid(HttpServletRequest request) {
	String relatorioRetorno;
	
	request.setAttribute("cids", Pesquisa.pesquisa("from Cid10"));
	relatorioRetorno = "cid10";
	return relatorioRetorno;
    }
    
    
}