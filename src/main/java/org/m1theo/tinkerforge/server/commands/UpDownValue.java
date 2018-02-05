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
public class UpDownValue implements Command{
  private UpDown value;

  public UpDownValue(UpDown value) {
    this.value = value;
  }

  public UpDownValue() {
  }

  public UpDownValue(JsonObject json){
    this();
    UpDownValueConverter.fromJson(json, this);
  }

  public JsonObject toJson(){
    JsonObject json = new JsonObject();
    UpDownValueConverter.toJson(this, json);
    return json;
  }

  public UpDown getValue() {
    return value;
  }

  public void setValue(UpDown value) {
    this.value = value;
  }

  public enum UpDown{
    UP, DOWN
  }
}
