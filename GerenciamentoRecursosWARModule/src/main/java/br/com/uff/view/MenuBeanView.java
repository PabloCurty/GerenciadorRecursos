package br.com.uff.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean (name="menuBean")
@SessionScoped
public class MenuBeanView implements Serializable{
    
	private static final long serialVersionUID = -1779241254755068025L;
	
	private int perfilNivel;
	private String id;
	private String perfil;
   
    public MenuBeanView() {
    	
    	this.id = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
    	this.perfil = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("perfil");

    }
    
    public int pegaPermissoes(){
    	/**
    	 * dá níveis aos papeis
    	 */
    	switch (perfil) {
		case "Administrador":
			perfilNivel = 3;
			break;
		
		case "ADMINISTRADOR":
			perfilNivel = 3;
			break;	
			
		case "Gerente":
			perfilNivel = 2;
			break;
	
		case "GERENTE":
			perfilNivel = 2;
			break;
	
		case "Professor":
			perfilNivel = 1;
			break;
	
		case "PROFESSOR":
			perfilNivel = 1;
			break;
		
		case "Assistente":
			perfilNivel = 0;
			break;
		
		case "ASSISTENTE":
			perfilNivel = 0;
			break;	
			
		default:
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