package br.com.uff.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.EquipamentoBean;

@ManagedBean(name="equipamentoBeanView")
@SessionScoped
public class EquipamentoBeanView {
	
	@EJB
	private EquipamentoBean equipamentoBean;
	
	private String numero;
	
	private String status;
	
	private String descricao;
	
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

	public EquipamentoBean getEquipamentoBean() {
		return equipamentoBean;
	}

	public void setEquipamentoBean(EquipamentoBean equipamentoBean) {
		this.equipamentoBean = equipamentoBean;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}