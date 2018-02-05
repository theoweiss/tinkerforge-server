package org.m1theo.tinkerforge.server.commands;

/**
 * @author theo@m1theo.org
 */
public enum CommandType {
  COLOR("color"), DECIMAL("decimal"), DIRECTION("direction"), HIGHLOW("highLow"), INCREASEDECREASE("increaseDecrease"),
  ONOFF("onOff"), PERCENT("percent"), STOPMOVE("stopMove"), STRING("string"), UPDOWN("upDown");

  private final String type;

  CommandType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
