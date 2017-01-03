package org.CommonsEJB.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.CommonsEJB.util.PerfilType;


@Entity
@Table(name = "PERFIL")
@AttributeOverride(name="oid", column=@Column(name="ID_PERFIL"))
public class Perfil extends EntidadeAbstrata implements Serializable{

	private static final long serialVersionUID = 5917873439974157899L;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NOME_PERFIL")
	private PerfilType nome_perfil;
	
	/** TODO colocar lista de usuarios e ver se não vai ficar infinito **/
	@OneToMany(mappedBy="perfil", cascade={CascadeType.ALL})
	@OrderBy
	private Set<Usuario> usuarios;
	
	public Perfil() {
		super();
	}

	public PerfilType getNome_perfil() {
		return nome_perfil;
	}

	public void setNome_perfil(PerfilType nome_perfil) {
		this.nome_perfil = nome_perfil;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
