package org.CommonsEJB;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.UsuarioDAO;
import org.CommonsEJB.model.Usuario;

@Stateless
@LocalBean
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = -452515628695888710L;

	@Inject
	UsuarioDAO usuarioDAO;
	
	public Usuario cadastraUsuario() {
		
		
		return null;
	}

}
