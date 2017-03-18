/**
 * 
 */
package cz.ucl.hatchery.carevidence.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author DZCJS9F
 *
 */
public class CoreDateUtil {

	public static Date getNow() {
		return new Date();
	}

	public static Date alterDate(Date date, int amount, int unit) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(unit, amount);
		return cal.getTime();
	}

	public static Date getDateFromNow(int amount, int unit) {
		Calendar cal = Calendar.getInstance();
		cal.add(unit, amount);
		return cal.getTime();
	}

}
