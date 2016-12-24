/**
 * 
 */
package br.com.uff.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

/**
 * @author Pablo
 *
 */
@ManagedBean(name = "userLoginView")
@SessionScoped
public class UserLoginView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String password;

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

		if (this.username != null && this.username.equals("admin") && this.password != null && this.password.equals("admin")) {
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", loggedIn);
			return "success";
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", loggedIn);
			return "failure";
		}
	}

	public String logout() {
		this.password = null;
		this.username = null;
		this.setId(null);
		// TODO verificar se eh necessario
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login.xhtml";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
