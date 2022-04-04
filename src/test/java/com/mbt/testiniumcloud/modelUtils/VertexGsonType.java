package com.mbt.testiniumcloud.modelUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VertexGsonType {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("sharedState")
    @Expose
    private String sharedState;

    @SerializedName("properties")
    @Expose
    private VertexPropertiesGsonType properties;

    @SerializedName("requirements")
    @Expose
    private List<String> requirements;

    public VertexGsonType(){

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

    public String getSharedState() {
        return sharedState;
    }

    public void setSharedState(String sharedState) {
        this.sharedState = sharedState;
    }

    public VertexPropertiesGsonType getProperties() {
        return properties;
    }

    public void setProperties(VertexPropertiesGsonType properties) {
        this.properties = properties;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }
}
