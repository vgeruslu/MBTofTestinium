package com.mbt.testiniumcloud.methods;

import com.mbt.testiniumcloud.helper.ElementHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsMethods {

    WebDriver driver;

    public JsMethods(WebDriver driver){

        this.driver = driver;
    }

    public Object jsExecuteScript(String script,Object... args){

        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    public Object jsExecuteAsyncScript(String script,Object... args){

        return ((JavascriptExecutor) driver).executeAsyncScript(script, args);
    }

    public void getColor(String byValue, String selectorType){

        System.out.println(((JavascriptExecutor) driver).executeScript("return window.getComputedStyle("+
                getjsFindString(byValue,selectorType)+",':before').getPropertyValue('background-color');").toString());
    }

    public void javaScriptScroll(WebElement webElement){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void clickByCoordinateJs(int x, int y){

        ((JavascriptExecutor) driver).executeScript("document.elementFromPoint("+ x + "," + y +").click();");
    }

    public void javaScriptScrollElementCenter(WebElement webElement){

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
    }

    public void javaScriptScrollElementCenter(String byValue, String selectorType){

        if(selectorType.equals("xpath")){
            javaScriptScrollElementCenter(driver.findElement(getByWithByValue(byValue, selectorType)));
        }else
        ((JavascriptExecutor) driver).executeScript(
                getjsFindString(byValue,selectorType)+".scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})");
    }

    public void javaScriptClicker(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", element);
    }

    public void scrollPage(int scrollNumber){

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollBy(0," + scrollNumber + ")");

        //jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void javaScriptSelect(String byValue, String selectorType, int index){

        JavascriptExecutor jsdriver = (JavascriptExecutor) driver;

        String jsString = getjsFindString(byValue,selectorType);

        if(selectorType.equals("xpath")){

            WebElement webElement = driver.findElement(getByWithByValue(byValue, selectorType));
            jsdriver.executeScript(jsString + ".style.display='block';",webElement);
            jsdriver.executeScript(jsString + ".selectedIndex(\"" + index + "\")",webElement);
        }
        else {
            jsdriver.executeScript(jsString + ".style.display='block';");
            jsdriver.executeScript(jsString + ".selectedIndex(\"" + index + "\")");
        }
    }

    public void javaScriptSendKeys(String byValue,String selectorType,String values){

        JavascriptExecutor jsdriver = (JavascriptExecutor) driver;

        String jsString = getjsFindString(byValue,selectorType);

        if(selectorType.equals("xpath")){

            WebElement webElement = driver.findElement(getByWithByValue(byValue, selectorType));
            jsdriver.executeScript(jsString + ".value=\"" + values + "\"",webElement);
        }
        else {
            jsdriver.executeScript(jsString + ".value=\"" + values + "\"");
        }
    }

    public void jsImageLoading(WebElement ImageFile) throws InterruptedException{
        int waitCount = 100;
        int count = 0;
        while (true) {
            count++;
            Thread.sleep(100);
            Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].complete", ImageFile);

            // return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0
            if (ImagePresent) {
                break;
            }
            if (count == waitCount) {
                Assert.fail("Hata");
            }

        }
        //js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 4000);");
    }
    public void waitAjaxComplete() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }

    public void waitPageLoadComplete() {

        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> expectation = driver -> js
                .executeScript("return document.readyState", true).toString().equals("complete");
        try {
            webDriverWait.until(expectation);
        } catch (Throwable error) {
        }

    }

    public void waitForAngularLoad() {
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> expectation = driver -> js.executeScript(
                "return angular.element(document).injector().getElement('$http').pendingRequests.length === 0",
                true).toString().equals("true");
        try {
            webDriverWait.until(expectation);
        } catch (Throwable error) {

        }
    }

    public void waitJQueryComplete() {
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> expectation = driver -> js.executeScript(
                "return jQuery.active",
                true).toString().equals("0");
        try {
            js.executeScript("window.jQuery");
            webDriverWait.until(expectation);
        } catch (Exception e) {

        }
    }

    public void waitPageScrollingComplete() {
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> expectedCondition = driver -> {
            long currentPosition = (long) js.executeScript("var currentPosition=window.pageYOffset;");
            //waitByMs(150);
            return js
                    .executeScript(
                            "return Math.abs(arguments[0]-window.pageYOffset) == 0; ", currentPosition)
                    .toString()
                    .equals("true");
        };
        try {
            webDriverWait.until(expectedCondition);
        } catch (Exception e) {

        }
    }

    public void stopPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.stop();");

    }

    public String getjsFindString(String byValue, String selectorType){

        String jsString = "";
        switch (selectorType){

            case "id":
                jsString ="document.getElementById(\""+ byValue +"\")";
                break;

            case "name":
                jsString ="document.getElementsByName(\""+ byValue +"\")[0]";
                break;

            case "class":
                jsString ="document.getElementsByClassName(\""+ byValue +"\")[0]";
                break;

            case "css":
                jsString ="document.querySelector(\""+ byValue +"\")";
                break;
            //querySelectorAll
            case "xpath":
                jsString = "arguments[0]";
                break;

            default:
                Assert.fail("HATA");
                break;
        }

        return jsString;
    }

    public By getByWithByValue(String byValue, String selectorType){

       return ElementHelper.getElementInfoToBy(byValue, selectorType);
    }
}
