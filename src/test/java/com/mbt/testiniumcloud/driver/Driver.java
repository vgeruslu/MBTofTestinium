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
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.junit.*;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import static org.apache.logging.log4j.LogManager.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Driver {

    private static final Logger logger = LogManager.getLogger(Driver.class);
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
    public static String TestClassName = "";
    public static String TestCaseName = "";
    public static boolean excelActive = false;
    public static String userDir = System.getProperty("user.dir");
    public static boolean chromeZoomCondition = false;
    public static boolean firefoxZoomCondition = false;
    public static boolean isSafari = false;
    public static boolean zoomCondition = false;
    public static String modelImplLogLevel = "";

    @BeforeClass
    public static void beforeClass(){

        if(StringUtils.isNotEmpty(System.getProperty("key"))){
            isTestinium = true;
        }
        if (!isTestinium){
            LoggerContext loggerContext = (LoggerContext) LogManager.getContext(false);
            File file = new File("./src/test/resources/log4j2Local.properties");
            loggerContext.setConfigLocation(file.toURI());
        }

        getRootLogger().atLevel(Level.toLevel(Driver.ConfigurationProp.getString("logLevel")));

        String methodsClassLogLevel = Driver.ConfigurationProp.getString("methodsClassLogLevel");
        modelImplLogLevel = ConfigurationProp.getString("modelImplLogLevel");
        String elementHelperLogLevel = ConfigurationProp.getString("elementHelperLogLevel");
        getLogger(Methods.class).atLevel(Level.toLevel(methodsClassLogLevel));
        getLogger(Driver.class).atLevel(Level.ALL);
        getLogger(TestResultJunit.class).atLevel(Level.ALL);
        getLogger(TestiniumBrowserExec.class).atLevel(Level.ALL);
        getLogger(LocalBrowserExec.class).atLevel(Level.ALL);
        getLogger(FindOS.class).atLevel(Level.ALL);
        getLogger(ExcelMapData.class).atLevel(Level.ALL);
        getLogger(StoreHelper.class).atLevel(Level.toLevel(elementHelperLogLevel));
        getLogger(ElementHelper.class).atLevel(Level.toLevel(elementHelperLogLevel));
        getLogger(ExcelMapData.class).atLevel(Level.ALL);
        getLogger(SendMail.class).atLevel(Level.ALL);
        getLogger(CreateMBTExcel.class).atLevel(Level.ALL);
        getLogger(StoreHelper.class).atLevel(Level.toLevel(elementHelperLogLevel));
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

        if (isTestinium || Boolean.parseBoolean(ConfigurationProp.getString("localQuitDriverActive"))) {
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
        if(StringUtils.isEmpty(key)) {
            isTestinium = false;
            platformName = FindOS.getOperationSystemNameExpanded();
            driver = LocalBrowserExec.LocalExec(browserName);
        }
        else {
            isTestinium = true;
            driver = TestiniumBrowserExec.TestiniumExec(key);
        }

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
                if (isTestinium) {
                    String toMailTestinium = System.getProperty("toMail");
                    if (!StringUtils.isEmpty(toMailTestinium)) {
                        toMail = toMailTestinium;
                    }
                }
                new SendMail().sendMailTestResult(result, toMail, excelLocation);
            } else {
                logger.info("Excel oluşturulamadığı için mail yollanamadı.");
            }
        }
    }
}
