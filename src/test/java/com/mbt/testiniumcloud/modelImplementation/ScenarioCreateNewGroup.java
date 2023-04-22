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
public class ScenarioCreateNewGroup extends ExecutionContext implements org.graphwalker.Scenario_Create_New_Group {

    private static final Logger logger = LogManager.getLogger(ScenarioCreateNewGroup.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public ScenarioCreateNewGroup() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(ScenarioCreateNewGroup.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void v_Verify_Create_New_Scenario_Group() {

        assertTrue(methods.doesUrl("https://testinium.io/scenario",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosLogoTitleInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("projectSelectInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("suiteSelectInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methodsUtil.waitByMilliSeconds(500);
        methods.selectByVisibleText(projectSelectBy, String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(projectSelectBy);
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("currentProject"));
        String scenarioName = String.valueOf(methodsUtil.getValueInTestMap("groupScenarioName"));
        By tableScenarioBy = commonProcess.getKeyValueChangerElement("tableScenarioNameKeyValueInAllScenarios"
                ,"tableScenarioNameKeyValue1InAllScenarios",projectName + "!!" + scenarioName);
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("scenarioForTableInAllScenarios"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("tableScenarioWithProjectNameInAllScenarios"
                ,"tableScenarioWithProjectName1InAllScenarios", projectName));
        assertTrue(methods.isElementInVisible(commonProcess.getKeyValueChangerElement("tableScenarioWithNotProjectNameInAllScenarios","tableScenarioWithNotProjectName1InAllScenarios", projectName),30));
        /**
         * TODO: pagination
         */
        By planCountBy = methods.getBy("planCountTextInAllSuites");
        commonProcess.checkElementVisible(planCountBy);
        methodsUtil.waitByMilliSeconds(500);
        int planCount = Integer.parseInt(methods.getText(planCountBy)
                .replace("\r\n","").trim().split("out of")[1]
                .replace("\r\n","").trim());
        if(planCount > 20){
            boolean isScenarioVisible = false;
            int pageCount = planCount/20;
            if(pageCount*20 < planCount){
                pageCount = pageCount+1;
            }
            By paginationPanelBy = methods.getBy("paginationPanelInAllSuites");
            By paginationPrevBy = methods.getBy("paginationPrevInAllSuites");
            By paginationNextBy = methods.getBy("paginationNextInAllSuites");
            commonProcess.checkElementVisible(paginationPanelBy);
            commonProcess.checkElementVisible(paginationPrevBy);
            commonProcess.checkElementVisible(paginationNextBy);
            for (int i = 1; i < pageCount+1; i++){

                if (i!=1){
                    commonProcess.checkElementVisible(paginationPanelBy);
                    commonProcess.checkElementVisible(paginationPrevBy);
                    commonProcess.clickButton(paginationNextBy);
                    methodsUtil.waitByMilliSeconds(200);
                    commonProcess.checkElementVisible(paginationPanelBy);
                }

                commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
                methods.checkElementCondition(commonProcess.getKeyValueChangerElement("paginationPageWithNumberInAllSuites","paginationPageWithNumber1InAllSuites", String.valueOf(i))
                        ,"attribute","active","contain",50,"false","class");
                commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("tableScenarioWithProjectNameInAllScenarios"
                        ,"tableScenarioWithProjectName1InAllScenarios", projectName));
                if(methods.isElementVisible(tableScenarioBy,3)){
                    isScenarioVisible = true;
                    break;
                }
            }
            if (!isScenarioVisible){
                fail(projectName + " projesinin " + scenarioName + " senaryosu bulunamadı.");
            }
        }else {
            assertTrue(methods.isElementVisible(tableScenarioBy,30),projectName + " projesinin " + scenarioName + " senaryosu bulunamadı.");
        }
    }

    public void v_Verify_Invalid_Create_New_Group_Empty_Inputs() {

        By projectNameErrorBlockBy = methods.getBy("projectNameErrorBlockInCreateNewGroup");
        By scenarioNameErrorBlockBy = methods.getBy("scenarioNameErrprBlockInCreateNewGroup");
        commonProcess.checkElementVisible(projectNameErrorBlockBy);
        assertEquals("This field is required."
                , methods.getText(projectNameErrorBlockBy).trim());
        commonProcess.checkElementVisible(scenarioNameErrorBlockBy);
        assertEquals("This field is required."
                , methods.getText(scenarioNameErrorBlockBy).trim());
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Create_New_Group_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/scenario/group/create",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("projectNameInCreateNewGroup"));
        commonProcess.checkElementVisible(methods.getBy("scenarioNameInCreateNewGroup"));
        commonProcess.checkElementVisible(methods.getBy("scenarioDescriptionInCreateNewGroup"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInCreateNewGroup"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInCreateNewGroup"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Save_Empty_Inputs() {

        By saveButtonBy = methods.getBy("saveButtonInCreateNewGroup");
        methods.clearElementWithBackSpace(methods.getBy("scenarioNameInCreateNewGroup"),"a");
        commonProcess.clickButton(saveButtonBy);
    }

    public void e_No_action() {

    }

    public void e_no_Action() {

    }

    public void v_Verify_Invalid_Create_New_Group_Blank_Scenario_Name() {

        By projectNameErrorBlockBy = methods.getBy("projectNameErrorBlockInCreateNewGroup");
        By scenarioNameErrorBlockBy = methods.getBy("scenarioNameErrprBlockInCreateNewGroup");
        assertTrue(methods.isElementInVisible(projectNameErrorBlockBy,30));
        commonProcess.checkElementVisible(scenarioNameErrorBlockBy);
        assertEquals("This field is required.", methods.getText(scenarioNameErrorBlockBy).trim());
    }

    public void e_Click_Save_No_Selected_Project() {

        By saveButtonBy = methods.getBy("saveButtonInCreateNewGroup");
        methods.sendKeys(methods.getBy("scenarioNameInCreateNewGroup"),"createGroupScenario");
        commonProcess.clickButton(saveButtonBy);
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInCreateNewGroup");
        commonProcess.clickButton(cancelButtonBy);
    }

    public void e_Click_Save_Blank_Scenario_Name() {

        By saveButtonBy = methods.getBy("saveButtonInCreateNewGroup");
        methods.selectByVisibleText(methods.getBy("projectNameInCreateNewGroup")
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(saveButtonBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(methods.getBy("scenarioNameInCreateNewGroup"),"a");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Verify_Invalid_Create_New_Group_None_Project() {

        By projectNameErrorBlockBy = methods.getBy("projectNameErrorBlockInCreateNewGroup");
        By scenarioNameErrorBlockBy = methods.getBy("scenarioNameErrprBlockInCreateNewGroup");
        commonProcess.checkElementVisible(projectNameErrorBlockBy);
        assertEquals("This field is required.", methods.getText(projectNameErrorBlockBy).trim());
        assertTrue(methods.isElementInVisible(scenarioNameErrorBlockBy,30));
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

    public void e_Create_New_Group() {

        By saveButtonBy = methods.getBy("saveButtonInCreateNewGroup");
        methods.selectByVisibleText(methods.getBy("projectNameInCreateNewGroup")
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(saveButtonBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElement(methods.getBy("scenarioNameInCreateNewGroup"));
        String scenarioName = "groupScenario" + methodsUtil.randomString(6);
        methods.sendKeys(methods.getBy("scenarioNameInCreateNewGroup")
                , scenarioName);
        commonProcess.clickButton(saveButtonBy);
        methodsUtil.putValueInTestMap("groupScenarioName", scenarioName);
    }

}
