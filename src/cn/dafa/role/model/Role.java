package cn.dafa.role.model;

import cn.dafa.base.model.BaseModel;

/**
 * @ClassName: Role
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-11 下午1:07:35
 * @version 【V1.0】
 * @Description: TODO
 */
public class Role extends BaseModel {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String roleName;

	private Integer weight;

	private String node;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
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
		Role other = (Role) that;
		return (this.getId() == null ? other.getId() == null : this.getId()
				.equals(other.getId()))
				&& (this.getRoleName() == null ? other.getRoleName() == null
						: this.getRoleName().equals(other.getRoleName()))
				&& (this.getWeight() == null ? other.getWeight() == null : this
						.getWeight().equals(other.getWeight()))
				&& (this.getNode() == null ? other.getNode() == null : this
						.getNode().equals(other.getNode()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result
				+ ((getRoleName() == null) ? 0 : getRoleName().hashCode());
		result = prime * result
				+ ((getWeight() == null) ? 0 : getWeight().hashCode());
		result = prime * result
				+ ((getNode() == null) ? 0 : getNode().hashCode());
		return result;
	}
}