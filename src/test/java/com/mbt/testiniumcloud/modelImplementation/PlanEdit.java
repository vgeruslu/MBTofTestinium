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
public class PlanEdit extends ExecutionContext implements org.graphwalker.Plan_Edit {

    private static final Logger logger = LogManager.getLogger(PlanEdit.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public PlanEdit() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
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

        assertTrue(methods.doesUrl("https://testinium.io/plan/edit/",75,"startWith"));
        assertTrue(methods.doesUrl("/advanced",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleForAdvancedSettingsInPlanEdit","logoTitleForAdvancedSettings1InPlanEdit", String.valueOf(methodsUtil.getValueInTestMap("editPlanName"))));
        commonProcess.checkElementVisible(methods.getBy("faildTestRetryCountForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("parallelTestLimitForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("maxExecutionTimeForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("bandwidthTypeForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("screenshotTypeForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("recordVideoForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("capturePerformanceDataForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("tunnelForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("javaParameterNameForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("javaParameterValueForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("javaParameterDescriptionForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("addButtonForAdvancedSettingsInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("applyButtonOtherTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonOtherTabInPlanEdit"));

        commonProcess.checkElementVisible(methods.getBy("propertiesTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("advancedTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("scheduleAndNotificationsTabInPlanEdit"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Select_Platform() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        commonProcess.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clearElement(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.sendKeys(planNameBy, methodsUtil.getValueInTestMap("editPlanName").toString());
        commonProcess.checkElementVisible(methods.getBy("browserTableInCreatePlan"));
        methodsUtil.waitByMilliSeconds(500);
        By environmentNameBy = methods.getBy("environmentNameInPlanEdit");
        String browserName = "";
        String browserVersion = "";
        if(methods.isElementVisible(environmentNameBy,3)) {
            browserName = methods.getText(environmentNameBy).trim();
            By deleteButtonForPlatformBy = methods.getBy("deleteButtonForPlatformInPlanEdit");
            commonProcess.clickButton(deleteButtonForPlatformBy);
        }
        By operatingSystemBy = commonProcess.getKeyValueChangerElement("operatingSystemOptionKeyValueInCreatePlan","operatingSystemOptionKeyValue1InCreatePlan","Windows 10");

        if(!browserName.equals("") && browserName.equalsIgnoreCase("chrome")) {

            browserName = "FIREFOX";
        }else {

            browserName = "CHROME";
        }

        By browserOptionBy = commonProcess.getKeyValueChangerElement("browserOptionKeyValueInCreatePlan","browserOptionKeyValue1InCreatePlan", browserName);
        commonProcess.checkElementVisible(methods.getBy("operatingSystemAreaInCreatePlan"));
        commonProcess.clickButton(operatingSystemBy);
        commonProcess.checkElementVisible(methods.getBy("browserAreaInCreatePlan"));
        commonProcess.clickButton(browserOptionBy);
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(methods.getBy("versionAreaInCreatePlan"));
        methodsUtil.waitByMilliSeconds(500);
        if(browserName.equals("CHROME")){

            browserVersion = "LATEST";
        }else {

            browserVersion = methods.getText(commonProcess.getKeyValueChangerElement("versionNumberForVersionPanelInCreatePlan","versionNumberForVersionPanel1InCreatePlan","last()")).trim();
        }

        By versionOptionBy = commonProcess.getKeyValueChangerElement("versionOptionKeyValueInCreatePlan","versionOptionKeyValue1InCreatePlan", browserVersion);
        commonProcess.clickButton(versionOptionBy);
        commonProcess.checkElementVisible(methods.getBy("screenResolutionInCreatePlan"));
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.clickButton(commonProcess.getKeyValueChangerElement("screenResolutionSelectOptionKeyValueInCreatePlan","screenResolutionSelectOptionKeyValue1InCreatePlan","1280x1024"));
        By screenResolutionAddButtonBy = methods.getBy("screenResolutionAddButtonInCreatePlan");
        commonProcess.clickButton(screenResolutionAddButtonBy);
        methodsUtil.putValueInTestMap("browserNameEditPlan", browserName);
        methodsUtil.putValueInTestMap("browserVersionEditPlan", browserVersion);
    }

    public void v_Verify_In_All_Suites_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/plan",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"));
        By selectProjectBy = methods.getBy("selectProjectInAllSuites");
        commonProcess.checkElementVisible(selectProjectBy);
        commonProcess.checkElementVisible(methods.getBy("exportTableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("createPlanInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("mobileIosShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("mobileAndroidShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webAllShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webFirefoxShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webChromeShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webIEShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webSafariShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webOperaShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("webEdgeShowOnlyOptionInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("runningSuitesShowOnlyOptionInAllSuites"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Advanced_Settings_Tab() {

        By advancedTabBy = methods.getBy("advancedTabInPlanEdit");
        commonProcess.clickButton(advancedTabBy);
    }

    public void e_Click_Save() {

        By saveButtonBy = methods.getBy("saveButtonInPlanEdit");
        commonProcess.clickButton(saveButtonBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_Schedule_And_Notifications_Tab() {

        assertTrue(methods.doesUrl("https://testinium.io/plan/edit/",75, "startWith"));
        assertTrue(methods.doesUrl("/schedule", 75, "endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleForScheduleInPlanEdit","logoTitleForSchedule1InPlanEdit", String.valueOf(methodsUtil.getValueInTestMap("editPlanName"))));
        commonProcess.checkElementVisible(methods.getBy("periodTypePanelForScheduleInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("manuallyRunForScheduleInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("automaticallyRunCheckboxForScheduleInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("repeatCheckboxForScheduleInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("applyButtonOtherTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonOtherTabInPlanEdit"));

        commonProcess.checkElementVisible(methods.getBy("propertiesTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("advancedTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("scheduleAndNotificationsTabInPlanEdit"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Change_Suite_Name() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        commonProcess.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElement(planNameBy);
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(planNameBy);
        String planName = "TestPlan" + methodsUtil.randomString(5);
        methods.sendKeys(planNameBy, planName);
        methodsUtil.waitByMilliSeconds(300);
        methodsUtil.putValueInTestMap("editPlanName", planName);
    }

    public void v_Control_Invalid_Suite_Name() {

        assertTrue(methods.doesUrl("https://testinium.io/plan/edit/",75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleInPlanEdit","logoTitle1InPlanEdit"
                , String.valueOf(methodsUtil.getValueInTestMap("editPlanName"))));
        commonProcess.checkElementVisible(methods.getBy("projectNameInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("planNameInPlanEdit"));
        By planNameErrorBlockBy = methods.getBy("planNameErrorBlockInPlanEdit");
        commonProcess.checkElementVisible(planNameErrorBlockBy);
        assertEquals("This field is required.", methods.getText(planNameErrorBlockBy).trim());
        assertEquals("#d0021b", methods.getHexCssValue(planNameErrorBlockBy,"border-bottom-color"));
    }

    public void v_Control_Edited_Plan() {

        v_Verify_In_All_Suites_Page_SHARED();
        By selectProjectBy = methods.getBy("selectProjectInAllSuites");
        By webChromeCheckboxBy = methods.getBy("webChromeShowOnlyOptionInAllSuites");
        By webFirefoxCheckboxBy = methods.getBy("webFirefoxShowOnlyOptionInAllSuites");
        By checkboxFirstBy = null;
        //By checkboxSecondBy = null;
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("editProjectName"));
        commonProcess.checkElementVisible(selectProjectBy);
        commonProcess.checkElementClickable(selectProjectBy);
        methods.selectByVisibleText(selectProjectBy, projectName);
        commonProcess.checkElementVisible(selectProjectBy);
        String planName = String.valueOf(methodsUtil.getValueInTestMap("editPlanName"));
        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("tablePlanKeyValueInAllSuites","tablePlanKeyValue1InAllSuites"
                ,projectName + "!!" + planName),30));

        if(String.valueOf(methodsUtil.getValueInTestMap("browserNameEditPlan"))
                .equalsIgnoreCase("chrome")){
            checkboxFirstBy = webChromeCheckboxBy;
          //  checkboxSecondBy = webFirefoxCheckboxBy;
        }else {
            checkboxFirstBy = webFirefoxCheckboxBy;
          //  checkboxSecondBy = webChromeCheckboxBy;
        }
        commonProcess.clickButton(checkboxFirstBy);
        /**commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        assertTrue("",methods.isElementInVisible(methods
                .getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));
        commonProcess.checkElementVisible(checkboxFirstBy);
        commonProcess.checkElementClickable(checkboxFirstBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(checkboxFirstBy);*/
        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("tablePlanKeyValueInAllSuites","tablePlanKeyValue1InAllSuites"
                ,projectName + "!!" + planName),30));
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.clickButton(checkboxFirstBy);
        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        commonProcess.checkElementVisible(selectProjectBy);
        commonProcess.checkElementClickable(selectProjectBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.selectByVisibleText(selectProjectBy, "All Projects");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(selectProjectBy);
    }

    public void e_Click_Save_Empty_Suite_Name() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        By saveButtonBy = methods.getBy("saveButtonInPlanEdit");
        commonProcess.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(400);
        methods.clearElementWithBackSpace(planNameBy,"a");
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Verify_Suite_Name() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        commonProcess.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        assertEquals( methodsUtil.getValueInTestMap("editPlanName"), methods.getAttribute(planNameBy,"value").trim());
    }

    public void v_control_Edited_Plan() {

        v_Verify_In_All_Suites_Page_SHARED();
        By selectProjectBy = methods.getBy("selectProjectInAllSuites");
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("editProjectName"));
        commonProcess.checkElementVisible(selectProjectBy);
        commonProcess.checkElementClickable(selectProjectBy);
        methods.selectByVisibleText(selectProjectBy, projectName);
        commonProcess.checkElementVisible(selectProjectBy);
        String planName = String.valueOf(methodsUtil.getValueInTestMap("editPlanName"));
        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("tablePlanKeyValueInAllSuites","tablePlanKeyValue1InAllSuites"
                ,projectName + "!!" + planName),30));
        commonProcess.checkElementVisible(selectProjectBy);
        commonProcess.checkElementClickable(selectProjectBy);
        methods.selectByVisibleText(selectProjectBy, "All Projects");
        commonProcess.checkElementVisible(selectProjectBy);
    }

    public void e_Click_Schedule_And_Notifications_Tab() {

        By scheduleTabBy = methods.getBy("scheduleAndNotificationsTabInPlanEdit");
        commonProcess.clickButton(scheduleTabBy);
    }

    public void v_Verify_Selected_Test_Cases() {

        commonProcess.checkElementVisible(methods.getBy("scenarioForScenarioOrderInCreatePlan"));
        By scenarioForScenarioOrderBy = commonProcess.getKeyValueChangerElement("scenarioKeyValueForScenarioOrderInCreatePlan","scenarioKeyValueForScenarioOrder1InCreatePlan"
                , String.valueOf(methodsUtil.getValueInTestMap("scenarioNameInEditPlan")));
        commonProcess.checkElementVisible(scenarioForScenarioOrderBy);
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInPlanEdit");
        commonProcess.clickButton(cancelButtonBy);
    }

    public void e_Click_Properties_Tab() {

        By propertiesTabBy = methods.getBy("propertiesTabInPlanEdit");
        commonProcess.clickButton(propertiesTabBy);
    }

    public void v_Verify_Selected_Platform() {

        By tableBy = commonProcess.getKeyValueChangerElement("browserTableKeyValueInCreatePlan","browserTableKeyValue1InCreatePlan"
                ,"Windows 10!!" + String.valueOf(methodsUtil.getValueInTestMap("browserNameEditPlan")).toLowerCase()
                        + "!!" + String.valueOf(methodsUtil.getValueInTestMap("browserVersionEditPlan")) + "!!1280x1024");
        commonProcess.checkElementVisible(tableBy);
    }

    public void v_Verify_In_Plan_Edit_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/plan/edit/",75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleInPlanEdit","logoTitle1InPlanEdit"
                , String.valueOf(methodsUtil.getValueInTestMap("editPlanName"))));
        commonProcess.checkElementVisible(methods.getBy("projectNameInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("planNameInPlanEdit"));
        //commonProcess.checkElementVisible(methods.getBy("enableSwitchInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("scenarioNameForScenariosPanelInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("applyButtonInPlanEdit"));
        //scenarioForScenariosSelectListInCreatePlan
        //Mac 	1920x1080

        commonProcess.checkElementVisible(methods.getBy("propertiesTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("advancedTabInPlanEdit"));
        commonProcess.checkElementVisible(methods.getBy("scheduleAndNotificationsTabInPlanEdit"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
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
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("editProjectName"));
        commonProcess.checkElementVisible(selectProjectBy);
        commonProcess.checkElementClickable(selectProjectBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.selectByVisibleText(selectProjectBy, projectName);
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.checkElementVisible(selectProjectBy);
        String planName = String.valueOf(methodsUtil.getValueInTestMap("editPlanName"));
        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("tablePlanKeyValueInAllSuites","tablePlanKeyValue1InAllSuites"
                ,projectName + "!!" + planName),30));
        commonProcess.checkElementVisible(selectProjectBy);
        commonProcess.checkElementClickable(selectProjectBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.selectByVisibleText(selectProjectBy, "All Projects");
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.checkElementVisible(selectProjectBy);
    }

    public void e_Select_Test_Cases() {

        By planNameBy = methods.getBy("planNameInPlanEdit");
        commonProcess.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clearElement(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.sendKeys(planNameBy, methodsUtil.getValueInTestMap("editPlanName").toString());
        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        By scenarioNameForScenariosBy = commonProcess.getKeyValueChangerElement("scenarioForScenariosSelectListNumberInCreatePlan"
                ,"scenarioForScenariosSelectListNumber1InCreatePlan","1");
        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("scenarioForScenariosSelectListInCreatePlan"));
        commonProcess.checkElementVisible(scenarioNameForScenariosBy);
        commonProcess.checkElementClickable(scenarioNameForScenariosBy);
        methodsUtil.waitByMilliSeconds(500);
        String scenarioName = methods.getText(scenarioNameForScenariosBy).trim();
        methodsUtil.putValueInTestMap("scenarioNameInEditPlan", scenarioName);
        if(!methods.getAttribute(commonProcess.getKeyValueChangerElement("scenarioKeyValueForScenariosInPlanEdit"
                ,"scenarioKeyValueForScenarios1InPlanEdit","!!" + scenarioName),"class").contains("checked")) {
            commonProcess.clickButton(scenarioNameForScenariosBy);
        }
    }

}
