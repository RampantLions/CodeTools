/* @(#)UTCTimestampType.java 1.00 Apr 29, 2015
*
* Copyright (c) 2015. All rights reserved.
*/
package io.github.rampantlions.codetools.hibernate.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * The Class UTCTimestampType.
 *
 * @author <a href="josh.wiechman@gmail.com">Wiechman, Joshua</a>
 */
@SuppressWarnings("serial")
public class UTCTimestampType extends org.hibernate.type.TimestampType {

	/**
	 * Gets the.
	 *
	 * @param rs
	 *            the rs
	 * @param name
	 *            the name
	 * @return the object
	 * @throws SQLException
	 *             the SQL exception
	 */
	public Object get(ResultSet rs, String name) throws SQLException {
		return rs.getTimestamp(name, createUTCCalendar());
	}

	/**
	 * Creates the utc calendar.
	 *
	 * @return the calendar
	 */
	private static Calendar createUTCCalendar() {
		final Calendar c = Calendar.getInstance();
		// c.setTimeZone( new SimpleTimeZone( 0, "UTC" ) );
		c.setTimeZone(new SimpleTimeZone(0, "GMT"));
		return c;
	}

	/**
	 * Sets the.
	 *
	 * @param st
	 *            the st
	 * @param value
	 *            the value
	 * @param index
	 *            the index
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void set(PreparedStatement st, Object value, int index) throws SQLException {
		Timestamp ts;
		if (value instanceof Timestamp) {
			ts = (Timestamp) value;
		} else {
			ts = new Timestamp(((java.util.Date) value).getTime());
		}
		st.setTimestamp(index, ts, createUTCCalendar());
	}

	public static Date getUtc() {
		SimpleDateFormat sdfAmerica = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
		DateTime dt = new DateTime(new Date());
		DateTimeZone dtZone = DateTimeZone.forID("UTC");
		DateTime dtus = dt.withZone(dtZone);
		TimeZone tzInAmerica = dtZone.toTimeZone();
		Date dateInAmerica = dtus.toLocalDateTime().toDate();
		return dateInAmerica;
	}
}
