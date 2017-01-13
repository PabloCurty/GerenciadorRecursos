/**
 * 
 */
package org.CommonsEJB.DAO.Impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.CommonsEJB.exception.DAOException;
import org.CommonsEJB.model.EntidadeAbstrata;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Pablo
 *
 */
@SuppressWarnings("unchecked")
public abstract class AbstractDAO<E extends EntidadeAbstrata> implements Repository<E>{

	private static final long serialVersionUID = 1L;
	
	private static final String MSG_ERRO_TIPO_RESULTADO = "O objeto %s não é do tipo esperado %s.";
	
	@PersistenceContext
	protected EntityManager em;
	
	protected Class<E> clazz;

	@PostConstruct
	public void postConstruct(){
		this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	/**
	 * Recupera a sessão do Hibernate.
	 *
	 * @return session Sessão do Hibernate.
	 */
	protected Session getSession() {
		return (Session) em.getDelegate();
	}

	@Override
	public E buscarPorId(String oid) {
		return em.find(clazz, oid);
	}

	@Override
	public List<E> buscarTodos() {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	@Override
	public E buscarPorIdComFetch(String oid, String... fetchProperties) {
		Criteria criteria = getSession().createCriteria(clazz).add(Restrictions.eq("oid", oid));

		for (String propriedade : fetchProperties) {
			criteria.setFetchMode(propriedade, FetchMode.JOIN);
		}

		return (E) criteria.uniqueResult();
	}


	@Override
	public E persist(E entidade) {
		try {
			em.persist(entidade);
			em.flush();

			return entidade;
		} catch (PersistenceException exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}

	@Override
	public E merge(E entidade) {
		try {
			E entidadePersistida = em.merge(entidade);
			em.flush();

			return entidadePersistida;
		} catch (PersistenceException exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}

	@Override
	public List<E> merge(List<E> entidades) {
		try {
			List<E> entidadesAtualizadas = new ArrayList<E>();
			for (E entidade : entidades) {
				em.merge(entidade);
				entidadesAtualizadas.add(entidade);
			}

			return entidadesAtualizadas;

		} catch (PersistenceException exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}

	@Override
	public void refresh(E entidade) {
		em.refresh(entidade);
	}

	@Override
	public E gravar(E entidade) {
		try {
			E entidadePersistida = entidade;

			if (entidade.getOid() == null || entidade.getOid().isEmpty()) {
				em.persist(entidade);
			} else {
				entidadePersistida = em.merge(entidade);
			}

			em.flush();

			return entidadePersistida;
		} catch (PersistenceException exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}

	@Override
	public void excluir(E entidade) {
		try {
			em.remove(entidade);
			em.flush();
		} catch (PersistenceException exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}


	/**
	 * Define o valor do parâmetro de nome paramName para null se value estiver
	 * vazio, caso contrário registra o valor de value ao parâmetro paramName
	 *
	 * @param query Query a ser manipulada
	 * @param paramName Nome do parâmetro da query a ser definida
	 * @param value Valor a ser utilizado na definição do parâmetro
	 */
	protected void setParameterQueryEmptyIsNull(Query query, String paramName, Collection<?> value) {
		if (!value.isEmpty()) {
			query.setParameter(paramName, value);
		} else {
			query.setParameter(paramName, null);
		}
	}

	/**
	 * Recupera o primeiro resultado de uma lista de resultados de consulta.
	 *
	 * @param resultList Lista de resultados de consulta
	 * @return Primeiro resultado da lista
	 */
	protected <T> T recuperarPrimeiroResultado(List<?> resultList, Class<T> tipoResultado) {
		T primeiroResultado = null;

		Object object = resultList != null && !resultList.isEmpty() ? resultList.get(0) : null;

		if (tipoResultado.isInstance(object)) {
			primeiroResultado = (T) object;
		} else if (object != null) {
			throw new DAOException(String.format(MSG_ERRO_TIPO_RESULTADO, object, tipoResultado.getName()));
		}

		return primeiroResultado;
	}


}
