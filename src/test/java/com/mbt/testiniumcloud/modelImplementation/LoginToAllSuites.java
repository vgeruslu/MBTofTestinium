package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.common.CommonProcess;
import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.methods.MethodsUtil;
import com.mbt.testiniumcloud.utils.CoverageValue;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.SharedNodeControl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)//, start = "v_Start")
public class LoginToAllSuites extends ExecutionContext implements org.graphwalker.LoginToAllSuites {

    private static final Logger logger = LogManager.getLogger(LoginToAllSuites.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public LoginToAllSuites() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(LoginToAllSuites.class), Level.toLevel(Driver.modelImplLogLevel));

        // Projects
        methodsUtil.putValueInTestMap("runProject", Driver.ConfigurationProp.getString("runProject"));
        methodsUtil.putValueInTestMap("optionalProject", Driver.ConfigurationProp.getString("multiScenariosProject"));
        methodsUtil.putValueInTestMap("editProject", Driver.ConfigurationProp.getString("editProject"));
        methodsUtil.putValueInTestMap("appiumProject", Driver.ConfigurationProp.getString("appiumProject"));
        methodsUtil.putValueInTestMap("ignoreDeleteProjectNameContain", Driver.ConfigurationProp.getString("ignoreDeleteProjectNameContain"));
        methodsUtil.putValueInTestMap("projectNameForReports", String.valueOf(methodsUtil.getValueInTestMap("editProject")));
        methodsUtil.putValueInTestMap("testSourceFileName","BaseTest.java");
        methodsUtil.putValueInTestMap("testMethodFileName","testCase");
        //methodsUtil.putValueInTestMap("editProjectRun",false);
        methodsUtil.putValueInTestMap("currentProject", String.valueOf(methodsUtil.getValueInTestMap("optionalProject")));
        methodsUtil.putValueInTestMap("testRun", false);
    }

    @BeforeElement
    public void beforeElement() {

        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
        excelMapData.setBeforeElementData(getModel(), getCurrentElement());
        SharedNodeControl.sharedNodeElementControl(getCurrentElement());
    }

    @AfterElement
    public void afterElement() {

        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    @BeforeExecution
    public void setup() {

    }

    @AfterExecution
    public void cleanup() {

    }

    public void e_Valid_Login() {

        By signInButtonBy = methods.getBy("signInInLogin");
        By userNameBy = methods.getBy("userNameInLogin");
        String userName = Driver.ConfigurationProp.getString("VALID_USERNAME");
        By passwordBy = methods.getBy("passwordInLogin");
        String password = Driver.ConfigurationProp.getString("VALID_PASSWORD");
        commonProcess.checkElementVisible(userNameBy);
        commonProcess.checkElementVisible(passwordBy);
        commonProcess.checkElementVisible(signInButtonBy);
        commonProcess.checkElementClickable(signInButtonBy);
        methods.clearElementWithBackSpace(userNameBy,"a");
        commonProcess.checkElementVisible(userNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(userNameBy, userName);
        commonProcess.checkElementClickable(passwordBy);
        methods.clearElementWithBackSpace(passwordBy,"a");
        commonProcess.checkElementClickable(passwordBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(passwordBy, password);
        commonProcess.clickButton(signInButtonBy);
    }

    public void e_Click_All_Suites_Tab() {

        By allSuitesTabBy = methods.getBy("allSuitesTab");
        commonProcess.checkElementVisible(allSuitesTabBy);
        commonProcess.scrollElementCenter(allSuitesTabBy);
        commonProcess.clickButton(allSuitesTabBy);
    }

    public void v_Verify_In_All_Suites_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/plan",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("selectProjectInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("exportTableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("createPlanInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("mobileIosShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("mobileAndroidShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webAllShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webFirefoxShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webChromeShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webIEShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webSafariShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webOperaShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webEdgeShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("runningSuitesShowOnlyOptionInAllSuites"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void v_Verify_In_Dashboard_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/home",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("logoArea"));
        commonProcess.checkElementVisible(methods.getBy("logoTitle"));
        assertEquals( "Dashboard", methods.getText(methods.getBy("logoTitle")).trim());
        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
        commonProcess.checkElementVisible(methods.getBy("dashboardCreateButton"));
        commonProcess.checkElementVisible(methods.getBy("testiniumTestPlanInDashboard"));
        commonProcess.checkElementVisible(methods.getBy("parallelTestsInDashboard"));
        commonProcess.checkElementVisible(methods.getBy("queuedTestsInDashboard"));
       // commonProcess.checkElementVisible(methods.getBy("activeTestsInDashboard"));
      //  commonProcess.checkElementVisible(methods.getBy("latestTestRunsTableInDashboard"));
      //  commonProcess.checkElementVisible(methods.getBy("bell"));
      //  commonProcess.checkElementVisible(methods.getBy("shoppingCart"));
        commonProcess.checkElementVisible(methods.getBy("userDropdown"));
    }

    public void e_Click_Dashboard_Button() {

        By dashboardButtonBy = methods.getBy("dashboardButton");
        commonProcess.checkElementVisible(dashboardButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(dashboardButtonBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementClickable(dashboardButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(dashboardButtonBy);
    }

    public void v_Start() {

    }

    public void v_Verify_In_Login_Page() {

        assertTrue(methods.doesUrl("https://account.testinium.com/uaa/login",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("userNameInLogin"));
        commonProcess.checkElementVisible(methods.getBy("passwordInLogin"));
        commonProcess.checkElementVisible(methods.getBy("signInInLogin"));
        commonProcess.checkElementClickable(methods.getBy("signInInLogin"));
        commonProcess.checkElementVisible(methods.getBy("forgotPasswordInLogin"));
        commonProcess.checkElementVisible(methods.getBy("linkedInButtonInLogin"));
        commonProcess.checkElementVisible(methods.getBy("googleButtonInLogin"));
        commonProcess.checkElementVisible(methods.getBy("githubButtonInLogin"));
        commonProcess.checkElementVisible(methods.getBy("signUpButtonInLogin"));
    }

    public void e_Go_To_Login_Page() {

        methods.navigateTo("https://account.testinium.com/uaa/login");
    }

    public void v_Verify_In_Report_Detail_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/report/detail/",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("exportTableInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("exportPdfInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("executionDetailTableInReportDetail"));
        //commonProcess.checkElementVisible(methods.getBy("executionDetailTestCaseInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("testResultTableInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("testResultStatusInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("testResultDetailButtonInReportDetail"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }
}
