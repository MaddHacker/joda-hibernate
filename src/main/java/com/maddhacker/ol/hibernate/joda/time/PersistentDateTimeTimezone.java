package com.maddhacker.ol.hibernate.joda.time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.maddhacker.ol.hibernate.AbstractUserType;

/**
 * Map a {@link DateTime} with a {@link DateTimeZone} to a
 * {@link Types#TIMESTAMP} and a {@link Types#VARCHAR} for Hibernate.
 * 
 * @see AbstractUserType
 * 
 */
public class PersistentDateTimeTimezone extends AbstractUserType<DateTime> {

	private static final long serialVersionUID = 1L;

	private static final int[] SQL_TYPES = new int[] { Types.TIMESTAMP, Types.VARCHAR, };

	@Override
	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	@Override
	protected Class<DateTime> typeClass() {
		return DateTime.class;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		Object timestamp = StandardBasicTypes.TIMESTAMP.nullSafeGet(rs, names[0], session);
		Object timezone = StandardBasicTypes.STRING.nullSafeGet(rs, names[1], session);
		return ((timestamp == null || timezone == null) ? null : (new DateTime(timestamp, DateTimeZone.forID(timezone
				.toString()))));
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		DateTime dt = ((value == null) ? null : (DateTime) value);
		StandardBasicTypes.TIMESTAMP.nullSafeSet(st, ((dt == null) ? null : dt.toDate()), index, session);
		StandardBasicTypes.STRING.nullSafeSet(st, ((dt == null) ? null : dt.getZone().getID()), index, session);
	}
}
