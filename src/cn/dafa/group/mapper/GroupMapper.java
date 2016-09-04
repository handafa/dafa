package cn.dafa.group.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.dafa.base.mapper.BaseMapper;
import cn.dafa.group.model.Group;

/**
 * @ClassName: GroupMapper
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-11 下午1:07:49
 * @version 【V1.0】
 * @Description: TODO
 */
@Repository
public interface GroupMapper extends BaseMapper<Group> {
	/**
	 * @Title: findGroups
	 * @Description: 根据父节点查找孩子
	 * @datetime 2013-1-11 下午1:24:37
	 * @param
	 * @return
	 * @throws
	 */
	public List<Group> findGroups(Integer fatherNode);

	/**
	 * @Title: updateIfFather
	 * @Description: 更改父节点
	 * @datetime 2013-1-11 下午1:24:37
	 * @param
	 * @return
	 * @throws
	 */
	public int updateIfFather(Integer fatherNode);

	/**
	 * @Title: countChildrenNum
	 * @Description: 查出该父节点的孩子数目
	 * @datetime 2013-1-11 下午1:24:37
	 * @param
	 * @return
	 * @throws
	 */
	public int countChildrenNum(Integer fatherNode);

	/**
	 * @Title: countChildrenNumByChild
	 * @Description: 根据孩子节点的id求出该父节点的孩子数目
	 * @datetime 2013-1-11 下午1:24:37
	 * @param
	 * @return
	 * @throws
	 */
	public int countChildrenNumByChild(String id);

	/**
	 * @Title: findGroupsMaxGroupId
	 * @Description: 根据父节点求出该组最大值
	 * @datetime 2013-1-15 下午1:28:51
	 * @param
	 * @return
	 * @throws
	 */
	public int findGroupsMaxGroupId(Integer fatherNode);

	/**
	 * @Title: findFatherGroupId
	 * @Description: 根据父节点获取父节点groupId
	 * @datetime 2013-1-15 下午1:35:58
	 * @param
	 * @return
	 * @throws
	 */
	public String findFatherGroupId(Integer fatherNode);

	/**
	 * @Title: countGroupsByFather
	 * @Description: 根据父节点求出最大数目
	 * @datetime 2013-1-15 下午1:29:59
	 * @param
	 * @return
	 * @throws
	 */
	public int countGroupsByFather(Integer fatherNode);

	/**
	 * @Title: findAllGroups
	 * @Description: 一次获取所有的组织
	 * @datetime 2013-1-17 下午9:04:26
	 * @param
	 * @return
	 * @throws
	 */
	public List<Group> findAllGroups();
}