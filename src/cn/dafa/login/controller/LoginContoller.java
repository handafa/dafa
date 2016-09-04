/**
 * 
 */
package cn.dafa.login.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.dafa.base.controller.BaseController;
import cn.dafa.common.util.ExtReturnJson;
import cn.dafa.login.service.LoginService;
import cn.dafa.user.model.User;

/**
 * @author 韩大发
 * @datetime 2012-8-29 上午10:54:45
 * @email:smile-gorget-song@foxmail.com
 * @summary dafa
 */
@Controller
@RequestMapping(value = "login")
public class LoginContoller extends BaseController<User> {
	private Logger logger = Logger.getLogger(LoginContoller.class);
	@SuppressWarnings("unused")
	@Resource
	private LoginService mLoginService;

	/**
	 * @Title: login
	 * @Description: 登陆
	 * @datetime 2013-1-21 上午9:58:05
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(
			HttpServletRequest request,
			HttpServletResponse response,
			User user,
			@RequestParam(required = true, defaultValue = "") String verificationCode)
			throws IOException {
		logger.info("login");
		ExtReturnJson extReturnJson = null;
		String kaptchaExpected = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		System.out.println("=============");
		System.out.println(user.toString());
		System.out.println(kaptchaExpected);
		System.out.println("=============");
		System.out.println(verificationCode);
		if (!verificationCode.equals(kaptchaExpected)) {
			System.out.println("验证码输入错误");
			extReturnJson = new ExtReturnJson("验证码错误", false, ExtReturnJson.RESULT_FLAG_MSG);
			response.getWriter().write(extReturnJson.getReturnJson());
			return null;
		}
		int result = 0;
		if (result > 0) {
			setSessionUser(request, user);
			response.getWriter().write("{success:true}");
		} else {
			response.getWriter().write("{success:false,msg:'密码错误！'}");
		}
		return null;
	}

	/**
	 * @param mLoginService
	 *            the mLoginService to set
	 */
	public void setmLoginService(LoginService mLoginService) {
		this.mLoginService = mLoginService;
	}

}
