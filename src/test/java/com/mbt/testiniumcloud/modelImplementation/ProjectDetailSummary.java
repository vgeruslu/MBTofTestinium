package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.methods.MethodsUtil;
import com.mbt.testiniumcloud.utils.CoverageValue;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.SharedNodeControl;
import org.graalvm.polyglot.Value;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class ProjectDetailSummary extends ExecutionContext implements org.graphwalker.Project_Detail_Summary {

    private static final Logger logger = LogManager.getLogger(ProjectDetailSummary.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public ProjectDetailSummary() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
        methods.putValueInTestMap("controlProjectDetailSummary",false);
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

    public void e_Click_Run_Suite() {

        By suiteNameBy = methods.getByWithKeySetValue("suiteNameInProjectDetailSummary","1");
        methods.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String planName = methods.getText(suiteNameBy).trim();
        By runSuiteBy = methods.getByWithKeySetValue("runSuiteWithSuiteNameInProjectDetailSummary", planName);
        methods.checkElementVisible(runSuiteBy);
        methods.checkElementClickable(runSuiteBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(runSuiteBy);
        methods.putValueInTestMap("currentPlan", planName);
    }

    public void e_Click_Project_Detail_Suites_Tab() {

        By suitesTabBy = methods.getBy("suitesTabInProjectDetail");
        methods.checkElementVisible(suitesTabBy);
        methods.checkElementClickable(suitesTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(suitesTabBy);
        methods.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_Verify_Suite_Is_Available() {

        By dropDownSuiteBy = methods.getByWithKeySetValue("dropDownSuiteWithSuiteNameInProjectDetailSummary"
                , methods.getValueInTestMap("currentPlan").toString());
        methods.checkElementVisible(dropDownSuiteBy);
    }

    public void e_Click_Project_Detail_Scenarios_Tab() {

        By scenariosTabBy = methods.getBy("scenariosTabInProjectDetail");
        methods.checkElementVisible(scenariosTabBy);
        methods.checkElementClickable(scenariosTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(scenariosTabBy);
        methods.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/create",
                75,"startWith"));
        methods.checkElementVisible(methods.getBy("logoInCreatePlan"));
        methods.checkElementVisible(methods.getBy("projectNameInCreatePlan"));
        methods.checkElementVisible(methods.getBy("suiteNameInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        methods.checkElementVisible(methods.getBy("cancelButtonInCreatePlan"));
        methods.checkElementVisible(methods.getBy("saveButtonInCreatePlan"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_Verify_In_Project_Detail_Suites_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/plans",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoWithProjectNameInProjectDetailSuites"
                , String.valueOf(methods.getValueInTestMap("currentProject"))));
        methods.checkElementVisible(methods.getBy("fromInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("toInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("runningTestCheckboxInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("failedOnesInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("tableInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_Verify_In_Projects_Page_SHARED() {

        /**
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
         */
    }

    public void v_Control_Drop_Down_Menu() {

        By editDropDownBy = methods.getByWithKeySetValue("editDropDownSuiteWithSuiteNameInProjectDetailSummary"
                , String.valueOf(methods.getValueInTestMap("currentPlan")));
        By deleteDropDownBy = methods.getByWithKeySetValue("deleteDropDownSuiteWithSuiteNameInProjectDetailSummary"
                , String.valueOf(methods.getValueInTestMap("currentPlan")));
        methods.checkElementVisible(editDropDownBy);
        methods.checkElementVisible(deleteDropDownBy);
    }

    public void e_Click_Properties() {

        By propertiesTabBy = methods.getBy("propertiesTabInProjectDetail");
        methods.checkElementVisible(propertiesTabBy);
        methods.checkElementClickable(propertiesTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(propertiesTabBy);
        methods.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_Control_Are_You_Sure_Message() {

        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
    }

    public void e_Click_Delete() {

        By suiteNameBy = methods.getByWithKeySetValue("suiteNameInProjectDetailSummary", "last()");
        methods.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String planName = methods.getText(suiteNameBy).trim();
        By deleteDropDownBy = methods.getByWithKeySetValue("deleteDropDownSuiteWithSuiteNameInProjectDetailSummary"
                , planName);
        methods.checkElementClickable(deleteDropDownBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(deleteDropDownBy);
        methods.putValueInTestMap("currentPlan", planName);
        methods.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_control_Are_You_Sure_Message() {

        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
    }

    public void e_No_Action() {

    }

    public void v_Verify_Suite_Is_Not_Running() {

        methodsUtil.waitByMilliSeconds(200);
        Assert.assertTrue("Hata", methods
                .isElementInVisible(methods.getBy("TestRunSuccessfullStarted"),30));
    }

    public void e_Click_Projects_Tab() {

        By projectsTabBy = methods.getBy("projectsTab");
        methods.checkElementVisible(projectsTabBy);
        methods.checkElementClickable(projectsTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(projectsTabBy);
        methods.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void e_Click_Summary() {

        By summaryTabBy = methods.getBy("summaryTabInProjectDetail");
        methods.checkElementVisible(summaryTabBy);
        methods.checkElementClickable(summaryTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(summaryTabBy);
    }

    public void e_No_action() {

    }

    public void e_no_Action() {

    }

    public void e_Click_Suite_Drop_Down() {

        By suiteNameBy = methods.getByWithKeySetValue("suiteNameInProjectDetailSummary","last()");
        methods.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String planName = methods.getText(suiteNameBy).trim();
        By dropDownSuiteBy = methods.getByWithKeySetValue("dropDownSuiteWithSuiteNameInProjectDetailSummary", planName);
        methods.checkElementVisible(dropDownSuiteBy);
        methods.checkElementClickable(dropDownSuiteBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(dropDownSuiteBy);
        methods.putValueInTestMap("currentPlan", planName);
    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methods.checkElementClickable(noButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void e_click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methods.checkElementClickable(noButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void e_Click_Create_New_Suite_Panel() {

        By createNewSuitePanelBy = methods.getBy("createNewSuitePanelInProjectDetailSummary");
        methods.checkElementVisible(createNewSuitePanelBy);
        methods.checkElementClickable(createNewSuitePanelBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(createNewSuitePanelBy);
        methods.putValueInTestMap("projectSelectedForPlan",true);
        methods.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_Verify_In_Project_Detail_Summary_Page_SHARED() {

        logger.info(getAttribute("hasProjectAPlan").toString());
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/summary",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoWithProjectNameInProjectDetailSummary"
                , String.valueOf(methods.getValueInTestMap("currentProject"))));
        methods.checkElementVisible(methods.getBy("createNewSuitePanelInProjectDetailSummary"));
        methods.checkElementVisible(methods.getBy("latestSuiteRunsTableWithTextInProjectDetailSummary"));
        methods.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));

        if(!Boolean.parseBoolean(methods.getValueInTestMap("controlProjectDetailSummary").toString())) {
            if (methods.isElementVisible(methods.getBy("suiteInProjectDetailSummary"), 2)) {
                logger.info("element görünür");
                methods.checkElementVisible(methods.getBy("dropDownSuiteInProjectDetailSummary"));
                methods.checkElementVisible(methods.getBy("reportSuiteInProjectDetailSummary"));
                methods.checkElementVisible(methods.getBy("runSuiteInProjectDetailSummary"));
                setAttribute("hasProjectAPlan", Value.asValue(true));
            } else {
                setAttribute("hasProjectAPlan", Value.asValue(false));
            }
            methods.putValueInTestMap("controlProjectDetailSummary", true);
        }
        logger.info(getAttribute("hasProjectAPlan").toString());
    }

    public void v_Verify_In_Project_Detail_Scenarios_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/scenarios",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoWithProjectNameInProjectDetailScenarios"
                , String.valueOf(methods.getValueInTestMap("currentProject"))));
        methods.checkElementVisible(methods.getBy("exportTableInProjectDetailScenarios"));
        methods.checkElementVisible(methods.getBy("suitesSelectInProjectDetailScenarios"));
        methods.checkElementVisible(methods.getBy("tableInProjectDetailScenarios"));
        methods.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_Verify_In_Project_Detail_Properties_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/properties",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoWithProjectNameInProjectDetailProperties"
                , String.valueOf(methods.getValueInTestMap("currentProject"))));
        methods.checkElementVisible(methods.getBy("projectNameInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("testFrameworkInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("testFileTypeInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("testRunnerToolInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("gitProjectFolderNameInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("gitBranchOrTagsInProjectDetailProperties"));
       // methods.checkElementVisible(methods.getBy("enableCheckboxInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("cancelButtonInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("applyButtonInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("saveButtonInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_no_action() {

    }
}
