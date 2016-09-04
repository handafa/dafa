/**
 * 
 */
package cn.dafa.login.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dafa.user.mapper.UserMapper;

/**
 * @author 韩大发
 * @datetime 2012-8-29 上午10:56:03
 * @email:smile-gorget-song@foxmail.com
 * @summary dafa
 */
@Service
@SuppressWarnings("unused")
public class LoginService{
	private Logger logger = Logger.getLogger(LoginService.class);
	@Autowired
	private UserMapper userMapper;

}
