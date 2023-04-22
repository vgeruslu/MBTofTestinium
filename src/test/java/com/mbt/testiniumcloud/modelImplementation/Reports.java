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
public class Reports extends ExecutionContext implements org.graphwalker.Reports {

    private static final Logger logger = LogManager.getLogger(Reports.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public Reports() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(Reports.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void v_Control_Suites_For_Selected_Suite() {

        commonProcess.checkElementVisible(methods.getBy("tableContainInReports"));
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("editProject"));
        String planName = String.valueOf(methodsUtil.getValueInTestMap("selectedPlanInReports"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("tablePlanKeyValueInReports","tablePlanKeyValue1InReports",planName + "!!" + projectName));
    }

    public void v_Verify_In_Reports_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/report/detail/",75,"notStartWith"));
        assertTrue(methods.doesUrl("https://testinium.io/report",75,"startWith"));
        /**
        methodsUtil.waitByMilliSeconds(300);
        String currentUrl = methods.getCurrentUrl().trim();
        logger.info(currentUrl);
        assertTrue(currentUrl.equals("https://testinium.io/report")
                || currentUrl.startsWith("https://testinium.io/report/project/")
                || currentUrl.startsWith("https://testinium.io/report/plan/"));
         */
        commonProcess.checkElementVisible(methods.getBy("reportsLogoTitleInReports"));
        commonProcess.checkElementVisible(methods.getBy("createButtonInReports"));
        commonProcess.checkElementVisible(methods.getBy("exportTableInReports"));
        commonProcess.checkElementVisible(methods.getBy("projectsInReports"));
        commonProcess.checkElementVisible(methods.getBy("suitesInReports"));
        commonProcess.checkElementVisible(methods.getBy("dateFromInReports"));
        commonProcess.checkElementVisible(methods.getBy("dateToInReports"));
        commonProcess.checkElementVisible(methods.getBy("showOnlyFailedTestsInReports"));
        commonProcess.checkElementVisible(methods.getBy("tableContainInReports"));
        commonProcess.checkElementVisible(methods.getBy("tableCheckboxInReports"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));

        e_Select_All_Projects();
        By suitesBy = methods.getBy("suitesInReports");
        commonProcess.checkElementVisible(suitesBy);
        methodsUtil.waitByMilliSeconds(200);
        //methods.selectByVisibleText(suitesBy, String.valueOf(methodsUtil.getValueInTestMap("currentPlan")));
        methods.selectByVisibleText(suitesBy,"All SUITES");
    }

    public void v_Verify_Drop_Down_Options() {

        commonProcess.checkElementVisible(methods.getBy("reportsOptionsDeleteButtonInReports"));
    }

    public void e_Click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        commonProcess.clickButton(yesButtonBy);
    }

    public void v_Verify_Report_Is_Available() {

        String reportId = String.valueOf(methodsUtil.getValueInTestMap("reportId"));
        By tablePlanCheckboxBy = commonProcess.getKeyValueChangerElement("tablePlanCheckboxNumberWithIdInReports","tablePlanCheckboxNumberWithId1InReports", reportId);
        // checkbox deselect
        commonProcess.clickButton(tablePlanCheckboxBy);
    }

    public void v_Verify_Report_Is_Not_Available() {

        String reportId = String.valueOf(methodsUtil.getValueInTestMap("reportId"));
        By tablePlanCheckboxBy = commonProcess.getKeyValueChangerElement("tablePlanCheckboxNumberWithIdInReports","tablePlanCheckboxNumberWithId1InReports", reportId);
        assertTrue(methods.isElementInVisible(tablePlanCheckboxBy,30));
    }

    public void v_Control_Suites_For_Run_Date_To() {

        String[] dateArray = String.valueOf(methodsUtil.getValueInTestMap("dateForRunDateTo")).split("/");
        By tableElementsFromDateBy = commonProcess.getKeyValueChangerElement("tableElementsToDateKeyValueInReports","tableElementsToDateKeyValue1InReports",dateArray[2] + "!!"
                + dateArray[1] + "!!" + dateArray[2] +  "!!" + dateArray[0] + "!!" + dateArray[1] + "!!" + dateArray[2]);
        commonProcess.checkElementVisible(tableElementsFromDateBy);
    }

    public void v_Control_Reports_Table() {

        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(methods.getBy("tableContainInReports"));
        methodsUtil.waitByMilliSeconds(200);
        if(methods.isElementVisible(methods.getBy("tableElementsInReports"),2)){
            setAttribute("isReportAvailable", Value.asValue(true));
        }else {
            setAttribute("isReportAvailable",Value.asValue(false));
        }
    }

    public void v_Control_Are_You_Sure_Message() {

        commonProcess.checkElementVisible(methods.getBy("popupTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        commonProcess.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
    }

    public void v_Verify_Options_Is_Visible() {

        commonProcess.checkElementVisible(methods.getBy("reportsOptionsInReports"));
    }

    public void e_Click_Delete() {

        By reportsOptionsDeleteButtonBy = methods.getBy("reportsOptionsDeleteButtonInReports");
        commonProcess.clickButton(reportsOptionsDeleteButtonBy);
    }

    public void v_Control_Table() {

        methodsUtil.waitByMilliSeconds(500);
        commonProcess.checkElementVisible(methods.getBy("tableContainInReports"));
        methodsUtil.waitByMilliSeconds(500);
        if(methods.isElementVisible(methods.getBy("tableElementsInReports"),2)){
            setAttribute("isReportAvailable",Value.asValue(true));
        }else {
            setAttribute("isReportAvailable",Value.asValue(false));
        }
    }

    public void e_Run_Date_To() {

        String year = "2021";
        String month = "4";
        String day = "29";
        By dateToBy = methods.getBy("dateToInReports");
        commonProcess.clickButton(dateToBy);
        By calendarDateBy = methods.getBy("calendarDateInReports");
        commonProcess.checkElementVisible(calendarDateBy);
        commonProcess.scrollElementCenter(calendarDateBy);
        commonProcess.checkElementVisible(calendarDateBy);
        methodsUtil.waitByMilliSeconds(500);
        By calendarNavigationButtonTwoBy = methods.getBy("calendarNavigationButton2InReports");
        commonProcess.clickButton(calendarNavigationButtonTwoBy);
        commonProcess.checkElementVisible(methods.getBy("yearsTableInReports"));
        By yearSelectBy = commonProcess.getKeyValueChangerElement("yearsSelectWithNumberKeyValueInReports","yearsSelectWithNumberKeyValue1InReports", year);
        commonProcess.clickButton(yearSelectBy);
        commonProcess.checkElementVisible(methods.getBy("monthsTableInReports"));
        By monthSelectBy = commonProcess.getKeyValueChangerElement("monthsSelectWithNumberKeyValueInReports","monthsSelectWithNumberKeyValue1InReports", month);
        commonProcess.clickButton(monthSelectBy);
        commonProcess.checkElementVisible(methods.getBy("calendarDateInReports"));
        By daySelectBy = commonProcess.getKeyValueChangerElement("dayWithCalendarKeyValue","dayWithCalendarKeyValue1", day);
        commonProcess.clickButton(daySelectBy);
        assertTrue(methods.isElementInVisible(calendarDateBy,30));
        methodsUtil.putValueInTestMap("dateForRunDateTo", day + "/" + month + "/" + year);
    }

    public void v_Verify_In_Report_Detail_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/report/detail/",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("exportTableInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("exportPdfInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("executionDetailTableInReportDetail"));
        //commonProcess.checkElementVisible(methods.getBy("executionDetailTestCaseInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("testResultTableInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("testResultStatusInReportDetail"));
        commonProcess.checkElementVisible(methods.getBy("testResultDetailButtonInReportDetail"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Reports() {

        By reportsTabBy = methods.getBy("reportsTab");
        commonProcess.checkElementVisible(reportsTabBy);
        commonProcess.scrollElementCenter(reportsTabBy);
        commonProcess.clickButton(reportsTabBy);
    }

    public void e_No_Action() {

    }

    public void e_Select_A_Suite() {

        By suitesBy = methods.getBy("suitesInReports");
        commonProcess.checkElementVisible(suitesBy);
        methodsUtil.waitByMilliSeconds(200);
        //methods.selectByVisibleText(suitesBy, String.valueOf(methodsUtil.getValueInTestMap("currentPlan")));
        methods.selectByIndex(suitesBy,1);
        commonProcess.checkElementVisible(suitesBy);
        methodsUtil.waitByMilliSeconds(200);
        methodsUtil.putValueInTestMap("selectedPlanInReports", methods.getFirstSelectedOption(suitesBy).getText().trim());
    }

    public void e_Select_All_Projects() {

        By projectsBy = methods.getBy("projectsInReports");
        commonProcess.checkElementVisible(projectsBy);
        methodsUtil.waitByMilliSeconds(200);
        methods.selectByVisibleText(projectsBy,"All Projects");
    }

    public void e_Select_A_Project() {

        By projectsBy = methods.getBy("projectsInReports");
        commonProcess.checkElementVisible(projectsBy);
        commonProcess.checkElementClickable(projectsBy);
        methodsUtil.waitBySeconds(1);
        methods.selectByVisibleText(projectsBy, String.valueOf(methodsUtil.getValueInTestMap("editProject")));
    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        commonProcess.clickButton(noButtonBy);
    }

    public void v_Control_Suites_For_Selected_Project() {

        commonProcess.checkElementVisible(methods.getBy("tableContainInReports"));
        String projectName = String.valueOf(methodsUtil.getValueInTestMap("editProject"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("tableProjectNameInReports","tableProjectName1InReports", projectName));
        assertTrue(methods.isElementInVisible(commonProcess.getKeyValueChangerElement("tableNotProjectNameInReports","tableNotProjectName1InReports", projectName),30));
    }

    public void e_Click_Report_Checkbox() {

       String reportId = methods.getText(commonProcess.getKeyValueChangerElement("tablePlanIdNumberInReports","tablePlanIdNumber1InReports","1")).trim();
       By tablePlanCheckboxBy = commonProcess.getKeyValueChangerElement("tablePlanCheckboxNumberWithIdInReports","tablePlanCheckboxNumberWithId1InReports", reportId);
       commonProcess.clickButton(tablePlanCheckboxBy);
       methodsUtil.putValueInTestMap("reportId", reportId);
    }

    public void e_Click_Options() {

        By reportsOptionsBy = methods.getBy("reportsOptionsInReports");
        commonProcess.clickButton(reportsOptionsBy);
    }

    public void e_Run_Date_From() {

        String year = "2019";
        String month = "11";
        String day = "6";
        By dateFromBy = methods.getBy("dateFromInReports");
        commonProcess.clickButton(dateFromBy);
        By calendarDateBy = methods.getBy("calendarDateInReports");
        commonProcess.checkElementVisible(calendarDateBy);
        commonProcess.scrollElementCenter(calendarDateBy);
        commonProcess.checkElementVisible(calendarDateBy);
        methodsUtil.waitByMilliSeconds(500);
        By calendarNavigationButtonTwoBy = methods.getBy("calendarNavigationButton2InReports");
        commonProcess.clickButton(calendarNavigationButtonTwoBy);
        commonProcess.checkElementVisible(methods.getBy("yearsTableInReports"));
        By yearSelectBy = commonProcess.getKeyValueChangerElement("yearsSelectWithNumberKeyValueInReports","yearsSelectWithNumberKeyValue1InReports", year);
        commonProcess.clickButton(yearSelectBy);
        commonProcess.checkElementVisible(methods.getBy("monthsTableInReports"));
        By monthSelectBy = commonProcess.getKeyValueChangerElement("monthsSelectWithNumberKeyValueInReports","monthsSelectWithNumberKeyValue1InReports", month);
        commonProcess.clickButton(monthSelectBy);
        commonProcess.checkElementVisible(methods.getBy("calendarDateInReports"));
        By daySelectBy = commonProcess.getKeyValueChangerElement("dayWithCalendarKeyValue","dayWithCalendarKeyValue1", day);
        commonProcess.clickButton(daySelectBy);
        assertTrue(methods.isElementInVisible(calendarDateBy,30));
        methodsUtil.putValueInTestMap("dateForRunDateFrom", day + "/" + month + "/" + year);
    }

    public void e_Click_Details() {

        //commonProcess.getKeyValueChangerElement("tablePlanDetailsButtonKeyValueInReports","planName!!projectName");
        By tablePlanDetailsButtonBy = methods.getBy("tablePlanDetailsButtonInReports");
        commonProcess.clickButton(tablePlanDetailsButtonBy);
    }

    public void v_Control_Suites_For_Run_Date_From() {

        String[] dateArray = String.valueOf(methodsUtil.getValueInTestMap("dateForRunDateFrom")).split("/");
        By tableElementsFromDateBy = commonProcess.getKeyValueChangerElement("tableElementsFromDateKeyValueInReports","tableElementsFromDateKeyValue1InReports",dateArray[2] + "!!"
                + dateArray[1] + "!!" + dateArray[2] +  "!!" + dateArray[0] + "!!" + dateArray[1] + "!!" + dateArray[2]);
        commonProcess.checkElementVisible(tableElementsFromDateBy);
    }
}
