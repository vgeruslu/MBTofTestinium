package com.mbt.testiniumcloud.driver;

import com.mbt.testiniumcloud.tests.GraphWalkerTestiniumCloudTest;
import com.mbt.testiniumcloud.tests.TestResultJunit;
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
    public static String osName;
    public static String winHandleBefore;
    public static ResourceBundle ConfigurationProp;
    public static String platformName;
    public static Result result;
    public static List<String> listExecution;
    public static String testResult = "";
    public static ConcurrentHashMap<String,Object> TestMap;

    @BeforeClass
    public static void beforeClass(){

        TestMap = new ConcurrentHashMap<String, Object>();
        //deneme
        //TestMap.put("stepCount", 0);
        String dir = "/src/test/resources/log4j.properties";
        if(FindOS.getOperationSystemName().equals("WINDOWS")){
            dir = dir.replace("/","\\");
        }
        PropertyConfigurator.configure(System.getProperty("user.dir") + dir);
        //getRootLogger().setLevel(Level.ALL);
        getRootLogger().setLevel(Level.OFF);

        getLogger(GraphWalkerTestiniumCloudTest.class).setLevel(Level.ALL);
        getLogger(DriverCreater.class).setLevel(Level.ALL);
        getLogger(TestResultJunit.class).setLevel(Level.ALL);
        getLogger(TestiniumBrowserExec.class).setLevel(Level.ALL);
        getLogger(LocalBrowserExec.class).setLevel(Level.ALL);
        getLogger(FindOS.class).setLevel(Level.ALL);
        logger.info("*************************************************************************");
        System.out.println("\r\n");
    }

    @Before
    public void before(){

        logger.info("_________________________________________________________________________" + "\r\n");
        logger.info("------------------------SCENARIO-------------------------");
        try {
            createDriver();
        }catch (Throwable e) {

            StackTraceElement[] stackTraceElements = e.getStackTrace();
            String error = e.toString() + "\r\n";
            for (int i = 0; i < stackTraceElements.length; i++) {

                error = error + "\r\n" + stackTraceElements[i].toString();
            }
            logger.error(error);
            throw new SessionNotCreatedException(error);
        }
    }

    @After
    public void after() {

        if (isTestinium || Boolean.parseBoolean(ConfigurationProp.getString("localQuitDriverCondition"))) {
            quitDriver();
        }
        logger.info("_________________________________________________________________________" + "\r\n");
        /**
        new SendMail().sendMailTestResult(result,listExecution,toMail);
         */
    }

    @AfterClass
    public static void afterClass(){

        //System.out.println("\r\n");
        System.out.println("");
        logger.info("*************************************************************************");
    }

    public void setInfo(Executor executor){

        List<Execution> list  = executor.getMachine().getCurrentContext().getProfiler().getExecutionPath();
        listExecution = new ArrayList<String>();
        String info;
        String type;
        Element element;
        Execution execution;
        for (int i = 0 ; i < list.size() ; i++) {
            execution = list.get(i);
            element = execution.getElement();
            type = "";
            if (element instanceof Vertex.RuntimeVertex) {
                type = "vertex";
            } else if (element instanceof Edge.RuntimeEdge) {
                type = "edge";
            }

            info = (i + 1) + " " + element.getId() + " " + type + " " + execution.getContext().getModel().getName() + " " + element.getName();
            logger.info(info);
            listExecution.add(info);
        }
    }

    public void errorControl(){

        if (result.hasErrors()) {

            logger.error("Done: [" + result.getResults().toString(2) + "]");
            Assert.fail(result.getErrors().toString());
        }
        logger.info("Done: [" + result.getResults().toString(2) + "]");
    }

    public void createDriver() throws MalformedURLException, Exception {

        osName = FindOS.getOperationSystemName();
        ConfigurationProp = ReadProperties.readProp("Configuration.properties");
        String key = System.getProperty("key");
        browserName = ConfigurationProp.getString("browserName");
        baseUrl = ConfigurationProp.getString("baseUrl");
        isFullScreen = Boolean.parseBoolean(ConfigurationProp.getString("isFullScreen"));
        if(StringUtils.isEmpty(key)) {
            platformName = FindOS.getOperationSystemNameExpanded();
            driver = LocalBrowserExec.LocalExec(browserName);
            isTestinium = false;
        }
        else {
            driver = TestiniumBrowserExec.TestiniumExec(key);
            isTestinium = true;
        }

        logger.info("Driver ayağa kaldırıldı.");
        driver.get(baseUrl);
       // winHandleBefore = driver.getWindowHandle();
    }

    public void quitDriver() {

        if(driver != null){
            driver.quit();
            logger.info("Driver kapatıldı.");
        }
        //logger.info("_________________________________________________________________________" + "\r\n");
    }

}
