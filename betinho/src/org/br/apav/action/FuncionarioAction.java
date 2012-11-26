package org.br.apav.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.br.apav.framework.*;
import org.br.apav.model.Funcionario;

public class FuncionarioAction extends AbstractAction {

	public void listar(HttpServletRequest request) {
		ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) Pesquisa
				.pesquisa("from Funcionario");

		request.setAttribute("funcionarios", funcionarios.toArray());
	}

	public void carregar(HttpServletRequest request) {
	    int cod = new Integer(request.getParameter("codFuncionario")).intValue();
		Funcionario funcionario = (Funcionario)Pesquisa.carregar(Funcionario.class, cod);
		request.setAttribute("funcionario", funcionario);
	}

	public String inserir(HttpServletRequest request) {
		Funcionario funcionario = new Funcionario();
		carregarFuncionario(request, funcionario);
		funcionario.insert();
		return Constants.SUCCESS;
	}

	public String excluir(HttpServletRequest request) {
		int cod = new Integer(request.getParameter("codFuncionario")).intValue();
		Funcionario funcionario = (Funcionario)Pesquisa.carregar(Funcionario.class, cod);
		funcionario.delete();
		return Constants.SUCCESS;
	}

	public String atualizar(HttpServletRequest request) {
		int cod = new Integer(request.getParameter("codFuncionario")).intValue();
		Funcionario funcionario =(Funcionario)Pesquisa.carregar(Funcionario.class, cod);
		carregarFuncionario(request, funcionario);
		funcionario.update();
		return Constants.SUCCESS;
	}

	/**
	 * Método para carregar Funcionario do Form
	 * 
	 * @param request
	 * @param funcionario
	 */
	private void carregarFuncionario(HttpServletRequest request, Funcionario funcionario) {
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setDataNascimento(DataUtility.stringToDate(request.getParameter("dataNascimento")));
		funcionario.setCpf(request.getParameter("cpf"));
		funcionario.setRg(request.getParameter("rg"));
		funcionario.setEndereco(request.getParameter("endereco"));
		funcionario.setTelefoneCelular(request.getParameter("telefoneCelular"));
		funcionario.setTelefoneComercial(request.getParameter("telefoneComercial"));
		funcionario.setTelefoneResidencial(request.getParameter("telefoneResidencial"));
		funcionario.setEstadoCivil(request.getParameter("estadoCivil"));
		funcionario.setSexo(request.getParameter("sexo"));
		funcionario.setCidade(request.getParameter("cidade"));
		funcionario.setUf(request.getParameter("uf"));
		funcionario.setEmail(request.getParameter("email"));
	}

	@Override
	public String caminhoAlternativo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
