package br.com.uff.view;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.CommonsEJB.SolicitacaoSalaBean;
import org.CommonsEJB.UsuarioBeanInterface;
import org.CommonsEJB.enums.StatusSolicitacao;
import org.CommonsEJB.model.SolicitacaoSala;
import org.CommonsEJB.model.Usuario;
import org.primefaces.context.RequestContext;

@ManagedBean (name="solicitacaoSalaBeanView")
@RequestScoped
public class SolicitacaoSalaView implements Serializable{
	
	private static final long serialVersionUID = 4483189948552126347L;

	@EJB
	private SolicitacaoSalaBean solicitacaoSalaBean;
	
	@EJB
	private UsuarioBeanInterface userBean;
	
	@ManagedProperty("#{userSession}")
	private UserLoginView userSession;
	
	private String capacidade;
	
	private String recursos;
	
	private Date data;
	
	private String id;
	
	private String perfil;
	
	
	
	public SolicitacaoSalaView() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = (HttpSession) request.getSession();
		setId((String) session.getAttribute("oid"));
		setPerfil((String) session.getAttribute("perf"));

	}

	public void prepararSolicitacao(){
		System.out.println("Preparar Solicitacao");
	}

	public String solicitar(){
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		SolicitacaoSala solicitacaoSala;
		Usuario user;
		boolean solIn = false;
		
		try {
			
			user = userBean.pegaUsuario(id);
			solicitacaoSala = new SolicitacaoSala(this.data, user, this.capacidade, this.recursos, StatusSolicitacao.EM_ABERTO);
			solicitacaoSala = solicitacaoSalaBean.solicitar(solicitacaoSala);
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

	public SolicitacaoSalaBean getSalaBean() {
		return solicitacaoSalaBean;
	}

	public void setSalaBean(SolicitacaoSalaBean solicitacaoSalaBean) {
		this.solicitacaoSalaBean = solicitacaoSalaBean;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public UserLoginView getUserSession() {
		return userSession;
	}

	public void setUserSession(UserLoginView userSession) {
		this.userSession = userSession;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}