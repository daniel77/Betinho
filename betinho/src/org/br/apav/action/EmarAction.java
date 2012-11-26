package org.br.apav.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.br.apav.framework.AbstractAction;
import org.br.apav.framework.Constants;
import org.br.apav.framework.DataUtility;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Crianca;
import org.br.apav.model.Emar;
import org.br.apav.model.Remedio;

public class EmarAction extends AbstractAction {
    public void listar(HttpServletRequest request) {
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request
		.getParameter("codCrianca")));

	List<Emar> emars = crianca.getEmars();
	// (ArrayList<CargaViral>)pesquisa("from CargaViral");

	ArrayList<Remedio> remedios = (ArrayList<Remedio>) Pesquisa
		.pesquisa("from Remedio");

	request.setAttribute("remedios", remedios);

	request.setAttribute("crianca", crianca);
	request.setAttribute("emars", emars);
	listarCid10(request);
	
    }

    public void carregar(HttpServletRequest request) {
	request.setAttribute("crianca", Pesquisa.carregar(Crianca.class,
		new Integer(request.getParameter("codCrianca"))));

	int cod = new Integer(request.getParameter("codEmar")).intValue();
	Emar emar = Pesquisa.carregar(Emar.class, cod);

	ArrayList<Remedio> remedios = (ArrayList<Remedio>) Pesquisa
		.pesquisa("from Remedio");

	request.setAttribute("remedios", remedios);

	request.setAttribute("emar", emar);
	listarCid10(request);
    }

    public String inserir(HttpServletRequest request) {
	Emar emar = new Emar();
	carregarEmar(request, emar);
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request
		.getParameter("codCrianca")));
	crianca.adicionarEmar(emar);
	emar.insert();

	return Constants.SUCCESS;
    }

    public String excluir(HttpServletRequest request) {
	int cod = new Integer(request.getParameter("codEmar")).intValue();
	Emar emar = Pesquisa.carregar(Emar.class, cod);
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request
		.getParameter("codCrianca")));
	crianca.removerEmar(emar);
	emar.delete();
	return Constants.SUCCESS;
    }

    public String atualizar(HttpServletRequest request) {
	int cod = new Integer(request.getParameter("codEmar")).intValue();
	Emar emar = Pesquisa.carregar(Emar.class, cod);
	carregarEmar(request, emar);
	emar.update();
	return Constants.SUCCESS;
    }

    private void listarCid10(HttpServletRequest request) {
	/*ArrayList<Cid10> cids = (ArrayList<Cid10>)
		Pesquisa.pesquisa("from Cid10 cid where cid.descr like '%HIV%' ");
	
	request.setAttribute("cids", cids);*/
    }
    
    /**
     * Método para carregar Emar do Form
     * 
     * @param request
     * @param emar
     */
    private void carregarEmar(HttpServletRequest request, Emar emar) {

	emar.setCrianca(Pesquisa.carregar(Crianca.class, new Integer(request
		.getParameter("codCrianca"))));

	
	boolean ativo = Boolean.valueOf(request.getParameter("ativo"));
	
	emar.setAtivo(ativo);
	emar.setDataInicio(DataUtility.stringToDate(request
		.getParameter("dataInicio")));
	emar.setDataFim(DataUtility.stringToDate(request
		.getParameter("dataFim")));
	
	ArrayList<Remedio> remedios = new ArrayList<Remedio>();
	
	
	int remedio1 = new Integer(request.getParameter("remedio1"));
	Remedio rem1 = Pesquisa.carregar(Remedio.class, remedio1);
	remedios.add(rem1); 
	
	int remedio2 = new Integer(request.getParameter("remedio2"));
	Remedio rem2 = Pesquisa.carregar(Remedio.class, remedio2);
	remedios.add(rem2);
	
	int remedio3 = new Integer(request.getParameter("remedio3"));
	Remedio rem3 = Pesquisa.carregar(Remedio.class, remedio3);
	remedios.add(rem3);
	//emar.removerTodosRemedios();
	emar.setRemedios(remedios);
	
/*	String cid10cod = request.getParameter("cid10");
	Cid10 cid10 = Pesquisa.carregar(Cid10.class, cid10cod);
	emar.setCid10(cid10);
*/
	
	
		
    }

    @Override
    public String caminhoAlternativo(HttpServletRequest request) {
	// TODO Auto-generated method stub
	return null;
    }
}
