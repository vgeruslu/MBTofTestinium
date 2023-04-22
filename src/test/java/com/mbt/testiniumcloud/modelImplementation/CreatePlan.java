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
public class CreatePlan extends ExecutionContext implements org.graphwalker.Create_Plan {

    private static final Logger logger = LogManager.getLogger(CreatePlan.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;
    Boolean modelLocationStillCreatePlanPage = false;
    Boolean appiumPlan = false;

    public CreatePlan() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(CreatePlan.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void v_Verify_In_All_Suites_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/plan",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("selectProjectInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("exportTableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("createPlanInAllSuites"));
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
         */
    }

    public void e_Select_A_Platform_For_Selenium_Project() {

        By operatingSystemBy = commonProcess.getKeyValueChangerElement("operatingSystemOptionKeyValueInCreatePlan","operatingSystemOptionKeyValue1InCreatePlan","Windows 10");
        By browserOptionBy = commonProcess.getKeyValueChangerElement("browserOptionKeyValueInCreatePlan","browserOptionKeyValue1InCreatePlan","CHROME");
        By versionOptionBy = commonProcess.getKeyValueChangerElement("versionOptionKeyValueInCreatePlan","versionOptionKeyValue1InCreatePlan","LATEST");
        commonProcess.checkElementVisible(methods.getBy("operatingSystemAreaInCreatePlan"));
        commonProcess.clickButton(operatingSystemBy);
        commonProcess.checkElementVisible(methods.getBy("browserAreaInCreatePlan"));
        commonProcess.clickButton(browserOptionBy);
        commonProcess.checkElementVisible(methods.getBy("versionAreaInCreatePlan"));
        commonProcess.clickButton(versionOptionBy);
        commonProcess.checkElementVisible(methods.getBy("screenResolutionInCreatePlan"));
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.clickButton(commonProcess.getKeyValueChangerElement("screenResolutionSelectOptionKeyValueInCreatePlan","screenResolutionSelectOptionKeyValue1InCreatePlan","1280x1024"));
        By screenResolutionAddButtonBy = methods.getBy("screenResolutionAddButtonInCreatePlan");
        commonProcess.clickButton(screenResolutionAddButtonBy);
    }

    public void e_No_Action() {

    }

    public void e_Click_Save() {

        By saveButtonBy = methods.getBy("saveButtonInCreatePlan");
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/plan/create",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("logoInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("projectNameInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("suiteNameInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInCreatePlan"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));

        if (!modelLocationStillCreatePlanPage) {
            setAttribute("isProjectSelected", Value.asValue(Boolean.parseBoolean(methodsUtil.getValueInTestMap("projectSelectedForPlan").toString())));
        }
        modelLocationStillCreatePlanPage = true;
    }

    public void e_Click_Save_Selected_Project() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By saveButtonBy = methods.getBy("saveButtonInCreatePlan");
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementClickable(projectBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.selectByVisibleText(projectBy, String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.clearElementWithBackSpace(suiteNameBy,"a");
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.checkElementVisible(suiteNameBy);
        commonProcess.clickButton(saveButtonBy);
    }

    public void e_Click_Save_Empty_Inputs() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By saveButtonBy = methods.getBy("saveButtonInCreatePlan");
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(suiteNameBy,"a");
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.checkElementVisible(suiteNameBy);
        commonProcess.clickButton(saveButtonBy);
    }

    public void e_Select_A_Platform_For_Appium_Project() {

        By appleBy = methods.getBy("iosInCreatePlan");
        commonProcess.checkElementVisible(methods.getBy("androidAreaInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("iosAreaInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("mobileDeviceInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("mobileVersionAreaInCreatePlan"));
        commonProcess.clickButton(appleBy);
        By mobileDeviceBy = commonProcess.getKeyValueChangerElement("mobileDeviceOptionKeyValueInCreatePlan","mobileDeviceOptionKeyValue1InCreatePlan","IPHONE 6");
        commonProcess.clickButton(mobileDeviceBy);
        commonProcess.checkElementVisible(mobileDeviceBy);
        By versionTextBy = commonProcess.getKeyValueChangerElement("mobileVersionOptionTextInCreatePlan","mobileVersionOptionText1InCreatePlan","last()");
        commonProcess.checkElementVisible(versionTextBy);
        methodsUtil.waitByMilliSeconds(200);
        String version = methods.getText(versionTextBy).trim();
        By versionBy = commonProcess.getKeyValueChangerElement("mobileVersionOptionKeyValueInCreatePlan","mobileVersionOptionKeyValue1InCreatePlan", version);
        commonProcess.clickButton(versionBy);
        By addButtonBy = methods.getBy("addButtonInCreatePlan");
        commonProcess.clickButton(addButtonBy);
        methodsUtil.putValueInTestMap("mobileVersion", version);
        appiumPlan = true;
    }

    public void v_Control_Invalid_Project() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By projectNameErrorBy = methods.getBy("projectNameErrorBlockInCreatePlan");
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementVisible(suiteNameBy);
        commonProcess.checkElementVisible(projectNameErrorBy);
        methodsUtil.waitByMilliSeconds(200);
        assertEquals("This field is required.", methods.getText(projectNameErrorBy).trim());
        commonProcess.checkElementVisible(methods.getBy("notAnyScenarioForScenariosInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("notAnyScenarioForScenarioOrderInCreatePlan"));
    }

    public void e_NO_Action() {

    }

    public void v_Control_Invalid_Suite_Name() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By suiteNameErrorBy = methods.getBy("suiteNameErrorBlockInCreatePlan");
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementVisible(suiteNameBy);
        commonProcess.checkElementVisible(suiteNameErrorBy);
        assertEquals("This field is required.", methods.getText(suiteNameErrorBy).trim());
    }

    public void v_Control_Selected_Web_Platform() {

        By tableBy = commonProcess.getKeyValueChangerElement("browserTableKeyValueInCreatePlan","browserTableKeyValue1InCreatePlan"
                , "Windows 10!!chrome!!LATEST!!1280x1024");
        commonProcess.checkElementVisible(tableBy);
    }

    public void e_Select_Project() {

        logger.info(getAttribute("isCreatePlanWebPlatform").toString());
        logger.info(getAttribute("isCreatePlanMobilePlatform").toString());
        String newPlan = "newPlan" + methodsUtil.randomString(6);
        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementClickable(projectBy);
        methodsUtil.waitByMilliSeconds(500);
        if(!appiumPlan){
            methodsUtil.putValueInTestMap("currentProject", methodsUtil.getValueInTestMap("appiumProject").toString());
            setAttribute("isCreatePlanWebPlatform", Value.asValue(false));
            setAttribute("isCreatePlanMobilePlatform", Value.asValue(true));
        }else {
            methodsUtil.putValueInTestMap("currentProject", methodsUtil.getValueInTestMap("optionalProject").toString());
            setAttribute("isCreatePlanWebPlatform", Value.asValue(true));
            setAttribute("isCreatePlanMobilePlatform", Value.asValue(false));
        }
        methods.selectByVisibleText(projectBy
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject")));
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementVisible(suiteNameBy);
        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        commonProcess.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(suiteNameBy,"a");
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.checkElementVisible(suiteNameBy);
        methods.sendKeys(suiteNameBy, newPlan);
        methodsUtil.putValueInTestMap("newPlan", newPlan);
        logger.info(getAttribute("isCreatePlanWebPlatform").toString());
        logger.info(getAttribute("isCreatePlanMobilePlatform").toString());
        methodsUtil.waitByMilliSeconds(300);
    }

    public void e_Click_Save_Filled_Suite_Name() {

        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By saveButtonBy = methods.getBy("saveButtonInCreatePlan");
        commonProcess.checkElementVisible(methods.getBy("projectNameInCreatePlan"));
        commonProcess.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.clearElementWithBackSpace(suiteNameBy,"a");
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.checkElementVisible(suiteNameBy);
        methods.sendKeys(suiteNameBy, "newPlan");
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Control_Project_Scenarios() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("scenarioForScenariosSelectListInCreatePlan"));
    }

    public void v_Verify_Selected_Test_Cases() {

        commonProcess.checkElementVisible(methods.getBy("scenarioForScenarioOrderInCreatePlan"));
        By scenarioForScenarioOrderBy = commonProcess.getKeyValueChangerElement("scenarioKeyValueForScenarioOrderInCreatePlan","scenarioKeyValueForScenarioOrder1InCreatePlan"
                , String.valueOf(methodsUtil.getValueInTestMap("scenarioNameInNewPlan")));
        commonProcess.checkElementVisible(scenarioForScenarioOrderBy);
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInCreatePlan");
        commonProcess.clickButton(cancelButtonBy);
        modelLocationStillCreatePlanPage = false;
    }

    public void v_Control_New_Plan() {

        assertTrue(methods.doesUrl("https://testinium.io/plan",75,"equal"));
        By projectBy = methods.getBy("selectProjectInAllSuites");
        commonProcess.checkElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"));
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementVisible(methods.getBy("exportTableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("createPlanInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        commonProcess.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        methodsUtil.waitByMilliSeconds(500);
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("currentProject"));
        methods.selectByVisibleText(projectBy, projectName);
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
        methodsUtil.waitByMilliSeconds(500);
        assertTrue(methods.isElementInVisible(commonProcess.getKeyValueChangerElement("tablePlanWithNotProjectNameInAllSuites","tablePlanWithNotProjectName1InAllSuites", projectName),60));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("tablePlanWithProjectNameInAllSuites","tablePlanWithProjectName1InAllSuites", projectName));
        methodsUtil.waitByMilliSeconds(500);
        String newPlan = String.valueOf(methodsUtil.getValueInTestMap("newPlan"));
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
            boolean isPlanVisible = false;
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
                    commonProcess.checkElementVisible(paginationNextBy);
                    commonProcess.checkElementClickable(paginationNextBy);
                    methodsUtil.waitByMilliSeconds(300);
                    methods.clickElement(paginationNextBy);
                    methodsUtil.waitByMilliSeconds(200);
                    commonProcess.checkElementVisible(paginationPanelBy);
                }

                commonProcess.checkElementVisible(methods.getBy("tableInAllSuites"));
                commonProcess.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
                methods.checkElementCondition(commonProcess.getKeyValueChangerElement("paginationPageWithNumberInAllSuites","paginationPageWithNumber1InAllSuites", String.valueOf(i))
                        ,"attribute","active","contain",10,"false","class");
                commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("tablePlanWithProjectNameInAllSuites","tablePlanWithProjectName1InAllSuites", projectName));
                if(methods.isElementVisible(commonProcess.getKeyValueChangerElement("tablePlanKeyValueInAllSuites","tablePlanKeyValue1InAllSuites"
                        ,projectName + "!!" + newPlan),3)){
                    isPlanVisible = true;
                    break;
                }
            }
            if (!isPlanVisible){
                fail(projectName + " projesinin " + newPlan + " planı bulunamadı.");
            }
        }else {
            assertTrue(methods.isElementVisible(commonProcess.getKeyValueChangerElement("tablePlanKeyValueInAllSuites","tablePlanKeyValue1InAllSuites"
                  , projectName + "!!" + newPlan),30));
        }

        modelLocationStillCreatePlanPage = false;
    }

    public void v_Control_Invalid_Inputs() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By projectNameErrorBy = methods.getBy("projectNameErrorBlockInCreatePlan");
        By suiteNameErrorBy = methods.getBy("suiteNameErrorBlockInCreatePlan");
        commonProcess.checkElementVisible(projectBy);
        commonProcess.checkElementVisible(suiteNameBy);
        commonProcess.checkElementVisible(projectNameErrorBy);
        commonProcess.checkElementVisible(suiteNameErrorBy);
        assertEquals("This field is required.", methods.getText(projectNameErrorBy).trim());
        assertEquals("This field is required.", methods.getText(suiteNameErrorBy).trim());
        commonProcess.checkElementVisible(methods.getBy("notAnyScenarioForScenariosInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("notAnyScenarioForScenarioOrderInCreatePlan"));
    }

    public void v_Control_Selected_Mobile_Platform() {

        By tableBy = commonProcess.getKeyValueChangerElement("mobileTableKeyValueInCreatePlan","mobileTableKeyValue1InCreatePlan"
                , "iOS!!IPHONE_6!!" + String.valueOf(methodsUtil.getValueInTestMap("mobileVersion")));
        commonProcess.checkElementVisible(tableBy);
    }

    public void e_Select_Test_Cases() {

        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        By scenarioNameForScenariosBy = commonProcess.getKeyValueChangerElement("scenarioForScenariosSelectListNumberInCreatePlan","scenarioForScenariosSelectListNumber1InCreatePlan","1");
        commonProcess.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        commonProcess.checkElementVisible(methods.getBy("scenarioForScenariosSelectListInCreatePlan"));
        commonProcess.checkElementVisible(scenarioNameForScenariosBy);
        commonProcess.checkElementClickable(scenarioNameForScenariosBy);
        methodsUtil.waitByMilliSeconds(200);
        String scenarioName = methods.getText(scenarioNameForScenariosBy).trim();
        methodsUtil.putValueInTestMap("scenarioNameInNewPlan",scenarioName);
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.clickButton(scenarioNameForScenariosBy);
    }

    public void e_no_action() {

    }
}
