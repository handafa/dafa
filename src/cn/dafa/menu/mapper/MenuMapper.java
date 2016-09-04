package cn.dafa.menu.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.dafa.base.mapper.BaseMapper;
import cn.dafa.menu.model.Menu;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {
	/**
	 * @Title: findMenu
	 * @Description: 根据父节点获取子节点
	 * @datetime 2013-1-4 下午4:56:53
	 * @param
	 * @return
	 * @throws
	 */
	public List<Menu> findMenus(String fatherNode);

	/**
	 * @Title: findAllMenu
	 * @Description: TODO
	 * @datetime 2013-1-4 下午9:22:59
	 * @param
	 * @return
	 * @throws
	 */
	public List<Menu> findAllMenus();

	/**
	 * @Title: updateIfFather
	 * @Description: 更改父节点
	 * @datetime 2013-1-5 下午2:31:49
	 * @param
	 * @return
	 * @throws
	 */
	public int updateIfFather(int fatherNode);

	/**
	 * @Title: countChildrenNum
	 * @Description: 查出该父节点的孩子数目
	 * @datetime 2013-1-5 下午2:33:47
	 * @param
	 * @return
	 * @throws
	 */
	public int countChildrenNum(int fatherNode);

	/**
	 * @Title: countChildrenNumByChild
	 * @Description: 根据孩子节点的id求出该父节点的孩子数目
	 * @datetime 2013-1-5 下午8:29:57
	 * @param
	 * @return
	 * @throws
	 */
	public int countChildrenNumByChild(int id);
}