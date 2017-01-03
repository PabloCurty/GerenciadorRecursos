/**
 * 
 */
package org.CommonsEJB.DAO.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.CommonsEJB.exception.InfraestruturaException;
import org.CommonsEJB.model.EntidadeAbstrata;

/**
 * @author Pablo
 *
 */
public abstract class AbstractDAO<E extends EntidadeAbstrata> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	protected EntityManager em;
	
	protected Class<E> clazz;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void postConstruct(){
		clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public E persist(E entidade){
		try {
			em.persist(entidade);
			em.flush();
			
			return entidade;
		} catch (PersistenceException e) {
			throw new InfraestruturaException(e);
		}
	}

}
