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

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.webstart.modules.admin.AdminRoutes;
import com.webstart.modules.index.IndexRoutes;
import com.webstart.modules.login.LoginRoutes;
import javafx.scene.transform.Rotate;


public class WebStartJConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        constants.setViewType(ViewType.JSP);
        constants.setErrorView(400,"/400error.jsp");
        constants.setErrorView(401,"/401error.jsp");
        constants.setErrorView(402,"/402error.jsp");
        constants.setErrorView(403,"/403error.jsp");
        constants.setErrorView(404,"/404error.jsp");
    }

    @Override
    public void configRoute(Routes routes) {

        routes.add(new IndexRoutes());
        routes.add(new LoginRoutes());
        routes.add(new AdminRoutes());
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
