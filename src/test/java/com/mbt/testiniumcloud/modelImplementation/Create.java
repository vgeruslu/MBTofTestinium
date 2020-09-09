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
public class Create extends ExecutionContext implements org.graphwalker.Create {

    private static final Logger logger = LoggerFactory.getLogger(Create.class);
    Methods methods;
    ExcelMapData excelMapData;

    public Create() {

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

        methods.putValueInTestMap("currentProject", methods.getValueInTestMap("optionalProject").toString());
    }

    public void v_Verify_Create_Scenario_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario/create",75,"startWith"));
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
         */
    }

    public void e_Click_Create_A_New_Suite() {

        By createNewPlanButtonBy = methods.getBy("createPlanInCreatePage");
        methods.checkElementClickable(createNewPlanButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(createNewPlanButtonBy);
        methods.putValueInTestMap("projectSelectedForPlan",false);
    }

    public void v_Verify_In_Create_Project_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/create",75,"equal"));
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
         */
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/create",75,"startWith"));
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

    public void e_Click_Create_A_New_Project() {

        By createNewProjectButtonBy = methods.getBy("createNewProjectInCreatePage");
        methods.checkElementClickable(createNewProjectButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(createNewProjectButtonBy);
    }

    public void e_Click_Create_A_New_Scenario() {

        By createNewScenarioButtonBy = methods.getBy("createScenarioInCreatePage");
        methods.checkElementClickable(createNewScenarioButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(createNewScenarioButtonBy);
        methods.putValueInTestMap("projectSelectedForScenario",false);
    }

}
