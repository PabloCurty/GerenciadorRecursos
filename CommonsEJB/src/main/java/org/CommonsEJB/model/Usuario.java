package org.CommonsEJB.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_USUARIO", "username"}))
@SequenceGenerator(name = "SEQUENCIA_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
public class Usuario implements Serializable{

	private static final long serialVersionUID = -729122042918040016L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCIA_USUARIO")
	@Column(name = "ID_USUARIO")
	private Long id_usuario; 
	
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

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id) {
		this.id_usuario = id;
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

	
	
	

}
