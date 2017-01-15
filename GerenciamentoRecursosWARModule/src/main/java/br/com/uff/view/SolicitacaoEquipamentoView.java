package br.com.uff.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.CommonsEJB.EquipamentoBean;
import org.CommonsEJB.UsuarioBeanInterface;
import org.CommonsEJB.enums.StatusSolicitacao;
import org.CommonsEJB.model.SolicitacaoEquipamento;
import org.CommonsEJB.model.Usuario;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "solicitacaoEquipamentoView")
@SessionScoped
public class SolicitacaoEquipamentoView {

	@EJB
	private EquipamentoBean equipamentoBean;
	
	@EJB
	private UsuarioBeanInterface userBean;
	
	private List<SolicitacaoEquipamento> solicitacoes;

	private List<String> tipos;

	private String tipo;
	
	private Date data;
	
	private String id;
	
	private String perfil;
	
	public void obtemSolicitacoes(){
		solicitacoes = equipamentoBean.getAllSolicitacoes();
		
	}

	public SolicitacaoEquipamentoView() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = (HttpSession) request.getSession();
		setId((String) session.getAttribute("oid"));
		setPerfil((String) session.getAttribute("perf"));
	}

	public void prepararSolicitacao() {
		System.out.println("Preparar Solicitacao");
	}

	public String solicitar() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		SolicitacaoEquipamento solicitacaoEquipamento;
		Usuario user;
		boolean solIn = false;
		
		try {
			
			user = userBean.pegaUsuario(id);
			solicitacaoEquipamento = new SolicitacaoEquipamento(this.data, user, StatusSolicitacao.EM_ABERTO);
			solicitacaoEquipamento = equipamentoBean.solicitar(solicitacaoEquipamento);
			solIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Equipamento solicitado com sucesso ", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("cadIn", solIn);
			return "/";
		} catch (Exception e) {
			solIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de solicitação", "Solicitação inválida");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("cadIn", solIn);
			return "/";
		}
	}

	public List<String> completeText() {

		tipos = new ArrayList<String>();
		tipos.add("PROJETOR");
		tipos.add("CAIXA DE SOM");
		tipos.add("MICROFONE");
		tipos.add("LAP TOP");

		return tipos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public EquipamentoBean getEquipamentoBean() {
		return equipamentoBean;
	}

	public void setEquipamentoBean(EquipamentoBean equipamentoBean) {
		this.equipamentoBean = equipamentoBean;
	}

	public List<String> getTipos() {
		return tipos;
	}

	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public List<SolicitacaoEquipamento> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoEquipamento> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

}