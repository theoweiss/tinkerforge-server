/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.m1theo.tinkerforge.server.commands;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link org.m1theo.tinkerforge.server.commands.IncreaseDecreaseValue}.
 *
 * NOTE: This class has been automatically generated from the {@link org.m1theo.tinkerforge.server.commands.IncreaseDecreaseValue} original class using Vert.x codegen.
 */
public class IncreaseDecreaseValueConverter {

  public static void fromJson(JsonObject json, IncreaseDecreaseValue obj) {
    if (json.getValue("value") instanceof String) {
      obj.setValue(org.m1theo.tinkerforge.server.commands.IncreaseDecreaseValue.IncreaseDecrease.valueOf((String)json.getValue("value")));
    }
  }

  public static void toJson(IncreaseDecreaseValue obj, JsonObject json) {
    if (obj.getCommandType() != null) {
      json.put("commandType", obj.getCommandType().name());
    }
    if (obj.getValue() != null) {
      json.put("value", obj.getValue().name());
    }
  }
}