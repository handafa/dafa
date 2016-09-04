/**  
 * @Title: RoleMenuService.java
 * @Package cn.dafa.role.service
 * @Description: 业务层
 * @author 韩大发  
 * @datetime 2013-1-15 下午8:38:18
 * @version V1.0  
 */
package cn.dafa.role.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dafa.common.pojo.Criteria;
import cn.dafa.common.util.ExtHelper;
import cn.dafa.common.util.ExtReturnJson;
import cn.dafa.common.util.TreeJson;
import cn.dafa.menu.mapper.MenuMapper;
import cn.dafa.menu.model.Menu;
import cn.dafa.role.mapper.RoleMapper;
import cn.dafa.role.mapper.RoleMenuMapper;
import cn.dafa.role.model.Role;
import cn.dafa.role.model.RoleMenu;

/**
 * @ClassName: RoleMenuService
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-15 下午8:38:18
 * @version 【V1.0】
 * @Description: 业务层
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleMenuService {
	private Logger logger = Logger.getLogger(RoleMenuService.class);
	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private MenuMapper menuMapper;

	public void setRoleMenuMapper(RoleMenuMapper roleMenuMapper) {
		this.roleMenuMapper = roleMenuMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	/**
	 * @Title: treeRoles
	 * @Description: 处理角色信息
	 * @datetime 2013-1-15 下午8:47:07
	 * @param
	 * @return
	 * @throws
	 */
	public String gridRoles() {
		logger.info("gridRoles");
		List<Role> list = roleMapper.findAll();
		long results = roleMapper.count(new Criteria());
		String json = ExtHelper.getJsonFromList(list, results);
		return json;
	}

	/**
	 * @Title: treeMenus
	 * @Description: 一次获取所有的菜单
	 * @datetime 2013-1-15 下午9:04:39
	 * @param
	 * @return
	 * @throws
	 */
	public String treeMenus(Integer node, Integer roleId) {
		logger.info("treeMenus");
		RoleMenu roleMenu = new RoleMenu();
		roleMenu.setFatherNode(node);
		roleMenu.setRoleId(roleId);
		int flag = 0;
		List<RoleMenu> list = new ArrayList<RoleMenu>();
		if (node != -1) {
			Menu menu = menuMapper.select(node);
			if (menu.getIfFather() == 0) {
				flag = 1;
				RoleMenu rm = new RoleMenu();
				rm.setMenuId(node);
				rm.setRoleId(roleId);
				list = roleMenuMapper.findBtnsByMenu(rm);
			} else {
				list = roleMenuMapper.queryMenusByRole(roleMenu);
			}
		} else {
			flag = 0;
			list = roleMenuMapper.queryMenusByRole(roleMenu);
		}
		String json = TreeJson.getRoleMenusJsons(list,
				TreeJson.FLAG_CHECKED_YES, flag);
		logger.info(json);
		return json;
	}

	/**
	 * @Title: save
	 * @Description: 保存角色菜单配置
	 * @datetime 2013-1-15 下午9:20:43
	 * @param
	 * @return
	 * @throws
	 */
	public String save(String ids) {
		return null;
	}

	/**
	 * @Title: authorize
	 * @Description: 角色授权
	 * @datetime 2013-1-17 下午1:56:59
	 * @param
	 * @return
	 * @throws
	 */
	public String authorize(String roleId, String[] menuIds) {
		logger.info("authorize");
		int role = Integer.parseInt(roleId);
		ExtReturnJson extReturnJson = null;
		roleMenuMapper.deleteMenusByRole(role);
		RoleMenu roleMenu = new RoleMenu();
		roleMenu.setRoleId(role);
		for (String s : menuIds) {
			String[] str = s.split("-");
			roleMenu.setMenuId(Integer.parseInt(str[0]));
			// roleMenu.setBtnId("QUERY");
			roleMenu.setBtnId("");
			if (str.length > 1) {
				roleMenu.setBtnId(str[1]);
			}
			roleMenuMapper.save(roleMenu);
		}
		extReturnJson = new ExtReturnJson("授权成功", true,
				ExtReturnJson.RESULT_FLAG_MSG);
		return extReturnJson.getReturnJson();
	}

}
