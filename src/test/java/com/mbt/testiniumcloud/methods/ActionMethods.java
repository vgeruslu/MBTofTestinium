package com.mbt.testiniumcloud.methods;

import com.mbt.testiniumcloud.driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.stream.IntStream;

public class ActionMethods {

    Keys controlKey = Driver.osName.equals("WINDOWS") ? Keys.CONTROL : Keys.COMMAND;
    WebDriver driver;

    public ActionMethods(WebDriver driver){

        this.driver = driver;
    }

    public void hoverElement(WebElement webElement) {

        Actions hoverAction = new Actions(driver);
        hoverAction.moveToElement(webElement).build().perform();
    }

    public void sendKeys(WebElement webElement, String text) {

        Actions actions = new Actions(driver);
        actions.sendKeys(webElement, text).build().perform();
    }

    public void clickElement(WebElement webElement){

        Actions actions = new Actions(driver);
        actions.click(webElement).build().perform();
    }

    public void doubleClickElement(WebElement webElement){

        Actions actions = new Actions(driver);
        actions.doubleClick(webElement).build().perform();
    }

    public void moveAndClickElement(WebElement webElement){

        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    public void moveAndDoubleClickElement(WebElement webElement){

        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).doubleClick().build().perform();
    }

    public void select(WebElement webElement, int optionIndex){

        Select select = new Select(webElement);
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
                .click(select.getOptions().get(optionIndex))
                .keyUp(Keys.CONTROL);
        builder.build().perform();
    }

    public void swipeToElement(WebElement firstElement, WebElement secondElement){

        Actions action = new Actions(driver);
        action.clickAndHold(firstElement).pause(Duration.ofMillis(1000));
        action.moveToElement(secondElement).release();
        action.build().perform();
    }

    public void swipeToElement(WebElement firstElement, int x, int y){

        Actions action = new Actions(driver);
        action.clickAndHold(firstElement).pause(Duration.ofMillis(1000));
        action.moveByOffset(x,y).release();
        action.build().perform();
    }

    public void swipeToElement(WebElement firstElement, WebElement secondElement, int x, int y){

        Actions action = new Actions(driver);
        action.clickAndHold(firstElement).pause(Duration.ofMillis(1000));
        action.moveToElement(secondElement,x,y).release();
        action.build().perform();
    }

    public void selectItemByIndex(WebElement element, int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click(element);
        actions.pause(Duration.ofSeconds(1));
        IntStream.range(0, index).mapToObj(i -> Keys.DOWN).forEach(actions::sendKeys);
        actions.sendKeys(Keys.SPACE);
        actions.build().perform();
    }

    public void selectDropdownItemByText(WebElement element, int index) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click(element);
        actions.pause(Duration.ofSeconds(1));
        IntStream.range(0, index).mapToObj(i -> Keys.DOWN).forEach(actions::sendKeys);
        actions.sendKeys(Keys.SPACE);
        actions.build().perform();
    }

    public void keyDownUp(String keyName){

        Actions actions = new Actions(driver);
        actions.keyDown(controlKey).sendKeys(keyName).keyUp(controlKey).perform();
    }

    public void sendKeysWithKey(String keyName){

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.valueOf(keyName)).perform();
    }

    public void sendKeys(String text){

        Actions actions = new Actions(driver);
        actions.sendKeys(text).perform();
    }

}