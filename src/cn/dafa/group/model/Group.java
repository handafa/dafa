package cn.dafa.group.model;

import cn.dafa.base.model.BaseModel;

public class Group extends BaseModel {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String groupId;

	private String groupName;

	private Integer fatherNode;

	private String fatherName;

	private Integer ifFather;

	private Integer weight;

	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getFatherNode() {
		return fatherNode;
	}

	public void setFatherNode(Integer fatherNode) {
		this.fatherNode = fatherNode;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
		Group other = (Group) that;
		return (this.getId() == null ? other.getId() == null : this.getId()
				.equals(other.getId()))
				&& (this.getGroupId() == null ? other.getGroupId() == null
						: this.getGroupId().equals(other.getGroupId()))
				&& (this.getGroupName() == null ? other.getGroupName() == null
						: this.getGroupName().equals(other.getGroupName()))
				&& (this.getFatherNode() == null ? other.getFatherNode() == null
						: this.getFatherNode().equals(other.getFatherNode()))
				&& (this.getIfFather() == null ? other.getIfFather() == null
						: this.getIfFather().equals(other.getIfFather()))
				&& (this.getWeight() == null ? other.getWeight() == null : this
						.getWeight().equals(other.getWeight()))
				&& (this.getNote() == null ? other.getNote() == null : this
						.getNote().equals(other.getNote()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result
				+ ((getGroupId() == null) ? 0 : getGroupId().hashCode());
		result = prime * result
				+ ((getGroupName() == null) ? 0 : getGroupName().hashCode());
		result = prime * result
				+ ((getFatherNode() == null) ? 0 : getFatherNode().hashCode());
		result = prime * result
				+ ((getIfFather() == null) ? 0 : getIfFather().hashCode());
		result = prime * result
				+ ((getWeight() == null) ? 0 : getWeight().hashCode());
		result = prime * result
				+ ((getNote() == null) ? 0 : getNote().hashCode());
		return result;
	}
}