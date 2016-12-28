/**
 * 
 */
package org.CommonsEJB;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * @author Pablo
 *
 */
@Stateless
@LocalBean
public class UserLoginBean implements Serializable {

	private static final long serialVersionUID = 6310959737543447061L;

	public Long login(String username, String password) {
		// TODO Auto-generated method stub
		return new Long("1");
	}
	


}
