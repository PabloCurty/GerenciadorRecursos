package org.CommonsEJB;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.CommonsEJB.model.Sala;

@ManagedBean
@ViewScoped
public class SalaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3630123330471989147L;
	
	private Sala sala = new Sala();
	
	private List<Sala> salas;
	
	public void prepararCadastro() {
		//sala = todas as salas do banco
	}

	public void salvar(){}
	
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
