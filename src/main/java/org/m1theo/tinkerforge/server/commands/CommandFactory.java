package org.m1theo.tinkerforge.server.commands;

import io.vertx.core.json.JsonObject;

/**
 * @author theo@m1theo.org
 */
public class CommandFactory {
  public static Command getCommand(JsonObject json){
    String typeString = json.getString(Command.COMMAND_TYPE_FIELD);
    if (typeString == null){
      return null;
    }
    try {
      Command command;
      switch (CommandType.valueOf(typeString)) {
        case COLOR:
          command = new ColorValue(json);
          break;
        case DECIMAL:
          command = new DecimalValue(json);
          break;
        case DIRECTION:
          command = new DecimalValue(json);
          break;
        case HIGHLOW:
          command = new HighLowValue(json);
          break;
        case INCREASEDECREASE:
          command = new IncreaseDecreaseValue(json);
          break;
        case ONOFF:
          command = new OnOffValue(json);
          break;
        case PERCENT:
          command = new PercentValue(json);
          break;
        case STOPMOVE:
          command = new StopMoveValue(json);
          break;
        case STRING:
          command = new StringValue(json);
          break;
        case UPDOWN:
          command = new UpDownValue(json);
          break;
        default:
            command = null;
            break;
      }
      return command;
    } catch (IllegalArgumentException e){
      return null;
    }
  }
}
