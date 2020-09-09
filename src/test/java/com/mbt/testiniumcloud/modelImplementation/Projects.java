package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.utils.CoverageValue;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class Projects extends ExecutionContext implements org.graphwalker.Projects {

    private static final Logger logger = LoggerFactory.getLogger(Projects.class);
    Methods methods;
    ExcelMapData excelMapData;

    public Projects() {

        methods = new Methods();
        excelMapData = new ExcelMapData();
    }

    @BeforeExecution
    public void setup() {

    }

    @AfterExecution
    public void cleanup() {

    }

    @BeforeElement
    public void beforeElement() {

        excelMapData.setBeforeElementData(getModel().getName().trim()
                , getCurrentElement().getId().trim(), getCurrentElement().getName().trim());
        logger.info("═════════  " + getCurrentElement().getName() + "   " + getModel().getName() + "  ═════════");
    }

    @AfterElement
    public void afterElement() {

        logger.info(getCurrentElement() instanceof Edge.RuntimeEdge ? "Edge" : "Vertex");
        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    public void e_Click_No_Button() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methods.checkElementClickable(noButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void v_Verify_In_Create_Scenario_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario/create",
                75,"startWith"));
        methods.checkElementVisible(methods.getBy("logoInCreateScenario"));
        methods.checkElementVisible(methods.getBy("projectNameInCreateScenario"));
        methods.checkElementVisible(methods.getBy("scenarioNameInCreateScenario"));
        methods.checkElementVisible(methods.getBy("scenarioDescriptionInCreateScenario"));
        methods.checkElementVisible(methods.getBy("selectGroupInCreateScenario"));
        methods.checkElementVisible(methods.getBy("selectMaxExecutionTimeInCreateScenario"));
        methods.checkElementVisible(methods.getBy("javaParameterNameInCreateScenario"));
        methods.checkElementVisible(methods.getBy("javaParameterValueInCreateScenario"));
        methods.checkElementVisible(methods.getBy("selectSourceFilePanelInCreateScenario"));
        methods.checkElementVisible(methods.getBy("selectTestMethodsPanelInCreateScenario"));
        methods.checkElementVisible(methods.getBy("copyButtonInCreateScenario"));
        methods.checkElementVisible(methods.getBy("cancelButtonInCreateScenario"));
        methods.checkElementVisible(methods.getBy("saveButtonInCreateScenario"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Yes_Button() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        methods.checkElementVisible(yesButtonBy);
        methods.checkElementClickable(yesButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(yesButtonBy);
    }

    public void v_Control_Drop_Down_Elements() {

        By addAScenariosBy = methods.getByWithKeySetValue("addAScenarioWithSelectedProjectInProjects",
                String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(addAScenariosBy);
        By addAPlanBy = methods.getByWithKeySetValue("addAPlanWithSelectedProjectInProjects",
                String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(addAPlanBy);
    }

    public void e_Click_Create_New_Project() {

        By createProjectPanelBy = methods.getBy("createProjectPanelInProjects");
        methods.checkElementVisible(createProjectPanelBy);
        methods.checkElementClickable(createProjectPanelBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(createProjectPanelBy);
    }

    public void v_Verify_In_Create_Project_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/create",
                75,"equal"));
        methods.checkElementVisible(methods.getBy("logoTitleInCreateProject"));
        methods.checkElementVisible(methods.getBy("projectNameInCreateProject"));
        methods.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        methods.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        methods.checkElementVisible(methods.getBy("gitProjectFolderNameInCreateProject"));
        methods.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        methods.checkElementVisible(methods.getBy("cancelButtonInCreateProject"));
        methods.checkElementVisible(methods.getBy("saveButtonInCreateProject"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Project_Suites() {

        methods.putValueInTestMap("currentProject", methods.getValueInTestMap("editProject"));
        By suitesButtonBy = methods.getByWithKeySetValue("suitesButtonWithSelectedProjectInProjects",
                String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(suitesButtonBy);
        methods.checkElementClickable(suitesButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(suitesButtonBy);
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

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
    }

    public void e_No_action() {

    }

    public void e_Click_Add_Scenario() {

        By addAScenariosBy = methods.getByWithKeySetValue("addAScenarioWithSelectedProjectInProjects",
                String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(addAScenariosBy);
        methods.checkElementClickable(addAScenariosBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(addAScenariosBy);
        methods.putValueInTestMap("projectSelectedForScenario",true);
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

        methods.putValueInTestMap("currentProject", methods.getValueInTestMap("optionalProject").toString());
    }

    public void v_Verify_In_Project_Detail_Suites_Page_SHARED() {

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
    }

    public void v_Verify_Project_Is_Available() {

        By projectBy = methods.getByWithKeySetValue("projectPanelProjectNameKeyValueInProjects",
                String.valueOf(methods.getValueInTestMap("deleteProjectName")));
        Assert.assertTrue("", methods.isElementVisible(projectBy,30));
    }

    public void e_no_Action() {

    }

    public void v_Control_Are_You_Sure_Message() {

        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methods.waitByMilliSeconds(500);
    }

    public void e_Click_Project_Scenarios() {

        methods.putValueInTestMap("currentProject",methods.getValueInTestMap("editProject"));
        By scenariosButtonBy = methods.getByWithKeySetValue("scenariosButtonWithSelectedProjectInProjects",
                String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(scenariosButtonBy);
        methods.checkElementClickable(scenariosButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(scenariosButtonBy);
    }

    public void e_Click_Delete() {

        methods.waitByMilliSeconds(300);
        // ignore project name for delete
        By deleteProjectNameBy = methods.getByWithKeySetValue("deleteProjectNameInProjects",
                methods.getValueInTestMap("runProject")
                        + "!!" + methods.getValueInTestMap("optionalProject")
                        + "!!" + methods.getValueInTestMap("editProject")
                        + "!!" + methods.getValueInTestMap("appiumProject")
                        + "!!" + methods.getValueInTestMap("ignoreDeleteProjectNameContain"));
        methods.checkElementVisible(deleteProjectNameBy);
        methods.waitByMilliSeconds(300);
        String projectName = methods.getText(deleteProjectNameBy).trim();
        By projectBy = methods.getByWithKeySetValue("projectPanelProjectNameKeyValueInProjects",
                projectName);
        methods.checkElementVisible(projectBy);
        methods.waitByMilliSeconds(500);
        methods.scrollElement(projectBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(projectBy);
        By dropdownTridotButtonBy = methods.getByWithKeySetValue("dropdownTridotWithSelectedProjectInProjects",
                projectName);
        methods.checkElementVisible(dropdownTridotButtonBy);
        methods.checkElementClickable(dropdownTridotButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(dropdownTridotButtonBy);
        By deleteButtonBy = methods.getByWithKeySetValue("deleteButtonWithSelectedProjectInProjects",
                projectName);
        methods.checkElementVisible(deleteButtonBy);
        methods.checkElementClickable(deleteButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(deleteButtonBy);
        methods.putValueInTestMap("deleteProjectName", projectName);
    }

    public void e_Click_Project_Plus_Button() {

        By projectBy = methods.getByWithKeySetValue("projectPanelProjectNameKeyValueInProjects",
                String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(projectBy);
        methods.scrollElement(projectBy);
        By projectsTabBy = methods.getByWithKeySetValue("dropdownPlusButtonWithSelectedProjectInProjects",
                String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(projectsTabBy);
        methods.checkElementClickable(projectsTabBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(projectsTabBy);
    }

    public void v_Verify_In_Project_Detail_Summary_Page_SHARED() {

        /**
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
         */
    }

    public void v_Verify_In_Project_Detail_Scenarios_Page_SHARED() {

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
    }

    public void v_Verify_Project_Is_Not_Available() {

        By projectBy = methods.getByWithKeySetValue("projectPanelProjectNameKeyValueInProjects",
                String.valueOf(methods.getValueInTestMap("deleteProjectName")));
        Assert.assertTrue("", methods.isElementInVisible(projectBy,30));
    }

    public void e_Click_Project_Summary() {

        methods.putValueInTestMap("currentProject",methods.getValueInTestMap("editProject"));
        By summaryButtonBy = methods.getByWithKeySetValue("summaryButtonWithSelectedProjectInProjects",
                String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(summaryButtonBy);
        methods.checkElementClickable(summaryButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(summaryButtonBy);
    }

    public void e_Click_Add_Suite() {

        By addAPlanBy = methods.getByWithKeySetValue("addAPlanWithSelectedProjectInProjects",
                String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(addAPlanBy);
        methods.checkElementClickable(addAPlanBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(addAPlanBy);
        methods.putValueInTestMap("projectSelectedForPlan",true);
    }
}
