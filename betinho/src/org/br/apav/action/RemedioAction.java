package org.br.apav.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.br.apav.framework.AbstractAction;

import org.br.apav.framework.Constants;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Remedio;

public class RemedioAction extends AbstractAction {

    public void listar(HttpServletRequest request) {
	ArrayList<Remedio> remedios = (ArrayList<Remedio>) Pesquisa
		.pesquisa("from Remedio");

	request.setAttribute("remedios", remedios.toArray());
    }

    public void carregar(HttpServletRequest request) {
	request.setAttribute("remedio", Pesquisa.carregar(Remedio.class,
		new Integer(request.getParameter("codRemedio"))));

    }

    public String inserir(HttpServletRequest request) {
	Remedio remedio = new Remedio();
	carregarRemedio(request, remedio);
	remedio.insert();
	return Constants.SUCCESS;
    }

    public String excluir(HttpServletRequest request) {
	int cod = new Long(request.getParameter("codRemedio")).intValue();
	Remedio remedio = Pesquisa.carregar(Remedio.class,cod);
	remedio.delete();
	return Constants.SUCCESS;
    }

    public String atualizar(HttpServletRequest request) {
	int cod = new Integer(request.getParameter("codRemedio")).intValue();
	Remedio remedio = Pesquisa.carregar(Remedio.class,cod);
	carregarRemedio(request, remedio);
	remedio.update();
	return Constants.SUCCESS;
    }

    /**
         * Método para carregar Padrinho do Form
         * 
         * @param request
         * @param padrinho
         */
    private void carregarRemedio(HttpServletRequest request, Remedio remedio) {
	remedio.setEAN(request.getParameter("EAN"));
	remedio.setDescricao(request.getParameter("descricao"));
	remedio.setFormula(request.getParameter("formula"));
	remedio.setQtdeEmbalagem(Integer.parseInt(request
		.getParameter("qtdeEmbalagem")));
	remedio.setTipoQtde(request.getParameter("tipoQtde"));
    }

    @Override
    public String caminhoAlternativo(HttpServletRequest request) {
	// TODO Auto-generated method stub
	return null;
    }
}