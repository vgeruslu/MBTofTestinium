package com.mbt.testiniumcloud.modelUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelGsonType
{
  @SerializedName("edges")
  @Expose
  private List<EdgeGsonType> edges;

  @SerializedName("generator")
  @Expose
  private String generator;

  @SerializedName("id")
  @Expose
  private String id;

  @SerializedName("name")
  @Expose
  private String name;

  @SerializedName("startElementId")
  @Expose
  private String startElementId;

  @SerializedName("vertices")
  @Expose
  private List<VertexGsonType> vertices;

  @SerializedName("editor")
  @Expose
  private Object editor;

  @SerializedName("actions")
  @Expose
  private List<String> actions;

  public ModelGsonType(){

  }

  public List<EdgeGsonType> getEdges() {
    return edges;
  }

  public void setModel(List<EdgeGsonType> edges) {
    this.edges = edges;
  }

  public String getGenerator() {
    return generator;
  }

  public void setGenerator(String generator) {
    this.generator = generator;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStartElementId() {
    return startElementId;
  }

  public void setStartElementId(String startElementId) {
    this.startElementId = startElementId;
  }

  public List<VertexGsonType> getVertices() {
    return vertices;
  }

  public void setVertices(List<VertexGsonType> vertices) {
    this.vertices = vertices;
  }

  public Object getEditor() {
    return editor;
  }

  public void setEditor(Object editor) {
    this.editor = editor;
  }

  public List<String> getActions() {
    return actions;
  }

  public void setActions(List<String> actions) {
    this.actions = actions;
  }

}
