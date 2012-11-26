package org.br.apav.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.br.apav.framework.AbstractAction;
import org.br.apav.framework.Constants;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Contato;
import org.br.apav.model.Crianca;

public class ContatoAction extends AbstractAction {
	
	
	public void listar(HttpServletRequest request){
		Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")));
	    
		List<Contato> contatos= crianca.getContatos(); 
		    //(ArrayList<CargaViral>)pesquisa("from CargaViral");
		
		request.setAttribute("crianca", crianca);
		request.setAttribute("contatos", contatos);
	}
	
	
	public void carregar(HttpServletRequest request){
	    
		request.setAttribute("crianca",
	    		Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca"))));
	
	    	int cod = new Integer(request.getParameter("codContato")).intValue();
		Contato contato = Pesquisa.carregar(Contato.class, cod);
		request.setAttribute("contato", contato);
	}
	
	public String inserir(HttpServletRequest request){
		Contato contato = new Contato();
		carregarContato(request, contato);
		Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")));
		crianca.adicionarContato(contato);
		contato.insert();
		return Constants.SUCCESS;

	}
	public String excluir(HttpServletRequest request){
		int cod = new Integer(request.getParameter("codContato")).intValue();
		Contato contato = Pesquisa.carregar(Contato.class, cod);
		Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")));
		crianca.removerContato(contato);
		contato.delete();
		return Constants.SUCCESS;
	}
	
	public String atualizar(HttpServletRequest request){
		int cod = new Integer(request.getParameter("codContato")).intValue();
		Contato contato =  Pesquisa.carregar(Contato.class, cod);
		carregarContato(request, contato);
		contato.update();
		return Constants.SUCCESS;
	}
	
	/**
	 * Método para carregar Padrinho do Form
	 * 
	 * @param request
	 * @param padrinho
	 */
	private void carregarContato(HttpServletRequest request, Contato contato) {
		

    	contato.setCrianca(Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca"))));
		contato.setNome(request.getParameter("nome"));
		contato.setParentesco(request.getParameter("parentesco"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setBairro(request.getParameter("bairro"));
		contato.setCidade(request.getParameter("cidade"));
		contato.setUf(request.getParameter("uf"));
		contato.setTelefoneResidencial(request.getParameter("telefoneResidencial"));
		contato.setTelefoneCelular(request.getParameter("telefoneCelular"));

		
	}


	@Override
	public String caminhoAlternativo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
