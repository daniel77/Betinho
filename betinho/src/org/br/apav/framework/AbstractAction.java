package org.br.apav.framework;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import org.apache.struts.validator.ValidatorForm;

public abstract class AbstractAction extends Action {

    protected ValidatorForm form;
    protected MessageResources messages; 

    private Log log = LogFactory.getFactory().getInstance(
	    this.getClass().getName());

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	
        
        
	if(iniciar(mapping,request) != null){
	    return iniciar(mapping,request);
	}
	
	HttpSession session = request.getSession();
	Locale locale = getLocale(request);
	messages = getResources(request);
	//objeto = (ObjetoPersistivel) form;
	
	request.setAttribute("message", messages);
	

	// Was this transaction cancelled?
	if (isCancelled(request)) {
	    if (log.isInfoEnabled()) {
		log.info(" " + mapping.getAttribute()
			+ " - Transação cancelada");
	    }

	    removeFormBean(mapping, request);

	    return (mapping.findForward("success"));
	}

	localizacao(form, session, locale);

	String retorno;
	try {

	    // atributo setado no form
	    String perform = request.getParameter(Constants.PERFORM);

	    if (Constants.CAMINHO_ALTERNATIVO.equals(perform)) {
		retorno = this.caminhoAlternativo(request);
		return mapping.findForward(retorno);
	    }

	    if (Constants.LOAD.equals(perform)) {
		if (!Constants.INSERT.equals(request.getParameter("event"))) {
		    this.carregar(request);
		    if(Constants.DELETE.equals(request.getParameter("event"))){
			request.setAttribute("disabled", "disabled");
		    }
		}
		retorno = Constants.LOAD;
	    } else if (Constants.INSERT.equals(perform)) {
		retorno = this.inserir(request);
	    } else if (Constants.UPDATE.equals(perform)) {
		retorno = this.atualizar(request);
	    } else if (Constants.DELETE.equals(perform)) {
		retorno = this.excluir(request);
	    } else {
		retorno = Constants.LIST;
	    }

	    this.listar(request);

	} catch (Exception e) {
//	    e.printStackTrace();
	    
	    StringBuffer msg = new StringBuffer();
	    msg.append("Sessão perdida : ").append(e.getLocalizedMessage())
		    .append("<iniciar");

	    request.setAttribute("mensagem", msg);
	    retorno = Constants.FAILURE;

	    FabricaDeSessao.discardSession();
	    request.getSession(false).removeAttribute("voluntario");
	    retorno = Constants.LOGIN;
	}

	return mapping.findForward(retorno);

    }

    private void localizacao(ActionForm form, HttpSession session, Locale locale) {


	session.setAttribute(Globals.LOCALE_KEY, locale);
	
    }

    /**
     * Método para verificar o voluntário está logado na sessão.
     * 
     * @param mapping
     * @param request
     * @return se null usuario logado, senão retorna a ação para login.
     * @throws Exception
     */
    public ActionForward iniciar(ActionMapping mapping,
	    HttpServletRequest request) throws Exception {
	if (request.getSession(false).getAttribute("voluntario") == null) {
	    return mapping.findForward(org.br.apav.framework.Constants.LOGIN);
	} else {
	    return null;
	}
    }

    public abstract void listar(HttpServletRequest request);

    public abstract void carregar(HttpServletRequest obj);
    public abstract String inserir(HttpServletRequest obj);

    public abstract String excluir(HttpServletRequest request);

    public abstract String atualizar(HttpServletRequest request);

    public abstract String caminhoAlternativo(HttpServletRequest request);

    protected void removeFormBean(ActionMapping mapping,
	    HttpServletRequest request) {
	// Remover obsoletos forms
	if (mapping.getAttribute() != null) {
	    if ("request".equals(mapping.getScope())) {
		request.removeAttribute(mapping.getAttribute());
	    } else {
		HttpSession session = request.getSession();
		session.removeAttribute(mapping.getAttribute());
	    }
	}
    }
}
