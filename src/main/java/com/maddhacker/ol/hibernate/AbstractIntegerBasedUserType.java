package com.maddhacker.ol.hibernate;

import java.sql.Types;

import org.hibernate.type.IntegerType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

/**
 * Abstract implementation for any {@link UserType} based on storage as
 * {@link Types#INTEGER} and {@link StandardBasicTypes#INTEGER}
 * 
 * @see AbstractSingleTypeUserType
 * 
 * @param <T>
 *            any Object
 */
public abstract class AbstractIntegerBasedUserType<T extends Object> extends AbstractSingleTypeUserType<T, IntegerType> {

	private static final long serialVersionUID = 1L;

	private static final int[] SQL_TYPES = new int[] { Types.INTEGER, };

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	protected IntegerType getStandardBasicType() {
		return StandardBasicTypes.INTEGER;
	}

}
