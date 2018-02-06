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
public class DirectionValue implements Command{
  private final CommandType COMMAND_TYPE = CommandType.DIRECTION;
  private Direction direction;

  public DirectionValue() {
  }

  public DirectionValue(JsonObject json){
    this();
    DirectionValueConverter.fromJson(json, this);
  }

  public DirectionValue(Direction direction) {

    this.direction = direction;
  }

  public JsonObject toJson(){
    JsonObject json = new JsonObject();
    DirectionValueConverter.toJson(this, json);
    json.put(Command.COMMAND_TYPE_FIELD, COMMAND_TYPE.name());
    return json;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  @Override
  public CommandType getCommandType() {
    return COMMAND_TYPE;
  }

  public enum Direction{
    LEFT, RIGHT
  }

}
