package org.CommonsEJB.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EQUIPAMENTO", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_EQUIPAMENTO","NUMERO"}))
@AttributeOverride(name="oid", column=@Column(name="ID_EQUIPAMENTO"))
public class Equipamento extends EntidadeAbstrata implements Serializable{


	private static final long serialVersionUID = -1547210011731613009L;
	
	@Column(name = "STATUS", nullable = true)
	private String status;
	
	@Column(name = "NUMERO", nullable = false)
	private String numero;
	
	@Column(name = "DESCRICAO", nullable = true)
	private String descricao;
	
	@Column(name = "TIPO", nullable = false)
	private String tipo;

	public Equipamento() {
		super();
	}

	public Equipamento(String numero, String tipo) {
		super();
		this.numero = numero;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
