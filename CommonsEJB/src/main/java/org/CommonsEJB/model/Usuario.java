package org.CommonsEJB.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_USUARIO", "USERNAME"}))
@AttributeOverride(name="oid", column=@Column(name="ID_USUARIO"))
public class Usuario extends EntidadeAbstrata implements Serializable{

	private static final long serialVersionUID = -729122042918040016L;

	
	@Column(name = "NOME", nullable = false)
	private String nome_usuario;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PERFIL")
	private Perfil perfil;

	public Usuario(String username, String password) {
		this.setPassword(password);
		this.setUsername(username);
	}

	public Usuario() {
		super();
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

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	
	
	

}
