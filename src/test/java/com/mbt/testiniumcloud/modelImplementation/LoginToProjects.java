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
public class LoginToProjects extends ExecutionContext implements org.graphwalker.LoginToProjects {

    private static final Logger logger = LogManager.getLogger(LoginToProjects.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public LoginToProjects() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(LoginToProjects.class), Level.toLevel(Driver.modelImplLogLevel));

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

    public void v_Verify_In_Create_Scenario_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/scenario/create",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("logoInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("projectNameInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("scenarioNameInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("scenarioDescriptionInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("selectGroupInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("selectMaxExecutionTimeInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("javaParameterNameInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("javaParameterValueInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("javaParametersAddButtonInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("selectSourceFilePanelInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("selectTestMethodsPanelInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("createScenarioGroupSwitchInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("copyButtonInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInCreateScenario"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void v_Verify_In_Reports_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/report/detail/",75,"notStartWith"));
        assertTrue(methods.doesUrl("https://testinium.io/report",75,"startWith"));

        commonProcess.checkElementVisible(methods.getBy("reportsLogoTitleInReports"));
        commonProcess.checkElementVisible(methods.getBy("createButtonInReports"));
        commonProcess.checkElementVisible(methods.getBy("exportTableInReports"));
        commonProcess.checkElementVisible(methods.getBy("projectsInReports"));
        commonProcess.checkElementVisible(methods.getBy("suitesInReports"));
        commonProcess.checkElementVisible(methods.getBy("dateFromInReports"));
        commonProcess.checkElementVisible(methods.getBy("dateToInReports"));
        commonProcess.checkElementVisible(methods.getBy("showOnlyFailedTestsInReports"));
        commonProcess.checkElementVisible(methods.getBy("tableContainInReports"));
        commonProcess.checkElementVisible(methods.getBy("tableCheckboxInReports"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
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
       // commonProcess.checkElementVisible(methods.getBy("shoppingCart"));
        commonProcess.checkElementVisible(methods.getBy("userDropdown"));
    }

    public void e_Click_Projects_Tab() {

        By projectsTabBy = methods.getBy("projectsTab");
        commonProcess.checkElementVisible(projectsTabBy);
        commonProcess.scrollElementCenter(projectsTabBy);
        commonProcess.clickButton(projectsTabBy);
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

    public void v_Verify_In_Create_Plan_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/plan/create",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("logoInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("projectNameInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("suiteNameInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInCreatePlan"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void v_Verify_In_Scenario_Edit_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/scenario/edit/",75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleWithProjectNameInScenarioEdit","logoTitleWithProjectName1InScenarioEdit", String.valueOf(methodsUtil.getValueInTestMap("currentScenario"))));
        commonProcess.checkElementVisible(methods.getBy("propertiesTabInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("ideTabInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("copyUrlButtonInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("projectNameInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("scenarioNameInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("scenarioDescriptionInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("selectGroupInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("selectMaxExecutionTimeInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("fileContentPanelInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("selectSourceFilePanelWindowInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("selectTestMethodsPanelWindow1InCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("javaParameterNameInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("javaParameterValueInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("javaParameterDescriptionInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("javaParametersAddButtonInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("applyButtonInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInScenarioEdit"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void v_Verify_In_Projects_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/project",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("projectsLogoTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("projectPanelInProjects"));
        commonProcess.checkElementVisible(methods.getBy("createProjectPanelInProjects"));
        commonProcess.checkElementVisible(methods.getBy("createProjectInProjects"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Dashboard_Button() {

        By dashboardButtonBy = methods.getBy("dashboardButton");
        commonProcess.checkElementVisible(dashboardButtonBy);
        commonProcess.scrollElementCenter(dashboardButtonBy);
        commonProcess.clickButton(dashboardButtonBy);
    }

    public void v_Start() {

    }

    public void e_Go_To_Login_Page() {

        methods.navigateTo("https://account.testinium.com/uaa/login");
    }

    public void v_Verify_In_Plan_Edit_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/plan/edit/",75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleInPlanEdit","logoTitleInPlanEdit1", String.valueOf(methodsUtil.getValueInTestMap("editPlanName"))));
        commonProcess.checkElementVisible(methods.getBy("projectNameInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("planNameInPlanEdit"));
        //commonProcess.checkElementVisible(methods.getBy("enableSwitchInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("scenarioNameForScenariosPanelInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("applyButtonInPlanEdit"));
        //scenarioForScenariosSelectListInCreatePlan
        //Mac 	1920x1080

        commonProcess.checkElementVisible(methods.getBy("propertiesTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("advancedTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("scheduleAndNotificationsTabInPlanEdit"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }
}
