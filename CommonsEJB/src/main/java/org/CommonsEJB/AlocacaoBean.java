package org.CommonsEJB;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.AlocacaoDAO;
import org.CommonsEJB.model.Alocacao;

@Stateless
@LocalBean
public class AlocacaoBean implements Serializable{

	private static final long serialVersionUID = -452515628695888710L;

	@Inject
	private AlocacaoDAO alocacaoDAO;
	
	public List<Alocacao> buscaTodasAlocacoes(){
		List<Alocacao> lista = alocacaoDAO.buscarTodos();
		return lista;
	}
	
}
