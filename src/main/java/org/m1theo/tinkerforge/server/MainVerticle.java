/**
 * Copyright 2018 Thomas Weiss <theo@m1theo.org>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.m1theo.tinkerforge.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.reactivex.core.Vertx;
import org.m1theo.tinkerforge.server.commands.Command;
import org.m1theo.tinkerforge.server.commands.CommandFactory;
import org.m1theo.tinkerforge.server.commands.CommandHolder;
import org.m1theo.tinkerforge.server.reactivex.tinkerforge.TinkerforgeEcosystem;
import org.m1theo.tinkerforge.server.tinkerforge.TinkerforgeEcosystemVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainVerticle extends AbstractVerticle {
  private static final Integer port = 9080;
  private static final Integer HTTP_CODE_INVALID_REQ = 301;
  private static final int HTTP_CODE_OK = 202;
  private static final int HTTP_CODE_FAILED = 505;
  private Logger logger = LoggerFactory.getLogger(MainVerticle.class);
  private TinkerforgeEcosystem ecosystem;

  @Override
  public void start() throws Exception {
    ecosystem = TinkerforgeEcosystem.createProxy(Vertx.newInstance(vertx));
    vertx.deployVerticle(TinkerforgeEcosystemVerticle.class, new DeploymentOptions().setConfig(config()));
    startHttpServer(config());
  }

  private void startHttpServer(JsonObject config) {
    Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    addRoutes(router);
    vertx.createHttpServer().requestHandler(router::accept).listen(port);
    System.out.println("HTTP server started on port " + port.toString());
  }

  private void addRoutes(Router router) {
    router.put("/command/:uid/:subid").handler(context -> {
      JsonObject body = context.getBodyAsJson();
      if (body == null) {
        context.response().setStatusCode(HTTP_CODE_INVALID_REQ).end("missing body");
        logger.debug("invalid request: missing body");
        return;
      }
      String uid = context.request().getParam("uid");
      String subid = context.request().getParam("subid");
      Command command = CommandFactory.getCommand(body);
      if (command == null) {
        context.response().setStatusCode(HTTP_CODE_INVALID_REQ).end("missing body");
        logger.debug("invalid request: missing body");
        return;
      }
      ecosystem.rxExecute(uid, subid, new CommandHolder(command), null)
          .subscribe(() -> {
            logger.debug("success");
            context.response().setStatusCode(HTTP_CODE_OK);
          }, e -> {
            logger.error("failed", e);
            context.response().setStatusCode(HTTP_CODE_FAILED).end(e.getMessage());
          });
    });
  }

}
