package br.com.uff.view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.CommonsEJB.SalaBean;
import org.CommonsEJB.model.Sala;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "salaBeanView")
@SessionScoped
public class SalaView {

	@EJB
	private SalaBean salaBean;

	private String numero;

	private String capacidade;

	private String tipo;

	private String recursos;

	private String predio;
	
	private List<String> predios;

	public void prepararCadastro() {
		System.out.println("Preparar cadastro");
	}

	public List<String> completeText() {

		predios = new ArrayList<String>();
		predios.add("COMPUTAÇÃO");
		predios.add("ENGENHARIA");
		predios.add("BIOLOGIA");
		predios.add("MATEMÁTICA");
		predios.add("SERVIÇO SOCIAL");
		return predios;
	}

	public String cadastrar() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		Sala sala;
		boolean cadIn = false;

		try {
			sala = new Sala(this.numero, this.capacidade, this.tipo, this.recursos, this.predio);
			sala = salaBean.cadastrar(sala);
			cadIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sala de numero " + sala.getNumero() + " cadastrado com sucesso ", this.numero);
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("cadIn", cadIn);
			return "/";
		} catch (Exception e) {
			cadIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de cadastro", "Cadastro inválido");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("cadIn", cadIn);
			return "/";
		}
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