package br.com.uff.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.SalaBean;

@ManagedBean (name="salaBeanView")
@SessionScoped
public class SalaBeanView {
	
	@EJB
	private SalaBean salaBean;
	
	private String numero;
	
	private String capacidade;
	
	private String tipo;
	
	private String recursos;
	
	private String predio;
	
	public void prepararCadastro(){
		System.out.println("Preparar cadastro");
	}

	public void cadastrar(){
		System.out.println("Cadastrar");
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRecursos() {
		return recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public SalaBean getSalaBean() {
		return salaBean;
	}

	public void setSalaBean(SalaBean salaBean) {
		this.salaBean = salaBean;
	}

}