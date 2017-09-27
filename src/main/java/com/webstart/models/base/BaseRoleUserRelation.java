package com.webstart.models.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseRoleUserRelation<M extends BaseRoleUserRelation<M>> extends Model<M> implements IBean {

	public void setRoleUserRelationId(java.lang.String RoleUserRelationId) {
		set("RoleUserRelationId", RoleUserRelationId);
	}

	public java.lang.String getRoleUserRelationId() {
		return getStr("RoleUserRelationId");
	}

	public void setRoleId(java.lang.String RoleId) {
		set("RoleId", RoleId);
	}

	public java.lang.String getRoleId() {
		return getStr("RoleId");
	}

	public void setUserId(java.lang.String UserId) {
		set("UserId", UserId);
	}

	public java.lang.String getUserId() {
		return getStr("UserId");
	}

	public void setEnabled(java.lang.String Enabled) {
		set("Enabled", Enabled);
	}

	public java.lang.String getEnabled() {
		return getStr("Enabled");
	}

	public void setRemark(java.lang.String Remark) {
		set("Remark", Remark);
	}

	public java.lang.String getRemark() {
		return getStr("Remark");
	}

	public void setDeleteMark(java.lang.String DeleteMark) {
		set("DeleteMark", DeleteMark);
	}

	public java.lang.String getDeleteMark() {
		return getStr("DeleteMark");
	}

}
