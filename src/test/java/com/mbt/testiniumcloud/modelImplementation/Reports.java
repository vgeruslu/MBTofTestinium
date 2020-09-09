package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.utils.CoverageValue;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class Reports extends ExecutionContext implements org.graphwalker.Reports {

    private static final Logger logger = LoggerFactory.getLogger(Reports.class);
    Methods methods;
    ExcelMapData excelMapData;

    public Reports() {

        methods = new Methods();
        excelMapData = new ExcelMapData();
    }

    @BeforeExecution
    public void setup() {

    }

    @AfterExecution
    public void cleanup() {

    }

    @BeforeElement
    public void beforeElement() {

        excelMapData.setBeforeElementData(getModel().getName().trim()
                , getCurrentElement().getId().trim(), getCurrentElement().getName().trim());
        logger.info("═════════  " + getCurrentElement().getName() + "   " + getModel().getName() + "  ═════════");
    }

    @AfterElement
    public void afterElement() {

        logger.info(getCurrentElement() instanceof Edge.RuntimeEdge ? "Edge" : "Vertex");
        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    public void v_Control_Suites_For_Selected_Suite() {

        methods.checkElementVisible(methods.getBy("tableContainInReports"));
        String projectName = String.valueOf(methods.getValueInTestMap("editProject"));
        String planName = String.valueOf(methods.getValueInTestMap("selectedPlanInReports"));
        methods.checkElementVisible(methods
                .getByWithKeySetValue("tablePlanKeyValueInReports", planName + "!!" + projectName));
    }

    public void v_Verify_In_Reports_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report/detail/",75,"notStartWith"));
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report",75,"startWith"));
        /**
        methods.waitByMilliSeconds(300);
        String currentUrl = methods.getCurrentUrl().trim();
        logger.info(currentUrl);
        Assert.assertTrue("", currentUrl.equals("https://testinium.io/report")
                || currentUrl.startsWith("https://testinium.io/report/project/")
                || currentUrl.startsWith("https://testinium.io/report/plan/"));
         */
        methods.checkElementVisible(methods.getBy("reportsLogoTitleInReports"));
        methods.checkElementVisible(methods.getBy("createButtonInReports"));
        methods.checkElementVisible(methods.getBy("exportTableInReports"));
        methods.checkElementVisible(methods.getBy("projectsInReports"));
        methods.checkElementVisible(methods.getBy("suitesInReports"));
        methods.checkElementVisible(methods.getBy("dateFromInReports"));
        methods.checkElementVisible(methods.getBy("dateToInReports"));
        methods.checkElementVisible(methods.getBy("showOnlyFailedTestsInReports"));
        methods.checkElementVisible(methods.getBy("tableContainInReports"));
        methods.checkElementVisible(methods.getBy("tableCheckboxInReports"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));

        e_Select_All_Projects();
        By suitesBy = methods.getBy("suitesInReports");
        methods.checkElementVisible(suitesBy);
        methods.waitByMilliSeconds(200);
        //methods.selectByVisibleText(suitesBy, String.valueOf(methods.getValueInTestMap("currentPlan")));
        methods.selectByVisibleText(suitesBy,"All SUITES");
    }

    public void v_Verify_Drop_Down_Options() {

        methods.checkElementVisible(methods.getBy("reportsOptionsDeleteButtonInReports"));
    }

    public void e_Click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        methods.checkElementVisible(yesButtonBy);
        methods.checkElementClickable(yesButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(yesButtonBy);
    }

    public void v_Verify_Report_Is_Available() {

        String reportId = String.valueOf(methods.getValueInTestMap("reportId"));
        By tablePlanCheckboxBy = methods.getByWithKeySetValue("tablePlanCheckboxNumberWithIdInReports", reportId);
        methods.checkElementVisible(tablePlanCheckboxBy);
        // checkbox deselect
        methods.checkElementClickable(tablePlanCheckboxBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(tablePlanCheckboxBy);
    }

    public void v_Verify_Report_Is_Not_Available() {

        String reportId = String.valueOf(methods.getValueInTestMap("reportId"));
        By tablePlanCheckboxBy = methods.getByWithKeySetValue("tablePlanCheckboxNumberWithIdInReports", reportId);
        Assert.assertTrue("", methods.isElementInVisible(tablePlanCheckboxBy,30));
    }

    public void v_Control_Suites_For_Run_Date_To() {

        String[] dateArray = String.valueOf(methods.getValueInTestMap("dateForRunDateTo")).split("/");
        By tableElementsFromDateBy = methods.getByWithKeySetValue("tableElementsToDateKeyValueInReports", dateArray[2] + "!!"
                + dateArray[1] + "!!" + dateArray[2] +  "!!" + dateArray[0] + "!!" + dateArray[1] + "!!" + dateArray[2]);
        methods.checkElementVisible(tableElementsFromDateBy);
    }

    public void v_Control_Reports_Table() {

        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(methods.getBy("tableContainInReports"));
        methods.waitByMilliSeconds(200);
        if(methods.isElementVisible(methods.getBy("tableElementsInReports"),2)){
            setAttribute("isReportAvailable",true);
        }else {
            setAttribute("isReportAvailable",false);
        }
    }

    public void v_Control_Are_You_Sure_Message() {

        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
    }

    public void v_Verify_Options_Is_Visible() {

        methods.checkElementVisible(methods.getBy("reportsOptionsInReports"));
    }

    public void e_Click_Delete() {

        By reportsOptionsDeleteButtonBy = methods.getBy("reportsOptionsDeleteButtonInReports");
        methods.checkElementClickable(reportsOptionsDeleteButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(reportsOptionsDeleteButtonBy);
    }

    public void v_Control_Table() {

        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(methods.getBy("tableContainInReports"));
        methods.waitByMilliSeconds(500);
        if(methods.isElementVisible(methods.getBy("tableElementsInReports"),2)){
            setAttribute("isReportAvailable",true);
        }else {
            setAttribute("isReportAvailable",false);
        }
    }

    public void e_Run_Date_To() {

        String year = "2021";
        String month = "4";
        String day = "29";
        By dateToBy = methods.getBy("dateToInReports");
        methods.checkElementVisible(dateToBy);
        methods.checkElementClickable(dateToBy);
        methods.waitBySeconds(1);
        methods.clickElement(dateToBy);
        By calendarDateBy = methods.getBy("calendarDateInReports");
        methods.checkElementVisible(calendarDateBy);
        methods.waitByMilliSeconds(500);
        methods.scrollElement(calendarDateBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(calendarDateBy);
        methods.waitByMilliSeconds(500);
        By calendarNavigationButtonTwoBy = methods.getBy("calendarNavigationButton2InReports");
        methods.checkElementVisible(calendarNavigationButtonTwoBy);
        methods.checkElementClickable(calendarNavigationButtonTwoBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(calendarNavigationButtonTwoBy);
        methods.checkElementVisible(methods.getBy("yearsTableInReports"));
        By yearSelectBy = methods.getByWithKeySetValue("yearsSelectWithNumberKeyValueInReports", year);
        methods.checkElementVisible(yearSelectBy);
        methods.checkElementClickable(yearSelectBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(yearSelectBy);
        methods.checkElementVisible(methods.getBy("monthsTableInReports"));
        By monthSelectBy = methods.getByWithKeySetValue("monthsSelectWithNumberKeyValueInReports", month);
        methods.checkElementVisible(monthSelectBy);
        methods.checkElementClickable(monthSelectBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(monthSelectBy);
        methods.checkElementVisible(methods.getBy("calendarDateInReports"));
        By daySelectBy = methods.getByWithKeySetValue("dayWithCalendarKeyValue", day);
        methods.checkElementVisible(daySelectBy);
        methods.checkElementClickable(daySelectBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(daySelectBy);
        Assert.assertTrue("", methods.isElementInVisible(calendarDateBy,30));
        methods.putValueInTestMap("dateForRunDateTo", day + "/" + month + "/" + year);
    }

    public void v_Verify_In_Report_Detail_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report/detail/",
                75,"startWith"));
        methods.checkElementVisible(methods.getBy("exportTableInReportDetail"));
        methods.checkElementVisible(methods.getBy("exportPdfInReportDetail"));
        methods.checkElementVisible(methods.getBy("executionDetailTableInReportDetail"));
        //methods.checkElementVisible(methods.getBy("executionDetailTestCaseInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultTableInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultStatusInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultDetailButtonInReportDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Reports() {

        By reportsTabBy = methods.getBy("reportsTab");
        methods.checkElementVisible(reportsTabBy);
        methods.waitBySeconds(1);
        methods.scrollElement(reportsTabBy);
        methods.waitBySeconds(1);
        methods.checkElementClickable(reportsTabBy);
        methods.waitBySeconds(1);
        methods.clickElement(reportsTabBy);
    }

    public void e_No_Action() {

    }

    public void e_Select_A_Suite() {

        By suitesBy = methods.getBy("suitesInReports");
        methods.checkElementVisible(suitesBy);
        methods.waitByMilliSeconds(200);
        //methods.selectByVisibleText(suitesBy, String.valueOf(methods.getValueInTestMap("currentPlan")));
        methods.selectByIndex(suitesBy,1);
        methods.checkElementVisible(suitesBy);
        methods.waitByMilliSeconds(200);
        methods.putValueInTestMap("selectedPlanInReports", methods.getFirstSelectedOption(suitesBy).getText().trim());
    }

    public void e_Select_All_Projects() {

        By projectsBy = methods.getBy("projectsInReports");
        methods.checkElementVisible(projectsBy);
        methods.waitByMilliSeconds(200);
        methods.selectByVisibleText(projectsBy,"All Projects");
    }

    public void e_Select_A_Project() {

        By projectsBy = methods.getBy("projectsInReports");
        methods.checkElementVisible(projectsBy);
        methods.checkElementClickable(projectsBy);
        methods.waitBySeconds(1);
        methods.selectByVisibleText(projectsBy, String.valueOf(methods.getValueInTestMap("editProject")));
    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methods.checkElementClickable(noButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void v_Control_Suites_For_Selected_Project() {

        methods.checkElementVisible(methods.getBy("tableContainInReports"));
        String projectName = String.valueOf(methods.getValueInTestMap("editProject"));
        methods.checkElementVisible(methods.getByWithKeySetValue("tableProjectNameInReports", projectName));
        Assert.assertTrue("", methods
                .isElementInVisible(methods.getByWithKeySetValue("tableNotProjectNameInReports", projectName),30));
    }

    public void e_Click_Report_Checkbox() {

       String reportId = methods.getText(methods.getByWithKeySetValue("tablePlanIdNumberInReports", "1")).trim();
       By tablePlanCheckboxBy = methods.getByWithKeySetValue("tablePlanCheckboxNumberWithIdInReports", reportId);
       methods.checkElementVisible(tablePlanCheckboxBy);
       methods.checkElementClickable(tablePlanCheckboxBy);
       methods.waitByMilliSeconds(200);
       methods.clickElement(tablePlanCheckboxBy);
       methods.putValueInTestMap("reportId", reportId);
    }

    public void e_Click_Options() {

        By reportsOptionsBy = methods.getBy("reportsOptionsInReports");
        methods.checkElementClickable(reportsOptionsBy);
        methods.waitByMilliSeconds(200);
        methods.clickElement(reportsOptionsBy);
    }

    public void e_Run_Date_From() {

        String year = "2019";
        String month = "11";
        String day = "6";
        By dateFromBy = methods.getBy("dateFromInReports");
        methods.checkElementVisible(dateFromBy);
        methods.checkElementClickable(dateFromBy);
        methods.waitBySeconds(1);
        methods.clickElement(dateFromBy);
        By calendarDateBy = methods.getBy("calendarDateInReports");
        methods.checkElementVisible(calendarDateBy);
        methods.waitByMilliSeconds(500);
        methods.scrollElement(calendarDateBy);
        methods.waitByMilliSeconds(500);
        methods.checkElementVisible(calendarDateBy);
        methods.waitByMilliSeconds(500);
        By calendarNavigationButtonTwoBy = methods.getBy("calendarNavigationButton2InReports");
        methods.checkElementVisible(calendarNavigationButtonTwoBy);
        methods.checkElementClickable(calendarNavigationButtonTwoBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(calendarNavigationButtonTwoBy);
        methods.checkElementVisible(methods.getBy("yearsTableInReports"));
        By yearSelectBy = methods.getByWithKeySetValue("yearsSelectWithNumberKeyValueInReports", year);
        methods.checkElementVisible(yearSelectBy);
        methods.checkElementClickable(yearSelectBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(yearSelectBy);
        methods.checkElementVisible(methods.getBy("monthsTableInReports"));
        By monthSelectBy = methods.getByWithKeySetValue("monthsSelectWithNumberKeyValueInReports", month);
        methods.checkElementVisible(monthSelectBy);
        methods.checkElementClickable(monthSelectBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(monthSelectBy);
        methods.checkElementVisible(methods.getBy("calendarDateInReports"));
        By daySelectBy = methods.getByWithKeySetValue("dayWithCalendarKeyValue", day);
        methods.checkElementVisible(daySelectBy);
        methods.checkElementClickable(daySelectBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(daySelectBy);
        Assert.assertTrue("", methods.isElementInVisible(calendarDateBy,30));
        methods.putValueInTestMap("dateForRunDateFrom", day + "/" + month + "/" + year);
    }

    public void e_Click_Details() {

        //methods.getByWithKeySetValue("tablePlanDetailsButtonKeyValueInReports","planName!!projectName");
        By tablePlanDetailsButtonBy = methods.getBy("tablePlanDetailsButtonInReports");
        methods.checkElementVisible(tablePlanDetailsButtonBy);
        methods.checkElementClickable(tablePlanDetailsButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(tablePlanDetailsButtonBy);
    }

    public void v_Control_Suites_For_Run_Date_From() {

        String[] dateArray = String.valueOf(methods.getValueInTestMap("dateForRunDateFrom")).split("/");
        By tableElementsFromDateBy = methods.getByWithKeySetValue("tableElementsFromDateKeyValueInReports", dateArray[2] + "!!"
                + dateArray[1] + "!!" + dateArray[2] +  "!!" + dateArray[0] + "!!" + dateArray[1] + "!!" + dateArray[2]);
        methods.checkElementVisible(tableElementsFromDateBy);
    }
}
