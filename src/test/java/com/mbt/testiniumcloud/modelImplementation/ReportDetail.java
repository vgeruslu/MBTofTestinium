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
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class ReportDetail extends ExecutionContext implements org.graphwalker.Report_Detail {

    private static final Logger logger = LogManager.getLogger(ReportDetail.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public ReportDetail() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
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

        assertTrue(methods.doesUrl("https://testinium.io/report/result/",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("logoTitleReportResult"));
        commonProcess.checkElementVisible(methods.getBy("createPublicUrlInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("downloadReportInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("formProjectInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("formTestSuiteInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("formScenarioInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("formIdInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("formStatusInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("formRunDateInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("formRunTimeInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("formOperatingSystemInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("commandInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("executionLogInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("seleniumOrAppiumLogInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("previousResultsInReportResult"));
        commonProcess.checkElementVisible(methods.getBy("sortInReportResult"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    /**
     * TODO: Download Control Export Table
     */
    public void v_Control_Downloaded_Export_Table_File() {

    }

    public void e_Click_Export_Table() {

        By exportTableBy = methods.getBy("exportTableInReportDetail");
        commonProcess.clickButton(exportTableBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Report_Detail_Page_SHARED() {

       assertTrue(methods.doesUrl("https://testinium.io/report/detail/",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("LogoTitleInReportDetail"));
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

    /**
     * TODO: Download Control Export Pdf
     */
    public void v_Control_Downloaded_Export_Pdf_File() {

    }

    public void e_Click_Details() {

        By testResultDetailButtonBy = methods.getBy("testResultDetailButtonInReportDetail");
        commonProcess.clickButton(testResultDetailButtonBy);
    }

    public void e_No_action() {

    }

    public void e_Click_Export_Pdf() {

        By exportPdfBy = methods.getBy("exportPdfInReportDetail");
        commonProcess.clickButton(exportPdfBy);
    }

    public void e_Navigate_Back() {

        methodsUtil.waitBySeconds(2);
        methods.navigateToBack();
    }
}
