package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.common.CommonProcess;
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
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class AllScenarios extends ExecutionContext implements org.graphwalker.All_Scenarios {

    private static final Logger logger = LogManager.getLogger(AllScenarios.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public AllScenarios(){

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
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
        commonProcess.clickButton(noButtonBy);
    }

    public void e_Select_A_Suite() {

        By suiteSelectBy = methods.getBy("suiteSelectInAllScenarios");
        commonProcess.checkElementVisible(suiteSelectBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.selectByVisibleText(suiteSelectBy,"All Suites");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(suiteSelectBy);
        //By suiteSelectOptionBy = commonProcess.getKeyValueChangerElement("suiteSelectOptionInAllScenarios","1:");
        //methods.doesElementExist(suiteSelectOptionBy,50);
        //commonProcess.checkElementVisible(suiteSelectBy);
        //methods.selectByVisibleText(suiteSelectBy
        //        , String.valueOf(methodsUtil.getValueInTestMap("currentSuite")));
        methodsUtil.waitByMilliSeconds(500);
        //methods.clickElement(suiteSelectOptionBy);
        methods.selectByIndex(suiteSelectBy,1);
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.checkElementVisible(suiteSelectBy);
    }

    public void v_Verify_In_Create_Scenario_Page_SHARED() {

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

    // none project
    public void e_click_Delete_Button() {
        
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
        commonProcess.checkElementClickable(methods.getBy("deleteButtonInAllScenarios"));
        methodsUtil.waitByMilliSeconds(500);
        By tableProjectNameBy = commonProcess.getKeyValueChangerElement("tableProjectNameWithNotProjectNameInAllScenarios","tableProjectNameWithNotProjectName1InAllScenarios",
                methodsUtil.getValueInTestMap("editProject") + "!!" + methodsUtil.getValueInTestMap("appiumProject") + "!!" + "last()");
        By tableScenarioNameBy = commonProcess.getKeyValueChangerElement("tableScenarioNameWithNotProjectNameInAllScenarios","tableScenarioNameWithNotProjectName1InAllScenarios",
                methodsUtil.getValueInTestMap("editProject") + "!!" + methodsUtil.getValueInTestMap("appiumProject") + "!!" + "last()");
        commonProcess.checkElementVisible(tableProjectNameBy);
        commonProcess.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By deleteButtonBy = commonProcess.getKeyValueChangerElement("deleteButtonTableScenarioKeyValueInAllScenarios","deleteButtonTableScenarioKeyValue1InAllScenarios"
                , projectName + "!!" + scenarioName);
        commonProcess.clickButton(deleteButtonBy);
        methodsUtil.putValueInTestMap("deleteProject", projectName);
        methodsUtil.putValueInTestMap("deleteScenario", scenarioName);
    }

    public void v_Verify_List_Scenarios_For_Selected_Suite() {

        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("scenarioWithTableProjectInAllScenarios","scenarioWithTableProject1InAllScenarios", String.valueOf(methodsUtil.getValueInTestMap("currentProject"))),30));
        assertTrue(methods.isElementInVisible(commonProcess.getKeyValueChangerElement("scenarioWithTableNotProjectInAllScenarios","scenarioWithTableNotProject1InAllScenarios"
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject"))),30));
    }

    public void e_Click_Create_Button() {

        By createScenarioBy = methods.getBy("createScenarioInAllScenarios");
        commonProcess.clickButton(createScenarioBy);
        methodsUtil.putValueInTestMap("projectSelectedForScenario",false);
    }

    //selected project
    public void e_Click_Edit_Button() {

        methodsUtil.waitBySeconds(1);
        By tableProjectNameBy = commonProcess.getKeyValueChangerElement("tableProjectNameInAllScenarios","tableProjectName1InAllScenarios","1");
        By tableScenarioNameBy = commonProcess.getKeyValueChangerElement("tableScenarioNameInAllScenarios","tableScenarioName1InAllScenarios","1");
        commonProcess.checkElementVisible(tableProjectNameBy);
        commonProcess.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By editButtonBy = commonProcess.getKeyValueChangerElement("editButtonTableScenarioKeyValueInAllScenarios","editButtonTableScenarioKeyValue1InAllScenarios"
                , projectName + "!!" + scenarioName);
        commonProcess.clickButton(editButtonBy);
        methodsUtil.putValueInTestMap("currentProject", projectName);
        methodsUtil.putValueInTestMap("currentScenario", scenarioName);
    }

    public void e_Select_All_Project() {

        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methods.selectByVisibleText(projectSelectBy,"All Projects");
        commonProcess.checkElementVisible(projectSelectBy);
    }

    public void e_No_Action() {

    }

    public void e_Click_Yes_Button() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        commonProcess.clickButton(yesButtonBy);
    }

    public void v_Verify_In_Create_New_Group_Page_SHARED() {

        /**
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
         */
    }

    public void e_Click_Create_New_Group() {

        By createNewGroupBy = methods.getBy("createNewGroupInAllScenarios");
        commonProcess.clickButton(createNewGroupBy);
    }

    public void v_Verify_In_Scenario_Edit_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/scenario/edit/",75,"startWith"));
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

    public void e_Select_A_Project() {

        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(projectSelectBy);
        methods.selectByVisibleText(projectSelectBy, String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(projectSelectBy);
    }

    public void v_Verify_Scenarios_Table_For_Selected_Project() {

        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        assertTrue(methods.isElementInVisible(commonProcess.getKeyValueChangerElement("scenarioWithTableNotProjectInAllScenarios","scenarioWithTableNotProject1InAllScenarios"
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject"))),30));
        methodsUtil.waitByMilliSeconds(500);
        assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("scenarioWithTableProjectInAllScenarios","scenarioWithTableProject1InAllScenarios"
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject"))),30));
    }

    public void v_Verify_Scenario_Still_Is_Available() {

        By tableScenarioBy = commonProcess.getKeyValueChangerElement("tableScenarioNameKeyValueInAllScenarios","tableScenarioNameKeyValue1InAllScenarios"
                , String.valueOf(methodsUtil.getValueInTestMap("deleteProject")) + "!!"
                        + String.valueOf(methodsUtil.getValueInTestMap("deleteScenario")));
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("scenarioForTableInAllScenarios"));
        assertTrue(methods.isElementVisible(tableScenarioBy,30),"Senaryo bulunamadı");
    }

    public void v_Control_Are_You_Sure_Message() {

        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementClickable(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementClickable(methods.getBy("popupNoButtonInProjects"));
    }

    //none project
    public void e_click_Edit_Button() {

        methodsUtil.waitBySeconds(1);
        By tableProjectNameBy = commonProcess.getKeyValueChangerElement("tableProjectNameInAllScenarios","tableProjectName1InAllScenarios","1");
        By tableScenarioNameBy = commonProcess.getKeyValueChangerElement("tableScenarioNameInAllScenarios","tableScenarioName1InAllScenarios","1");
        commonProcess.checkElementVisible(tableProjectNameBy);
        commonProcess.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By editButtonBy = commonProcess.getKeyValueChangerElement("editButtonTableScenarioKeyValueInAllScenarios","editButtonTableScenarioKeyValue1InAllScenarios"
                , projectName + "!!" + scenarioName);
        commonProcess.clickButton(editButtonBy);
        methodsUtil.putValueInTestMap("currentProject", projectName);
        methodsUtil.putValueInTestMap("currentScenario", scenarioName);
    }

    //selected suite
    public void e_Click_delete_Button() {

        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
        commonProcess.checkElementClickable(methods.getBy("deleteButtonInAllScenarios"));
        methodsUtil.waitByMilliSeconds(500);
        By tableProjectNameBy = commonProcess.getKeyValueChangerElement("tableProjectNameWithNotProjectNameInAllScenarios","tableProjectNameWithNotProjectName1InAllScenarios",
                methodsUtil.getValueInTestMap("editProject")+ "!!" + methodsUtil.getValueInTestMap("appiumProject") + "!!" + "last()");
        By tableScenarioNameBy = commonProcess.getKeyValueChangerElement("tableScenarioNameWithNotProjectNameInAllScenarios","tableScenarioNameWithNotProjectName1InAllScenarios",
                methodsUtil.getValueInTestMap("editProject")+ "!!" + methodsUtil.getValueInTestMap("appiumProject") + "!!" + "last()");
        commonProcess.checkElementVisible(tableProjectNameBy);
        commonProcess.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By deleteButtonBy = commonProcess.getKeyValueChangerElement("deleteButtonTableScenarioKeyValueInAllScenarios","deleteButtonTableScenarioKeyValue1InAllScenarios"
                , projectName + "!!" + scenarioName);
        commonProcess.clickButton(deleteButtonBy);
        methodsUtil.putValueInTestMap("deleteProject", projectName);
        methodsUtil.putValueInTestMap("deleteScenario", scenarioName);
    }

    public void v_Verify_In_All_Scenarios_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/scenario",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosLogoTitleInAllScenarios"));
        By projectSelectBy = methods.getBy("projectSelectInAllScenarios");
        commonProcess.checkElementVisible(projectSelectBy);
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

        methodsUtil.waitByMilliSeconds(500);
        methods.selectByVisibleText(projectSelectBy, methodsUtil.getValueInTestMap("appiumProject").toString());
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(projectSelectBy);
        methods.selectByVisibleText(projectSelectBy,"All Projects");
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(projectSelectBy);
        methods.selectByVisibleText(methods.getBy("suiteSelectInAllScenarios"),"All Suites");
        methodsUtil.putValueInTestMap("currentProject", methodsUtil.getValueInTestMap("optionalProject").toString());
        methodsUtil.waitByMilliSeconds(500);
    }

    /**
     * TODO: sfdsgh
     */
    // selected project
    public void e_Click_Delete_Button() {

        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        commonProcess.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(methods.getBy("deleteButtonInAllScenarios"));
        commonProcess.checkElementClickable(methods.getBy("deleteButtonInAllScenarios"));
        methodsUtil.waitByMilliSeconds(500);
        By tableProjectNameBy = commonProcess.getKeyValueChangerElement("tableProjectNameWithNotProjectNameInAllScenarios","tableProjectNameWithNotProjectName1InAllScenarios",
                methodsUtil.getValueInTestMap("editProject") + "!!" + methodsUtil.getValueInTestMap("appiumProject") + "!!" + "last()");
        By tableScenarioNameBy = commonProcess.getKeyValueChangerElement("tableScenarioNameWithNotProjectNameInAllScenarios","tableScenarioNameWithNotProjectName1InAllScenarios",
                methodsUtil.getValueInTestMap("editProject") + "!!" + methodsUtil.getValueInTestMap("appiumProject") + "!!" + "last()");
        commonProcess.checkElementVisible(tableProjectNameBy);
        commonProcess.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By deleteButtonBy = commonProcess.getKeyValueChangerElement("deleteButtonTableScenarioKeyValueInAllScenarios","deleteButtonTableScenarioKeyValue1InAllScenarios"
                , projectName + "!!" + scenarioName);
        commonProcess.clickButton(deleteButtonBy);
        methodsUtil.putValueInTestMap("deleteProject", projectName);
        methodsUtil.putValueInTestMap("deleteScenario", scenarioName);
    }

    public void v_Verify_Scenario_Is_Not_Available() {

        By tableScenarioBy = commonProcess.getKeyValueChangerElement("tableScenarioNameKeyValueInAllScenarios","tableScenarioNameKeyValue1InAllScenarios"
                , String.valueOf(methodsUtil.getValueInTestMap("deleteProject")) + "!!"
                        + String.valueOf(methodsUtil.getValueInTestMap("deleteScenario")));
        commonProcess.checkElementVisible(methods.getBy("tableInAllScenarios"));
        assertTrue(methods.isElementInVisible(tableScenarioBy,30),"Senaryo halen mevcut");
    }

    //selected suite
    public void e_Click_edit_Button() {

        methodsUtil.waitBySeconds(1);
        By tableProjectNameBy = commonProcess.getKeyValueChangerElement("tableProjectNameInAllScenarios","tableProjectName1InAllScenarios","1");
        By tableScenarioNameBy = commonProcess.getKeyValueChangerElement("tableScenarioNameInAllScenarios","tableScenarioName1InAllScenarios","1");
        commonProcess.checkElementVisible(tableProjectNameBy);
        commonProcess.checkElementVisible(tableScenarioNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String projectName = methods.getText(tableProjectNameBy).trim();
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(tableScenarioNameBy).trim();
        By editButtonBy = commonProcess.getKeyValueChangerElement("editButtonTableScenarioKeyValueInAllScenarios","editButtonTableScenarioKeyValue1InAllScenarios"
                , projectName + "!!" + scenarioName);
        commonProcess.clickButton(editButtonBy);
        methodsUtil.putValueInTestMap("currentProject", projectName);
        methodsUtil.putValueInTestMap("currentScenario", scenarioName);
    }
}
