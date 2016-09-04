package cn.dafa.common.util;

import java.util.List;

import org.apache.log4j.Logger;

import cn.dafa.group.model.Group;
import cn.dafa.menu.model.Menu;
import cn.dafa.role.model.RoleMenu;

/**
 * @ClassName: MenuJson
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-4 下午4:29:46
 * @version 【V1.0】
 * @Description: 拼成树形json串
 */
public class TreeJson {
	private static Logger logger = Logger.getLogger(TreeJson.class);
	public static final int FLAG_CHECKED_YES = 1;
	public static final int FLAG_CHECKED_NO = 0;

	/**
	 * @Title: getMenuJsons
	 * @Description: 拼成树形json串
	 * @datetime 2013-1-4 下午4:34:00
	 * @param
	 * @return
	 * @throws
	 */
	public static String getMenuJsons(List<Menu> list, int flag) {
		logger.info("getMenuJsons");
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		int i = 0;
		for (Menu m : list) {
			i++;
			buffer.append("{");
			buffer.append("id:").append(m.getId()).append(",");
			buffer.append("text:'").append(m.getName()).append("',");
			if (m.getIfFather() == 0) {
				buffer.append("leaf:").append(true).append(",");
				buffer.append("cls:'").append("file").append("',");
			} else {
				buffer.append("leaf:").append(false).append(",");
				buffer.append("cls:'").append("folder").append("',");
			}
			if (flag == FLAG_CHECKED_YES) {
				buffer.append("checked:").append(false).append(",");
			}
			buffer.append("url:'").append(m.getUrl()).append("'");
			if (list.size() != i) {
				buffer.append("},");
			} else {
				buffer.append("}");
			}
		}
		buffer.append("]");
		return buffer.toString();
	}

	/**
	 * @param roleMenuMapper
	 * @Title: getRoleMenusJsons
	 * @Description: 根据角色获取菜单
	 * @datetime 2013-1-15 下午9:14:44
	 * @param
	 * @return
	 * @throws
	 */
	public static String getRoleMenusJsons(List<RoleMenu> list, int flag,
			int btnFlag) {
		logger.info("getRoleMenusJsons");
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		int i = 0;
		for (RoleMenu roleMenu : list) {
			i++;
			buffer.append("{");
			if (btnFlag == 0) {
				buffer.append("id:").append(roleMenu.getMenuId()).append(",");
				buffer.append("text:'").append(roleMenu.getMenuName())
						.append("',");

				buffer.append("leaf:").append(false).append(",");
				buffer.append("cls:'").append("folder").append("',");
			} else {
				buffer.append("id:'")
						.append(roleMenu.getMenuId() + "-"
								+ roleMenu.getBtnId()).append("',");
				buffer.append("text:'").append(roleMenu.getBtnName())
						.append("',");
				buffer.append("leaf:").append(true).append(",");
				buffer.append("cls:'").append("file").append("',");
			}

			// if (roleMenu.getIfFather() == 0) {
			// buffer.append("leaf:").append(true).append(",");
			// buffer.append("cls:'").append("file").append("',");
			// } else {
			// buffer.append("leaf:").append(false).append(",");
			// buffer.append("cls:'").append("folder").append("',");
			// }
			if (flag == FLAG_CHECKED_YES) {
				if (roleMenu.getChecked() != null) {
					buffer.append("checked:").append(true);
				} else {
					buffer.append("checked:").append(false);
				}
			}
			if (list.size() != i) {
				buffer.append("},");
			} else {
				buffer.append("}");
			}
		}
		buffer.append("]");
		return buffer.toString();
	}

	/**
	 * @Title: getTreeJsons
	 * @Description: 获取组织树形json
	 * @datetime 2013-1-11 下午1:57:23
	 * @param
	 * @return
	 * @throws
	 */
	public static String getGroupJsons(List<Group> list, int flag) {
		logger.info("getGroupJsons");
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		int i = 0;
		for (Group group : list) {
			i++;
			buffer.append("{");
			if (flag == FLAG_CHECKED_YES) {
				buffer.append("checked:").append(false).append(",");
			}
			buffer.append("id:").append(group.getId()).append(",");
			buffer.append("text:'").append(group.getGroupName()).append("',");
			if (group.getIfFather() == 0) {
				buffer.append("leaf:").append(true).append(",");
				buffer.append("cls:'").append("file").append("'");
			} else {
				buffer.append("leaf:").append(false).append(",");
				buffer.append("cls:'").append("folder").append("'");
			}
			if (list.size() != i) {
				buffer.append("},");
			} else {
				buffer.append("}");
			}
		}
		buffer.append("]");
		return buffer.toString();
	}

	/**
	 * @Title: getJsonFromBean
	 * @Description: 拼串
	 * @datetime 2013-1-17 下午9:14:32
	 * @param
	 * @return
	 * @throws
	 */
	public static String getJsonFromBean(Group group, int flag) {
		logger.info("getJsonFromBean");
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		if (flag == FLAG_CHECKED_YES) {
			buffer.append("checked:").append(false).append(",");
		}
		buffer.append("id:'").append(group.getId()).append("',");
		buffer.append("text:'").append(group.getGroupName()).append("',");
		if (group.getIfFather() == 1) {
			buffer.append("leaf:").append(false).append(",");
			buffer.append("cls:'").append("folder").append("'");
		} else {
			buffer.append("leaf:").append(true).append(",");
			buffer.append("cls:'").append("file").append("'");
		}
		buffer.append("}");
		return buffer.toString();
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @datetime 2012-11-15 下午9:17:41
	 * @param
	 * @return
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
