/**  
 * @Title: GroupService.java
 * @Package cn.dafa.group.service
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-11 下午1:14:56
 * @version V1.0  
 */
package cn.dafa.group.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dafa.common.pojo.Criteria;
import cn.dafa.common.util.ExtHelper;
import cn.dafa.common.util.ExtReturnJson;
import cn.dafa.common.util.TreeJson;
import cn.dafa.group.mapper.GroupMapper;
import cn.dafa.group.model.Group;

/**
 * @ClassName: GroupService
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-11 下午1:14:56
 * @version 【V1.0】
 * @Description: TODO
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupService {
	private static Logger logger = Logger.getLogger(GroupService.class);
	@Autowired
	protected GroupMapper groupMapper;

	private final int SAVE = 1;

	private final int MODIFY = 2;

	/**
	 * @param groupMapper
	 *            the groupMapper to set
	 */
	public void setGroupMapper(GroupMapper groupMapper) {
		this.groupMapper = groupMapper;
	}

	/**
	 * @Title: select
	 * @Description: TODO
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public String select(int id) {
		logger.info("select");
		ExtReturnJson extReturnJson = null;
		Group group = groupMapper.select(id);
		if (group != null) {
			extReturnJson = new ExtReturnJson(ExtHelper.getJsonFromBean(group),
					true, ExtReturnJson.RESULT_FLAG_DATA);
		} else {
			return "{success:false}";
		}
		return extReturnJson.getReturnJson();
	}

	/**
	 * @Title: modify
	 * @Description: TODO
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public String modify(Group group) {
		logger.info("modify");
		ExtReturnJson extReturnJson = null;
		if (group != null) {
			group.setGroupId(getGroupId(group.getFatherNode(), MODIFY));
			int result = groupMapper.modify(group);
			if (result > 0) {
				extReturnJson = new ExtReturnJson("修改成功", true,
						ExtReturnJson.RESULT_FLAG_MSG);
			} else {
				extReturnJson = new ExtReturnJson("修改失败", false,
						ExtReturnJson.RESULT_FLAG_MSG);
			}
		}
		return extReturnJson.getReturnJson();
	}

	/**
	 * @Title: delete
	 * @Description: 删除
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public String delete(int id) {
		logger.info("delete");
		ExtReturnJson extReturnJson = null;
		// 获取该实体
		Group g = groupMapper.select(id);
		// 判断该节点的孩子数目，如果有孩子则不能删除
		int childrenNum = this.countChildrenNum(id);
		if (childrenNum > 0) {
			// 表示为父节点不能删除
			extReturnJson = new ExtReturnJson("请先删除该节点的子节点", false,
					ExtReturnJson.RESULT_FLAG_MSG);
		} else {
			// 求出该节点父节点的孩子数目
			childrenNum = this.countChildrenNum(g.getFatherNode());
			int result = groupMapper.delete(id);
			if (result > 0) {
				if (childrenNum == 1) {
					// 加入该节点只有一个孩子，那么删除之后，要将其是否为父节点改为否
					Group group = new Group();
					group.setId(g.getFatherNode());
					group.setIfFather(0);
					this.modify(group);
				}
				extReturnJson = new ExtReturnJson("删除成功", true,
						ExtReturnJson.RESULT_FLAG_MSG);
			} else {
				extReturnJson = new ExtReturnJson("删除失败", false,
						ExtReturnJson.RESULT_FLAG_MSG);
			}
		}
		return extReturnJson.getReturnJson();
	}

	/**
	 * @Title: deleteBatch
	 * @Description: TODO
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public int deleteBatch(String[] ids) {
		logger.info("deleteBatch");
		return groupMapper.deleteBatch(ids);
	}

	/**
	 * @Title: save
	 * @Description: TODO
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public String save(Group group) {
		logger.info("save");
		ExtReturnJson extReturnJson = null;
		System.out.println(group.getFatherNode());
		int fatherNode = group.getFatherNode();
		// 获取
		group.setGroupId(getGroupId(fatherNode, SAVE));
		this.updateIfFather(fatherNode);
		int result = groupMapper.save(group);
		if (result > 0) {
			extReturnJson = new ExtReturnJson("保存成功", true,
					ExtReturnJson.RESULT_FLAG_MSG);
		} else {
			extReturnJson = new ExtReturnJson("保存失败", false,
					ExtReturnJson.RESULT_FLAG_MSG);
		}
		return extReturnJson.getReturnJson();
	}

	/**
	 * @Title: getGroupId
	 * @Description: 根据父节点获取groupid
	 * @datetime 2013-1-15 下午1:43:17
	 * @param
	 * @return
	 * @throws
	 */
	private String getGroupId(int fatherNode, int flag) {
		logger.info("getGroupId");
		// 获取父节点的groupId
		String groupId = "";
		int countchildren = 0;
		groupId = groupMapper.findFatherGroupId(fatherNode);
		if (groupId == null
				|| groupId.trim().toLowerCase().equalsIgnoreCase("null")) {
			groupId = "";
		}
		if (flag == SAVE) {
			countchildren = groupMapper.countChildrenNum(fatherNode);
		} else if (flag == MODIFY) {
			countchildren = groupMapper.findGroupsMaxGroupId(fatherNode);
		}
		groupId += (countchildren + 1001);
		return groupId;
	}

	/**
	 * @Title: find
	 * @Description: TODO
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public List<Group> query(Criteria criteria) {
		logger.info("query");
		return groupMapper.query(criteria);
	}

	/**
	 * @Title: count
	 * @Description: TODO
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public long count(Criteria criteria) {
		logger.info("count");
		return groupMapper.count(criteria);
	}

	/**
	 * @Title: findGroups
	 * @Description: 根据父节点获取子节点
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public String findGroups(Integer fatherNode) {
		logger.info("findGroups");
		List<Group> list = groupMapper.findGroups(fatherNode);
		return TreeJson.getGroupJsons(list, TreeJson.FLAG_CHECKED_NO);
	}

	/**
	 * @Title: findAllGroups
	 * @Description: 一次获取全部的组织
	 * @datetime 2013-1-17 下午9:06:04
	 * @param
	 * @return
	 * @throws
	 */
	public String findAllGroups(Integer fatherNode, int c) {
		logger.info("findAllGroups");
		Group g = groupMapper.select(fatherNode);
		List<Group> list = groupMapper.findGroups(fatherNode);
		String s = "";
		if (list != null && list.size() > 0) {
			s += "{\"children\":[";
			int length = list.size();
			for (Group group : list) {
				s += findAllGroups(group.getId(), length);
				length--;
			}
			s += "],\"cls\":\"folder\",\"id\":" + g.getId()
					+ ",\"leaf\":false,\"text\":\"" + g.getGroupName() + "\"}";
		} else {
			s += "{\"children\":[],\"cls\":\"file\",\"id\":" + g.getId()
					+ ",\"leaf\":true,\"text\":\"" + g.getGroupName() + "\"}";
		}
		if (c > 1) {
			s += ",";
		}
		return s;
	}

	/**
	 * @Title: updateIfFather
	 * @Description: 更改父节点
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public int updateIfFather(Integer fatherNode) {
		logger.info("updateIfFather");
		return groupMapper.updateIfFather(fatherNode);
	}

	/**
	 * @Title: countChildrenNum
	 * @Description: 查出该父节点的孩子数目
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public int countChildrenNum(Integer fatherNode) {
		logger.info("countChildrenNum");
		return groupMapper.countChildrenNum(fatherNode);
	}

	/**
	 * @Title: countChildrenNumByChild
	 * @Description: 根据孩子节点的id求出该父节点的孩子数目
	 * @datetime 2013-1-11 下午1:14:56
	 * @param
	 * @return
	 * @throws
	 */
	public int countChildrenNumByChild(String id) {
		logger.info("countChildrenNumByChild");
		return groupMapper.countChildrenNumByChild(id);
	}
}
