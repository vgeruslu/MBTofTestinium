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
public class CreatePlan extends ExecutionContext implements org.graphwalker.Create_Plan {

    private static final Logger logger = LoggerFactory.getLogger(CreatePlan.class);
    Methods methods;
    Boolean modelLocationStillCreatePlanPage = false;
    Boolean appiumPlan = false;

    public CreatePlan() {

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

    public void v_Verify_In_All_Suites_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan",75,"equal"));
        methods.checkElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"));
        methods.checkElementVisible(methods.getBy("selectProjectInAllSuites"));
        methods.checkElementVisible(methods.getBy("exportTableInAllSuites"));
        methods.checkElementVisible(methods.getBy("createPlanInAllSuites"));
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
         */
    }

    public void e_Select_A_Platform_For_Selenium_Project() {

        By operatingSystemBy = methods.getByWithKeySetValue("operatingSystemOptionKeyValueInCreatePlan","Windows 10");
        By browserOptionBy = methods.getByWithKeySetValue("browserOptionKeyValueInCreatePlan","CHROME");
        By versionOptionBy = methods.getByWithKeySetValue("versionOptionKeyValueInCreatePlan","LATEST");
        methods.checkElementVisible(methods.getBy("operatingSystemAreaInCreatePlan"));
        methods.checkElementVisible(operatingSystemBy);
        methods.checkElementClickable(operatingSystemBy);
        methods.waitByMilliSeconds(200);
        methods.clickElement(operatingSystemBy);
        methods.checkElementVisible(methods.getBy("browserAreaInCreatePlan"));
        methods.checkElementVisible(browserOptionBy);
        methods.checkElementClickable(browserOptionBy);
        methods.waitByMilliSeconds(200);
        methods.clickElement(browserOptionBy);
        methods.checkElementVisible(methods.getBy("versionAreaInCreatePlan"));
        methods.checkElementVisible(versionOptionBy);
        methods.checkElementClickable(versionOptionBy);
        methods.waitByMilliSeconds(200);
        methods.clickElement(versionOptionBy);
        methods.checkElementVisible(methods.getBy("screenResolutionInCreatePlan"));
        methods.waitByMilliSeconds(200);
        methods.clickElement(methods.getByWithKeySetValue("screenResolutionSelectOptionKeyValueInCreatePlan","1280x1024"));
        By screenResolutionAddButtonBy = methods.getBy("screenResolutionAddButtonInCreatePlan");
        methods.checkElementVisible(screenResolutionAddButtonBy);
        methods.checkElementClickable(screenResolutionAddButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(screenResolutionAddButtonBy);
    }

    public void e_No_Action() {

    }

    public void e_Click_Save() {

        By saveButtonBy = methods.getBy("saveButtonInCreatePlan");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(saveButtonBy);
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

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

        if (!modelLocationStillCreatePlanPage) {
            setAttribute("isProjectSelected",
                    Boolean.parseBoolean(methods.getValueInTestMap("projectSelectedForPlan").toString()));
        }
        modelLocationStillCreatePlanPage = true;
    }

    public void e_Click_Save_Selected_Project() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By saveButtonBy = methods.getBy("saveButtonInCreatePlan");
        methods.checkElementVisible(projectBy);
        methods.checkElementClickable(projectBy);
        methods.waitByMilliSeconds(300);
        methods.selectByVisibleText(projectBy
                , String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(projectBy);
        methods.checkElementVisible(suiteNameBy);
        methods.waitByMilliSeconds(200);
        methods.clearElementWithBackSpace(suiteNameBy);
        methods.waitByMilliSeconds(200);
        methods.checkElementVisible(suiteNameBy);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(saveButtonBy);
    }

    public void e_Click_Save_Empty_Inputs() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By saveButtonBy = methods.getBy("saveButtonInCreatePlan");
        methods.checkElementVisible(projectBy);
        methods.checkElementVisible(suiteNameBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(suiteNameBy);
        methods.waitByMilliSeconds(200);
        methods.checkElementVisible(suiteNameBy);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void e_Select_A_Platform_For_Appium_Project() {

        By appleBy = methods.getBy("iosInCreatePlan");
        methods.checkElementVisible(methods.getBy("androidAreaInCreatePlan"));
        methods.checkElementVisible(methods.getBy("iosAreaInCreatePlan"));
        methods.checkElementVisible(methods.getBy("mobileDeviceInCreatePlan"));
        methods.checkElementVisible(methods.getBy("mobileVersionAreaInCreatePlan"));
        methods.checkElementVisible(appleBy);
        methods.checkElementClickable(appleBy);
        methods.clickElement(appleBy);
        By mobileDeviceBy = methods.getByWithKeySetValue("mobileDeviceOptionKeyValueInCreatePlan","IPHONE 6");
        methods.checkElementVisible(mobileDeviceBy);
        methods.checkElementClickable(mobileDeviceBy);
        methods.clickElement(mobileDeviceBy);
        methods.checkElementVisible(mobileDeviceBy);
        By versionTextBy = methods.getByWithKeySetValue("mobileVersionOptionTextInCreatePlan","last()");
        methods.checkElementVisible(versionTextBy);
        methods.waitByMilliSeconds(200);
        String version = methods.getText(versionTextBy).trim();
        By versionBy = methods.getByWithKeySetValue("mobileVersionOptionKeyValueInCreatePlan", version);
        methods.checkElementVisible(versionBy);
        methods.checkElementClickable(versionBy);
        methods.clickElement(versionBy);
        By addButtonBy = methods.getBy("addButtonInCreatePlan");
        methods.checkElementVisible(addButtonBy);
        methods.checkElementClickable(addButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(addButtonBy);
        methods.putValueInTestMap("mobileVersion", version);
        appiumPlan = true;
    }

    public void v_Control_Invalid_Project() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By projectNameErrorBy = methods.getBy("projectNameErrorBlockInCreatePlan");
        methods.checkElementVisible(projectBy);
        methods.checkElementVisible(suiteNameBy);
        methods.checkElementVisible(projectNameErrorBy);
        methods.waitByMilliSeconds(200);
        Assert.assertEquals("","This field is required.", methods.getText(projectNameErrorBy).trim());
        methods.checkElementVisible(methods.getBy("notAnyScenarioForScenariosInCreatePlan"));
        methods.checkElementVisible(methods.getBy("notAnyScenarioForScenarioOrderInCreatePlan"));
    }

    public void e_NO_Action() {

    }

    public void v_Control_Invalid_Suite_Name() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By suiteNameErrorBy = methods.getBy("suiteNameErrorBlockInCreatePlan");
        methods.checkElementVisible(projectBy);
        methods.checkElementVisible(suiteNameBy);
        methods.checkElementVisible(suiteNameErrorBy);
        Assert.assertEquals("","This field is required.", methods.getText(suiteNameErrorBy).trim());
    }

    public void v_Control_Selected_Web_Platform() {

        By tableBy = methods.getByWithKeySetValue("browserTableKeyValueInCreatePlan"
                , "Windows 10!!chrome!!LATEST!!1280x1024");
        methods.checkElementVisible(tableBy);
    }

    public void e_Select_Project() {

        logger.info(getAttribute("isCreatePlanWebPlatform").toString());
        logger.info(getAttribute("isCreatePlanMobilePlatform").toString());
        String newPlan = "newPlan" + methods.randomString(6);
        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        methods.checkElementVisible(projectBy);
        methods.checkElementClickable(projectBy);
        methods.waitByMilliSeconds(500);
        if(!appiumPlan){
            methods.putValueInTestMap("currentProject", methods.getValueInTestMap("appiumProject").toString());
            setAttribute("isCreatePlanWebPlatform",false);
            setAttribute("isCreatePlanMobilePlatform",true);
        }else {
            methods.putValueInTestMap("currentProject", methods.getValueInTestMap("optionalProject").toString());
            setAttribute("isCreatePlanWebPlatform",true);
            setAttribute("isCreatePlanMobilePlatform",false);
        }
        methods.selectByVisibleText(projectBy
                , String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(projectBy);
        methods.checkElementVisible(suiteNameBy);
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        methods.checkElementVisible(suiteNameBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(suiteNameBy);
        methods.waitByMilliSeconds(200);
        methods.checkElementVisible(suiteNameBy);
        methods.sendKeys(suiteNameBy, newPlan);
        methods.putValueInTestMap("newPlan", newPlan);
        logger.info(getAttribute("isCreatePlanWebPlatform").toString());
        logger.info(getAttribute("isCreatePlanMobilePlatform").toString());
        methods.waitByMilliSeconds(300);
    }

    public void e_Click_Save_Filled_Suite_Name() {

        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By saveButtonBy = methods.getBy("saveButtonInCreatePlan");
        methods.checkElementVisible(methods.getBy("projectNameInCreatePlan"));
        methods.checkElementVisible(suiteNameBy);
        methods.waitByMilliSeconds(200);
        methods.clearElementWithBackSpace(suiteNameBy);
        methods.waitByMilliSeconds(200);
        methods.checkElementVisible(suiteNameBy);
        methods.sendKeys(suiteNameBy, "newPlan");
        methods.waitByMilliSeconds(200);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(saveButtonBy);
    }

    public void v_Control_Project_Scenarios() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        methods.checkElementVisible(projectBy);
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        methods.checkElementVisible(methods.getBy("scenarioForScenariosSelectListInCreatePlan"));
    }

    public void v_Verify_Selected_Test_Cases() {

        methods.checkElementVisible(methods.getBy("scenarioForScenarioOrderInCreatePlan"));
        By scenarioForScenarioOrderBy = methods.getByWithKeySetValue("scenarioKeyValueForScenarioOrderInCreatePlan"
                , String.valueOf(methods.getValueInTestMap("scenarioNameInNewPlan")));
        methods.checkElementVisible(scenarioForScenarioOrderBy);
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInCreatePlan");
        methods.checkElementVisible(cancelButtonBy);
        methods.checkElementClickable(cancelButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(cancelButtonBy);
        modelLocationStillCreatePlanPage = false;
    }

    public void v_Control_New_Plan() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan",75,"equal"));
        By projectBy = methods.getBy("selectProjectInAllSuites");
        methods.checkElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"));
        methods.checkElementVisible(projectBy);
        methods.checkElementVisible(methods.getBy("exportTableInAllSuites"));
        methods.checkElementVisible(methods.getBy("createPlanInAllSuites"));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        methods.waitByMilliSeconds(500);
        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        methods.selectByVisibleText(projectBy, projectName);
        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(projectBy);
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.waitByMilliSeconds(500);
        Assert.assertTrue("", methods.isElementInVisible(methods
                .getByWithKeySetValue("tablePlanWithNotProjectNameInAllSuites", projectName),60));
        methods.checkElementVisible(methods.getByWithKeySetValue("tablePlanWithProjectNameInAllSuites"
                , projectName));
        methods.waitByMilliSeconds(500);
        String newPlan = String.valueOf(methods.getValueInTestMap("newPlan"));

        By planCountBy = methods.getBy("planCountTextInAllSuites");
        methods.checkElementVisible(planCountBy);
        methods.waitByMilliSeconds(500);
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

                methods.checkElementVisible(methods.getBy("tableInAllSuites"));
                methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
                Assert.assertTrue("", methods.doesAttributeValue(methods
                                .getByWithKeySetValue("paginationPageWithNumberInAllSuites", String.valueOf(i))
                        ,"class","active","contain",50));
                methods.checkElementVisible(methods.getByWithKeySetValue("tablePlanWithProjectNameInAllSuites"
                        , projectName));
                if(methods.isElementVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                        , projectName + "!!" + newPlan),3)){
                    isPlanVisible = true;
                    break;
                }
            }
            if (!isPlanVisible){
                Assert.fail(projectName + " projesinin " + newPlan + " planı bulunamadı.");
            }
        }else {
            Assert.assertTrue("", methods.isElementVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                  , projectName + "!!" + newPlan),30));
        }

        modelLocationStillCreatePlanPage = false;
    }

    public void v_Control_Invalid_Inputs() {

        By projectBy = methods.getBy("projectNameInCreatePlan");
        By suiteNameBy = methods.getBy("suiteNameInCreatePlan");
        By projectNameErrorBy = methods.getBy("projectNameErrorBlockInCreatePlan");
        By suiteNameErrorBy = methods.getBy("suiteNameErrorBlockInCreatePlan");
        methods.checkElementVisible(projectBy);
        methods.checkElementVisible(suiteNameBy);
        methods.checkElementVisible(projectNameErrorBy);
        methods.checkElementVisible(suiteNameErrorBy);
        Assert.assertEquals("","This field is required.", methods.getText(projectNameErrorBy).trim());
        Assert.assertEquals("","This field is required.", methods.getText(suiteNameErrorBy).trim());
        methods.checkElementVisible(methods.getBy("notAnyScenarioForScenariosInCreatePlan"));
        methods.checkElementVisible(methods.getBy("notAnyScenarioForScenarioOrderInCreatePlan"));
    }

    public void v_Control_Selected_Mobile_Platform() {

        By tableBy = methods.getByWithKeySetValue("mobileTableKeyValueInCreatePlan"
                , "iOS!!IPHONE_6!!" +
                String.valueOf(methods.getValueInTestMap("mobileVersion")));
        methods.checkElementVisible(tableBy);
    }

    public void e_Select_Test_Cases() {

        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        By scenarioNameForScenariosBy = methods.getByWithKeySetValue("scenarioForScenariosSelectListNumberInCreatePlan"
                , "1");
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        methods.checkElementVisible(methods.getBy("scenarioForScenariosSelectListInCreatePlan"));
        methods.checkElementVisible(scenarioNameForScenariosBy);
        methods.checkElementClickable(scenarioNameForScenariosBy);
        methods.waitByMilliSeconds(200);
        String scenarioName = methods.getText(scenarioNameForScenariosBy).trim();
        methods.putValueInTestMap("scenarioNameInNewPlan",scenarioName);
        methods.waitByMilliSeconds(200);
        methods.clickElement(scenarioNameForScenariosBy);
    }

    public void e_no_action() {

    }
}
