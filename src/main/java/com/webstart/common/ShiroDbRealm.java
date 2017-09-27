/*
 * *
 *  * Copyright (c) 2017, Johnny Loo 罗武强(luowuqiang@gmail.com).
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.webstart.common;

import com.webstart.models.Role;
import com.webstart.models.User;
import com.webstart.modules.user.UserServices;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

public class ShiroDbRealm extends AuthorizingRealm {

    public String getName() {
        return "ShiroDbRealm";
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        User user = UserServices.services.findByUserName(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
        } else {
            return null;
        }
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.fromRealm(getName()).iterator().next();
        User user = UserServices.services.findByUserName(userName);
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRoles(user.getRoleNameList());
            for (Role role : user.getRoleList()) {
                info.addStringPermissions(role.getPermissionNameList());
            }
            return info;
        } else {
            return null;
        }
    }

    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }
}
