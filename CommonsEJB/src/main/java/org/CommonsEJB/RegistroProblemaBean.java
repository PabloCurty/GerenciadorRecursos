package org.CommonsEJB;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.RegistroProblemaDAO;
import org.CommonsEJB.model.RegistroProblema;

@Stateless
@LocalBean
public class RegistroProblemaBean implements Serializable{

	private static final long serialVersionUID = -452515628695888710L;

	@Inject
	private RegistroProblemaDAO registroProblemaDAO;
	
	public List<RegistroProblema> buscaRegistros(){
		List<RegistroProblema> lista = registroProblemaDAO.buscarTodos();
		return lista;
	}
	
	public RegistroProblema criaRegistro(RegistroProblema registro){
		return registroProblemaDAO.persist(registro);
	}

	public RegistroProblemaDAO getRegistroProblemaDAO() {
		return registroProblemaDAO;
	}

	public void setRegistroProblemaDAO(RegistroProblemaDAO registroProblemaDAO) {
		this.registroProblemaDAO = registroProblemaDAO;
	}
}
