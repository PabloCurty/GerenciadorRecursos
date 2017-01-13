package br.com.uff.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.EquipamentoBean;

@ManagedBean(name="solicitacaoEquipamentoBeanView")
@SessionScoped
public class SolicitacaoEquipamentoView {
	
	@EJB
	private EquipamentoBean equipamentoBean;
	
	private String tipo;
	
	public void prepararSolicitacao(){
		System.out.println("Preparar Solicitacao");
	}

	public void solicitar(){
		System.out.println("solicitar");
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public EquipamentoBean getEquipamentoBean() {
		return equipamentoBean;
	}

	public void setEquipamentoBean(EquipamentoBean equipamentoBean) {
		this.equipamentoBean = equipamentoBean;
	}

}