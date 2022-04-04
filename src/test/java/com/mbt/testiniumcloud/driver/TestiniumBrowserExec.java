package com.mbt.testiniumcloud.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;

public class TestiniumBrowserExec {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(TestiniumBrowserExec.class);

    public static WebDriver TestiniumExec(String key) throws InterruptedException {

        String testiniumHubUrl = Driver.ConfigurationProp.getString("testiniumHubUrl");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("key", key);

        if(Driver.ConfigurationProp.getString("proxyActive").trim().equals("true")) {
            String PROXY = Driver.ConfigurationProp.getString("proxyAddress").trim();
            Proxy proxy = new Proxy();
            proxy.setProxyType(Proxy.ProxyType.MANUAL);
            proxy.setHttpProxy(PROXY);
            proxy.setFtpProxy(PROXY);
            proxy.setSslProxy(PROXY);
            capabilities.setCapability(CapabilityType.PROXY, proxy);
        }

        //logger.info(System.getProperty().toString());
        /**Properties properties = System.getProperties();
        Set<String> set = properties.stringPropertyNames();
        for (String propertiesName: set){
            logger.info(propertiesName + " " + properties.getProperty(propertiesName));
        }*/
        String platform = System.getProperty("platform");
        String browser = System.getProperty("browser");
        Driver.platformName = platform;
        Driver.browserName = browser;
        logger.info(platform + "  " + browser);
        switch (browser.toLowerCase(Locale.ENGLISH)){

            case "chrome" :
                driver = getChromeDriver(capabilities, testiniumHubUrl);
                if(Boolean.parseBoolean(Driver.ConfigurationProp.getString("testiniumChromeZoomActive"))
                        && Driver.ConfigurationProp.getString("testiniumChromeZoomPlatform").contains(Driver.platformName)) {
                    driver.get("chrome://settings/");
                    Thread.sleep(1000);
                    logger.info("testinium zoom");
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("chrome.settingsPrivate.setDefaultZoom("
                            + Driver.ConfigurationProp.getString("testiniumChromeZoomSize") + ");");
                    Driver.chromeZoomCondition = true;
                }
                break;
            case "firefox" :
                driver = getFirefoxDriver(capabilities,testiniumHubUrl);
                break;
            default:

                try {
                    driver = new RemoteWebDriver(new URL(testiniumHubUrl), capabilities);
                    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                } catch (MalformedURLException e) {
                    throw new WebDriverException(e);
                }
        }
        if(platform.equalsIgnoreCase("mac")
                && browser.equalsIgnoreCase("safari") ){
            //driver.manage().window().setPosition(new Point(0, 0));
            //driver.manage().window().setSize(new Dimension(1600, 900));
            driver.manage().window().maximize();
        }
        /**if(browser.trim().equalsIgnoreCase("firefox")){
            driver.manage().window().maximize();
        }*/
        logger.info(((RemoteWebDriver)driver).getCapabilities().toString());
        return driver;
    }

    private static WebDriver getChromeDriver(DesiredCapabilities capabilities, String testiniumHubUrl){

        // logger.info(platform + "  " + browser);
        ChromeOptions chromeOptions = new ChromeOptions();

        // performance logs
        if(Driver.ConfigurationProp.getString("performanceLog").equals("true")) {
            LoggingPreferences logPrefs = new LoggingPreferences();
            //logPrefs.addPreferences(new string[] { "devtools.network" });
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
            //chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            chromeOptions.setCapability("goog:loggingPrefs", logPrefs);
        }

        if (Driver.ConfigurationProp.getString("remoteDebuggingPort").equals("true")) {
            chromeOptions.addArguments("--remote-debugging-port=9222");
        }

        //chromeOptions.addArguments("--lang=tr-TR");
        //chromeOptions.addArguments("--start-maximized");
        // chromeOptions.addArguments("--start-fullscreen");
        chromeOptions.addArguments("--disable-notifications");
        //chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("--disable-blink-features");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-extensions");
        // chromeOptions.addArguments("window-size=1389,875");
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        // chromeOptions.addArguments("--disable-web-security");
        // chromeOptions.addArguments("--no-proxy-server");
        //chromeOptions.addArguments("--allow-running-insecure-content");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        //chromeOptions.addArguments("--disable-blink-features=BlockCredentialedSubresources");
        // chromeOptions.addArguments("--incognito");
        // chromeOptions.addArguments("--disable-dev-shm-usage");
        /** chromeOptions.addArguments("disable-popup-blocking");
         chromeOptions.addArguments("ignore-certificate-errors");
         chromeOptions.addArguments("disable-translate");
         chromeOptions.addArguments("disable-infobars"); */
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
            throw new WebDriverException(e);
        }
        return driver;
    }

    private static WebDriver getFirefoxDriver(DesiredCapabilities capabilities, String testiniumHubUrl){

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        if(Boolean.parseBoolean(Driver.ConfigurationProp.getString("testiniumFirefoxZoomActive"))
                && Driver.ConfigurationProp.getString("testiniumFirefoxZoomPlatform").contains(Driver.osName)) {
            firefoxProfile.setPreference("layout.css.devPixelsPerPx",
                    Driver.ConfigurationProp.getString("testiniumFirefoxZoomSize"));
            Driver.firefoxZoomCondition = true;
        }
        // firefoxProfile.setPreference("network.cookie.cookieBehavior",2);
        firefoxProfile.setPreference("dom.webnotifications.enabled", false);
        firefoxOptions.setProfile(firefoxProfile);
        firefoxOptions.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL(testiniumHubUrl), firefoxOptions);
            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException e) {
            throw new WebDriverException(e);
        }
        return driver;
    }

    private static WebDriver getSafariDriver(DesiredCapabilities capabilities, String testiniumHubUrl){

        //capabilities
        //capabilities.setCapability("browserstack.safari.enablePopups", "false");
        SafariOptions safariOptions = new SafariOptions();
        //safariOptions.setCapability("safari.cleanSession", true);
        //safariOptions.setUseTechnologyPreview(true);
        // options
        safariOptions.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL(testiniumHubUrl), safariOptions);
            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException e) {
            throw new WebDriverException(e);
        }
        return driver;
    }

    private static WebDriver getEdgeDriver(DesiredCapabilities capabilities, String testiniumHubUrl){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.setExperimentalOption("w3c",false);
        chromeOptions.setBinary(Driver.ConfigurationProp.getString("edgeBrowserLocation"));
        EdgeOptions edgeOptions = new EdgeOptions().merge(chromeOptions);
        // options
        edgeOptions.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL(testiniumHubUrl), edgeOptions);
            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException e) {
            throw new WebDriverException(e);
        }
        return driver;
    }

    private static WebDriver getieDriver(DesiredCapabilities capabilities, String testiniumHubUrl){

        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability("ignoreProtectedModeSettings",1);
        capabilities.setCapability("nativeEvents",false);
        //capabilities.setCapability("requireWindowFocus","true");
        capabilities.setCapability("requireWindowFocus", true);
        capabilities.setCapability("enablePersistentHover", false);
        capabilities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
        capabilities.setCapability("ignoreProtectedModeSettings", true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        //capabilities
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
        // options
        internetExplorerOptions.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL(testiniumHubUrl), internetExplorerOptions);
            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException e) {
            throw new WebDriverException(e);
        }
        return driver;
    }

    private static WebDriver getOperaDriver(DesiredCapabilities capabilities, String testiniumHubUrl){

        OperaOptions operaOptions = new OperaOptions();
        operaOptions.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL(testiniumHubUrl), operaOptions);
            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException e) {
            throw new WebDriverException(e);
        }
        return driver;
    }

}
