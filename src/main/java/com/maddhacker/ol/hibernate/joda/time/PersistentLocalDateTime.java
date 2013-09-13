package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Types;

import org.joda.time.LocalDateTime;

import com.maddhacker.ol.hibernate.AbstractTimestampBasedUserType;

/**
 * Map a {@link LocalDateTime} to a {@link Types#TIMESTAMP} for Hibernate.
 * 
 * @see AbstractTimestampBasedUserType
 * 
 */
public class PersistentLocalDateTime extends AbstractTimestampBasedUserType<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<LocalDateTime> typeClass() {
		return LocalDateTime.class;
	}

	@Override
	protected LocalDateTime fromCommonTypeNotNull(Object obj) {
		return new LocalDateTime(obj);
	}

	@Override
	protected Object toCommonTypeNotNull(LocalDateTime value) {
		return value.toDateTime().toDate();
	}

}
