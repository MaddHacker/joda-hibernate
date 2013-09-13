package com.maddhacker.ol.hibernate;

import java.sql.Types;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

/**
 * Abstract implementation for any {@link UserType} based on storage as
 * {@link Types#VARCHAR} and {@link StandardBasicTypes#STRING}
 * 
 * @see AbstractSingleTypeUserType
 * 
 * @param <T>
 *            any Object
 */
public abstract class AbstractStringBasedUserType<T extends Object> extends AbstractSingleTypeUserType<T, StringType> {

	private static final long serialVersionUID = 1L;

	private static final int[] SQL_TYPES = new int[] { Types.VARCHAR, };

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	protected StringType getStandardBasicType() {
		return StandardBasicTypes.STRING;
	}

}
