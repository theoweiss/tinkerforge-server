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
 * Converter for {@link org.m1theo.tinkerforge.server.commands.ColorValue}.
 *
 * NOTE: This class has been automatically generated from the {@link org.m1theo.tinkerforge.server.commands.ColorValue} original class using Vert.x codegen.
 */
public class ColorValueConverter {

  public static void fromJson(JsonObject json, ColorValue obj) {
    if (json.getValue("blue") instanceof Number) {
      obj.setBlue(((Number)json.getValue("blue")).intValue());
    }
    if (json.getValue("green") instanceof Number) {
      obj.setGreen(((Number)json.getValue("green")).intValue());
    }
    if (json.getValue("red") instanceof Number) {
      obj.setRed(((Number)json.getValue("red")).intValue());
    }
  }

  public static void toJson(ColorValue obj, JsonObject json) {
    json.put("blue", obj.getBlue());
    json.put("green", obj.getGreen());
    json.put("red", obj.getRed());
  }
}