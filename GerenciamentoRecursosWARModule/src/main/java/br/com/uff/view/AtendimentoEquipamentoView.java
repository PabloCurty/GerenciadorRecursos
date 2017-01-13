package br.com.uff.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.EquipamentoBean;
import org.CommonsEJB.model.SolicitacaoEquipamento;

@ManagedBean(name="atendimentoEquipamentoBeanView")
@SessionScoped
public class AtendimentoEquipamentoView {
	
	private List<SolicitacaoEquipamento> solicitacoes;
	
	private SolicitacaoEquipamento selectedSol;
	
	@EJB
	private EquipamentoBean equipamentoBean;
	
	public void prepararAtendimento(){
		//buscar solicitacoes de equipamento do banco
		obtemSolicitacoes();
		
		System.out.println("Preparar Solicitacao");
	}

	public void atender(){
		System.out.println("atender");
	}
	
	public void obtemSolicitacoes(){
		this.solicitacoes = new ArrayList<SolicitacaoEquipamento>();
		SolicitacaoEquipamento sol1 = new SolicitacaoEquipamento();
		sol1.setData(new Date());
		this.solicitacoes.add(sol1);
	}

	public EquipamentoBean getEquipamentoBean() {
		return equipamentoBean;
	}

	public void setEquipamentoBean(EquipamentoBean equipamentoBean) {
		this.equipamentoBean = equipamentoBean;
	}

	public List<SolicitacaoEquipamento> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoEquipamento> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public SolicitacaoEquipamento getSelectedSol() {
		return selectedSol;
	}

	public void setSelectedSol(SolicitacaoEquipamento selectedSol) {
		this.selectedSol = selectedSol;
	}

}