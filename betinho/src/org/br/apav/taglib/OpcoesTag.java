package org.br.apav.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class OpcoesTag extends BodyTagSupport {
	static final long serialVersionUID = 16;
	
	private String editar;
	private String incluir;
	private String excluir;


	public OpcoesTag() {
		editar = "true";
		incluir = "true";
		excluir = "true";
	}

	@Override
	public int doStartTag() throws JspException {

		javax.servlet.jsp.JspWriter out = super.pageContext.getOut();
		StringBuffer conteudo = new StringBuffer();

		conteudo
				.append("<table align=\"center\" border=\"0\"> ")
				.append("<tr>");
		if(Boolean.valueOf(incluir)){
				conteudo.append("<td align=\"center\" width=\"70\" >")
				.append("<a href=\"javascript:submitAcao('insert');\"  >")
				.append("<img src=\"imagens/b_incluir.gif\" border=\"0\" alt='Incluir um novo registro! ' ></a><br>Novo&nbsp;")
				.append("</td>");
		}
		if(Boolean.valueOf(editar)){
				conteudo.append("<td align=\"center\"  width=\"70\" >")
				.append("<a href=\"javascript:submitAcao('update');\"  >")
				.append("<img src=\"imagens/b_alterar.gif\" border=\"0\" alt='Alterar um registro!' ></a><br>Editar&nbsp;")
				.append("</td>");
		}
		if(Boolean.valueOf(excluir)){
				conteudo.append("<td align=\"center\"  width=\"70\" >")
				.append("<a href=\"javascript:submitAcao('delete');\" >")
				.append("<img src=\"imagens/b_excluir.gif\" border=\"0\" alt='Excluir um Registro!' ></a><br>Excluir&nbsp;")
				.append("</td>");
		}
		conteudo.append("</tr>").append("</table>").append("<br>");
		
		try {
			out.print(conteudo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}

	
	/**
	 * Retorna o valor de editar
	 * @return  editar
	 */
	public String getEditar() {
		return editar;
	}

	/**
	 * @param editar é atribuido a editar
	 */
	public void setEditar(String editar) {
		this.editar = editar;
	}

	/**
	 * Retorna o valor de incluir
	 * @return  incluir
	 */
	public String getIncluir() {
		return incluir;
	}

	/**
	 * @param incluir é atribuido a incluir
	 */
	public void setIncluir(String incluir) {
		this.incluir = incluir;
	}

	/**
	 * Retorna o valor de excluir
	 * @return  excluir
	 */
	public String getExcluir() {
		return excluir;
	}

	/**
	 * @param excluir é atribuido a excluir
	 */
	public void setExcluir(String excluir) {
		this.excluir = excluir;
	}	
}
