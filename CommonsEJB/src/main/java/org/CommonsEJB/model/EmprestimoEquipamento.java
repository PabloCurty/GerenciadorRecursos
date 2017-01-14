package org.CommonsEJB.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.CommonsEJB.enums.StatusEmprestimo;

@Entity
@Table(name = "EMPRESTIMO_EQUIPAMENTO", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_EMPRESTIMO_EQUIP"}))
@AttributeOverride(name="oid", column=@Column(name="ID_EMPRESTIMO_EQUIP"))
public class EmprestimoEquipamento extends EntidadeAbstrata implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5267785599547066024L;
	
	@Column(name = "HORA_SAIDA", nullable = false)
	private Date horaSaida;
	
	@Column(name = "HORA_RETORNO", nullable = false)
	private Date horaRetorno;
	
	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEmprestimo status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_EQUIPAMENTO")
	private Equipamento equipamento;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SOLICITACAO")
	private SolicitacaoEquipamento solicitacao;

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Date getHoraRetorno() {
		return horaRetorno;
	}

	public void setHoraRetorno(Date horaRetorno) {
		this.horaRetorno = horaRetorno;
	}

	public StatusEmprestimo getStatus() {
		return status;
	}

	public void setStatus(StatusEmprestimo status) {
		this.status = status;
	}

	public SolicitacaoEquipamento getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoEquipamento solicitacao) {
		this.solicitacao = solicitacao;
	}

}
