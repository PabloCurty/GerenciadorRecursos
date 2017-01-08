package org.CommonsEJB.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Emprestimo {

	@Column(name = "HORA_SAIDA", nullable = false)
	private Date horaSaida;
	
	@Column(name = "HORA_RETORNO", nullable = false)
	private Date horaRetorno;
	
	@Column(name = "STATUS", nullable = false)
	private String status;

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
