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
package org.m1theo.tinkerforge.server.tinkerforge.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.m1theo.tinkerforge.emf.client.Client;
import org.m1theo.tinkerforge.emf.client.LoggingDataListener;
import org.m1theo.tinkerforge.server.tinkerforge.TinkerforgeCommandFactory;
import org.m1theo.tinkerforge.server.tinkerforge.TinkerforgeEcosystem;
import org.m1theo.tinkerforge.server.commands.CommandHolder;
import org.m1theo.tinkerforge.server.commands.DeviceOptions;
import org.m1theo.tinkerforge.types.TinkerforgeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author theo@m1theo.org
 */
public class TinkerforgeEcosystemImpl implements TinkerforgeEcosystem {
  private final Vertx vertx;
  private final JsonObject config;
  private final Client client;
  private final Logger logger = LoggerFactory.getLogger(TinkerforgeEcosystemImpl.class);

  public TinkerforgeEcosystemImpl(Vertx vertx, JsonObject config) {
    this.vertx = vertx;
    this.config = config;
    client = Client.createInstance(config.getMap(), new LoggingDataListener());
  }

  @Override
  public void execute(String uid, String subId, CommandHolder command, DeviceOptions
      options, Handler<AsyncResult<Void>> handler) {
    TinkerforgeValue cmd = TinkerforgeCommandFactory.getCommand(command.getCommand());
    if (cmd == null) {
      handler.handle(Future.failedFuture(new RuntimeException("invalid command")));
      return;
    }
    try {
      org.m1theo.tinkerforge.config.DeviceOptions deviceOptions = null;
      if (options != null) {
        deviceOptions = new org.m1theo.tinkerforge.config.DeviceOptions(options.getOptions());
      }
      client.execute(uid, subId, cmd, deviceOptions);
      logger.debug("execute succeeded");
      handler.handle(Future.succeededFuture());
    } catch (Exception e) {
      logger.error("execute failed", e);
      handler.handle(Future.failedFuture(e));
    }
  }
}
