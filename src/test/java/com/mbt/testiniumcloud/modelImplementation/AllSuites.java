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
import org.graalvm.polyglot.Value;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class AllSuites extends ExecutionContext implements org.graphwalker.All_Suites {

    private static final Logger logger = LogManager.getLogger(AllSuites.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public AllSuites() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
        commonProcess = new CommonProcess();
        methodsUtil.putValueInTestMap("allSuitesMobile",false);
        Configurator.setLevel(getLogger(AllSuites.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void e_click_Mobile_Checbox() {

        By iosOptionBy = methods.getBy("mobileIosShowOnlyOptionInAllSuites");
        commonProcess.clickButton(iosOptionBy);
        By androidOptionBy = methods.getBy("mobileAndroidShowOnlyOptionInAllSuites");
        commonProcess.clickButton(androidOptionBy);
        methodsUtil.putValueInTestMap("allSuitesMobile",true);
    }

    public void e_Click_Create_Button() {

        By createButtonBy = methods.getBy("createPlanInAllSuites");
        commonProcess.clickButton(createButtonBy);
        methodsUtil.putValueInTestMap("projectSelectedForPlan",false);
    }

    public void v_Verify_In_All_Suites_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/plan",75,"equal"));
        assertTrue(methods.isElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"),30));
        By selectProjectBy = methods.getBy("selectProjectInAllSuites");
        assertTrue(methods.isElementVisible(selectProjectBy,30));
        assertTrue(methods.isElementVisible(methods.getBy("exportTableInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("createPlanInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("tableInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("suiteForTableInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("mobileIosShowOnlyOptionInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("mobileAndroidShowOnlyOptionInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("webAllShowOnlyOptionInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("webFirefoxShowOnlyOptionInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("webChromeShowOnlyOptionInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("webIEShowOnlyOptionInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("webSafariShowOnlyOptionInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("webOperaShowOnlyOptionInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("webEdgeShowOnlyOptionInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("runningSuitesShowOnlyOptionInAllSuites"),30));

         assertTrue(methods.isElementVisible(methods.getBy("dashboardButton"),30));
         assertTrue(methods.isElementVisible(methods.getBy("projectsTab"),30));
         assertTrue(methods.isElementVisible(methods.getBy("allScenariosTab"),30));
         assertTrue(methods.isElementVisible(methods.getBy("allSuitesTab"),30));
         assertTrue(methods.isElementVisible(methods.getBy("reportsTab"),30));
         assertTrue(methods.isElementVisible(methods.getBy("automatedTestTab"),30));

        methodsUtil.waitByMilliSeconds(400);

        if(methods.getAttribute(commonProcess.getKeyValueChangerElement("checkboxShowOnlyOptionKeyValueInAllSuites"
                        ,"checkboxShowOnlyOptionValueInAllSuites","Mobile (iOS)"),"class")
                .contains("checked")){
            By iosOptionBy = methods.getBy("mobileIosShowOnlyOptionInAllSuites");
            commonProcess.clickButton(iosOptionBy);
            assertTrue(methods.isElementVisible(methods.getBy("tableInAllSuites"),30));
            assertTrue(methods.isElementVisible(methods.getBy("suiteForTableInAllSuites"),30));
            assertTrue(methods.isElementVisible(iosOptionBy,30));
        }
        if(methods.getAttribute(commonProcess.getKeyValueChangerElement("checkboxShowOnlyOptionKeyValueInAllSuites","checkboxShowOnlyOptionValueInAllSuites","Mobile (ANDROID)")
                ,"class").contains("checked")){
            By androidOptionBy = methods.getBy("mobileAndroidShowOnlyOptionInAllSuites");
            commonProcess.clickButton(androidOptionBy);
            assertTrue(methods.isElementVisible(methods.getBy("tableInAllSuites"),30));
            assertTrue(methods.isElementVisible(methods.getBy("suiteForTableInAllSuites"),30));
            assertTrue(methods.isElementVisible(androidOptionBy,30));
        }
        if(methods.getAttribute(commonProcess.getKeyValueChangerElement("checkboxShowOnlyOptionKeyValueInAllSuites","checkboxShowOnlyOptionValueInAllSuites","Web (All)")
                ,"class").contains("checked")){
            By webAllOptionBy = methods.getBy("webAllShowOnlyOptionInAllSuites");
            commonProcess.clickButton(webAllOptionBy);
            assertTrue(methods.isElementVisible(methods.getBy("tableInAllSuites"),30));
            assertTrue(methods.isElementVisible(methods.getBy("suiteForTableInAllSuites"),30));
            assertTrue(methods.isElementVisible(webAllOptionBy,30));
        }

        //if(!methods.getFirstSelectedOption(selectProjectBy)
          //      .getText().trim().equals("All Projects")){
        methodsUtil.waitByMilliSeconds(200);
        methods.selectByVisibleText(selectProjectBy, methodsUtil.getValueInTestMap("appiumProject").toString());
        methodsUtil.waitByMilliSeconds(200);
             assertTrue(methods.isElementVisible(selectProjectBy,30));
            methods.selectByVisibleText(selectProjectBy,"All Projects");
             assertTrue(methods.isElementVisible(selectProjectBy,30));
        methodsUtil.waitByMilliSeconds(500);
             assertTrue(methods.isElementVisible(methods.getBy("tableInAllSuites"),30));
             assertTrue(methods.isElementVisible(methods.getBy("suiteForTableInAllSuites"),30));
        //}

        methodsUtil.putValueInTestMap("currentProject", methodsUtil.getValueInTestMap("optionalProject").toString());
    }

    public void v_Verify_Suite_Is_Available() {

         assertTrue(methods.isElementVisible(methods.getBy("tableInAllSuites"),30));
         assertTrue(methods.isElementVisible(methods.getBy("suiteForTableInAllSuites"),30));
        methodsUtil.waitByMilliSeconds(500);
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("deleteProjectNameInAllSuites"));
        String planName = String.valueOf(methodsUtil.getValueInTestMap("deletePlanNameInAllSuites"));
        assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("tablePlanKeyValueInAllSuites","tablePlanKeyValue1InAllSuites"
                , projectName + "!!" + planName),30));
    }

    public void e_click_Web_Checkbox() {

        By webAllOptionBy = methods.getBy("webAllShowOnlyOptionInAllSuites");
        commonProcess.clickButton(webAllOptionBy);
    }

    //delete
    public void e_Click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        commonProcess.clickButton(yesButtonBy);
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/plan/create",75,"startWith"));
         assertTrue(methods.isElementVisible(methods.getBy("logoInCreatePlan"));
         assertTrue(methods.isElementVisible(methods.getBy("projectNameInCreatePlan"));
         assertTrue(methods.isElementVisible(methods.getBy("suiteNameInCreatePlan"));
         assertTrue(methods.isElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
         assertTrue(methods.isElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
         assertTrue(methods.isElementVisible(methods.getBy("cancelButtonInCreatePlan"));
         assertTrue(methods.isElementVisible(methods.getBy("saveButtonInCreatePlan"));

         assertTrue(methods.isElementVisible(methods.getBy("dashboardButton"));
         assertTrue(methods.isElementVisible(methods.getBy("projectsTab"));
         assertTrue(methods.isElementVisible(methods.getBy("allScenariosTab"));
         assertTrue(methods.isElementVisible(methods.getBy("allSuitesTab"));
         assertTrue(methods.isElementVisible(methods.getBy("reportsTab"));
         assertTrue(methods.isElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_Click_Report() {

        String projectName = String.valueOf(methodsUtil.getValueInTestMap("currentProject"));
        //By suiteNameBy = commonProcess.getKeyValueChangerElement("tableSuiteNameWithProjectNameReportInAllSuites", projectName);
        By suiteNameBy = commonProcess.getKeyValueChangerElement("tableSuiteNameWithProjectNameNumberReportInAllSuites","tableSuiteNameWithProjectNameNumberReport1InAllSuites",
                projectName + "!!" + "last()");
         assertTrue(methods.isElementVisible(suiteNameBy,30));
        methodsUtil.waitByMilliSeconds(500);
        String planName = methods.getText(suiteNameBy).trim().split(" ")[0];
        By reportButtonBy = commonProcess.getKeyValueChangerElement("reportButtonTableSuiteNameKeyValueInAllSuites","reportButtonTableSuiteNameKeyValue1InAllSuites"
                , projectName + "!!" + planName);
         assertTrue(methods.isElementVisible(reportButtonBy,30));
        commonProcess.clickButton(reportButtonBy);
        methodsUtil.putValueInTestMap("currentPlan", planName);
    }

    public void v_Control_Suite_Table_For_Only_Selected_Project() {

        String projectName = String.valueOf(methodsUtil.getValueInTestMap("currentProject"));
        By tableSuiteNameBy = commonProcess.getKeyValueChangerElement("tablePlanKeyValueInAllSuites","tablePlanValueInAllSuites"
                , projectName + "!!" + "");
        By tableSuiteNameNotProjectBy = commonProcess.getKeyValueChangerElement("tablePlanKeyValueNotProjectInAllSuites","tablePlanValueNotProjectInAllSuites"
                , projectName + "!!" + "");
         assertTrue(methods.isElementVisible(methods.getBy("tableInAllSuites"),30));
         assertTrue(methods.isElementVisible(tableSuiteNameBy,30));
        assertTrue(methods.isElementInVisible(tableSuiteNameNotProjectBy,30));
    }

    public void v_Control_Suite_Table_In_All_Suites() {

        assertTrue(methods.isElementVisible(methods.getBy("selectProjectInAllSuites"),30));
        assertTrue(methods.isElementVisible(methods.getBy("tableInAllSuites"),30));
        assertTrue(methods.isElementVisible(methods.getBy("suiteForTableInAllSuites"),30));
        methodsUtil.waitBySeconds(1);
        assertTrue(methods.isElementVisible(methods.getBy("tableInAllSuites"),30));
        methodsUtil.waitByMilliSeconds(200);

        if(methods.isElementVisible(methods.getBy("runButtonTableInAllSuites"), 2)){

            setAttribute("hasProjectASuite", Value.asValue(true));

            if(methods.isElementVisible(methods.getBy("reportButtonTableInAllSuites"),2)){

                setAttribute("hasProjectAReport", Value.asValue(true));
            }else {

                setAttribute("hasProjectAReport", Value.asValue(false));
            }
        }else {
            setAttribute("hasProjectASuite", Value.asValue(false));
            setAttribute("hasProjectAReport", Value.asValue(false));
        }

       //mobile ignore

        if(Boolean.parseBoolean(methodsUtil.getValueInTestMap("allSuitesMobile").toString())){

            setAttribute("hasProjectASuite", Value.asValue(false));
            methodsUtil.putValueInTestMap("allSuitesMobile", Value.asValue(false));
        }
    }

    public void v_Control_Are_You_Sure_Message() {

        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitBySeconds(1);
    }

    public void e_Click_Delete() {

        By projectNameBy = commonProcess.getKeyValueChangerElement("tableProjectNameInAllSuites","tableProjectName1InAllSuites","last()");
        By tableSuiteNameBy = commonProcess.getKeyValueChangerElement("tableSuiteNameInAllSuites","tableSuiteName1InAllSuites","last()");
         commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(tableSuiteNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String projectName = methods.getText(projectNameBy).trim();
        //split eklendi editPlan1 (1) yüzünden
        String planName = methods.getText(tableSuiteNameBy).trim().split(" ")[0];
        methodsUtil.putValueInTestMap("deleteProjectNameInAllSuites", projectName);
        methodsUtil.putValueInTestMap("deletePlanNameInAllSuites", planName);
        By deleteButtonBy = commonProcess.getKeyValueChangerElement("deleteButtonTableSuiteNameKeyValueInAllSuites","deleteButtonTableSuiteNameKeyValue1InAllSuites"
                , projectName + "!!" + planName);
       commonProcess.clickButton(deleteButtonBy);
    }

    /**
     * TODO: e_no_action
     */
    public void e_Clear_Checkbox() {

    }

    public void e_Click_Edit() {

        String projectName = String.valueOf(methodsUtil.getValueInTestMap("currentProject"));
        By planNameBy = commonProcess.getKeyValueChangerElement("tableSuiteNameByProjectNameInAllSuites",
                "tableSuiteNameByProjectNameElementInAllSuites",projectName + "!!1");
       commonProcess.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String planName = methods.getText(planNameBy).trim().split(" ")[0];;
        By editButtonBy = commonProcess.getKeyValueChangerElement("editButtonTableSuiteNameKeyValueInAllSuites"
                ,"editButtonTableSuiteNameElementInAllSuites",projectName + "!!" + planName);
        commonProcess.clickButton(editButtonBy);
        methodsUtil.putValueInTestMap("editPlanName", planName);
        methodsUtil.putValueInTestMap("editProjectName", projectName);
    }

    public void v_Verify_In_Report_Detail_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/report/detail/",75,"startWith"));
         assertTrue(methods.isElementVisible(methods.getBy("exportTableInReportDetail"));
         assertTrue(methods.isElementVisible(methods.getBy("exportPdfInReportDetail"));
         assertTrue(methods.isElementVisible(methods.getBy("executionDetailTableInReportDetail"));
        // assertTrue(methods.isElementVisible(methods.getBy("executionDetailTestCaseInReportDetail"));
         assertTrue(methods.isElementVisible(methods.getBy("testResultTableInReportDetail"));
         assertTrue(methods.isElementVisible(methods.getBy("testResultStatusInReportDetail"));
         assertTrue(methods.isElementVisible(methods.getBy("testResultDetailButtonInReportDetail"));

         assertTrue(methods.isElementVisible(methods.getBy("dashboardButton"));
         assertTrue(methods.isElementVisible(methods.getBy("projectsTab"));
         assertTrue(methods.isElementVisible(methods.getBy("allScenariosTab"));
         assertTrue(methods.isElementVisible(methods.getBy("allSuitesTab"));
         assertTrue(methods.isElementVisible(methods.getBy("reportsTab"));
         assertTrue(methods.isElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_control_Are_You_Sure_Message() {
        
        methodsUtil.waitBySeconds(1);
        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitBySeconds(1);
    }

    /**
     * TODO: düzenle
     * AssertionError: By.xpath: //table[contains(@class,"table")]/tbody/tr[./td[./span[text()="PROJECT NAME"] and text()="testiniumProjectTemp"] and ./td/button[contains(text(),"REPORT") and not(disabled)]]/td[./span[text()="SUITE NAME"]] elementi görüntülenemedi.
     */

    public void e_Click_Mobile_Checbox() {

        By iosOptionBy = methods.getBy("mobileIosShowOnlyOptionInAllSuites");
        commonProcess.clickButton(iosOptionBy);
        By androidOptionBy = methods.getBy("mobileAndroidShowOnlyOptionInAllSuites");
        commonProcess.clickButton(androidOptionBy);
        methodsUtil.putValueInTestMap("allSuitesMobile",true);
    }

    public void e_Click_Web_Checkbox() {

        By webAllOptionBy = methods.getBy("webAllShowOnlyOptionInAllSuites");
        commonProcess.clickButton(webAllOptionBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_Suite_Is_Not_Running() {

        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        assertTrue(methods.isElementInVisible(methods.getBy("TestRunSuccessfullStarted"),30));
    }

    public void v_Verify_Suite_Is_Running() {

        assertTrue(methods.isElementVisible(methods.getBy("TestRunSuccessfullStarted"),60),"Test Başlatılamadı...");
        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("currentProject"));
        String planName = String.valueOf(methodsUtil.getValueInTestMap("currentPlan"));
        assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("testRunningSpinnerInNewSuite","testRunningSpinner1InNewSuite"
                , planName),120));
    }

    // run
    public void e_click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        commonProcess.clickButton(yesButtonBy);
        setAttribute("isRunYes", Value.asValue(false));
    }

    public void e_Click_Run() {

        String projectName = String.valueOf(methodsUtil.getValueInTestMap("currentProject"));
        By suiteNameBy = commonProcess.getKeyValueChangerElement("tableSuiteNameWithProjectNameInAllSuites","tableSuiteNameWithProjectName1InAllSuites", projectName);
        commonProcess.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(400);
        String planName = methods.getText(suiteNameBy).trim().split(" ")[0];;
        By runButtonBy = commonProcess.getKeyValueChangerElement("runButtonTableSuiteNameKeyValueInAllSuites","runButtonTableSuiteNameKeyValue1InAllSuites"
                , projectName + "!!" + planName);
        commonProcess.clickButton(runButtonBy);
        methodsUtil.putValueInTestMap("currentPlan", planName);
    }

    public void e_NO_action() {

    }

    public void e_Select_All_Projects() {

        By projectSelectBy = methods.getBy("selectProjectInAllSuites");
        methods.selectByVisibleText(projectSelectBy
                , "All Projects");
    }

    public void e_NO_Action() {

    }

    public void e_no_Action() {

    }

    public void v_Verify_Suite_Is_Not_Available() {

        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("deleteProjectNameInAllSuites"));
        String planName = String.valueOf(methodsUtil.getValueInTestMap("deletePlanNameInAllSuites"));
        assertTrue(methods.isElementInVisible(commonProcess.getKeyValueChangerElement("tablePlanKeyValueInAllSuites","tablePlanKeyValue1InAllSuites"
                , projectName + "!!" + planName),30));
    }

    public void e_Select_A_Project() {

        By projectSelectBy = methods.getBy("selectProjectInAllSuites");
        methods.selectByVisibleText(projectSelectBy
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        commonProcess.clickButton(noButtonBy);
    }

    public void e_click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        commonProcess.clickButton(noButtonBy);
    }

    public void v_Verify_In_Plan_Edit_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/plan/edit/",75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
         assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("logoTitleInPlanEdit"
                , String.valueOf(methodsUtil.getValueInTestMap("editPlanName"))));
         assertTrue(methods.isElementVisible(methods.getBy("projectNameInPlanEdit"));
         assertTrue(methods.isElementVisible(methods.getBy("planNameInPlanEdit"));
        // assertTrue(methods.isElementVisible(methods.getBy("enableSwitchInPlanEdit"));
         assertTrue(methods.isElementVisible(methods.getBy("scenarioNameForScenariosPanelInPlanEdit"));
         assertTrue(methods.isElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
         assertTrue(methods.isElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
         assertTrue(methods.isElementVisible(methods.getBy("cancelButtonInPlanEdit"));
         assertTrue(methods.isElementVisible(methods.getBy("saveButtonInPlanEdit"));
         assertTrue(methods.isElementVisible(methods.getBy("applyButtonInPlanEdit"));
        //scenarioForScenariosSelectListInCreatePlan
        //Mac 	1920x1080

         assertTrue(methods.isElementVisible(methods.getBy("propertiesTabInPlanEdit"));
         assertTrue(methods.isElementVisible(methods.getBy("advancedTabInPlanEdit"));
         assertTrue(methods.isElementVisible(methods.getBy("scheduleAndNotificationsTabInPlanEdit"));

         assertTrue(methods.isElementVisible(methods.getBy("dashboardButton"));
         assertTrue(methods.isElementVisible(methods.getBy("projectsTab"));
         assertTrue(methods.isElementVisible(methods.getBy("allScenariosTab"));
         assertTrue(methods.isElementVisible(methods.getBy("allSuitesTab"));
         assertTrue(methods.isElementVisible(methods.getBy("reportsTab"));
         assertTrue(methods.isElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_no_action() {

    }
}
