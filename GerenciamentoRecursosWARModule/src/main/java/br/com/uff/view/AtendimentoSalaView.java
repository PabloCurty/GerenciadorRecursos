package br.com.uff.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.SalaBean;
import org.CommonsEJB.model.SolicitacaoSala;

@ManagedBean(name="atendimentoSalaBeanView")
@SessionScoped
public class AtendimentoSalaView {
	
	private List<SolicitacaoSala> solicitacoes;
	
	private SolicitacaoSala selectedSol;
	
	@EJB
	private SalaBean salaBean;
	
	public void prepararAtendimento(){
		//buscar solicitacoes de equipamento do banco
		obtemSolicitacoes();
		
		System.out.println("Preparar Solicitacao");
	}

	public void atender(){
		System.out.println("atender");
	}
	
	public void obtemSolicitacoes(){
		this.solicitacoes = new ArrayList<SolicitacaoSala>();
		SolicitacaoSala sol1 = new SolicitacaoSala();
		sol1.setData(new Date());
		this.solicitacoes.add(sol1);
	}

	public SalaBean getEquipamentoBean() {
		return salaBean;
	}

	public void setSalaBean(SalaBean salaBean) {
		this.salaBean = salaBean;
	}

	public List<SolicitacaoSala> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoSala> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public SolicitacaoSala getSelectedSol() {
		return selectedSol;
	}

	public void setSelectedSol(SolicitacaoSala selectedSol) {
		this.selectedSol = selectedSol;
	}

}