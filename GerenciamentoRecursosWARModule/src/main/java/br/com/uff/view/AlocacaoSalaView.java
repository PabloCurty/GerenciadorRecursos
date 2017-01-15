package br.com.uff.view;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.AlocacaoBean;
import org.CommonsEJB.SolicitacaoSalaBean;
import org.CommonsEJB.enums.StatusSolicitacao;
import org.CommonsEJB.model.Alocacao;
import org.CommonsEJB.model.SolicitacaoSala;

@ManagedBean(name="alocacaoSalaView")
@SessionScoped
public class AlocacaoSalaView {
	
	@EJB
	private AlocacaoBean alocacaoBean;
	
	@EJB
	private SolicitacaoSalaBean solicitacaoSalaBean;
	
	private List<Alocacao> alocacoes;
	
	private List<SolicitacaoSala> solicitacoes;
	
	private String selectedItem;
	
	private Date data;
	
	public void prepararAlocacoes(){
		this.setSolicitacoes(solicitacaoSalaBean.buscaTodasSolicitacoesPassandoStatus(StatusSolicitacao.CONCEDIDO));
		this.setAlocacoes(alocacaoBean.buscaTodasAlocacoes());
	}
	
	public String buscar(){
		
		if(selectedItem == null || data == null){
			return "failure";
		}
		
		//TODO
		//busca as solicitacoes e alocacoes com base no periodo entrado pelo usuario
		//utilizar selectedItem e data
		
		// call prepararAlocacao com itens recebidos da interface tratados
		prepararAlocacoes();
		
		return "success";
	}

	public AlocacaoBean getAlocacaoBean() {
		return alocacaoBean;
	}

	public void setAlocacaoBean(AlocacaoBean alocacaoBean) {
		this.alocacaoBean = alocacaoBean;
	}

	public List<Alocacao> getAlocacoes() {
		return alocacoes;
	}

	public void setAlocacoes(List<Alocacao> alocacoes) {
		this.alocacoes = alocacoes;
	}

	public List<SolicitacaoSala> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoSala> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}