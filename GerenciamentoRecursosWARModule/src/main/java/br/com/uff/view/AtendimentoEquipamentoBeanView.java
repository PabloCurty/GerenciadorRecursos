package br.com.uff.view;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.EquipamentoBean;
import org.CommonsEJB.model.SolicitacaoEquipamento;

@ManagedBean(name="atendimentoEquipamentoBeanView")
@SessionScoped
public class AtendimentoEquipamentoBeanView {
	
	@EJB
	private EquipamentoBean equipamentoBean;
	
	public void prepararAtendimento(){
		//buscar solicitacoes de equipamento do banco
		System.out.println("Preparar Solicitacao");
	}

	public void atender(){
		System.out.println("atender");
	}
	
	public List<SolicitacaoEquipamento> obtemSolicitacoes(){
		return null;
		
	}

	public EquipamentoBean getEquipamentoBean() {
		return equipamentoBean;
	}

	public void setEquipamentoBean(EquipamentoBean equipamentoBean) {
		this.equipamentoBean = equipamentoBean;
	}

}