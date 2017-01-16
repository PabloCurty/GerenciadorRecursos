package br.com.uff.view;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.CommonsEJB.EquipamentoBean;
import org.CommonsEJB.RegistroProblemaBean;
import org.CommonsEJB.SalaBean;
import org.CommonsEJB.model.Equipamento;
import org.CommonsEJB.model.RegistroProblema;
import org.CommonsEJB.model.Sala;

@ManagedBean(name="registroProblemaBeanView")
@RequestScoped
public class RegistroProblemaView {
	
	@EJB
	private RegistroProblemaBean registroProblemaBean;
	
	@EJB
	private SalaBean salaBean;
	
	@EJB
	private EquipamentoBean equipamentoBean;
	
	private List<RegistroProblema> listaRegistros;
	
	private String numeroSala;
	
	private String numeroEquipamento;
	
	private String descricao;
	
	private String[] selectedProblemas;
	
	public void prepararRegistro(){
		listaRegistros = registroProblemaBean.buscaRegistros();
	}

	public void registrar(){
		
		Sala sala = salaBean.buscaSalaPorNumero(numeroSala);
		
		Equipamento equipamento = equipamentoBean.buscaEquipamentoPorNumero(numeroEquipamento);
		
		RegistroProblema registro = new RegistroProblema(sala, equipamento, new Date(), descricao);
		
		registroProblemaBean.criaRegistro(registro);
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

	public String[] getSelectedProblemas() {
		return selectedProblemas;
	}

	public void setSelectedProblemas(String[] selectedProblemas) {
		this.selectedProblemas = selectedProblemas;
	}

	public List<RegistroProblema> getListaRegistros() {
		return listaRegistros;
	}

	public void setListaRegistros(List<RegistroProblema> listaRegistros) {
		this.listaRegistros = listaRegistros;
	}

}