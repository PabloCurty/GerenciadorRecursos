package org.CommonsEJB;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.UsuarioDAO;
import org.CommonsEJB.model.Usuario;

@Stateless
public class UsuarioBean implements Serializable, UsuarioBeanInterface{

	private static final long serialVersionUID = -452515628695888710L;

	@Inject
	UsuarioDAO usuarioDAO;
	
	Usuario usuario;
	
	@Override
	public Usuario cadastraUsuario(Usuario user) {
		
		usuario = usuarioDAO.persist(user);
		return usuario;
	}

}
