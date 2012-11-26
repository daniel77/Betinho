package org.br.apav.framework;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Classe para efetuar pesquisas direto no banco e
 * carregar objetos. 
 * 
 * @author Daniel Gorski 
 * email: ddeniall@gmail.com	
 *
 */
public final class Pesquisa {
	
	/**
	 * Método para carregar um único objeto.
	 * 
	 * ex.
	 * <code>
	 *   QualquerObjeto obj = (QualquerObjeto)Pesquisa.carregar(QualquerObjeto.class,int pk);
	 * </code>  
	 *  
	 * @param classe Classe do objeto a ser carregado  
	 * @param pk int chave para identificacao do mesmo 
	 * @return objeto  
	 */
	public static <E>E carregar(Class<E> c, int pk) {
		Session session = FabricaDeSessao.getSession();
		Object obj = session.get(c, new Integer(pk));
		
		if(obj == null)
			obj = session.load(c, pk);

		return c.cast(obj);
	}
	
	/**
	 * Método para carregar um único objeto.
	 *  
	 * <code>
	 *   QualquerObjeto obj = (QualquerObjeto)Pesquisa.carregar(QualquerObjeto.class,String pk);
	 * </code>
	 *  
	 * @param classe Classe do objeto a ser carregado  
	 * @param pk string chave para identificacao do mesmo 
	 * @return objeto  
	 */
	public static <E>E carregar(Class<E> c, String pk) {
		Session session = FabricaDeSessao.getSession();
		Object obj = session.get(c, pk);
		
		if(obj == null)
			obj = session.load(c, pk);

		return c.cast(obj);
	}
	
	/**
	 * Pesquisa apartir de um hql. 
	 * Para maiores informações sobre hql, ler documentação 
	 * do hibernate  
	 * 
	 * ex. 
	 * <code>
	 *  List lista =  (ArrayList<QualquerObjeto>) Pesquisa.pesquisa("from QualquerObjeto");</code>
	 * 
	 * @param hql String com hql
	 * @return listagem dos objetos
	 * @see http://www.hibernate.org
	 * 
	 *  public static <E>E carregar(Class<E> c, int pk) {
	 */
	public static List<? extends ObjetoPersistivel> pesquisa(CharSequence hql) {
		// não abre transaction
		Session sessao = FabricaDeSessao.getSession();

		Query select = sessao.createQuery(hql.toString());

		List<? extends ObjetoPersistivel> objetos = (List<? extends ObjetoPersistivel>) select.list();

		return objetos;
	}
}
