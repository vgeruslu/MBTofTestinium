package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.methods.Methods;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GraphWalker(value = "random(edge_coverage(100))")
public class ProjectDetailScenarios extends ExecutionContext implements org.graphwalker.Project_Detail_Scenarios {

    private static final Logger logger = LoggerFactory.getLogger(ProjectDetailScenarios.class);
    Methods methods;

    public ProjectDetailScenarios() {

        methods = new Methods();
    }

    @BeforeExecution
    public void setup() {

    }

    @AfterExecution
    public void cleanup() {

    }

    @BeforeElement
    public void beforeElement() {

        logger.info("═════════  " + getModel().getName() + "   "
                + (getCurrentElement() instanceof Edge.RuntimeEdge ? "Edge" : "Vertex") + "   "
                + getCurrentElement().getName() + "   "  + getCurrentElement().getId() + "  ═════════");
    }

    @AfterElement
    public void afterElement() {

        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    public void e_Select_A_Suite() {

        methods.checkElementVisible(methods.getBy("suitesSelectInProjectDetailScenarios"));
        By suitesSelectOptionBy = methods.getByWithKeySetValue("suitesSelectWithOptionValueInProjectDetailScenarios","1");
        methods.clickElement(suitesSelectOptionBy);
    }

    public void v_Verify_Scenario_Is_Available() {

        methods.checkElementVisible(methods.getByWithKeySetValue("scenarioWithScenarioNameInProjectDetailScenarios"
                , String.valueOf(methods.getValueInTestMap("deleteScenario"))));
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Scenario_Edit_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario/edit/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/properties",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoTitleWithProjectNameInScenarioEdit"
                , String.valueOf(methods.getValueInTestMap("currentScenario"))));
        methods.checkElementVisible(methods.getBy("propertiesTabInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("ideTabInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("copyUrlButtonInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("projectNameInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("scenarioNameInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("scenarioDescriptionInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("selectGroupInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("selectMaxExecutionTimeInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("fileContentPanelInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("selectSourceFilePanelWindowInCreateScenario"));
        methods.checkElementVisible(methods.getBy("selectTestMethodsPanelWindow1InCreateScenario"));
        methods.checkElementVisible(methods.getBy("javaParameterNameInCreateScenario"));
        methods.checkElementVisible(methods.getBy("javaParameterValueInCreateScenario"));
        methods.checkElementVisible(methods.getBy("javaParameterDescriptionInCreateScenario"));
        methods.checkElementVisible(methods.getBy("javaParametersAddButtonInCreateScenario"));
        methods.checkElementVisible(methods.getBy("cancelButtonInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("applyButtonInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("saveButtonInScenarioEdit"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_No_action() {

    }

    public void e_Select_All_Suites() {

        methods.selectByVisibleText(methods.getBy("suitesSelectInProjectDetailScenarios")
                , "All Suites");
    }

    public void e_no_Action() {

    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methods.checkElementClickable(noButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void v_Control_Are_You_Sure_Message() {

        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
    }

    public void e_Click_Delete() {


        By scenarioNameBy = methods.getByWithKeySetValue("tableScenarioNameInProjectDetailScenarios","last()");
        methods.checkElementVisible(scenarioNameBy);
        methods.waitByMilliSeconds(200);
        String scenarioName = methods.getText(scenarioNameBy);
        By deleteButtonBy = methods.getByWithKeySetValue("deleteButtonWithScenarioNameInProjectDetailScenarios",
                scenarioName);
        methods.checkElementVisible(deleteButtonBy);
        methods.checkElementClickable(deleteButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(deleteButtonBy);
        methods.putValueInTestMap("deleteScenario", scenarioName);
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

    public void e_Click_Project_Detail_Summary_Tab() {

        By summaryTabBy = methods.getBy("summaryTabInProjectDetail");
        methods.checkElementVisible(summaryTabBy);
        methods.checkElementClickable(summaryTabBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(summaryTabBy);
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


        if(methods.isElementVisible(methods.getBy("scenarioElementInProjectDetailScenarios"),2)) {

            methods.checkElementVisible(methods.getBy("editButtonInProjectDetailScenarios"));
            methods.checkElementVisible(methods.getBy("deleteButtonInProjectDetailScenarios"));
            setAttribute("hasProjectAScenario",true);
            if (methods.isElementVisible(methods
                    .getByWithKeySetValue("suitesSelectWithOptionValueInProjectDetailScenarios", ""), 2)) {

                setAttribute("hasProjectAPlan", true);
            } else {
                setAttribute("hasProjectAPlan", false);
            }
        }else {
            setAttribute("hasProjectAScenario",false);
            setAttribute("hasProjectAPlan", false);
        }
    }

    public void v_Control_Scenarios_Table() {

        methods.checkElementVisible(methods.getBy("tableInProjectDetailScenarios"));
        methods.checkElementVisible(methods.getBy("scenarioInProjectDetailScenarios"));
    }

    public void e_Click_Edit() {

        By scenarioNameBy = methods.getBy("scenarioNameInProjectDetailScenarios");
        By editButtonBy = methods.getBy("editButtonInProjectDetailScenarios");
        methods.checkElementVisible(scenarioNameBy);
        methods.checkElementVisible(editButtonBy);
        methods.waitByMilliSeconds(200);
        String scenarioName = methods.getText(scenarioNameBy).trim();
        methods.checkElementClickable(editButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(editButtonBy);
        methods.putValueInTestMap("currentScenario", scenarioName);
    }
}
