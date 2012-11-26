package org.br.apav.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class BotoesTag extends BodyTagSupport {
	static final long serialVersionUID = 16;

	public BotoesTag() {

	}

	@Override
	public int doStartTag() throws JspException {

		javax.servlet.jsp.JspWriter out = super.pageContext.getOut();
		StringBuffer conteudo = new StringBuffer();

		String event = (String)super.pageContext.getRequest().getParameter("event");
		
		conteudo
				.append("<table align=\"center\">")
				.append("<tr align=\"center\">")
				.append("<td align=\"center\">")
				.append(
						":: <a href=\"javascript:submitLocal();\" >Salvar</a>&nbsp;::");
		if(!"delete".equals(event)){
				conteudo.append(
						":: <a href=\"javascript:clearForm();\"  >Limpar</a>&nbsp;::");
		 }
				conteudo.append(
						":: <a href=\"javascript:history.go(-1);\"  >Voltar</a>&nbsp;::")
				.append("</td></tr> <script> setFocus(); </script>");
		try {
			out.print(conteudo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return super.doStartTag();
	}

}
