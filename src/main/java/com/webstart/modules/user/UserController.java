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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class UserController extends Controller {

    public void index(){
        retrieveAll();
    }

    public void retrieveAll(){
        //get parameter from view
        int pageNumber=getParaToInt("pageNumber");
        int pageSize=getParaToInt("pageSize");

        //validate parameter

        //process buisiness
        Page<Record> users=UserServices.services.retrieveAll(pageNumber,pageSize);
        int totalPage=users.getTotalPage();
        int totalRows=users.getTotalRow();

        //convert to json
        JSONObject jo=new JSONObject();
        jo.put("status", "success");
        jo.put("pageIndex", pageNumber);
        jo.put("pageRows", pageSize);
        jo.put("totalPages", totalPage);
        jo.put("totalRows", totalRows);
        JSONArray ja=new JSONArray();
        for(Record rc:users.getList()){
            ja.add(rc.getColumns());
        }
        jo.put("items", ja);

        //return to view
        renderJson(jo);
    }
}
