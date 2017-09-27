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

package com.webstart.models;

import javax.sql.DataSource;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.activerecord.dialect.*;

public class ModelsGenerator {
    public static DataSource getDataSource() {
        //properties file
        Prop p = PropKit.use("app.properties");
        DruidPlugin dp = new DruidPlugin(p.get("jdbc.url"), p.get("jdbc.userName"), p.get("jdbc.password"),p.get("jdbc.clazz"));
        dp.start();
        return dp.getDataSource();
    }

    public static void main(String[] args) {
        // base model package
        String baseModelPackageName = "com.webstart.models.base";
        // base model path
        String baseModelOutputDir = PathKit.getWebRootPath() + "\\src\\main\\java\\com\\webstart\\models\\base";

        // model package
        String modelPackageName = "com.webstart.models";
        // model path
        String modelOutputDir = PathKit.getWebRootPath() + "\\src\\main\\java\\com\\webstart\\models";

        Generator gernerator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
        gernerator.setDialect(new MysqlDialect());
        //gernerator.addExcludedTable("adv");
        gernerator.setGenerateDaoInModel(true);
        gernerator.setGenerateDataDictionary(false);
        gernerator.setRemovedTableNamePrefixes("Base_");
        gernerator.generate();
    }
}
