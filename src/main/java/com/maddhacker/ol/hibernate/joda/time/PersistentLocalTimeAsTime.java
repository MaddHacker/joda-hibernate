package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Time;
import java.sql.Types;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;

import com.maddhacker.ol.hibernate.AbstractTimeBasedUserType;

/**
 * Map a {@link LocalTime} to a {@link Types#TIME} for Hibernate.
 * 
 * @see AbstractTimeBasedUserType
 * 
 */
public class PersistentLocalTimeAsTime extends AbstractTimeBasedUserType<LocalTime> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<LocalTime> typeClass() {
		return LocalTime.class;
	}

	@Override
	protected LocalTime fromCommonTypeNotNull(Object obj) {
		return new LocalTime(obj, DateTimeZone.UTC);
	}

	@Override
	protected Object toCommonTypeNotNull(LocalTime value) {
		return new Time(value.getMillisOfDay());
	}

}
