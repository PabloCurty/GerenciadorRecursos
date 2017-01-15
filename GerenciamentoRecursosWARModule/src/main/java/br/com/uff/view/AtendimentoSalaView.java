package br.com.uff.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.CommonsEJB.AlocacaoBean;
import org.CommonsEJB.SalaBean;
import org.CommonsEJB.SolicitacaoSalaBean;
import org.CommonsEJB.enums.DiasSemana;
import org.CommonsEJB.enums.StatusSolicitacao;
import org.CommonsEJB.model.Alocacao;
import org.CommonsEJB.model.Sala;
import org.CommonsEJB.model.SolicitacaoSala;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "atendimentoSalaBeanView")
@SessionScoped
public class AtendimentoSalaView {

	private List<SolicitacaoSala> solicitacoes;

	private SolicitacaoSala selectedSol;

	@EJB
	private SalaBean salaBean;

	@EJB
	private SolicitacaoSalaBean solicitacaoSalaBean;

	@EJB
	private AlocacaoBean alocacaoBean;

	private Sala sala;

	private String numeroSala;
	
	public String negar(){
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean atendIn = false;
		try {
			
		
		selectedSol.setStatus(StatusSolicitacao.NEGADO);
		selectedSol = solicitacaoSalaBean.negar(selectedSol);
		
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

	public String atender() {

		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean atendIn = false;
		try {
			colocaSalaNaSolicitacao();

			Calendar c = Calendar.getInstance();
			c.setTime(selectedSol.getData());
			String year = String.valueOf(c.get(Calendar.YEAR));
			Integer mesAux = c.get(Calendar.MONTH);
			String semestre = mesAux > 5 ? "2" : "1";
			String horario = String.valueOf(selectedSol.getData().getHours());

			c.setTime(selectedSol.getData());
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			DiasSemana diaSemana = DiasSemana.getDiaDaSemana(dayOfWeek);

			List<DiasSemana> listaDias = new ArrayList<DiasSemana>();
			listaDias.add(diaSemana);
			
			selectedSol.setStatus(StatusSolicitacao.CONCEDIDO);
			selectedSol = solicitacaoSalaBean.solicitar(selectedSol);

			Alocacao alocacao = new Alocacao(year, semestre, horario, listaDias, sala);

			alocacaoBean.criaAlocacao(alocacao);

			atendIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala alocada com sucesso ", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("atendIn", atendIn);
			return "/";
		} catch (Exception e) {
			atendIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de alocação", "Alocação inválida");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("atendIn", atendIn);
			return "/";
		}
	}

	private void colocaSalaNaSolicitacao() {
		sala = salaBean.buscaSalaPorNumero(numeroSala);
		selectedSol.setSala(sala);
		selectedSol = solicitacaoSalaBean.solicitar(selectedSol);
	}

	public List<String> completeSalaComboBox() {

		List<String> salasString = new ArrayList<String>();

		List<Sala> salas = salaBean.getSalas();

		for (Sala sala : salas) {
			salasString.add(sala.getNumero());
		}

		return salasString;
	}

	public void obtemSolicitacoes() {
		this.solicitacoes = solicitacaoSalaBean.buscaTodasSolicitacoesPassandoStatus(StatusSolicitacao.EM_ABERTO);
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

	public SolicitacaoSalaBean getSolicitacaoSalaBean() {
		return solicitacaoSalaBean;
	}

	public void setSolicitacaoSalaBean(SolicitacaoSalaBean solicitacaoSalaBean) {
		this.solicitacaoSalaBean = solicitacaoSalaBean;
	}

	public String getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(String numeroSala) {
		if (numeroSala != null) {
			this.numeroSala = numeroSala;
		}
	}

}