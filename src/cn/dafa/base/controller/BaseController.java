/**  
 * @Title: BaseController.java
 * @Package cn.dafa.base.controller
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-2 下午2:15:14
 * @version V1.0  
 */
package cn.dafa.base.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.web.servlet.mvc.SimpleFormController;

import cn.dafa.common.constant.Constant;
import cn.dafa.user.model.User;

/**
 * @ClassName: BaseController
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-2 下午2:15:14
 * @version 【V1.0】
 * @Description: TODO
 */
@SuppressWarnings("deprecation")
public class BaseController<T extends Serializable> extends
		SimpleFormController {
	protected Logger logger = Logger.getLogger(getClass());

	protected static final String ERROR_MSG_KEY = "errorMsg";
	/**
	 * @summary json格式标签
	 */
	protected static final String HTML_JSON_FLAG = "text/javascript;charset=UTF-8";

	/**
	 * @summary xml格式标签
	 */
	protected static final String HTML_XML_FLAG = "text/xml;charset=UTF-8";

	/**
	 * @summary 请求的反馈
	 */
	protected String response_result = "";

	/**
	 * @Title: getSessionUser
	 * @Description: 获取保存在session中的用户对象
	 * @datetime 2013-1-2 下午2:37:18
	 * @param
	 * @return
	 * @throws
	 */
	protected User getSessionUser(HttpServletRequest request) {
		logger.info("getSessionUser");
		return (User) request.getSession().getAttribute(Constant.USER_CONTEXT);
	}

	/**
	 * @Title: setSessionUser
	 * @Description: 将用户对象保存到Session中
	 * @datetime 2013-1-2 下午2:38:59
	 * @param
	 * @return
	 * @throws
	 */
	protected void setSessionUser(HttpServletRequest request, User user) {
		logger.info("setSessionUser");
		request.getSession().setAttribute(Constant.USER_CONTEXT, user);
	}

	/**
	 * @Title: getAppBaseUrl
	 * @Description: 获取基于应用程序的url绝对路径
	 * @datetime 2013-1-2 下午2:42:38
	 * @param
	 * @return
	 * @throws
	 */
	protected final String getAppBaseUrl(HttpServletRequest request, String url) {
		logger.info("getAppBaseUrl");
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "必须以/打头");
		return request.getContextPath() + url;
	}
}
