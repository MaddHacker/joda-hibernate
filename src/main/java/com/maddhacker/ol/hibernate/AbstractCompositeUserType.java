package com.maddhacker.ol.hibernate;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.CompositeUserType;

/**
 * Abstract for {@link CompositeUserType} implementations. This assumes that
 * certain required method implemenations are common for the objects extending
 * this.
 * 
 * @see AbstractType
 * 
 * @param <T>
 *            any Object
 * 
 */
public abstract class AbstractCompositeUserType<T extends Object> extends AbstractType<T> implements CompositeUserType {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable disassemble(Object value, SessionImplementor session) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, SessionImplementor session, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, SessionImplementor session, Object owner)
			throws HibernateException {
		return original;
	}

}
