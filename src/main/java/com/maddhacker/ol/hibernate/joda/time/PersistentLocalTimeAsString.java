package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Types;

import org.joda.time.LocalTime;

import com.maddhacker.ol.hibernate.AbstractStringBasedUserType;

/**
 * Map a {@link LocalTime} to a {@link Types#VARCHAR} for Hibernate.
 * 
 * @see AbstractStringBasedUserType
 * 
 */
public class PersistentLocalTimeAsString extends AbstractStringBasedUserType<LocalTime> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<LocalTime> typeClass() {
		return LocalTime.class;
	}

	@Override
	protected LocalTime fromCommonTypeNotNull(Object obj) {
		return new LocalTime(obj);
	}

	@Override
	protected Object toCommonTypeNotNull(LocalTime value) {
		return value.toString();
	}

}
