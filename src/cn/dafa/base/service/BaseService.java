/**  
 * @Title: BaseService.java
 * @Package cn.dafa.base.service
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2012-11-7 上午10:36:50
 * @version V1.0  
 */
package cn.dafa.base.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import cn.dafa.base.mapper.BaseMapper;
import cn.dafa.common.pojo.Criteria;

/**
 * @ClassName: BaseService
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2012-11-7 上午10:36:50
 * @version 【V1.0】
 * @Description: TODO
 */
public class BaseService<T extends Serializable> {
	protected Logger logger = Logger.getLogger(getClass());
	protected BaseMapper<T> mBaseMapper;

	/**
	 * @Title: delete
	 * @Description: 根据主键进行删除
	 * @datetime 2012-12-31 下午2:39:36
	 * @param 主键
	 * @return
	 * @throws
	 */
	public int delete(Integer id) {
		logger.info("delete");
		return mBaseMapper.delete(id);
	}

	/**
	 * @Title: deleteBatch
	 * @Description: 根据主键进行批量删除
	 * @datetime 2012-12-31 下午2:41:04
	 * @param
	 * @return
	 * @throws
	 */
	public int deleteBatch(String[] ids) {
		logger.info("deleteBatch");
		return mBaseMapper.deleteBatch(ids);
	}

	/**
	 * @Title: save
	 * @Description: 写入数据
	 * @datetime 2012-12-31 下午2:48:19
	 * @param
	 * @return
	 * @throws
	 */
	public int save(T entity) {
		logger.info("insert");
		return mBaseMapper.save(entity);
	}


	/**
	 * @Title: modify
	 * @Description: 修改数据
	 * @datetime 2012-12-31 下午3:01:18
	 * @param
	 * @return
	 * @throws
	 */
	public int modify(T entity) {
		logger.info("updateByPrimaryKeySelective");
		return mBaseMapper.modify(entity);
	}

	/**
	 * @Title: select
	 * @Description: 根据主键获取
	 * @datetime 2012-12-31 下午3:02:27
	 * @param
	 * @return
	 * @throws
	 */
	public T select(Integer id) {
		logger.info("select");
		return mBaseMapper.select(id);
	}

	/**
	 * @Title: find
	 * @Description: 根据查询条件获取
	 * @datetime 2012-12-31 下午3:02:59
	 * @param
	 * @return
	 * @throws
	 */
	public List<T> find(Criteria criteria) {
		logger.info("find");
		return mBaseMapper.query(criteria);
	}


	public BaseMapper<T> getmBaseMapper() {
		return mBaseMapper;
	}

	public void setmBaseMapper(BaseMapper<T> mBaseMapper) {
		this.mBaseMapper = mBaseMapper;
	}

}
