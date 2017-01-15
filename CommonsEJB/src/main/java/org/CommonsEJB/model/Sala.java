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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SALA", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_SALA", "NUMERO"}))
@AttributeOverride(name="oid", column=@Column(name="ID_SALA"))
public class Sala extends EntidadeAbstrata implements Serializable{

	private static final long serialVersionUID = -3232143187772453046L;

	@Column(name = "NUMERO", nullable = false)
	private String numero;

	@Column(name = "CAPACIDADE", nullable = false)
	private String capacidade;
	
	@Column(name = "TIPO", nullable = false)
	private String tipo;
	
	@Column(name = "RECURSOS", nullable = false)
	private String recursos;
	
	@Column(name = "PREDIO", nullable = false)
	private String predio;
	
	@OneToMany(mappedBy="sala", cascade={CascadeType.ALL})
	@OrderBy
	@Column(name = "ALOCACAO", nullable = true)
	private Set<Alocacao> alocacao;
	
	public Sala() {
		super();
	}

	public Sala(String numero, String capacidade, String tipo, String recursos, String predio) {
		super();
		this.numero = numero;
		this.capacidade = capacidade;
		this.tipo = tipo;
		this.recursos = recursos;
		this.predio = predio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRecursos() {
		return recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}

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

	public Set<Alocacao> getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(Set<Alocacao> alocacao) {
		this.alocacao = alocacao;
	}


}
