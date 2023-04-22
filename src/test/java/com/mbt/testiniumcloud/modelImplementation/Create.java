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
public class Create extends ExecutionContext implements org.graphwalker.Create {

    private static final Logger logger = LogManager.getLogger(Create.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public Create() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(Create.class), Level.toLevel(Driver.modelImplLogLevel));
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

        methodsUtil.putValueInTestMap("currentProject", methodsUtil.getValueInTestMap("optionalProject").toString());
    }

    public void v_Verify_Create_Scenario_Page_SHARED() {

        /**
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
         */
    }

    public void e_Click_Create_A_New_Suite() {

        By createNewPlanButtonBy = methods.getBy("createPlanInCreatePage");
        commonProcess.clickButton(createNewPlanButtonBy);
        methodsUtil.putValueInTestMap("projectSelectedForPlan",false);
    }

    public void v_Verify_In_Create_Project_Page_SHARED() {

        /**
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
         */
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

        /**
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
         */
    }

    public void e_Click_Create_A_New_Project() {

        By createNewProjectButtonBy = methods.getBy("createNewProjectInCreatePage");
        commonProcess.checkElementClickable(createNewProjectButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(createNewProjectButtonBy);
    }

    public void e_Click_Create_A_New_Scenario() {

        By createNewScenarioButtonBy = methods.getBy("createScenarioInCreatePage");
        commonProcess.clickButton(createNewScenarioButtonBy);
        methodsUtil.putValueInTestMap("projectSelectedForScenario",false);
    }

}
