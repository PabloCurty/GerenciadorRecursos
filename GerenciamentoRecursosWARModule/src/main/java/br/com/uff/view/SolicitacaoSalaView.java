package br.com.uff.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.SalaBean;

@ManagedBean (name="solicitacaoSalaBeanView")
@SessionScoped
public class SolicitacaoSalaView {
	
	@EJB
	private SalaBean salaBean;
	
	private String capacidade;
	
	private String recursos;
	
	public void prepararSolicitacao(){
		System.out.println("Preparar Solicitacao");
	}

	public void solicitar(){
		System.out.println("solicitar");
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getRecursos() {
		return recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}

	public SalaBean getSalaBean() {
		return salaBean;
	}

	public void setSalaBean(SalaBean salaBean) {
		this.salaBean = salaBean;
	}

}