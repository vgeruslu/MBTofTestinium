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
public class ProjectDetailSuites extends ExecutionContext implements org.graphwalker.Project_Detail_Suites {

    private static final Logger logger = LogManager.getLogger(ProjectDetailSuites.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public ProjectDetailSuites() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(ProjectDetailSuites.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void v_Verify_In_Reports_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/report",75,"startWith"));
        String currentUrl = methods.getCurrentUrl().trim();
        assertTrue(currentUrl.equals("https://testinium.io/report")
                || currentUrl.startsWith("https://testinium.io/report/project/")
                || currentUrl.startsWith("https://testinium.io/report/plan/"));
        commonProcess.checkElementVisible(methods.getBy("reportsLogoTitleInReports"));
        commonProcess.checkElementVisible(methods.getBy("createButtonInReports"));
        commonProcess.checkElementVisible(methods.getBy("exportTableInReports"));
        commonProcess.checkElementVisible(methods.getBy("projectsInReports"));
        commonProcess.checkElementVisible(methods.getBy("suitesInReports"));
        commonProcess.checkElementVisible(methods.getBy("dateFromInReports"));
        commonProcess.checkElementVisible(methods.getBy("dateToInReports"));
        commonProcess.checkElementVisible(methods.getBy("showOnlyFailedTestsInReports"));
        commonProcess.checkElementVisible(methods.getBy("tableInReports"));
        commonProcess.checkElementVisible(methods.getBy("tableCheckboxInReports"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_Verify_Suite_Is_Available() {

        By planBy = commonProcess.getKeyValueChangerElement("tablePlanWithPlanNameInProjectDetailSuites"
                ,"tablePlanWithPlanName1InProjectDetailSuites", String.valueOf(methodsUtil.getValueInTestMap("deletePlan")));
        commonProcess.checkElementVisible(planBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_Suite_Is_Not_Running() {

        methodsUtil.waitByMilliSeconds(200);
        assertTrue(methods.isElementInVisible(methods.getBy("TestRunSuccessfullStarted"),30));
    }

    public void v_Verify_Suite_Is_Running() {

        commonProcess.checkElementVisible(methods.getBy("TestRunSuccessfullStarted"));
        methodsUtil.waitByMilliSeconds(200);
    }

    public void e_click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        commonProcess.checkElementVisible(yesButtonBy);
        commonProcess.clickButton(yesButtonBy);
        methodsUtil.putValueInTestMap("testRun",true);
        setAttribute("suiteRunYes", Value.asValue(false));
    }

    public void e_Click_Report() {

        By planNameBy = methods.getBy("tablePlanNameWithReportButtonInProjectDetailSuites");
        commonProcess.checkElementVisible(planNameBy);
        String planName = methods.getText(planNameBy).trim();
        methodsUtil.putValueInTestMap("reportPlan", planName);
        By planReportButtonBy = commonProcess.getKeyValueChangerElement("reportButtonWithPlanNameInProjectDetailSuites","reportButtonWithPlanName1InProjectDetailSuites",planName);
        commonProcess.clickButton(planReportButtonBy);
    }

    public void e_Click_Run() {

        By planNameBy = methods.getBy("tablePlanNameInProjectDetailSuites");
        commonProcess.checkElementVisible(planNameBy);
        String planName = methods.getText(planNameBy).trim();
        methodsUtil.putValueInTestMap("runningPlan", planName);
        By planRunButtonBy = commonProcess.getKeyValueChangerElement("runButtonWithPlanNameInProjectDetailSuites","runButtonWithPlanName1InProjectDetailSuites",planName);
        commonProcess.clickButton(planRunButtonBy);
        if(!Boolean.parseBoolean(methodsUtil.getValueInTestMap("testRun").toString())
                && methodsUtil.getValueInTestMap("currentProject").toString().trim()
                .equals(methodsUtil.getValueInTestMap("editProject").toString())){
            setAttribute("suiteRunYes",Value.asValue(true));
        }
        else {
        setAttribute("suiteRunYes",Value.asValue(false));
        }
    }

    public void v_Verify_In_Project_Detail_Suites_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",75,"startWith"));
        assertTrue(methods.doesUrl("/plans",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailSuites"
                ,"logoWithProjectName1InProjectDetailSuites", String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
        commonProcess.checkElementVisible(methods.getBy("fromInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("toInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("runningTestCheckboxInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("failedOnesInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("tableInProjectDetailSuites"));
        commonProcess.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));

        if (methods.isElementVisible(methods.getBy("tableElementInProjectDetailSuites"),2)){

            commonProcess.checkElementVisible(methods.getBy("runButtonInProjectDetailSuites"));
            commonProcess.checkElementVisible(methods.getBy("editButtonInProjectDetailSuites"));
            commonProcess.checkElementVisible(methods.getBy("deleteButtonInProjectDetailSuites"));
            setAttribute("hasProjectAPlan",Value.asValue(true));
            if (methods.isElementVisible(methods.getBy("reportButtonInProjectDetailSuites"),2)){
                setAttribute("isReportAvailable",Value.asValue(true));
            }else {
                setAttribute("isReportAvailable",Value.asValue(false));
            }
        }else {
            setAttribute("hasProjectAPlan",Value.asValue(false));
            setAttribute("isReportAvailable",Value.asValue(false));
        }

        /**
         if(!Boolean.parseBoolean(methodsUtil.getValueInTestMap("editProjectRun").toString())
                && String.valueOf(methodsUtil.getValueInTestMap("currentProject"))
                .equals(methodsUtil.getValueInTestMap("editProject").toString())){
            setAttribute("suiteRunYes",true);
            methodsUtil.putValueInTestMap("editProjectRun",true);
        }*/
    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        commonProcess.clickButton(noButtonBy);
    }

    public void v_Control_Are_You_Sure_Message() {

        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitByMilliSeconds(500);
    }

    public void e_Click_Delete() {

        By planNameBy = methods.getBy("tablePlanNameInProjectDetailSuites");
        commonProcess.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String planName = methods.getText(planNameBy).trim();
        methodsUtil.putValueInTestMap("deletePlan", planName);
        By planDeleteButtonBy = commonProcess.getKeyValueChangerElement("deleteButtonWithPlanNameInProjectDetailSuites","deleteButtonWithPlanName1InProjectDetailSuites", planName);
        commonProcess.clickButton(planDeleteButtonBy);
    }

    public void v_Verify_In_Project_Detail_Summary_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        assertTrue(methods.doesUrl("/summary",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailSummary"
                , String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
        commonProcess.checkElementVisible(methods.getBy("createNewSuitePanelInProjectDetailSummary"));
        commonProcess.checkElementVisible(methods.getBy("latestSuiteRunsTableWithTextInProjectDetailSummary"));
        commonProcess.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        commonProcess.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_Click_Project_Detail_Summary_Tab() {

        By summaryTabBy = methods.getBy("summaryTabInProjectDetail");
        commonProcess.clickButton(summaryTabBy);
    }

    public void e_Click_Edit() {

        By planNameBy = methods.getBy("tablePlanNameInProjectDetailSuites");
        commonProcess.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String planName = methods.getText(planNameBy).trim();
        methodsUtil.putValueInTestMap("editPlanName", planName);
        methodsUtil.putValueInTestMap("editProjectName", methodsUtil.getValueInTestMap("currentProject").toString());
        By planEditButtonBy = commonProcess.getKeyValueChangerElement("editButtonWithPlanNameInProjectDetailSuites","editButtonWithPlanName1InProjectDetailSuites", planName);
        commonProcess.clickButton(planEditButtonBy);
    }

    public void v_control_Are_You_Sure_Message() {

        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitByMilliSeconds(200);
    }

    public void v_Verify_In_Plan_Edit_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/plan/edit/",
                75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoTitleInPlanEdit"
                ,"logoTitle1InPlanEdit", String.valueOf(methodsUtil.getValueInTestMap("editPlanName"))));
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
    }

    public void e_no_action() {

    }
}
