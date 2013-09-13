package com.maddhacker.ol.hibernate;

import java.sql.Types;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.TimeType;
import org.hibernate.usertype.UserType;

/**
 * Abstract implementation for any {@link UserType} based on storage as
 * {@link Types#TIME} and {@link StandardBasicTypes#TIME}
 * 
 * @see AbstractSingleTypeUserType
 * 
 * @param <T>
 *            any Object
 */
public abstract class AbstractTimeBasedUserType<T extends Object> extends AbstractSingleTypeUserType<T, TimeType> {

	private static final long serialVersionUID = 1L;

	private static final int[] SQL_TYPES = new int[] { Types.TIME, };

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	protected TimeType getStandardBasicType() {
		return StandardBasicTypes.TIME;
	}

}
