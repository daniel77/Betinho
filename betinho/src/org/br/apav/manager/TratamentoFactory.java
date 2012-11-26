package org.br.apav.manager;

import java.io.PrintWriter;
import java.util.List;

import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Crianca;
import org.br.apav.model.Tratamento;

public class TratamentoFactory {

    public static TratamentoFactory instancia(int codCrianca){
	
	if(TratamentoFactory == null){
	    TratamentoFactory = new TratamentoFactory();
	    
	}
	TratamentoFactory.crianca = Pesquisa.carregar(Crianca.class, codCrianca);	
	return TratamentoFactory;
	
    }
    
    private TratamentoFactory() {
	
	
    }
    
    static TratamentoFactory TratamentoFactory;
    Crianca crianca;
    
    public void carregarArquivo( PrintWriter out ){
	List<Tratamento> tra = crianca.getTratamentos();
	
	
	
    }
    
}
