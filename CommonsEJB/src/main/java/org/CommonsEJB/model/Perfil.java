package org.CommonsEJB.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name = "PERFIL")
@AttributeOverride(name="oid", column=@Column(name="ID_PERFIL"))
public class Perfil extends EntidadeAbstrata implements Serializable{

	private static final long serialVersionUID = 5917873439974157899L;
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCIA_PERFIL")
	@Column(name = "ID_PERFIL")
	private Long id;*/
	
	@Column(name = "NOME_PERFIL")
	private String nome_perfil;
	
	/** TODO colocar lista de usuarios e ver se não vai ficar infinito **/
	@OneToMany(mappedBy="perfil", cascade={CascadeType.ALL})
	@OrderBy
	private Set<Usuario> usuarios;
	
	public Perfil() {
		super();
	}

	public String getNome_perfil() {
		return nome_perfil;
	}

	public void setNome_perfil(String nome_perfil) {
		this.nome_perfil = nome_perfil;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}