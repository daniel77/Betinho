package org.br.apav.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.br.apav.framework.AbstractAction;
import org.br.apav.framework.Constants;
import org.br.apav.framework.DataUtility;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Antropometria;
import org.br.apav.model.Crianca;

public class AntropometriaAction extends AbstractAction {

    public void listar(HttpServletRequest request) {
	// ArrayList<Antropometria> antropometrias= (ArrayList<Antropometria>)
	// Antropometria.pesquisa(" select a from Antropometria a ");

	// request.setAttribute("antropometrias", antropometrias.toArray());
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request
		.getParameter("codCrianca")));

	List<Antropometria> antropometrias = crianca.getAntropometrias();
	// (ArrayList<CargaViral>)pesquisa("from CargaViral");

	request.setAttribute("crianca", crianca);
	request.setAttribute("antropometrias", antropometrias);
    }

    public void carregar(HttpServletRequest request) {
	request.setAttribute("crianca", Pesquisa.carregar(Crianca.class,
		new Integer(request.getParameter("codCrianca"))));

	int cod = new Integer(request.getParameter("codAntropometria"))
		.intValue();
	Antropometria antropometria = Pesquisa.carregar(Antropometria.class,
		cod);
	request.setAttribute("antropometria", antropometria);

    }

    public String inserir(HttpServletRequest request) {
	Antropometria antropometria = new Antropometria();
	carregarAntropometria(request, antropometria);
	antropometria.insert();

	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request
		.getParameter("codCrianca")));
	crianca.adicionarAntropometria(antropometria);

	return Constants.SUCCESS;

    }

    public String excluir(HttpServletRequest request) {
	int cod = new Integer(request.getParameter("codAntropometria"))
		.intValue();
	Antropometria antropometria = Pesquisa.carregar(Antropometria.class,
		cod);
	antropometria.delete();
	
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request
		.getParameter("codCrianca")));
	crianca.removerAntropometria(antropometria);
	
	return Constants.SUCCESS;
    }

    public String atualizar(HttpServletRequest request) {
	int cod = new Integer(request.getParameter("codAntropometria"))
		.intValue();
	Antropometria antropometria = Pesquisa.carregar(Antropometria.class,
		cod);
	carregarAntropometria(request, antropometria);
	antropometria.update();
	return Constants.SUCCESS;
    }

    /**
         * Método para carregar Antropometria do Form
         * 
         * @param request
         * @param antropometria
         */
    private void carregarAntropometria(HttpServletRequest request,
	    Antropometria antropometria) {

	antropometria.setData(DataUtility.stringToDate(request
		.getParameter("data")));
	antropometria.setCrianca(Pesquisa.carregar(Crianca.class, new Integer(
		request.getParameter("codCrianca"))));
	antropometria.setPeso(request.getParameter("peso"));
	antropometria.setAltura(request.getParameter("altura"));
	antropometria.setNumeroRoupa(request.getParameter("numeroRoupa"));
	antropometria.setNumeroSapato(request.getParameter("numeroSapato"));

    }

    @Override
    public String caminhoAlternativo(HttpServletRequest request) {
	return null;
    }
}
