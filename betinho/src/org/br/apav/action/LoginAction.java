package org.br.apav.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.br.apav.framework.Constants;
import org.br.apav.model.Acesso;
import org.br.apav.model.Voluntario;
import org.hibernate.ObjectNotFoundException;

public class LoginAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm arg1,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");

	String sair = request.getParameter("perform");

	if ("sair".equals(sair)) {
	    request.getSession(false).removeAttribute("voluntario");
	    return mapping.findForward(Constants.LOAD);
	}

	if (login == null || "".equals(login)) {
	    return mapping.findForward(Constants.LOAD);
	}
	try {
	    Voluntario vol = new Voluntario(login);

	    if (senha.equals(vol.getSenha())) {
		request.getSession(true).setAttribute("voluntario", vol);
		Acesso as = new Acesso();
		as.setVoluntario(vol);
		as.setDataAcesso(new Date());
		as.insert();
		return mapping.findForward(Constants.SUCCESS);
	    } else {
		request.setAttribute("erro", "1");
		request.getSession().removeAttribute("voluntario");
		return mapping.findForward(Constants.FAILURE);
	    }
	} catch (ObjectNotFoundException e) {
	    request.setAttribute("erro", "1");
	    return mapping.findForward(Constants.FAILURE);

	}

    }

}
