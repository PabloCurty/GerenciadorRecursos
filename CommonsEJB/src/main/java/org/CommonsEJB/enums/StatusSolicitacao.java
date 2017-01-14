package org.CommonsEJB.enums;

public enum StatusSolicitacao {
	
	EM_ABERTO("EM ABERTO"), NEGADO("NEGADO"), CONCEDIDO("CONCEDIDO");
	
	private String value;
	
	StatusSolicitacao(String value){
		this.value = value;
	}

    public String getValue() {
       return this.value;
    }	
}
