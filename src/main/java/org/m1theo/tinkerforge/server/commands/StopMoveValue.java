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

/**
 * @author theo@m1theo.org
 */

@DataObject(generateConverter = true)
public class StopMoveValue implements Command {
  private final CommandType COMMAND_TYPE = CommandType.STOPMOVE;
  private StopMove value;

  public StopMoveValue(StopMove value) {
    this.value = value;
  }

  public StopMoveValue() {
  }

  public StopMoveValue(JsonObject json){
    this();
    StopMoveValueConverter.fromJson(json, this);
  }

  public JsonObject toJson(){
    JsonObject json = new JsonObject();
    StopMoveValueConverter.toJson(this, json);
    json.put(Command.COMMAND_TYPE_FIELD, COMMAND_TYPE.name());
    return json;
  }

  public StopMove getValue() {
    return value;
  }

  public void setValue(StopMove value) {
    this.value = value;
  }

  @Override
  public CommandType getCommandType() {
    return COMMAND_TYPE;
  }

  public enum StopMove {
    STOP, MOVE
  }
}
