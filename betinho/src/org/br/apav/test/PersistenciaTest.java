package org.br.apav.test;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Acesso;
import org.br.apav.model.Antropometria;
import org.br.apav.model.Crianca;
import org.br.apav.model.Voluntario;

public class PersistenciaTest extends TestCase {
	
	public PersistenciaTest(){
		super();
	}
	
	
	public void testCriarRelatorio(){
	   Crianca crianca = Pesquisa.carregar(Crianca.class, 435);
	   List<Antropometria> ant = crianca.getAntropometrias();
	   System.out.println(crianca.getNome());
	   for (Antropometria antropometria : ant) {
	       double imc = Math.pow(
		       Double.valueOf(antropometria.getPeso())/
		       Double.valueOf(antropometria.getAltura()), 2);
	       
	       Date datanasc = crianca.getDataNascimento();
	       Date dtHoje = new Date();
	       long dat_n = datanasc.getTime();
	       long dat_atual = dtHoje.getTime();
	       Date datadele = antropometria.getData();
	       
	       Calendar cal = Calendar.getInstance();
	       cal.setTime(datanasc);
	       
	       Calendar cal_hj = Calendar.getInstance();
	       cal_hj.setTime(datadele);
	       
	       int idade = cal_hj.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
	       
	       System.out.println(imc+","+idade+","+crianca.getCodCrianca()+","+crianca.getNome());
	       
	       
	   }
	       
	       
	    
	}
	    
	    
	
	
	
	public void testInsertVoluntario(){
		Voluntario voluntario = new Voluntario();
		voluntario.setLogin("daniel");
		voluntario.setSenha("daniel");
		voluntario.insert();
		ArrayList<Voluntario> ar = Voluntario.listagem("");
		assertTrue(ar.contains(voluntario));
	}

	public void testUpdateVoluntario(){
		Voluntario voluntario =(Voluntario)Pesquisa.carregar(Voluntario.class, "testejunit1" );
		voluntario.setSenha("oioioi");
		voluntario.update();
		assertEquals(voluntario.getSenha(),"oioioi");	
		//voluntario.();
	}
	
	public static int codAcesso;
	public void testInsertAcesso(){
		Voluntario voluntario = new Voluntario("testejunit1");
		Acesso as = new Acesso();
		as.setVoluntario(voluntario);
		as.setDataAcesso(new Date());
		as.insert();
		codAcesso = as.getCodAcesso();
	}
	
	public void testDeleteAcesso(){
		Acesso ac =(Acesso)Pesquisa.carregar(Acesso.class, codAcesso ); 
		    //new Acesso(codAcesso);
		ac.delete();
	}
	
	
	public void testDeleteVoluntario(){
		Voluntario voluntario =(Voluntario)Pesquisa.carregar(Voluntario.class, "testejunit1" );
		voluntario.delete();
	}
	
	
	static int cod = -1;
	public void testInsertCrianca(){
		Crianca cri = new Crianca();
		cri.setNome("vovo");
		cri.insert();
		
		//cri.delete();
		
		cod = cri.getCodCrianca();
		cri = null;
		Crianca crianca = (Crianca)Pesquisa.carregar(Crianca.class, cod);
		crianca.setNome("testeinioji");
		crianca.update();
	}
	
	public void testUpdateCrianca(){
	    Crianca cri =(Crianca)Pesquisa.carregar(Crianca.class, cod );
		cri.setNome("NovoNome");
		cri.update();
		assertEquals(cri.getNome(),"NovoNome");
		//voluntario.();
	}
	
	public void testDeleteCrianca(){
	    Crianca cri =(Crianca)Pesquisa.carregar(Crianca.class, cod );
		cri.setNome("NovoNome");
		cri.delete();
		try
		{
		    Pesquisa.carregar(Crianca.class, cod );
		}catch (Exception e) {
		    fail();
		}
		
		
	}
}
