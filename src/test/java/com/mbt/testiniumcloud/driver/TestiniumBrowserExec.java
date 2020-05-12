package com.mbt.testiniumcloud.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class TestiniumBrowserExec {
    private static WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger(TestiniumBrowserExec.class);

    public static WebDriver TestiniumExec(String key) {
        String testiniumHubUrl = DriverCreater.ConfigurationProp.getString("testiniumHubUrl");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("key", key);
        //logger.info(System.getenv().toString());
        String platform = System.getProperty("platform");
        String browser = System.getProperty("browser");
        DriverCreater.platformName = platform;
        DriverCreater.browserName = browser;
        logger.info("1 " + platform + "  " + browser);
        if(browser.trim().equalsIgnoreCase("chrome") ){
            logger.info(platform + "  " + browser);
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.addArguments("--start-maximized");
           // chromeOptions.addArguments("--start-fullscreen");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("test-type");
            chromeOptions.addArguments("disable-popup-blocking");
            chromeOptions.addArguments("ignore-certificate-errors");
            chromeOptions.addArguments("disable-translate");
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("w3c",false);
            //--disable-extensions
            chromeOptions.merge(capabilities);
            try {
                driver = new RemoteWebDriver(new URL(testiniumHubUrl), chromeOptions);
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
             /**   driver.get("chrome://settings/");
                if(platform.trim().equalsIgnoreCase("WIN10")){
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("chrome.settingsPrivate.setDefaultZoom(0.75);");
                }*/
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else {

            try {
                driver = new RemoteWebDriver(new URL(testiniumHubUrl), capabilities);
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        /**if(platform.trim().equalsIgnoreCase("mac")
                && browser.trim().equalsIgnoreCase("safari") ){
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(1600, 900));
        }*/
        /**if(browser.trim().equalsIgnoreCase("firefox")){
            driver.manage().window().maximize();
        }*/
        logger.info(((RemoteWebDriver)driver).getCapabilities().toString());
        return driver;
    }
}
