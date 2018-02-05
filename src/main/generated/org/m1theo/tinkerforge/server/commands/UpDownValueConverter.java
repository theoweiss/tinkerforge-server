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

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link org.m1theo.tinkerforge.server.commands.UpDownValue}.
 *
 * NOTE: This class has been automatically generated from the {@link org.m1theo.tinkerforge.server.commands.UpDownValue} original class using Vert.x codegen.
 */
public class UpDownValueConverter {

  public static void fromJson(JsonObject json, UpDownValue obj) {
    if (json.getValue("value") instanceof String) {
      obj.setValue(org.m1theo.tinkerforge.server.commands.UpDownValue.UpDown.valueOf((String)json.getValue("value")));
    }
  }

  public static void toJson(UpDownValue obj, JsonObject json) {
    if (obj.getValue() != null) {
      json.put("value", obj.getValue().name());
    }
  }
}