package com.mbt.testiniumcloud.modelUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelsGsonType
{
  @SerializedName("models")
  @Expose
  private List<ModelGsonType> model;

  @SerializedName("selectedModelIndex")
  @Expose
  private int selectedModelIndex;

  @SerializedName("selectedElementId")
  @Expose
  private String selectedElementId;

  public ModelsGsonType(){

  }

  public List<ModelGsonType> getModel() {
    return model;
  }

  public void setModel(List<ModelGsonType> model) {
    this.model = model;
  }

  public int getSelectedModelIndex() {
    return selectedModelIndex;
  }

  public void setSelectedModelIndex(int selectedModelIndex) {
    this.selectedModelIndex = selectedModelIndex;
  }

  public String getSelectedElementId() {
    return selectedElementId;
  }

  public void setSelectedElementId(String selectedElementId) {
    this.selectedElementId = selectedElementId;
  }
}
