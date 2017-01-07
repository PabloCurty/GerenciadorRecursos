package org.CommonsEJB.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SALA", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_SALA", "SALA"}))
@AttributeOverride(name="oid", column=@Column(name="ID_SALA"))
public class Sala extends EntidadeAbstrata implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3232143187772453046L;

	@Column(name = "NUMERO", nullable = false)
	private String numero;

	@Column(name = "CAPACIDADE", nullable = false)
	private String capacidade;
	
	@Column(name = "PREDIO", nullable = false)
	private String predio;
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

}
