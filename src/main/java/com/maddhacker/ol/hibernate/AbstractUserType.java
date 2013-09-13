package com.maddhacker.ol.hibernate;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

/**
 * Abstract for {@link UserType} implementations. This assumes that certain
 * required method implemenations are common for the objects extending this.
 * 
 * @see AbstractType
 * 
 * @param <T>
 *            any Object
 */
public abstract class AbstractUserType<T extends Object> extends AbstractType<T> implements UserType {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

}
