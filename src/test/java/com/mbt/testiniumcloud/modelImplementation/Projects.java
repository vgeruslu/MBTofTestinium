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
public class Projects extends ExecutionContext implements org.graphwalker.Projects {

    private static final Logger logger = LogManager.getLogger(Projects.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public Projects() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(Projects.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void e_Click_No_Button() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        commonProcess.clickButton(noButtonBy);
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
        commonProcess.checkElementVisible(methods.getBy("selectSourceFilePanelInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("selectTestMethodsPanelInCreateScenario"));
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

    public void e_Click_Yes_Button() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        commonProcess.clickButton(yesButtonBy);
    }

    public void v_Control_Drop_Down_Elements() {

        By addAScenariosBy = commonProcess.getKeyValueChangerElement("addAScenarioWithSelectedProjectInProjects",
                "addAScenarioWithSelectedProject1InProjects", String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(addAScenariosBy);
        By addAPlanBy = commonProcess.getKeyValueChangerElement("addAPlanWithSelectedProjectInProjects",
                "addAPlanWithSelectedProject1InProjects", String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(addAPlanBy);
    }

    public void e_Click_Create_New_Project() {

        By createProjectPanelBy = methods.getBy("createProjectPanelInProjects");
        commonProcess.clickButton(createProjectPanelBy);
    }

    public void v_Verify_In_Create_Project_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/project/create",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("logoTitleInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("projectNameInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("gitProjectFolderNameInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInCreateProject"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Project_Suites() {

        methodsUtil.putValueInTestMap("currentProject", methodsUtil.getValueInTestMap("editProject"));
        By suitesButtonBy = commonProcess.getKeyValueChangerElement("suitesButtonWithSelectedProjectInProjects",
               "suitesButtonWithSelectedProject1InProjects", String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.clickButton(suitesButtonBy);
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

    public void e_No_action() {

    }

    public void e_Click_Add_Scenario() {

        By addAScenariosBy = commonProcess.getKeyValueChangerElement("addAScenarioWithSelectedProjectInProjects",
               "addAScenarioWithSelectedProject1InProjects", String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(addAScenariosBy);
        commonProcess.checkElementClickable(addAScenariosBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(addAScenariosBy);
        methodsUtil.putValueInTestMap("projectSelectedForScenario",true);
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

        methodsUtil.putValueInTestMap("currentProject", methodsUtil.getValueInTestMap("optionalProject").toString());
    }

    public void v_Verify_In_Project_Detail_Suites_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",75,"startWith"));
        assertTrue(methods.doesUrl("/plans",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailSuites"
                ,"logoWithProjectName1InProjectDetailSuites", String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
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
    }

    public void v_Verify_Project_Is_Available() {

        By projectBy = commonProcess.getKeyValueChangerElement("projectPanelProjectNameKeyValueInProjects",
                "projectPanelProjectNameKeyValue1InProjects", String.valueOf(methodsUtil.getValueInTestMap("deleteProjectName")));
        assertTrue(methods.isElementVisible(projectBy,30));
    }

    public void e_no_Action() {

    }

    public void v_Control_Are_You_Sure_Message() {

        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitByMilliSeconds(500);
    }

    public void e_Click_Project_Scenarios() {

        methodsUtil.putValueInTestMap("currentProject",methodsUtil.getValueInTestMap("editProject"));
        By scenariosButtonBy = commonProcess.getKeyValueChangerElement("scenariosButtonWithSelectedProjectInProjects",
                "scenariosButtonWithSelectedProject1InProjects", String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.clickButton(scenariosButtonBy);
    }

    public void e_Click_Delete() {

        methodsUtil.waitByMilliSeconds(300);
        // ignore project name for delete
        By deleteProjectNameBy = commonProcess.getKeyValueChangerElement("deleteProjectNameInProjects","deleteProjectName1InProjects",
                methodsUtil.getValueInTestMap("runProject")
                        + "!!" + methodsUtil.getValueInTestMap("optionalProject")
                        + "!!" + methodsUtil.getValueInTestMap("editProject")
                        + "!!" + methodsUtil.getValueInTestMap("appiumProject")
                        + "!!" + methodsUtil.getValueInTestMap("ignoreDeleteProjectNameContain"));
        commonProcess.checkElementVisible(deleteProjectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        String projectName = methods.getText(deleteProjectNameBy).trim();
        By projectBy = commonProcess.getKeyValueChangerElement("projectPanelProjectNameKeyValueInProjects","projectPanelProjectNameKeyValue1InProjects", projectName);
        commonProcess.checkElementVisible(projectBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementJs(projectBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(projectBy);
        By dropdownTridotButtonBy = commonProcess.getKeyValueChangerElement("dropdownTridotWithSelectedProjectInProjects","dropdownTridotWithSelectedProject1InProjects", projectName);
        commonProcess.clickButton(dropdownTridotButtonBy);
        By deleteButtonBy = commonProcess.getKeyValueChangerElement("deleteButtonWithSelectedProjectInProjects","deleteButtonWithSelectedProject1InProjects", projectName);
        commonProcess.clickButton(deleteButtonBy);
        methodsUtil.putValueInTestMap("deleteProjectName", projectName);
    }

    public void e_Click_Project_Plus_Button() {

        By projectBy = commonProcess.getKeyValueChangerElement("projectPanelProjectNameKeyValueInProjects","projectPanelProjectNameKeyValue1InProjects",
                String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(projectBy);
        commonProcess.scrollElementCenter(projectBy);
        By projectsTabBy = commonProcess.getKeyValueChangerElement("dropdownPlusButtonWithSelectedProjectInProjects","dropdownPlusButtonWithSelectedProject1InProjects",
                String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
       commonProcess.clickButton(projectsTabBy);
    }

    public void v_Verify_In_Project_Detail_Summary_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        assertTrue(methods.doesUrl("/summary",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailSummary"
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
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
         */
    }

    public void v_Verify_In_Project_Detail_Scenarios_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",75,"startWith"));
        assertTrue(methods.doesUrl("/scenarios",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailScenarios","logoWithProjectName1InProjectDetailScenarios"
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
    }

    public void v_Verify_Project_Is_Not_Available() {

        By projectBy = commonProcess.getKeyValueChangerElement("projectPanelProjectNameKeyValueInProjects","projectPanelProjectNameKeyValue1InProjects",
                String.valueOf(methodsUtil.getValueInTestMap("deleteProjectName")));
        assertTrue(methods.isElementInVisible(projectBy,30));
    }

    public void e_Click_Project_Summary() {

        methodsUtil.putValueInTestMap("currentProject",methodsUtil.getValueInTestMap("editProject"));
        By summaryButtonBy = commonProcess.getKeyValueChangerElement("summaryButtonWithSelectedProjectInProjects","summaryButtonWithSelectedProject1InProjects",
                String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.clickButton(summaryButtonBy);
    }

    public void e_Click_Add_Suite() {

        By addAPlanBy = commonProcess.getKeyValueChangerElement("addAPlanWithSelectedProjectInProjects",
                "addAPlanWithSelectedProject1InProjects",String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.clickButton(addAPlanBy);
        methodsUtil.putValueInTestMap("projectSelectedForPlan",true);
    }
}
