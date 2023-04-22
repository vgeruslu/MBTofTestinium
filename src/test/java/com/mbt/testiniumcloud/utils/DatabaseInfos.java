package com.mbt.testiniumcloud.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;


public class DatabaseInfos {

    @SerializedName("isDatabaseExist")
    @Expose
    private Boolean isDatabaseExist;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("environment")
    @Expose
    private String environment;
    @SerializedName("databaseMap")
    @Expose
    private LinkedTreeMap<String, DatabaseInfo> databaseMap;

    public DatabaseInfos() {

    }

    public Boolean getDatabaseExist() {
        return isDatabaseExist;
    }

    public void setDatabaseExist(Boolean databaseExist) {
        isDatabaseExist = databaseExist;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public LinkedTreeMap<String, DatabaseInfo> getDatabaseMap() {
        return databaseMap;
    }

    public void setDatabaseMap(LinkedTreeMap<String, DatabaseInfo> databaseMap) {
        this.databaseMap = databaseMap;
    }
}
