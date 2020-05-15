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
public class CreateScenario extends ExecutionContext implements org.graphwalker.Create_Scenario {

    private static final Logger logger = LoggerFactory.getLogger(CreateScenario.class);
    Methods methods;
    Boolean modelLocationStillCreateScenarioPage = false;

    public CreateScenario() {

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
        methods.checkElementVisible(methods.getBy("javaParametersAddButtonInCreateScenario"));
        methods.checkElementVisible(methods.getBy("selectSourceFilePanelInCreateScenario"));
        methods.checkElementVisible(methods.getBy("selectTestMethodsPanelInCreateScenario"));
        methods.checkElementVisible(methods.getBy("createScenarioGroupSwitchInCreateScenario"));
        methods.checkElementVisible(methods.getBy("copyButtonInCreateScenario"));
        methods.checkElementVisible(methods.getBy("cancelButtonInCreateScenario"));
        methods.checkElementVisible(methods.getBy("saveButtonInCreateScenario"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));

        if(!modelLocationStillCreateScenarioPage) {
            setAttribute("isProjectSelected",
                    Boolean.parseBoolean(methods.getValueInTestMap("projectSelectedForScenario").toString()));
        }
        modelLocationStillCreateScenarioPage = true;
    }

    public void e_Add_A_System_Parameter() {

        By javaParameterNameBy = methods.getBy("javaParameterNameInCreateScenario");
        By javaParameterValueBy = methods.getBy("javaParameterValueInCreateScenario");
        By javaParameterAddButtonBy = methods.getBy("javaParametersAddButtonInCreateScenario");
        methods.waitByMilliSeconds(300);
        methods.clearElement(javaParameterNameBy);
        methods.sendKeys(javaParameterNameBy,"newParameter");
        methods.waitByMilliSeconds(300);
        methods.clearElement(javaParameterValueBy);
        methods.sendKeys(javaParameterValueBy,"newValue");
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(javaParameterAddButtonBy);
        methods.checkElementClickable(javaParameterAddButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(javaParameterAddButtonBy);
    }

    public void v_Verify_Invalid_Create_Scenario_None_Project() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By errorBlockProjectNameBy = methods.getBy("errorBlockProjectNameInCreateScenario");
        By selectSourceFilePanelBy = methods.getBy("selectSourceFilePanelWindowInCreateScenario");
        By selectTestMethodsPanelBy = methods.getBy("selectTestMethodsPanelWindowInCreateScenario");
        methods.checkElementVisible(projectNameBy);
        Assert.assertTrue("", methods.getAttribute(projectNameBy,"class").contains("ng-invalid"));
        methods.checkElementVisible(errorBlockProjectNameBy);
        Assert.assertEquals("","This field is required.", methods.getText(errorBlockProjectNameBy).trim());
        methods.checkElementVisible(scenarioNameBy);
        Assert.assertTrue("", methods.getAttribute(scenarioNameBy,"class").contains("ng-valid"));
        methods.checkElementVisible(selectSourceFilePanelBy);
        Assert.assertTrue("", methods.getAttribute(selectSourceFilePanelBy,"class").contains("error-border"));
        methods.checkElementVisible(selectTestMethodsPanelBy);
        Assert.assertTrue("", methods.getAttribute(selectTestMethodsPanelBy,"class").contains("error-border"));
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(projectNameBy,"border-bottom-color"));
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(selectSourceFilePanelBy,"border-bottom-color"));
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(selectTestMethodsPanelBy,"border-bottom-color"));
    }

    public void v_Control_Edited_System_Parameter() {

        By javaParametersTableParameterBy = methods.getByWithKeySetValue("javaParametersTableParameterKeyValueInCreateScenario"
                , "newParameter!!newValue!!");
        By javaParametersEditButtonBy = methods.getByWithKeySetValue("javaParametersEditButtonKeyValueInCreateScenario"
                , "newParameter!!newValue!!");
        By javaParametersDeleteButtonBy = methods.getByWithKeySetValue("javaParametersDeleteButtonKeyValueInCreateScenario"
                , "newParameter!!newValue!!");
        Assert.assertTrue("", methods.isElementInVisible(javaParametersTableParameterBy,30));
        Assert.assertTrue("", methods.isElementInVisible(javaParametersEditButtonBy,30));
        Assert.assertTrue("", methods.isElementInVisible(javaParametersDeleteButtonBy,30));
        javaParametersTableParameterBy = methods.getByWithKeySetValue("javaParametersTableParameterKeyValueInCreateScenario"
                , "editedParameter!!editedValue!!");
        javaParametersEditButtonBy = methods.getByWithKeySetValue("javaParametersEditButtonKeyValueInCreateScenario"
                , "editedParameter!!editedValue!!");
        javaParametersDeleteButtonBy = methods.getByWithKeySetValue("javaParametersDeleteButtonKeyValueInCreateScenario"
                , "editedParameter!!editedValue!!");
        methods.checkElementVisible(javaParametersTableParameterBy);
        methods.checkElementVisible(javaParametersEditButtonBy);
        methods.checkElementVisible(javaParametersDeleteButtonBy);
    }

    public void v_Verify_System_Parameter_Is_Not_Available() {

        By javaParametersTableParameterBy = methods.getByWithKeySetValue("javaParametersTableParameterKeyValueInCreateScenario"
                , "editedParameter!!editedValue!!");
        By javaParametersEditButtonBy = methods.getByWithKeySetValue("javaParametersEditButtonKeyValueInCreateScenario"
                , "editedParameter!!editedValue!!");
        By javaParametersDeleteButtonBy = methods.getByWithKeySetValue("javaParametersDeleteButtonKeyValueInCreateScenario"
                , "editedParameter!!editedValue!!");
        Assert.assertTrue("", methods.isElementInVisible(javaParametersTableParameterBy,30));
        Assert.assertTrue("", methods.isElementInVisible(javaParametersEditButtonBy,30));
        Assert.assertTrue("", methods.isElementInVisible(javaParametersDeleteButtonBy,30));
    }

    public void e_Click_Save_Blank_Scenario_Name() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By saveButtonBy = methods.getBy("saveButtonInCreateScenario");
        methods.checkElementVisible(projectNameBy);
        methods.selectByVisibleText(projectNameBy
                , String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(scenarioNameBy);
        methods.clearElementWithBackSpace(scenarioNameBy);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
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

    public void v_Verify_Invalid_Create_Scenario_Blank_Scenario_Name() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        //By selectSourceFilePanelBy = methods.getBy("selectSourceFilePanelWindowInCreateScenario");
        //By selectTestMethodsPanelBy = methods.getBy("selectTestMethodsPanelWindowInCreateScenario");

        methods.checkElementVisible(projectNameBy);
        methods.checkElementVisible(scenarioNameBy);
        methods.waitByMilliSeconds(500);
        Assert.assertTrue("", methods.getAttribute(projectNameBy,"class").contains("ng-valid"));
        Assert.assertTrue("", methods.getAttribute(scenarioNameBy,"class").contains("ng-invalid"));
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(scenarioNameBy,"border-bottom-color"));
    }

    public void v_Verify_New_System_Parameter() {

        By javaParametersTableParameterBy = methods.getByWithKeySetValue("javaParametersTableParameterKeyValueInCreateScenario"
                , "newParameter!!newValue!!");
        By javaParametersEditButtonBy = methods.getByWithKeySetValue("javaParametersEditButtonKeyValueInCreateScenario"
                , "newParameter!!newValue!!");
        By javaParametersDeleteButtonBy = methods.getByWithKeySetValue("javaParametersDeleteButtonKeyValueInCreateScenario"
                , "newParameter!!newValue!!");
        methods.checkElementVisible(javaParametersTableParameterBy);
        methods.checkElementVisible(javaParametersEditButtonBy);
        methods.checkElementVisible(javaParametersDeleteButtonBy);
    }

    public void v_Control_Test_Methods() {

        By testCasesBy = methods.getBy("selectTestCaseInCreateScenario");
        methods.checkElementVisible(testCasesBy);
    }

    public void e_No_Action() {

    }

    public void e_Click_A_Test_Methods_File() {

        By sourceFileBy = methods.getByWithKeySetValue("selectSourceFileKeyValueContainInCreateScenario"
                , String.valueOf(methods.getValueInTestMap("testSourceFileName")));
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(methods.getBy("selectSourceFilePanelInCreateScenario"));
        methods.checkElementVisible(sourceFileBy);
        methods.waitByMilliSeconds(300);
        methods.checkElementClickable(sourceFileBy);
        methods.waitBySeconds(1);
        methods.clickElement(sourceFileBy);
    }

    public void e_Click_Save_Empty_Inputs() {

        //By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By saveButtonBy = methods.getBy("saveButtonInCreateScenario");
        methods.checkElementVisible(scenarioNameBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(scenarioNameBy);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void v_Control_New_Scenario() {

        String projectName = methods.getValueInTestMap("currentProject").toString();
        String scenarioName = methods.getValueInTestMap("newScenarioName").toString();
        By tableScenarioBy = methods.getByWithKeySetValue("tableScenarioNameKeyValueInAllScenarios"
                , projectName + "!!" + scenarioName);
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario",75,"equal"));
        methods.checkElementVisible(methods.getBy("allScenariosLogoTitleInAllScenarios"));
        methods.checkElementVisible(methods.getBy("projectSelectInAllScenarios"));
        methods.checkElementVisible(methods.getBy("suiteSelectInAllScenarios"));
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methods.waitByMilliSeconds(500);
        methods.selectByVisibleText(projectSelectBy
                , String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(projectSelectBy);
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(methods.getByWithKeySetValue("tableScenarioWithProjectNameInAllScenarios"
                , projectName));
        Assert.assertTrue("", methods.isElementInVisible(methods
                .getByWithKeySetValue("tableScenarioWithNotProjectNameInAllScenarios", projectName),30));

        By planCountBy = methods.getBy("planCountTextInAllSuites");
        methods.checkElementVisible(planCountBy);
        methods.waitByMilliSeconds(500);
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
            methods.checkElementVisible(paginationPanelBy);
            methods.checkElementVisible(paginationPrevBy);
            methods.checkElementVisible(paginationNextBy);
            for (int i = 1; i < pageCount+1; i++){

                if (i!=1){
                    methods.checkElementVisible(paginationPanelBy);
                    methods.checkElementVisible(paginationPrevBy);
                    methods.checkElementVisible(paginationNextBy);
                    methods.checkElementClickable(paginationNextBy);
                    methods.waitByMilliSeconds(300);
                    methods.clickElement(paginationNextBy);
                    methods.waitByMilliSeconds(200);
                    methods.checkElementVisible(paginationPanelBy);
                }

                methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
                Assert.assertTrue("", methods.doesAttributeValue(methods
                                .getByWithKeySetValue("paginationPageWithNumberInAllSuites", String.valueOf(i))
                        ,"class","active","contain",50));
                methods.checkElementVisible(methods.getByWithKeySetValue("tableScenarioWithProjectNameInAllScenarios"
                        , projectName));
                if(methods.isElementVisible(tableScenarioBy,3)){
                    isScenarioVisible = true;
                    break;
                }
            }
            if (!isScenarioVisible){
                Assert.fail(projectName + " projesinin " + scenarioName + " senaryosu bulunamadı.");
            }
        }else {
            methods.checkElementVisible(tableScenarioBy);
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
        By javaParametersEditButtonBy = methods.getByWithKeySetValue("javaParametersEditButtonKeyValueInCreateScenario"
                , "newParameter!!newValue!!");

        methods.checkElementClickable(javaParametersEditButtonBy);
        methods.waitByMilliSeconds(200);
        methods.clickElement(javaParametersEditButtonBy);
        Assert.assertTrue("", methods.isElementInVisible(javaParameterAddButtonBy,30));
        methods.checkElementVisible(javaParameterCancelButtonBy);
        methods.checkElementVisible(javaParameterSaveButtonBy);
        methods.checkElementVisible(javaParameterNameBy);
        methods.checkElementVisible(javaParameterValueBy);
        methods.waitByMilliSeconds(300);
        methods.clearElement(javaParameterNameBy);
        methods.sendKeys(javaParameterNameBy,"editedParameter");
        methods.waitByMilliSeconds(300);
        methods.clearElement(javaParameterValueBy);
        methods.sendKeys(javaParameterValueBy,"editedValue");
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(javaParameterSaveButtonBy);
        methods.checkElementClickable(javaParameterSaveButtonBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(javaParameterSaveButtonBy);
    }

    public void e_No_action() {

    }

    public void v_Control_Project_Source_Files() {

        By sourceFilesBy = methods.getBy("selectSourceFileInCreateScenario");
        methods.checkElementVisible(sourceFilesBy);
    }

    public void e_no_Action() {

    }

    public void e_Select_A_Project() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(200);
        methods.selectByVisibleText(projectNameBy
                , String.valueOf(methods.getValueInTestMap("appiumProject")));
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.selectByVisibleText(projectNameBy
                , String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(projectNameBy);
    }

    public void e_Click_Save_No_Selected_Project() {

        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By saveButtonBy = methods.getBy("saveButtonInCreateScenario");
        methods.checkElementVisible(scenarioNameBy);
        methods.waitByMilliSeconds(300);
        methods.clearElement(scenarioNameBy);
        methods.sendKeys(scenarioNameBy,"newScenarioName");
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.clickElement(saveButtonBy);
    }

    public void e_Create_New_Scenario() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By saveButtonBy = methods.getBy("saveButtonInCreateScenario");
        By testMethodBy = methods.getByWithKeySetValue("selectTestCaseKeyValueContainInCreateScenario"
                , String.valueOf(methods.getValueInTestMap("testMethodFileName")));
        By testSourceFileBy = methods.getByWithKeySetValue("selectSourceFileKeyValueContainInCreateScenario"
                , String.valueOf(methods.getValueInTestMap("testSourceFileName")));
        methods.checkElementVisible(projectNameBy);
        methods.checkElementVisible(scenarioNameBy);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(projectNameBy);
        methods.waitByMilliSeconds(500);
        methods.selectByVisibleText(projectNameBy, String.valueOf(methods.getValueInTestMap("appiumProject")));
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(projectNameBy);
        methods.checkElementClickable(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.selectByVisibleText(projectNameBy, String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.waitBySeconds(1);
        methods.checkElementVisible(projectNameBy);
        methods.clearElement(scenarioNameBy);
        methods.waitByMilliSeconds(300);
        String newScenarioName = "newScenarioName" + methods.randomString(6);
        methods.sendKeys(scenarioNameBy, newScenarioName);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(scenarioNameBy);
        methods.checkElementVisible(methods.getBy("selectSourceFilePanelInCreateScenario"));
        methods.checkElementVisible(methods.getBy("selectTestMethodsPanelInCreateScenario"));
        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(testSourceFileBy);
        methods.checkElementClickable(testSourceFileBy);
        methods.clickElement(testSourceFileBy);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(testMethodBy);
        methods.checkElementClickable(testMethodBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(testMethodBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(saveButtonBy);
        methods.focusToElementJs(saveButtonBy);
        methods.waitBySeconds(1);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(saveButtonBy);
        methods.putValueInTestMap("newScenarioName", newScenarioName);
        modelLocationStillCreateScenarioPage = false;
    }

    public void e_Delete_New_System_Parameter() {

        By javaParametersDeleteButtonBy = methods.getByWithKeySetValue("javaParametersDeleteButtonKeyValueInCreateScenario"
                , "editedParameter!!editedValue!!");
        methods.checkElementClickable(javaParametersDeleteButtonBy);
        methods.waitByMilliSeconds(250);
        methods.clickElement(javaParametersDeleteButtonBy);
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInCreateScenario");
        methods.checkElementVisible(cancelButtonBy);
        methods.checkElementClickable(cancelButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(cancelButtonBy);
        modelLocationStillCreateScenarioPage = false;
    }

    public void v_Verify_Invalid_Create_Scenario_Empty_Inputs() {

        By projectNameBy = methods.getBy("projectNameInCreateScenario");
        By scenarioNameBy = methods.getBy("scenarioNameInCreateScenario");
        By errorBlockProjectNameBy = methods.getBy("errorBlockProjectNameInCreateScenario");
        By selectSourceFilePanelBy = methods.getBy("selectSourceFilePanelWindowInCreateScenario");
        By selectTestMethodsPanelBy = methods.getBy("selectTestMethodsPanelWindowInCreateScenario");
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(500);
        Assert.assertTrue("", methods.getAttribute(projectNameBy,"class").contains("ng-invalid"));
        methods.checkElementVisible(errorBlockProjectNameBy);
        Assert.assertEquals("","This field is required.", methods.getText(errorBlockProjectNameBy).trim());
        methods.checkElementVisible(scenarioNameBy);
        Assert.assertTrue("", methods.getAttribute(scenarioNameBy,"class").contains("ng-invalid"));
        methods.checkElementVisible(selectSourceFilePanelBy);
        Assert.assertTrue("", methods.getAttribute(selectSourceFilePanelBy,"class").contains("error-border"));
        methods.checkElementVisible(selectTestMethodsPanelBy);
        Assert.assertTrue("", methods.getAttribute(selectTestMethodsPanelBy,"class").contains("error-border"));
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(projectNameBy,"border-bottom-color"));
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(scenarioNameBy,"border-bottom-color"));
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(selectSourceFilePanelBy,"border-bottom-color"));
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(selectTestMethodsPanelBy,"border-bottom-color"));
        //#d0021b
        // border-bottom-color
        // #4a4a4a
    }

    public void e_no_action() {

    }
}
