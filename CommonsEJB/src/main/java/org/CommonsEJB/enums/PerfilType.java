package org.CommonsEJB.enums;

public enum PerfilType {
	
	USUARIO("USUARIO"), ADMINISTRADOR("ADMINISTRADOR"), GERENTE("GERENTE"), PROFESSOR("PROFESSOR"), ASSISTENTE("ASSISTENTE");
	
	private String value;
	
	PerfilType(String value){
		this.value = value;
	}

    public String getValue() {
       return this.value;
    }	
}
