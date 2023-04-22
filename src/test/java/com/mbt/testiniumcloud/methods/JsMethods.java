package com.mbt.testiniumcloud.methods;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mbt.testiniumcloud.helper.ElementHelper;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.fail;

public class JsMethods {

    WebDriver driver;
    JavascriptExecutor jsDriver;

    public JsMethods(WebDriver driver){

        this.driver = driver;
        jsDriver = (JavascriptExecutor) driver;
    }

    public Object jsExecuteScript(String script,Object... args){

        return jsDriver.executeScript(script, args);
    }

    public Object jsExecuteAsyncScript(String script,Object... args){

        return jsDriver.executeAsyncScript(script, args);
    }

    public void openNewTab(String url){

        String openNewTab = "window.open('" + url + "','_blank');";
        jsDriver.executeScript(openNewTab);
    }

    public WebElement findElement(String byValue, String selectorType){

        String jsString = getjsFindString(byValue, selectorType);
        String script = "return " + jsString + ";";
        return (WebElement) jsDriver.executeScript(script);
    }

    public String getBackgroundColor(WebElement webElement){

        return jsDriver.executeScript("return window.getComputedStyle(arguments[0],':before').getPropertyValue('background-color');",webElement).toString();
    }

    public ConcurrentHashMap<String, Object> getCssValueMap(WebElement webElement){

        ConcurrentHashMap<String, Object> cssValueMap = new ConcurrentHashMap<String, Object>();
        String script = "var s = '';" +
                "var o = getComputedStyle(arguments[0]);" +
                "for(var i = 0; i < o.length; i++){" +
                "s+=o[i] + ':' + o.getPropertyValue(o[i])+';';}" +
                "return s;";
        String cssValuesString = jsDriver.executeScript(script, webElement).toString();
        String[] cssValues = cssValuesString.trim().split(";");
        Arrays.stream(cssValues).parallel().forEach(value -> setCssValueMap(cssValueMap, value));
        return cssValueMap;
    }

    private void setCssValueMap(ConcurrentHashMap<String, Object> cssValueMap, String value){

        String[] values = value.trim().split(":");
        cssValueMap.put(values[0].trim(), values[1].trim());
    }

    //border-bottom-color background-color
    public Object getCssValue(WebElement webElement, String valueName){

        String script = "return getComputedStyle(arguments[0]).getPropertyValue('" + valueName + "');";
        return jsDriver.executeScript(script,webElement);
    }

    public ConcurrentHashMap<String, Object> getLocationValues(WebElement webElement){

        return getLocationValues(webElement,".getClientRects()[0];");
    }

    public ConcurrentHashMap<String, Object> getLocationValuesWithBounding(WebElement webElement){

        return getLocationValues(webElement,".getBoundingClientRect();");
    }

    // bottom, height, left, right, toJSON={}, top, width, x, y
    public ConcurrentHashMap<String, Object> getLocationValues(WebElement webElement, String clientRectText){

        ConcurrentHashMap<String, Object> locationValueMap = new ConcurrentHashMap<String, Object>();
        String script = "return " + "arguments[0]" + clientRectText;
        String locationValues = jsDriver.executeScript(script,webElement).toString();
        System.out.println(locationValues);
        Type elementType = new TypeToken<Set<Map.Entry<String, JsonElement>>>(){}.getType();
        Set<Map.Entry<String, JsonElement>> entries = new Gson().fromJson(locationValues, elementType);
        for (Map.Entry<String, JsonElement> entry: entries) {

            String value = entry.getValue().toString();
            locationValueMap.put(entry.getKey(), StringUtils
                    .isNumeric(value.replace(".","")) ? Double.parseDouble(value): value);
        }
        return locationValueMap;
    }

    public void scrollElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void scrollIntoViewIfNeeded(WebElement webElement){

        jsDriver.executeScript("arguments[0].scrollIntoViewIfNeeded();", webElement);
    }

    public void focusElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].focus();", webElement);
    }

    public void mouseOver(WebElement webElement){

        jsExecuteScript("var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj);", webElement);
    }

    public void mouseOut(WebElement webElement){

        jsExecuteScript("var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseout\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj);", webElement);
    }

    public void clickByCoordinate(int x, int y){

        jsDriver.executeScript("document.elementFromPoint("+ x + "," + y +").click();");
    }

    public void clickByWebElementCoordinate(WebElement webElement){

        jsDriver.executeScript("var element = arguments[0];" +
                "var box = element.getBoundingClientRect();\n" +
                "var clientX = box.left + (box.width / 2);\n" +
                "var clientY = box.top + (box.height / 2);" +
                "document.elementFromPoint(clientX,clientY).click();", webElement);
    }

    public void clickByWebElementCoordinate(WebElement webElement, int x, int y){

        jsDriver.executeScript("var element = arguments[0];" +
                "var box = element.getBoundingClientRect();\n" +
                "var clientX = box.left + ((box.width * " + x + ") / 100);\n" +
                "var clientY = box.top + ((box.height * " + y + ") / 100);" +
                "document.elementFromPoint(clientX,clientY).click();", webElement);
    }

    public void clickByElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].click();", webElement);
    }

    public Boolean isElementDisabled(WebElement webElement){

        return Boolean.valueOf(jsDriver.executeScript("return arguments[0].ariaDisabled;", webElement).toString());
    }

    public Boolean isElementExpanded(WebElement webElement){

        return Boolean.valueOf(jsDriver.executeScript("return arguments[0].ariaExpanded;", webElement).toString());
    }

    public void clickByElement(WebElement webElement, boolean notClickByCoordinate){

        if (notClickByCoordinate) {

            clickByElement(webElement);
        }else {
            clickByWebElementCoordinate(webElement);
        }
    }

    public void scrollElementCenter(WebElement webElement){

        jsDriver.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                webElement);
    }

    public void clickMouseEvent(WebElement webElement) {

        jsDriver.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", webElement);
    }

    public void scrollIntoView(WebElement webElement) {

        jsDriver.executeScript("window.scrollTo(" + webElement.getLocation().x +
                "," + webElement.getLocation().y + ")");

    }

    public void scrollPage(int scrollY){

        jsDriver.executeScript("window.scrollBy(0," + scrollY + ")");
    }

    private void selectedElementVisible(WebElement webElement){

        String script = "var evt = document.createEvent(\"HTMLEvents\");" +
                "evt.initEvent(\"change\", true, true);arguments[0].dispatchEvent(evt);";
        jsDriver.executeScript(script,webElement);
    }

    public void selectWithIndex(WebElement webElement, int index){

        String script = "arguments[0].selectedIndex=" + index + ";";
        jsDriver.executeScript(script,webElement);
        selectedElementVisible(webElement);
    }

    public void selectWithText(WebElement webElement, String optionText){

        String script = "var select = arguments[0];" +
                " for(var i = 0; i < select.options.length; i++){" +
                "if(select.options[i].text == '" + optionText + "')" +
                "{ select.options[i].selected = true; } }";
        jsDriver.executeScript(script, webElement);
        selectedElementVisible(webElement);
    }

    public void selectWithValue(WebElement webElement, String optionValue){

        String script = "var select = arguments[0];" +
                " for(var i = 0; i < select.options.length; i++){" +
                "if(select.options[i].value == '" + optionValue + "')" +
                "{ select.options[i].selected = true; } }";
        jsDriver.executeScript(script,webElement);
        selectedElementVisible(webElement);
    }

    public int getSelectedOptionIndex(WebElement webElement){

        String script = "return arguments[0].selectedIndex;";
        return Integer.parseInt(jsDriver.executeScript(script,webElement).toString());
    }

    public String getSelectedOptionText(WebElement webElement){

        int index = getSelectedOptionIndex(webElement);
        String script = "return arguments[0].options[" + index + "].text;";
        return jsDriver.executeScript(script,webElement).toString();
    }

    public String getSelectedOptionValue(WebElement webElement){

        int index = getSelectedOptionIndex(webElement);
        String script = "return arguments[0].options[" + index + "].value;";
        return jsDriver.executeScript(script,webElement).toString();
    }

    public String getText(WebElement webElement, String textType){

        String condition = "";
        switch (textType){

            case "textContent":
                condition = ".textContent;";
                break;
            case "innerText":
                condition = ".innerText;";
                break;
            case "outerText":
                condition = ".outerText;";
                break;
            default:
                fail("");
        }

        String script = "return arguments[0]" + condition;
        return jsDriver.executeScript(script,webElement).toString();
    }

    public Object getAttribute(WebElement webElement, String attribute){

        String script = "return arguments[0].getAttribute(\"" + attribute + "\");";
        return jsDriver.executeScript(script,webElement);
    }

    public Object getValue(WebElement webElement){

        String script = "return arguments[0].value;";
        return jsDriver.executeScript(script,webElement);
    }

    public void setValue(WebElement webElement, String text, boolean isValueString){

        String script = "arguments[0].value = " + (isValueString ? "'arguments[1]'": "arguments[1]");
        jsDriver.executeScript(script, webElement, text);
    }

    public Object validationMessage(WebElement webElement){

        String script = "return arguments[0].validationMessage;";
        return jsDriver.executeScript(script,webElement);
    }

    public Object checkValidity(WebElement webElement){

        String script = "return arguments[0].checkValidity();";
        return jsDriver.executeScript(script,webElement);
    }

    public Object validityValid(WebElement webElement){

        String script = "return arguments[0].validity.valid;";
        return jsDriver.executeScript(script,webElement);
    }

    public boolean jsImageLoading(WebElement ImageElement, int count) {

        int actualCount = 0;
        while (true) {
            actualCount++;
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            boolean ImagePresent = (Boolean) jsDriver
                    .executeScript("return arguments[0].complete", ImageElement);
            // return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0
            if (ImagePresent) {
                break;
            }
            if (actualCount == count) {
                return false;
            }

        }
        return true;
    }

    public void waitPageLoadComplete(FluentWait<WebDriver> fluentWait) {

        ExpectedCondition<Boolean> expectation = driver -> jsDriver
                .executeScript("return document.readyState;").toString().equals("complete");
        try {
            fluentWait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public void waitForAngularLoad(FluentWait<WebDriver> fluentWait) {

        ExpectedCondition<Boolean> expectation = driver -> jsDriver.executeScript(
                "return angular.element(document).injector().getElement('$http').pendingRequests.length === 0")
                .toString().equals("true");
        try {
            fluentWait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public void waitJQueryComplete(FluentWait<WebDriver> fluentWait) {

        ExpectedCondition<Boolean> expectation = driver -> jsDriver.executeScript(
                "return jQuery.active").toString().equals("0");
        try {
            jsDriver.executeScript("window.jQuery");
            fluentWait.until(expectation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitPageScrollingComplete(FluentWait<WebDriver> fluentWait) {

        ExpectedCondition<Boolean> expectedCondition = driver -> {
            long currentPosition = (long) jsDriver.executeScript("return window.pageYOffset;");
            //waitByMs(150);
            return jsDriver
                    .executeScript(
                            "return Math.abs(arguments[0]-window.pageYOffset) == 0; ", currentPosition)
                    .toString()
                    .equals("true");
        };
        try {
            fluentWait.until(expectedCondition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopPageLoad() {

        jsDriver.executeScript("window.stop();");
    }

    public void highlightElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].setAttribute('style','background: green; border: 5px solid red;');", webElement);
        //jsDriver.executeScript("arguments[0].style.border='3px solid red';", webElement);
    }

    public String getjsFindString(String byValue, String selectorType){

        String jsString = "";
        byValue = byValue.replace("\"","\\\"");
        switch (selectorType){

            case "id":
                jsString ="document.getElementById(\""+ byValue +"\")";
                break;

            case "name":
                jsString ="document.getElementsByName(\""+ byValue +"\")[0]";
                break;

            case "tagName":
                jsString = "document.getElementsByTagName(\"" + byValue + "\")[0]";
                break;

            case "class":
                jsString ="document.getElementsByClassName(\""+ byValue +"\")[0]";
                break;

            case "css":
                jsString ="document.querySelector(\""+ byValue +"\")";
                break;

            case "xpath":
                jsString = "document.evaluate(\"" + byValue
                        + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue";
                break;

            default:
                fail("HATA");
                break;
        }

        return jsString;
    }

    public String getjsFindsString(String byValue, String selectorType){

        String jsString = "";
        byValue = byValue.replace("\"","\\\"");
        switch (selectorType){

            case "id":
                jsString = "return document.querySelectorAll(\"#" + byValue + "\");";
                break;

            case "name":
                jsString = "return document.getElementsByName(\"" + byValue + "\");";
                break;

            case "tagName":
                jsString = "return document.getElementsByTagName(\"" + byValue + "\");";
                break;

            case "class":
                jsString = "return document.getElementsByClassName(\"" + byValue + "\");";
                break;

            case "css":
                jsString = "return document.querySelectorAll(\"" + byValue + "\");";
                break;

            case "xpath":
                jsString = "var result = [];\n" +
                        "var nodesSnapshot = document.evaluate(\"" + byValue + "\",\n" +
                        "document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null );\n" +
                        "for ( var i=0 ; i < nodesSnapshot.snapshotLength; i++ ){\n" +
                        "result.push( nodesSnapshot.snapshotItem(i) );\n" +
                        "}\n" +
                        "return result;";
                break;

            default:
                fail("HATA");
        }

        return jsString;
    }

    @SuppressWarnings("unchecked")
    public List<WebElement> findElements(String byValue, String selectorType){

        return (List<WebElement>) jsDriver.executeScript(getjsFindsString(byValue, selectorType));
    }

    public void wheelElement(WebElement element, int deltaY, int offsetX, int offsetY) {
        try{
            String script = "var element = arguments[0];"
                    +"var deltaY = arguments[1];"
                    +"var box = element.getBoundingClientRect();"
                    +"var clientX = box.left + (arguments[2] || box.width / 2);"
                    +"var clientY = box.top + (arguments[3] || box.height / 2);"
                    +"var target = element.ownerDocument.elementFromPoint(clientX, clientY);"
                    +"for (var e = target; e; e = e.parentElement) {"
                    +"if (e === element) {"
                    +"target.dispatchEvent(new MouseEvent('mouseover', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
                    +"target.dispatchEvent(new MouseEvent('mousemove', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
                    +"target.dispatchEvent(new WheelEvent('mousewheel', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY, deltaY: deltaY}));"
                    +"return;"
                    +"}"
                    +"}";

            WebElement parent = (WebElement) jsDriver.executeScript("return arguments[0].parentNode;", element);
            jsDriver.executeScript(script, parent, deltaY, offsetX, offsetY);
        } catch(WebDriverException e) {
            System.out.println("Exception caught in Catch block");
        }
    }

    public void wheelElementSimple(WebElement element, int deltaY, int offsetX, int offsetY){

        try{
            String script = "var element = arguments[0];"
                    +"var deltaY = arguments[1];"
                    +"var box = element.getBoundingClientRect();"
                    +"var clientX = box.left + (arguments[2] || box.width / 2);"
                    +"var clientY = box.top + (arguments[3] || box.height / 2);"
                    +"element.dispatchEvent(new MouseEvent('mouseover', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
                    +"element.dispatchEvent(new MouseEvent('mousemove', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
                    +"element.dispatchEvent(new WheelEvent('mousewheel', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY, deltaY: deltaY}));";

            jsDriver.executeScript(script, element, deltaY, offsetX, offsetY);
        } catch(WebDriverException e) {
            System.out.println("Exception caught in Catch block");
        }
    }

    public By getByWithByValue(String byValue, String selectorType){

        return ElementHelper.getElementInfoToBy(byValue, selectorType);
    }

    public String getJsCondition(String condition, String value){

        String jsCondition = "";
        switch (condition){
            //not control dataType "1" == 1 true
            case "equal":
                jsCondition = " == '" + value + "'";
                break;
            //control dataType ===
            case "equals":
                jsCondition = " === '" + value + "'";
                break;
            case "contain":
                jsCondition = ".includes('" + value + "')";
                break;
            case "startWith":
                jsCondition = ".startsWith('" + value + "')";
                break;
            case "endWith":
                jsCondition = ".endsWith('" + value + "')";
                break;
            case "notEqual":
                jsCondition = " != '" + value + "'";
                break;
            case "notEquals":
                jsCondition = " !== '" + value + "'";
                break;
            default:
                fail("HATA");
        }
        return jsCondition;
    }
}
