package org.br.apav.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.br.apav.framework.AbstractAction;
import org.br.apav.framework.Constants;
import org.br.apav.framework.DataUtility;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.CargaViral;
import org.br.apav.model.Crianca;

public class CargaViralAction extends AbstractAction {
	
	public void listar(HttpServletRequest request){
	    	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")));
	    
		List<CargaViral> cargasVirais= crianca.getCargaVirais(); 
		    //(ArrayList<CargaViral>)pesquisa("from CargaViral");
		
		request.setAttribute("crianca", crianca);
		request.setAttribute("cargasVirais", cargasVirais);
	}
	public void carregar(HttpServletRequest request){
	    	request.setAttribute("crianca",
	    		Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca"))));
	
	    	int cod = new Integer(request.getParameter("codCargaViral")).intValue();
		CargaViral cargaViral = Pesquisa.carregar(CargaViral.class, cod);
		request.setAttribute("cargaViral", cargaViral);
	}
	public String inserir(HttpServletRequest request){
		CargaViral cargaViral = new CargaViral();
		carregarCargaViral (request, cargaViral);
		Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")));
		crianca.adicionarExameCargaViral(cargaViral);
		cargaViral.insert();
		
		return Constants.SUCCESS;
	}
	public String excluir(HttpServletRequest request){
		int cod = new Integer(request.getParameter("codCargaViral")).intValue();
		CargaViral cargaViral = Pesquisa.carregar(CargaViral.class, cod);
		Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")));
		crianca.removerExameCargaViral(cargaViral);
		cargaViral.delete();
		return Constants.SUCCESS;
	}
	public String atualizar(HttpServletRequest request){
		int cod = new Integer(request.getParameter("codCargaViral")).intValue();
		CargaViral cargaViral =  Pesquisa.carregar(CargaViral.class, cod);
		carregarCargaViral (request, cargaViral);
		cargaViral.update();
		return Constants.SUCCESS;
	}
	

	/**
	 * Método para carregar Carga Viral do Form
	 * 
	 * @param request
	 * @param cargaViral
	 */
	private void carregarCargaViral(HttpServletRequest request, CargaViral cargaViral) {
		
	    	cargaViral.setCrianca(Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca"))));
	    	cargaViral.setData(DataUtility.stringToDate(request.getParameter("data")));
	    	
		cargaViral.setCd8(Integer.parseInt(request.getParameter("cd8")));
		cargaViral.setCd4(Integer.parseInt(request.getParameter("cd4")));
		cargaViral.setLog(request.getParameter("log"));
		}
	@Override
	public String caminhoAlternativo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
