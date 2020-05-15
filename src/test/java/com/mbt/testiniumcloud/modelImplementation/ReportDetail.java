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
public class ReportDetail extends ExecutionContext implements org.graphwalker.Report_Detail {

    private static final Logger logger = LoggerFactory.getLogger(ReportDetail.class);
    Methods methods;

    public ReportDetail() {

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

    public void v_Control_Report_Result() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report/result/",
                75,"startWith"));
        methods.checkElementVisible(methods.getBy("logoTitleReportResult"));
        methods.checkElementVisible(methods.getBy("createPublicUrlInReportResult"));
        methods.checkElementVisible(methods.getBy("downloadReportInReportResult"));
        methods.checkElementVisible(methods.getBy("formProjectInReportResult"));
        methods.checkElementVisible(methods.getBy("formTestSuiteInReportResult"));
        methods.checkElementVisible(methods.getBy("formScenarioInReportResult"));
        methods.checkElementVisible(methods.getBy("formIdInReportResult"));
        methods.checkElementVisible(methods.getBy("formStatusInReportResult"));
        methods.checkElementVisible(methods.getBy("formRunDateInReportResult"));
        methods.checkElementVisible(methods.getBy("formRunTimeInReportResult"));
        methods.checkElementVisible(methods.getBy("formOperatingSystemInReportResult"));
        methods.checkElementVisible(methods.getBy("commandInReportResult"));
        methods.checkElementVisible(methods.getBy("executionLogInReportResult"));
        methods.checkElementVisible(methods.getBy("seleniumOrAppiumLogInReportResult"));
        methods.checkElementVisible(methods.getBy("previousResultsInReportResult"));
        methods.checkElementVisible(methods.getBy("sortInReportResult"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    /**
     * TODO: Download Control Export Table
     */
    public void v_Control_Downloaded_Export_Table_File() {

    }

    public void e_Click_Export_Table() {

        By exportTableBy = methods.getBy("exportTableInReportDetail");
        methods.checkElementVisible(exportTableBy);
        methods.checkElementClickable(exportTableBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(exportTableBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Report_Detail_Page_SHARED() {

       Assert.assertTrue("", methods.doesUrl("https://testinium.io/report/detail/",
               75,"startWith"));
        methods.checkElementVisible(methods.getBy("LogoTitleInReportDetail"));
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
    }

    /**
     * TODO: Download Control Export Pdf
     */
    public void v_Control_Downloaded_Export_Pdf_File() {

    }

    public void e_Click_Details() {

        By testResultDetailButtonBy = methods.getBy("testResultDetailButtonInReportDetail");
        methods.checkElementVisible(testResultDetailButtonBy);
        methods.checkElementClickable(testResultDetailButtonBy);
        methods.waitByMilliSeconds(400);
        methods.clickElement(testResultDetailButtonBy);
    }

    public void e_No_action() {

    }

    public void e_Click_Export_Pdf() {

        By exportPdfBy = methods.getBy("exportPdfInReportDetail");
        methods.checkElementVisible(exportPdfBy);
        methods.checkElementClickable(exportPdfBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(exportPdfBy);
    }

    public void e_Navigate_Back() {

        methods.waitBySeconds(2);
        methods.navigateToBack();
    }
}
