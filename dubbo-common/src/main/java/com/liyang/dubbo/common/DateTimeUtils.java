package com.liyang.dubbo.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

public class DateTimeUtils {
	private static Logger logger = Logger.getLogger(DateTimeUtils.class);

	public static String format(String date, String inFormat, String outFormat) {
		String result = "";
		try {
			DateFormat iformat = new SimpleDateFormat(inFormat);
			DateFormat oformat = new SimpleDateFormat(outFormat);

			result = oformat.format(iformat.parse(date));

		} catch (Exception e) {
			logger.error("", e);
		}
		return result;
	}

}
