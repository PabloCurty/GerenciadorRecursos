package org.CommonsEJB;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.PerfilDAO;
import org.CommonsEJB.model.Perfil;

@LocalBean
@Stateless
public class PerfilBean implements Serializable{
	
	private static final long serialVersionUID = -4054397467271377511L;
	
	@Inject
	PerfilDAO perfilDAO;
	
	public Perfil pegaPerfil(String nome){
		return perfilDAO.buscaPerfilPorNome(nome);
	}

}
