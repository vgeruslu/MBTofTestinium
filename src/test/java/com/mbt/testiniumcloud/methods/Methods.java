package com.mbt.testiniumcloud.methods;

import com.google.common.base.Splitter;
import com.mbt.testiniumcloud.driver.DriverCreater;
import com.mbt.testiniumcloud.helper.ElementHelper;
import com.mbt.testiniumcloud.helper.StoreHelper;
import com.mbt.testiniumcloud.model.ElementInfo;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Methods {

    private Logger logger = LoggerFactory.getLogger(getClass());
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JsMethods jsMethods;
    long waitElementTimeout;
    long pollingEveryValue;

    //@NamedArg("width")

    public Methods(){

        this.driver = DriverCreater.driver;
        setWaitElementTimeout();
        setPollingEveryValue();
        wait = setFluentWait(waitElementTimeout);
        jsMethods = new JsMethods(driver);
    }

    private void setWaitElementTimeout(){

        waitElementTimeout = DriverCreater.isTestinium ? Long.parseLong(DriverCreater.ConfigurationProp
                .getString("testiniumWaitElementTimeout")) : Long.parseLong(DriverCreater.ConfigurationProp
                .getString("localWaitElementTimeout"));
    }

    private void setPollingEveryValue(){

        pollingEveryValue = DriverCreater.isTestinium ? Long.parseLong(DriverCreater.ConfigurationProp
                .getString("testiniumPollingEveryMilliSecond")) : Long.parseLong(DriverCreater.ConfigurationProp
                .getString("localPollingEveryMilliSecond"));
    }

    public FluentWait<WebDriver> setFluentWait(long timeout){

        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingEveryValue))
                .ignoring(NoSuchElementException.class);
        return fluentWait;
    }

    public ElementInfo getElementInfo(String key){

        return StoreHelper.INSTANCE.findElementInfoByKey(key);
    }

    public void createElementInfo(String key, String value, String type){
        ElementInfo elementInfo = new ElementInfo();
        elementInfo.setKey(key);
        elementInfo.setValue(value);
        elementInfo.setType(type);
        StoreHelper.INSTANCE.addElementInfoByKey(key,elementInfo);
    }

    public By getBy(String key){

        logger.info("Element " + key + " değerinde tutuluyor");
        return ElementHelper.getElementInfoToBy(getElementInfo(key));
    }

    public Boolean waitUntilWithoutStaleElement(By by){

        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(findElement(by))));
    }

    public WebElement findElement(By by){

        logger.info("Element " + by.toString() + " by değerine sahip");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by){

        logger.info("Element " + by.toString() + " by değerine sahip");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void clickElement(By by){

        findElement(by).click();
        logger.info("Elemente tıklandı.");
    }

    public void clearElement(By by){

        findElement(by).clear();
    }

    public void clearElementWithBackSpace(By by){

        clearElement(by);
        waitByMilliSeconds(100);
        sendKeys(by,"a");
        waitByMilliSeconds(100);
        sendKeysWithKeys(by,"BACK_SPACE");
        waitByMilliSeconds(100);
    }

    public void sendKeys(By by, String text){

        findElement(by).sendKeys(text);
        logger.info("Elemente " + text + " texti yazıldı.");
    }

    public void sendKeysWithKeys(By by, String text){

        findElement(by).sendKeys(Keys.valueOf(text));
    }

    public void sendKeysWithNumpad(By by, String text){

        WebElement webElement = findElement(by);
        char[] textArray = text.toCharArray();
        for(int i = 0; i < textArray.length; i++){

            webElement.sendKeys(Keys.valueOf("NUMPAD" + String.valueOf(textArray[i])));
        }
        logger.info("Elemente " + text + " texti yazıldı.");
    }

    public String getText(By by){

        return findElement(by).getText();
    }

    public String getAttribute(By by, String attribute){

        return findElement(by).getAttribute(attribute);
    }

    public String getCssValue(By by, String attribute){

        return findElement(by).getCssValue(attribute);
    }

    public String getHexCssValue(By by, String attribute){

        return Color.fromString(getCssValue(by, attribute)).asHex();
    }

    /**
      DriverCreater TestMap
      */

    public Boolean containsKeyInTestMap(String key){

        return DriverCreater.TestMap.containsKey(key);
    }

    public Object getValueInTestMap(String key){

        return DriverCreater.TestMap.get(key);
    }

    public void putValueInTestMap(String key, Object object){

        DriverCreater.TestMap.put(key, object);
    }

    public String getPageSource(){

        return driver.getPageSource();
    }

    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }

    public List<String> listTabs(){
        List<String> list = new ArrayList<String>();
        for (String window: driver.getWindowHandles()){
            list.add(window);
        }
        return list;
    }

    public void switchTab(int tabNumber){

        driver.switchTo().window(listTabs().get(tabNumber));
    }

    public void switchFrame(int frameNumber){

        driver.switchTo().frame(frameNumber);
    }

    public void switchFrame(String frameName){

        driver.switchTo().frame(frameName);
    }

    public void switchFrameWithKey(By by){

        WebElement webElement = findElement(by);
        driver.switchTo().frame(webElement);
    }

    public void switchDefaultContent(){

        driver.switchTo().defaultContent();
    }

    public void navigateTo(String url){

        driver.navigate().to(url);
    }

    public void navigateToBack(){

        driver.navigate().back();
    }

    public void navigateToForward(){

        driver.navigate().forward();
    }

    public void navigateToRefresh(){

        driver.navigate().refresh();
    }

    public Select getSelect(By by){

        return new Select(findElement(by));
    }

    public void selectByValue(By by, String value){

        getSelect(by).selectByValue(value);
    }

    public void selectByVisibleText(By by, String text){

        getSelect(by).selectByVisibleText(text);
    }

    public void selectByIndex(By by, int index){

        getSelect(by).selectByIndex(index);
    }

    public List<WebElement> getSelectOptions(By by){

        return getSelect(by).getOptions();
    }

    public WebElement getFirstSelectedOption(By by){

        return getSelect(by).getFirstSelectedOption();
    }

    public List<WebElement> getAllSelectedOptions(By by){

        return getSelect(by).getAllSelectedOptions();
    }

    /**public int getSelectedOptionIndexWithJs(By by){

        return Integer.parseInt(String.valueOf(jsMethods
                .jsExecuteScript("arguments[0].selectedIndex", findElement(by))));
    }*/

    public String getValueElementWithJs(By by){

        return String.valueOf(jsMethods
                .jsExecuteScript("arguments[0].value", findElement(by)));
    }

    public void scrollToElementJs(By by){

        WebElement webElement = findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void scrollElementCenterWithJs(By by){

        scrollElementCenterWithJs(findElement(by));
    }

    public void scrollElementCenterWithJs(WebElement webElement){

        jsExecutor("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", webElement);
    }

    public void focusToElement(By by){

        WebElement webElement = findElement(by);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
        jse.executeScript("arguments[0].focus();", webElement);
    }

    public void jsExecutor(String script, Object... args){

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript(script,args);
    }

    public void jsExecutorWithKey(String script, By by){

        jsExecutor(script,findElement(by));
    }

    public void waitByMilliSeconds(long milliSeconds){

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitBySeconds(long seconds){

        logger.info(seconds + " saniye bekleniyor...");
        waitByMilliSeconds(seconds*1000);
    }

    public void checkElementClickable(By by){
        checkElementClickable(by,30);
    }

    public void checkElementClickable(By by, long timeout){

        Assert.assertTrue(by.toString() + " elementi tıklanabilir değil.", isElementClickable(by,timeout));
    }

    public boolean isElementClickable(By by, long timeout){

        logger.info("Element " + by.toString() + " by değerine sahip");
        try
        {
            setFluentWait(timeout).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }
        catch (Exception e)
        {
            logger.info("Element tıklanabilir değil");
            return false;
        }

    }

    public void checkElementVisible(By by){
        checkElementVisible(by,30);
    }

    public void checkElementVisible(By by, long timeout) {

        Assert.assertTrue(by.toString() + " elementi görüntülenemedi.",isElementVisible(by,timeout));
    }

    public boolean isElementVisible(By by, long timeout){

        try
        {
            setFluentWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }
        catch (Exception e)
        {
            logger.info("Element görünür değil");
            return false;
        }

    }

    public boolean isElementInVisible(By by, long timeout){

        try
        {
            setFluentWait(timeout).until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        }
        catch (Exception e)
        {
            logger.info("Element görünür");
            return false;
        }
    }

    public void returnParentWindow() {

        String winHandleBefore = DriverCreater.winHandleBefore;

        logger.info("default: " + winHandleBefore);
        List<String> windowList = new ArrayList<String>();
        for (String winHandle : driver.getWindowHandles()) {
            logger.info(winHandle);
            windowList.add(winHandle);
        }
        windowList.remove(winHandleBefore);

        for (int i = 0 ; i < windowList.size() ; i++){
            // Switch to new window opened
            driver.switchTo().window(windowList.get(i));
            waitBySeconds(1);
            // Perform the actions on new window
            //this will close new opened window
            driver.close();
            waitBySeconds(1);

        }

        //switch back to main window using this code
        if(windowList.size() > 0) {
            driver.switchTo().window(winHandleBefore);
            waitBySeconds(1);
        }
    }

    public void hoverElement(By by) {

        WebElement element = findElement(by);
        Actions hoverAction  = new Actions(driver);
        hoverAction.moveToElement(element).perform();
    }

    public void scrollElement(By by){

        Actions actions = new Actions(driver);
        WebElement webElement = findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
        actions.moveToElement(webElement).build().perform();
    }

    public void clickElementWithAction(By by){

        Actions actions = new Actions(driver);
        WebElement webElement = findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
        actions.moveToElement(webElement).click().build().perform();
    }

    public void doubleClickElementWithAction(By by){

        Actions actions = new Actions(driver);
        WebElement webElement = findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
        actions.moveToElement(webElement).doubleClick().build().perform();
    }
    public void selectAction(By by,int optionIndex){

        WebElement webElement = findElement(by);
        Select select = new Select(webElement);
        Actions builder = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
        builder.keyDown(Keys.CONTROL)
                .click(select.getOptions().get(optionIndex))
                .keyUp(Keys.CONTROL);
        builder.build().perform();
    }

    public boolean doesUrl(String url, int count, String condition){

        int againCount = 0;
        boolean isUrl = false;
        String takenUrl = "";
        logger.info("Beklenen url: " + url);
        while (!isUrl) {
            waitByMilliSeconds(400);
            if (againCount == count) {
                logger.info("Alınan url: " + takenUrl);
                return false;
            }
            takenUrl = driver.getCurrentUrl();
            if (takenUrl != null) {
                isUrl = conditionValueControl(url,takenUrl,condition);
            }
            againCount++;
        }
        logger.info("Alınan url: " + takenUrl);
        return true;
    }

    public String randomString(int stringLenght){

        Random random = new Random();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUWVXYZabcdefghijklmnopqrstuwvxyz0123456789".toCharArray();
        String stringRandom = "";
        for (int i = 0 ; i < stringLenght ; i++){

            stringRandom = stringRandom + String.valueOf(chars[random.nextInt(chars.length)]);
        }

        return stringRandom;
    }

    public boolean conditionValueControl(String expectedValue, String actualValue,String condition){

        boolean result = false;
        switch (condition){
            case "equal":
                result = actualValue.equals(expectedValue);
                break;
            case "contain":
                result = actualValue.contains(expectedValue);
                break;
            case "startWith":
                result = actualValue.startsWith(expectedValue);
                break;
            case "endWith":
                result = actualValue.endsWith(expectedValue);
                break;
            case "notEqual":
                result = !actualValue.equals(expectedValue);
                break;
            case "notContain":
                result = !actualValue.contains(expectedValue);
                break;
            case "notStartWith":
                result = !actualValue.startsWith(expectedValue);
                break;
            case "notEndWith":
                result = !actualValue.endsWith(expectedValue);
                break;
            default:
                Assert.fail("hatali durum: " + condition);
        }
        return result;
    }

    public void focusToElementJs(By by){

        WebElement webElement = findElement(by);
        waitByMilliSeconds(1000);
        jsMethods.jsExecuteScript("arguments[0].scrollIntoView();", webElement);
        waitByMilliSeconds(100);
        jsMethods.jsExecuteScript("arguments[0].focus();", webElement);
        waitByMilliSeconds(1000);
    }

    public void clickElementJs(By by){

        WebElement webElement = findElement(by);
        jsMethods.jsExecuteScript("arguments[0].click();",webElement);
    }

    public void focusAndClickElementJs(By by){

        WebElement webElement = findElement(by);
        jsMethods.jsExecuteScript("arguments[0].scrollIntoView();", webElement);
        waitByMilliSeconds(100);
        jsMethods.jsExecuteScript("arguments[0].focus();", webElement);
        waitByMilliSeconds(100);
        jsMethods.jsExecuteScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", webElement);
        waitByMilliSeconds(1000);
        jsMethods.jsExecuteScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", webElement);
        waitByMilliSeconds(100);
    }

    public boolean doesAttributeValue(By by, String attribute, String value, String condition, int count){

        int againCount = 0;
        boolean attributeCondition = false;
        String actualAttributeValue = "";
        logger.info("Beklenen değer: " + attribute + " " + condition + " " + value);
        while (!attributeCondition) {
            waitByMilliSeconds(400);
            if (againCount == count) {
                logger.info("Alınan değer: " + actualAttributeValue);
                return false;
            }
            actualAttributeValue = findElement(by).getAttribute(attribute).trim();
            if (actualAttributeValue != null) {
                attributeCondition = conditionValueControl(value, actualAttributeValue, condition);
            }
            againCount++;
        }
        logger.info("Alınan değer: " + actualAttributeValue);
        return true;
    }

    public void checkElementExistWithUrl(By by, int elementControlCount, int repeatCount, String url, String errorMessage) {

        logger.info("Element " + by.toString() + " by değerine sahip");
        boolean isElementVisible = false;
        int countAgain = 0;
        int elementCount;
        while (!isElementVisible) {
            waitByMilliSeconds(400);
            if (countAgain == repeatCount*elementControlCount) {
                Assert.fail(errorMessage);
                break;
            }
            elementCount = driver.findElements(by)
                    .size();
            if (elementCount != 0) {
                isElementVisible = true;
            }
            if(countAgain % elementControlCount == 0) {
                driver.navigate().to(url);
                doesUrl(url,15,"contain");
            }
            countAgain++;
        }
    }

    public void checkElementExist(By by, int loopCount){

        Assert.assertTrue("Element bulunamadı",doesElementExist(by,loopCount));
    }

    public boolean doesElementExist(By by, int loopCount){

        logger.info("Element " + by.toString() + " by değerine sahip");
        int countAgain = 0;
        int elementCount;
        while (true) {
            waitByMilliSeconds(400);
            if (countAgain == loopCount) {
                return false;
            }
            elementCount = driver.findElements(by).size();
            if (elementCount != 0) {
                return true;
            }
            countAgain++;
        }
    }

    public boolean doesElementNotExist(By by,int loopCount) {

        logger.info("Element " + by.toString() + " by değerine sahip");
        boolean isElementInvisible = false;
        int countAgain = 0;
        int elementCount;
        while (!isElementInvisible) {
            waitByMilliSeconds(400);
            if (countAgain == loopCount) {
                return false;
            }
            elementCount = driver.findElements(by).size();
            if (elementCount == 0) {
                isElementInvisible = true;
            }
            countAgain++;
        }
        return true;
    }

    public void closeAddsTab(int tabNumber, String urls, String bannedUrls) {

        waitBySeconds(2);
        List<String> windowList = new ArrayList<String>();
        for (String winHandle : driver.getWindowHandles()) {

            windowList.add(winHandle.trim());
        }

        logger.info("tabList: " + windowList.toString());

        for (int i = 0; i < windowList.size(); i++) {
            // Switch to new window opened
            try {
                driver.switchTo().window(windowList.get(i));
                waitBySeconds(1);
                String newUrl = driver.getCurrentUrl();
                if (!containsControlUrl(newUrl, urls) || containsControlUrl(newUrl, bannedUrls)) {
                    waitBySeconds(1);
                    // Perform the actions on new window
                    //this will close new opened window
                    driver.close();
                    waitBySeconds(1);
                }
            }catch (Exception e){
                logger.info("Tab bulunamadı");
            }
        }
        windowList = new ArrayList<String>();
        for (String winHandle : driver.getWindowHandles()) {
            windowList.add(winHandle.trim());
        }

        driver.switchTo().window(windowList.get(tabNumber));
    }

    public boolean containsControlUrl(String currentUrl, String urls){

        String[] urlArray = urls.split(",");
        boolean result=false;
        for(int i = 0; i < urlArray.length; i++){
            if(!urlArray[i].equals("")) {
                result = currentUrl.contains(urlArray[i]);
            }
            if(result){
                break;
            }
        }
        return result;
    }

    public By getByWithKeySetValue(String key, String value){

        ElementInfo elementInfo = getElementInfo(key);
        String getValue = elementInfo.getValue();
        String type = elementInfo.getType();
        logger.info(value);
        String[] arrayValue = Splitter.on("!!").splitToList(value).toArray(new String[0]);
        String newValue = String.format(getValue, arrayValue);
        return ElementHelper.getElementInfoToBy(newValue,type);
    }

    public void keyValueChangerMethod(String key, String value){

        ElementInfo elementInfo = getElementInfo(key);
        String getValue = elementInfo.getValue();
        String type = elementInfo.getType();
        ElementInfo elementInfo2 = getElementInfo(type + "KeyValue");
        String[] array = value.split("!!");
        String newValue = String.format(getValue, array);
        logger.info(Arrays.asList(array).toString());
        elementInfo2.setValue(newValue);
    }

    public void keyValueChangerMethodWithNewElement(String key, String newKey, String value){

        ElementInfo elementInfo = getElementInfo(key);
        String getValue = elementInfo.getValue();
        String type = elementInfo.getType();
        logger.info(value);
        String[] arrayValue = value.split("!!");
        String newValue = String.format(getValue, arrayValue);
        createElementInfo(newKey,newValue,type);
    }

    public void isFileDownloaded(LocalDateTime target, String fileNameStartsWith, String fileNameEndsWith) throws Exception{

        int loopCount = 200;
        // LocalDateTime target = LocalDate.of(2019, 2, 1).atTime(12,30,10);
        File dir;
        /**if(DriverCreater.isTestinium){
         dir = new File(System.getProperty("user.home"));
         }*/
        String slash = DriverCreater.osName.equals("WINDOWS") ? "\\" : "/";
        dir = new File(System.getProperty("user.home") + slash + "Downloads");
        File[] dirContents = dir.listFiles();
        File myFile = null;
        if (dirContents == null) {

            Assert.fail("Verilen dizin hatalı");
        }
        int countValue = 0;
        int seconds = 0;
        boolean isFileDownloaded = false;
        File file;

        while (true) {

            countValue++;
            dirContents = dir.listFiles();
            waitByMilliSeconds(100);
            if (countValue % 10 == 0) {
                seconds++;
                System.out.println(seconds);
            }
            for (int i = 0; i < dirContents.length; i++) {
                file = dirContents[i];
                if (!file.isDirectory() && file.getName().startsWith(fileNameStartsWith)
                        && file.getName().endsWith(fileNameEndsWith)) {

                    isFileDownloaded = getLocalDateTime(Files.readAttributes(file.toPath()
                            , BasicFileAttributes.class)).isAfter(target);
                    if (isFileDownloaded) {
                        myFile = file;
                        break;
                    }
                }
            }
            if (isFileDownloaded) {
                break;
            }
            if (countValue == loopCount) {
                break;
            }
        }
        if(myFile != null) {
            logger.info(myFile.getName());
            myFile.delete();
        }
        Assert.assertTrue("Dosya indirilemedi.", isFileDownloaded);
    }

    public String getTime(String simpleDateFormat){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat(simpleDateFormat);
        String currentTimeString = currentTime.format(calendar.getTime());
        return currentTimeString;
    }

    public LocalDateTime getLocalDateTime(BasicFileAttributes attributes){

        return attributes.creationTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public LocalDateTime getTarget(){

        String currentTimeString = getTime("yyyy:MM:dd:HH:mm:ss");
        String[] arrayStringTime = currentTimeString.split(":");
        LocalDateTime target = LocalDate.of(Integer.parseInt(arrayStringTime[0])
                , Integer.parseInt(arrayStringTime[1])
                , Integer.parseInt(arrayStringTime[2]))
                .atTime(Integer.parseInt(arrayStringTime[3])
                        , Integer.parseInt(arrayStringTime[4])
                        , Integer.parseInt(arrayStringTime[5]));

        waitByMilliSeconds(1000);
        return target;
    }

}
