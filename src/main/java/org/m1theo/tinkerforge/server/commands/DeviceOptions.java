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
package org.m1theo.tinkerforge.server.commands;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Map;

/**
 * @author theo@m1theo.org
 */

@DataObject(generateConverter = true)
public class DeviceOptions {
  private Map<String, String> options;

  public DeviceOptions() {
  }

  public DeviceOptions(JsonObject json){
    this();
    DeviceOptionsConverter.fromJson(json, this);
  }

  public Map<String, String> getOptions() {
    return options;
  }

  public void setOptions(Map<String, String> options) {
    this.options = options;
  }

  public JsonObject toJson(){
    JsonObject json = new JsonObject();
    DeviceOptionsConverter.toJson(this, json);
    return json;
  }
}
