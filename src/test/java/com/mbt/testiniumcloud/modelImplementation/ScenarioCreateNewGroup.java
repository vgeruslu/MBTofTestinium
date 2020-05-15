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
public class ScenarioCreateNewGroup extends ExecutionContext implements org.graphwalker.Scenario_Create_New_Group {

    private static final Logger logger = LoggerFactory.getLogger(ScenarioCreateNewGroup.class);
    Methods methods;

    public ScenarioCreateNewGroup() {

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
        /**
         int stepCount = Integer.parseInt(methods.getValueInTestMap("stepCount").toString()) + 1;
         methods.putValueInTestMap("stepCount",stepCount);
         logger.error("  " + stepCount + " " + getModel().getName() + "   "
         + (getCurrentElement() instanceof Edge.RuntimeEdge ? "Edge" : "Vertex") + "   "
         + getCurrentElement().getName() + "   "  + getCurrentElement().getId() + "   ");
         */
    }

    @AfterElement
    public void afterElement() {

        //logger.error("Success" + "\n");
        //logger.info(getCurrentElement() instanceof Edge.RuntimeEdge ? "Edge" : "Vertex");
        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
        //System.out.println("\r\n");
    }

    public void v_Verify_Create_New_Scenario_Group() {

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
        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        String scenarioName = String.valueOf(methods.getValueInTestMap("groupScenarioName"));
        By tableScenarioBy = methods.getByWithKeySetValue("tableScenarioNameKeyValueInAllScenarios"
                , projectName + "!!"
                        + scenarioName);
        methods.checkElementVisible(methods.getBy("tableInAllScenarios"));
        methods.checkElementVisible(methods.getBy("scenarioForTableInAllScenarios"));
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
            Assert.assertTrue(projectName + " projesinin " + scenarioName + " senaryosu bulunamadı."
                    , methods.isElementVisible(tableScenarioBy,30));
        }
    }

    public void v_Verify_Invalid_Create_New_Group_Empty_Inputs() {

        By projectNameErrorBlockBy = methods.getBy("projectNameErrorBlockInCreateNewGroup");
        By scenarioNameErrorBlockBy = methods.getBy("scenarioNameErrprBlockInCreateNewGroup");
        methods.checkElementVisible(projectNameErrorBlockBy);
        Assert.assertEquals("","This field is required."
                , methods.getText(projectNameErrorBlockBy).trim());
        methods.checkElementVisible(scenarioNameErrorBlockBy);
        Assert.assertEquals("","This field is required."
                , methods.getText(scenarioNameErrorBlockBy).trim());
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Create_New_Group_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/scenario/group/create",
                75,"equal"));
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
    }

    public void e_Click_Save_Empty_Inputs() {

        By saveButtonBy = methods.getBy("saveButtonInCreateNewGroup");
        methods.clearElementWithBackSpace(methods.getBy("scenarioNameInCreateNewGroup"));
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void e_No_action() {

    }

    public void e_no_Action() {

    }

    public void v_Verify_Invalid_Create_New_Group_Blank_Scenario_Name() {

        By projectNameErrorBlockBy = methods.getBy("projectNameErrorBlockInCreateNewGroup");
        By scenarioNameErrorBlockBy = methods.getBy("scenarioNameErrprBlockInCreateNewGroup");
        Assert.assertTrue("", methods.isElementInVisible(projectNameErrorBlockBy,30));
        methods.checkElementVisible(scenarioNameErrorBlockBy);
        Assert.assertEquals("","This field is required."
                , methods.getText(scenarioNameErrorBlockBy).trim());
    }

    public void e_Click_Save_No_Selected_Project() {

        By saveButtonBy = methods.getBy("saveButtonInCreateNewGroup");
        methods.sendKeys(methods.getBy("scenarioNameInCreateNewGroup")
        , "createGroupScenario");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInCreateNewGroup");
        methods.checkElementVisible(cancelButtonBy);
        methods.checkElementClickable(cancelButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(cancelButtonBy);
    }

    public void e_Click_Save_Blank_Scenario_Name() {

        By saveButtonBy = methods.getBy("saveButtonInCreateNewGroup");
        methods.selectByVisibleText(methods.getBy("projectNameInCreateNewGroup")
                , String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(saveButtonBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(methods.getBy("scenarioNameInCreateNewGroup"));
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void v_Verify_Invalid_Create_New_Group_None_Project() {

        By projectNameErrorBlockBy = methods.getBy("projectNameErrorBlockInCreateNewGroup");
        By scenarioNameErrorBlockBy = methods.getBy("scenarioNameErrprBlockInCreateNewGroup");
        methods.checkElementVisible(projectNameErrorBlockBy);
        Assert.assertEquals("","This field is required."
                , methods.getText(projectNameErrorBlockBy).trim());
        Assert.assertTrue("", methods.isElementInVisible(scenarioNameErrorBlockBy,30));
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

    public void e_Create_New_Group() {

        By saveButtonBy = methods.getBy("saveButtonInCreateNewGroup");
        methods.selectByVisibleText(methods.getBy("projectNameInCreateNewGroup")
                , String.valueOf(methods.getValueInTestMap("currentProject")));
        methods.checkElementVisible(saveButtonBy);
        methods.waitByMilliSeconds(300);
        methods.clearElement(methods.getBy("scenarioNameInCreateNewGroup"));
        String scenarioName = "groupScenario" + methods.randomString(6);
        methods.sendKeys(methods.getBy("scenarioNameInCreateNewGroup")
                , scenarioName);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
        methods.putValueInTestMap("groupScenarioName", scenarioName);
    }

}
