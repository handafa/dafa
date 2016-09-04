/**  
 * @Title: BaseMapper.java
 * @Package cn.dafa.base.mapper
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2012-11-7 上午10:36:25
 * @version V1.0  
 */
package cn.dafa.base.mapper;

import java.io.Serializable;
import java.util.List;

import cn.dafa.common.pojo.Criteria;

/**
 * @ClassName: BaseMapper
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2012-11-7 上午10:36:25
 * @version 【V1.0】
 * @Description: TODO
 */
public interface BaseMapper<T extends Serializable> {
	/**
	 * @Title: delete
	 * @Description: 根据主键进行逐条删除
	 * @datetime 2012-12-31 下午2:23:11
	 * @param
	 * @return
	 * @throws
	 */
	public int delete(Integer id);

	/**
	 * @Title: deleteBatch
	 * @Description: 根据主键进行批量删除
	 * @datetime 2012-12-31 下午2:23:45
	 * @param
	 * @return
	 * @throws
	 */
	public int deleteBatch(String[] ids);

	/**
	 * @Title: insert
	 * @Description: 写入数据
	 * @datetime 2012-12-31 下午2:27:18
	 * @param
	 * @return
	 * @throws
	 */
	public int save(T entity);


	/**
	 * @Title: update
	 * @Description: 根据主键进行更改数据
	 * @datetime 2012-12-31 下午2:27:39
	 * @param
	 * @return
	 * @throws
	 */
	public int modify(T entity);


	/**
	 * @Title: select
	 * @Description: 根据主键获取
	 * @datetime 2012-12-31 下午2:29:44
	 * @param
	 * @return
	 * @throws
	 */
	public T select(Integer id);
	
	/**
	 * @Title: count
	 * @Description: 获取总数
	 * @datetime 2013-1-4 上午10:30:11  
	 * @param
	 * @return
	 * @throws
	 */
	public long count(Criteria criteria);

	/**
	 * @Title: find
	 * @Description: 根据查询条件获取
	 * @datetime 2012-12-31 下午2:30:29
	 * @param
	 * @return
	 * @throws
	 */
	public List<T> query(Criteria criteria);

	
}
