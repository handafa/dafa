/**
 * 
 */
package cn.dafa.user.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dafa.common.pojo.Criteria;
import cn.dafa.user.mapper.UserMapper;
import cn.dafa.user.model.User;

/**
 * @author 韩大发
 * @datetime 2012-8-28 下午01:36:42
 * @email:smile-gorget-song@foxmail.com
 * @summary dafa
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	private Logger logger = Logger.getLogger(UserService.class);
	@Autowired
	private UserMapper userMapper;

	/**
	 * @param userMapper
	 *            the userMapper to set
	 */
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * @Title: select
	 * @Description: TODO
	 * @datetime 2013-1-7 下午8:52:25
	 * @param
	 * @return
	 * @throws
	 */
	public User select(int id) {
		logger.info("select");
		return userMapper.select(id);
	}

	/**
	 * @Title: modify
	 * @Description: TODO
	 * @datetime 2013-1-7 下午8:52:20
	 * @param
	 * @return
	 * @throws
	 */
	public int modify(User user) {
		logger.info("modify");
		return userMapper.modify(user);
	}

	/**
	 * @Title: delete
	 * @Description: TODO
	 * @datetime 2013-1-7 下午8:52:13
	 * @param
	 * @return
	 * @throws
	 */
	public int delete(int id) {
		logger.info("delete");
		return userMapper.delete(id);
	}

	/**
	 * @Title: deleteBatch
	 * @Description: TODO
	 * @datetime 2013-1-7 下午8:52:08
	 * @param
	 * @return
	 * @throws
	 */
	public int deleteBatch(String[] ids) {
		logger.info("deleteBatch");
		return userMapper.deleteBatch(ids);
	}

	/**
	 * @Title: save
	 * @Description: TODO
	 * @datetime 2013-1-7 下午8:52:01
	 * @param
	 * @return
	 * @throws
	 */
	public int save(User user) {
		logger.info("save");
		return userMapper.save(user);
	}

	/**
	 * @Title: query
	 * @Description: TODO
	 * @datetime 2013-1-7 下午8:51:55
	 * @param
	 * @return
	 * @throws
	 */
	public List<User> query(Criteria criteria) {
		logger.info("query");
		return userMapper.query(criteria);
	}

	/**
	 * @Title: count
	 * @Description: TODO
	 * @datetime 2013-1-7 下午8:51:43
	 * @param
	 * @return
	 * @throws
	 */
	public long count(Criteria criteria) {
		logger.info("count");
		return userMapper.count(criteria);
	}

	/**
	 * @Title: resetPassword
	 * @Description: 密码重置
	 * @datetime 2013-1-14 下午1:17:08
	 * @param
	 * @return
	 * @throws
	 */
	public int resetPassword(String id) {
		logger.info("resetPassword");
		return userMapper.resetPassword(id);
	}
}
