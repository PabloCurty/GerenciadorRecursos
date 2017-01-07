package br.com.uff.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean (name="menuBean")
@SessionScoped
public class MenuBean {
    
   
    public MenuBean() {
    	
    	String id = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
    	String perfil = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("perfil");

    }

}