package org.CommonsEJB.util;

public enum PerfilType {
	
	ADMINISTRADOR("ADMINISTRADOR"), GERENTE("GERENTE"), PROFESSOR("PROFESSOR"), ASSISTENTE("ASSISTENTE");
	
	private String value;
	
	PerfilType(String value){
		this.value = value;
	}

    public String getValue() {
       return this.value;
    }	
}
