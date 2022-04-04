package com.mbt.testiniumcloud.modelUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EdgeGsonType {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("sourceVertexId")
    @Expose
    private String sourceVertexId;

    @SerializedName("targetVertexId")
    @Expose
    private String targetVertexId;

    @SerializedName("guard")
    @Expose
    private String guard;

    @SerializedName("actions")
    @Expose
    private List<String> actions;

    @SerializedName("weight")
    @Expose
    private String weight;

    public EdgeGsonType(){

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

    public String getSourceVertexId() {
        return sourceVertexId;
    }

    public void setSourceVertexId(String sourceVertexId) {
        this.sourceVertexId = sourceVertexId;
    }

    public String getTargetVertexId() {
        return targetVertexId;
    }

    public void setTargetVertexId(String targetVertexId) {
        this.targetVertexId = targetVertexId;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

}
