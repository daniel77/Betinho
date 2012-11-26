package org.br.apav.action;

import javax.servlet.http.HttpServletRequest;

import org.br.apav.framework.AbstractAction;
import org.br.apav.framework.Constants;
import org.br.apav.framework.DataUtility;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Crianca;
import org.br.apav.model.PCR;

public class PCRAction extends AbstractAction{



	@Override
	public String inserir(HttpServletRequest request) {
		
		int cod = new Integer(request.getParameter("codCrianca")).intValue();
		
		Crianca crianca = (Crianca)Pesquisa.carregar(Crianca.class, cod);
		PCR pcr = new PCR();
		pcr.setCrianca(crianca);
		pcr.setPcr(new Boolean(request.getParameter("pcr")).booleanValue());
		pcr.setData(DataUtility.stringToDate(request.getParameter("data")));
		//
		crianca.setPcr(pcr);
		pcr.insert();
		//crianca.update();
		
		return Constants.SUCCESS;
	}

	@Override
	public void listar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String atualizar(HttpServletRequest request) {
		int cod = new Integer(request.getParameter("codCrianca")).intValue();
		
		Crianca crianca = (Crianca)Pesquisa.carregar(Crianca.class, cod);
		
		PCR pcr = (PCR)Pesquisa.carregar(PCR.class,  new Integer(request.getParameter("codPCR")).intValue());
		pcr.setCrianca(crianca);
		pcr.setPcr(new Boolean(request.getParameter("pcr")).booleanValue());
		pcr.setData(DataUtility.stringToDate(request.getParameter("data")));
		//
		crianca.setPcr(pcr);
		pcr.insert();
		//crianca.update();
		
		return Constants.SUCCESS;
	}

	@Override
	public String caminhoAlternativo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void carregar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String excluir(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
