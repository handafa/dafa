/**
 * 
 */
package cn.dafa.user.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dafa.base.controller.BaseController;
import cn.dafa.common.pojo.Criteria;
import cn.dafa.common.springmvc.DateConvertEditor;
import cn.dafa.common.util.ExtHelper;
import cn.dafa.common.util.ExtReturnJson;
import cn.dafa.user.model.User;
import cn.dafa.user.service.UserService;

/**
 * @author 韩大发
 * @datetime 2012-8-29 上午09:28:58
 * @email:smile-gorget-song@foxmail.com
 * @summary 系统用户管理的controller
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {
	private Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService mService;

	/**
	 * @summary 查询用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public Object query(HttpServletRequest request,
			HttpServletResponse response, Criteria criteria,
			@RequestParam(required = false, defaultValue = "") String keyword)
			throws IOException {
		logger.info("query");
		// Map m = WebUtils.getPraramsAsMap(request);
		// System.out.println(m.toString());
		// 保存查询条件
		if (StringUtils.isNotBlank(keyword)) {
			criteria.put("keyword", keyword);
		}
		long results = mService.count(criteria);
		List<User> list = mService.query(criteria);
		String json = ExtHelper.getJsonFromList(list, results);
		response.setContentType(HTML_JSON_FLAG);
		response.getWriter().write(json);
		return null;
	}

	/**
	 * @Title: save
	 * @Description: 保存用户信息
	 * @datetime 2013-1-10 下午9:34:14
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(User user, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("save");
		response.setContentType(HTML_JSON_FLAG);
		int result = mService.save(user);
		if (result > 0) {
			response.getWriter().write("{success:true,msg:'保存成功'}");
		} else {
			response.getWriter().write("{success:false,msg:'保存失败'}");
		}
		return null;
	}

	/**
	 * @Title: 查出某个用户
	 * @Description: TODO
	 * @datetime 2013-1-7 下午8:56:48
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("select");
		response.setContentType(HTML_JSON_FLAG);
		String id = request.getParameter("id");
		User user = mService.select(Integer.parseInt(id));
		String json = null;
		if (user != null) {
			json = "{success:true,data:" + ExtHelper.getJsonFromBean(user)
					+ "}";
			System.out.println(json);
			response.getWriter().write(json);

		} else {
			response.getWriter().write("{success:false,msg:'查询出错'}");
		}
		return null;
	}

	/**
	 * @throws IOException
	 * @Title: delete
	 * @Description: 删除
	 * @datetime 2013-1-12 下午1:36:55
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(HttpServletRequest request,
			HttpServletResponse response, String[] ids) throws IOException {
		logger.info("delete");
		response.setContentType(HTML_JSON_FLAG);
		int result = 0;
		String json = "";
		try {
			result = mService.deleteBatch(ids);
			if (result > 0) {
				json = "{success:true,msg:'删除成功'}";
			} else {
				json = "{success:false,msg:'删除失败'}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			json = "{success:false,msg:'删除失败,系统异常'}";
		}
		response.getWriter().write(json);
	}

	/**
	 * @Title: modify
	 * @Description: 更改用户信息
	 * @datetime 2013-1-7 下午8:57:59
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(User user, HttpServletResponse response) {
		logger.info("modify");
		response.setContentType(HTML_JSON_FLAG);
		if (user != null) {
			try {
				int result = mService.modify(user);
				if (result > 0) {
					response.getWriter().write("{success:true,msg:'修改成功'}");
				} else {
					response.getWriter().write("{success:false,msg:'修改失败'}");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @Title: resetPassword
	 * @Description: 密码重置
	 * @datetime 2013-1-14 下午1:35:08
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public void resetPassword(
			@RequestParam(required = false, defaultValue = "") String id,
			HttpServletResponse response) throws IOException {
		logger.info("resetPassword");
		response.setContentType(HTML_JSON_FLAG);
		ExtReturnJson extReturnJson;
		try {
			int result = mService.resetPassword(id);
			System.out.println(result);
			if (result > 0) {
				extReturnJson = new ExtReturnJson("重置密码成功", true,
						ExtReturnJson.RESULT_FLAG_MSG);
			} else {
				extReturnJson = new ExtReturnJson("重置密码成功", false,
						ExtReturnJson.RESULT_FLAG_MSG);
			}
		} catch (Exception e) {
			extReturnJson = new ExtReturnJson("重置密码发生异常：" + e.getMessage(),
					false, ExtReturnJson.RESULT_FLAG_MSG);
		}
		System.out.println(extReturnJson.getReturnJson());
		response.getWriter().write(extReturnJson.getReturnJson());
	}

	public void setmService(UserService mService) {
		this.mService = mService;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DateConvertEditor("yyyy-MM-dd"));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
