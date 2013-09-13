package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Types;

import org.joda.time.DateTime;

import com.maddhacker.ol.hibernate.AbstractTimestampBasedUserType;

/**
 * Map a {@link DateTime} to a {@link Types#TIMESTAMP} for Hibernate.
 * 
 * @see AbstractTimestampBasedUserType
 * 
 */
public class PersistentDateTime extends AbstractTimestampBasedUserType<DateTime> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<DateTime> typeClass() {
		return DateTime.class;
	}

	@Override
	protected DateTime fromCommonTypeNotNull(Object obj) {
		return new DateTime(obj);
	}

	@Override
	protected Object toCommonTypeNotNull(DateTime value) {
		return value.toDate();
	}

}
