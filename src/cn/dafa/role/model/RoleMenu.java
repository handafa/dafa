package cn.dafa.role.model;

import cn.dafa.base.model.BaseModel;

/**
 * @ClassName: RoleMenu
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-15 下午8:33:41
 * @version 【V1.0】
 * @Description: 菜单角色
 */
public class RoleMenu extends BaseModel {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer roleId;

	private String roleName;

	private Integer menuId;

	private String menuName;

	private Integer fatherNode;

	private Integer ifFather;

	private Integer checked;

	private String btnId;

	private String btnName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
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

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public String getBtnId() {
		return btnId;
	}

	public void setBtnId(String btnId) {
		this.btnId = btnId;
	}

	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
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
		RoleMenu other = (RoleMenu) that;
		return (this.getId() == null ? other.getId() == null : this.getId()
				.equals(other.getId()))
				&& (this.getRoleId() == null ? other.getRoleId() == null : this
						.getRoleId().equals(other.getRoleId()))
				&& (this.getMenuId() == null ? other.getMenuId() == null : this
						.getMenuId().equals(other.getMenuId()))
				&& (this.getStatus() == null ? other.getStatus() == null : this
						.getStatus().equals(other.getStatus()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null
						: this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getCreater() == null ? other.getCreater() == null
						: this.getCreater().equals(other.getCreater()))
				&& (this.getUpdateTime() == null ? other.getUpdateTime() == null
						: this.getUpdateTime().equals(other.getUpdateTime()))
				&& (this.getUpdater() == null ? other.getUpdater() == null
						: this.getUpdater().equals(other.getUpdater()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result
				+ ((getRoleId() == null) ? 0 : getRoleId().hashCode());
		result = prime * result
				+ ((getMenuId() == null) ? 0 : getMenuId().hashCode());
		result = prime * result
				+ ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result
				+ ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result
				+ ((getCreater() == null) ? 0 : getCreater().hashCode());
		result = prime * result
				+ ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
		result = prime * result
				+ ((getUpdater() == null) ? 0 : getUpdater().hashCode());
		return result;
	}
}