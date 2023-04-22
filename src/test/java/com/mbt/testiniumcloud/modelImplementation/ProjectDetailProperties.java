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
public class ProjectDetailProperties extends ExecutionContext implements org.graphwalker.Project_Detail_Properties {

    private static final Logger logger = LogManager.getLogger(ProjectDetailProperties.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public ProjectDetailProperties() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(ProjectDetailProperties.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void e_No_Action() {

    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInProjectDetailProperties");
        commonProcess.clickButton(cancelButtonBy);
    }

    public void v_Verify_In_Project_Detail_Properties_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",75,"startWith"));
        assertTrue(methods.doesUrl("/properties",75,"endWith"));
        commonProcess.checkElementVisible(commonProcess.getKeyValueChangerElement("logoWithProjectNameInProjectDetailProperties"
                ,"logoWithProjectName1InProjectDetailProperties", String.valueOf(methodsUtil.getValueInTestMap("currentProject"))));
        commonProcess.checkElementVisible(methods.getBy("projectNameInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("testFrameworkInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("testFileTypeInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("testRunnerToolInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("gitProjectFolderNameInProjectDetailProperties"));
        //commonProcess.checkElementVisible(methods.getBy("gitBranchOrTagsInProjectDetailProperties"));
        //commonProcess.checkElementVisible(methods.getBy("enableCheckboxInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("applyButtonInProjectDetailProperties"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInProjectDetailProperties"));
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
    }

    public void e_Click_Save_Empty_Inputs() {

        By saveButtonBy = methods.getBy("saveButtonInProjectDetailProperties");
        commonProcess.checkElementVisible(saveButtonBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(methods.getBy("projectNameInProjectDetailProperties"),"a");
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(methods.getBy("gitProjectFolderNameInProjectDetailProperties"),"a");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Control_Invalid_Inputs() {

        By projectNameErrorBlockBy = methods.getBy("projectNameErrorBlockInProjectDetailProperties");
        commonProcess.checkElementVisible(projectNameErrorBlockBy);
        assertEquals("This field is required.", methods.getText(projectNameErrorBlockBy).trim());
        By gitProjectFolderNameErrorBlockBy = methods.getBy("gitProjectFolderNameErrorBlockInProjectDetailProperties");
        commonProcess.checkElementVisible(gitProjectFolderNameErrorBlockBy);
        assertEquals("This field is required.", methods.getText(gitProjectFolderNameErrorBlockBy).trim());
    }

    public void v_Verify_In_Projects_Page_SHARED() {

        /**
        assertTrue(methods.doesUrl("https://testinium.io/project",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("projectsLogoTitleInProjects"));
        commonProcess.checkElementVisible(methods.getBy("projectPanelInProjects"));
        commonProcess.checkElementVisible(methods.getBy("createProjectPanelInProjects"));
        commonProcess.checkElementVisible(methods.getBy("createProjectInProjects"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }
}
