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
 * Converter for {@link org.m1theo.tinkerforge.server.commands.PercentValue}.
 *
 * NOTE: This class has been automatically generated from the {@link org.m1theo.tinkerforge.server.commands.PercentValue} original class using Vert.x codegen.
 */
public class PercentValueConverter {

  public static void fromJson(JsonObject json, PercentValue obj) {
  }

  public static void toJson(PercentValue obj, JsonObject json) {
    if (obj.getCommandType() != null) {
      json.put("commandType", obj.getCommandType().name());
    }
  }
}