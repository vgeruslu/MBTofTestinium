package com.mbt.testiniumcloud.driver;

public class SetBrowserForOS {

    private static String driverPath = "";
    private static String driverName = "";
    private static String webDriverName = "";
    private static String osDriverType = "";
    private static String dir = "";
    private static String os = "";
    private static String browserName = "";

    public static void setDriverPath(String browser){

        os = DriverCreater.osName;
        browserName = browser;
        System.out.println(os);

        boolean isDriverLocationInProperty = DriverCreater.ConfigurationProp
                .getString("isDriverLocationInProperty").equalsIgnoreCase("true");

        boolean safariDriverLocationInProject = DriverCreater.ConfigurationProp
                .getString("safariDriverLocationInProject").equalsIgnoreCase("false");

        if((browserName.equals("safari") && safariDriverLocationInProject)
                || (!browserName.equals("safari") && isDriverLocationInProperty)) {
            System.out.println(browserName + " configurationproperties");
            setDirInProperties();
        }else {

            setDriverName();
            driverPath = "drivers/%s/%s";
            setOsDriverType();
            driverPath = String.format(driverPath, browser, webDriverName) + osDriverType;
            dir = "/" + driverPath;

            if (os.equals("WINDOWS")) {
                dir = dir.replace("/", "\\");
            }

            dir = System.getProperty("user.dir") + dir;
        }

        System.out.println(dir);
        System.setProperty("webdriver." + driverName + ".driver", dir);
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

    private static void setOsDriverType(){

        switch (os) {

            case "WINDOWS":
                osDriverType = ".exe";
                break;
            case "MAC":
                if (driverName.equals("safari")) {
                    osDriverType = "";
                }else {
                    osDriverType = "mac";
                }
                break;
            case "LINUX":
                osDriverType = "linux";
                break;
            default:
                throw new NullPointerException("İşletim Sistemi kodta tanımlı değil");
        }
    }

    private static void setDirInProperties(){

        switch (browserName) {
            case "chrome":
                driverName = "chrome";
                dir = DriverCreater.ConfigurationProp.getString("driverLocation");
                break;
            case "firefox":
                driverName = "gecko";
                dir = DriverCreater.ConfigurationProp.getString("driverLocation");
                break;
            case "opera":
                driverName = "opera";
                dir = DriverCreater.ConfigurationProp.getString("driverLocation");
                break;
            case "safari":
                if (!os.equals("MAC")) {
                    throw new NullPointerException("Safari Browser sadece Mac işletim sisteminde mevcut");
                }
                driverName = "safari";
                dir = DriverCreater.ConfigurationProp.getString("safariDriverLocation");
                break;
            case "edge":
                if (!os.equals("WINDOWS")) {
                    throw new NullPointerException("Edge Browser sadece Windows işletim sisteminde mevcut");
                }
                driverName = "edge";
                dir = DriverCreater.ConfigurationProp.getString("driverLocation");
                break;
            case "ie":
                if (!os.equals("WINDOWS")) {
                    throw new NullPointerException("Internet Explorer sadece Windows işletim sisteminde mevcut");
                }
                driverName = "ie";
                dir = DriverCreater.ConfigurationProp.getString("driverLocation");
                break;
            default:
                throw new NullPointerException("Seçilen Browser kullanılamıyor");
        }
    }

}
