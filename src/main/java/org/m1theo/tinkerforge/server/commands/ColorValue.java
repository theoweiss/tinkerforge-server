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
import org.m1theo.tinkerforge.server.exceptions.IllegalValueException;


/**
 * @author theo@m1theo.org
 */

@DataObject(generateConverter = true)
public class ColorValue implements Command {
  public static final String COMMAND_TYPE = CommandType.COLOR.getType();
  private int red;
  private int green;
  private int blue;

  public ColorValue(int red, int green, int blue) {
    this.red = check(red);
    this.green = check(green);
    this.blue = check(blue);
  }

  public ColorValue() {
  }

  public ColorValue(JsonObject json){
    this();
    ColorValueConverter.fromJson(json, this);
  }

  public JsonObject toJson(){
    JsonObject json = new JsonObject();
    ColorValueConverter.toJson(this, json);
    json.put(Command.COMMAND_TYPE_FIELD, COMMAND_TYPE);
    return json;
  }

  public int getRed() {
    return red;
  }

  public void setRed(int red) {
    this.red = check(red);
  }

  public int getGreen() {
    return check(green);
  }

  public void setGreen(int green) {
    this.green = green;
  }

  public int getBlue() {
    return blue;
  }

  public void setBlue(int blue) {
    this.blue = check(blue);
  }

  private int check(int value){
   if ( value < 0 || value > 255 ){
     throw new IllegalValueException("color value not valid: " + value);
   }
   return value;
  }
}
