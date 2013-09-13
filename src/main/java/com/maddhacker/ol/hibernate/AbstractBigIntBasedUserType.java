package com.maddhacker.ol.hibernate;

import java.sql.Types;

import org.hibernate.type.LongType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

/**
 * Abstract implementation for any {@link UserType} based on storage as
 * {@link Types#BIGINT} and {@link StandardBasicTypes#LONG}
 * 
 * @see AbstractSingleTypeUserType
 * 
 * @param <T>
 *            any Object
 */
public abstract class AbstractBigIntBasedUserType<T extends Object> extends AbstractSingleTypeUserType<T, LongType> {

	private static final long serialVersionUID = 1L;

	private static final int[] SQL_TYPES = new int[] { Types.BIGINT, };

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	protected LongType getStandardBasicType() {
		return StandardBasicTypes.LONG;
	}

}
