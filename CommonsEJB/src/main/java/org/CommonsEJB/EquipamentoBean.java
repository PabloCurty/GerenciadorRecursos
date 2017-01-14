package org.CommonsEJB;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.SolicitacaoEquipamentoDAO;
import org.CommonsEJB.model.Equipamento;
import org.CommonsEJB.model.SolicitacaoEquipamento;

@Stateless
@LocalBean
public class EquipamentoBean implements Serializable {

	/**
	 * deve checar as alocacoes de sala, solicitacoes de sala e solicitacoes de equipamento
	 */
	private static final long serialVersionUID = -3630123330471989147L;
	
	@Inject
	private SolicitacaoEquipamentoDAO solicitacaoEquipamentoDAO;
	
	private Equipamento equipamento = new Equipamento();
	
	private List<Equipamento> equipamentos;
	
	public SolicitacaoEquipamento solicitar(SolicitacaoEquipamento solicitacaoEquipamento) {
		solicitacaoEquipamento = solicitacaoEquipamentoDAO.merge(solicitacaoEquipamento);
		return solicitacaoEquipamento;
	}

	public void salvar(){}
	
	public void cadastrar(){}
	
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
