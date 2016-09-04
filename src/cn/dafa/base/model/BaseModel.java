/**  
 * @Title: BaseModel.java
 * @Package cn.dafa.base.model
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2012-11-7 上午10:37:19
 * @version V1.0  
 */
package cn.dafa.base.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @ClassName: BaseModel
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2012-11-7 上午10:37:19
 * @version 【V1.0】
 * @Description: TODO
 */
public class BaseModel implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields 状态
	 */
	protected Integer status;
	/**
	 * @Fields 创建时间
	 */
	protected Date createTime;
	/**
	 * @Fields 更改时间
	 */
	protected Date updateTime;
	/**
	 * @Fields 创建者
	 */
	protected String creater;
	/**
	 * @Fields 修改者
	 */
	protected String updater;

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the creater
	 */
	public String getCreater() {
		return creater;
	}

	/**
	 * @param creater
	 *            the creater to set
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}

	/**
	 * @return the updater
	 */
	public String getUpdater() {
		return updater;
	}

	/**
	 * @param updater
	 *            the updater to set
	 */
	public void setUpdater(String updater) {
		this.updater = updater;
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
