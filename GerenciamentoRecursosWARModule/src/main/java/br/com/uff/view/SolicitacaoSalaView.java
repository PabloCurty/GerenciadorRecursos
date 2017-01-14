package br.com.uff.view;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.CommonsEJB.SalaBean;
import org.CommonsEJB.UsuarioBeanInterface;
import org.CommonsEJB.model.Sala;
import org.CommonsEJB.model.SolicitacaoSala;
import org.CommonsEJB.model.Usuario;
import org.primefaces.context.RequestContext;

@ManagedBean (name="solicitacaoSalaBeanView")
@SessionScoped
public class SolicitacaoSalaView {
	
	@EJB
	private SalaBean salaBean;
	
	@EJB
	private UsuarioBeanInterface userBean;
	
	private String capacidade;
	
	private String recursos;
	
	private Date data;
	
	public void prepararSolicitacao(){
		System.out.println("Preparar Solicitacao");
	}

	public String solicitar(){
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		SolicitacaoSala solicitacaoSala;
		Usuario user;
		Sala sala = new Sala();
		String idUser = "id";
		boolean solIn = false;
		
		try {
			idUser = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(idUser);
			user = userBean.pegaUsuario(idUser);
			solicitacaoSala = new SolicitacaoSala(this.data, user, sala , this.capacidade, this.recursos, false);
			solicitacaoSala = salaBean.solicitar(solicitacaoSala);
			solIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala solicitada com sucesso ", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("cadIn", solIn);
			return "/";
		} catch (Exception e) {
			solIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de solicitação", "Solicitação inválido");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("cadIn", solIn);
			return "/";
		}
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getRecursos() {
		return recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}

	public SalaBean getSalaBean() {
		return salaBean;
	}

	public void setSalaBean(SalaBean salaBean) {
		this.salaBean = salaBean;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}