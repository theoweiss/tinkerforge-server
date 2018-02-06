package org.m1theo.tinkerforge.server.tinkerforge;

import org.m1theo.tinkerforge.server.commands.*;
import org.m1theo.tinkerforge.types.DecimalValue;
import org.m1theo.tinkerforge.types.HSBValue;
import org.m1theo.tinkerforge.types.TinkerforgeValue;

/**
 * @author theo@m1theo.org
 */
public class TinkerforgeCommandFactory {

  public static TinkerforgeValue getCommand(Command command) {
    TinkerforgeValue value = null;
    switch (command.getCommandType()) {
      case COLOR:
        ColorValue colorValue = (ColorValue) command;
        value = new HSBValue(colorValue.getRed(), colorValue.getGreen(), colorValue.getBlue());
        break;
      case DECIMAL:
        value = new DecimalValue(((org.m1theo.tinkerforge.server.commands.DecimalValue) command).getValue());
        break;
      case DIRECTION:
        value = ((DirectionValue) command).getDirection() == DirectionValue.Direction.LEFT ? org.m1theo.tinkerforge.types.DirectionValue
            .LEFT : org.m1theo
            .tinkerforge.types.DirectionValue.RIGHT;
        break;
      case HIGHLOW:
        value = ((HighLowValue) command).getValue() == HighLowValue.HighLow.HIGH ? org.m1theo.tinkerforge.types
          .HighLowValue.HIGH :org.m1theo.tinkerforge.types.HighLowValue.LOW;
        break;
      case INCREASEDECREASE:
        value = ((IncreaseDecreaseValue) command).getValue() == IncreaseDecreaseValue.IncreaseDecrease.INCREASE ? org
            .m1theo.tinkerforge.types.IncreaseDecreaseValue.INCREASE : org.m1theo.tinkerforge.types
            .IncreaseDecreaseValue.DECREASE;
        break;
      case ONOFF:
        value = ((OnOffValue)command).getValue() == OnOffValue.OnOff.ON ? org.m1theo.tinkerforge.types.OnOffValue.ON
            : org.m1theo.tinkerforge.types.OnOffValue.OFF;
        break;
      case PERCENT:
        value = new org.m1theo.tinkerforge.types.PercentValue(((PercentValue) command).getValue());
        break;
      case STOPMOVE:
        value = ((StopMoveValue) command).getValue() == StopMoveValue.StopMove.MOVE ? org.m1theo.tinkerforge.types
            .StopMoveValue.MOVE : org.m1theo.tinkerforge.types.StopMoveValue.STOP;
        break;
      case STRING:
        value = new org.m1theo.tinkerforge.types.StringValue(((StringValue) command).getValue());
        break;
      case UPDOWN:
        value = ((UpDownValue) command).getValue() == UpDownValue.UpDown.UP ? org.m1theo.tinkerforge.types
            .UpDownValue.UP : org.m1theo.tinkerforge.types.UpDownValue.DOWN;
        break;
    }
    return value;
  }
}
