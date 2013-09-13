package com.maddhacker.ol.hibernate;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.usertype.CompositeUserType;
import org.hibernate.usertype.UserType;

/**
 * High level abstractions for {@link UserType} and {@link CompositeUserType}
 * type implementations. This assumes that certain required method
 * implemenations are common for the objects extending this.
 * <p>
 * Implements {@link Serializable}
 * 
 * @see AbstractUserType
 * @see AbstractCompositeUserType
 * 
 * @param <T>
 *            any Object
 */
public abstract class AbstractType<T extends Object> implements Serializable {

	private static final long serialVersionUID = 1L;

	public Class<T> returnedClass() {
		return typeClass();
	}

	protected abstract Class<T> typeClass();

	@SuppressWarnings("unchecked")
	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y) {
			return true;
		}
		if (x == null || y == null) {
			return false;
		}
		T cx = (T) x;
		T cy = (T) y;

		return cx.equals(cy);
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public boolean isMutable() {
		return false;
	}

}
