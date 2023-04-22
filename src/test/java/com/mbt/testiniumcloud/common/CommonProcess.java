package com.mbt.testiniumcloud.common;

import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.methods.MethodsUtil;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;

public class CommonProcess {

    Methods methods;
    MethodsUtil methodsUtil;

    public CommonProcess(){

        methods = new Methods();
        methodsUtil = new MethodsUtil();
    }

    public void clickButton(By by){

        assertTrue(methods.isElementVisible(by,30));
        assertTrue(methods.isElementClickable(by,30));
        methodsUtil.waitByMilliSeconds(300,false);
        methods.clickElement(by);
    }

    public void scrollElementCenter(By by){

        scrollElementCenter(by,200,500);
    }

    public void scrollElementCenter(By by, long time1, long time2){

        methodsUtil.waitByMilliSeconds(time1,false);
        methods.scrollElementCenterJs(by,"1");
        methodsUtil.waitByMilliSeconds(time2,false);
    }

    public void scrollElement(By by, long time1, long time2){

        methodsUtil.waitByMilliSeconds(time1,false);
        methods.scrollElementJs(by,"1");
        methodsUtil.waitByMilliSeconds(time2,false);
    }

    public By getKeyValueChangerElement(String element, String newElement, String value){

        methods.keyValueChangerMethodWithNewElement(element, newElement, value,"|!");
        return methods.getBy(newElement);
    }

    public void checkElementVisible(By by){

        assertTrue(methods.isElementVisible(by,30));
    }

    public void checkElementClickable(By by){

        assertTrue(methods.isElementClickable(by,30));
    }
}
