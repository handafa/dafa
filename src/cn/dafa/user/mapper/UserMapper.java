package cn.dafa.user.mapper;

import cn.dafa.base.mapper.BaseMapper;
import cn.dafa.user.model.User;

public interface UserMapper extends BaseMapper<User> {
	/**
	 * @Title: resetPassword
	 * @Description: 用户密码重置功能
	 * @datetime 2013-1-14 下午1:12:57
	 * @param
	 * @return
	 * @throws
	 */
	public int resetPassword(String id);
}