package org.CommonsEJB.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.CommonsEJB.enums.DiasSemana;

@Entity
@Table(name = "ALOCACAO", uniqueConstraints = @UniqueConstraint(columnNames = { "ID_ALOCACAO" }))
@AttributeOverride(name = "oid", column = @Column(name = "ID_ALOCACAO"))
public class Alocacao extends EntidadeAbstrata implements Serializable {

	private static final long serialVersionUID = -8698953061832691450L;

	@Column(name = "ANO", nullable = false)
	private String ano;

	@Column(name = "SEMESTRE", nullable = false)
	private String semestre;

	@Column(name = "HORARIO", nullable = false)
	private String horario;

	@ElementCollection(targetClass=DiasSemana.class , fetch=FetchType.EAGER)
    @Enumerated(EnumType.STRING) 
    @Column(name="DIAS", nullable = false)
	private List<DiasSemana> dias;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_SALA")
	private Sala sala;

	public Alocacao() {

	}

	public Alocacao(String ano, String semestre, String horario, List<DiasSemana> dias, Sala sala) {
		super();
		this.ano = ano;
		this.semestre = semestre;
		this.horario = horario;
		this.dias = dias;
		this.sala = sala;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<DiasSemana> getDias() {
		return dias;
	}

	public void setDias(List<DiasSemana> dias) {
		this.dias = dias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
