/**
 * 
 */
package org.CommonsEJB;

import javax.ejb.Local;

import org.CommonsEJB.model.Usuario;

/**
 * @author Pablo
 *
 */
@Local
public interface UserLoginBeanInterface {

	public Usuario login(String username, String password);

}
