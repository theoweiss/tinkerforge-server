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

import java.math.BigDecimal;

/**
 * @author theo@m1theo.org
 */

@DataObject(generateConverter = true)
public class DecimalValue implements Command {
  private final CommandType COMMAND_TYPE = CommandType.DECIMAL;
  private BigDecimal value;

  public DecimalValue(BigDecimal value) {
    this.value = value;
  }

  public DecimalValue() {
  }

  public DecimalValue(JsonObject json) {
    this();
    DecimalValueConverter.fromJson(json, this);
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public JsonObject toJson(){
    JsonObject json = new JsonObject();
    DecimalValueConverter.toJson(this, json);
    json.put(Command.COMMAND_TYPE_FIELD, COMMAND_TYPE.name());
    return json;
  }

  @Override
  public CommandType getCommandType() {
  return COMMAND_TYPE;
  }
}
