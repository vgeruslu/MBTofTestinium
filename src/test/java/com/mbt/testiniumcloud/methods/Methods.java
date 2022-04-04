package com.mbt.testiniumcloud.methods;

import com.google.common.base.Splitter;
import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.helper.ElementHelper;
import com.mbt.testiniumcloud.helper.StoreHelper;
import com.mbt.testiniumcloud.model.ElementInfo;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class Methods {

    private static final Logger logger = LogManager.getLogger(Methods.class);
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JsMethods jsMethods;
    ActionMethods actionMethods;
    MethodsUtil methodsUtil;
    long waitElementTimeout;
    long pollingEveryValue;

    public Methods(){

        this.driver = Driver.driver;
        waitElementTimeout = Long.parseLong(Driver.ConfigurationProp.getString("localWaitElementTimeout"));
        pollingEveryValue = Long.parseLong(Driver.ConfigurationProp.getString("localPollingEveryMilliSecond"));
        wait = setFluentWait(waitElementTimeout);
        jsMethods = new JsMethods(driver);
        actionMethods = new ActionMethods(driver);
        methodsUtil = new MethodsUtil();
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

    public String getElementInfoJsonFileName(int i){

        return i == -1 ? "Element createElementInfo metoduyla oluşturulmuş" : StoreHelper.INSTANCE.getFileName(i);
    }

    public boolean containsKeyInElementInfoMap(String key){

        return StoreHelper.INSTANCE.containsKey(key);
    }

    public void duplicateKeyControlInElementInfoMap(boolean printAllData){

        StoreHelper.INSTANCE.duplicateKeyControl(printAllData);
    }

    public void createElementInfo(String key, String value, String type){

        ElementInfo elementInfo = new ElementInfo();
        elementInfo.setKey(key);
        elementInfo.setValue(value);
        elementInfo.setType(type);
        elementInfo.setFileNameIndex(-1);
        StoreHelper.INSTANCE.addElementInfoByKey(key,elementInfo);
    }

    public WebDriver getDriver(){

        return driver;
    }

    public By getBy(String key){

        ElementInfo elementInfo = getElementInfo(key);
        By by = ElementHelper.getElementInfoToBy(elementInfo);
        logger.info(key + " elementi " + by.toString() + " by değerine sahip." + " Json dosya yolu: "
                + getElementInfoJsonFileName(elementInfo.getFileNameIndex()));
        return by;
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

    public List<String> getByValueAndSelectorType(By by){

        List<String> list = new ArrayList<String>();
        String stringBy = by.toString();
        Matcher matcher = Pattern.compile("[By\\.A-Za-z]+: ").matcher(stringBy);
        matcher.find();
        String t = matcher.group();
        String type = t.replace(": ","").trim();
        list.add(stringBy.replaceFirst(t,"").trim());
        list.add(methodsUtil.getSelectorTypeName(type.replace("By.","").trim()));
        return list;
    }

    public Object jsExecuteScript(String script, boolean isScriptAsync, Object... args){

        return isScriptAsync ? jsMethods.jsExecuteAsyncScript(script, args) : jsMethods.jsExecuteScript(script, args);
    }

    public JsMethods getJsMethods(){

        return jsMethods;
    }

    public ActionMethods getActionMethods(){

        return actionMethods;
    }

    public Boolean isElementEnabled(By by, int timeout){

        for (int i = 0; i < 4*timeout; i++) {
            try {
                WebElement element = driver.findElement(by);
                if (element.isDisplayed() && element.isEnabled()) {
                    return true;
                }
            }catch (Exception e){
            }
            methodsUtil.waitByMilliSeconds(250);
        }
        return false;
    }

    public void clickElementForStaleElement(By by){

        try {
            clickElement(by);
        } catch (StaleElementReferenceException e) {
            methodsUtil.waitByMilliSeconds(400);
            waitUntilWithoutStaleElement(by,30);
            clickElement(by);
        }
    }
    
    public void waitUntilWithoutStaleElement(By by, long timeout){

        setFluentWait(timeout).until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(findElement(by))));
    }

    public WebElement findElement(By by){

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement findElementWithoutWait(By by){

        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by){

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public List<WebElement> findElementsWithOutError(By by){

        List<WebElement> list = new ArrayList<>();
        try {
            list.addAll(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<WebElement> findElementsWithoutWait(By by){

        return driver.findElements(by);
    }

    public void clickElement(By by){

        findElement(by).click();
        logger.info("Elemente tıklandı.");
    }

    public void clearElement(By by){

        findElement(by).clear();
        logger.info("Elementin text alanı temizlendi.");
    }

    public void clearElementWithBackSpace(By by, String value){

        int count;
        String attribute = "";
        if (value.startsWith("attribute_")){
            attribute = value.replaceFirst("attribute_","");
            value = "attribute";
        }
        switch (value) {
            case "valueJs":
                count = getValueJs(by,"3").toCharArray().length;
                break;
            case "text":
                count = getText(by).toCharArray().length;
                break;
            case "attribute":
                count = getAttribute(by, attribute).toCharArray().length;
                break;
            default:
                clearElement(by);
                methodsUtil.waitByMilliSeconds(100);
                sendKeys(by, value.substring(0, 1)); // There was no other way
                methodsUtil.waitByMilliSeconds(100);
                count = 1;
        }
        WebElement webElement = findElement(by);
        for (int i = 0; i < count; i++){
            webElement.sendKeys(Keys.valueOf("BACK_SPACE"));
            //methodsUtil.waitByMilliSeconds(20);
        }
    }

    public Dimension getSize(By by){

        return findElement(by).getSize();
    }

    public Point getLocation(By by){

        return findElement(by).getLocation();
    }

    public Rectangle getRect(By by){

        return findElement(by).getRect();
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

    public void sendKeysJs(By by, String text, String type){

        jsMethods.sendKeys(findElementForJs(by,type), text);
        logger.info("Elemente " + text + " texti yazıldı.");
    }

    public String getText(By by){

        return findElement(by).getText();
    }

    public String getTextContentJs(By by, String type){

        return jsMethods.getText(findElementForJs(by,type),"textContent");
    }

    public String getInnerTextJs(By by, String type){

        return jsMethods.getText(findElementForJs(by,type),"innerText");
    }

    public String getOuterTextJs(By by, String type){

        return jsMethods.getText(findElementForJs(by,type),"outerText");
    }

    public void mouseOverJs(By by, String type){

        jsMethods.mouseOver(findElementForJs(by,type));
        logger.info("mouseover " + by);
    }

    public void mouseOutJs(By by, String type){

        jsMethods.mouseOut(findElementForJs(by,type));
        logger.info("mouseout " + by);
    }

    public String getAttribute(By by, String attribute){

        return findElement(by).getAttribute(attribute);
    }

    public String getAttributeJs(By by, String attribute, String type){

        return jsMethods.getAttribute(findElementForJs(by,type), attribute);
    }

    public String getValueJs(By by, String type){

        return jsMethods.getValue(findElementForJs(by,type));
    }

    public String getCssValue(By by, String attribute){

        return findElement(by).getCssValue(attribute);
    }

    public String getHexCssValue(By by, String attribute){

        return Color.fromString(getCssValue(by, attribute)).asHex();
    }

    public String getCssValueJs(By by, String attribute, String type){

        return jsMethods.getCssValue(findElementForJs(by,type), attribute);
    }

    public String getHexCssValueJs(By by, String attribute, String type){

        return Color.fromString(getCssValueJs(by, attribute, type)).asHex();
    }

    public String getPageSource(){

        return driver.getPageSource();
    }

    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }

    public Point getDriverPosition(){

        return driver.manage().window().getPosition();
    }

    public Dimension getDriverSize(){

        return driver.manage().window().getSize();
    }

    public void openNewTabJs(String url){

        jsMethods.openNewTab(url);
        logger.info("Yeni tab açılıyor..." + " Url: " + url);
    }

    public void acceptAlert(){

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public List<String> listTabs(){
        
        List<String> list = new ArrayList<String>();
        for (String window: driver.getWindowHandles()){
            list.add(window);
        }
        return list;
    }

    public void close(){

        driver.close();
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

    public void switchParentFrame(){

        driver.switchTo().parentFrame();
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

    public Set<Cookie> getCookies(){

        return driver.manage().getCookies();
    }

    public void deleteAllCookies(){

        driver.manage().deleteAllCookies();
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

    public void selectItemByIndex(By by, int index){
        WebElement element = findElement(by);
        actionMethods.selectItemByIndex(element, index);
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

    public void selectByIndexJs(By by, int index, String type){

        jsMethods.selectWithIndex(findElementForJs(by,type), index);
    }

    public void selectByTextJs(By by, String text, String type){

        jsMethods.selectWithText(findElementForJs(by,type), text);
    }

    public void selectByValueJs(By by, String value, String type){

        jsMethods.selectWithValue(findElementForJs(by,type), value);
    }

    public int getSelectedOptionIndexJs(By by, String type){

        return jsMethods.getSelectedOptionIndex(findElementForJs(by,type));
    }

    public String getSelectedOptionTextJs(By by, String type){

        return jsMethods.getSelectedOptionText(findElementForJs(by,type));
    }

    public String getSelectedOptionValueJs(By by, String type){

        return jsMethods.getSelectedOptionValue(findElementForJs(by,type));
    }

    public void scrollElementJs(By by, String type){

        jsMethods.scrollElement(findElementForJs(by,type));
    }

    public void scrollIntoViewIfNeededJs(By by, String type){

        jsMethods.scrollIntoViewIfNeeded(findElementForJs(by,type));
    }

    public void scrollElementCenterJs(By by,String type){

        jsMethods.scrollElementCenter(findElementForJs(by,type));
    }

    public void focusElementJs(By by){

        WebElement webElement = findElementForJs(by,"1");
        jsMethods.scrollElement(webElement);
        jsMethods.focusElement(webElement);
    }

    public void jsExecutorWithBy(String script, By by){

        jsMethods.jsExecuteScript(script, findElementForJs(by,"3"));
    }

    public boolean isElementClickable(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.elementToBeClickable(by));
            logger.info("true");
            return true;
        }
        catch (Exception e) {
            logger.info("false" + " " + e.getMessage());
            return false;
        }
    }

    public void checkElementClickable(By by, long timeout){

        assertTrue(isElementClickable(by, timeout),by.toString() + " elementi tıklanabilir değil.");
    }
    public void checkElementNotClickable(By by, long timeout){

        assertFalse(isElementClickable(by, timeout),by.toString() + " elementi tıklanabilir.");
    }

    public void checkElementClickable(By by){
        checkElementClickable(by,30);
    }

    public boolean isElementVisible(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("true");
            return true;
        } catch (Exception e) {
            logger.info("false" + " " + e.getMessage());
            return false;
        }
    }

    public void checkElementVisible(By by, long timeout) {

        assertTrue(isElementVisible(by, timeout), by.toString() + " elementi görüntülenemedi.");
    }

    public void checkElementVisible(By by){
        checkElementVisible(by,30);
    }

    public boolean isElementInVisible(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.invisibilityOfElementLocated(by));
            logger.info("true");
            return true;
        } catch (Exception e) {
            logger.info("false" + " " + e.getMessage());
            return false;
        }
    }

    public void checkElementInVisible(By by, long timeout) {

        assertTrue(isElementInVisible(by, timeout),by.toString() + " elementi görünür");
    }

    public void checkElementInVisible(By by) {

        checkElementInVisible(by,30);
    }

    public boolean isElementLocated(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.presenceOfElementLocated(by));
            logger.info("true");
            return true;
        } catch (Exception e) {
            logger.info("false" + " " + e.getMessage());
            return false;
        }
    }

    public void checkElementLocated(By by, long timeout) {

        assertTrue(isElementLocated(by, timeout),by.toString() + " element located error.");
    }

    public void checkElementLocated(By by){
        checkElementLocated(by,30);
    }

    public void hoverElementAction(By by, boolean isScrollElement) {

        WebElement webElement = findElementForJs(by,"1");
        if(isScrollElement){
            jsMethods.scrollElement(webElement);
        }
        actionMethods.hoverElement(webElement);
    }

    public void moveAndClickElement(By by, boolean isScrollElement) {

        WebElement webElement = findElementForJs(by,"1");
        if(isScrollElement){
            jsMethods.scrollElement(webElement);
        }
        actionMethods.moveAndClickElement(webElement);
    }

    public void clickElementWithAction(By by, boolean isScrollElement){

        WebElement webElement = findElementForJs(by,"1");
        if(isScrollElement){
            jsMethods.scrollElement(webElement);
        }
        actionMethods.clickElement(webElement);
    }

    public void doubleClickElementWithAction(By by, boolean isScrollElement){

        WebElement webElement = findElementForJs(by,"1");
        if(isScrollElement){
            jsMethods.scrollElement(webElement);
        }
        actionMethods.doubleClickElement(webElement);
    }

    public void selectAction(By by, int optionIndex, boolean isScrollElement){

        WebElement webElement = findElementForJs(by,"1");
        if(isScrollElement){
            jsMethods.scrollElement(webElement);
        }
        actionMethods.select(webElement, optionIndex);
    }

    // 1 loop 400 ms
    public boolean isImageLoadingJs(By by, int loopCount){

        boolean isImageLoading = false;
        try {
            isImageLoading = jsMethods.jsImageLoading(findElementForJs(by,"1"), loopCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return isImageLoading;
    }

    public void waitPageLoadCompleteJs() {

        jsMethods.waitPageLoadComplete(setFluentWait(10));
    }

    public void waitForAngularLoadJs() {

        jsMethods.waitForAngularLoad(setFluentWait(10));
    }

    public void waitJQueryCompleteJs() {

        jsMethods.waitJQueryComplete(setFluentWait(10));
    }

    public void waitPageScrollingCompleteJs() {

        jsMethods.waitPageScrollingComplete(setFluentWait(10));
    }

    public void stopPageLoadJs() {

        jsMethods.stopPageLoad();
    }

    public boolean doesUrl(String url, int count, String condition){

        int againCount = 0;
        boolean isUrl = false;
        String takenUrl = "";
        logger.info("Beklenen url: " + url);
        while (!isUrl) {
            methodsUtil.waitByMilliSeconds(250);
            if (againCount == count) {
                System.err.println("Expected url " + url + " doesn't equal current url " + takenUrl);
                logger.info("Alınan url: " + takenUrl);
                return false;
            }
            takenUrl = driver.getCurrentUrl();
            if (takenUrl != null) {
                isUrl = methodsUtil.conditionValueControl(url,takenUrl,condition);
            }
            againCount++;
        }
        logger.info("Alınan url: " + takenUrl);
        return true;
    }

    public void clickElementJs(By by){

        jsMethods.clickByElement(findElementForJs(by,"3"));
    }

    public void clickElementJs(By by, boolean notClickByCoordinate){

        jsMethods.clickByElement(findElementForJs(by,"3"), notClickByCoordinate);
    }

    public void clickByCoordinateJs(int x, int y){

        jsMethods.clickByCoordinate(x, y);
    }

    public void clickByWebElementCoordinate(By by){

        jsMethods.clickByWebElementCoordinate(findElementForJs(by,"3"));
    }

    public void clickByWebElementCoordinate(By by, int x, int y){

        jsMethods.clickByWebElementCoordinate(findElementForJs(by,"3"), x, y);
    }

    public void checkElementExistWithUrl(By by, int elementControlCount, int repeatCount, String url, String errorMessage) {

        boolean isElementVisible = false;
        int countAgain = 0;
        int elementCount;
        while (!isElementVisible) {
            methodsUtil.waitByMilliSeconds(400);
            if (countAgain == repeatCount*elementControlCount) {
                fail(errorMessage);
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

    public boolean doesElementExist(By by, int timeout){

        int elementCount;
        for (int i = 0; i < 4*timeout; i++) {
            elementCount = driver.findElements(by).size();
            if (elementCount != 0) {
                return true;
            }
            methodsUtil.waitByMilliSeconds(250);
        }
        return false;
    }

    public boolean doesElementNotExist(By by, int timeout) {

        int elementCount;
        for (int i = 0; i < 4*timeout; i++) {
            elementCount = driver.findElements(by).size();
            if (elementCount == 0) {
                return true;
            }
            methodsUtil.waitByMilliSeconds(250);
        }
        return false;
    }

    public void keyValueChangerMethodWithNewElement(String key, String newKey, String value, String splitValue){

        ElementInfo elementInfo = getElementInfo(key);
        String getValue = elementInfo.getValue();
        String type = elementInfo.getType();
        logger.info(value);
        String[] arrayValue = Splitter.on(splitValue).splitToList(value).toArray(new String[0]);
        String newValue = String.format(getValue, arrayValue);
        logger.info(newValue);
        createElementInfo(newKey,newValue,type);
    }

    public String getKeyValueChangerStringBuilder(String value, String splitValue, String mapKeySuffix){

        if(value.contains(mapKeySuffix)) {
            String[] values = Splitter.on(splitValue).splitToList(value).toArray(new String[0]);
            StringBuilder stringBuilder = new StringBuilder();
            int valuesLength = values.length;
            for (int i = 0; i < valuesLength; i++) {
                String text = values[i];
                if (text.endsWith(mapKeySuffix)) {
                    text = Driver.TestMap.get(text).toString();
                }
                stringBuilder.append(text);
                if (i != valuesLength - 1) {
                    stringBuilder.append(splitValue);
                }
            }
            value = stringBuilder.toString();
        }
        return value;
    }

    public WebElement findElementForJs(By by, String type){

        WebElement webElement = null;
        switch (type){
            case "1":
                webElement = findElement(by);
                break;
            case "2":
                webElement = findElementWithoutWait(by);
                break;
            case "3":
                List<String> byValueList = getByValueAndSelectorType(by);
                webElement = jsMethods.findElement(byValueList.get(0),byValueList.get(1));
                break;
            default:
                fail("type hatalı");
        }
        return webElement;
    }

    public List<WebElement> findElementsForJs(By by, String type){

        List<WebElement> webElementList = null;
        switch (type){
            case "1":
                webElementList = findElements(by);
                break;
            case "2":
                webElementList = findElementsWithoutWait(by);
                break;
            case "3":
                List<String> byValueList = getByValueAndSelectorType(by);
                webElementList = jsMethods.findElements(byValueList.get(0),byValueList.get(1));
                break;
            default:
                fail("type hatalı");
        }
        return webElementList;
    }

    /**
     * TODO: remote ortamda butona tıklanarak kopyalanan texti alma
     * @return
     */
    public String getCopiedTextWithNewTab() {

        openNewTabJs("https://testinium.com/");
        methodsUtil.waitBySeconds(1);
        tabControl();
        switchTab(1);
        methodsUtil.waitBySeconds(1);
        String textKey = "COMMAND";
        if (Driver.platformName.startsWith("WIN")){
            textKey = "LEFT_CONTROL";
        }
        By by = By.xpath("//div[@id=\"tryNow\"]/preceding-sibling::input");
        checkElementVisible(by);
        findElement(by).sendKeys(Keys.chord(Keys.valueOf(textKey), "v"));
        return getValueJs(by,"3");
    }

    public void tabControl(){
        for (int i = 0; i < 20; i++){
            methodsUtil.waitByMilliSeconds(400);
            if (listTabs().size() > 1){
                break;
            }
        }
    }

    public Object getValueInTestMap(String key){

        return Driver.TestMap.get(key);
    }

    public void putValueInTestMap(String key, Object object){

        Driver.TestMap.put(key, object);
    }

    public boolean doesAttributeValue(By by, String attribute, String value, String condition, int count){

        int againCount = 0;
        boolean attributeCondition = false;
        String actualAttributeValue = "";
        logger.info("Beklenen değer: " + attribute + " " + condition + " " + value);
        while (!attributeCondition) {
            methodsUtil.waitByMilliSeconds(400);
            if (againCount == count) {
                logger.info("Alınan değer: " + actualAttributeValue);
                return false;
            }
            actualAttributeValue = findElement(by).getAttribute(attribute).trim();
            if (actualAttributeValue != null) {
                attributeCondition = methodsUtil.conditionValueControl(value, actualAttributeValue, condition);
            }
            againCount++;
        }
        logger.info("Alınan değer: " + actualAttributeValue);
        return true;
    }

    public void checkElementExist(By by, int loopCount){

        Assert.assertTrue("Element bulunamadı",doesElementExist(by,loopCount));
    }

    public void closeAddsTab(int tabNumber, String urls, String bannedUrls) {

        methodsUtil.waitBySeconds(2);
        List<String> windowList = new ArrayList<String>();
        for (String winHandle : driver.getWindowHandles()) {

            windowList.add(winHandle.trim());
        }

        logger.info("tabList: " + windowList.toString());

        for (int i = 0; i < windowList.size(); i++) {
            // Switch to new window opened
            try {
                driver.switchTo().window(windowList.get(i));
                methodsUtil.waitBySeconds(1);
                String newUrl = driver.getCurrentUrl();
                if (!containsControlUrl(newUrl, urls) || containsControlUrl(newUrl, bannedUrls)) {
                    methodsUtil.waitBySeconds(1);
                    // Perform the actions on new window
                    //this will close new opened window
                    driver.close();
                    methodsUtil.waitBySeconds(1);
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


}
