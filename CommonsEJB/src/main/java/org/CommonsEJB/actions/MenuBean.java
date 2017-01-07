package org.CommonsEJB.actions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.MenuModel;

@ManagedBean
@SessionScoped
public class MenuBean {
    
    private MenuModel model;
   
    public MenuBean() {
    	
    	String id = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
    	String perfil = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("perfil");
    	
        MenuItem menuItem = new MenuItem();
        menuItem.setValue("Computers");
        menuItem.setUrl("#");
        model.addMenuItem(menuItem);
       
        menuItem = new MenuItem();
        menuItem.setValue("Clothes");
        menuItem.setUrl("#");
        model.addMenuItem(menuItem);
        
        menuItem = new MenuItem();
        menuItem.setValue("Gaming");
        menuItem.setUrl("#");
        model.addMenuItem(menuItem);
        
        menuItem = new MenuItem();
        menuItem.setValue("Books");
        menuItem.setUrl("#");
        model.addMenuItem(menuItem);
        
        menuItem = new MenuItem();
        menuItem.setValue("Jewellery and Watches");
        menuItem.setUrl("#");
        model.addMenuItem(menuItem);
    }
    
    public MenuModel getModel() {
        return model;
    }
}