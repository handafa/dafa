/**
 * 
 */
package cn.dafa.menu.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dafa.base.controller.BaseController;
import cn.dafa.common.util.ExtHelper;
import cn.dafa.common.util.TreeJson;
import cn.dafa.menu.model.Menu;
import cn.dafa.menu.service.MenuService;

/**
 * @ClassName: MenuController
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2012-11-4 下午10:03:29
 * @version 【V1.0】
 * @Description: 菜单管理
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController extends BaseController<Menu> {
	private Logger logger = Logger.getLogger(MenuController.class);
	@Resource
	private MenuService mService;

	/**
	 * @throws IOException
	 * @Title: getAllMenus
	 * @Description: 获取菜单
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 * @datetime 2012-11-6 下午10:43:37
	 * @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query(HttpServletRequest request,
			HttpServletResponse response, Menu menu) throws IOException {
		logger.info("query");
		long results = mService.count(null);
		List<Menu> list = mService.query(null);
		String json = ExtHelper.getJsonFromList(list, results);
		response.setContentType(HTML_JSON_FLAG);
		response.getWriter().write(json);
		return null;
	}

	@RequestMapping(value = "/treeMenus", method = RequestMethod.GET)
	public String treeMenus(
			@RequestParam(required = false, defaultValue = "-1") String node,
			HttpServletResponse response) throws IOException {
		logger.info("treeMenus");
		List<Menu> list = mService.findMenus(node);
		String json = TreeJson.getMenuJsons(list, TreeJson.FLAG_CHECKED_NO);
		response.setContentType(HTML_JSON_FLAG);
		response.getWriter().write(json);
		return null;
	}

	/**
	 * @Title: save
	 * @Description: TODO
	 * @datetime 2012-11-12 下午8:30:56
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Menu menu, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("save");
		response.setContentType(HTML_JSON_FLAG);
		int fatherNode = menu.getFatherNode();
		mService.updateIfFather(fatherNode);
		int result = mService.save(menu);
		if (result > 0) {
			response.getWriter().write("{success:true,msg:'保存成功'}");
		} else {
			response.getWriter().write("{success:false,msg:'保存失败'}");
		}
		logger.info(menu.toString());
		return null;
	}

	/**
	 * @throws IOException
	 * @Title: getMenu
	 * @Description: 根据菜单主键获取菜单实体
	 * @datetime 2012-11-12 下午8:36:34
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public Menu select(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("select");
		response.setContentType(HTML_JSON_FLAG);
		String id = request.getParameter("id");
		Menu menu = mService.select(Integer.parseInt(id));
		String json = null;
		if (menu != null) {
			json = "{success:true,data:" + ExtHelper.getJsonFromBean(menu)
					+ "}";
			response.getWriter().write(json);
		} else {
			response.getWriter().write("{success:false}");
		}
		return null;
	}

	/**
	 * @Title: Modify
	 * @Description: 修改菜单信息
	 * @datetime 2012-11-14 下午9:55:22
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Menu menu, HttpServletResponse response) {
		logger.info("modify");
		response.setContentType(HTML_JSON_FLAG);
		if (menu != null) {
			try {
				int result = mService.modify(menu);
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
	 * @Title: Delete
	 * @Description: 删除菜单信息
	 * @datetime 2012-11-14 下午10:31:53
	 * @param
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("delete");
		response.setContentType(HTML_JSON_FLAG);
		try {
			// 要删除的节点编码
			int id = Integer.parseInt(request.getParameter("id"));
			// 获取该实体
			Menu m = this.mService.select(id);
			// 判断该节点的孩子数目，如果有孩子则不能删除
			int childrenNum = this.mService.countChildrenNum(id);
			if (childrenNum > 0) {
				// 表示为父节点不能删除
				response.getWriter().write("{success:false,msg:'请先删除该节点的子节点'}");
			} else {
				// 求出该节点父节点的孩子数目
				childrenNum = this.mService.countChildrenNum(m.getFatherNode());

				int result = this.mService.delete(id);
				if (result > 0) {
					if (childrenNum == 1) {
						// 加入该节点只有一个孩子，那么删除之后，要将其是否为父节点改为否
						Menu menu = new Menu();
						menu.setId(m.getFatherNode());
						menu.setIfFather(0);
						this.mService.modify(menu);
					}
					response.getWriter().write("{success:true,msg:'删除成功'}");
				} else {
					response.getWriter().write("{success:false,msg:'删除失败'}");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param mService
	 *            the mService to set
	 */
	public void setmService(MenuService mService) {
		this.mService = mService;
	}

	/**
	 * @return the mService
	 */
	public MenuService getmService() {
		return mService;
	}

}
