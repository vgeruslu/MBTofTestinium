package com.mbt.testiniumcloud.methods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.stream.IntStream;

public class ActionMethods {

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

    public void waitByMilliSeconds(long milliSeconds){

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitBySeconds(long seconds){

        waitByMilliSeconds(seconds*1000);
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

}