package com.mbt.testiniumcloud.tests;

import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.SendMail;
import org.apache.commons.lang3.StringUtils;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestResultJunit extends TestWatcher {

    private static final Logger logger = LogManager.getLogger(TestResultJunit.class);

    protected void starting(Description description) {
        logger.info("=========================================================================");
        String[] classNameArray = description.getClassName().split("\\.");
        Driver.TestClassName = classNameArray[classNameArray.length-1];
        String testCaseName = description.getMethodName();
        logger.info("Starting Test: " + testCaseName);
        Driver.TestCaseName = testCaseName;
        logger.info("If The Test fails, The Faulty Step is the last step");
        //System.out.println("\r\n");
    }

    protected void succeeded(Description description) {
        //String[] classNameArray = description.getClassName().split("\\.");
        logger.info("Test Class: " + Driver.TestClassName
                + " Test Case: " + Driver.TestCaseName);
        logger.info("Test Result: " + "TEST SUCCESSFULL");
        //Driver.testResult = "Successfull";
        /**
         if(Driver.excelActive) {
         new ExcelMapData().setTestResult("Successfull");
         }
         */
    }

    public void failed(Throwable e, Description description) {
        //String[] classNameArray = description.getClassName().split("\\.");
        logger.error("Test Class: " + Driver.TestClassName
                + " Test Case: " + Driver.TestCaseName);
        logger.error("Test Result: " + "TEST FAILED");
        //logger.error("Error: ", e);
        /**
         if(Driver.excelActive) {
         new ExcelMapData().setTestResult("Failed");
         }
         */
    }

    protected void skipped(AssumptionViolatedException e, Description description) {
        //String[] classNameArray = description.getClassName().split("\\.");
        //Driver.testResult = "Test Skipped";
        //logger.error(e.getMessage());
        //logger.error("", e);
        logger.info("Test Class: " + Driver.TestClassName
                + " Test Case: " + Driver.TestCaseName);
        logger.info("Test Result: " + "TEST SKIPPED");
    }

    protected void finished(Description description) {
        //logger.info(description.getMethodName());
        logger.info("=========================================================================");
        //System.out.println("\r\n");
    }

}
