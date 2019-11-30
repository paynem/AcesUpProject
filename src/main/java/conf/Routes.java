/**
 * Copyright (C) 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package conf;


import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;

/**
 * Assignment 1: No changes are needed in this file, but it is good to be aware of the routes for future assignments.
 */
public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {  
        
        router.GET().route("/").with(ApplicationController.class, "index");
        router.GET().route("/endGame").with(ApplicationController.class, "endGame");

        // I don't think this is a particularly good way to do this, but I figured I'd experiment.  I created a second set of routes for the Spanish version of the game
        // that links up with a set of separate functions (again, for the Spanish version of the game)
        router.GET().route("/game").with(ApplicationController.class, "gameGet");
        router.GET().route("/sgame").with(ApplicationController.class, "sgameGet");
        router.POST().route("/dealGame").with(ApplicationController.class, "dealPost");
        router.POST().route("/sdealGame").with(ApplicationController.class, "sdealPost");
        router.POST().route("/moveCard/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCard");
        router.POST().route("/smoveCard/{columnFrom}/{columnTo}").with(ApplicationController.class, "smoveCard");
        router.POST().route("/removeCard/{column}").with(ApplicationController.class, "removeCard");
        router.POST().route("/sremoveCard/{column}").with(ApplicationController.class, "sremoveCard");

        

        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");
        
        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/.*").with(ApplicationController.class, "index");
    }

}
