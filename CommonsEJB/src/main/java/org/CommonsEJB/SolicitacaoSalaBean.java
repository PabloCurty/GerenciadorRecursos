package org.CommonsEJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.SolicitacaoSalaDAO;
import org.CommonsEJB.enums.StatusSolicitacao;
import org.CommonsEJB.model.SolicitacaoSala;

@Stateless
@LocalBean
public class SolicitacaoSalaBean implements Serializable {

	private static final long serialVersionUID = -3630123330471989147L;
	
	@Inject
	private SolicitacaoSalaDAO solicitacaoSalaDAO;
	
	public SolicitacaoSala solicitar(SolicitacaoSala solicitacaoSala){
		
		solicitacaoSala = solicitacaoSalaDAO.merge(solicitacaoSala);
		
		return solicitacaoSala;
	}
	
	public List<SolicitacaoSala> buscaTodasSolicitacoesPassandoStatus(StatusSolicitacao status){
		List<SolicitacaoSala> lista = solicitacaoSalaDAO.buscarTodos();
		List<SolicitacaoSala> listaConcedidos = new ArrayList<SolicitacaoSala>();
		for(SolicitacaoSala s : lista){
			if(s.getStatus()==status){
				listaConcedidos.add(s);
			}
		}
		return listaConcedidos;
	}

	public SolicitacaoSala negar(SolicitacaoSala selectedSol) {
		return solicitacaoSalaDAO.merge(selectedSol);
	}
	
	
}
