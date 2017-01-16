package org.CommonsEJB.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "REGISTRO_PROBLEMA", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_REGISTRO"}))
@AttributeOverride(name="oid", column=@Column(name="ID_REGISTRO"))
public class RegistroProblema extends EntidadeAbstrata implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6159133778817607728L;
	
	public RegistroProblema(){}
	
	public RegistroProblema(Sala sala, Equipamento equipamento, Date data, String descricao){
		this.sala = sala;
		this.equipamento = equipamento;
		this.data = data;
		this.descricao = descricao;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SALA")
	private Sala sala;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_EQUIPAMENTO")
	private Equipamento equipamento;
	
	@Column(name = "DATA", nullable = false)
	private Date data;
	
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
