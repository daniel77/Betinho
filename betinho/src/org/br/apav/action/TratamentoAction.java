package org.br.apav.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.br.apav.framework.AbstractAction;
import org.br.apav.framework.Constants;
import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Cid10;
import org.br.apav.model.Crianca;
import org.br.apav.model.Remedio;
import org.br.apav.model.Tratamento;

public class TratamentoAction extends AbstractAction {

    @Override
    public String caminhoAlternativo(HttpServletRequest request) {
	
	if("medicacao".equals(request.getParameter("event"))){
		carregar(request);
		ArrayList<Remedio> remedios = (ArrayList<Remedio>) Pesquisa
			.pesquisa("from Remedio");
		request.setAttribute("remedios", remedios.toArray());
		return "medicacao";
	}
	
	return null;
    }

    @Override
    public void carregar(HttpServletRequest request) {
	request.setAttribute("crianca", Pesquisa.carregar(Crianca.class,
		new Integer(request.getParameter("codCrianca"))));
	
	try{
	    int cod = new Integer(request.getParameter("codTratamento")).intValue();
	    Tratamento tratamento = Pesquisa.carregar(Tratamento.class, cod);
	    request.setAttribute("tratamento", tratamento);
	    request.setAttribute("cid10id", tratamento.getCid10().getCid10());
	    request.setAttribute("medicacoes", tratamento.getMedicacao());
	}catch (Exception e) {
	    // TODO: handle exception
	}
	
	
	
	listarCid10(request);

    }

    private void listarCid10(HttpServletRequest request) {
	ArrayList<Cid10> cids = (ArrayList<Cid10>)
		Pesquisa.pesquisa("from Cid10 cid where cid.descr like '%HIV%' ");
	
	request.setAttribute("cids", cids);
    }

    @Override
    public String excluir(HttpServletRequest request) {
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")).intValue());
	
	int codTratamento = new Integer(request.getParameter("codTratamento")).intValue();
	
	Tratamento tra = Pesquisa.carregar(Tratamento.class, codTratamento );
	crianca.removerTratamento(tra);
	tra.delete();
	
	
	
	return Constants.SUCCESS;
    }
    
    @Override
    public String atualizar(HttpServletRequest request) {
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")).intValue());
	
	int codTratamento = new Integer(request.getParameter("codTratamento")).intValue();
	Tratamento tra = Pesquisa.carregar(Tratamento.class, codTratamento );
	tra.setCrianca(crianca);
	
	String cid10cod = request.getParameter("cid10");
	Cid10 cid10 = Pesquisa.carregar(Cid10.class, cid10cod);
	tra.setCid10(cid10);
	
	tra.update();


	
	return Constants.SUCCESS;
    }
    

    @Override
    public String inserir(HttpServletRequest request) {
	
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")).intValue());
	
	Tratamento tra = new Tratamento();
	tra.setCrianca(crianca);
	
	String cid10cod = request.getParameter("cid10");
	Cid10 cid10 = Pesquisa.carregar(Cid10.class, cid10cod);
	tra.setCid10(cid10);
	
	tra.insert();
	crianca.adicionarTratamento(tra);
	
	return Constants.SUCCESS;
    }

    @Override
    public void listar(HttpServletRequest request) {
	
	Crianca crianca = Pesquisa.carregar(Crianca.class, new Integer(request.getParameter("codCrianca")).intValue());
	
	request.setAttribute("crianca",crianca );
	
	List<Tratamento> tratamentos = crianca.getTratamentos();
	
	listarCid10(request);
	
	request.setAttribute("tratamentos", tratamentos);
    }

}
