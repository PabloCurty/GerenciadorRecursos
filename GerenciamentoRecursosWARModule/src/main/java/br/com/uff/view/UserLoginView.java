/**
 * 
 */
package br.com.uff.view;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.CommonsEJB.UserLoginBeanInterface;
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

	private UIForm form;

	@EJB
	private UserLoginBeanInterface userLoginBean;

	public UIForm getForm() {
		return form;
	}

	public void setForm(UIForm form) {
		this.form = form;
	}

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
			this.perfil = user.getPerfil().getNome_perfil();
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

	public String entrarSemLogin() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		try {
			limpaUsuario();
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicite seu cadastro ", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("perfil", "Usuario");
			loggedIn = false;
			context.addCallbackParam("loggedIn", loggedIn);
			return "success";
		} catch (Exception e) {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Não foi possível efetuar a consulta",
					"Sistema fora do ar");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", loggedIn);
			return "failure";
		}

	}

	public boolean limpaUsuario() {

		try {
			FacesContext context = FacesContext.getCurrentInstance(); 
	        context.getExternalContext().getSessionMap().remove("#{userLoginView}");
	        context.getExternalContext().getSessionMap().remove("#{menuBean}");
	        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	        session.invalidate();

			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	private boolean limpaUsuarioNobean(){
		this.setPassword(null);
		this.setUsername(null);
		this.setPerfil(null);
		this.setId(null);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", this.getId());
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("perfil", this.getPerfil());

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return true;
	}

	public String logout() {

		try {
			limpaUsuarioNobean();
			limpaUsuario();
			cleanSubmittedValues(form);
			return "success";
		} catch (Exception e) {
			return "failure";
		}
	}

	/**
	 * Limpa os dados dos componentes de edição e de seus filhos,
	 * recursivamente. Checa se o componente é instância de EditableValueHolder
	 * e 'reseta' suas propriedades.
	 * <p>
	 * Quando este método, por algum motivo, não funcionar, parta para
	 * ignorância e limpe o componente assim:
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * component.getChildren().clear()
	 * </pre>
	 * 
	 * </blockquote> :-)
	 */
	public boolean cleanSubmittedValues(UIComponent component) {

		if (component != null) {

			if (component instanceof EditableValueHolder) {
				EditableValueHolder evh = (EditableValueHolder) component;
				evh.setSubmittedValue(null);
				evh.setValue(null);
				evh.setLocalValueSet(false);
				evh.setValid(true);
			}
			if (component.getChildCount() > 0) {
				for (UIComponent child : component.getChildren()) {
					cleanSubmittedValues(child);
				}
			}
		}

		return true;
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
