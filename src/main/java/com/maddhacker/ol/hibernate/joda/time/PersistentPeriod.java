package com.maddhacker.ol.hibernate.joda.time;

import java.sql.Types;

import org.joda.time.Period;

import com.maddhacker.ol.hibernate.AbstractStringBasedUserType;

/**
 * Map a {@link Period} to a {@link Types#VARCHAR} for Hibernate.
 * 
 * @see AbstractStringBasedUserType
 * 
 */
public class PersistentPeriod extends AbstractStringBasedUserType<Period> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Period> typeClass() {
		return Period.class;
	}

	@Override
	protected Period fromCommonTypeNotNull(Object s) {
		return new Period(s);
	}

	@Override
	protected Object toCommonTypeNotNull(Period value) {
		return value.toString();
	}

}
