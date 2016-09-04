/**  
 * @Title: JsonDateValueProcessor.java
 * @Package cn.dafa.common.util
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-10 下午9:58:23
 * @version V1.0  
 */
package cn.dafa.common.util;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.log4j.Logger;

/**
 * @ClassName: JsonDateValueProcessor
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-10 下午9:58:23
 * @version 【V1.0】
 * @Description: TODO
 */
public class DateJsonValueProcessor implements JsonValueProcessor {
	private static Logger logger = Logger
			.getLogger(DateJsonValueProcessor.class);
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private DateFormat dateFormat;

	public DateJsonValueProcessor() {
		this(DEFAULT_DATE_PATTERN);
	}

	public DateJsonValueProcessor(String datePattern) {
		logger.info("DateJsonValueProcessor");
		try {
			dateFormat = new SimpleDateFormat(datePattern);
		} catch (Exception ex) {
			dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
		}
	}

	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return process(value);
	}

	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		return process(value);
	}

	private Object process(Object value) {
		logger.info("process");
		if (value instanceof Timestamp)
			return dateFormat.format((Timestamp) value);
		else if (value instanceof Date)
			return dateFormat.format((Date) value);
		else if (value == null)
			return "";
		else
			return value.toString();
	}
}
