package com.mbt.testiniumcloud.modelImplementation;

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
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class PlanEdit extends ExecutionContext implements org.graphwalker.Plan_Edit {

    private static final Logger logger = LogManager.getLogger(PlanEdit.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public PlanEdit() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(PlanEdit.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void v_Verify_Advanced_Settings_Tab() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/edit/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/advanced",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoTitleForAdvancedSettingsInPlanEdit"
                , String.valueOf(methods.getValueInTestMap("editPlanName"))), 30);
        methods.checkElementVisible(methods.getBy("faildTestRetryCountForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("parallelTestLimitForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("maxExecutionTimeForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("bandwidthTypeForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("screenshotTypeForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("recordVideoForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("capturePerformanceDataForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("tunnelForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("javaParameterNameForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("javaParameterValueForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("javaParameterDescriptionForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("addButtonForAdvancedSettingsInPlanEdit"));
        methods.checkElementVisible(methods.getBy("cancelButtonInPlanEdit"));
        methods.checkElementVisible(methods.getBy("applyButtonOtherTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("saveButtonOtherTabInPlanEdit"));

        methods.checkElementVisible(methods.getBy("propertiesTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("advancedTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("scheduleAndNotificationsTabInPlanEdit"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Select_Platform() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        methods.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clearElement(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.sendKeys(planNameBy, methods.getValueInTestMap("editPlanName").toString());
        methods.checkElementVisible(methods.getBy("browserTableInCreatePlan"));
        methodsUtil.waitByMilliSeconds(500);
        By environmentNameBy = methods.getBy("environmentNameInPlanEdit");
        String browserName = "";
        String browserVersion = "";
        if(methods.isElementVisible(environmentNameBy,3)) {
            browserName = methods.getText(environmentNameBy).trim();
            By deleteButtonForPlatformBy = methods.getBy("deleteButtonForPlatformInPlanEdit");
            methods.checkElementVisible(deleteButtonForPlatformBy);
            methods.checkElementClickable(deleteButtonForPlatformBy);
            methodsUtil.waitByMilliSeconds(300);
            methods.clickElement(deleteButtonForPlatformBy);
        }
        By operatingSystemBy = methods.getByWithKeySetValue("operatingSystemOptionKeyValueInCreatePlan","Windows 10");

        if(!browserName.equals("") && browserName.equalsIgnoreCase("chrome")) {

            browserName = "FIREFOX";
        }else {

            browserName = "CHROME";
        }

        By browserOptionBy = methods.getByWithKeySetValue("browserOptionKeyValueInCreatePlan", browserName);
        methods.checkElementVisible(methods.getBy("operatingSystemAreaInCreatePlan"));
        methods.checkElementVisible(operatingSystemBy);
        methods.checkElementClickable(operatingSystemBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.clickElement(operatingSystemBy);
        methods.checkElementVisible(methods.getBy("browserAreaInCreatePlan"));
        methods.checkElementVisible(browserOptionBy);
        methods.checkElementClickable(browserOptionBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.clickElement(browserOptionBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementVisible(methods.getBy("versionAreaInCreatePlan"));
        methodsUtil.waitByMilliSeconds(500);
        if(browserName.equals("CHROME")){

            browserVersion = "LATEST";
        }else {

            browserVersion = methods.getText(methods
                    .getByWithKeySetValue("versionNumberForVersionPanelInCreatePlan", "last()")).trim();
        }

        By versionOptionBy = methods.getByWithKeySetValue("versionOptionKeyValueInCreatePlan", browserVersion);
        methods.checkElementVisible(versionOptionBy);
        methods.checkElementClickable(versionOptionBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.clickElement(versionOptionBy);
        methods.checkElementVisible(methods.getBy("screenResolutionInCreatePlan"));
        methodsUtil.waitByMilliSeconds(200);
        methods.clickElement(methods
                .getByWithKeySetValue("screenResolutionSelectOptionKeyValueInCreatePlan","1280x1024"));
        By screenResolutionAddButtonBy = methods.getBy("screenResolutionAddButtonInCreatePlan");
        methods.checkElementVisible(screenResolutionAddButtonBy);
        methods.checkElementClickable(screenResolutionAddButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(screenResolutionAddButtonBy);
        methods.putValueInTestMap("browserNameEditPlan", browserName);
        methods.putValueInTestMap("browserVersionEditPlan", browserVersion);
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
    }

    public void e_Click_Advanced_Settings_Tab() {

        By advancedTabBy = methods.getBy("advancedTabInPlanEdit");
        methods.checkElementVisible(advancedTabBy);
        methods.checkElementClickable(advancedTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(advancedTabBy);
    }

    public void e_Click_Save() {

        By saveButtonBy = methods.getBy("saveButtonInPlanEdit");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_Schedule_And_Notifications_Tab() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/edit/",
                75, "startWith"));
        Assert.assertTrue("", methods.doesUrl("/schedule", 75, "endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoTitleForScheduleInPlanEdit"
                , String.valueOf(methods.getValueInTestMap("editPlanName"))), 30);
        methods.checkElementVisible(methods.getBy("periodTypePanelForScheduleInPlanEdit"));
        methods.checkElementVisible(methods.getBy("manuallyRunForScheduleInPlanEdit"));
        methods.checkElementVisible(methods.getBy("automaticallyRunCheckboxForScheduleInPlanEdit"));
        methods.checkElementVisible(methods.getBy("repeatCheckboxForScheduleInPlanEdit"));
        methods.checkElementVisible(methods.getBy("cancelButtonInPlanEdit"));
        methods.checkElementVisible(methods.getBy("applyButtonOtherTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("saveButtonOtherTabInPlanEdit"));

        methods.checkElementVisible(methods.getBy("propertiesTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("advancedTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("scheduleAndNotificationsTabInPlanEdit"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Change_Suite_Name() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        methods.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElement(planNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementVisible(planNameBy);
        String planName = "TestPlan" + methodsUtil.randomString(5);
        methods.sendKeys(planNameBy, planName);
        methodsUtil.waitByMilliSeconds(300);
        methods.putValueInTestMap("editPlanName", planName);
    }

    public void v_Control_Invalid_Suite_Name() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/edit/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/properties",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoTitleInPlanEdit"
                , String.valueOf(methods.getValueInTestMap("editPlanName"))));
        methods.checkElementVisible(methods.getBy("projectNameInPlanEdit"));
        methods.checkElementVisible(methods.getBy("planNameInPlanEdit"));
        By planNameErrorBlockBy = methods.getBy("planNameErrorBlockInPlanEdit");
        methods.checkElementVisible(planNameErrorBlockBy);
        Assert.assertEquals("","This field is required."
                , methods.getText(planNameErrorBlockBy).trim());
        Assert.assertEquals("","#d0021b"
                , methods.getHexCssValue(planNameErrorBlockBy,"border-bottom-color"));
    }

    public void v_Control_Edited_Plan() {

        v_Verify_In_All_Suites_Page_SHARED();
        By selectProjectBy = methods.getBy("selectProjectInAllSuites");
        By webChromeCheckboxBy = methods.getBy("webChromeShowOnlyOptionInAllSuites");
        By webFirefoxCheckboxBy = methods.getBy("webFirefoxShowOnlyOptionInAllSuites");
        By checkboxFirstBy = null;
        //By checkboxSecondBy = null;
        String projectName = String.valueOf(methods.getValueInTestMap("editProjectName"));
        methods.checkElementVisible(selectProjectBy);
        methods.checkElementClickable(selectProjectBy);
        methods.selectByVisibleText(selectProjectBy, projectName);
        methods.checkElementVisible(selectProjectBy);
        String planName = String.valueOf(methods.getValueInTestMap("editPlanName"));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        Assert.assertTrue("",methods.isElementVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));

        if(String.valueOf(methods.getValueInTestMap("browserNameEditPlan"))
                .equalsIgnoreCase("chrome")){
            checkboxFirstBy = webChromeCheckboxBy;
          //  checkboxSecondBy = webFirefoxCheckboxBy;
        }else {
            checkboxFirstBy = webFirefoxCheckboxBy;
          //  checkboxSecondBy = webChromeCheckboxBy;
        }
        methods.checkElementVisible(checkboxFirstBy);
        methods.checkElementClickable(checkboxFirstBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(checkboxFirstBy);
        /**methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        Assert.assertTrue("",methods.isElementInVisible(methods
                .getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));
        methods.checkElementVisible(checkboxFirstBy);
        methods.checkElementClickable(checkboxFirstBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(checkboxFirstBy);*/
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        Assert.assertTrue("",methods.isElementVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementVisible(checkboxFirstBy);
        methods.checkElementClickable(checkboxFirstBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(checkboxFirstBy);
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(selectProjectBy);
        methods.checkElementClickable(selectProjectBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.selectByVisibleText(selectProjectBy, "All Projects");
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementVisible(selectProjectBy);
    }

    public void e_Click_Save_Empty_Suite_Name() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        By saveButtonBy = methods.getBy("saveButtonInPlanEdit");
        methods.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(400);
        methods.clearElementWithBackSpace(planNameBy,"a");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void v_Verify_Suite_Name() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        methods.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        Assert.assertEquals("", methods.getValueInTestMap("editPlanName")
        , methods.getAttribute(planNameBy,"value").trim());
    }

    public void v_control_Edited_Plan() {

        v_Verify_In_All_Suites_Page_SHARED();
        By selectProjectBy = methods.getBy("selectProjectInAllSuites");
        String projectName = String.valueOf(methods.getValueInTestMap("editProjectName"));
        methods.checkElementVisible(selectProjectBy);
        methods.checkElementClickable(selectProjectBy);
        methods.selectByVisibleText(selectProjectBy, projectName);
        methods.checkElementVisible(selectProjectBy);
        String planName = String.valueOf(methods.getValueInTestMap("editPlanName"));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        Assert.assertTrue("",methods.isElementVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));
        methods.checkElementVisible(selectProjectBy);
        methods.checkElementClickable(selectProjectBy);
        methods.selectByVisibleText(selectProjectBy, "All Projects");
        methods.checkElementVisible(selectProjectBy);
    }

    public void e_Click_Schedule_And_Notifications_Tab() {

        By scheduleTabBy = methods.getBy("scheduleAndNotificationsTabInPlanEdit");
        methods.checkElementVisible(scheduleTabBy);
        methods.checkElementClickable(scheduleTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(scheduleTabBy);
    }

    public void v_Verify_Selected_Test_Cases() {

        methods.checkElementVisible(methods.getBy("scenarioForScenarioOrderInCreatePlan"));
        By scenarioForScenarioOrderBy = methods.getByWithKeySetValue("scenarioKeyValueForScenarioOrderInCreatePlan"
                , String.valueOf(methods.getValueInTestMap("scenarioNameInEditPlan")));
        methods.checkElementVisible(scenarioForScenarioOrderBy);
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInPlanEdit");
        methods.checkElementVisible(cancelButtonBy);
        methods.checkElementClickable(cancelButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(cancelButtonBy);
    }

    public void e_Click_Properties_Tab() {

        By propertiesTabBy = methods.getBy("propertiesTabInPlanEdit");
        methods.checkElementVisible(propertiesTabBy);
        methods.checkElementClickable(propertiesTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(propertiesTabBy);
    }

    public void v_Verify_Selected_Platform() {

        By tableBy = methods.getByWithKeySetValue("browserTableKeyValueInCreatePlan"
                , "Windows 10!!" + String.valueOf(methods.getValueInTestMap("browserNameEditPlan")).toLowerCase()
                        + "!!" + String.valueOf(methods.getValueInTestMap("browserVersionEditPlan")) + "!!1280x1024");
        methods.checkElementVisible(tableBy);
    }

    public void v_Verify_In_Plan_Edit_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/edit/",
                75,"startWith"));
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
        methodsUtil.waitBySeconds(1);
        String projectName = methods.getFirstSelectedOption(methods.getBy("projectNameInPlanEdit")).getText().trim();
        /**
         * TODO: kontrol et
         */
        if(projectName.contains("mobileTemp") || projectName.contains("appiumEditProject")){
            setAttribute("isProjectMobile", Value.asValue(true));
        } else {
            setAttribute("isProjectMobile",Value.asValue(false));
        }
    }

    public void v_Control_Edited_plan() {

        v_Verify_In_All_Suites_Page_SHARED();
        By selectProjectBy = methods.getBy("selectProjectInAllSuites");
        String projectName = String.valueOf(methods.getValueInTestMap("editProjectName"));
        methods.checkElementVisible(selectProjectBy);
        methods.checkElementClickable(selectProjectBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.selectByVisibleText(selectProjectBy, projectName);
        methodsUtil.waitByMilliSeconds(200);
        methods.checkElementVisible(selectProjectBy);
        String planName = String.valueOf(methods.getValueInTestMap("editPlanName"));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        Assert.assertTrue("",methods.isElementVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));
        methods.checkElementVisible(selectProjectBy);
        methods.checkElementClickable(selectProjectBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.selectByVisibleText(selectProjectBy, "All Projects");
        methodsUtil.waitByMilliSeconds(200);
        methods.checkElementVisible(selectProjectBy);
    }

    public void e_Select_Test_Cases() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        methods.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clearElement(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.sendKeys(planNameBy, methods.getValueInTestMap("editPlanName").toString());
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        By scenarioNameForScenariosBy = methods.getByWithKeySetValue("scenarioForScenariosSelectListNumberInCreatePlan"
                , "1");
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        methods.checkElementVisible(methods.getBy("scenarioForScenariosSelectListInCreatePlan"));
        methods.checkElementVisible(scenarioNameForScenariosBy);
        methods.checkElementClickable(scenarioNameForScenariosBy);
        methodsUtil.waitByMilliSeconds(500);
        String scenarioName = methods.getText(scenarioNameForScenariosBy).trim();
        methods.putValueInTestMap("scenarioNameInEditPlan", scenarioName);
        if(!methods.getAttribute(methods.getByWithKeySetValue("scenarioKeyValueForScenariosInPlanEdit"
                ,"!!" + scenarioName),"class").contains("checked")) {
            methodsUtil.waitByMilliSeconds(300);
            methods.clickElement(scenarioNameForScenariosBy);
        }
    }

}
