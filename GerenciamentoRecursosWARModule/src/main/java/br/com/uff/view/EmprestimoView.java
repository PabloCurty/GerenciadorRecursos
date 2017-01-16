package br.com.uff.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.EmprestimoBean;
import org.CommonsEJB.SolicitacaoSalaBean;
import org.CommonsEJB.enums.StatusEmprestimo;
import org.CommonsEJB.enums.StatusSolicitacao;
import org.CommonsEJB.enums.TipoSolicitacao;
import org.CommonsEJB.model.EmprestimoChave;
import org.CommonsEJB.model.EmprestimoEquipamento;
import org.CommonsEJB.model.SolicitacaoEquipamento;
import org.CommonsEJB.model.SolicitacaoSala;

@ManagedBean(name="emprestimoBeanView")
@SessionScoped
public class EmprestimoView {
	
	//essa classe irá concentrar tudo relacionado a emprestimo/devolucao de chave e equipamento
	//melhor do que ficar criando um bean e uma view para cada
	
	@EJB
	private EmprestimoBean emprestimoBean;
	
	@EJB
	private SolicitacaoSalaBean solicitacaoSalaBean;
	
	private EmprestimoChave selectedEmprestimoChave;
	
	private EmprestimoEquipamento selectedEmprestimoEquipamento;
	
	private List<SolicitacaoEquipamento> solicitacoesEquipamentos;
	
	private List<SolicitacaoSala> solicitacoesSalas;
	
	private List<EmprestimoChave> emprestimosChave;
	
	private List<EmprestimoEquipamento> emprestimosEquipamento;
	
	public void prepararEmprestimoDevolucaoChave(){
		
		//TODO buscar do banco as solicitacoes de sala e emprestimos concedidos de chave 
		
		solicitacoesSalas = solicitacaoSalaBean.buscaTodasSolicitacoesPassandoStatus(StatusSolicitacao.CONCEDIDO);
		
		SolicitacaoSala sol = new SolicitacaoSala();
		sol.setData(new Date());
		sol.setStatus(StatusSolicitacao.CONCEDIDO);
		sol.setRecursos("PC");
		
		solicitacoesSalas.add(sol);
	}
	
	public void prepararEmprestimoDevolucaoEquipamento(){
		//TODO buscar do banco as solicitacoes de sala e emprestimos concedidos de Equipamento
	}

	public void solicitarEmprestimoChave(){
		
		selectedEmprestimoChave.setStatus(StatusEmprestimo.AGUARDANDO_RETORNO);
		emprestimoBean.solicitarEmprestimoChave(selectedEmprestimoChave);
		//emprestimoBean.solicitarEmprestimoChave(TipoSolicitacao.EMPRESTIMO_CHAVE,selectedEmprestimoChave);
		
		System.out.println("Cadastrar");
	}
	
	public void solicitarDevolucaoChave(){
		
		emprestimoBean.solicitarDevolucaoChave(TipoSolicitacao.DEVOLUCAO_CHAVE,selectedEmprestimoChave);
		
		System.out.println("Cadastrar");
	}
	
	public void solicitarDevolucaoEquipamento(){
		
		emprestimoBean.solicitarDevolucaoEquipamento(TipoSolicitacao.DEVOLUCAO_EQUIPAMENTO,selectedEmprestimoEquipamento);
		
		System.out.println("Cadastrar");
	}
	
	public void solicitarEmprestimoEquipamento(){
		
		
		emprestimoBean.solicitarEmprestimoEquipamento(TipoSolicitacao.EMPRESTIMO_EQUIPAMENTO,selectedEmprestimoEquipamento);
		
		System.out.println("Cadastrar");
	}

	public EmprestimoBean getEmprestimoBean() {
		return emprestimoBean;
	}

	public void setEmprestimoBean(EmprestimoBean emprestimoBean) {
		this.emprestimoBean = emprestimoBean;
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

	public List<String> obtemSolicitacoesSalaComboBox(){
		List<String> lista = new ArrayList<String>();
		
		for(SolicitacaoSala sol : solicitacoesSalas){
			if(sol.getStatus() == StatusSolicitacao.CONCEDIDO){
				lista.add(""+sol.getData()+" "+sol.getRecursos()+"");
			}
		}
		return lista;
	}
	
	public List<String> obtemSolicitacoesEquipamentoComboBox(){
		List<String> lista = new ArrayList<String>();
		
		for(SolicitacaoEquipamento sol : solicitacoesEquipamentos){
			if(sol.getStatus() == StatusSolicitacao.CONCEDIDO){
				lista.add("ALGUM TEXTO QUE VOCE IDENTIFIQUE E POSSA IDENTIFICA-LO POS ESCOLHA");
			}
		}
		return lista;
	}

	public EmprestimoChave getSelectedEmprestimoChave() {
		return selectedEmprestimoChave;
	}

	public void setSelectedEmprestimoChave(EmprestimoChave selectedEmprestimoChave) {
		this.selectedEmprestimoChave = selectedEmprestimoChave;
	}

	public EmprestimoEquipamento getSelectedEmprestimoEquipamento() {
		return selectedEmprestimoEquipamento;
	}

	public void setSelectedEmprestimoEquipamento(EmprestimoEquipamento selectedEmprestimoEquipamento) {
		this.selectedEmprestimoEquipamento = selectedEmprestimoEquipamento;
	}
}