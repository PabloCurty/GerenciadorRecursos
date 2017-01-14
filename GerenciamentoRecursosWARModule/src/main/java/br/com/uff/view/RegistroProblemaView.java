package br.com.uff.view;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.EquipamentoBean;
import org.CommonsEJB.SalaBean;

@ManagedBean(name="registroProblemaBeanView")
@SessionScoped
public class RegistroProblemaView {
	
	@EJB
	private EquipamentoBean equipamentoBean;
	
	@EJB
	private SalaBean salaBean;
	
	private String numeroSala;
	
	private String numeroEquipamento;
	
	private String descricao;
	
	public void prepararRegistro(){
		System.out.println("Preparar registro");
	}

	public void registrar(){
		
		System.out.println(numeroSala);
		System.out.println(numeroEquipamento);
		System.out.println(descricao);
		
	}
	
	public List<String> completaArea(String query){
		return null;
		
	}

	public EquipamentoBean getEquipamentoBean() {
		return equipamentoBean;
	}

	public void setEquipamentoBean(EquipamentoBean equipamentoBean) {
		this.equipamentoBean = equipamentoBean;
	}
	
	public SalaBean getSalaBean() {
		return salaBean;
	}

	public void setSalaBean(SalaBean salaBean) {
		this.salaBean = salaBean;
	}

	public String getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(String numeroSala) {
		this.numeroSala = numeroSala;
	}

	public String getNumeroEquipamento() {
		return numeroEquipamento;
	}

	public void setNumeroEquipamento(String numeroEquipamento) {
		this.numeroEquipamento = numeroEquipamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}