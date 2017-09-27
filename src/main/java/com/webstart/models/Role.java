package com.webstart.models;

import com.jfinal.plugin.activerecord.Db;
import com.webstart.models.base.BaseRole;

import java.util.Collection;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Role extends BaseRole<Role> {
	public static final Role dao = new Role().dao();

	public Collection<String> getPermissionNameList() {
		Collection<String> names = Db.query("SELECT bp.PermissionName FROM Base_Permission bp,Base_Role br WHERE bp.RoleId=br.RoleId AND br.RoleId=?", this.getRoleId());
		return names;
	}
}