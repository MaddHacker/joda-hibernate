package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Types;

import org.joda.time.Instant;

import com.maddhacker.ol.hibernate.AbstractBigIntBasedUserType;

/**
 * Map an {@link Instant} to a {@link Types#BIGINT} for Hibernate.
 * 
 * @see AbstractBigIntBasedUserType
 * 
 */
public class PersistentInstantAsBigInt extends AbstractBigIntBasedUserType<Instant> {

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
		return value.getMillis();
	}

}
