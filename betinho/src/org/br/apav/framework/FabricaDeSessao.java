package org.br.apav.framework;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Classe de controle de conex�o com hibernate.
 * 
 * @author Daniel Gorski
 *
 */
public class FabricaDeSessao {
	
	/**
	 * Fabrica de Sessao. 
	 */
	private static SessionFactory factory;
	
	/**
	 * ThreadLocal que controla a sess�o. 
	 */
	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	
	/**
	 * Inicia a cone��o
	 */
	static {
		try {

			System.out.println("Iniciando Aplica��o Betinho! Aguarde...");
			
			
			File f = new File(
					"C:\\Documents and Settings\\magic\\workspace\\betinho\\src\\org\\br\\apav\\model\\hibernate.cfg.xml");
			
			if (f == null)
				System.err.println("ATEN��O ARQUIVO DE CONFIGURA��O N�O ENCONTRADO!");
			
			//ExportarParaBanco.initialization(f);
			
			factory = new Configuration().configure(f).buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
			factory = null;
		}
	}
	
	/**
	 * Recupera a sessao corrente.
	 * Abre uma nova sess�o se n�o existe nenhuma. 
	 *  
	 * @return 
	 * @throws HibernateException
	 */
	public static Session getSession() throws HibernateException {
		Session s = (Session) session.get();
		if (s == null) {
			s = factory.openSession();
			session.set(s);
		}
		return s;
	}
	
	/**
	 * Finaliza a sessao 
	 * TODO: Tem que executar esse metodo na saida do hibernate
	 * @throws HibernateException
	 */
	public static void discardSession() throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null)
			s.close();
	}

/*	public static Session getSession() {
		return factory.openSession();
	}*/
}
