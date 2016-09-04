package cn.dafa.role.mapper;

import java.util.List;

import cn.dafa.base.mapper.BaseMapper;
import cn.dafa.role.model.Role;

/**
 * @ClassName: RoleMapper
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-11 下午1:07:26
 * @version 【V1.0】
 * @Description: TODO
 */
public interface RoleMapper extends BaseMapper<Role> {

	/**
	 * @Title: findAll
	 * @Description: 获取全部角色
	 * @datetime 2013-1-15 下午8:49:11
	 * @param
	 * @return
	 * @throws
	 */
	public List<Role> findAll();

}