package com.mbt.testiniumcloud.modelImplementation;

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
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)//, start = "v_Start")
public class LoginToAllSuites extends ExecutionContext implements org.graphwalker.LoginToAllSuites {

    private static final Logger logger = LogManager.getLogger(LoginToAllSuites.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public LoginToAllSuites() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(LoginToAllSuites.class), Level.toLevel(Driver.modelImplLogLevel));

        // Projects
        methods.putValueInTestMap("runProject",
                Driver.ConfigurationProp.getString("runProject"));
        methods.putValueInTestMap("optionalProject",
                Driver.ConfigurationProp.getString("multiScenariosProject"));
        methods.putValueInTestMap("editProject",
                Driver.ConfigurationProp.getString("editProject"));
        methods.putValueInTestMap("appiumProject",
                Driver.ConfigurationProp.getString("appiumProject"));
        methods.putValueInTestMap("ignoreDeleteProjectNameContain",
                Driver.ConfigurationProp.getString("ignoreDeleteProjectNameContain"));
        methods.putValueInTestMap("projectNameForReports",
                String.valueOf(methods.getValueInTestMap("editProject")));
        methods.putValueInTestMap("testSourceFileName","BaseTest.java");
        methods.putValueInTestMap("testMethodFileName","testCase");
        //methods.putValueInTestMap("editProjectRun",false);
        methods.putValueInTestMap("currentProject",
                String.valueOf(methods.getValueInTestMap("optionalProject")));
        methods.putValueInTestMap("testRun",false);
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
        methods.checkElementVisible(userNameBy);
        methods.checkElementVisible(passwordBy);
        methods.checkElementVisible(signInButtonBy);
        methods.checkElementClickable(signInButtonBy);
        methods.clearElementWithBackSpace(userNameBy,"a");
        methods.checkElementVisible(userNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(userNameBy, userName);
        methods.checkElementClickable(passwordBy);
        methods.clearElementWithBackSpace(passwordBy,"a");
        methods.checkElementClickable(passwordBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(passwordBy, password);
        methods.checkElementVisible(signInButtonBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementClickable(signInButtonBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clickElement(signInButtonBy);
    }

    public void e_Click_All_Suites_Tab() {

        By allSuitesTabBy = methods.getBy("allSuitesTab");
        methods.checkElementVisible(allSuitesTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(allSuitesTabBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(allSuitesTabBy);
        methods.clickElement(allSuitesTabBy);
    }

    public void v_Verify_In_All_Suites_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan",75,"equal"));
        methods.checkElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"));
        methods.checkElementVisible(methods.getBy("selectProjectInAllSuites"));
        methods.checkElementVisible(methods.getBy("exportTableInAllSuites"));
        methods.checkElementVisible(methods.getBy("createPlanInAllSuites"));
        methods.checkElementVisible(methods.getBy("mobileIosShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("mobileAndroidShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webAllShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webFirefoxShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webChromeShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webIEShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webSafariShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webOperaShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webEdgeShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("runningSuitesShowOnlyOptionInAllSuites"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void v_Verify_In_Dashboard_Page_SHARED() {

        Assert.assertTrue(""
                , methods.doesUrl("https://testinium.io/home",75,"startWith"));
        methods.checkElementVisible(methods.getBy("logoArea"),60);
        methods.checkElementVisible(methods.getBy("logoTitle"),60);
        Assert.assertEquals("", "Dashboard", methods.getText(methods.getBy("logoTitle")).trim());
        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
        methods.checkElementVisible(methods.getBy("dashboardCreateButton"));
        methods.checkElementVisible(methods.getBy("testiniumTestPlanInDashboard"));
        methods.checkElementVisible(methods.getBy("parallelTestsInDashboard"));
        methods.checkElementVisible(methods.getBy("queuedTestsInDashboard"));
       // methods.checkElementVisible(methods.getBy("activeTestsInDashboard"));
      //  methods.checkElementVisible(methods.getBy("latestTestRunsTableInDashboard"));
      //  methods.checkElementVisible(methods.getBy("bell"));
      //  methods.checkElementVisible(methods.getBy("shoppingCart"));
        methods.checkElementVisible(methods.getBy("userDropdown"));
    }

    public void e_Click_Dashboard_Button() {

        By dashboardButtonBy = methods.getBy("dashboardButton");
        methods.checkElementVisible(dashboardButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(dashboardButtonBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(dashboardButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(dashboardButtonBy);
    }

    public void v_Start() {

    }

    public void v_Verify_In_Login_Page() {

        Assert.assertTrue("", methods.doesUrl("https://account.testinium.com/uaa/login",
                75,"startWith"));
        methods.checkElementVisible(methods.getBy("userNameInLogin"));
        methods.checkElementVisible(methods.getBy("passwordInLogin"));
        methods.checkElementVisible(methods.getBy("signInInLogin"));
        methods.checkElementClickable(methods.getBy("signInInLogin"));
        methods.checkElementVisible(methods.getBy("forgotPasswordInLogin"));
        methods.checkElementVisible(methods.getBy("linkedInButtonInLogin"));
        methods.checkElementVisible(methods.getBy("googleButtonInLogin"));
        methods.checkElementVisible(methods.getBy("githubButtonInLogin"));
        methods.checkElementVisible(methods.getBy("signUpButtonInLogin"));
    }

    public void e_Go_To_Login_Page() {

        methods.navigateTo("https://account.testinium.com/uaa/login");
    }

    public void v_Verify_In_Report_Detail_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report/detail/",75,"startWith"));
        methods.checkElementVisible(methods.getBy("exportTableInReportDetail"));
        methods.checkElementVisible(methods.getBy("exportPdfInReportDetail"));
        methods.checkElementVisible(methods.getBy("executionDetailTableInReportDetail"));
        //methods.checkElementVisible(methods.getBy("executionDetailTestCaseInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultTableInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultStatusInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultDetailButtonInReportDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }
}
