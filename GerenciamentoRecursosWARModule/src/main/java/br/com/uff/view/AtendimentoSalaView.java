package br.com.uff.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.AlocacaoBean;
import org.CommonsEJB.SalaBean;
import org.CommonsEJB.SolicitacaoSalaBean;
import org.CommonsEJB.enums.DiasSemana;
import org.CommonsEJB.model.Alocacao;
import org.CommonsEJB.model.Sala;
import org.CommonsEJB.model.SolicitacaoSala;

@ManagedBean(name="atendimentoSalaBeanView")
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
	
	private String numeroSala;

	public void atender(){
		try{
			Sala sala = salaBean.buscaSalaPorNumero(numeroSala);
			selectedSol.setSala(sala);
			selectedSol = solicitacaoSalaBean.solicitar(selectedSol);
			
			String year = String.valueOf(selectedSol.getData().getYear());
			Integer mesAux = selectedSol.getData().getMonth();
			String semestre = mesAux > 6 ? "2" : "1";
			String horario = String.valueOf(selectedSol.getData().getHours());
			
			Calendar c = Calendar.getInstance();
			c.setTime(selectedSol.getData());
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			
			DiasSemana diaSemana = DiasSemana.getDiaDaSemana(dayOfWeek);
			
			List<DiasSemana> listaDias = new ArrayList<DiasSemana>();
			listaDias.add(diaSemana);
			
			Alocacao alocacao = new Alocacao(year,semestre,horario,listaDias,sala);
			
			alocacaoBean.criaAlocacao(alocacao);
			
			
			
		}
		catch(Exception e){
			
		}
		
		
		System.out.println("atendido");
	}
	
	public List<String> completeSalaComboBox(){
		
		List<String> salasString = new ArrayList<String>();
		
		List<Sala> salas = salaBean.getSalas();
		
		for(Sala sala : salas){
			salasString.add(sala.getNumero());
		}
		
		return salasString;
	}
	
	public void obtemSolicitacoes(){
		this.solicitacoes = solicitacaoSalaBean.buscaTodasSolicitacoesConcedidas();
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
		this.numeroSala = numeroSala;
	}

}