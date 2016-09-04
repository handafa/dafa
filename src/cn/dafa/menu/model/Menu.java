package cn.dafa.menu.model;

import cn.dafa.base.model.BaseModel;

public class Menu extends BaseModel {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String url;
	private Integer fatherNode;
	private Integer ifFather;
	private Integer weight;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getFatherNode() {
		return fatherNode;
	}

	public void setFatherNode(Integer fatherNode) {
		this.fatherNode = fatherNode;
	}

	public Integer getIfFather() {
		return ifFather;
	}

	public void setIfFather(Integer ifFather) {
		this.ifFather = ifFather;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Menu other = (Menu) that;
		return (this.getId() == null ? other.getId() == null : this.getId()
				.equals(other.getId()))
				&& (this.getName() == null ? other.getName() == null : this
						.getName().equals(other.getName()))
				&& (this.getUrl() == null ? other.getUrl() == null : this
						.getUrl().equals(other.getUrl()))
				&& (this.getFatherNode() == null ? other.getFatherNode() == null
						: this.getFatherNode().equals(other.getFatherNode()))
				&& (this.getIfFather() == null ? other.getIfFather() == null
						: this.getIfFather().equals(other.getIfFather()))
				&& (this.getWeight() == null ? other.getWeight() == null : this
						.getWeight().equals(other.getWeight()))
				&& (this.getStatus() == null ? other.getStatus() == null : this
						.getStatus().equals(other.getStatus()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null
						: this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getUpdateTime() == null ? other.getUpdateTime() == null
						: this.getUpdateTime().equals(other.getUpdateTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result
				+ ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result
				+ ((getUrl() == null) ? 0 : getUrl().hashCode());
		result = prime * result
				+ ((getFatherNode() == null) ? 0 : getFatherNode().hashCode());
		result = prime * result
				+ ((getIfFather() == null) ? 0 : getIfFather().hashCode());
		result = prime * result
				+ ((getWeight() == null) ? 0 : getWeight().hashCode());
		result = prime * result
				+ ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result
				+ ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result
				+ ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
		return result;
	}
}