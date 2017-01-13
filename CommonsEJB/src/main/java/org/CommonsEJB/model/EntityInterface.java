package org.CommonsEJB.model;

import java.io.Serializable;

public interface EntityInterface extends Serializable, Cloneable {

	/**
	 * Recupera o identificador da entidade.
	 * 
	 * @return Identificador da entidade
	 */
	String getOid();

	/**
	 * Define o identificador da entidade.
	 * 
	 * @param id Novo identificador da entidade
	 */
	void setOid(String id);

	/**
	 * É uma nova entidade?
	 * 
	 * @return isNovo
	 */
	boolean isNovo();

}
