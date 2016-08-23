package sql_date;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatter {

	public static Date getSqlDate(String strDate) {

		java.sql.Date sqlDate = null;

		try {
			SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date utilDate = format.parse(strDate);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {

			System.out.print(e);
			e.printStackTrace();
		}

		return sqlDate;

	}
}
