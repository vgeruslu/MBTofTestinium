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
import org.graalvm.polyglot.Value;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class ProjectDetailSummary extends ExecutionContext implements org.graphwalker.Project_Detail_Summary {

    private static final Logger logger = LogManager.getLogger(ProjectDetailSummary.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public ProjectDetailSummary() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        methodsUtil.putValueInTestMap("controlProjectDetailSummary",false);
        Configurator.setLevel(getLogger(ProjectDetailSummary.class), Level.toLevel(Driver.modelImplLogLevel));
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

        By suiteNameBy = commonProcess.getKeyValueChangerElement("suiteNameInProjectDetailSummary","suiteNameInProjectDetailSummary1","1");
        commonProcess.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String planName = methods.getText(suiteNameBy).trim();
        By runSuiteBy = commonProcess.getKeyValueChangerElement("runSuiteWithSuiteNameInProjectDetailSummary","runSuiteWithSuiteNameInProjectDetailSummary1", planName);
        commonProcess.clickButton(runSuiteBy);
        methodsUtil.putValueInTestMap("currentPlan", planName);
    }

    public void e_Click_Project_Detail_Suites_Tab() {

        By suitesTabBy = methods.getBy("suitesTabInProjectDetail");
        commonProcess.clickButton(suitesTabBy);
        methodsUtil.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_Verify_Suite_Is_Available() {

        By dropDownSuiteBy = commonProcess.getKeyValueChangerElement("dropDownSuiteWithSuiteNameInProjectDetailSummary"
                ,"dropDownSuiteWithSuiteName1InProjectDetailSummary", methodsUtil.getValueInTestMap("currentPlan").toString());
        commonProcess.checkElementVisible(dropDownSuiteBy);
    }

    public void e_Click_Project_Detail_Scenarios_Tab() {

        By scenariosTabBy = methods.getBy("scenariosTabInProjectDetail");
        commonProcess.clickButton(scenariosTabBy);
        methodsUtil.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/plan/create",
                75,"startWith"));
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
         */
    }

    public void v_Verify_In_Project_Detail_Suites_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        assertTrue(methods.doesUrl("/plans",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailSuites"
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
        commonProcess.checkElementVisible(methods.getBy("fromInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("toInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("runningTestCheckboxInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("failedOnesInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("tableInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_Verify_In_Projects_Page_SHARED() {

        /**
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
         */
    }

    public void v_Control_Drop_Down_Menu() {

        By editDropDownBy = commonProcess.getKeyValueChangerElement("editDropDownSuiteWithSuiteNameInProjectDetailSummary"
                ,"editDropDownSuiteWithSuiteName1InProjectDetailSummary", String.valueOf(methodsUtil.getValueInTestMap("currentPlan")));
        By deleteDropDownBy = commonProcess.getKeyValueChangerElement("deleteDropDownSuiteWithSuiteNameInProjectDetailSummary"
                ,"deleteDropDownSuiteWithSuiteName1InProjectDetailSummary", String.valueOf(methodsUtil.getValueInTestMap("currentPlan")));
        commonProcess.checkElementVisible(editDropDownBy);
        commonProcess.checkElementVisible(deleteDropDownBy);
    }

    public void e_Click_Properties() {

        By propertiesTabBy = methods.getBy("propertiesTabInProjectDetail");
        commonProcess.clickButton(propertiesTabBy);
        methodsUtil.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_Control_Are_You_Sure_Message() {

        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
    }

    public void e_Click_Delete() {

        By suiteNameBy = commonProcess.getKeyValueChangerElement("suiteNameInProjectDetailSummary","suiteNameInProjectDetailSummary1","last()");
        commonProcess.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String planName = methods.getText(suiteNameBy).trim();
        By deleteDropDownBy = commonProcess.getKeyValueChangerElement("deleteDropDownSuiteWithSuiteNameInProjectDetailSummary"
                ,"deleteDropDownSuiteWithSuiteName1InProjectDetailSummary", planName);
        commonProcess.clickButton(deleteDropDownBy);
        methodsUtil.putValueInTestMap("currentPlan", planName);
        methodsUtil.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_control_Are_You_Sure_Message() {

        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
    }

    public void e_No_Action() {

    }

    public void v_Verify_Suite_Is_Not_Running() {

        methodsUtil.waitByMilliSeconds(200);
        assertTrue(methods.isElementInVisible(methods.getBy("TestRunSuccessfullStarted"),30));
    }

    public void e_Click_Projects_Tab() {

        By projectsTabBy = methods.getBy("projectsTab");
        commonProcess.clickButton(projectsTabBy);
        methodsUtil.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void e_Click_Summary() {

        By summaryTabBy = methods.getBy("summaryTabInProjectDetail");
        commonProcess.clickButton(summaryTabBy);
    }

    public void e_No_action() {

    }

    public void e_no_Action() {

    }

    public void e_Click_Suite_Drop_Down() {

        By suiteNameBy = commonProcess.getKeyValueChangerElement("suiteNameInProjectDetailSummary","suiteNameInProjectDetailSummary1","last()");
        commonProcess.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String planName = methods.getText(suiteNameBy).trim();
        By dropDownSuiteBy = commonProcess.getKeyValueChangerElement("dropDownSuiteWithSuiteNameInProjectDetailSummary","dropDownSuiteWithSuiteName1InProjectDetailSummary", planName);
        commonProcess.clickButton(dropDownSuiteBy);
        methodsUtil.putValueInTestMap("currentPlan", planName);
    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        commonProcess.clickButton(noButtonBy);
    }

    public void e_click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        commonProcess.clickButton(noButtonBy);
    }

    public void e_Click_Create_New_Suite_Panel() {

        By createNewSuitePanelBy = methods.getBy("createNewSuitePanelInProjectDetailSummary");
        commonProcess.clickButton(createNewSuitePanelBy);
        methodsUtil.putValueInTestMap("projectSelectedForPlan",true);
        methodsUtil.putValueInTestMap("controlProjectDetailSummary",false);
    }

    public void v_Verify_In_Project_Detail_Summary_Page_SHARED() {

        logger.info(getAttribute("hasProjectAPlan").toString());
        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",75,"startWith"));
        assertTrue(methods.doesUrl("/summary",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailSummary"
                ,"logoWithProjectName1InProjectDetailSummary", String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
        commonProcess.checkElementVisible(methods.getBy("createNewSuitePanelInProjectDetailSummary"));
        commonProcess.checkElementVisible(methods.getBy("latestSuiteRunsTableWithTextInProjectDetailSummary"));
        commonProcess.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));

        if(!Boolean.parseBoolean(methodsUtil.getValueInTestMap("controlProjectDetailSummary").toString())) {
            if (methods.isElementVisible(methods.getBy("suiteInProjectDetailSummary"), 2)) {
                logger.info("element görünür");
                commonProcess.checkElementVisible(methods.getBy("dropDownSuiteInProjectDetailSummary"));
                commonProcess.checkElementVisible(methods.getBy("reportSuiteInProjectDetailSummary"));
                commonProcess.checkElementVisible(methods.getBy("runSuiteInProjectDetailSummary"));
                setAttribute("hasProjectAPlan", Value.asValue(true));
            } else {
                setAttribute("hasProjectAPlan", Value.asValue(false));
            }
            methodsUtil.putValueInTestMap("controlProjectDetailSummary", true);
        }
        logger.info(getAttribute("hasProjectAPlan").toString());
    }

    public void v_Verify_In_Project_Detail_Scenarios_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        assertTrue(methods.doesUrl("/scenarios",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailScenarios"
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
        commonProcess.checkElementVisible(methods.getBy("exportTableInProjectDetailScenarios"));
        commonProcess.checkElementVisible(methods.getBy("suitesSelectInProjectDetailScenarios"));
        commonProcess.checkElementVisible(methods.getBy("tableInProjectDetailScenarios"));
        commonProcess.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_Verify_In_Project_Detail_Properties_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailProperties"
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
        commonProcess.checkElementVisible(methods.getBy("projectNameInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("testFrameworkInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("testFileTypeInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("testRunnerToolInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("gitProjectFolderNameInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("gitBranchOrTagsInProjectDetailProperties"));
       // commonProcess.checkElementVisible(methods.getBy("enableCheckboxInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("applyButtonInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_no_action() {

    }
}
