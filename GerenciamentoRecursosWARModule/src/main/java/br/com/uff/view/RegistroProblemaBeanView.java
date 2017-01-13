package br.com.uff.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.EquipamentoBean;
import org.CommonsEJB.SalaBean;

@ManagedBean(name="registroProblemaBeanView")
@SessionScoped
public class RegistroProblemaBeanView {
	
	@EJB
	private EquipamentoBean equipamentoBean;
	
	@EJB
	private SalaBean salaBean;
	
	public void prepararRegistro(){
		System.out.println("Preparar registro");
	}

	public void registrar(){
		System.out.println("registrar");
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

}