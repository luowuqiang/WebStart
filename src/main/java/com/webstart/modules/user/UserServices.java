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

package com.webstart.modules.user;

import com.webstart.common.WebStartServices;
import com.webstart.models.User;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class UserServices extends WebStartServices {
    public static final UserServices services  = new UserServices();

    public User findByUserName(String userName){
        User user=User.dao.findFirst("SELECT * FROM Base_User WHERE UserName=? AND Enabled=1 AND DeleteMark=0",userName);

        return user;
    }

    public Page<Record>retrieveAll(int pageNumber,int pageSize){
        Page<Record> users=Db.paginate(pageNumber,pageSize,"SELECT UserId,UserName,Online,Remark,Enabled","From Base_User");
        return users;
    }

/*    public Page<Record> retrieve(int pageNumber,int pageSize,String strWhere) {

        Page<Record> users=Db.paginate(pageNumber,pageSize,"SELECT UserId,UserName,Online,Remark,Enabled"," FROM Base_User "+strWhere);

        return users;
    }

    public int delete(String strWhere) {

        int result=Db.update("UPDATE DeleteMark=1 FROM Base_User WHERE UserId in "+strWhere);

        return result;
    }*/
}
