package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.methods.MethodsUtil;
import com.mbt.testiniumcloud.utils.CoverageValue;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.SharedNodeControl;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class Dashboard extends ExecutionContext implements org.graphwalker.Dashboard {

    private static final Logger logger = LogManager.getLogger(Dashboard.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public Dashboard() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
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

    public void v_Verify_In_Reports_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report/detail/",75,"notStartWith"));
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report",75,"startWith"));
        /**
         methodsUtil.waitByMilliSeconds(300);
         String currentUrl = methods.getCurrentUrl().trim();
         logger.info(currentUrl);
         Assert.assertTrue("", currentUrl.equals("https://testinium.io/report")
         || currentUrl.startsWith("https://testinium.io/report/project/")
         || currentUrl.startsWith("https://testinium.io/report/plan/"));
         */
        methods.checkElementVisible(methods.getBy("reportsLogoTitleInReports"));
        methods.checkElementVisible(methods.getBy("createButtonInReports"));
        methods.checkElementVisible(methods.getBy("exportTableInReports"));
        methods.checkElementVisible(methods.getBy("projectsInReports"));
        methods.checkElementVisible(methods.getBy("suitesInReports"));
        methods.checkElementVisible(methods.getBy("dateFromInReports"));
        methods.checkElementVisible(methods.getBy("dateToInReports"));
        methods.checkElementVisible(methods.getBy("showOnlyFailedTestsInReports"));
        methods.checkElementVisible(methods.getBy("tableContainInReports"));
        methods.checkElementVisible(methods.getBy("tableCheckboxInReports"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void v_Verify_In_Create_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/create",75,"equal"));
        methods.checkElementVisible(methods.getBy("panelBodyCreateInCreatePage"));
        methods.checkElementVisible(methods.getBy("panelBodyDefineInCreatePage"));
        methods.checkElementVisible(methods.getBy("panelBodyArrangeInCreatePage"));
        methods.checkElementVisible(methods.getBy("createButtonInCreatePage"));
        methods.checkElementVisible(methods.getBy("createNewProjectInCreatePage"));
        methods.checkElementVisible(methods.getBy("seeYourProjectInCreatePage"));
        methods.checkElementVisible(methods.getBy("createScenarioInCreatePage"));
        methods.checkElementVisible(methods.getBy("seeYourScenariosInCreatePage"));
        methods.checkElementVisible(methods.getBy("createPlanInCreatePage"));
        methods.checkElementVisible(methods.getBy("seeYourPlansInCreatePage"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
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

    public void e_Click_Automated_Test_Tab() {

        By automatedTestTabBy = methods.getBy("automatedTestTab");
        methods.checkElementVisible(automatedTestTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(automatedTestTabBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(automatedTestTabBy);
        methods.clickElement(automatedTestTabBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Dashboard_Page_SHARED() {

        //https://testinium.io/home?code=
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
        methods.checkElementVisible(allScenariosTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(allScenariosTabBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(allScenariosTabBy);
        methods.clickElement(allScenariosTabBy);
    }

    /**
     * TODO: user profile
     */
    public void e_Click_User_Profile() {

    }

    public void v_Verify_In_Automated_Test_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/automated/code-generator",75,"equal"));
        methods.checkElementVisible(methods.getBy("automatedTestCodeGeneratorLogoTitleInAutomatedTest"));
        methods.checkElementVisible(methods.getBy("createButtonInAutomatedTest"));
        methods.checkElementVisible(methods.getBy("selectAPlatformPanelBodyInAutomationTest"));
        methods.checkElementVisible(methods.getBy("selectAPlatformPanelBodyWithPlatformsInAutomationTest"));
        methods.checkElementVisible(methods.getBy("operatingSystemAreaInCreatePlan"));
        methods.checkElementVisible(methods.getBy("browserAreaInCreatePlan"));
        methods.checkElementVisible(methods.getBy("versionAreaInCreatePlan"));
        methods.checkElementVisible(methods.getBy("testCodeGeneratorTabInAutomationTest"));
        methods.checkElementVisible(methods.getBy("operationReportTabInAutomationTest"));
        methods.checkElementVisible(methods.getBy("takeScreenshotSwitchInAutomatedTest"));
        methods.checkElementVisible(methods.getBy("recordVideoSwitchInAutomatedTest"));
        methods.checkElementVisible(methods.getBy("screenResolutionSelectInAutomatedTest"));
        methods.checkElementVisible(methods.getBy("testCodeScriptTabContentInAutomatedTest"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Projects_Tab() {

        By projectsTabBy = methods.getBy("projectsTab");
        methods.checkElementVisible(projectsTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(projectsTabBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(projectsTabBy);
        methods.clickElement(projectsTabBy);
    }

    public void e_Click_Dashboard_Create_Button() {

        By dashboardCreateButtonBy = methods.getBy("dashboardCreateButton");
        methods.checkElementVisible(dashboardCreateButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(dashboardCreateButtonBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(dashboardCreateButtonBy);
        methods.clickElement(dashboardCreateButtonBy);
    }

    public void v_Verify_In_Projects_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project",75,"equal"));
        methods.checkElementVisible(methods.getBy("projectsLogoTitleInProjects"));
        methods.checkElementVisible(methods.getBy("projectPanelInProjects"));
        methods.checkElementVisible(methods.getBy("createProjectPanelInProjects"));
        methods.checkElementVisible(methods.getBy("createProjectInProjects"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    /**
     * TODO: user account
     */
    public void v_Verify_User_Account_Info() {

    }

    public void e_Click_Reports_Tab() {

        By reportsTabBy = methods.getBy("reportsTab");
        methods.checkElementVisible(reportsTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(reportsTabBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(reportsTabBy);
        methods.clickElement(reportsTabBy);
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
        methods.checkElementVisible(dashboardButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(dashboardButtonBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(dashboardButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(dashboardButtonBy);
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

    public void e_Click_Details() {

        By reportTableElementBy = methods.getBy("reportsTableElementsInDashboard");
        By reportDetailInDashboardBy = methods.getBy("reportDetailInDashboard");
        methods.checkElementVisible(reportTableElementBy);
        methods.checkElementVisible(reportDetailInDashboardBy);
        methodsUtil.waitBySeconds(1);
        methods.isElementEnabled(reportTableElementBy,30);
        //methods.scrollElementCenterWithJs(reportTableElementBy);
        methodsUtil.waitBySeconds(1);
        //methods.checkElementVisible(reportDetailInDashboardBy);
        //methodsUtil.waitByMilliSeconds(500);
        methods.isElementEnabled(reportDetailInDashboardBy,30);
        methods.checkElementClickable(reportDetailInDashboardBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElementForStaleElement(reportDetailInDashboardBy);
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
