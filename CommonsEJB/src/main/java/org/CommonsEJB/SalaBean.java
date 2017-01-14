package org.CommonsEJB;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.SolicitacaoSalaDAO;
import org.CommonsEJB.model.Sala;
import org.CommonsEJB.model.SolicitacaoSala;

@Stateless
@LocalBean
public class SalaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3630123330471989147L;
	
	private Sala sala;
	
	private List<Sala> salas;
	
	@Inject
	private SolicitacaoSalaDAO solicitacaoSalaDAO;

	public void salvar(){}
	
	public void cadastrar(){}
	
	public SolicitacaoSala solicitar(SolicitacaoSala solicitacaoSala){
		
		solicitacaoSala = solicitacaoSalaDAO.merge(solicitacaoSala);
		
		return solicitacaoSala;
	}
	
	public List<Sala> getSalas(){
		return this.salas;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}
