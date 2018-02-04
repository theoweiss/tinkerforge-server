/**
 * Copyright 2018 Thomas Weiss <theo@m1theo.org>
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
package org.m1theo.tinkerforge.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.deployVerticle(TinkerforgeEcosystemVerticle.class, new DeploymentOptions().setConfig(config()));

        vertx.createHttpServer().requestHandler(req -> {
              req.response()
                .putHeader("content-type", "text/plain")
                .end("Hello from Vert.x!");
            }).listen(8080);
        System.out.println("HTTP server started on port 8080");
    }
}
