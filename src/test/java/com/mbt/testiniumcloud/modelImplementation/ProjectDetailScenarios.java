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
public class ProjectDetailScenarios extends ExecutionContext implements org.graphwalker.Project_Detail_Scenarios {

    private static final Logger logger = LogManager.getLogger(ProjectDetailScenarios.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public ProjectDetailScenarios() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(ProjectDetailScenarios.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void e_Select_A_Suite() {

        commonProcess.checkElementVisible(methods.getBy("suitesSelectInProjectDetailScenarios"));
        By suitesSelectOptionBy = commonProcess.getKeyValueChangerElement("suitesSelectWithOptionValueInProjectDetailScenarios","suitesSelectWithOptionValue1InProjectDetailScenarios","1");
        commonProcess.clickButton(suitesSelectOptionBy);
    }

    public void v_Verify_Scenario_Is_Available() {

        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("scenarioWithScenarioNameInProjectDetailScenarios","scenarioWithScenarioName1InProjectDetailScenarios", String.valueOf(methodsUtil.getValueInTestMap("deleteScenario"))));
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Scenario_Edit_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/scenario/edit/",
                75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleWithProjectNameInScenarioEdit"
                , String.valueOf(methodsUtil.getValueInTestMap("currentScenario"))));
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
         */
    }

    public void e_No_action() {

    }

    public void e_Select_All_Suites() {

        methods.selectByVisibleText(methods.getBy("suitesSelectInProjectDetailScenarios"),"All Suites");
    }

    public void e_no_Action() {

    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        commonProcess.clickButton(noButtonBy);
    }

    public void v_Control_Are_You_Sure_Message() {

        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
    }

    public void e_Click_Delete() {


        By scenarioNameBy = commonProcess.getKeyValueChangerElement("tableScenarioNameInProjectDetailScenarios","tableScenarioName1InProjectDetailScenarios","last()");
        commonProcess.checkElementVisible(scenarioNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(scenarioNameBy);
        By deleteButtonBy = commonProcess.getKeyValueChangerElement("deleteButtonWithScenarioNameInProjectDetailScenarios","deleteButtonWithScenarioName1InProjectDetailScenarios", scenarioName);
        commonProcess.clickButton(deleteButtonBy);
        methodsUtil.putValueInTestMap("deleteScenario", scenarioName);
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

    public void e_Click_Project_Detail_Summary_Tab() {

        By summaryTabBy = methods.getBy("summaryTabInProjectDetail");
        commonProcess.clickButton(summaryTabBy);
    }

    public void v_Verify_In_Project_Detail_Scenarios_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",75,"startWith"));
        assertTrue(methods.doesUrl("/scenarios",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailScenarios"
                ,"logoWithProjectName1InProjectDetailScenarios", String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
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


        if(methods.isElementVisible(methods.getBy("scenarioElementInProjectDetailScenarios"),2)) {

            commonProcess.checkElementVisible(methods.getBy("editButtonInProjectDetailScenarios"));
            commonProcess.checkElementVisible(methods.getBy("deleteButtonInProjectDetailScenarios"));
            setAttribute("hasProjectAScenario", Value.asValue(true));
            if (methods.isElementVisible(commonProcess.getKeyValueChangerElement("suitesSelectWithOptionValueInProjectDetailScenarios","suitesSelectWithOptionValue1InProjectDetailScenarios", ""), 2)) {
                setAttribute("hasProjectAPlan", Value.asValue(true));
            } else {
                setAttribute("hasProjectAPlan", Value.asValue(false));
            }
        }else {
            setAttribute("hasProjectAScenario",Value.asValue(false));
            setAttribute("hasProjectAPlan", Value.asValue(false));
        }
    }

    public void v_Control_Scenarios_Table() {

        commonProcess.checkElementVisible(methods.getBy("tableInProjectDetailScenarios"));
        commonProcess.checkElementVisible(methods.getBy("scenarioInProjectDetailScenarios"));
    }

    public void e_Click_Edit() {

        By scenarioNameBy = methods.getBy("scenarioNameInProjectDetailScenarios");
        By editButtonBy = methods.getBy("editButtonInProjectDetailScenarios");
        commonProcess.checkElementVisible(scenarioNameBy);
        commonProcess.checkElementVisible(editButtonBy);
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(scenarioNameBy).trim();
        commonProcess.clickButton(editButtonBy);
        methodsUtil.putValueInTestMap("currentScenario", scenarioName);
    }
}
