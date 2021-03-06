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
public class PercentValue implements Command{
  private final CommandType COMMAND_TYPE = CommandType.PERCENT;
  private BigDecimal value;

  public PercentValue(BigDecimal value) {
    this.value = validateValue(value);
  }

  public PercentValue() {
  }

  public PercentValue(JsonObject json){
    this();
    PercentValueConverter.fromJson(json, this);
    validateValue(value);
  }

  public JsonObject toJson(){
    JsonObject json = new JsonObject();
    PercentValueConverter.toJson(this, json);
    json.put(Command.COMMAND_TYPE_FIELD, COMMAND_TYPE.name());
    return json;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = validateValue(value);
  }

  private BigDecimal validateValue(BigDecimal value) {
    if (BigDecimal.ZERO.compareTo(value) > 0 || new BigDecimal(100).compareTo(value) < 0) {
      throw new IllegalArgumentException("Value must be between 0 and 100");
    }
    return value;
  }

  @Override
  public CommandType getCommandType() {
    return COMMAND_TYPE;
  }
}
