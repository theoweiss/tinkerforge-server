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
import io.vertx.core.Future;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ServiceBinder;
import org.m1theo.tinkerforge.server.impl.Constants;

/**
 * @author theo@m1theo.org
 */
public class TinkerforgeEcosystemVerticle extends AbstractVerticle {

  private MessageConsumer<JsonObject> binder;

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    TinkerforgeEcosystem service = TinkerforgeEcosystem.create(vertx, config());
    binder = new ServiceBinder(vertx).setAddress(Constants.ECOSYSTEM_ADDRESS).register(TinkerforgeEcosystem.class, service);
    startFuture.complete();
  }

  @Override
  public void stop(Future<Void> stopFuture) throws Exception {
    binder.unregister(res -> stopFuture.complete());
  }
}
