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
public class CreateScenario extends ExecutionContext implements org.graphwalker.Create_Scenario {

    private static final Logger logger = LogManager.getLogger(CreateScenario.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;
    Boolean modelLocationStillCreateScenarioPage = false;

    public CreateScenario() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(CreateScenario.class), Level.toLevel(Driver.modelImplLogLevel));
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
        commonProcess.checkElementVisible(methods.getBy("javaParametersAddButtonInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("selectSourceFilePanelInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("selectTestMethodsPanelInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("createScenarioGroupSwitchInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("copyButtonInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInCreateScenario"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));

        if(!modelLocationStillCreateScenarioPage) {
            setAttribute("isProjectSelected",
                    Value.asValue(Boolean.parseBoolean(methodsUtil.getValueInTestMap("projectSelectedForScenario").toString())));
        }
        modelLocationStillCreateScenarioPage = true;
    }

    public void e_Add_A_System_Parameter() {

        By javaParameterNameBy = methods.getBy("javaParameterNameInCreateScenario");
        By javaParameterValueBy = methods.getBy("javaParameterValueInCreateScenario");
        By javaParameterAddButtonBy = methods.getBy("javaParametersAddButtonInCreateScenario");
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElement(javaParameterNameBy);
        methods.sendKeys(javaParameterNameBy,"newParameter");
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElement(javaParameterValueBy);
        methods.sendKeys(javaParameterValueBy,"newValue");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.clickButton(javaParameterAddButtonBy);
    }

    public void v_Verify_Invalid_Create_Scenario_None_Project() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By errorBlockProjectNameBy = methods.getBy("errorBlockProjectNameInCreateScenario");
        By selectSourceFilePanelBy = methods.getBy("selectSourceFilePanelWindowInCreateScenario");
        By selectTestMethodsPanelBy = methods.getBy("selectTestMethodsPanelWindowInCreateScenario");
        commonProcess.checkElementVisible(projectNameBy);
        assertTrue(methods.getAttribute(projectNameBy,"class").contains("ng-invalid"));
        commonProcess.checkElementVisible(errorBlockProjectNameBy);
        assertEquals("This field is required.", methods.getText(errorBlockProjectNameBy).trim());
        commonProcess.checkElementVisible(scenarioNameBy);
        assertTrue(methods.getAttribute(scenarioNameBy,"class").contains("ng-valid"));
        commonProcess.checkElementVisible(selectSourceFilePanelBy);
        assertTrue(methods.getAttribute(selectSourceFilePanelBy,"class").contains("error-border"));
        commonProcess.checkElementVisible(selectTestMethodsPanelBy);
        assertTrue(methods.getAttribute(selectTestMethodsPanelBy,"class").contains("error-border"));
        assertEquals("#d0021b"
                , methods.getHexCssValue(projectNameBy,"border-bottom-color"));
        assertEquals("#d0021b"
                , methods.getHexCssValue(selectSourceFilePanelBy,"border-bottom-color"));
        assertEquals("#d0021b"
                , methods.getHexCssValue(selectTestMethodsPanelBy,"border-bottom-color"));
    }

    public void v_Control_Edited_System_Parameter() {

        By javaParametersTableParameterBy = commonProcess.getKeyValueChangerElement("javaParametersTableParameterKeyValueInCreateScenario"
                ,"javaParametersTableParameterKeyValue1InCreateScenario", "newParameter!!newValue!!");
        By javaParametersEditButtonBy = commonProcess.getKeyValueChangerElement("javaParametersEditButtonKeyValueInCreateScenario"
                ,"javaParametersEditButtonKeyValue1InCreateScenario","newParameter!!newValue!!");
        By javaParametersDeleteButtonBy = commonProcess.getKeyValueChangerElement("javaParametersDeleteButtonKeyValueInCreateScenario"
                ,"javaParametersDeleteButtonKeyValue1InCreateScenario","newParameter!!newValue!!");
        assertTrue(methods.isElementInVisible(javaParametersTableParameterBy,30));
        assertTrue(methods.isElementInVisible(javaParametersEditButtonBy,30));
        assertTrue(methods.isElementInVisible(javaParametersDeleteButtonBy,30));
        javaParametersTableParameterBy = commonProcess.getKeyValueChangerElement("javaParametersTableParameterKeyValueInCreateScenario"
                ,"javaParametersTableParameterKeyValue1InCreateScenario","editedParameter!!editedValue!!");
        javaParametersEditButtonBy = commonProcess.getKeyValueChangerElement("javaParametersEditButtonKeyValueInCreateScenario"
                ,"javaParametersEditButtonKeyValue1InCreateScenario","editedParameter!!editedValue!!");
        javaParametersDeleteButtonBy = commonProcess.getKeyValueChangerElement("javaParametersDeleteButtonKeyValueInCreateScenario"
                ,"javaParametersDeleteButtonKeyValue1InCreateScenario","editedParameter!!editedValue!!");
        commonProcess.checkElementVisible(javaParametersTableParameterBy);
        commonProcess.checkElementVisible(javaParametersEditButtonBy);
        commonProcess.checkElementVisible(javaParametersDeleteButtonBy);
    }

    public void v_Verify_System_Parameter_Is_Not_Available() {

        By javaParametersTableParameterBy = commonProcess.getKeyValueChangerElement("javaParametersTableParameterKeyValueInCreateScenario"
                ,"javaParametersTableParameterKeyValue1InCreateScenario","editedParameter!!editedValue!!");
        By javaParametersEditButtonBy = commonProcess.getKeyValueChangerElement("javaParametersEditButtonKeyValueInCreateScenario"
                ,"javaParametersEditButtonKeyValue1InCreateScenario","editedParameter!!editedValue!!");
        By javaParametersDeleteButtonBy = commonProcess.getKeyValueChangerElement("javaParametersDeleteButtonKeyValueInCreateScenario"
                ,"javaParametersDeleteButtonKeyValue1InCreateScenario","editedParameter!!editedValue!!");
        assertTrue(methods.isElementInVisible(javaParametersTableParameterBy,30));
        assertTrue(methods.isElementInVisible(javaParametersEditButtonBy,30));
        assertTrue(methods.isElementInVisible(javaParametersDeleteButtonBy,30));
    }

    public void e_Click_Save_Blank_Scenario_Name() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By saveButtonBy = methods.getBy("saveButtonInCreateScenario");
        commonProcess.checkElementVisible(projectNameBy);
        methods.selectByVisibleText(projectNameBy
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(scenarioNameBy);
        methods.clearElementWithBackSpace(scenarioNameBy,"a");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(saveButtonBy);
        commonProcess.checkElementClickable(saveButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
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

    public void v_Verify_Invalid_Create_Scenario_Blank_Scenario_Name() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        //By selectSourceFilePanelBy = methods.getBy("selectSourceFilePanelWindowInCreateScenario");
        //By selectTestMethodsPanelBy = methods.getBy("selectTestMethodsPanelWindowInCreateScenario");

        commonProcess.checkElementVisible(projectNameBy);
        commonProcess.checkElementVisible(scenarioNameBy);
        methodsUtil.waitByMilliSeconds(500);
        assertTrue(methods.getAttribute(projectNameBy,"class").contains("ng-valid"));
        assertTrue(methods.getAttribute(scenarioNameBy,"class").contains("ng-invalid"));
        assertEquals("#d0021b", methods.getHexCssValue(scenarioNameBy,"border-bottom-color"));
    }

    public void v_Verify_New_System_Parameter() {

        By javaParametersTableParameterBy = commonProcess.getKeyValueChangerElement("javaParametersTableParameterKeyValueInCreateScenario"
                ,"javaParametersTableParameterKeyValue1InCreateScenario","newParameter!!newValue!!");
        By javaParametersEditButtonBy = commonProcess.getKeyValueChangerElement("javaParametersEditButtonKeyValueInCreateScenario"
                ,"javaParametersEditButtonKeyValue1InCreateScenario","newParameter!!newValue!!");
        By javaParametersDeleteButtonBy = commonProcess.getKeyValueChangerElement("javaParametersDeleteButtonKeyValueInCreateScenario"
                ,"javaParametersDeleteButtonKeyValue1InCreateScenario","newParameter!!newValue!!");
        commonProcess.checkElementVisible(javaParametersTableParameterBy);
        commonProcess.checkElementVisible(javaParametersEditButtonBy);
        commonProcess.checkElementVisible(javaParametersDeleteButtonBy);
    }

    public void v_Control_Test_Methods() {

        By testCasesBy = methods.getBy("selectTestCaseInCreateScenario");
        commonProcess.checkElementVisible(testCasesBy);
    }

    public void e_No_Action() {

    }

    public void e_Click_A_Test_Methods_File() {

        By sourceFileBy = commonProcess.getKeyValueChangerElement("selectSourceFileKeyValueContainInCreateScenario"
                ,"selectSourceFileKeyValueContain1InCreateScenario", String.valueOf(methodsUtil.getValueInTestMap("testSourceFileName")));
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(methods.getBy("selectSourceFilePanelInCreateScenario"));
        commonProcess.clickButton(sourceFileBy);
    }

    public void e_Click_Save_Empty_Inputs() {

        //By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By saveButtonBy = methods.getBy("saveButtonInCreateScenario");
        commonProcess.checkElementVisible(scenarioNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(scenarioNameBy,"a");
        methodsUtil.waitByMilliSeconds(300);
       commonProcess.clickButton(saveButtonBy);
    }

    public void v_Control_New_Scenario() {

        String projectName = methodsUtil.getValueInTestMap("currentProject").toString();
        String scenarioName = methodsUtil.getValueInTestMap("newScenarioName").toString();
        By tableScenarioBy = commonProcess.getKeyValueChangerElement("tableScenarioNameKeyValueInAllScenarios"
                ,"tableScenarioNameKeyValue1InAllScenarios",projectName + "!!" + scenarioName);

        assertTrue(methods.doesUrl("https://testinium.io/scenario",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosLogoTitleInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("projectSelectInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("suiteSelectInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methodsUtil.waitByMilliSeconds(500);
        methods.selectByVisibleText(projectSelectBy
                , "All Projects");
        methodsUtil.waitBySeconds(1);
        methods.selectByVisibleText(projectSelectBy
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(projectSelectBy);
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("tableScenarioWithProjectNameInAllScenarios"
                ,"tableScenarioWithProjectName1InAllScenarios", projectName));
        assertTrue(methods.isElementInVisible(commonProcess.getKeyValueChangerElement("tableScenarioWithNotProjectNameInAllScenarios"
                ,"tableScenarioWithNotProjectName1InAllScenarios", projectName),30));
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
            commonProcess.checkElementVisible(tableScenarioBy);
        }
    }

    public void e_NO_Action() {

    }

    public void e_Edit_New_System_Parameter() {

        By javaParameterNameBy = methods.getBy("javaParameterNameInCreateScenario");
        By javaParameterValueBy = methods.getBy("javaParameterValueInCreateScenario");
        By javaParameterAddButtonBy = methods.getBy("javaParametersAddButtonInCreateScenario");
        By javaParameterCancelButtonBy = methods.getBy("javaParametersCancelButtonInCreateScenario");
        By javaParameterSaveButtonBy = methods.getBy("javaParametersSaveButtonInCreateScenario");
        By javaParametersEditButtonBy = commonProcess.getKeyValueChangerElement("javaParametersEditButtonKeyValueInCreateScenario"
                ,"javaParametersEditButtonKeyValue1InCreateScenario","newParameter!!newValue!!");

        commonProcess.clickButton(javaParametersEditButtonBy);
        assertTrue(methods.isElementInVisible(javaParameterAddButtonBy,30));
        commonProcess.checkElementVisible(javaParameterCancelButtonBy);
        commonProcess.checkElementVisible(javaParameterSaveButtonBy);
        commonProcess.checkElementVisible(javaParameterNameBy);
        commonProcess.checkElementVisible(javaParameterValueBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElement(javaParameterNameBy);
        methods.sendKeys(javaParameterNameBy,"editedParameter");
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElement(javaParameterValueBy);
        methods.sendKeys(javaParameterValueBy,"editedValue");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.clickButton(javaParameterSaveButtonBy);
    }

    public void e_No_action() {

    }

    public void v_Control_Project_Source_Files() {

        By sourceFilesBy = methods.getBy("selectSourceFileInCreateScenario");
        commonProcess.checkElementVisible(sourceFilesBy);
    }

    public void e_no_Action() {

    }

    public void e_Select_A_Project() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.selectByVisibleText(projectNameBy
                , String.valueOf(methodsUtil.getValueInTestMap("appiumProject")));
        commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.selectByVisibleText(projectNameBy
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(projectNameBy);
    }

    public void e_Click_Save_No_Selected_Project() {

        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By saveButtonBy = methods.getBy("saveButtonInCreateScenario");
        commonProcess.checkElementVisible(scenarioNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElement(scenarioNameBy);
        methods.sendKeys(scenarioNameBy,"newScenarioName");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.clickButton(saveButtonBy);
    }

    public void e_Create_New_Scenario() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By saveButtonBy = methods.getBy("saveButtonInCreateScenario");
        By testMethodBy = commonProcess.getKeyValueChangerElement("selectTestCaseKeyValueContainInCreateScenario"
                ,"selectTestCaseKeyValueContain1InCreateScenario", String.valueOf(methodsUtil.getValueInTestMap("testMethodFileName")));
        By testSourceFileBy = commonProcess.getKeyValueChangerElement("selectSourceFileKeyValueContainInCreateScenario"
                ,"selectSourceFileKeyValueContain1InCreateScenario", String.valueOf(methodsUtil.getValueInTestMap("testSourceFileName")));
        commonProcess.checkElementVisible(projectNameBy);
        commonProcess.checkElementVisible(scenarioNameBy);
        commonProcess.checkElementVisible(saveButtonBy);
        commonProcess.checkElementClickable(projectNameBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.selectByVisibleText(projectNameBy, String.valueOf(methodsUtil.getValueInTestMap("appiumProject")));
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(projectNameBy);
        commonProcess.checkElementClickable(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.selectByVisibleText(projectNameBy, String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(projectNameBy);
        methods.clearElement(scenarioNameBy);
        methodsUtil.waitByMilliSeconds(300);
        String newScenarioName = "newScenarioName" + methodsUtil.randomString(6);
        methods.sendKeys(scenarioNameBy, newScenarioName);
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(scenarioNameBy);
        commonProcess.checkElementVisible(methods.getBy("selectSourceFilePanelInCreateScenario"));
        commonProcess.checkElementVisible(methods.getBy("selectTestMethodsPanelInCreateScenario"));
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.clickButton(testSourceFileBy);
        methodsUtil.waitByMilliSeconds(300);

        /**
         * TODO: Error Could not read file
         * if testMethod not exist
         */
        if(!methods.isElementVisible(testMethodBy,3)){
            methodsUtil.waitBySeconds(1);
            methods.selectByVisibleText(projectNameBy, String.valueOf(methodsUtil.getValueInTestMap("appiumProject")));
            methodsUtil.waitByMilliSeconds(300);
            commonProcess.checkElementVisible(projectNameBy);
            commonProcess.checkElementClickable(projectNameBy);
            methodsUtil.waitByMilliSeconds(300);
            methods.selectByVisibleText(projectNameBy, String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
            methodsUtil.waitBySeconds(1);
            commonProcess.checkElementVisible(projectNameBy);
            methodsUtil.waitByMilliSeconds(500);
            commonProcess.clickButton(testSourceFileBy);
            methodsUtil.waitByMilliSeconds(300);
        }

        commonProcess.clickButton(testMethodBy);
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(saveButtonBy);
        commonProcess.scrollElementCenter(saveButtonBy);
        commonProcess.clickButton(saveButtonBy);
        methodsUtil.putValueInTestMap("newScenarioName", newScenarioName);
        modelLocationStillCreateScenarioPage = false;
    }

    public void e_Delete_New_System_Parameter() {

        By javaParametersDeleteButtonBy = commonProcess.getKeyValueChangerElement("javaParametersDeleteButtonKeyValueInCreateScenario"
                ,"javaParametersDeleteButtonKeyValue1InCreateScenario","editedParameter!!editedValue!!");
        commonProcess.clickButton(javaParametersDeleteButtonBy);
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInCreateScenario");
        commonProcess.clickButton(cancelButtonBy);
        modelLocationStillCreateScenarioPage = false;
    }

    public void v_Verify_Invalid_Create_Scenario_Empty_Inputs() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By errorBlockProjectNameBy = methods.getBy("errorBlockProjectNameInCreateScenario");
        By selectSourceFilePanelBy = methods.getBy("selectSourceFilePanelWindowInCreateScenario");
        By selectTestMethodsPanelBy = methods.getBy("selectTestMethodsPanelWindowInCreateScenario");
        commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(500);
        assertTrue(methods.getAttribute(projectNameBy,"class").contains("ng-invalid"));
        commonProcess.checkElementVisible(errorBlockProjectNameBy);
        assertEquals("This field is required.", methods.getText(errorBlockProjectNameBy).trim());
        commonProcess.checkElementVisible(scenarioNameBy);
        assertTrue(methods.getAttribute(scenarioNameBy,"class").contains("ng-invalid"));
        commonProcess.checkElementVisible(selectSourceFilePanelBy);
        assertTrue(methods.getAttribute(selectSourceFilePanelBy,"class").contains("error-border"));
        commonProcess.checkElementVisible(selectTestMethodsPanelBy);
        assertTrue(methods.getAttribute(selectTestMethodsPanelBy,"class").contains("error-border"));
        assertEquals("#d0021b", methods.getHexCssValue(projectNameBy,"border-bottom-color"));
        assertEquals("#d0021b", methods.getHexCssValue(scenarioNameBy,"border-bottom-color"));
        assertEquals("#d0021b", methods.getHexCssValue(selectSourceFilePanelBy,"border-bottom-color"));
        assertEquals("#d0021b", methods.getHexCssValue(selectTestMethodsPanelBy,"border-bottom-color"));
        //#d0021b
        // border-bottom-color
        // #4a4a4a
    }

    public void e_no_action() {

    }
}
