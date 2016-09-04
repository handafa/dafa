/**
 * 
 */
package cn.dafa.menu.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dafa.common.pojo.Criteria;
import cn.dafa.menu.mapper.MenuMapper;
import cn.dafa.menu.model.Menu;

/**
 * @author 韩大发
 * @datetime 2012-10-29 下午09:32:34
 * @email:smile-gorget-song@foxmail.com
 * @summary dafa
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuService {
	private Logger logger = Logger.getLogger(MenuService.class);
	@Autowired
	protected MenuMapper menuMapper;

	/**
	 * @param menuMapper
	 *            the menuMapper to set
	 */
	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	/**
	 * @Title: select
	 * @Description: TODO
	 * @datetime 2013-1-3 下午1:49:14
	 * @param
	 * @return
	 * @throws
	 */
	public Menu select(int id) {
		logger.info("select");
		return menuMapper.select(id);
	}

	/**
	 * @Title: modify
	 * @Description: TODO
	 * @datetime 2013-1-3 下午1:49:46
	 * @param
	 * @return
	 * @throws
	 */
	public int modify(Menu menu) {
		logger.info("modify");
		return menuMapper.modify(menu);
	}

	/**
	 * @Title: delete
	 * @Description: 删除
	 * @datetime 2013-1-5 下午8:17:57
	 * @param
	 * @return
	 * @throws
	 */
	public int delete(int id) {
		logger.info("delete");
		return menuMapper.delete(id);
	}

	/**
	 * @Title: deleteBatch
	 * @Description: TODO
	 * @datetime 2013-1-3 下午1:49:52
	 * @param
	 * @return
	 * @throws
	 */
	public int deleteBatch(String[] ids) {
		logger.info("deleteBatch");
		return menuMapper.deleteBatch(ids);
	}

	/**
	 * @Title: save
	 * @Description: TODO
	 * @datetime 2013-1-3 下午1:50:04
	 * @param
	 * @return
	 * @throws
	 */
	public int save(Menu menu) {
		logger.info("save");
		return menuMapper.save(menu);
	}

	/**
	 * @Title: find
	 * @Description: TODO
	 * @datetime 2013-1-4 上午11:02:16
	 * @param
	 * @return
	 * @throws
	 */
	public List<Menu> query(Criteria criteria) {
		logger.info("query");
		return menuMapper.query(criteria);
	}

	/**
	 * @Title: count
	 * @Description: TODO
	 * @datetime 2013-1-4 上午11:03:34
	 * @param
	 * @return
	 * @throws
	 */
	public long count(Criteria criteria) {
		logger.info("count");
		return menuMapper.count(criteria);
	}

	/**
	 * @Title: findMenus
	 * @Description: 根据父节点获取子节点
	 * @datetime 2013-1-4 下午4:58:42
	 * @param
	 * @return
	 * @throws
	 */
	public List<Menu> findMenus(String fatherNode) {
		logger.info("findMenus");
		return menuMapper.findMenus(fatherNode);
	}

	/**
	 * @Title: findAllMenus
	 * @Description: TODO
	 * @datetime 2013-1-4 下午9:24:53
	 * @param
	 * @return
	 * @throws
	 */
	public List<Menu> findAllMenus() {
		logger.info("findAllMenus");
		return menuMapper.findAllMenus();
	}

	/**
	 * @Title: updateIfFather
	 * @Description: 更改父节点
	 * @datetime 2013-1-5 下午2:31:49
	 * @param
	 * @return
	 * @throws
	 */
	public int updateIfFather(int fatherNode) {
		logger.info("updateIfFather");
		return menuMapper.updateIfFather(fatherNode);
	}

	/**
	 * @Title: countChildrenNum
	 * @Description: 查出该父节点的孩子数目
	 * @datetime 2013-1-5 下午2:33:47
	 * @param
	 * @return
	 * @throws
	 */
	public int countChildrenNum(int fatherNode) {
		logger.info("countChildrenNum");
		return menuMapper.countChildrenNum(fatherNode);
	}

	/**
	 * @Title: countChildrenNumByChild
	 * @Description: 根据孩子节点的id求出该父节点的孩子数目
	 * @datetime 2013-1-5 下午8:31:03
	 * @param
	 * @return
	 * @throws
	 */
	public int countChildrenNumByChild(int id) {
		logger.info("countChildrenNumByChild");
		return menuMapper.countChildrenNumByChild(id);
	}
}
