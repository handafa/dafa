/**  
 * @Title: GroupController.java
 * @Package cn.dafa.group
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-11 下午1:09:02
 * @version V1.0  
 */
package cn.dafa.group.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dafa.base.controller.BaseController;
import cn.dafa.common.springmvc.DateConvertEditor;
import cn.dafa.group.model.Group;
import cn.dafa.group.service.GroupService;

/**
 * @ClassName: GroupController
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-11 下午1:09:02
 * @version 【V1.0】
 * @Description: 组织
 */
@Controller
@RequestMapping(value = "group")
public class GroupController extends BaseController<Group> {
	private Logger logger = Logger.getLogger(GroupController.class);

	@Resource
	private GroupService mService;

	/**
	 * @Title: treeGroups
	 * @Description: 获取组织树形
	 * @datetime 2013-1-11 下午2:02:46
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/treeGroups", method = RequestMethod.GET)
	public Object treeGroups(HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "-1") String node)
			throws IOException {
		logger.info("treeGroups");
		response.setContentType(HTML_JSON_FLAG);
		response_result = mService.findAllGroups(Integer.parseInt(node),0);
		response.getWriter().write(response_result);
		return null;
	}

	/**
	 * @Title: save
	 * @Description: 保存组织
	 * @datetime 2013-1-15 上午10:16:54
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Object save(Group group, HttpServletResponse response)
			throws IOException {
		logger.info("save");
		response.setContentType(HTML_JSON_FLAG);
		response_result = mService.save(group);
		response.getWriter().write(response_result);
		return null;
	}

	/**
	 * @Title: select
	 * @Description: 查出一条数据
	 * @datetime 2013-1-15 上午10:21:15
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public Object select(
			@RequestParam(required = false, defaultValue = "0") String id,
			HttpServletResponse response) throws IOException {
		logger.info("select");
		response.setContentType(HTML_JSON_FLAG);
		response_result = mService.select(Integer.parseInt(id));
		response.getWriter().write(response_result);
		return null;
	}

	/**
	 * @Title: modify
	 * @Description: 修改数据
	 * @datetime 2013-1-15 上午10:24:09
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public Object modify(Group group, HttpServletResponse response)
			throws IOException {
		logger.info("modify");
		response.setContentType(HTML_JSON_FLAG);
		response_result = mService.modify(group);
		response.getWriter().write(response_result);
		return null;
	}

	/**
	 * @throws IOException
	 * @Title: delete
	 * @Description: 删除某个节点
	 * @datetime 2013-1-15 上午10:46:19
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(
			@RequestParam(required = false, defaultValue = "0") String id,
			HttpServletResponse response) throws IOException {
		logger.info("delete");
		response.setContentType(HTML_JSON_FLAG);
		response_result = mService.delete(Integer.parseInt(id));
		response.getWriter().write(response_result);
		return null;
	}

	public void setmService(GroupService mService) {
		this.mService = mService;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DateConvertEditor(
				"yyyy-MM-dd"));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
