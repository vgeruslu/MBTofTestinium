package com.mbt.testiniumcloud.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatabaseInfo {

    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("port")
    @Expose
    private String port;

    public DatabaseInfo() {

    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
