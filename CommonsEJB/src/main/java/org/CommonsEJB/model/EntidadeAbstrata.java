/**
 * 
 */
package org.CommonsEJB.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.google.common.base.Strings;



/**
 * @author Pablo
 *
 */
@MappedSuperclass
public abstract class EntidadeAbstrata implements EntityInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5984844393731264815L;
	
	
	@Id
	@Size(min = 36, max = 36)
	@GenericGenerator(name = "uuid", strategy = "org.CommonsEJB.util.UFFIdGenerator")
	@GeneratedValue(generator = "uuid")
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

	/**@Override
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
	}**/

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeAbstrata other = (EntidadeAbstrata) obj;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		return true;
	}
	
	

}
