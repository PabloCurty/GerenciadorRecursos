/**
 * 
 */
package org.CommonsEJB;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.LoginDAOImpl;
import org.CommonsEJB.model.Usuario;

/**
 * @author Pablo
 *
 */
@Stateless
public class UserLoginBean implements Serializable, UserLoginBeanInterface {

	private static final long serialVersionUID = 6310959737543447061L;
	
	@Inject
	LoginDAOImpl loginDAO;
	
	Usuario usuario;

	@Override
	public Usuario login(String username, String password) {
		
		usuario = new Usuario(username, password);
				
		return loginDAO.doLogin(usuario);
	}
	


}
