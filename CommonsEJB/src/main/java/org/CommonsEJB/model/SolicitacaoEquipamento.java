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
@Table(name = "SOLICITACAO_EQUIPAMENTO", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_SOLICITACAO"}))
@AttributeOverride(name="oid", column=@Column(name="ID_SOLICITACAO"))
public class SolicitacaoEquipamento extends EntidadeAbstrata implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8920073542652884613L;

	@Column(name = "DATA", nullable = false)
	private Date data;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_USUARIO")
	private Usuario professor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_EQUIPAMENTO")
	private Equipamento equipamento;
	
	@Column(name = "STATUS", nullable = true)
	private boolean status;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getProfessor() {
		return professor;
	}

	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
