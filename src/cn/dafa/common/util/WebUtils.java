package cn.dafa.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: WebUtils
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-14 上午10:56:56
 * @version 【V1.0】 
 * @Description: Web层相关的实用工具类
 */
public class WebUtils {
	/**
	 * 将请求参数封装为Map<br>
	 * request中的参数t1=1&t1=2&t2=3<br>
	 * 形成的map结构：<br>
	 * key=t1;value[0]=1,value[1]=2<br>
	 * key=t2;value[0]=3<br>
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static HashMap<String, String> getPraramsAsMap(HttpServletRequest request) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		Map map = request.getParameterMap();
		Iterator keyIterator = (Iterator) map.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = (String) keyIterator.next();
			String value = ((String[]) (map.get(key)))[0];
			hashMap.put(key, value);
		}
		return hashMap;
	}
}
