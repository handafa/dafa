/**  
 * @Title: ExtHelper.java
 * @Package cn.dafa.common.util
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2012-11-3 下午8:05:13
 * @version V1.0  
 */
package cn.dafa.common.util;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;

import cn.dafa.menu.model.Menu;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @ClassName: ExtHelper
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2012-11-3 下午8:05:13
 * @version 【V1.0】
 * @Description: 将javabean转换成xml或者json格式的数据
 */
@SuppressWarnings({ "rawtypes", "unchecked" }) 
public class ExtHelper {
	private static Logger logger = Logger.getLogger(ExtHelper.class);
	private static JsonConfig jsonConfig = new JsonConfig();// JsonConfig是net.sf.json.JsonConfig中的这个，为固定写法
	private static String dateformat = "yyyy-MM-dd";

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public ExtHelper() {
		super();
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param format日期格式
	 */
	public ExtHelper(String format) {
		super();
		dateformat = format;
	}

	/**
	 * @Title: getXmlFromList
	 * @Description: 通过List生成XML数据
	 * @datetime 2012-11-14 下午9:38:08
	 * @param
	 * @return 生成的XML数据
	 * @throws
	 */
	private static String getXmlFromList(long recordTotal, List beanList) {
		TotalXml total = new TotalXml();
		total.setResults(recordTotal);
		List results = new ArrayList();
		results.add(total);
		results.addAll(beanList);
		XStream sm = new XStream(new DomDriver());
		for (int i = 0; i < results.size(); i++) {
			Class c = results.get(i).getClass();
			String b = c.getName();
			String[] temp = b.split("\\.");
			sm.alias(temp[temp.length - 1], c);
		}
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
				+ sm.toXML(results);
		return xml;
	}

	/**
	 * @Title: getXmlFromList
	 * @Description: 通过List生成XML数据
	 * @datetime 2012-11-14 下午9:39:03
	 * @param
	 * @return
	 * @throws
	 */
	public static String getXmlFromList(List beanList) {
		logger.info("getXmlFromList");
		return getXmlFromList(beanList.size(), beanList);
	}

	/**
	 * @Title: getJsonFromList
	 * @Description: 通过List生成JSON数据
	 * @datetime 2012-11-14 下午9:39:34
	 * @param
	 * @return 生成的JSON数据
	 * @throws
	 */
	public static String getJsonFromList(long recordTotal, List beanList) {
		TotalJson total = new TotalJson();
		total.setResults(recordTotal);
		total.setItems(beanList);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor(dateformat));
		JSONObject JsonObject = JSONObject.fromObject(total, jsonConfig);
		return JsonObject.toString();
	}

	/**
	 * @Title: getJsonFromList
	 * @Description: 通过List生成JSON数据
	 * @datetime 2012-11-14 下午9:40:26
	 * @param 包含bean对象的集合
	 * @return 生成的JSON数据
	 * @throws
	 */
	public static String getJsonFromList(List beanList, long results) {
		logger.info("getJsonFromList");
		return getJsonFromList(results, beanList);
	}

	/**
	 * @Title: getJsonFromBean
	 * @Description: 通过bean生成JSON数据
	 * @datetime 2012-11-14 下午9:40:55
	 * @param
	 * @return 生成的JSON数据
	 * @throws
	 */
	public static String getJsonFromBean(Object bean) {
		logger.info("getJsonFromBean");
		jsonConfig.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor(dateformat));
		JSONObject JsonObject = JSONObject.fromObject(bean, jsonConfig);
		return JsonObject.toString();
	}

	public static void main(String[] args) {

		System.out.println(Menu.class.getName());
	}

}
