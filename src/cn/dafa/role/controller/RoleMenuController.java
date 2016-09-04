/**  
 * @Title: RoleMenuController.java
 * @Package cn.dafa.role.controller
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-15 下午8:35:55
 * @version V1.0  
 */
package cn.dafa.role.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dafa.base.controller.BaseController;
import cn.dafa.role.model.RoleMenu;
import cn.dafa.role.service.RoleMenuService;

/**
 * @ClassName: RoleMenuController
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-15 下午8:35:55
 * @version 【V1.0】
 * @Description: TODO
 */
@Controller
@RequestMapping(value = "rolemenu")
public class RoleMenuController extends BaseController<RoleMenu> {
	private Logger logger = Logger.getLogger(RoleMenuController.class);
	@Autowired
	private RoleMenuService mService;

	public void setmService(RoleMenuService mService) {
		this.mService = mService;
	}

	/**
	 * @throws IOException
	 * @Title: treeRoles
	 * @Description: 处理获取角色菜单请求
	 * @datetime 2013-1-15 下午8:44:15
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "gridroles", method = RequestMethod.GET)
	public Object gridRoles(HttpServletResponse response) throws IOException {
		logger.info("treeRoles");
		response_result = mService.gridRoles();
		response.setContentType(HTML_JSON_FLAG);
		response.getWriter().write(response_result);
		return null;
	}

	/**
	 * @throws IOException
	 * @Title: treeMenus
	 * @Description: 处理请求菜单
	 * @datetime 2013-1-15 下午9:04:15
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "treemenus", method = RequestMethod.GET)
	public Object treeMenus(
			@RequestParam(required = false, defaultValue = "-1") String node,
			@RequestParam(required = false, defaultValue = "-1") String roleId,
			HttpServletResponse response) throws IOException {
		logger.info("treeMenus");
		response.setContentType(HTML_JSON_FLAG);
		response_result = mService.treeMenus(Integer.parseInt(node),
				Integer.parseInt(roleId));
		response.getWriter().write(response_result);
		return null;
	}

	/**
	 * @Title: AUTHORIZE
	 * @Description: 角色授权
	 * @datetime 2013-1-17 下午1:57:47
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "authorize", method = RequestMethod.GET)
	public Object authorize(
			@RequestParam(required = true, defaultValue = "-1") String roleId,
			@RequestParam(required = true, defaultValue = "-1") String[] menuIds,
			HttpServletResponse response) throws IOException {
		logger.info("authorize");
		response.setContentType(HTML_JSON_FLAG);
		System.out.println("================");
		for(String s:menuIds){
			System.out.println(s);
		}
		response_result = mService.authorize(roleId, menuIds);
		response.getWriter().write(response_result);
		return null;
	}
}
