/**  
 * @Title: ExtReturnJson.java
 * @Package cn.dafa.common.util
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-14 下午1:20:21
 * @version V1.0  
 */
package cn.dafa.common.util;

import org.apache.log4j.Logger;

/**
 * @ClassName: ExtReturnJson
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-14 下午1:20:21
 * @version 【V1.0】
 * @Description: 返回的json结果
 */
public class ExtReturnJson {
	private Logger logger = Logger.getLogger(ExtReturnJson.class);
	public static final int RESULT_FLAG_MSG = 0;
	public static final int RESULT_FLAG_DATA = 1;
	boolean isSuccess = true;
	String result;
	int flag = 0;
	private String s = "";

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param result
	 * @param isSuccess
	 * @param flag
	 */
	public ExtReturnJson(String result, boolean isSuccess, int flag) {
		super();
		this.result = result;
		this.isSuccess = isSuccess;
		this.flag = flag;
	}

	/**
	 * @Title: getReturnJson
	 * @Description: TODO
	 * @datetime 2013-1-14 下午1:52:53
	 * @param
	 * @return
	 * @throws
	 */
	public String getReturnJson() {
		logger.info("getReturnJson");
		s += "{success:";
		if (isSuccess) {
			s += "true,";
		} else {
			s += "false,";
		}
		if (flag == RESULT_FLAG_MSG) {
			s += "msg:'" + result + "'}";
		} else if (flag == RESULT_FLAG_DATA) {
			s += "data:" + result + "}";
		}
		logger.info(s);
		return s;
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @datetime 2013-1-14 下午1:20:21
	 * @param
	 * @return
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
