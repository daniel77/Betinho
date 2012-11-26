package org.br.apav.framework;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Classe para abstração dos objetos persistiveis no banco de dados. 
 * Toda classe persistente deve obrigatóriamente herdar está classe 
 * para que possa ser feita a camada de persistencia.  
 * Est
 * 
 * @author Daniel Gorski 
 * TODO Excluir comentários no fim desta classe assim que que possivel.
 *
 */
@SuppressWarnings("unchecked")
public abstract class ObjetoPersistivel implements Serializable {
	
	

	public ObjetoPersistivel() {
	}

	/**
	 * Método para excluir este objeto
	 */
	public void delete() {
		try {
			Session sessao = FabricaDeSessao.getSession(); // Abrindo uma sessão
			Transaction transaction = sessao.beginTransaction(); // Iniciando uma
			// transação

			sessao.delete(this);
			sessao.flush();	
			transaction.commit(); // Finalizando a transação
			//sessao.close(); // Fechando a sessão

		} catch (Exception e) {
			e.printStackTrace();
			

		}

	}
	
	/**
	 * Método para inserir este objeto 
	 */
	public void insert() {
		try {

			Session sessao = FabricaDeSessao.getSession(); // Abrindo uma sessão
			Transaction transaction = sessao.beginTransaction(); // Iniciando uma
			// transação
			
			sessao.save(this.getClass().getName(), this);

			sessao.flush();	
			transaction.commit(); // Finalizando a transação
			//sessao.close(); // Fechando a sessão
		} catch (Exception e) {
			e.printStackTrace();
			

		}

	}
	
	/**
	 * Método para exclir este objeto. 
	 *
	 */
	public void update() {
		try {
			Session session = FabricaDeSessao.getSession();
			Transaction tx = session.beginTransaction();
			
			session.update(this.getClass().getName(), this);
			session.flush();	
			tx.commit();
			//session.close();
		} catch (Exception e) {
			e.printStackTrace();


		}

	}

}

/*
 * 
 * 
 * 
public Object carrssegar(Class c, String pk) {
		Session session = HibernateUtility.getSession();
		Transaction tx = session.beginTransaction();
		//Object obj = c.cast(session.load(c, pk));
		Object obj = session.get(c, pk);
		
		if(obj == null)
			obj = session.load(c, pk);
	//	tx.commit();
		//session.close();
		return obj;
	}

	public ObjetoPersistivel carregarFromHQL(Class c, String hql) {
		Session session = HibernateUtility.getSession();
		Transaction tx = session.beginTransaction();

		Query select = session.createQuery(hql.toString());

		List<? extends ObjetoPersistivel> objetos = (List<? extends ObjetoPersistivel>) select
				.list();
	//	tx.commit();
		//session.close();

		if (!objetos.isEmpty()) {
			Object obj = c.cast(objetos.get(0));
			return (ObjetoPersistivel) obj;
		}

		return null;

	}

	public Object carregar(Class c, int pk) {
		Session session = HibernateUtility.getSession();
		//Transaction tx = session.beginTransaction();
		
		Object obj = session.get(c, new Integer(pk));
		
		if(obj == null)
			obj = session.load(c, pk);
		
		 
	//	tx.commit();
		//	session.close();
		return c.cast(obj);
	}
	
		public ObjetoPersistivel(int pk) {
Session session = HibernateUtility.getSession();

Object obj = session.get(this.getClass(), new Integer(pk));

if(obj == null)
	obj = session.load(this.getClass(), pk);
	
}

public ObjetoPersistivel(String pk) {
Session session = HibernateUtility.getSession();
//	Transaction tx = session.beginTransaction();
//session.load(this, pk);
Object obj = session.get(this.getClass(), pk);

if(obj == null)
	obj = session.load(this.getClass(), pk);
//	tx.commit();
//		session.close();	
}
*/