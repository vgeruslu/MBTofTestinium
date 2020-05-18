package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.methods.Methods;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GraphWalker(value = "random(edge_coverage(100))")
public class AllSuites extends ExecutionContext implements org.graphwalker.All_Suites {

    private static final Logger logger = LoggerFactory.getLogger(AllSuites.class);
    Methods methods;

    public AllSuites() {

        methods = new Methods();
        methods.putValueInTestMap("allSuitesMobile",false);
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

    public void e_click_Mobile_Checbox() {

        By iosOptionBy = methods.getBy("mobileIosShowOnlyOptionInAllSuites");
        By androidOptionBy = methods.getBy("mobileAndroidShowOnlyOptionInAllSuites");
        methods.checkElementClickable(iosOptionBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(iosOptionBy);
        methods.checkElementVisible(androidOptionBy);
        methods.checkElementClickable(androidOptionBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(androidOptionBy);
        methods.putValueInTestMap("allSuitesMobile",true);
    }

    public void e_Click_Create_Button() {

        By createButtonBy = methods.getBy("createPlanInAllSuites");
        methods.checkElementVisible(createButtonBy);
        methods.checkElementClickable(createButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(createButtonBy);
        methods.putValueInTestMap("projectSelectedForPlan",false);
    }

    public void v_Verify_In_All_Suites_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan",75,"equal"));
        methods.checkElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"));
        By selectProjectBy = methods.getBy("selectProjectInAllSuites");
        methods.checkElementVisible(selectProjectBy);
        methods.checkElementVisible(methods.getBy("exportTableInAllSuites"));
        methods.checkElementVisible(methods.getBy("createPlanInAllSuites"));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        methods.checkElementVisible(methods.getBy("mobileIosShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("mobileAndroidShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webAllShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webFirefoxShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webChromeShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webIEShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webSafariShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webOperaShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webEdgeShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("runningSuitesShowOnlyOptionInAllSuites"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));

        methods.waitByMilliSeconds(400);

        if(methods.getAttribute(methods.getByWithKeySetValue("checkboxShowOnlyOptionKeyValueInAllSuites","Mobile (iOS)")
                ,"class").contains("checked")){
            By iosOptionBy = methods.getBy("mobileIosShowOnlyOptionInAllSuites");
            methods.checkElementVisible(iosOptionBy);
            methods.checkElementClickable(iosOptionBy);
            methods.clickElement(iosOptionBy);
            methods.checkElementVisible(methods.getBy("tableInAllSuites"));
            methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
            methods.checkElementVisible(iosOptionBy);
        }
        if(methods.getAttribute(methods.getByWithKeySetValue("checkboxShowOnlyOptionKeyValueInAllSuites","Mobile (ANDROID)")
                ,"class").contains("checked")){
            By androidOptionBy = methods.getBy("mobileAndroidShowOnlyOptionInAllSuites");
            methods.checkElementVisible(androidOptionBy);
            methods.checkElementClickable(androidOptionBy);
            methods.clickElement(androidOptionBy);
            methods.checkElementVisible(methods.getBy("tableInAllSuites"));
            methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
            methods.checkElementVisible(androidOptionBy);
        }
        if(methods.getAttribute(methods.getByWithKeySetValue("checkboxShowOnlyOptionKeyValueInAllSuites","Web (All)")
                ,"class").contains("checked")){
            By webAllOptionBy = methods.getBy("webAllShowOnlyOptionInAllSuites");
            methods.checkElementVisible(webAllOptionBy);
            methods.checkElementClickable(webAllOptionBy);
            methods.clickElement(webAllOptionBy);
            methods.checkElementVisible(methods.getBy("tableInAllSuites"));
            methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
            methods.checkElementVisible(webAllOptionBy);
        }

        //if(!methods.getFirstSelectedOption(selectProjectBy)
          //      .getText().trim().equals("All Projects")){
        methods.waitByMilliSeconds(200);
        methods.selectByVisibleText(selectProjectBy,
                methods.getValueInTestMap("appiumProject").toString());
        methods.waitByMilliSeconds(200);
            methods.checkElementVisible(selectProjectBy);
            methods.selectByVisibleText(selectProjectBy,"All Projects");
            methods.checkElementVisible(selectProjectBy);
        methods.waitByMilliSeconds(500);
            methods.checkElementVisible(methods.getBy("tableInAllSuites"));
            methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        //}

        methods.putValueInTestMap("currentProject", methods.getValueInTestMap("optionalProject").toString());
    }

    public void v_Verify_Suite_Is_Available() {

        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        methods.waitByMilliSeconds(500);
        String projectName = String.valueOf(methods.getValueInTestMap("deleteProjectNameInAllSuites"));
        String planName = String.valueOf(methods.getValueInTestMap("deletePlanNameInAllSuites"));
        Assert.assertTrue("",methods.isElementVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));
    }

    public void e_click_Web_Checkbox() {

        By webAllOptionBy = methods.getBy("webAllShowOnlyOptionInAllSuites");
        methods.checkElementVisible(webAllOptionBy);
        methods.checkElementClickable(webAllOptionBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(webAllOptionBy);
    }

    //delete
    public void e_Click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        methods.checkElementVisible(yesButtonBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementClickable(yesButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(yesButtonBy);
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/create",75,"startWith"));
        methods.checkElementVisible(methods.getBy("logoInCreatePlan"));
        methods.checkElementVisible(methods.getBy("projectNameInCreatePlan"));
        methods.checkElementVisible(methods.getBy("suiteNameInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        methods.checkElementVisible(methods.getBy("cancelButtonInCreatePlan"));
        methods.checkElementVisible(methods.getBy("saveButtonInCreatePlan"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_Click_Report() {

        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        //By suiteNameBy = methods.getByWithKeySetValue("tableSuiteNameWithProjectNameReportInAllSuites", projectName);
        By suiteNameBy = methods.getByWithKeySetValue("tableSuiteNameWithProjectNameNumberReportInAllSuites",
                projectName + "!!" + "last()");
        methods.checkElementVisible(suiteNameBy);
        methods.waitByMilliSeconds(500);
        String planName = methods.getText(suiteNameBy).trim().split(" ")[0];
        By reportButtonBy = methods.getByWithKeySetValue("reportButtonTableSuiteNameKeyValueInAllSuites"
                , projectName + "!!" + planName);
        methods.checkElementVisible(reportButtonBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementClickable(reportButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(reportButtonBy);
        methods.putValueInTestMap("currentPlan", planName);
    }

    public void v_Control_Suite_Table_For_Only_Selected_Project() {

        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        By tableSuiteNameBy = methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + "");
        By tableSuiteNameNotProjectBy = methods.getByWithKeySetValue("tablePlanKeyValueNotProjectInAllSuites"
                , projectName + "!!" + "");
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(tableSuiteNameBy);
        Assert.assertTrue("", methods.isElementInVisible(tableSuiteNameNotProjectBy,30));
    }

    public void v_Control_Suite_Table_In_All_Suites() {

        methods.checkElementVisible(methods.getBy("selectProjectInAllSuites"));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        methods.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.waitByMilliSeconds(200);

        if(methods.isElementVisible(methods.getBy("runButtonTableInAllSuites"), 2)){

            setAttribute("hasProjectASuite",true);

            if(methods.isElementVisible(methods.getBy("reportButtonTableInAllSuites"),2)){

                setAttribute("hasProjectAReport",true);
            }else {

                setAttribute("hasProjectAReport",false);
            }
        }else {
            setAttribute("hasProjectASuite",false);
            setAttribute("hasProjectAReport",false);
        }

       //mobile ignore

        if(Boolean.parseBoolean(methods.getValueInTestMap("allSuitesMobile").toString())){

            setAttribute("hasProjectASuite",false);
            methods.putValueInTestMap("allSuitesMobile",false);
        }
    }

    public void v_Control_Are_You_Sure_Message() {

        methods.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methods.waitBySeconds(1);
    }

    public void e_Click_Delete() {

        By projectNameBy = methods.getByWithKeySetValue("tableProjectNameInAllSuites","last()");
        By tableSuiteNameBy = methods.getByWithKeySetValue("tableSuiteNameInAllSuites","last()");
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(tableSuiteNameBy);
        methods.waitByMilliSeconds(200);
        String projectName = methods.getText(projectNameBy).trim();
        //split eklendi editPlan1 (1) yüzünden
        String planName = methods.getText(tableSuiteNameBy).trim().split(" ")[0];
        methods.putValueInTestMap("deleteProjectNameInAllSuites", projectName);
        methods.putValueInTestMap("deletePlanNameInAllSuites", planName);
        By deleteButtonBy = methods.getByWithKeySetValue("deleteButtonTableSuiteNameKeyValueInAllSuites"
                , projectName + "!!" + planName);
        methods.checkElementVisible(deleteButtonBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementClickable(deleteButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(deleteButtonBy);
    }

    /**
     * TODO: e_no_action
     */
    public void e_Clear_Checkbox() {

    }

    public void e_Click_Edit() {

        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        By planNameBy = methods.getByWithKeySetValue("tableSuiteNameByProjectNameInAllSuites",
                projectName + "!!1");
        methods.checkElementVisible(planNameBy);
        methods.waitByMilliSeconds(200);
        String planName = methods.getText(planNameBy).trim().split(" ")[0];;
        By editButtonBy = methods.getByWithKeySetValue("editButtonTableSuiteNameKeyValueInAllSuites"
                , projectName + "!!" + planName);
        methods.checkElementVisible(editButtonBy);
        methods.checkElementClickable(editButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(editButtonBy);
        methods.putValueInTestMap("editPlanName", planName);
        methods.putValueInTestMap("editProjectName", projectName);
    }

    public void v_Verify_In_Report_Detail_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report/detail/",75,"startWith"));
        methods.checkElementVisible(methods.getBy("exportTableInReportDetail"));
        methods.checkElementVisible(methods.getBy("exportPdfInReportDetail"));
        methods.checkElementVisible(methods.getBy("executionDetailTableInReportDetail"));
        methods.checkElementVisible(methods.getBy("executionDetailTestCaseInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultTableInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultStatusInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultDetailButtonInReportDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_control_Are_You_Sure_Message() {

        methods.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methods.waitBySeconds(1);
    }

    public void e_Click_Mobile_Checbox() {

        By iosOptionBy = methods.getBy("mobileIosShowOnlyOptionInAllSuites");
        By androidOptionBy = methods.getBy("mobileAndroidShowOnlyOptionInAllSuites");
        methods.checkElementVisible(iosOptionBy);
        methods.checkElementClickable(iosOptionBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(iosOptionBy);
        methods.checkElementVisible(androidOptionBy);
        methods.checkElementClickable(androidOptionBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(androidOptionBy);
        methods.putValueInTestMap("allSuitesMobile",true);
    }

    public void e_Click_Web_Checkbox() {

        By webAllOptionBy = methods.getBy("webAllShowOnlyOptionInAllSuites");
        methods.checkElementVisible(webAllOptionBy);
        methods.checkElementClickable(webAllOptionBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(webAllOptionBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_Suite_Is_Not_Running() {

        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        Assert.assertTrue("Hata", methods
                .isElementInVisible(methods.getBy("TestRunSuccessfullStarted"),30));
    }

    public void v_Verify_Suite_Is_Running() {

        Assert.assertTrue("Test Başlatılamadı...", methods
                .isElementVisible(methods.getBy("TestRunSuccessfullStarted"),60));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        String planName = String.valueOf(methods.getValueInTestMap("currentPlan"));
        methods.checkElementVisible(methods.getByWithKeySetValue("testRunningSpinnerInNewSuite"
                , planName),120);
    }

    // run
    public void e_click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        methods.checkElementVisible(yesButtonBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementClickable(yesButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(yesButtonBy);
        setAttribute("isRunYes",false);
    }

    public void e_Click_Run() {

        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        By suiteNameBy = methods.getByWithKeySetValue("tableSuiteNameWithProjectNameInAllSuites", projectName);
        methods.checkElementVisible(suiteNameBy);
        methods.waitByMilliSeconds(400);
        String planName = methods.getText(suiteNameBy).trim().split(" ")[0];;
        By runButtonBy = methods.getByWithKeySetValue("runButtonTableSuiteNameKeyValueInAllSuites"
                , projectName + "!!" + planName);
        methods.checkElementVisible(runButtonBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementClickable(runButtonBy);
        methods.waitByMilliSeconds(500);
        try {
            methods.clickElement(runButtonBy);
        }catch (StaleElementReferenceException e){
            methods.checkElementVisible(runButtonBy);
            methods.waitByMilliSeconds(500);
            methods.checkElementClickable(runButtonBy);
            methods.waitByMilliSeconds(500);
            methods.clickElement(runButtonBy);
        }
        methods.putValueInTestMap("currentPlan", planName);
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

        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        String projectName = String.valueOf(methods.getValueInTestMap("deleteProjectNameInAllSuites"));
        String planName = String.valueOf(methods.getValueInTestMap("deletePlanNameInAllSuites"));
        Assert.assertTrue("",methods.isElementInVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));
    }

    public void e_Select_A_Project() {

        By projectSelectBy = methods.getBy("selectProjectInAllSuites");
        methods.selectByVisibleText(projectSelectBy
                , String.valueOf(methods.getValueInTestMap("currentProject")));
    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementClickable(noButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void e_click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementClickable(noButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void v_Verify_In_Plan_Edit_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/edit/",75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/properties",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoTitleInPlanEdit"
                , String.valueOf(methods.getValueInTestMap("editPlanName"))));
        methods.checkElementVisible(methods.getBy("projectNameInPlanEdit"));
        methods.checkElementVisible(methods.getBy("planNameInPlanEdit"));
        //methods.checkElementVisible(methods.getBy("enableSwitchInPlanEdit"));
        methods.checkElementVisible(methods.getBy("scenarioNameForScenariosPanelInPlanEdit"));
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        methods.checkElementVisible(methods.getBy("cancelButtonInPlanEdit"));
        methods.checkElementVisible(methods.getBy("saveButtonInPlanEdit"));
        methods.checkElementVisible(methods.getBy("applyButtonInPlanEdit"));
        //scenarioForScenariosSelectListInCreatePlan
        //Mac 	1920x1080

        methods.checkElementVisible(methods.getBy("propertiesTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("advancedTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("scheduleAndNotificationsTabInPlanEdit"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_no_action() {

    }
}
