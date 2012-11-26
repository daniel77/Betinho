package org.br.apav.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import static org.br.apav.framework.Pesquisa.*;
import org.br.apav.framework.AbstractAction;
import org.br.apav.framework.Constants;
import org.br.apav.framework.DataUtility;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Padrinho;

public class PadrinhoAction extends AbstractAction {

	public void listar(HttpServletRequest request) {
		ArrayList<Padrinho> padrinhos = (ArrayList<Padrinho>) 
				pesquisa("from Padrinho");

		request.setAttribute("padrinhos", padrinhos.toArray());
	}

	public void carregar(HttpServletRequest request) {
	    	int cod = new Integer(request.getParameter("codPadrinho")).intValue();
		Padrinho padrinho = Pesquisa.carregar(Padrinho.class,cod);
		request.setAttribute("padrinho", padrinho);
	}

	public String inserir(HttpServletRequest request) {
		Padrinho padrinho = new Padrinho();
		carregarPadrinho(request, padrinho);
		padrinho.insert();
		return Constants.SUCCESS;
	}

	public String excluir(HttpServletRequest request) {
		int cod = new Integer(request.getParameter("codPadrinho")).intValue();
		Padrinho padrinho = Pesquisa.carregar(Padrinho.class,cod);
		padrinho.delete();
		return Constants.SUCCESS;
	}

	public String atualizar(HttpServletRequest request) {
		int cod = new Integer(request.getParameter("codPadrinho")).intValue();
		Padrinho padrinho = Pesquisa.carregar(Padrinho.class,cod);
		carregarPadrinho(request, padrinho);
		padrinho.update();
		return Constants.SUCCESS;
	}

	/**
	 * Método para carregar Padrinho do Form
	 * 
	 * @param request
	 * @param padrinho
	 */
	private void carregarPadrinho(HttpServletRequest request, Padrinho padrinho) {
		padrinho.setNome(request.getParameter("nome"));
		padrinho.setDataNascimento(DataUtility.stringToDate(request.getParameter("dataNascimento")));
		padrinho.setCpf(request.getParameter("cpf"));
		padrinho.setRg(request.getParameter("rg"));
		padrinho.setEndereco(request.getParameter("endereco"));
		padrinho.setTelefoneCelular(request.getParameter("telefoneCelular"));
		padrinho.setTelefoneComercial(request.getParameter("telefoneComercial"));
		padrinho.setTelefoneResidencial(request.getParameter("telefoneResidencial"));
		padrinho.setEstadoCivil(request.getParameter("estadoCivil"));
		padrinho.setSexo(request.getParameter("sexo"));
		padrinho.setCidade(request.getParameter("cidade"));
		padrinho.setUf(request.getParameter("uf"));
		padrinho.setEmail(request.getParameter("email"));
	}

	@Override
	public String caminhoAlternativo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
