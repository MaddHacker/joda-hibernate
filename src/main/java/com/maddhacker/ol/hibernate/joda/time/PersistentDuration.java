package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Types;

import org.joda.time.Duration;

import com.maddhacker.ol.hibernate.AbstractStringBasedUserType;

/**
 * Map a {@link Duration} to a {@link Types#VARCHAR} for Hibernate.
 * 
 * @see AbstractStringBasedUserType
 * 
 */
public class PersistentDuration extends AbstractStringBasedUserType<Duration> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Duration> typeClass() {
		return Duration.class;
	}

	@Override
	protected Duration fromCommonTypeNotNull(Object s) {
		return new Duration(s);
	}

	@Override
	protected Object toCommonTypeNotNull(Duration value) {
		return value.toString();
	}

}
