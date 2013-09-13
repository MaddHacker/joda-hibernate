package com.maddhacker.ol.hibernate;

import java.sql.Types;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.TimestampType;
import org.hibernate.usertype.UserType;

/**
 * Abstract implementation for any {@link UserType} based on storage as
 * {@link Types#TIMESTAMP} and {@link StandardBasicTypes#TIMESTAMP}
 * 
 * @see AbstractSingleTypeUserType
 * 
 * @param <T>
 *            any Object
 */
public abstract class AbstractTimestampBasedUserType<T extends Object> extends
		AbstractSingleTypeUserType<T, TimestampType> {

	private static final long serialVersionUID = 1L;

	private static final int[] SQL_TYPES = new int[] { Types.TIMESTAMP, };

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	protected TimestampType getStandardBasicType() {
		return StandardBasicTypes.TIMESTAMP;
	}

}
