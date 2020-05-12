package com.mbt.testiniumcloud.utils;

import com.mbt.testiniumcloud.driver.DriverCreater;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ReadProperties {

    public static ResourceBundle readProp(String systemSourcesDir){

        ResourceBundle bundle = null;

        try {
            String propertyDir = "/src/test/resources/"+systemSourcesDir;
            if(DriverCreater.osName.equals("WINDOWS")){
                propertyDir = propertyDir.replace("/","\\") ;
            }
            InputStream propertiesStream = new FileInputStream(System.getProperty("user.dir") + propertyDir);//ClassLoader.getSystemResource(systemSourcesDir).getPath()
            bundle = new PropertyResourceBundle(new InputStreamReader(propertiesStream,"UTF-8"));
            propertiesStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bundle;
    }

    public static String getPropertiesValue(ResourceBundle bundle, String propertiesKey){

        return bundle.getString(propertiesKey);
    }

    public static List<String> getPropertiesKeyList(ResourceBundle bundle){
        List<String> propertiesKeys = new ArrayList<String>();
        for(String key: bundle.keySet()){
        propertiesKeys.add(key);
        }
        return propertiesKeys;
    }
}
