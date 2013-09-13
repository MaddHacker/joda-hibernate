package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Types;

import org.joda.time.LocalDate;

import com.maddhacker.ol.hibernate.AbstractDateBasedUserType;

/**
 * Map a {@link LocalDate} to a {@link Types#DATE} for Hibernate.
 * 
 * @see AbstractDateBasedUserType
 * 
 */
public class PersistentLocalDate extends AbstractDateBasedUserType<LocalDate> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<LocalDate> typeClass() {
		return LocalDate.class;
	}

	@Override
	protected LocalDate fromCommonTypeNotNull(Object obj) {
		return new LocalDate(obj);
	}

	@Override
	protected Object toCommonTypeNotNull(LocalDate value) {
		return value.toDateTimeAtStartOfDay().toDate();
	}

}
