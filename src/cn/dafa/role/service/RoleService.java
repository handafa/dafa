/**  
 * @Title: RoleService.java
 * @Package cn.dafa.role.service
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-14 下午3:20:19
 * @version V1.0  
 */
package cn.dafa.role.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dafa.common.pojo.Criteria;
import cn.dafa.common.util.ExtHelper;
import cn.dafa.common.util.ExtReturnJson;
import cn.dafa.role.mapper.RoleMapper;
import cn.dafa.role.model.Role;

/**
 * @ClassName: RoleService
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-14 下午3:20:19
 * @version 【V1.0】
 * @Description: TODO
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleService {
	private Logger logger = Logger.getLogger(RoleService.class);
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * @Title: query
	 * @Description: 条件查询
	 * @datetime 2013-1-14 下午8:41:10
	 * @param
	 * @return
	 * @throws
	 */
	public String query(Criteria criteria) {
		logger.info("query");
		List<Role> list = roleMapper.query(criteria);
		long results = roleMapper.count(criteria);
		return ExtHelper.getJsonFromList(list, results);
	}

	/**
	 * @Title: count
	 * @Description: 总数
	 * @datetime 2013-1-14 下午8:41:54
	 * @param
	 * @return
	 * @throws
	 */
	public long count(Criteria criteria) {
		logger.info("count");
		return roleMapper.count(criteria);
	}

	/**
	 * @Title: save
	 * @Description: 保存
	 * @datetime 2013-1-14 下午8:52:20
	 * @param
	 * @return
	 * @throws
	 */
	public String save(Role role) {
		logger.info("save");
		ExtReturnJson extReturnJson = null;
		int result = 0;
		try {
			result = roleMapper.save(role);
			if (result > 0) {
				extReturnJson = new ExtReturnJson("保存成功", true,
						ExtReturnJson.RESULT_FLAG_MSG);
			} else {
				extReturnJson = new ExtReturnJson("保存失败", false,
						ExtReturnJson.RESULT_FLAG_MSG);

			}
		} catch (Exception e) {
			extReturnJson = new ExtReturnJson("保存时发生异常：" + e.getMessage(),
					false, ExtReturnJson.RESULT_FLAG_MSG);
		}
		return extReturnJson.getReturnJson();
	}

	/**
	 * @Title: select
	 * @Description: 根据主键查询
	 * @datetime 2013-1-14 下午8:42:26
	 * @param
	 * @return
	 * @throws
	 */
	public String select(int id) {
		logger.info("select");
		ExtReturnJson extReturnJson = null;
		Role role = null;
		try {
			role = roleMapper.select(id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			extReturnJson = new ExtReturnJson("查询时发生异常：" + e.getMessage(),
					false, ExtReturnJson.RESULT_FLAG_DATA);
		}
		if (role != null) {
			extReturnJson = new ExtReturnJson(ExtHelper.getJsonFromBean(role),
					true, ExtReturnJson.RESULT_FLAG_DATA);
		} else {
			extReturnJson = new ExtReturnJson("查询失败", false,
					ExtReturnJson.RESULT_FLAG_DATA);
		}
		return extReturnJson.getReturnJson();
	}

	/**
	 * @Title: modify
	 * @Description: 根据主键进行修改
	 * @datetime 2013-1-14 下午8:43:24
	 * @param
	 * @return
	 * @throws
	 */
	public String modify(Role role) {
		logger.info("modify");
		ExtReturnJson extReturnJson = null;
		if (role != null) {
			try {
				int result = roleMapper.modify(role);
				if (result > 0) {
					extReturnJson = new ExtReturnJson("修改成功", true,
							ExtReturnJson.RESULT_FLAG_MSG);
				} else {
					extReturnJson = new ExtReturnJson("修改失败", false,
							ExtReturnJson.RESULT_FLAG_MSG);
				}
			} catch (Exception e) {
				extReturnJson = new ExtReturnJson("修改时发生异常：" + e.getMessage(),
						false, ExtReturnJson.RESULT_FLAG_MSG);
			}
		}
		return extReturnJson.getReturnJson();
	}

	/**
	 * @Title: delete
	 * @Description: 根据主键进行删除
	 * @datetime 2013-1-14 下午8:44:06
	 * @param
	 * @return
	 * @throws
	 */
	public int delete(int id) {
		logger.info("delete");
		return roleMapper.delete(id);
	}

	/**
	 * @Title: deleteBatch
	 * @Description: 批量删除
	 * @datetime 2013-1-14 下午8:44:31
	 * @param
	 * @return
	 * @throws
	 */
	public String deleteBatch(String[] ids) {
		logger.info("deleteBatch");
		ExtReturnJson extReturnJson = null;
		int result = 0;
		try {
			result = roleMapper.deleteBatch(ids);
			if (result > 0) {
				extReturnJson = new ExtReturnJson("删除成功", true,
						ExtReturnJson.RESULT_FLAG_MSG);
			} else {
				extReturnJson = new ExtReturnJson("删除失败", false,
						ExtReturnJson.RESULT_FLAG_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			extReturnJson = new ExtReturnJson("删除时发生异常：" + e.getMessage(),
					false, ExtReturnJson.RESULT_FLAG_MSG);
		}
		return extReturnJson.getReturnJson();
	}

	/**
	 * @param roleMapper
	 *            the roleMapper to set
	 */
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

}
