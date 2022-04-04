package com.mbt.testiniumcloud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElementInfo
{
  @SerializedName("key")
  @Expose
  private String key;
  @SerializedName("value")
  @Expose
  private String value;
  @SerializedName("type")
  @Expose
  private String type;
  @SerializedName("index")
  @Expose
  private int index;

  private int fileNameIndex;

  public ElementInfo(){

  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public int getFileNameIndex() {
    return fileNameIndex;
  }

  public void setFileNameIndex(int fileNameIndex) {
    this.fileNameIndex = fileNameIndex;
  }
}
