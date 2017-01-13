/**
 * 
 */
package org.CommonsEJB.DAO.Impl;

import java.util.List;

import javax.persistence.Query;

import org.CommonsEJB.DAO.LoginDAOInterface;
import org.CommonsEJB.exception.InfraestruturaException;
import org.CommonsEJB.model.Usuario;

/**
 * @author Pablo
 *
 */
public class LoginDAOImpl extends AbstractDAO<Usuario> implements LoginDAOInterface {


	private static final long serialVersionUID = 4669525348150194770L;

	@Override
	public Usuario doLogin(Usuario usuarioModel) {
		try {
			Query query = em.createQuery("select u from Usuario as u where u.username = :username");
			query.setParameter("username", usuarioModel.getUsername());
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = query.getResultList();
			Usuario user = new Usuario();
			for (Usuario usuario : usuarios) {
				if(usuario.getUsername().equals(usuarioModel.getUsername()) && usuario.getPassword().equals(usuarioModel.getPassword())){
					user = usuario;
					break;
				}
			}
			
			return user;
		} catch (RuntimeException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}

	
}
