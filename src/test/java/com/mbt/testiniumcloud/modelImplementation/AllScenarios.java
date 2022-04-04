package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.methods.MethodsUtil;
import com.mbt.testiniumcloud.utils.CoverageValue;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.SharedNodeControl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class AllScenarios extends ExecutionContext implements org.graphwalker.All_Scenarios {

    private static final Logger logger = LogManager.getLogger(AllScenarios.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public AllScenarios(){

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(AllScenarios.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void e_Click_No_Button() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.checkElementClickable(noButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void e_Select_A_Suite() {

        By suiteSelectBy = methods.getBy("suiteSelectInAllScenarios");
        methods.checkElementVisible(suiteSelectBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.selectByVisibleText(suiteSelectBy,"All Suites");
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementVisible(suiteSelectBy);
        //By suiteSelectOptionBy = methods.getByWithKeySetValue("suiteSelectOptionInAllScenarios","1:");
        //methods.doesElementExist(suiteSelectOptionBy,50);
        //methods.checkElementVisible(suiteSelectBy);
        //methods.selectByVisibleText(suiteSelectBy
        //        , String.valueOf(methods.getValueInTestMap("currentSuite")));
        methodsUtil.waitByMilliSeconds(500);
        //methods.clickElement(suiteSelectOptionBy);
        methods.selectByIndex(suiteSelectBy,1);
        methodsUtil.waitByMilliSeconds(200);
        methods.checkElementVisible(suiteSelectBy);
    }

    public void v_Verify_In_Create_Scenario_Page_SHARED() {

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

    // none project
    public void e_click_Delete_Button() {

        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
       methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
       methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
        methods.checkElementClickable(methods.getBy("deleteButtonInAllScenarios"));
        methodsUtil.waitByMilliSeconds(500);
        By tableProjectNameBy = methods.getByWithKeySetValue("tableProjectNameWithNotProjectNameInAllScenarios",
                methods.getValueInTestMap("editProject") + "!!" + methods.getValueInTestMap("appiumProject") + "!!" + "last()");
        By tableScenarioNameBy = methods.getByWithKeySetValue("tableScenarioNameWithNotProjectNameInAllScenarios",
                methods.getValueInTestMap("editProject") + "!!" + methods.getValueInTestMap("appiumProject") + "!!" + "last()");
        methods.checkElementVisible(tableProjectNameBy);
        methods.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By deleteButtonBy = methods.getByWithKeySetValue("deleteButtonTableScenarioKeyValueInAllScenarios"
                , projectName + "!!" + scenarioName);
        methods.checkElementVisible(deleteButtonBy);
        methods.checkElementClickable(deleteButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(deleteButtonBy);
        methods.putValueInTestMap("deleteProject", projectName);
        methods.putValueInTestMap("deleteScenario", scenarioName);
    }

    public void v_Verify_List_Scenarios_For_Selected_Suite() {

        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        Assert.assertTrue("", methods.isElementVisible(methods.getByWithKeySetValue("scenarioWithTableProjectInAllScenarios"
                , String.valueOf(methods.getValueInTestMap("currentProject"))),30));
        Assert.assertTrue("", methods.isElementInVisible(methods.getByWithKeySetValue("scenarioWithTableNotProjectInAllScenarios"
                , String.valueOf(methods.getValueInTestMap("currentProject"))),30));
    }

    public void e_Click_Create_Button() {

        By createScenarioBy = methods.getBy("createScenarioInAllScenarios");
        methods.checkElementVisible(createScenarioBy);
        methods.checkElementClickable(createScenarioBy);
       methodsUtil.waitBySeconds(1);
        methods.clickElement(createScenarioBy);
        methods.putValueInTestMap("projectSelectedForScenario",false);
    }

    //selected project
    public void e_Click_Edit_Button() {

       methodsUtil.waitBySeconds(1);
        By tableProjectNameBy = methods.getByWithKeySetValue("tableProjectNameInAllScenarios","1");
        By tableScenarioNameBy = methods.getByWithKeySetValue("tableScenarioNameInAllScenarios","1");
        methods.checkElementVisible(tableProjectNameBy);
        methods.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By editButtonBy = methods.getByWithKeySetValue("editButtonTableScenarioKeyValueInAllScenarios"
                , projectName + "!!" + scenarioName);
        methods.checkElementVisible(editButtonBy);
        methods.checkElementClickable(editButtonBy);
       methodsUtil.waitBySeconds(1);
        methods.clickElement(editButtonBy);
        methods.putValueInTestMap("currentProject", projectName);
        methods.putValueInTestMap("currentScenario", scenarioName);
    }

    public void e_Select_All_Project() {

        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methods.selectByVisibleText(projectSelectBy,"All Projects");
        methods.checkElementVisible(projectSelectBy);
    }

    public void e_No_Action() {

    }

    public void e_Click_Yes_Button() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        methods.checkElementVisible(yesButtonBy);
       methodsUtil.waitBySeconds(1);
        methods.checkElementClickable(yesButtonBy);
       methodsUtil.waitBySeconds(1);
        methods.clickElement(yesButtonBy);
    }

    public void v_Verify_In_Create_New_Group_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario/group/create",75,"equal"));
        methods.checkElementVisible(methods.getBy("projectNameInCreateNewGroup"));
        methods.checkElementVisible(methods.getBy("scenarioNameInCreateNewGroup"));
        methods.checkElementVisible(methods.getBy("scenarioDescriptionInCreateNewGroup"));
        methods.checkElementVisible(methods.getBy("cancelButtonInCreateNewGroup"));
        methods.checkElementVisible(methods.getBy("saveButtonInCreateNewGroup"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_Click_Create_New_Group() {

        By createNewGroupBy = methods.getBy("createNewGroupInAllScenarios");
        methods.checkElementVisible(createNewGroupBy);
        methods.checkElementClickable(createNewGroupBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(createNewGroupBy);
    }

    public void v_Verify_In_Scenario_Edit_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario/edit/",75,"startWith"));
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

    public void e_Select_A_Project() {

        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementVisible(projectSelectBy);
        methods.selectByVisibleText(projectSelectBy
                , String.valueOf(methods.getValueInTestMap("currentProject")));
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementVisible(projectSelectBy);
    }

    public void v_Verify_Scenarios_Table_For_Selected_Project() {

        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        Assert.assertTrue("", methods.isElementInVisible(methods.getByWithKeySetValue("scenarioWithTableNotProjectInAllScenarios"
                , String.valueOf(methods.getValueInTestMap("currentProject"))),30));
        methodsUtil.waitByMilliSeconds(500);
        Assert.assertTrue("", methods.isElementVisible(methods.getByWithKeySetValue("scenarioWithTableProjectInAllScenarios"
                , String.valueOf(methods.getValueInTestMap("currentProject"))),30));
    }

    public void v_Verify_Scenario_Still_Is_Available() {

        By tableScenarioBy = methods.getByWithKeySetValue("tableScenarioNameKeyValueInAllScenarios"
                , String.valueOf(methods.getValueInTestMap("deleteProject")) + "!!"
                        + String.valueOf(methods.getValueInTestMap("deleteScenario")));
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.checkElementVisible(methods.getBy("scenarioForTableInAllScenarios"));
        Assert.assertTrue("Senaryo bulunamadı", methods.isElementVisible(tableScenarioBy,30));
    }

    public void v_Control_Are_You_Sure_Message() {

        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
       methodsUtil.waitBySeconds(1);
        methods.checkElementClickable(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementClickable(methods.getBy("popupNoButtonInProjects"));
    }

    //none project
    public void e_click_Edit_Button() {

       methodsUtil.waitBySeconds(1);
        By tableProjectNameBy = methods.getByWithKeySetValue("tableProjectNameInAllScenarios","1");
        By tableScenarioNameBy = methods.getByWithKeySetValue("tableScenarioNameInAllScenarios","1");
        methods.checkElementVisible(tableProjectNameBy);
        methods.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By editButtonBy = methods.getByWithKeySetValue("editButtonTableScenarioKeyValueInAllScenarios"
                , projectName + "!!" + scenarioName);
        methods.checkElementVisible(editButtonBy);
        methods.checkElementClickable(editButtonBy);
        methods.clickElement(editButtonBy);
        methods.putValueInTestMap("currentProject", projectName);
        methods.putValueInTestMap("currentScenario", scenarioName);
    }

    //selected suite
    public void e_Click_delete_Button() {

        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
       methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
       methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
        methods.checkElementClickable(methods.getBy("deleteButtonInAllScenarios"));
        methodsUtil.waitByMilliSeconds(500);
        By tableProjectNameBy = methods.getByWithKeySetValue("tableProjectNameWithNotProjectNameInAllScenarios",
                methods.getValueInTestMap("editProject")+ "!!" + methods.getValueInTestMap("appiumProject") + "!!" + "last()");
        By tableScenarioNameBy = methods.getByWithKeySetValue("tableScenarioNameWithNotProjectNameInAllScenarios",
                methods.getValueInTestMap("editProject")+ "!!" + methods.getValueInTestMap("appiumProject") + "!!" + "last()");
        methods.checkElementVisible(tableProjectNameBy);
        methods.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By deleteButtonBy = methods.getByWithKeySetValue("deleteButtonTableScenarioKeyValueInAllScenarios"
                , projectName + "!!" + scenarioName);
        methods.checkElementVisible(deleteButtonBy);
        methods.checkElementClickable(deleteButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(deleteButtonBy);
        methods.putValueInTestMap("deleteProject", projectName);
        methods.putValueInTestMap("deleteScenario", scenarioName);
    }

    public void v_Verify_In_All_Scenarios_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario",75,"equal"));
        methods.checkElementVisible(methods.getBy("allScenariosLogoTitleInAllScenarios"));
        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methods.checkElementVisible(projectSelectBy);
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

        methodsUtil.waitByMilliSeconds(500);
        methods.selectByVisibleText(projectSelectBy, methods.getValueInTestMap("appiumProject").toString());
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementVisible(projectSelectBy);
        methods.selectByVisibleText(projectSelectBy,"All Projects");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementVisible(projectSelectBy);
        methods.selectByVisibleText(methods.getBy("suiteSelectInAllScenarios"),"All Suites");
        methods.putValueInTestMap("currentProject", methods.getValueInTestMap("optionalProject").toString());
        methodsUtil.waitByMilliSeconds(500);
    }

    /**
     * TODO: sfdsgh
     */
    // selected project
    public void e_Click_Delete_Button() {

        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
       methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
       methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
        methods.checkElementClickable(methods.getBy("deleteButtonInAllScenarios"));
        methodsUtil.waitByMilliSeconds(500);
        By tableProjectNameBy = methods.getByWithKeySetValue("tableProjectNameWithNotProjectNameInAllScenarios",
                methods.getValueInTestMap("editProject") + "!!" + methods.getValueInTestMap("appiumProject") + "!!" + "last()");
        By tableScenarioNameBy = methods.getByWithKeySetValue("tableScenarioNameWithNotProjectNameInAllScenarios",
                methods.getValueInTestMap("editProject") + "!!" + methods.getValueInTestMap("appiumProject") + "!!" + "last()");
        methods.checkElementVisible(tableProjectNameBy);
        methods.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By deleteButtonBy = methods.getByWithKeySetValue("deleteButtonTableScenarioKeyValueInAllScenarios"
                , projectName + "!!" + scenarioName);
        methods.checkElementVisible(deleteButtonBy);
        methods.checkElementClickable(deleteButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(deleteButtonBy);
        methods.putValueInTestMap("deleteProject", projectName);
        methods.putValueInTestMap("deleteScenario", scenarioName);
    }

    public void v_Verify_Scenario_Is_Not_Available() {

        By tableScenarioBy = methods.getByWithKeySetValue("tableScenarioNameKeyValueInAllScenarios"
                , String.valueOf(methods.getValueInTestMap("deleteProject")) + "!!"
                        + String.valueOf(methods.getValueInTestMap("deleteScenario")));
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        Assert.assertTrue("Senaryo halen mevcut", methods.isElementInVisible(tableScenarioBy,30));
    }

    //selected suite
    public void e_Click_edit_Button() {

       methodsUtil.waitBySeconds(1);
        By tableProjectNameBy = methods.getByWithKeySetValue("tableProjectNameInAllScenarios","1");
        By tableScenarioNameBy = methods.getByWithKeySetValue("tableScenarioNameInAllScenarios","1");
        methods.checkElementVisible(tableProjectNameBy);
        methods.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By editButtonBy = methods.getByWithKeySetValue("editButtonTableScenarioKeyValueInAllScenarios"
                , projectName + "!!" + scenarioName);
        methods.checkElementVisible(editButtonBy);
        methods.checkElementClickable(editButtonBy);
        methods.clickElement(editButtonBy);
        methods.putValueInTestMap("currentProject", projectName);
        methods.putValueInTestMap("currentScenario", scenarioName);
    }
}
