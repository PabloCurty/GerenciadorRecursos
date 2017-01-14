package org.CommonsEJB;

import javax.ejb.Local;

import org.CommonsEJB.model.Usuario;

@Local
public interface UsuarioBeanInterface {

	public Usuario cadastraUsuario(Usuario user);

	public Usuario pegaUsuario(String id);
}
