package org.br.apav.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.br.apav.manager.AntropometriaFactory;
import org.br.apav.manager.CargaViralFactory;
import org.br.apav.model.CargaViral;

public class PublicarArquivo extends HttpServlet{

    protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("application/cvs;");
	
	String relatorio = request.getParameter("relatorio");
	
	int codCrianca = new Integer(request.getParameter("codCrianca"));
	
	if("antropometria".equals(relatorio)){
	
	    AntropometriaFactory fabrica =  AntropometriaFactory.instancia(codCrianca);	
	    fabrica.carregarArquivo(response.getWriter());
	}else if("cargaviral".equals(relatorio)){
	    CargaViralFactory fabrica = CargaViralFactory.instancia(codCrianca);
	    fabrica.carregarArquivo(response.getWriter());
	}else if("tratamento".equals(relatorio)){
	    CargaViralFactory fabrica = CargaViralFactory.instancia(codCrianca);
	    fabrica.carregarArquivo(response.getWriter());
	}
	
	
	
	
	
	
    }

}
