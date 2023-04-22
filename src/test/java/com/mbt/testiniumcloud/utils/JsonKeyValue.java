package com.mbt.testiniumcloud.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonKeyValue {

    @SerializedName("key")
    @Expose
    private String key;

    @SerializedName("value")
    @Expose
    private String value;

    public  JsonKeyValue(){

    }

    public String getKey(){

        return key;
    }

    public  void setKey(String key){

        this.key = key;
    }

    public String getValue(){

        return value;
    }

    public  void setValue(String value){

        this.value = value;
    }
}
