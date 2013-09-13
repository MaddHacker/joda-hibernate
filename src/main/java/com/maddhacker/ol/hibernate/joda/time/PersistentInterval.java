package com.maddhacker.ol.hibernate.joda.time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import com.maddhacker.ol.hibernate.AbstractCompositeUserType;

/**
 * Map a {@link PersistentInterval} to two {@link Types#TIMESTAMP}s for
 * Hibernate.
 * 
 * @see CompositeUserType
 * @see AbstractCompositeUserType
 * 
 */
public class PersistentInterval extends AbstractCompositeUserType<Interval> {

	private static final long serialVersionUID = 1L;

	private static final String[] PROPERTY_NAMES = new String[] { "start", "end" };

	private static final Type[] TYPES = new Type[] { StandardBasicTypes.TIMESTAMP, StandardBasicTypes.TIMESTAMP };

	@Override
	public String[] getPropertyNames() {
		return PROPERTY_NAMES;
	}

	@Override
	public Type[] getPropertyTypes() {
		return TYPES;
	}

	@Override
	protected Class<Interval> typeClass() {
		return Interval.class;
	}

	@Override
	public Object getPropertyValue(Object component, int property) throws HibernateException {
		Interval interval = (Interval) component;
		return (property == 0) ? interval.getStart().toDate() : interval.getEnd().toDate();
	}

	@Override
	public void setPropertyValue(Object component, int property, Object value) throws HibernateException {
		throw new UnsupportedOperationException("Intervals are immutable");
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		return ((rs == null || names[0] == null || names[1] == null) ? null : (new Interval(new DateTime(names[0]),
				new DateTime(names[1]))));
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, StandardBasicTypes.TIMESTAMP.sqlType());
			st.setNull(index + 1, StandardBasicTypes.TIMESTAMP.sqlType());
		} else {
			Interval interval = (Interval) value;
			st.setTimestamp(index, getIndexTimestamp(interval, 0));
			st.setTimestamp(index + 1, getIndexTimestamp(interval, 1));
		}

	}

	private Timestamp getIndexTimestamp(Interval time, int index) {
		return new Timestamp((index == 0 ? time.getStart() : time.getEnd()).getMillis());
	}

}
