package org.CommonsEJB;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.CommonsEJB.enums.TipoSolicitacao;
import org.CommonsEJB.model.EmprestimoChave;
import org.CommonsEJB.model.EmprestimoEquipamento;
import org.CommonsEJB.model.SolicitacaoEquipamento;
import org.CommonsEJB.model.SolicitacaoSala;

@Stateless
@LocalBean
public class EmprestimoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3630123330471989147L;
	
	private List<SolicitacaoEquipamento> solicitacoesEquipamentos;
	
	private List<SolicitacaoSala> solicitacoesSalas;
	
	private List<EmprestimoChave> emprestimosChave;
	
	private List<EmprestimoEquipamento> emprestimosEquipamento;
	
	public void solicitarEmprestimoEquipamento(TipoSolicitacao tipoSolicitacao, EmprestimoEquipamento selectedEmprestimoEquipamento){
		
		switch(tipoSolicitacao){
			case DEVOLUCAO_CHAVE:
				break;
			case DEVOLUCAO_EQUIPAMENTO:
				break;
			case EMPRESTIMO_CHAVE:
				break;
			case EMPRESTIMO_EQUIPAMENTO:
				break;
			default:
				break;
			
		}
		
	}
	
	public void solicitarEmprestimoChave(TipoSolicitacao tipoSolicitacao, EmprestimoChave selectedEmprestimoChave){
		
		switch(tipoSolicitacao){
			case DEVOLUCAO_CHAVE:
				break;
			case DEVOLUCAO_EQUIPAMENTO:
				break;
			case EMPRESTIMO_CHAVE:
				break;
			case EMPRESTIMO_EQUIPAMENTO:
				break;
			default:
				break;
			
		}
		
	}
	
	public void solicitarDevolucaoChave(TipoSolicitacao tipoSolicitacao, EmprestimoChave selectedEmprestimoChave){
		
		switch(tipoSolicitacao){
			case DEVOLUCAO_CHAVE:
				break;
			case DEVOLUCAO_EQUIPAMENTO:
				break;
			case EMPRESTIMO_CHAVE:
				break;
			case EMPRESTIMO_EQUIPAMENTO:
				break;
			default:
				break;
			
		}
		
	}
	
	public void solicitarDevolucaoEquipamento(TipoSolicitacao tipoSolicitacao, EmprestimoEquipamento selectedEmprestimoEquipamento){
		
		switch(tipoSolicitacao){
			case DEVOLUCAO_CHAVE:
				break;
			case DEVOLUCAO_EQUIPAMENTO:
				break;
			case EMPRESTIMO_CHAVE:
				break;
			case EMPRESTIMO_EQUIPAMENTO:
				break;
			default:
				break;
			
		}
		
	}

	public List<SolicitacaoEquipamento> getSolicitacoesEquipamentos() {
		return solicitacoesEquipamentos;
	}

	public void setSolicitacoesEquipamentos(List<SolicitacaoEquipamento> solicitacoesEquipamentos) {
		this.solicitacoesEquipamentos = solicitacoesEquipamentos;
	}

	public List<SolicitacaoSala> getSolicitacoesSalas() {
		return solicitacoesSalas;
	}

	public void setSolicitacoesSalas(List<SolicitacaoSala> solicitacoesSalas) {
		this.solicitacoesSalas = solicitacoesSalas;
	}

	public List<EmprestimoChave> getEmprestimosChave() {
		return emprestimosChave;
	}

	public void setEmprestimosChave(List<EmprestimoChave> emprestimosChave) {
		this.emprestimosChave = emprestimosChave;
	}

	public List<EmprestimoEquipamento> getEmprestimosEquipamento() {
		return emprestimosEquipamento;
	}

	public void setEmprestimosEquipamento(List<EmprestimoEquipamento> emprestimosEquipamento) {
		this.emprestimosEquipamento = emprestimosEquipamento;
	}
	public void solicitarDevolucao(TipoSolicitacao devolucaoEquipamento) {
		// TODO Auto-generated method stub
		
	}
	
}
