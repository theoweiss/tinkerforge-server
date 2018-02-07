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
package org.m1theo.tinkerforge.server.tinkerforge;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.m1theo.tinkerforge.server.commands.CommandHolder;
import org.m1theo.tinkerforge.server.commands.DeviceOptions;
import org.m1theo.tinkerforge.server.tinkerforge.impl.TinkerforgeEcosystemImpl;

import java.util.List;

/**
 * @author theo@m1theo.org
 */

@VertxGen
@ProxyGen
public interface TinkerforgeEcosystem {

  static TinkerforgeEcosystem create(Vertx vertx, JsonObject config) {
    return new TinkerforgeEcosystemImpl(vertx, config);
  }

  static TinkerforgeEcosystem createProxy(Vertx vertx) {
    return new TinkerforgeEcosystemVertxEBProxy(vertx, "ecosystem");
  }

  void connectBrickd(String host, Integer port, String authKey);

  void connectBrickds(List<Host> hosts);

  void execute(String uid, String subId, CommandHolder command, DeviceOptions options, Handler<AsyncResult<Void>> handler);
}
