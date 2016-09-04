/**  
 * @Title: UserController.java
 * @Package cn.dafa.role.controller
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-14 下午3:15:21
 * @version V1.0  
 */
package cn.dafa.role.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dafa.base.controller.BaseController;
import cn.dafa.common.pojo.Criteria;
import cn.dafa.role.model.Role;
import cn.dafa.role.service.RoleService;

/**
 * @ClassName: UserController
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-14 下午3:15:21
 * @version 【V1.0】
 * @Description: 角色
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController<Role> {
	private Logger logger = Logger.getLogger(RoleController.class);
	@Autowired
	private RoleService mService;

	/**
	 * @throws IOException
	 * @Title: query
	 * @Description: 查询
	 * @datetime 2013-1-14 下午3:19:47
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public Object query(HttpServletRequest request,
			HttpServletResponse response, Criteria criteria,
			@RequestParam(required = false, defaultValue = "") String keyword)
			throws IOException {
		logger.info("query");
		if (StringUtils.isNotBlank(keyword)) {
			criteria.put("keyword", keyword);
		}
		response_result = mService.query(criteria);
		response.setContentType(HTML_JSON_FLAG);
		response.getWriter().write(response_result);
		return null;
	}

	/**
	 * @throws IOException
	 * @Title: save
	 * @Description: 保存
	 * @datetime 2013-1-14 下午8:50:24
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Object save(Role role, HttpServletResponse response)
			throws IOException {
		logger.info("save");
		response_result = mService.save(role);
		response.setContentType(HTML_JSON_FLAG);
		response.getWriter().write(response_result);
		return null;
	}

	/**
	 * @Title: select
	 * @Description: 根据主键查询
	 * @datetime 2013-1-14 下午9:00:47
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public Object select(
			@RequestParam(required = false, defaultValue = "") String id,
			HttpServletResponse response) throws IOException {
		logger.info("select");
		response_result = mService.select(Integer.parseInt(id));
		response.setContentType(HTML_JSON_FLAG);
		response.getWriter().write(response_result);
		return null;
	}

	/**
	 * @Title: delete
	 * @Description: 删除
	 * @datetime 2013-1-14 下午9:02:54
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(HttpServletRequest request,
			HttpServletResponse response, String[] ids) throws IOException {
		logger.info("delete");
		response_result = mService.deleteBatch(ids);
		response.setContentType(HTML_JSON_FLAG);
		response.getWriter().write(response_result);
	}

	/**
	 * @throws IOException
	 * @Title: modify
	 * @Description: 修改
	 * @datetime 2013-1-14 下午9:03:31
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public Object modify(Role role, HttpServletResponse response)
			throws IOException {
		logger.info("modify");
		response_result = mService.modify(role);
		response.setContentType(HTML_JSON_FLAG);
		response.getWriter().write(response_result);
		return null;
	}

	// @InitBinder
	// protected void initBinder(WebDataBinder binder) throws Exception {
	// binder.registerCustomEditor(Date.class, new DateConvertEditor(
	// "yyyy-MM-dd"));
	// binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	// }

	/**
	 * @param mService
	 *            the mService to set
	 */
	public void setmService(RoleService mService) {
		this.mService = mService;
	}

}
