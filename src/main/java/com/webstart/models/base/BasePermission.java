package com.webstart.models.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePermission<M extends BasePermission<M>> extends Model<M> implements IBean {

	public void setPermissionId(java.lang.String PermissionId) {
		set("PermissionId", PermissionId);
	}

	public java.lang.String getPermissionId() {
		return getStr("PermissionId");
	}

	public void setPermissionName(java.lang.String PermissionName) {
		set("PermissionName", PermissionName);
	}

	public java.lang.String getPermissionName() {
		return getStr("PermissionName");
	}

	public void setObjectId(java.lang.String ObjectId) {
		set("ObjectId", ObjectId);
	}

	public java.lang.String getObjectId() {
		return getStr("ObjectId");
	}

	public void setRoleId(java.lang.String RoleId) {
		set("RoleId", RoleId);
	}

	public java.lang.String getRoleId() {
		return getStr("RoleId");
	}

	public void setRemark(java.lang.String Remark) {
		set("Remark", Remark);
	}

	public java.lang.String getRemark() {
		return getStr("Remark");
	}

	public void setEnabled(java.lang.String Enabled) {
		set("Enabled", Enabled);
	}

	public java.lang.String getEnabled() {
		return getStr("Enabled");
	}

	public void setDeleteMark(java.lang.String DeleteMark) {
		set("DeleteMark", DeleteMark);
	}

	public java.lang.String getDeleteMark() {
		return getStr("DeleteMark");
	}

}
