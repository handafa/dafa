/**  
 * @Title: TimeUtil.java
 * @Package cn.dafa.common.util
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2012-11-4 下午10:19:44
 * @version V1.0  
 */
package cn.dafa.common.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @ClassName: TimeUtil
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2012-11-4 下午10:19:44
 * @version 【V1.0】
 * @Description: 获取各种时间格式
 */
public class TimeUtil {

	private static Logger logger = Logger.getLogger(TimeUtil.class);

	/**
	 * @Title: getNowDate
	 * @Description: 获取date类型的时间格式 yyyy-MM-dd HH:mm:ss
	 * @param @return
	 * @return Date
	 * @datetime 2012-11-6 下午8:09:54
	 * @throws
	 */
	public static Date getNowDate() {
		logger.info("getNowDate");
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(now);
		ParsePosition pos = new ParsePosition(8);
		now = formatter.parse(dateString, pos);
		return now;
	}

	/**
	 * @Title: getNowDateShort
	 * @Description: 获取date类型的时间格式 yyyy-MM-dd
	 * @param @return
	 * @return Date
	 * @datetime 2012-11-6 下午8:11:23
	 * @throws
	 */
	public static Date getNowDateShort() {
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(now);
		ParsePosition pos = new ParsePosition(8);
		now = formatter.parse(dateString, pos);
		return now;
	}

	/**
	 * @Title: getStringDate
	 * @Description: 返回字符串格式 yyyy-MM-dd HH:mm:ss
	 * @param @return
	 * @return String
	 * @datetime 2012-11-6 下午8:18:32
	 * @throws
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * @Title: getStringDateShort
	 * @Description: 返回字符串格式 yyyy-MM-dd
	 * @param @return
	 * @return String
	 * @datetime 2012-11-6 下午8:19:11
	 * @throws
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * @Title: getTimeStamp
	 * @Description: 获取时间戳
	 * @datetime 2013-2-21 下午4:22:10
	 * @param
	 * @return
	 * @throws
	 */
	public static String getTimeStamp() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(currentTime);
		return dateString + System.currentTimeMillis();
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @datetime 2012-11-4 下午10:19:44
	 * @throws
	 */
	public static void main(String[] args) {
		System.out.println(getTimeStamp());
	}

}
