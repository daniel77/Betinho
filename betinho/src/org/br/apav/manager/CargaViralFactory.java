package org.br.apav.manager;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Antropometria;
import org.br.apav.model.CargaViral;
import org.br.apav.model.Crianca;

public class CargaViralFactory {

    public static CargaViralFactory instancia(int codCrianca){
	
	if(caragviralFactory == null){
	    caragviralFactory = new CargaViralFactory();
	    
	}
	caragviralFactory.crianca = Pesquisa.carregar(Crianca.class, codCrianca);	
	return caragviralFactory;
	
    }
    
    private CargaViralFactory() {
	
    }
	
	
    
    static CargaViralFactory caragviralFactory;
    Crianca crianca;

    ArrayList<Byte> conteudo = new ArrayList<Byte>();
	   
    File arquivo;
	   
    
    public void carregarArquivo( PrintWriter out ){
	
		

	   
	   
	   String nomeArquivo = "";
	   nomeArquivo = crianca.getNome();
	   arquivo = new File("",new Date()+nomeArquivo+"_antropometria.cvs");
	   
	    try{
	       
	List<CargaViral> ant = crianca.getCargaVirais();	
	   
	   for (CargaViral viral : ant) {
	 
	
	       
	       String b = new String(viral.getCd4()+","+viral.getCd8()+","+viral.getDataExameStr()+","
		       +crianca.getCodCrianca()+
		       ","+crianca.getNome()+"\n");

	       
		       
		out.write(b);
		
		
	           
	   }
	   out.close();
	   
	    
		   }catch (Exception e) {
			e.printStackTrace();
		    }
		   
		   	   
	   
	
    }

    
}
