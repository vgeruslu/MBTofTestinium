package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.methods.MethodsUtil;
import com.mbt.testiniumcloud.utils.CoverageValue;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.SharedNodeControl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class ReportDetail extends ExecutionContext implements org.graphwalker.Report_Detail {

    private static final Logger logger = LogManager.getLogger(ReportDetail.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public ReportDetail() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(ReportDetail.class), Level.toLevel(Driver.modelImplLogLevel));
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
        methodsUtil.waitByMilliSeconds(500);
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

    /**
     * TODO: Download Control Export Pdf
     */
    public void v_Control_Downloaded_Export_Pdf_File() {

    }

    public void e_Click_Details() {

        By testResultDetailButtonBy = methods.getBy("testResultDetailButtonInReportDetail");
        methods.checkElementVisible(testResultDetailButtonBy);
        methods.checkElementClickable(testResultDetailButtonBy);
        methodsUtil.waitByMilliSeconds(400);
        methods.clickElement(testResultDetailButtonBy);
    }

    public void e_No_action() {

    }

    public void e_Click_Export_Pdf() {

        By exportPdfBy = methods.getBy("exportPdfInReportDetail");
        methods.checkElementVisible(exportPdfBy);
        methods.checkElementClickable(exportPdfBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(exportPdfBy);
    }

    public void e_Navigate_Back() {

        methodsUtil.waitBySeconds(2);
        methods.navigateToBack();
    }
}
