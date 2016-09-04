/**  
 * @Title: AuthorityFilter.java
 * @Package cn.dafa.common.filter
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2012-12-31 下午3:12:47
 * @version V1.0  
 */
package cn.dafa.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cn.dafa.common.constant.Constant;
import cn.dafa.user.model.User;
import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: AuthorityFilter
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2012-12-31 下午3:12:47
 * @version 【V1.0】
 * @Description: 过滤器
 */
public class AuthorityFilter implements Filter {
	private Logger logger = Logger.getLogger(AuthorityFilter.class);

	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	// 不需要登录即可访问的URI资源
	private static final String[] INHERENT_ESCAPE_URIS = { "/login.jsp",
			"/error.jsp" };

	/*
	 * <p>Title: destroy</p> <p>Description: </p>
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		logger.info("destroy");

	}

	/*
	 * <p>Title: doFilter</p> <p>Description:执行过滤 </p>
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @param chain
	 * 
	 * @throws IOException
	 * 
	 * @throws ServletException
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		logger.info("doFilter");
		// 保证该过滤器在一次请求中只被调用一次
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {

			// 设置过滤标识，防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			User userContext = getSessionUser(httpRequest);

			// 用户未登录, 且当前URI资源需要登录才能访问
			if (userContext == null
					&& !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
				String toUrl = httpRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toUrl += "?" + httpRequest.getQueryString();
				}

				// 将用户的请求URL保存在session中，用于登录成功之后，跳到目标URL
				httpRequest.getSession().setAttribute(Constant.LOGIN_TO_URL,
						toUrl);

				// 转发到登录页面
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
				return;
			}
			chain.doFilter(request, response);
		}

	}

	/*
	 * <p>Title: init</p> <p>Description: </p>
	 * 
	 * @param filterConfig
	 * 
	 * @throws ServletException
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("init");
	}

	/**
	 * @Title: isURILogin
	 * @Description: 当前URI资源是否需要登录才能访问
	 * @datetime 2013-1-2 下午2:52:25
	 * @param
	 * @return
	 * @throws
	 */
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/")
						.equalsIgnoreCase(requestURI))
			return true;
		for (String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0) {
				return true;
			}
		}
		return false;
	}

	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(Constant.USER_CONTEXT);
	}
}
