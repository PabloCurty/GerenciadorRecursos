package org.CommonsEJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.SolicitacaoEquipamentoDAO;
import org.CommonsEJB.enums.StatusSolicitacao;
import org.CommonsEJB.model.SolicitacaoEquipamento;

@Stateless
@LocalBean
public class SolicitacaoEquipamentoBean implements Serializable{

	private static final long serialVersionUID = 5529152267846960723L;

	public SolicitacaoEquipamentoBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SolicitacaoEquipamentoDAO solicitacaoEquipamentoDAO;
	
	private List<SolicitacaoEquipamento>  solicitacoesEquipamento;
	
	
	public List<SolicitacaoEquipamento> buscaTodasSolicitacoesPassandoStatus(StatusSolicitacao status){
		solicitacoesEquipamento = solicitacaoEquipamentoDAO.buscarTodos();
		List<SolicitacaoEquipamento> listaConcedidos = new ArrayList<SolicitacaoEquipamento>();
		for (SolicitacaoEquipamento s : solicitacoesEquipamento) {
			if(s.getStatus()==status){
				listaConcedidos.add(s);
			}
		}
		return listaConcedidos;
	}


	public SolicitacaoEquipamento salva(SolicitacaoEquipamento selectedSol) {
		return solicitacaoEquipamentoDAO.merge(selectedSol);
	}
	
	

}
