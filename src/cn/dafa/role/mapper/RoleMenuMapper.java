package cn.dafa.role.mapper;

import java.util.List;

import cn.dafa.base.mapper.BaseMapper;
import cn.dafa.role.model.RoleMenu;

/**
 * @ClassName: RoleMenuMapper
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-15 下午8:33:25
 * @version 【V1.0】
 * @Description: TODO
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

	/**
	 * @Title: queryMenusByRole
	 * @Description: 根据角色查询菜单并且判断是否选中
	 * @datetime 2013-1-16 上午10:16:52
	 * @param
	 * @return
	 * @throws
	 */
	public List<RoleMenu> queryMenusByRole(RoleMenu roleMenu);

	/**
	 * @Title: deleteMenusByRole
	 * @Description: 根据角色编码进行删除
	 * @datetime 2013-1-17 下午2:04:43
	 * @param
	 * @return
	 * @throws
	 */
	public int deleteMenusByRole(Integer roleId);

	/**
	 * @Title: findBtnsByMenu
	 * @Description: 根据菜单查找按钮
	 * @datetime 2013-1-18 下午9:42:31
	 * @param
	 * @return
	 * @throws
	 */
	public List<RoleMenu> findBtnsByMenu(RoleMenu roleMenu);
}