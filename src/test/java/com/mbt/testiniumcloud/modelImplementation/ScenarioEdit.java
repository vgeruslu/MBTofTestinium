package com.mbt.testiniumcloud.modelImplementation;

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
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class ScenarioEdit extends ExecutionContext implements org.graphwalker.Scenario_Edit {

    private static final Logger logger = LogManager.getLogger(ScenarioEdit.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public ScenarioEdit() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
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

        methods.checkElementVisible(methods.getBy("scenarioSuccessfullyUpdated"));
        methods.isElementInVisible(methods.getBy("scenarioSuccessfullyUpdated"),5);
    }

    public void v_Verify_New_Scenario_Name() {

        By scenarioNameBy = methods.getBy("scenarioNameInScenarioEdit");
        methods.checkElementVisible(scenarioNameBy);
        Assert.assertTrue("", methods.getAttribute(scenarioNameBy,"value").trim()
                .equals(String.valueOf(methods.getValueInTestMap("editedScenarioName"))));
    }

    public void e_No_Action() {

    }

    public void e_Click_Apply() {

        By applyButtonBy = methods.getBy("applyButtonInScenarioEdit");
        methods.checkElementVisible(applyButtonBy);
        methods.checkElementClickable(applyButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(applyButtonBy);
    }

    public void e_Click_IDE() {

        By ideTabBy = methods.getBy("ideTabInScenarioEdit");
        methods.checkElementVisible(ideTabBy);
        methods.checkElementClickable(ideTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(ideTabBy);
    }

    public void v_Verify_In_Scenario_Edit_Page_SHARED() {

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
    }

    public void v_Control_IDE_Page() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario/edit/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/ide",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoTitleWithProjectNameForIdeTabInScenarioEdit"
                , String.valueOf(methods.getValueInTestMap("currentScenario"))));
        methods.checkElementVisible(methods.getBy("propertiesTabInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("ideTabInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("saveButtonForIdeTabInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("explorerPanelForIdeTabInScenarioEdit"));
        methods.checkElementVisible(methods.getBy("aceEditorForIdeTabInScenarioEdit"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Change_Scenario_Name() {

        By scenarioNameBy = methods.getBy("scenarioNameInScenarioEdit");
        methods.checkElementVisible(scenarioNameBy);
        methods.clearElement(scenarioNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String editedScenarioName = "editedScenario" + methodsUtil.randomString(6);
        methods.putValueInTestMap("editedScenarioName", editedScenarioName);
        methods.sendKeys(scenarioNameBy, editedScenarioName);
        methodsUtil.waitByMilliSeconds(200);
    }

    public void e_No_action() {

    }

    public void e_Click_Properties() {

        By propertiesTabBy = methods.getBy("propertiesTabInScenarioEdit");
        methods.checkElementVisible(propertiesTabBy);
        methods.checkElementClickable(propertiesTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(propertiesTabBy);
    }

    public void v_Verify_Invalid_Edit_Scenario_Blank_Scenario_Name() {

        By scenarioNameBy = methods.getBy("scenarioNameInScenarioEdit");
        methods.checkElementVisible(methods.getBy("projectNameInScenarioEdit"));
        methods.checkElementVisible(scenarioNameBy);
        methodsUtil.waitByMilliSeconds(500);
        Assert.assertTrue("",methods.getAttribute(scenarioNameBy,"class").contains("ng-invalid"));
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(scenarioNameBy,"border-bottom-color"));
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInScenarioEdit");
        methods.checkElementVisible(cancelButtonBy);
        methods.checkElementClickable(cancelButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(cancelButtonBy);
    }

    public void e_Click_Save_Blank_Scenario_Name() {

        By scenarioNameBy = methods.getBy("scenarioNameInScenarioEdit");
        methods.checkElementVisible(methods.getBy("projectNameInScenarioEdit"));
        methods.checkElementVisible(scenarioNameBy);
        methods.clearElementWithBackSpace(scenarioNameBy,"a");
        methods.checkElementVisible(scenarioNameBy);
        By saveButtonBy = methods.getBy("saveButtonInScenarioEdit");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void e_click_Save() {

        By saveButtonBy = methods.getBy("saveButtonInScenarioEdit");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void v_Verify_In_All_Scenarios_Page_SHARED() {

        /**
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
         */
    }

    public void v_Verify_Edited_Scenario() {

        By tableScenarioBy = methods.getByWithKeySetValue("tableScenarioNameKeyValueInAllScenarios"
                , methods.getValueInTestMap("currentProject") + "!!" + methods.getValueInTestMap("editedScenarioName"));
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario",75,"equal"));
        methods.checkElementVisible(methods.getBy("allScenariosLogoTitleInAllScenarios"));
        methods.checkElementVisible(methods.getBy("projectSelectInAllScenarios"));
        methods.checkElementVisible(methods.getBy("suiteSelectInAllScenarios"));
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methodsUtil.waitByMilliSeconds(500);
        methods.selectByVisibleText(projectSelectBy
                , "All Projects");
        methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.selectByVisibleText(projectSelectBy
                , String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(projectSelectBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.checkElementVisible(tableScenarioBy);
    }
}
