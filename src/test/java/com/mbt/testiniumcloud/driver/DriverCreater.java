package com.mbt.testiniumcloud.driver;

import com.mbt.testiniumcloud.tests.GraphWalkerTestiniumCloudTest;
import com.mbt.testiniumcloud.tests.TestResultJunit;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.ReadProperties;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Element;
import org.graphwalker.core.model.Vertex;
import org.graphwalker.core.statistics.Execution;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.junit.*;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import static org.apache.log4j.Logger.*;

public class DriverCreater {

    private static Logger logger = LoggerFactory.getLogger(DriverCreater.class);
    public static String browserName;
    public static boolean isFullScreen;
    public static WebDriver driver;
    public static boolean isTestinium = false;
    public static String baseUrl;
    public static String osName = FindOS.getOperationSystemName();
    public static ResourceBundle ConfigurationProp = ReadProperties.readProp("Configuration.properties");
    public static String platformName;
    public static Result result;
    public static String testResult = "";
    public static ConcurrentHashMap<String,Object> TestMap;
    public static ConcurrentHashMap<String,Object> ModelDurationMap;
    public static Integer stepCount;
    public static String excelLocation;
    public static String slash = FindOS.getOperationSystemName().equals("WINDOWS") ? "\\": "/";
    public static String TestCaseName = "";
    public static boolean excelActive = false;
    public static String userDir = System.getProperty("user.dir");
    public static boolean chromeZoomCondition = false;
    public static boolean isSafari = false;
    public static boolean zoomCondition = false;

    @BeforeClass
    public static void beforeClass(){

        String dir = "/src/test/resources/log4j.properties";
        if(!slash.equals("/")) {
            dir = dir.replace("/", "\\");
        }
        /**if(FindOS.getOperationSystemName().equals("WINDOWS")){
            slash = "\\";
            dir = dir.replace("/","\\");
        }*/
        PropertyConfigurator.configure(userDir + dir);
                //GraphWalkerTestiniumCloudTest.class.getClassLoader().getResource("log4j.properties"));
        //getRootLogger().setLevel(Level.ALL);
        getRootLogger().setLevel(Level.OFF);

        getLogger(GraphWalkerTestiniumCloudTest.class).setLevel(Level.ALL);
        getLogger(DriverCreater.class).setLevel(Level.ALL);
        getLogger(TestResultJunit.class).setLevel(Level.ALL);
        getLogger(TestiniumBrowserExec.class).setLevel(Level.ALL);
        getLogger(LocalBrowserExec.class).setLevel(Level.ALL);
        getLogger(FindOS.class).setLevel(Level.ALL);
        getLogger(ExcelMapData.class).setLevel(Level.ALL);
        logger.info("*************************************************************************");
        System.out.println("\r\n");
    }

    @Before
    public void before(){

        logger.info("_________________________________________________________________________" + "\r\n");
        logger.info("------------------------SCENARIO-------------------------");

        TestMap = new ConcurrentHashMap<String, Object>();
        ModelDurationMap = new ConcurrentHashMap<String, Object>();
        stepCount = 0;
        testResult = "";
        excelLocation = userDir + slash + "TestiniumMBTTestPath.xlsx";
        excelActive = false;

        try{
            File file = new File(excelLocation);
            if(file.exists()){
                file.delete();
                logger.info("Excel file is deleted.");
            }else
                logger.info("Excel file is not found.");
        }catch (Exception e){
            logger.info("Excel file is not deleted.");
        }

        try {
            createDriver();
        }catch (Throwable e) {

            StackTraceElement[] stackTraceElements = e.getStackTrace();
            String error = e.toString() + "\r\n";
            for (int i = 0; i < stackTraceElements.length; i++) {

                error = error + "\r\n" + stackTraceElements[i].toString();
            }
            //logger.error(error);
            throw new SessionNotCreatedException(error);
        }
    }

    @After
    public void after() {

        if (isTestinium || Boolean.parseBoolean(ConfigurationProp.getString("localQuitDriverCondition"))) {
            quitDriver();
        }
        logger.info("_________________________________________________________________________" + "\r\n");
    }

    @AfterClass
    public static void afterClass(){

        System.out.println("");
        logger.info("*************************************************************************");
    }

    public void setExcel(Executor executor){

        excelActive = true;
        new ExcelMapData().createMapData(executor.getMachine());
    }

    public void errorControl(){

        ExcelMapData excelMapData = new ExcelMapData();
        if (result.hasErrors()) {

            excelMapData.setTestResult("Failed");
            logger.error("Done: [" + "\r\n" + "  \"totalFailedNumberOfModels\"" + result.getResults().toString(2).split("\"totalFailedNumberOfModels\"")[1] + "]");
            Assert.fail(result.getErrors().toString());
        }

        excelMapData.setTestResult("Successfull");
        logger.info("Done: [" + result.getResults().toString(2) + "]");
    }

    public void createDriver() throws MalformedURLException, Exception {

        //ConfigurationProp = ReadProperties.readProp("Configuration.properties");
        String key = System.getProperty("key");
        browserName = ConfigurationProp.getString("browserName");
        baseUrl = ConfigurationProp.getString("baseUrl");
        isFullScreen = Boolean.parseBoolean(ConfigurationProp.getString("isFullScreen"));
        if(StringUtils.isEmpty(key)) {
            isTestinium = false;
            platformName = FindOS.getOperationSystemNameExpanded();
            driver = LocalBrowserExec.LocalExec(browserName);
        }
        else {
            isTestinium = true;
            driver = TestiniumBrowserExec.TestiniumExec(key);
        }

        logger.info("Driver is started.");
        isSafari = browserName.equalsIgnoreCase("safari");
        zoomCondition = !DriverCreater.isTestinium
                && DriverCreater.browserName.equalsIgnoreCase("chrome")
                && DriverCreater.chromeZoomCondition;
        driver.get(baseUrl);
    }

    public void quitDriver() {

        if(driver != null){
            driver.quit();
            logger.info("Driver is closed.");
        }
    }

}
