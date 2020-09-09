package com.mbt.testiniumcloud.tests;

import com.mbt.testiniumcloud.driver.DriverCreater;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.SendMail;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

public class TestResultJunit extends TestWatcher {

    private static final Logger logger = LoggerFactory.getLogger(TestResultJunit.class);

    protected void starting(Description description) {
        logger.info("=========================================================================");
        String testCaseName = description.getMethodName();
        logger.info("Starting Test: " + testCaseName);
        DriverCreater.TestCaseName = testCaseName;
        logger.info("If The Test fails, The Faulty Step is the last step");
        //System.out.println("\r\n");
    }

    protected void succeeded(Description description) {
        String[] classNameArray = description.getClassName().split("\\.");
        logger.info("Test Class: " + classNameArray[classNameArray.length-1]
                + " Test Case: " + description.getMethodName());
        logger.info("Test Result: " + "TEST SUCCESSFULL");
        //DriverCreater.testResult = "Successfull";
        /**
        if(DriverCreater.excelActive) {
            new ExcelMapData().setTestResult("Successfull");
        }
         */
    }

    public void failed(Throwable e, Description description) {
        String[] classNameArray = description.getClassName().split("\\.");
        logger.error("Test Class: " + classNameArray[classNameArray.length-1]
                + " Test Case: " + description.getMethodName());
        logger.error("Test Result: " + "TEST FAILED");
        logger.error("Error: ", e);
        /**
        if(DriverCreater.excelActive) {
            new ExcelMapData().setTestResult("Failed");
        }
         */
    }

    protected void skipped(AssumptionViolatedException e, Description description) {
        String[] classNameArray = description.getClassName().split("\\.");
        //DriverCreater.testResult = "Test Skipped";
        //logger.error(e.getMessage());
        //logger.error("", e);
        logger.info("Test Class: " + classNameArray[classNameArray.length-1]
                + " Test Case: " + description.getMethodName());
        logger.info("Test Result: " + "TEST SKIPPED");
    }

    protected void finished(Description description) {
        //logger.info(description.getMethodName());
        if(DriverCreater.excelActive
                && Integer.parseInt(DriverCreater.ModelDurationMap.get("TotalStepCount").toString()) > 1) {
            try {
                new ExcelMapData().createExcel();
            }catch (Exception e){
                logger.info("Excel oluşturulamadı.");
                e.printStackTrace();
                DriverCreater.excelActive = false;
            }
            if(DriverCreater.excelActive) {
                new SendMail().sendMailTestResult(DriverCreater.result,
                        DriverCreater.ConfigurationProp.getString("toMail"), DriverCreater.excelLocation);
            }else {
                logger.info("Excel oluşturulamadığı için mail yollanamadı.");
            }
        }
        logger.info("=========================================================================");
        //System.out.println("\r\n");
    }

}
