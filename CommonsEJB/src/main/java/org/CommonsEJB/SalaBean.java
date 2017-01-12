package org.CommonsEJB;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.CommonsEJB.model.Sala;

@Stateless
@LocalBean
public class SalaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3630123330471989147L;
	
	private Sala sala = new Sala();
	
	private List<Sala> salas;

	public void salvar(){}
	
	public void cadastrar(){}
	
	public void solicitar(){}
	
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
