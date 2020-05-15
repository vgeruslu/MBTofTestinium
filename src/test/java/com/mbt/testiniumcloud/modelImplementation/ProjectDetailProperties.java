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
public class ProjectDetailProperties extends ExecutionContext implements org.graphwalker.Project_Detail_Properties {

    private static final Logger logger = LoggerFactory.getLogger(ProjectDetailProperties.class);
    Methods methods;

    public ProjectDetailProperties() {

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

    public void e_No_Action() {

    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInProjectDetailProperties");
        methods.checkElementVisible(cancelButtonBy);
        methods.checkElementClickable(cancelButtonBy);
        methods.clickElement(cancelButtonBy);
    }

    public void v_Verify_In_Project_Detail_Properties_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/properties",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoWithProjectNameInProjectDetailProperties"
                , String.valueOf(methods.getValueInTestMap("currentProject"))));
        methods.checkElementVisible(methods.getBy("projectNameInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("testFrameworkInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("testFileTypeInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("testRunnerToolInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("gitProjectFolderNameInProjectDetailProperties"));
        //methods.checkElementVisible(methods.getBy("gitBranchOrTagsInProjectDetailProperties"));
        //methods.checkElementVisible(methods.getBy("enableCheckboxInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("cancelButtonInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("applyButtonInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("saveButtonInProjectDetailProperties"));
        methods.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Save_Empty_Inputs() {

        By saveButtonBy = methods.getBy("saveButtonInProjectDetailProperties");
        methods.checkElementVisible(saveButtonBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(methods.getBy("projectNameInProjectDetailProperties"));
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(methods.getBy("gitProjectFolderNameInProjectDetailProperties"));
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void v_Control_Invalid_Inputs() {

        By projectNameErrorBlockBy = methods.getBy("projectNameErrorBlockInProjectDetailProperties");
        methods.checkElementVisible(projectNameErrorBlockBy);
        Assert.assertEquals("","This field is required."
                , methods.getText(projectNameErrorBlockBy).trim());
        By gitProjectFolderNameErrorBlockBy = methods.getBy("gitProjectFolderNameErrorBlockInProjectDetailProperties");
        methods.checkElementVisible(gitProjectFolderNameErrorBlockBy);
        Assert.assertEquals("","This field is required."
                , methods.getText(gitProjectFolderNameErrorBlockBy).trim());
    }

    public void v_Verify_In_Projects_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project",75,"equal"));
        methods.checkElementVisible(methods.getBy("projectsLogoTitleInProjects"));
        methods.checkElementVisible(methods.getBy("projectPanelInProjects"));
        methods.checkElementVisible(methods.getBy("createProjectPanelInProjects"));
        methods.checkElementVisible(methods.getBy("createProjectInProjects"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }
}
