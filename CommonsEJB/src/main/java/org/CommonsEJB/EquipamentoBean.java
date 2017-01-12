package org.CommonsEJB;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.CommonsEJB.model.Equipamento;

@Stateless
@LocalBean
public class EquipamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3630123330471989147L;
	
	private Equipamento equipamento = new Equipamento();
	
	private List<Equipamento> equipamentos;

	public void salvar(){}
	
	public void cadastrar(){}
	
	public void solicitar(){}
	
	public List<Equipamento> getEquipamentos(){
		return this.equipamentos;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
}
