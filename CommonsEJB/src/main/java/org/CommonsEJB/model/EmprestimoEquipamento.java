package org.CommonsEJB.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EMPRESTIMO_EQUIPAMENTO", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_EMPRESTIMO_EQUIP"}))
@AttributeOverride(name="oid", column=@Column(name="ID_EMPRESTIMO_EQUIP"))
public class EmprestimoEquipamento extends EntidadeAbstrata implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5267785599547066024L;
	
	@Embedded
	private Emprestimo emprestimo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_EQUIPAMENTO")
	private Equipamento equipamento;

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

}
