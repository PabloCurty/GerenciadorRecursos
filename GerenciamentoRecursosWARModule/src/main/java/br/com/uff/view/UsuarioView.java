package br.com.uff.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.CommonsEJB.PerfilBean;
import org.CommonsEJB.UsuarioBeanInterface;
import org.CommonsEJB.model.Perfil;
import org.CommonsEJB.model.Usuario;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "usuarioMB")
@ViewScoped
public class UsuarioView implements Serializable {

	private static final long serialVersionUID = 6928509066244122179L;

	private String nomeUsuario;

	private String email;

	private String password;

	private String username;

	private String matricula;

	private String perfil;

	private String txt6;

	private List<String> perfilType;
	
	@EJB
	private UsuarioBeanInterface usuarioBean;
	
	@EJB
	private PerfilBean perfiBean;

	public UsuarioView() {
		
	}
	
	public String cadastraUsuario(){
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		Usuario user;
		Perfil perfil;
		boolean cadIn = false;
		
		try {
			perfil = perfiBean.pegaPerfil(this.perfil);
			user = new Usuario(this.nomeUsuario, this.email, this.password, this.username, this.matricula, perfil);
			Usuario userRetorno = usuarioBean.cadastraUsuario(user);
			cadIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario " + userRetorno.getNome_usuario() + " cadastrado com sucesso ", this.nomeUsuario);
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("cadIn", cadIn);
			return "success";
		} catch (Exception e) {
			cadIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de cadastro", "Cadastro inválido");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("cadIn", cadIn);
			return "failure";
		}
		
		
	}

	public List<String> completeText() {
		
		perfilType = new ArrayList<String>();
		perfilType.add("ADMINISTRADOR");
		perfilType.add("GERENTE");
		perfilType.add("PROFESSOR");
		perfilType.add("ASSISTENTE");

		return perfilType;
	}

	public List<String> getPerfilType() {
		return perfilType;
	}

	public void setPerfilType(List<String> perfilType) {
		this.perfilType = perfilType;
	}

	public String getTxt6() {
		return txt6;
	}

	public void setTxt6(String txt6) {
		this.txt6 = txt6;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
