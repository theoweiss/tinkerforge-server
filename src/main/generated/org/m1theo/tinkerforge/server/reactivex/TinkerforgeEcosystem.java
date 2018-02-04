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
package org.m1theo.tinkerforge.server.reactivex;

import java.util.Map;
import io.reactivex.Observable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import org.m1theo.tinkerforge.server.commands.DeviceOptions;
import io.vertx.reactivex.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import org.m1theo.tinkerforge.server.commands.CommandHolder;

/**
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link org.m1theo.tinkerforge.server.TinkerforgeEcosystem original} non RX-ified interface using Vert.x codegen.
 */

@io.vertx.lang.reactivex.RxGen(org.m1theo.tinkerforge.server.TinkerforgeEcosystem.class)
public class TinkerforgeEcosystem {

  @Override
  public String toString() {
    return delegate.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TinkerforgeEcosystem that = (TinkerforgeEcosystem) o;
    return delegate.equals(that.delegate);
  }
  
  @Override
  public int hashCode() {
    return delegate.hashCode();
  }

  public static final io.vertx.lang.reactivex.TypeArg<TinkerforgeEcosystem> __TYPE_ARG = new io.vertx.lang.reactivex.TypeArg<>(
    obj -> new TinkerforgeEcosystem((org.m1theo.tinkerforge.server.TinkerforgeEcosystem) obj),
    TinkerforgeEcosystem::getDelegate
  );

  private final org.m1theo.tinkerforge.server.TinkerforgeEcosystem delegate;
  
  public TinkerforgeEcosystem(org.m1theo.tinkerforge.server.TinkerforgeEcosystem delegate) {
    this.delegate = delegate;
  }

  public org.m1theo.tinkerforge.server.TinkerforgeEcosystem getDelegate() {
    return delegate;
  }

  public static TinkerforgeEcosystem create(Vertx vertx, JsonObject config) { 
    TinkerforgeEcosystem ret = TinkerforgeEcosystem.newInstance(org.m1theo.tinkerforge.server.TinkerforgeEcosystem.create(vertx.getDelegate(), config));
    return ret;
  }

  public static TinkerforgeEcosystem createProxy(Vertx vertx) { 
    TinkerforgeEcosystem ret = TinkerforgeEcosystem.newInstance(org.m1theo.tinkerforge.server.TinkerforgeEcosystem.createProxy(vertx.getDelegate()));
    return ret;
  }

  public void execute(String uid, String subId, CommandHolder command, DeviceOptions options, Handler<AsyncResult<Void>> handler) { 
    delegate.execute(uid, subId, command, options, handler);
  }

  public Completable rxExecute(String uid, String subId, CommandHolder command, DeviceOptions options) { 
    return new io.vertx.reactivex.core.impl.AsyncResultCompletable(handler -> {
      execute(uid, subId, command, options, handler);
    });
  }


  public static  TinkerforgeEcosystem newInstance(org.m1theo.tinkerforge.server.TinkerforgeEcosystem arg) {
    return arg != null ? new TinkerforgeEcosystem(arg) : null;
  }
}
