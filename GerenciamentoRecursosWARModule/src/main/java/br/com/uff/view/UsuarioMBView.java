package br.com.uff.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "usuarioMB")
@ViewScoped
public class UsuarioMBView implements Serializable {

	private static final long serialVersionUID = 6928509066244122179L;

	private String nomeUsuario;

	private String email;

	private String password;

	private String username;

	private String matricula;

	private String perfil;

	private String txt6;

	private List<String> perfilType;

	public UsuarioMBView() {
		perfilType = new ArrayList<String>();
		perfilType.add("ADMINISTRADOR");
		perfilType.add("GERENTE");
		perfilType.add("PROFESSOR");
		perfilType.add("ASSISTENTE");
	}

	public List<String> completeText() {

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
