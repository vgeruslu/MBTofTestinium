package com.mbt.testiniumcloud.utils;

import com.mbt.testiniumcloud.driver.Driver;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ReadProperties {

    public static ResourceBundle readProp(String systemSourcesDir){

        String propertyDir = "/src/test/resources/" + systemSourcesDir;
        return readPropDir(propertyDir,true);
    }

    public static ResourceBundle readPropDir(String dir, boolean isProjectDir){

        ResourceBundle bundle = null;

        try {
            String propertyDir = "";
            propertyDir = isProjectDir ? System.getProperty("user.dir") + dir : dir;
            if(Driver.osName.equals("WINDOWS")){
                propertyDir = propertyDir.replace("/","\\") ;
            }
            InputStream propertiesStream = new FileInputStream(propertyDir);//ClassLoader.getSystemResource(systemSourcesDir).getPath()
            bundle = new PropertyResourceBundle(new InputStreamReader(propertiesStream, StandardCharsets.UTF_8));
            propertiesStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bundle;
    }

    public static String readFile(String fileLocation){

        StringBuilder jsonStringBuilder = new StringBuilder();
        InputStream propertiesStream = null;
        try {
            propertiesStream = new FileInputStream(Driver.userDir
                    + (Driver.slash.equals("/") ? fileLocation : fileLocation.replace("/","\\")));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(propertiesStream, StandardCharsets.UTF_8));
            String jsonString;
            while(true){
                if ((jsonString = bufferedReader.readLine()) == null) break;
                jsonStringBuilder.append(jsonString);
                jsonStringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStringBuilder.toString();
    }

}
