package com.mbt.testiniumcloud.driver;

import com.mbt.testiniumcloud.helper.ElementHelper;
import com.mbt.testiniumcloud.helper.StoreHelper;
import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.tests.TestResultJunit;
import com.mbt.testiniumcloud.utils.CreateMBTExcel;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.ReadProperties;
import com.mbt.testiniumcloud.utils.SendMail;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.junit.*;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import static org.apache.logging.log4j.LogManager.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Driver {

    private static final Logger logger = LogManager.getLogger(Driver.class);
    public static String browserName;
    public static boolean isFullScreen;
    public static WebDriver driver;
    public static String baseUrl;
    public static String osName = FindOS.getOperationSystemName();
    public static ResourceBundle ConfigurationProp = ReadProperties.readPropDir("./src/test/resources/Configuration.properties");
    public static String platformName;
    public static Result result;
    public static String testResult = "";
    public static ConcurrentHashMap<String,Object> TestMap;
    public static ConcurrentHashMap<String,Object> ModelDurationMap;
    public static Integer stepCount;
    public static String excelLocation;
    public static String slash = FindOS.getOperationSystemName().equals("WINDOWS") ? "\\": "/";
    public static String TestClassName = "";
    public static String TestCaseName = "";
    public static boolean excelActive = false;
    public static String userDir = Paths.get("").toAbsolutePath().toString();
    public static boolean chromeZoomCondition = false;
    public static boolean firefoxZoomCondition = false;
    public static boolean isSafari = false;
    public static boolean zoomCondition = false;
    public static String modelImplLogLevel = "";

    @BeforeClass
    public static void beforeClass(){

        if (Boolean.parseBoolean(Driver.ConfigurationProp.getString("log4jColorActive").toString())){
            LoggerContext loggerContext = (LoggerContext) getContext(false);
            File file = new File("./src/test/resources/log4j2Local.properties");
            loggerContext.setConfigLocation(file.toURI());
        }

        String rootLogLevel = Driver.ConfigurationProp.getString("logLevel").trim();
        Configurator.setRootLevel(Level.toLevel(rootLogLevel));

        String methodsClassLogLevel = Driver.ConfigurationProp.getString("methodsClassLogLevel");
        modelImplLogLevel = ConfigurationProp.getString("modelImplLogLevel");
        Configurator.setLevel(getLogger(Methods.class), Level.toLevel(methodsClassLogLevel));
        String elementHelperLogLevel = ConfigurationProp.getString("elementHelperLogLevel");
        Configurator.setLevel(getLogger(Driver.class), Level.ALL);
        Configurator.setLevel(getLogger(TestResultJunit.class), Level.ALL);
        Configurator.setLevel(getLogger(LocalBrowserExec.class), Level.ALL);
        Configurator.setLevel(getLogger(FindOS.class), Level.ALL);
        Configurator.setLevel(getLogger(ExcelMapData.class), Level.ALL);
        Configurator.setLevel(getLogger(SendMail.class), Level.ALL);
        Configurator.setLevel(getLogger(CreateMBTExcel.class), Level.ALL);
        Configurator.setLevel(getLogger(StoreHelper.class), Level.toLevel(elementHelperLogLevel));
        Configurator.setLevel(getLogger(ElementHelper.class), Level.toLevel(elementHelperLogLevel));
        Configurator.setLevel(getLogger(StoreHelper.class), Level.toLevel(elementHelperLogLevel));
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
                logger.info("Excel silindi");
            }else
                logger.info("Excel mevcut değil");
        }catch (Exception e){
            logger.info("Excel silinemedi");
        }
        try{
            File file = new File(userDir + slash+ "testFailInfo.txt");
            if(file.exists()){
                file.delete();
            }
        }catch (Exception e){
        }
        try{
            File file = new File(userDir + slash + "testResult.txt");
            if(file.exists()){
                file.delete();
            }
        }catch (Exception e){
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

        if (Boolean.parseBoolean(ConfigurationProp.getString("localQuitDriverActive"))) {
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

        boolean isSuccess = !result.hasErrors();
        if (isSuccess){
            excelMapData.setTestResult("Successfull");
            logger.info("Done: [" + result.getResults().toString(2) + "]");
        }else {
            excelMapData.setTestResult("Failed");
            logger.error("Done: [" + "\r\n" + "  \"totalFailedNumberOfModels\""
                    + result.getResults().toString(2).split("\"totalFailedNumberOfModels\"")[1] + "]");
        }

        assertTrue(isSuccess, isSuccess ? "" : result.getErrors().toString().split("Caused by:")[1]);
    }

    public void createDriver() throws MalformedURLException, Exception {

        //ConfigurationProp = ReadProperties.readProp("Configuration.properties");
        String key = System.getProperty("key");
        browserName = ConfigurationProp.getString("browserName");
        baseUrl = ConfigurationProp.getString("baseUrl");
        isFullScreen = Boolean.parseBoolean(ConfigurationProp.getString("isFullScreen"));
        platformName = FindOS.getOperationSystemNameExpanded();
        driver = LocalBrowserExec.LocalExec(browserName);

        logger.info("Driver ayağa kaldırıldı.");
        isSafari = browserName.equalsIgnoreCase("safari");
        zoomCondition = (browserName.equalsIgnoreCase("chrome") && chromeZoomCondition)
                || (browserName.equalsIgnoreCase("firefox") && firefoxZoomCondition);
        driver.get(baseUrl);
    }

    public void quitDriver() {

        if(driver != null || Boolean.parseBoolean(ConfigurationProp.getString("localQuitDriverActive"))){
            driver.quit();
            logger.info("Driver kapatıldı.");
        }

        sendMail();
    }

    public void sendMail() {

        if (excelActive
                && Integer.parseInt(ModelDurationMap.get("TotalStepCount").toString()) > 1) {
            try {
                new ExcelMapData().createExcel();
            } catch (Exception e) {
                logger.info("Excel oluşturulamadı.");
                e.printStackTrace();
                excelActive = false;
            }
            if (excelActive) {
                String toMail = ConfigurationProp.getString("toMail");
                new SendMail().sendMailTestResult(result, toMail, excelLocation);
            } else {
                logger.info("Excel oluşturulamadığı için mail yollanamadı.");
            }
        }
    }
}
