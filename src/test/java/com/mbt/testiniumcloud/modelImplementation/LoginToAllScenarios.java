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
public class LoginToAllScenarios extends ExecutionContext implements org.graphwalker.LoginToAllScenarios {

    private static final Logger logger = LogManager.getLogger(LoginToAllScenarios.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public LoginToAllScenarios() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(LoginToAllScenarios.class), Level.toLevel(Driver.modelImplLogLevel));

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
        methodsUtil.putValueInTestMap("testRun",false);
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

    public void v_Verify_In_Dashboard_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/home",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("logoArea"));
        commonProcess.checkElementVisible(methods.getBy("logoTitle"));
        assertEquals("Dashboard", methods.getText(methods.getBy("logoTitle")).trim());
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
       // commonProcess.checkElementVisible(methods.getBy("latestTestRunsTableInDashboard"));
      //  commonProcess.checkElementVisible(methods.getBy("bell"));
      //  commonProcess.checkElementVisible(methods.getBy("shoppingCart"));
        commonProcess.checkElementVisible(methods.getBy("userDropdown"));
    }

    public void e_Click_All_Scenarios_Tab() {

        By allScenariosTabBy = methods.getBy("allScenariosTab");
        commonProcess.checkElementVisible(allScenariosTabBy);
        commonProcess.scrollElementCenter(allScenariosTabBy);
        commonProcess.clickButton(allScenariosTabBy);
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

    public void v_Verify_In_All_Scenarios_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/scenario",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosLogoTitleInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("projectSelectInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("suiteSelectInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("createScenarioInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("syncScenariosInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("createNewGroupInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("exportTableInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("tableViewModeNormalInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("tableViewModeFileInAllScenarios"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }
}
