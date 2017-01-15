package br.com.uff.view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.CommonsEJB.EquipamentoBean;
import org.CommonsEJB.model.Equipamento;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "equipamentoBeanView")
@SessionScoped
public class EquipamentoView {

	@EJB
	private EquipamentoBean equipamentoBean;

	private String numero;

	private String tipo;

	private String descricao;
	
	private String status;

	private List<String> tipos;

	public List<String> completeText() {

		tipos = new ArrayList<String>();
		tipos.add("PROJETOR");
		tipos.add("CAIXA DE SOM");
		tipos.add("MICROFONE");
		tipos.add("LAP TOP");
		tipos.add("OUTROS");

		return tipos;
	}

	public void prepararCadastro() {
		System.out.println("Preparar cadastro");
	}

	public String cadastrar(){
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		Equipamento equipamento;
		boolean cadIn = false;

		try {
			equipamento = new Equipamento(this.numero, this.tipo);
			equipamento = equipamentoBean.cadastrar(equipamento);
			cadIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Equipamento de numero " + equipamento.getNumero() + " cadastrado com sucesso ", this.numero);
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

	public EquipamentoBean getEquipamentoBean() {
		return equipamentoBean;
	}

	public void setEquipamentoBean(EquipamentoBean equipamentoBean) {
		this.equipamentoBean = equipamentoBean;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}