package org.CommonsEJB;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.CommonsEJB.DAO.Impl.SalaDAO;
import org.CommonsEJB.model.Sala;

@Stateless
@LocalBean
public class SalaBean implements Serializable {

	private static final long serialVersionUID = -3630123330471989147L;
	
	private Sala sala;
	
	private List<Sala> salas;
	
	@Inject
	private SalaDAO salaDAO;

	public void salvar(){}
	
	public Sala cadastrar(Sala sala2){
		sala2 = salaDAO.merge(sala2);
		return sala2;
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
