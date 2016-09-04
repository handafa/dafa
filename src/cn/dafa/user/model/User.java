package cn.dafa.user.model;

import java.util.Date;

import cn.dafa.base.model.BaseModel;

/**
 * @ClassName: User
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-7 下午3:49:52
 * @version 【V1.0】
 * @Description: 系统用户
 */
public class User extends BaseModel {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String number;

	private String userName;

	private String loginName;

	private String password;

	private Integer roleId;

	private String roleName;

	private String groupId;

	private String groupName;

	private String sex;

	private Integer age;

	private Date birthday;

	private String degree;

	private String picture;

	private String mobile;

	private String tel;

	private String qq;

	private String email;

	private Date entryTime;

	private String note;

	private Integer weight;

	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
		User other = (User) that;
		return (this.getId() == null ? other.getId() == null : this.getId()
				.equals(other.getId()))
				&& (this.getNumber() == null ? other.getNumber() == null : this
						.getNumber().equals(other.getNumber()))
				&& (this.getUserName() == null ? other.getUserName() == null
						: this.getUserName().equals(other.getUserName()))
				&& (this.getLoginName() == null ? other.getLoginName() == null
						: this.getLoginName().equals(other.getLoginName()))
				&& (this.getRoleId() == null ? other.getRoleId() == null : this
						.getRoleId().equals(other.getRoleId()))
				&& (this.getRoleName() == null ? other.getRoleName() == null
						: this.getRoleName().equals(other.getRoleName()))
				&& (this.getGroupId() == null ? other.getGroupId() == null
						: this.getGroupId().equals(other.getGroupId()))
				&& (this.getGroupName() == null ? other.getGroupName() == null
						: this.getGroupName().equals(other.getGroupName()))
				&& (this.getPassword() == null ? other.getPassword() == null
						: this.getPassword().equals(other.getPassword()))
				&& (this.getSex() == null ? other.getSex() == null : this
						.getSex().equals(other.getSex()))
				&& (this.getAge() == null ? other.getAge() == null : this
						.getAge().equals(other.getAge()))
				&& (this.getBirthday() == null ? other.getBirthday() == null
						: this.getBirthday().equals(other.getBirthday()))
				&& (this.getDegree() == null ? other.getDegree() == null : this
						.getDegree().equals(other.getDegree()))
				&& (this.getPicture() == null ? other.getPicture() == null
						: this.getPicture().equals(other.getPicture()))
				&& (this.getMobile() == null ? other.getMobile() == null : this
						.getMobile().equals(other.getMobile()))
				&& (this.getTel() == null ? other.getTel() == null : this
						.getTel().equals(other.getTel()))
				&& (this.getQq() == null ? other.getQq() == null : this.getQq()
						.equals(other.getQq()))
				&& (this.getEmail() == null ? other.getEmail() == null : this
						.getEmail().equals(other.getEmail()))
				&& (this.getEntryTime() == null ? other.getEntryTime() == null
						: this.getEntryTime().equals(other.getEntryTime()))
				&& (this.getNote() == null ? other.getNote() == null : this
						.getNote().equals(other.getNote()))
				&& (this.getWeight() == null ? other.getWeight() == null : this
						.getWeight().equals(other.getWeight()))
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
				+ ((getNumber() == null) ? 0 : getNumber().hashCode());
		result = prime * result
				+ ((getUserName() == null) ? 0 : getUserName().hashCode());
		result = prime * result
				+ ((getLoginName() == null) ? 0 : getLoginName().hashCode());
		result = prime * result
				+ ((getPassword() == null) ? 0 : getPassword().hashCode());
		result = prime * result
				+ ((getAge() == null) ? 0 : getAge().hashCode());
		result = prime * result
				+ ((getBirthday() == null) ? 0 : getBirthday().hashCode());
		result = prime * result
				+ ((getDegree() == null) ? 0 : getDegree().hashCode());
		result = prime * result
				+ ((getPicture() == null) ? 0 : getPicture().hashCode());
		result = prime * result
				+ ((getMobile() == null) ? 0 : getMobile().hashCode());
		result = prime * result
				+ ((getTel() == null) ? 0 : getTel().hashCode());
		result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
		result = prime * result
				+ ((getEmail() == null) ? 0 : getEmail().hashCode());
		result = prime * result
				+ ((getEntryTime() == null) ? 0 : getEntryTime().hashCode());
		result = prime * result
				+ ((getNote() == null) ? 0 : getNote().hashCode());
		result = prime * result
				+ ((getWeight() == null) ? 0 : getWeight().hashCode());
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