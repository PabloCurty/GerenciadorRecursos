package br.com.uff.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean (name="menuBean")
@SessionScoped
public class MenuView implements Serializable{
    
	private static final long serialVersionUID = -1779241254755068025L;
	
	private int perfilNivel;
	private String id;
	private String perfil;
   
    public MenuView() {
    	
    	this.id = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
    	this.perfil = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("perfil");
    	FacesContext fc = FacesContext.getCurrentInstance();
    	HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
    	session.setAttribute("oid", this.id );
    	session.setAttribute("perfi", this.perfil );

    }
    
    public int pegaPermissoes(){
    	/**
    	 * dá níveis aos papeis
    	 */
    	switch (perfil) {
			case "Administrador":
				perfilNivel = 4;
				break;
			
			case "ADMINISTRADOR":
				perfilNivel = 4;
				break;	
				
			case "Gerente":
				perfilNivel = 3;
				break;
		
			case "GERENTE":
				perfilNivel = 3;
				break;
		
			case "Professor":
				perfilNivel = 2;
				break;
		
			case "PROFESSOR":
				perfilNivel = 2;
				break;
			
			case "Assistente":
				perfilNivel = 1;
				break;
			
			case "ASSISTENTE":
				perfilNivel = 1;
				break;	
				
			default:
				perfilNivel = 0;
				break;
			}
    	
    		return perfilNivel;
    }

	public int getPerfilNivel() {
		return perfilNivel;
	}

	public void setPerfilNivel(int perfilNivel) {
		this.perfilNivel = perfilNivel;
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