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
public class ScenarioEdit extends ExecutionContext implements org.graphwalker.Scenario_Edit {

    private static final Logger logger = LogManager.getLogger(ScenarioEdit.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public ScenarioEdit() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(ScenarioEdit.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void v_Control_Apply_Successfull_Message() {

        commonProcess.checkElementVisible(methods.getBy("scenarioSuccessfullyUpdated"));
        methods.isElementInVisible(methods.getBy("scenarioSuccessfullyUpdated"),5);
    }

    public void v_Verify_New_Scenario_Name() {

        By scenarioNameBy = methods.getBy("scenarioNameInScenarioEdit");
        commonProcess.checkElementVisible(scenarioNameBy);
        assertEquals(methods.getAttribute(scenarioNameBy, "value").trim(), String.valueOf(methodsUtil.getValueInTestMap("editedScenarioName")));
    }

    public void e_No_Action() {

    }

    public void e_Click_Apply() {

        By applyButtonBy = methods.getBy("applyButtonInScenarioEdit");
        commonProcess.clickButton(applyButtonBy);
    }

    public void e_Click_IDE() {

        By ideTabBy = methods.getBy("ideTabInScenarioEdit");
        commonProcess.clickButton(ideTabBy);
    }

    public void v_Verify_In_Scenario_Edit_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/scenario/edit/",75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleWithProjectNameInScenarioEdit"
                ,"logoTitleWithProjectName1InScenarioEdit", String.valueOf(methodsUtil.getValueInTestMap("currentScenario"))));
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
    }

    public void v_Control_IDE_Page() {

        assertTrue(methods.doesUrl("https://testinium.io/scenario/edit/",75,"startWith"));
        assertTrue(methods.doesUrl("/ide",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleWithProjectNameForIdeTabInScenarioEdit"
                ,"logoTitleWithProjectNameForIdeTab1InScenarioEdit", String.valueOf(methodsUtil.getValueInTestMap("currentScenario"))));
        commonProcess.checkElementVisible(methods.getBy("propertiesTabInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("ideTabInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonForIdeTabInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("explorerPanelForIdeTabInScenarioEdit"));
        commonProcess.checkElementVisible(methods.getBy("aceEditorForIdeTabInScenarioEdit"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Change_Scenario_Name() {

        By scenarioNameBy = methods.getBy("scenarioNameInScenarioEdit");
        commonProcess.checkElementVisible(scenarioNameBy);
        methods.clearElement(scenarioNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String editedScenarioName = "editedScenario" + methodsUtil.randomString(6);
        methodsUtil.putValueInTestMap("editedScenarioName", editedScenarioName);
        methods.sendKeys(scenarioNameBy, editedScenarioName);
        methodsUtil.waitByMilliSeconds(200);
    }

    public void e_No_action() {

    }

    public void e_Click_Properties() {

        By propertiesTabBy = methods.getBy("propertiesTabInScenarioEdit");
        commonProcess.clickButton(propertiesTabBy);
    }

    public void v_Verify_Invalid_Edit_Scenario_Blank_Scenario_Name() {

        By scenarioNameBy = methods.getBy("scenarioNameInScenarioEdit");
        commonProcess.checkElementVisible(methods.getBy("projectNameInScenarioEdit"));
        commonProcess.checkElementVisible(scenarioNameBy);
        methodsUtil.waitByMilliSeconds(500);
        assertTrue(methods.getAttribute(scenarioNameBy,"class").contains("ng-invalid"));
        assertEquals("#d0021b", methods.getHexCssValue(scenarioNameBy,"border-bottom-color"));
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInScenarioEdit");
        commonProcess.clickButton(cancelButtonBy);
    }

    public void e_Click_Save_Blank_Scenario_Name() {

        By scenarioNameBy = methods.getBy("scenarioNameInScenarioEdit");
        commonProcess.checkElementVisible(methods.getBy("projectNameInScenarioEdit"));
        commonProcess.checkElementVisible(scenarioNameBy);
        methods.clearElementWithBackSpace(scenarioNameBy,"a");
        commonProcess.checkElementVisible(scenarioNameBy);
        By saveButtonBy = methods.getBy("saveButtonInScenarioEdit");
        commonProcess.clickButton(saveButtonBy);
    }

    public void e_click_Save() {

        By saveButtonBy = methods.getBy("saveButtonInScenarioEdit");
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Verify_In_All_Scenarios_Page_SHARED() {

        /**
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
         */
    }

    public void v_Verify_Edited_Scenario() {

        By tableScenarioBy = commonProcess.getKeyValueChangerElement("tableScenarioNameKeyValueInAllScenarios"
                ,"tableScenarioNameKeyValue1InAllScenarios",methodsUtil.getValueInTestMap("currentProject") + "!!" + methodsUtil.getValueInTestMap("editedScenarioName"));
        assertTrue(methods.doesUrl("https://testinium.io/scenario",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosLogoTitleInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("projectSelectInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("suiteSelectInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methodsUtil.waitByMilliSeconds(500);
        methods.selectByVisibleText(projectSelectBy,"All Projects");
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.selectByVisibleText(projectSelectBy, String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(projectSelectBy);
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        commonProcess.checkElementVisible(tableScenarioBy);
    }
}
