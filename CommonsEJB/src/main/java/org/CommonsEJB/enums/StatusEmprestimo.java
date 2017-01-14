package org.CommonsEJB.enums;

public enum StatusEmprestimo {
	
	AGUARDANDO_RETORNO("AGUARDANDO RETORNO"), CONCLUIDO("CONCLUIDO");
	
	private String value;
	
	StatusEmprestimo(String value){
		this.value = value;
	}

    public String getValue() {
       return this.value;
    }	
}
