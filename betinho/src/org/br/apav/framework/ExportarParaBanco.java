package org.br.apav.framework;

import java.io.File;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;



public class ExportarParaBanco {
	



	    /** We use this session factory to create our sessions */
	    public static org.hibernate.SessionFactory sessionFactory;

	    public static void main(String[] args)
	    {
	    	File f = new File(
			"C:\\Documents and Settings\\magic\\workspace\\betinho\\src\\org\\br\\apav\\model\\hibernate.cfg.xml");
	        initialization(f);
	    }

	    /**
	     * Loads the Hibernate configuration information, sets up
	     * the database and the Hibernate session factory.
	     */
	    public static void initialization(File f)
	    {
	        System.out.println("Atualizando Tabelas Banco de Dados");
	        try
	        {
	        	
	            Configuration myConfiguration = new
	                 Configuration();
	            
	            myConfiguration.configure(f);

	 
	            // Load the *.hbm.xml files as set in the
	            // config, and set the dialect.
	            new SchemaUpdate(myConfiguration)
	                    .execute(true, true);

	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }


}
