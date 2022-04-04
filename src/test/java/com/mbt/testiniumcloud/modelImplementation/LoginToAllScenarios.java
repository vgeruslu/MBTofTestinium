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
public class LoginToAllScenarios extends ExecutionContext implements org.graphwalker.LoginToAllScenarios {

    private static final Logger logger = LogManager.getLogger(LoginToAllScenarios.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public LoginToAllScenarios() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(LoginToAllScenarios.class), Level.toLevel(Driver.modelImplLogLevel));

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
        methods.checkElementVisible(methods.getBy("activeTestsInDashboard"));
        methods.checkElementVisible(methods.getBy("latestTestRunsTableInDashboard"));
        methods.checkElementVisible(methods.getBy("bell"));
        methods.checkElementVisible(methods.getBy("shoppingCart"));
        methods.checkElementVisible(methods.getBy("userDropdown"));
    }

    public void e_Click_All_Scenarios_Tab() {

        By allScenariosTabBy = methods.getBy("allScenariosTab");
        methods.checkElementVisible(allScenariosTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(allScenariosTabBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(allScenariosTabBy);
        methods.clickElement(allScenariosTabBy);
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

    public void v_Verify_In_All_Scenarios_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario",75,"equal"));
        methods.checkElementVisible(methods.getBy("allScenariosLogoTitleInAllScenarios"));
        methods.checkElementVisible(methods.getBy("projectSelectInAllScenarios"));
        methods.checkElementVisible(methods.getBy("suiteSelectInAllScenarios"));
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.checkElementVisible(methods.getBy("createScenarioInAllScenarios"));
        methods.checkElementVisible(methods.getBy("syncScenariosInAllScenarios"));
        methods.checkElementVisible(methods.getBy("createNewGroupInAllScenarios"));
        methods.checkElementVisible(methods.getBy("exportTableInAllScenarios"));
        methods.checkElementVisible(methods.getBy("tableViewModeNormalInAllScenarios"));
        methods.checkElementVisible(methods.getBy("tableViewModeFileInAllScenarios"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }
}
