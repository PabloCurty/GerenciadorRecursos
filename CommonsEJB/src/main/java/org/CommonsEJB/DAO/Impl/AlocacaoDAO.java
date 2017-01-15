package org.CommonsEJB.DAO.Impl;

import java.util.Date;
import java.util.List;

import org.CommonsEJB.model.Alocacao;

public class AlocacaoDAO extends AbstractDAO<Alocacao>{

	private static final long serialVersionUID = 829615182914237284L;

	public List<Alocacao> buscarTodosPorData(Date date) {
		return this.em.createQuery("from " + Alocacao.class.getName() + " where ").getResultList();
	}
	
}
