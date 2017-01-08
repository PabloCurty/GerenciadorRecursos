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
@Table(name = "EMPRESTIMO_CHAVE", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_EMPRESTIMO_CHAVE"}))
@AttributeOverride(name="oid", column=@Column(name="ID_EMPRESTIMO_CHAVE"))
public class EmprestimoChave extends EntidadeAbstrata implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5267785599547066024L;
	
	@Column(name = "HORA_SAIDA", nullable = false)
	private Date horaSaida;
	
	@Column(name = "HORA_RETORNO", nullable = false)
	private Date horaRetorno;
	
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SALA")
	private Sala sala;
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
