package com.mbt.testiniumcloud.driver;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindOS {

    private static Logger logger = LoggerFactory.getLogger(FindOS.class);

    public static String getOperationSystemName(){

        logger.info(System.getProperty("os.name"));
        if(SystemUtils.IS_OS_WINDOWS){
            return "WINDOWS";
        }else if(SystemUtils.IS_OS_MAC){
            return "MAC";
        }else if (SystemUtils.IS_OS_LINUX){
            return "LINUX";
        }else
            return "null";
    }

    public static String getOperationSystemNameExpanded(){

        logger.info(System.getProperty("os.name"));
        if(SystemUtils.IS_OS_WINDOWS) {
            if (SystemUtils.IS_OS_WINDOWS_7) {
                return "WIN7";
            }else if (SystemUtils.IS_OS_WINDOWS_8) {
                return "WIN8";
            }else if (SystemUtils.IS_OS_WINDOWS_10) {
                return "WIN10";
            }else {
                return "WIN";
            }
        }else if(SystemUtils.IS_OS_MAC){
            return "MAC";
        }else if (SystemUtils.IS_OS_LINUX){
            return "LINUX";
        }else
            return "null";
    }

}
