package com.mbt.testiniumcloud.driver;

public class SetBrowserForOS {

    private static String driverPath = "";
    private static String driverName = "";
    private static String webDriverName = "";
    private static String osDriverSuffix = "";
    private static String dir = "";
    private static String os = "";
    private static String browserName = "";

    public static void setDriverPath(String browser){

        os = Driver.osName;
        browserName = browser;
        System.out.println(os);

        setDriverName();
        if(!browserName.equals("safari")) {

            if(Boolean.parseBoolean(Driver.ConfigurationProp.getString("isDriverLocationProjectDir"))){
                driverPath = Driver.userDir
                        + Driver.ConfigurationProp.getString("driverFileLocation") + "/%s/%s";
            }else {
                driverPath = Driver.ConfigurationProp.getString("customDriverFileLocation") + "/%s/%s";
            }
            setOsDriverSuffix();
            dir = String.format(driverPath, browserName, webDriverName) + osDriverSuffix;

            if (os.equals("WINDOWS")) {
                dir = dir.replace("/", "\\");
            }
            System.out.println(dir);
            System.setProperty("webdriver." + driverName + ".driver", dir);
        }
    }

    private static void setDriverName(){

        switch (browserName) {
            case "chrome":
                driverName = "chrome";
                webDriverName = "chromedriver";
                break;
            case "firefox":
                driverName = "gecko";
                webDriverName = "geckodriver";
                break;
            case "opera":
                driverName = "opera";
                webDriverName = "operadriver";
                break;
            case "safari":
                if (!os.equals("MAC")) {
                    throw new NullPointerException("Safari Browser sadece Mac işletim sisteminde mevcut");
                }
                driverName = "safari";
                webDriverName = "safaridriver";
                break;
            case "edge":
                if (!os.equals("WINDOWS")) {
                    throw new NullPointerException("Edge Browser sadece Windows işletim sisteminde mevcut");
                }
                driverName = "edge";
                webDriverName = "MicrosoftWebDriver";
                // terminal
                //DISM.exe /Online /Add-Capability /CapabilityName:Microsoft.WebDriver~~~~0.0.1.0
                break;
            case "ie":
                if (!os.equals("WINDOWS")) {
                    throw new NullPointerException("Internet Explorer Browser sadece Windows işletim sisteminde mevcut");
                }
                driverName = "ie";
                webDriverName = "IEDriverServer";
                break;
            default:
                throw new NullPointerException("Seçilen Browser kullanılamıyor");
        }
    }

    private static void setOsDriverSuffix(){

        switch (os) {

            case "WINDOWS":
                osDriverSuffix = Driver.ConfigurationProp.getString("windowsDriverNameSuffix");
                break;
            case "MAC":
                if (driverName.equals("safari")) {
                    osDriverSuffix = "";
                }else {
                    osDriverSuffix = Driver.ConfigurationProp.getString("macDriverNameSuffix");
                }
                break;
            case "LINUX":
                osDriverSuffix = Driver.ConfigurationProp.getString("linuxDriverNameSuffix");
                break;
            default:
                throw new NullPointerException("İşletim Sistemi kodta tanımlı değil");
        }
    }

}
