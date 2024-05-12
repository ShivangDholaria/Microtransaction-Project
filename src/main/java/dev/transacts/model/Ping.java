package dev.transacts.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;


public class Ping {
    
  private String timeStamp;
  private JSONObject responseObject;

  public Ping() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    setTimeStamp(dtf.format(LocalDateTime.now()));
  }


  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  @SuppressWarnings("unchecked")
  public JSONObject ping() {
    responseObject = new JSONObject();
    responseObject.put("serverTime", this.timeStamp);

    return responseObject;
  }
  
}
