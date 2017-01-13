/**
 * 
 */
package br.com.uff.view;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.CommonsEJB.UserLoginBeanInterface;
import org.CommonsEJB.model.Perfil;
import org.CommonsEJB.model.Usuario;
import org.primefaces.context.RequestContext;

/**
 * @author Pablo
 *
 */
@ManagedBean(name = "userLoginView")
@SessionScoped
public class UserLoginView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String username;

	private String password;
	
	private String perfil;
	
	@EJB
	private UserLoginBeanInterface userLoginBean;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		Usuario user;
		try {
			user = userLoginBean.login(this.username, this.password);
			this.id = user.getOid();
			this.perfil  =  user.getPerfil().getNome_perfil();
			String nome = user.getNome_usuario();
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome " + nome, this.username);
			FacesContext.getCurrentInstance().addMessage(null, message);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", this.getId());
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("perfil", this.getPerfil());
			context.addCallbackParam("loggedIn", loggedIn);
			return "success";
		} catch (Exception e) {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", loggedIn);
			return "failure";
		}

	}
	
	public String entrarSemLogin(){
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		try {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicite seu cadastro ", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("perfil", "Usuario");
			loggedIn = false;
			context.addCallbackParam("loggedIn", loggedIn);
			return "success";
		} catch (Exception e) {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Não foi possível efetuar a consulta", "Sistema fora do ar");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", loggedIn);
			return "failure";
		}
		
	}

	public String logout() {
		
		try {
			this.password = null;
			this.username = null;
			this.perfil = null;
			this.setId(null);
			// TODO verificar se eh necessario
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "success";
		} catch (Exception e) {
			return "failure";
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	
}
