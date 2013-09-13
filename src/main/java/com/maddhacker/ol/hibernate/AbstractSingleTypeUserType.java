package com.maddhacker.ol.hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

/**
 * Abstract for {@link UserType} implementations that use a single column type.
 * This abstracts common methods, and provides generic support for any
 * {@link AbstractSingleColumnStandardBasicType}.
 * 
 * @see AbstractUserType
 * 
 * @param <T>
 *            any Object
 * @param <SBT>
 *            any {@link AbstractSingleColumnStandardBasicType}
 */
public abstract class AbstractSingleTypeUserType<T extends Object, SBT extends AbstractSingleColumnStandardBasicType<?>>
		extends AbstractUserType<T> {

	private static final long serialVersionUID = 1L;

	protected T fromCommonType(Object obj) {
		return ((obj == null) ? null : fromCommonTypeNotNull(obj));
	}

	/**
	 * Generate the object from the given <code>not null</code> obj
	 * 
	 * @param obj
	 *            guaranteed to be <code>not null</code>
	 * @return instance of T
	 */
	protected abstract T fromCommonTypeNotNull(Object obj);

	@SuppressWarnings("unchecked")
	protected Object toCommonType(Object value) {
		return ((value == null) ? null : toCommonTypeNotNull((T) value));
	}

	/**
	 * Generate the object transform from the given <code>not null</code>
	 * instance of T.
	 * 
	 * @param value
	 *            guarantted to be <code>not null</code>
	 * @return transformed object
	 */
	protected abstract Object toCommonTypeNotNull(T value);

	/**
	 * One of the instances in {@link StandardBasicTypes}, related to SBT.
	 * 
	 * @see StandardBasicTypes
	 * @see AbstractSingleColumnStandardBasicType
	 * 
	 * @return instance defined in {@link StandardBasicTypes} that extends
	 *         {@link AbstractSingleColumnStandardBasicType}
	 */
	protected abstract SBT getStandardBasicType();

	@Override
	public T nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		Object basicType = getStandardBasicType().nullSafeGet(rs, names[0], session);
		return fromCommonType(basicType);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		getStandardBasicType().nullSafeSet(st, toCommonType(value), index, session);
	}
}
