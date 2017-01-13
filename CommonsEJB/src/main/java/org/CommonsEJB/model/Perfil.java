package org.CommonsEJB.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "PERFIL", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_PERFIL", "NOME_PERFIL"}))
@AttributeOverride(name="oid", column=@Column(name="ID_PERFIL"))
public class Perfil extends EntidadeAbstrata implements Serializable{

	private static final long serialVersionUID = 5917873439974157899L;
	
	
	//TODO quando tava dando errado verificou se o tipo do atributo era PerfilType???
	//@Enumerated(EnumType.STRING)
	@Column(name = "NOME_PERFIL")
	private String nome_perfil;
	
	public Perfil(String nome_perfil) {
		super();
		this.nome_perfil = nome_perfil;
	}

	public Perfil() {
		super();
	}

	public String getNome_perfil() {
		return nome_perfil;
	}

	public void setNome_perfil(String nome_perfil) {
		this.nome_perfil = nome_perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome_perfil == null) ? 0 : nome_perfil.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (nome_perfil == null) {
			if (other.nome_perfil != null)
				return false;
		} else if (!nome_perfil.equals(other.nome_perfil))
			return false;
		return true;
	}
	
	

}
