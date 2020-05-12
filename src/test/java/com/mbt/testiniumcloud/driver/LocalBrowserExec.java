package com.mbt.testiniumcloud.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Locale;

public class LocalBrowserExec {

    private static WebDriver driver;
    public static WebDriver LocalExec(String browser) throws Exception{

        SetBrowserForOS.setDriverPath(browser);

        switch (browser.toLowerCase(Locale.ENGLISH)){

            case "chrome" :
                driver = getChromeDriver();
                if(Boolean.parseBoolean(DriverCreater.ConfigurationProp.getString("chromeZoomCondition"))
                        && DriverCreater.ConfigurationProp.getString("chromeZoomPlatform").contains(DriverCreater.osName)) {
                    driver.get("chrome://settings/");
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("chrome.settingsPrivate.setDefaultZoom("
                            + DriverCreater.ConfigurationProp.getString("chromeZoomSize") + ");");
                }
                break;
            case "firefox" :
                driver = getFirefoxDriver();
                break;
            case "safari" :
                driver = getSafariDriver();
                break;
            case "edge" :
                driver = getEdgeDriver();
                break;
            case "ie" :
                driver = getieDriver();
                break;
            case "opera" :
                driver = getOperaDriver();
                break;
            default:
                throw new Exception("Hata");
        }

        if(DriverCreater.isFullScreen) {
            Thread.sleep(1000);
            //driver.manage().window().fullscreen();
            driver.manage().window().maximize();
        }else if(DriverCreater.ConfigurationProp.getString("setSize").equalsIgnoreCase("true")){
            String[] sizeValue = DriverCreater.ConfigurationProp.getString("setSizeValue").split(",");
            Thread.sleep(1000);
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(Integer.parseInt(sizeValue[0]), Integer.parseInt(sizeValue[1])));
        }
        return driver;
    }

    private static ChromeDriver getChromeDriver(){

        DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
        //capabilities
       /** Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);*/
        //prefs.put("profile.default_content_setting_values.cookies", 2);
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setExperimentalOption("prefs", prefs);
        /**
         * Timed out receiving message from renderer hatası çözümü NONE
         * chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
         */
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-plugins");
        //chromeOptions.addArguments("--disable-local-storage");
       // chromeOptions.addArguments("--disable-automation");
        //chromeOptions.setExperimentalOption("useAutomationExtension", false);
        //chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation" , "load-extension"));
        //chromeOptions.addArguments("disable-extensions");
        //chromeOptions.addArguments("--test-type");
        //chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--disable-gpu");
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("window-size=800,600");
        chromeOptions.setExperimentalOption("w3c",false);
        //chromeOptions.setExperimentalOption("profile.default_content_setting_values.cookies", "2");
       // chromeOptions.addArguments("--start-maximized");
       // chromeOptions.addArguments("--start-fullscreen");
        // options
        chromeOptions.merge(capabilities);
        return new ChromeDriver(chromeOptions);
    }

    private static FirefoxDriver getFirefoxDriver(){

        DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
       // capabilities.setCapability("marionette",true);
       // capabilities.setCapability("browser.privatebrowsing.autostart", true);
        //capabilities
       // ProfilesIni profile = new ProfilesIni();
        //FirefoxProfile testprofile = profile.getProfile("default");
        //capabilities.setCapability(FirefoxDriver.PROFILE, testprofile);
       /** FirefoxProfile ffprofile = new FirefoxProfile();
        ffprofile.setPreference("dom.webnotifications.enabled", false);*/
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        if(Boolean.parseBoolean(DriverCreater.ConfigurationProp.getString("firefoxZoomCondition"))
        && DriverCreater.ConfigurationProp.getString("firefoxZoomPlatform").contains(DriverCreater.osName)) {
            firefoxProfile.setPreference("layout.css.devPixelsPerPx",
                    DriverCreater.ConfigurationProp.getString("firefoxZoomSize"));
        }
       // firefoxProfile.setPreference("network.cookie.cookieBehavior",2);
        firefoxProfile.setPreference("dom.webnotifications.enabled", false);
        firefoxOptions.setProfile(firefoxProfile);
        // firefoxProfile.setPreference("dom.disable_beforeunload", true);
        // firefoxProfile.setPreference("dom.push.enabled", false);
        //firefoxOptions.setProfile(new FirefoxProfile());
        //firefoxOptions.addArguments("-private");
        //firefoxOptions.addPreference("dom.push.enabled", false);
        //firefoxOptions.addPreference("dom.webnotifications.enabled", false);
       // firefoxOptions.addPreference("dom.disable_beforeunload", true);
        //firefoxOptions.addPreference("browser.privatebrowsing.autostart", true);
        //firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
        // options
       /** FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("dom.webnotifications.enabled", false);
        firefoxProfile.setPreference("dom.push.enabled", false);
        firefoxProfile.setPreference("dom.disable_beforeunload", true);
        firefoxProfile.setPreference("extensions.firebug.onByDefault", true);
        firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
        //firefoxProfile.setPreference("browser.startup.homepage", "https://www.google.com/tr");*/

        firefoxOptions.merge(capabilities);
        return new FirefoxDriver(firefoxOptions);
    }

    private static SafariDriver getSafariDriver(){

        DesiredCapabilities capabilities = new DesiredCapabilities().safari();
        //capabilities
        //capabilities.setCapability("browserstack.safari.enablePopups", "false");
        SafariOptions safariOptions = new SafariOptions();
        //safariOptions.setCapability("safari.cleanSession", true);
        //safariOptions.setUseTechnologyPreview(true);
        // options
        safariOptions.merge(capabilities);
        return new SafariDriver(safariOptions);
    }

    private static EdgeDriver getEdgeDriver(){

        DesiredCapabilities capabilities = new DesiredCapabilities().edge();
        //capabilities.setCapability(CapabilityType.SUPPORTS_WEB_STORAGE,false);
        //capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS,false);
        /**capabilities.setCapability("locationContextEnabled",false);
        capabilities.setCapability("applicationCacheEnabled",false);
        capabilities.setCapability("webStorageEnabled",false);
        capabilities.setCapability("nativeEvents",false);*/
       // capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //capabilities
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("--disable-local-storage");
        //chromeOptions.addArguments("disable-extensions");
        chromeOptions.setExperimentalOption("w3c",false);
        chromeOptions.setBinary(DriverCreater.ConfigurationProp.getString("edgeLocation"));
        //"C:\\Windows\\SystemApps\\Microsoft.MicrosoftEdge_8wekyb3d8bbwe/MicrosoftEdge.exe");
        EdgeOptions edgeOptions = new EdgeOptions().merge(chromeOptions);
        //firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
        // options
        edgeOptions.merge(capabilities);
        return new EdgeDriver(edgeOptions);
    }

    /**private static InternetExplorerDriver getieDriver(){

        DesiredCapabilities capabilities = new DesiredCapabilities().internetExplorer();
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability("ignoreProtectedModeSettings",1);
        capabilities.setCapability("nativeEvents",false);
        //capabilities.setCapability("requireWindowFocus","true");
       // capabilities.setCapability("browserstack.ie.enablePopups", "false");
       // capabilities.setCapability("webStorageEnabled",false);
        //capabilities.setCapability("applicationCacheEnabled",false);
       //capabilities.setCapability("initialBrowserUrl", "");
        //capabilities.internetExplorer().setCapability("silent", true);
        capabilities.setCapability("locationContextEnabled",false);
        capabilities.setCapability("applicationCacheEnabled",false);
        capabilities.setCapability("webStorageEnabled",false);
        capabilities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
        capabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
        //capabilities.setCapability("IE.binary", "C:/Program Files (x86)/Internet Explorer/iexplore.exe");
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("requireWindowFocus", true);
        capabilities.setCapability("enablePersistentHover", false);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        //capabilities
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
       // internetExplorerOptions.disableNativeEvents();
       // internetExplorerOptions.destructivelyEnsureCleanSession();
        // options
        internetExplorerOptions.merge(capabilities);
        return new InternetExplorerDriver(internetExplorerOptions);
    }*/

     private static InternetExplorerDriver getieDriver(){
     DesiredCapabilities capabilities = new DesiredCapabilities().internetExplorer();
     capabilities.setCapability("ignoreZoomSetting", true);
     capabilities.setCapability("ignoreProtectedModeSettings",1);
     capabilities.setCapability("nativeEvents",false);
     //capabilities.setCapability("requireWindowFocus","true");
     capabilities.setCapability("requireWindowFocus", true);
     capabilities.setCapability("enablePersistentHover", false);
     capabilities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
     capabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
     capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
     //capabilities
     InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
     internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
     //firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
     // options
     internetExplorerOptions.merge(capabilities);
     return new InternetExplorerDriver(internetExplorerOptions);
     }

    private static OperaDriver getOperaDriver(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities
        OperaOptions operaOptions = new OperaOptions();
        //firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
        // options
        operaOptions.merge(capabilities);
        return new OperaDriver(operaOptions);
    }

}
