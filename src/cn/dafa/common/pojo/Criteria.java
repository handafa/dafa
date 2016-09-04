/**  
 * @Title: Criteria.java
 * @Package cn.dafa.common.pojo
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-4 下午12:52:21
 * @version V1.0  
 */
package cn.dafa.common.pojo;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import cn.dafa.common.util.TypeCaseHelper;

/**
 * @ClassName: Criteria
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-4 下午12:52:21
 * @version 【V1.0】
 * @Description: 公用条件查询类,也可以用于MVC层之间的参数传递
 */
public class Criteria {
	/**
	 * 存放条件查询值
	 */
	private Map<String, Object> condition;

	/**
	 * 是否相异
	 */
	protected boolean distinct;

	/**
	 * 排序字段
	 */
	protected String orderByClause;
	/**
	 * 分页查询的长度
	 */
	private Integer limit;
	/**
	 * 分页查询的起点
	 */
	private Integer start;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public Criteria() {
		super();
		condition = new HashMap<String, Object>();
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public Criteria(Criteria example) {
		this.orderByClause = example.orderByClause;
		this.condition = example.condition;
		this.distinct = example.distinct;
		this.start = example.start;
		this.limit = example.limit;
	}

	/**
	 * @Title: clear
	 * @Description: 数据清空
	 * @datetime 2013-1-14 上午10:52:02
	 * @param
	 * @return
	 * @throws
	 */
	public void clear() {
		this.condition.clear();
		this.orderByClause = null;
		this.distinct = false;
		this.start = null;
		this.limit = null;
	}

	/**
	 * @param keyName
	 *            查询的条件名称
	 * @param keyValue
	 *            查询的值
	 */
	public Criteria put(String keyName, Object keyValue) {
		this.condition.put(keyName, keyValue);
		return (Criteria) this;
	}

	/**
	 * 得到键值，C层和S层的参数传递时取值所用<br>
	 * 自行转换对象
	 * 
	 * @param keyName
	 *            键值
	 * @return 返回指定键所映射的值
	 */
	public Object get(String keyName) {
		return this.condition.get(keyName);
	}

	/**
	 * @return the condition
	 */
	public Map<String, Object> getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	/**
	 * @return the distinct
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * @param distinct
	 *            the distinct to set
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * @return the orderByClause
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * @param orderByClause
	 *            the orderByClause to set
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the start
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * 以BigDecimal类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return BigDecimal 键值
	 */
	public BigDecimal getAsBigDecimal(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "BigDecimal", null);
		if (obj != null)
			return (BigDecimal) obj;
		else
			return null;
	}

	/**
	 * 以Date类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Date 键值
	 */
	public Date getAsDate(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Date", "yyyy-MM-dd");
		if (obj != null)
			return (Date) obj;
		else
			return null;
	}

	/**
	 * 以Integer类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Integer 键值
	 */
	public Integer getAsInteger(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Integer", null);
		if (obj != null)
			return (Integer) obj;
		else
			return null;
	}

	/**
	 * 以Long类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Long 键值
	 */
	public Long getAsLong(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Long", null);
		if (obj != null)
			return (Long) obj;
		else
			return null;
	}

	/**
	 * 以String类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return String 键值
	 */
	public String getAsString(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "String", null);
		if (obj != null)
			return (String) obj;
		else
			return "";
	}

	/**
	 * 以Timestamp类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Timestamp getAsTimestamp(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Timestamp",
				"yyyy-MM-dd HH:mm:ss");
		if (obj != null)
			return (Timestamp) obj;
		else
			return null;
	}

	/**
	 * 以Boolean类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Boolean getAsBoolean(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Boolean", null);
		if (obj != null)
			return (Boolean) obj;
		else
			return null;
	}

	/*
	 * <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
