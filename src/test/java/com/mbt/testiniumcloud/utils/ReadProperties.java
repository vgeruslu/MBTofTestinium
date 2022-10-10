package com.mbt.testiniumcloud.utils;

import com.mbt.testiniumcloud.driver.Driver;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ReadProperties {

    public static ResourceBundle readPropDir(String dir){

        ResourceBundle bundle = null;

        try {
            InputStream propertiesStream = new FileInputStream(dir);
            bundle = new PropertyResourceBundle(new InputStreamReader(propertiesStream, StandardCharsets.UTF_8));
            propertiesStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bundle;
    }

}
