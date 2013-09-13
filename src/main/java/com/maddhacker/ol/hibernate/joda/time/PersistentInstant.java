package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Types;

import org.joda.time.Instant;

import com.maddhacker.ol.hibernate.AbstractTimestampBasedUserType;

/**
 * Map an {@link Instant} to a {@link Types#TIMESTAMP} for Hibernate.
 * 
 * @see AbstractTimestampBasedUserType
 * 
 */
public class PersistentInstant extends AbstractTimestampBasedUserType<Instant> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Instant> typeClass() {
		return Instant.class;
	}

	@Override
	protected Instant fromCommonTypeNotNull(Object obj) {
		return new Instant(obj);
	}

	@Override
	protected Object toCommonTypeNotNull(Instant value) {
		return value.toDate();
	}

}
