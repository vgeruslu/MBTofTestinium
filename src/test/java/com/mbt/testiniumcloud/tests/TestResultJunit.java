package com.mbt.testiniumcloud.tests;

import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestResultJunit extends TestWatcher {

    private static final Logger logger = LoggerFactory.getLogger(TestResultJunit.class);

    protected void starting(Description description) {
        logger.info("=========================================================================");
        logger.info("Starting Test: " + description.getMethodName());
    }

    protected void succeeded(Description description) {
        String[] classNameArray = description.getClassName().split("\\.");
        logger.info("Test Class: " + classNameArray[classNameArray.length-1]
                + " Test Case: " + description.getMethodName());
        logger.info("Test Result: " + "TEST SUCCESSFULL");
    }

    public void failed(Throwable e, Description description) {
        String[] classNameArray = description.getClassName().split("\\.");
        logger.error("", e);
        logger.error("Test Class: " + classNameArray[classNameArray.length-1]
                + " Test Case: " + description.getMethodName());
        logger.error("Test Result: " + "TEST FAILED");
    }

    protected void skipped(AssumptionViolatedException e, Description description) {
        String[] classNameArray = description.getClassName().split("\\.");
        logger.error(e.getMessage());
        logger.error("", e);
        logger.info("Test Class: " + classNameArray[classNameArray.length-1]
                + " Test Case: " + description.getMethodName());
        logger.info("Test Result: " + "TEST SKIPPED");
    }

    protected void finished(Description description) {
        logger.info("=========================================================================");
    }

}
