package com.maddhacker.ol.hibernate;

import java.sql.Types;

import org.hibernate.type.DateType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

/**
 * Abstract implementation for any {@link UserType} based on storage as
 * {@link Types#DATE} and {@link StandardBasicTypes#DATE}
 * 
 * @see AbstractSingleTypeUserType
 * 
 * @param <T>
 *            any Object
 */
public abstract class AbstractDateBasedUserType<T extends Object> extends AbstractSingleTypeUserType<T, DateType> {

	private static final long serialVersionUID = 1L;

	private static final int[] SQL_TYPES = new int[] { Types.DATE, };

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	protected DateType getStandardBasicType() {
		return StandardBasicTypes.DATE;
	}

}
