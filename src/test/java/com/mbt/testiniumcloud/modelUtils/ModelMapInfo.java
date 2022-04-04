package com.mbt.testiniumcloud.modelUtils;

import java.util.Set;

public class ModelMapInfo {

    private String modelName;

    private Set<String> elementSet;

    private String jsonFileLocation;

    public ModelMapInfo(){

    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Set<String> getElementSet() {
        return elementSet;
    }

    public void setElementSet(Set<String> elementSet) {
        this.elementSet = elementSet;
    }

    public String getJsonFileLocation() {
        return jsonFileLocation;
    }

    public void setJsonFileLocation(String jsonFileLocation) {
        this.jsonFileLocation = jsonFileLocation;
    }
}
