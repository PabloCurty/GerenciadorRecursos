/**
 * 
 */
package org.CommonsEJB.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.Strings;



/**
 * @author Pablo
 *
 */
@MappedSuperclass
public abstract class EntidadeAbstrata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5984844393731264815L;
	
	
	@Id
	@SequenceGenerator(name = "SEQUENCIA_UFF", sequenceName = "SEQ_UFF", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCIA_UFF")
	@Column(name = "OID")
	protected String oid;
	
	

	public EntidadeAbstrata() {
		super();
	}

	public EntidadeAbstrata(String oid) {
		super();
		this.oid = oid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	
	
	@Override
	public String toString() {
		return oid;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(5, 11).append(oid).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof EntidadeAbstrata) {
			EntidadeAbstrata ae = (EntidadeAbstrata) obj;

			result = ae.canEqual(this) && new EqualsBuilder().append(oid, ae.getOid()).isEquals();
		}

		return result;
	}

	public boolean isNovo() {
		return Strings.isNullOrEmpty(oid);
	}

	/**
	 * EqualsVerifier.
	 * 
	 * @param obj
	 * @return canEqual
	 */
	public boolean canEqual(Object obj) {
		return obj instanceof EntidadeAbstrata;
	}
	
	

}
