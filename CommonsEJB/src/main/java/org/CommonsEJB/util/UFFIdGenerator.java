package org.CommonsEJB.util;

import java.io.Serializable;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UFFIdGenerator implements IdentifierGenerator {

	public UFFIdGenerator(){
		super();
	}

	@Override
	public Serializable generate(SessionImplementor session, Object object) {
		return EntityUtil.gerarOidRandomico();
	}

}
