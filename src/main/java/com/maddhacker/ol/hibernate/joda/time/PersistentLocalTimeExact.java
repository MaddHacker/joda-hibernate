package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Types;

import org.joda.time.LocalTime;

import com.maddhacker.ol.hibernate.AbstractIntegerBasedUserType;

/**
 * Map a {@link LocalTime} to a {@link Types#INTEGER} for Hibernate.
 * 
 * @see AbstractIntegerBasedUserType
 * 
 */
public class PersistentLocalTimeExact extends AbstractIntegerBasedUserType<LocalTime> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<LocalTime> typeClass() {
		return LocalTime.class;
	}

	@Override
	protected LocalTime fromCommonTypeNotNull(Object obj) {
		return LocalTime.fromMillisOfDay(((Number) obj).intValue());
	}

	@Override
	protected Object toCommonTypeNotNull(LocalTime value) {
		return new Integer(value.getMillisOfDay());
	}

}
