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

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class Dashboard extends ExecutionContext implements org.graphwalker.Dashboard {

    private static final Logger logger = LogManager.getLogger(Dashboard.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public Dashboard() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(Dashboard.class), Level.toLevel(Driver.modelImplLogLevel));
        // Projects
        methodsUtil.putValueInTestMap("runProject",
                Driver.ConfigurationProp.getString("runProject"));
        methodsUtil.putValueInTestMap("optionalProject",
                Driver.ConfigurationProp.getString("multiScenariosProject"));
        methodsUtil.putValueInTestMap("editProject",
                Driver.ConfigurationProp.getString("editProject"));
        methodsUtil.putValueInTestMap("appiumProject",
                Driver.ConfigurationProp.getString("appiumProject"));
        methodsUtil.putValueInTestMap("ignoreDeleteProjectNameContain",
                Driver.ConfigurationProp.getString("ignoreDeleteProjectNameContain"));
        methodsUtil.putValueInTestMap("projectNameForReports",
                String.valueOf(methodsUtil.getValueInTestMap("editProject")));
        methodsUtil.putValueInTestMap("testSourceFileName","BaseTest.java");
        methodsUtil.putValueInTestMap("testMethodFileName","testCase");
        //methodsUtil.putValueInTestMap("editProjectRun",false);
        methodsUtil.putValueInTestMap("currentProject",
                String.valueOf(methodsUtil.getValueInTestMap("optionalProject")));
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

    public void v_Verify_In_Reports_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/report/detail/",75,"notStartWith"));
        assertTrue(methods.doesUrl("https://testinium.io/report",75,"startWith"));
        /**
         methodsUtil.waitByMilliSeconds(300);
         String currentUrl = methods.getCurrentUrl().trim();
         logger.info(currentUrl);
         assertTrue(currentUrl.equals("https://testinium.io/report")
         || currentUrl.startsWith("https://testinium.io/report/project/")
         || currentUrl.startsWith("https://testinium.io/report/plan/"));
         */
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

    public void v_Verify_In_Create_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/create",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("panelBodyCreateInCreatePage"));
        commonProcess.checkElementVisible(methods.getBy("panelBodyDefineInCreatePage"));
        commonProcess.checkElementVisible(methods.getBy("panelBodyArrangeInCreatePage"));
        commonProcess.checkElementVisible(methods.getBy("createButtonInCreatePage"));
        commonProcess.checkElementVisible(methods.getBy("createNewProjectInCreatePage"));
        commonProcess.checkElementVisible(methods.getBy("seeYourProjectInCreatePage"));
        commonProcess.checkElementVisible(methods.getBy("createScenarioInCreatePage"));
        commonProcess.checkElementVisible(methods.getBy("seeYourScenariosInCreatePage"));
        commonProcess.checkElementVisible(methods.getBy("createPlanInCreatePage"));
        commonProcess.checkElementVisible(methods.getBy("seeYourPlansInCreatePage"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
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

    public void e_Click_Automated_Test_Tab() {

        By automatedTestTabBy = methods.getBy("automatedTestTab");
        commonProcess.checkElementVisible(automatedTestTabBy);
        commonProcess.scrollElementCenter(automatedTestTabBy);
        commonProcess.clickButton(automatedTestTabBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Dashboard_Page_SHARED() {

        //https://testinium.io/home?code=
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
       // commonProcess.checkElementVisible(methods.getBy("bell"));
      //  commonProcess.checkElementVisible(methods.getBy("shoppingCart"));
        commonProcess.checkElementVisible(methods.getBy("userDropdown"));
    }

    /**
     * TODO: user profile
     */
    public void v_Verify_User_Profile() {

    }

    /**
     * TODO: change company
     */
    public void e_Change_Company() {

    }

    public void e_Click_All_Scenarios_Tab() {

        By allScenariosTabBy = methods.getBy("allScenariosTab");
        commonProcess.checkElementVisible(allScenariosTabBy);
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.clickButton(allScenariosTabBy);
    }

    /**
     * TODO: user profile
     */
    public void e_Click_User_Profile() {

    }

    public void v_Verify_In_Automated_Test_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/automated/code-generator",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestCodeGeneratorLogoTitleInAutomatedTest"));
        commonProcess.checkElementVisible(methods.getBy("createButtonInAutomatedTest"));
        commonProcess.checkElementVisible(methods.getBy("selectAPlatformPanelBodyInAutomationTest"));
        commonProcess.checkElementVisible(methods.getBy("selectAPlatformPanelBodyWithPlatformsInAutomationTest"));
        commonProcess.checkElementVisible(methods.getBy("operatingSystemAreaInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("browserAreaInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("versionAreaInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("testCodeGeneratorTabInAutomationTest"));
        commonProcess.checkElementVisible(methods.getBy("operationReportTabInAutomationTest"));
        commonProcess.checkElementVisible(methods.getBy("takeScreenshotSwitchInAutomatedTest"));
        commonProcess.checkElementVisible(methods.getBy("recordVideoSwitchInAutomatedTest"));
        commonProcess.checkElementVisible(methods.getBy("screenResolutionSelectInAutomatedTest"));
        commonProcess.checkElementVisible(methods.getBy("testCodeScriptTabContentInAutomatedTest"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Projects_Tab() {

        By projectsTabBy = methods.getBy("projectsTab");
        commonProcess.checkElementVisible(projectsTabBy);
        commonProcess.scrollElementCenter(projectsTabBy);
        commonProcess.clickButton(projectsTabBy);
    }

    public void e_Click_Dashboard_Create_Button() {

        By dashboardCreateButtonBy = methods.getBy("dashboardCreateButton");
        commonProcess.checkElementVisible(dashboardCreateButtonBy);
        commonProcess.scrollElementCenter(dashboardCreateButtonBy);
        commonProcess.clickButton(dashboardCreateButtonBy);
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

    /**
     * TODO: user account
     */
    public void v_Verify_User_Account_Info() {

    }

    public void e_Click_Reports_Tab() {

        By reportsTabBy = methods.getBy("reportsTab");
        commonProcess.checkElementVisible(reportsTabBy);
        commonProcess.scrollElementCenter(reportsTabBy);
        commonProcess.clickButton(reportsTabBy);
    }

    public void e_Click_All_Suites_Tab() {

        By allSuitesTabBy = methods.getBy("allSuitesTab");
        commonProcess.checkElementVisible(allSuitesTabBy);
        commonProcess.scrollElementCenter(allSuitesTabBy);
        commonProcess.clickButton(allSuitesTabBy);
    }

    /**
     * TODO: verify company
     */
    public void v_Verify_Changed_Company() {

    }

    /**
     * TODO: user account
     */
    public void e_Click_User_Account_Info() {

    }

    public void e_Click_Dashboard_Button() {

        By dashboardButtonBy = methods.getBy("dashboardButton");
        commonProcess.checkElementVisible(dashboardButtonBy);
        commonProcess.scrollElementCenter(dashboardButtonBy);
        commonProcess.clickButton(dashboardButtonBy);
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

    public void e_Click_Details() {

        By reportTableElementBy = methods.getBy("reportsTableElementsInDashboard");
        By reportDetailInDashboardBy = methods.getBy("reportDetailInDashboard");
        commonProcess.checkElementVisible(reportTableElementBy);
        commonProcess.clickButton(reportDetailInDashboardBy);
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
