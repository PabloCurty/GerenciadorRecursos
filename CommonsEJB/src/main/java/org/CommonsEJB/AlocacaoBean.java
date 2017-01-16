package org.CommonsEJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.AlocacaoDAO;
import org.CommonsEJB.model.Alocacao;

@Stateless
@LocalBean
public class AlocacaoBean implements Serializable{

	private static final long serialVersionUID = -452515628695888710L;

	@Inject
	private AlocacaoDAO alocacaoDAO;
	
	public List<Alocacao> buscaTodasAlocacoes(){
		List<Alocacao> lista = alocacaoDAO.buscarTodos();
		return lista;
	}
	
	public List<Alocacao> buscaTodasAlocacoes(Date date){
		List<Alocacao> lista = alocacaoDAO.buscarTodos();
		
		String semestre = date.getMonth() > 5 ? "2" : "1";
		
		List<Alocacao> novaLista = new ArrayList<Alocacao>();
		
		for(Alocacao al : lista){
			if(al.getAno().equals(String.valueOf(date.getYear()))
					&& al.getSemestre().equals(semestre)){
				novaLista.add(al);
			}
		}
		
		return novaLista;
	}
	
	public Alocacao criaAlocacao(Alocacao alocacao){
		return alocacaoDAO.persist(alocacao);
	}
}
