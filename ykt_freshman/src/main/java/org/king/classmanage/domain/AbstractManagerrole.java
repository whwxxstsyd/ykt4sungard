package org.king.classmanage.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * AbstractManagerrole generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractManagerrole extends
		org.king.framework.domain.BaseObject implements java.io.Serializable {

	// Fields

	private String roleId;

	private String roleName;

	private String introduction;

	// Constructors

	/** default constructor */
	public AbstractManagerrole() {
	}

	/** full constructor */
	public AbstractManagerrole(String roleName, String introduction) {
		this.roleName = roleName;
		this.introduction = introduction;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof AbstractManagerrole)) {
			return false;
		}
		AbstractManagerrole rhs = (AbstractManagerrole) object;
		return new EqualsBuilder().append(this.roleName, rhs.roleName).append(
				this.roleId, rhs.roleId).append(this.introduction,
				rhs.introduction).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(208209391, 1486332995).append(this.roleName)
				.append(this.roleId).append(this.introduction).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("introduction",
				this.introduction).append("roleId", this.roleId).append(
				"roleName", this.roleName).toString();
	}

}