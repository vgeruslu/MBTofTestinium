package com.mbt.testiniumcloud.utils;

public class JsonPathValue {

    private String key;
    private Object value;
    private String type;
    private String id;
    private String valueControlType;
    private boolean OrActive;

    public JsonPathValue(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValueControlType() {
        return valueControlType;
    }

    public void setValueControlType(String valueControlType) {
        this.valueControlType = valueControlType;
    }

    public boolean getOrActive() {
        return OrActive;
    }

    public void setOrActive(boolean OrActive) {
        this.OrActive = OrActive;
    }

}