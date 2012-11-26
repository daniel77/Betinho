package org.br.apav.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.br.apav.framework.AbstractAction;
import org.br.apav.framework.Constants;
import org.br.apav.framework.DataUtility;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Crianca;
import org.br.apav.model.Medicacao;
import org.br.apav.model.Remedio;
import org.br.apav.model.Tratamento;

public class MedicacaoAction extends AbstractAction {

    @Override
    public String atualizar(HttpServletRequest request) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String caminhoAlternativo(HttpServletRequest request) {
	// TODO Auto-generated method stub
	return null;
    }



    @Override
    public String excluir(HttpServletRequest request) {
	Medicacao med = Pesquisa.carregar(Medicacao.class, new Integer(request.getParameter("codMedicacao")).intValue());
	med.delete();
	Tratamento tratamento= Pesquisa.carregar(Tratamento.class, new Integer(request.getParameter("codTratamento")).intValue());
	tratamento.removerMedicacao(med);
	return Constants.SUCCESS;
    }

    @Override
    public String inserir(HttpServletRequest request) {

	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")).intValue());
	Tratamento tratamento= Pesquisa.carregar(Tratamento.class, new Integer(request.getParameter("codTratamento")).intValue());
	
	int cod = new Long(request.getParameter("codRemedio")).intValue();
	Remedio remedio = Pesquisa.carregar(Remedio.class,cod);
	
	
	
	Medicacao med = new Medicacao();
	carregarMedicacao(request, med);
	//med.setTratamento(tratamento);
	med.setRemedio(remedio);
	med.insert();
	tratamento.adicionarMedicacao(med);
	
	
	return Constants.SUCCESS;
    }

    private void carregarMedicacao(HttpServletRequest request, Medicacao med) {
	med.setDosagem(request.getParameter("dosagem"));
	med.setPoslogia(request.getParameter("poslogia"));
	med.setDataInicio(DataUtility.stringToDate(request.getParameter("dataInicio")));
	med.setDataFim(DataUtility.stringToDate(request.getParameter("dataFim")));
	

	
    }

    @Override
    public void listar(HttpServletRequest request) {
	carregar(request);
	
	ArrayList<Remedio> remedios = (ArrayList<Remedio>) Pesquisa
		.pesquisa("from Remedio");

	request.setAttribute("remedios", remedios);
	
	Tratamento tratamento= Pesquisa.carregar(Tratamento.class,
		new Integer(request.getParameter("codTratamento")).intValue());
	
	request.setAttribute("medicacoes", tratamento.getMedicacao());

    }
    
    @Override
    public void carregar(HttpServletRequest request) {
	ArrayList<Remedio> remedios = (ArrayList<Remedio>) Pesquisa
	.pesquisa("from Remedio");

	request.setAttribute("remedios", remedios);
	
	request.setAttribute("crianca", Pesquisa.carregar(Crianca.class,
		new Integer(request.getParameter("codCrianca"))));
	String event = (String)request.getParameter("event");
	try{
	    int cod = new Integer(request.getParameter("codTratamento")).intValue();
	    Tratamento tratamento = Pesquisa.carregar(Tratamento.class, cod);
	    
	    
	    request.setAttribute("tratamento", tratamento);
	    request.setAttribute("cid10id", tratamento.getCid10().getCid10());
	   
	}catch (Exception e) {
	    // TODO: handle exception
	}
	if(!"insert".equals(event))
	    {
		
	try{
	    int cod_Medicacao = new Integer(request.getParameter("codMedicacao")).intValue();
	    Medicacao medicacao = Pesquisa.carregar(Medicacao.class, cod_Medicacao);
	    request.setAttribute("medicacao", medicacao);
	}catch (Exception e) {
	    // TODO: handle exception
	}

	    }

    }

}
