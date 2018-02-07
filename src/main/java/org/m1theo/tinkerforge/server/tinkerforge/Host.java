package org.m1theo.tinkerforge.server.tinkerforge;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * @author theo@m1theo.org
 */

@DataObject(generateConverter = true)
public class Host {
  private String host;
  private Integer port;
  private String authKey;

  public Host(String host, Integer port, String authKey) {
    this.host = host;
    this.port = port;
    this.authKey = authKey;
  }

  public Host(org.m1theo.tinkerforge.config.Host host) {
    this.host = host.getHost();
    this.port = host.getPort();
    this.authKey = host.getAuthKey();
  }

  public Host(JsonObject json) {
    this();
    HostConverter.fromJson(json, this);
  }

  public Host() {
  }

  public JsonObject toJson(){
    JsonObject json = new JsonObject();
    HostConverter.toJson(this, json);
    return json;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public String getAuthKey() {
    return authKey;
  }

  public void setAuthKey(String authKey) {
    this.authKey = authKey;
  }
}
