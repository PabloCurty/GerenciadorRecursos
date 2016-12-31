/**
 * 
 */
package org.CommonsEJB;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.LoginDAOImpl;
import org.CommonsEJB.model.Usuario;

/**
 * @author Pablo
 *
 */
@Stateless
@LocalBean
public class UserLoginBean implements Serializable {

	private static final long serialVersionUID = 6310959737543447061L;
	
	@Inject
	LoginDAOImpl loginDAO;
	
	Usuario usuario;

	public Usuario login(String username, String password) {
		
		usuario = new Usuario(username, password);
				
		return loginDAO.doLogin(usuario);
	}

}
