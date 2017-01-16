package br.com.uff.view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.CommonsEJB.EquipamentoBean;
import org.CommonsEJB.SolicitacaoEquipamentoBean;
import org.CommonsEJB.enums.StatusSolicitacao;
import org.CommonsEJB.model.Equipamento;
import org.CommonsEJB.model.SolicitacaoEquipamento;
import org.primefaces.context.RequestContext;

@ManagedBean(name="atendimentoEquipamentoBeanView")
@SessionScoped
public class AtendimentoEquipamentoView {
	
	private List<SolicitacaoEquipamento> solicitacoes;
	
	private List<Equipamento> equipamentos;
	
	private SolicitacaoEquipamento selectedSol;
	
	private String tipoEquipamento;
	
	private Equipamento equipamento;
	
	@EJB
	private SolicitacaoEquipamentoBean solicitacaoEquipamentoBean;
	
	@EJB
	private EquipamentoBean equipamentoBean;
	
	public void prepararAtendimento(){
		//buscar solicitacoes de equipamento do banco
		obtemSolicitacoes();
		
		System.out.println("Preparar Solicitacao");
	}
	
	public String negar() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean atendIn = false;
		try {
		
		selectedSol.setStatus(StatusSolicitacao.NEGADO);
		selectedSol = solicitacaoEquipamentoBean.salva(selectedSol);
		
		atendIn = true;
		message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitação negada com sucesso ", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("atendIn", atendIn);
		return "/";
		} catch (Exception e) {
			atendIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao negar solicitação", "Solicitação inválida");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("atendIn", atendIn);
			return "/";
		}
	}

	public String atender(){
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean atendIn = false;
		
		try {
			selectedSol.setStatus(StatusSolicitacao.CONCEDIDO);
			for (Equipamento equipamento : equipamentos) {
				if(equipamento.getTipo().equalsIgnoreCase(tipoEquipamento)){
					this.equipamento = equipamento;
					break;
				}
			}
			selectedSol.setEquipamento(equipamento);
			selectedSol = solicitacaoEquipamentoBean.salva(selectedSol);
			
			
			atendIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Equipamento concedido com sucesso ", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("atendIn", atendIn);
			return "/";
		} catch (Exception e) {
			atendIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de conceção", "Conceção inválida");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("atendIn", atendIn);
			return "/";
		}
	}
	
	public List<String> completeEquipamentoComboBox(){
		List<String> equipamentosString = new ArrayList<String>();

		equipamentos = equipamentoBean.buscaTodosEquipamentos();

		for (Equipamento equipamento : equipamentos) {
			equipamentosString.add(equipamento.getTipo());
		}

		return equipamentosString;
	}
	
	public void obtemSolicitacoes(){
		this.solicitacoes = solicitacaoEquipamentoBean.buscaTodasSolicitacoesPassandoStatus(StatusSolicitacao.EM_ABERTO);
		/**
		 * TODO ver equipamento tipo
		 */
		//equipamento = new Equipamento();
		//equipamento.setTipo("PROJETOR");
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

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public String getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(String tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

}