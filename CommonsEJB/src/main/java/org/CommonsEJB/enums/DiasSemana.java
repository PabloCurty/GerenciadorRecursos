package org.CommonsEJB.enums;

public enum DiasSemana {
	
	SEGUNDA("SEGUNDA"),TERCA("TERCA"),QUARTA("QUARTA"),QUINTA("QUINTA"),SEXTA("SEXTA"),SABADO("SABADO");
	
	private String value;
	
	public static final DiasSemana getDiaDaSemana(int dia){
		switch(dia){
			case 2: return SEGUNDA;
			case 3: return TERCA;
			case 4: return QUARTA;
			case 5: return QUINTA;
			case 6: return SEXTA;
			case 7: return SABADO;
			default: return null;
		}
	}
	
	DiasSemana(String value)
	{
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

}
