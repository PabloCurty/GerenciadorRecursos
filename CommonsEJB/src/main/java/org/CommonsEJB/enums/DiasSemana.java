package org.CommonsEJB.enums;

public enum DiasSemana {
	
	SEGUNDA("SEGUNDA"),TERCA("TERCA"),QUARTA("QUARTA"),QUINTA("QUINTA"),SEXTA("SEXTA"),SABADO("SABADO");
	
	private String value;
	
	DiasSemana(String value)
	{
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

}
