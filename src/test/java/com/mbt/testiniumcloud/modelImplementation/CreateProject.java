package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.driver.DriverCreater;
import com.mbt.testiniumcloud.methods.Methods;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GraphWalker(value = "random(edge_coverage(100))")
public class CreateProject extends ExecutionContext implements org.graphwalker.Create_Project {

    private static final Logger logger = LoggerFactory.getLogger(CreateProject.class);
    Methods methods;

    public CreateProject() {

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

    public void e_Click_Checked_Template_Checkbox() {

        By templateCheckboxBy = methods.getBy("templateCheckboxInCreateProject");
        methods.checkElementVisible(templateCheckboxBy);
        methods.checkElementClickable(templateCheckboxBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(templateCheckboxBy);
    }

    public void v_Control_Invalid_Create_Project_Empty_Url() {

        methods.checkElementVisible(methods.getBy("templateSiteURLBlankErrorBlockInCreateProject"));
    }

    public void e_click_Save_Empty_Git_Project_Folder_Name() {

        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        methods.checkElementVisible(gitProjectFolderNameBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(gitProjectFolderNameBy);
        methods.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void v_Verify_Selenium_Framework() {

        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFrameworkNameBy = methods.getBy("testFrameworkNameInCreateProject");
        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFrameworkBy);
        methods.checkElementVisible(testFrameworkNameBy);
        methods.waitByMilliSeconds(200);
        Assert.assertEquals("", "SELENIUM", methods.getText(testFrameworkNameBy).trim());
        //if(methods.getSelectedOptionIndexWithJs(testFileTypeBy) != 0){
            e_Select_Selenium_Framework();
            methods.checkElementVisible(testFrameworkBy);
            methods.checkElementVisible(testFrameworkNameBy);
            methods.waitByMilliSeconds(200);
            Assert.assertEquals("", "SELENIUM", methods.getText(testFrameworkNameBy).trim());
       // }
    }

    public void v_Verify_In_Create_Project_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/create",75,"equal"));
        methods.checkElementVisible(methods.getBy("logoTitleInCreateProject"));
        methods.checkElementVisible(methods.getBy("projectNameInCreateProject"));
        methods.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        methods.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        methods.checkElementVisible(methods.getBy("gitProjectFolderNameInCreateProject"));
        methods.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        methods.checkElementVisible(methods.getBy("cancelButtonInCreateProject"));
        methods.checkElementVisible(methods.getBy("saveButtonInCreateProject"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Save_With_Empty_Url() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        methods.checkElementVisible(templateSiteUrlBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(templateSiteUrlBy);
        methods.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void e_Click_Template_Checkbox() {

        By templateCheckboxBy = methods.getBy("templateCheckboxInCreateProject");
        methods.checkElementVisible(templateCheckboxBy);
        methods.checkElementClickable(templateCheckboxBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(templateCheckboxBy);
    }

    public void e_Clear_File() {

        e_Select_Selenium_Framework();
        methods.waitByMilliSeconds(200);
        e_Select_Appium_Framework();
        methods.waitByMilliSeconds(200);
    }

    public void v_Control_Invalid_Create_Project_Invalid_Url() {

        methods.checkElementVisible(methods.getBy("templateSiteURLInvalidErrorBlockInCreateProject"));
    }

    public void e_Select_Selenium_Framework() {

        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFrameworkButtonBy = methods.getBy("testFrameworkButtonInCreateProject");
        By seleniumFrameworkBy = methods.getBy("seleniumFrameworkInCreateProject");
        methods.checkElementVisible(testFrameworkBy);
        methods.checkElementVisible(testFrameworkButtonBy);
        methods.checkElementClickable(testFrameworkButtonBy);
        methods.waitByMilliSeconds(200);
        methods.clickElement(testFrameworkButtonBy);
        methods.checkElementVisible(seleniumFrameworkBy);
        methods.checkElementClickable(seleniumFrameworkBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(seleniumFrameworkBy);
    }

    public void v_Control_Checked_Template_Checkbox() {

        By templateCheckboxCheckedConditionBy = methods.getBy("templateCheckboxCheckedConditionInCreateProject");
        methods.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        methods.checkElementVisible(templateCheckboxCheckedConditionBy);
        methods.waitByMilliSeconds(200);
        Assert.assertTrue("", methods
                .getAttribute(templateCheckboxCheckedConditionBy, "class").contains("checked"));
    }

    public void v_Control_Upload_Ipa_Invalid_File() {

        methods.checkElementVisible(methods.getBy("uploadIpaErrorBlockInCreateProject"));
    }

    public void e_click_Save_Empty_Project_Name() {

        By projectNameBy = methods.getBy("projectNameInCreateProject");
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(projectNameBy);
        methods.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void e_upload_Invalid_File() {

        String uploadDir = System.getProperty("user.dir") + "/pom.xml";
        if(DriverCreater.osName.equals("WINDOWS")){
            uploadDir = uploadDir.replace("/","\\") ;
        }
        methods.checkElementVisible(methods.getBy("mobileAppAreaInCreateProject"));
        By uploadAndroidApkInputBy = methods.getBy("uploadAndroidApkInputInCreateProject");
        methods.checkElementVisible(methods.getBy("uploadAndroidApkAreaInCreateProject"));
        //methods.checkElementVisible(uploadAndroidApkInputBy);
        methods.sendKeys(uploadAndroidApkInputBy, uploadDir);
    }

    public void e_Click_Save_Empty_Git_Project_Folder_Name() {

        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        methods.checkElementVisible(gitProjectFolderNameBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(gitProjectFolderNameBy);
        methods.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
    }

    public void v_Verify_Site_Url_Value() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        methods.checkElementVisible(templateSiteUrlBy);
        methods.waitByMilliSeconds(200);
        Assert.assertTrue("", methods
                .getAttribute(templateSiteUrlBy, "value").trim().equals("https://testinium.com/"));
    }

    public void e_Select_Appium_Cucumber_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"APPIUM CUCUMBER");
        methods.putValueInTestMap("appiumTestFileType","APPIUM CUCUMBER");
    }

    public void e_Click_Save_Empty_Inputs() {

        By projectNameBy = methods.getBy("projectNameInCreateProject");
        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        By templateCheckboxBy = methods.getBy("templateCheckboxInCreateProject");
        By cancelButtonBy = methods.getBy("cancelButtonInCreateProject");
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");

        methods.checkElementVisible(projectNameBy);
        methods.checkElementVisible(testFrameworkBy);
        methods.checkElementVisible(testFileTypeBy);
        methods.checkElementVisible(gitProjectFolderNameBy);
        methods.checkElementVisible(templateCheckboxBy);
        methods.checkElementVisible(cancelButtonBy);
        methods.checkElementVisible(saveButtonBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(projectNameBy);
        methods.clearElementWithBackSpace(gitProjectFolderNameBy);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(gitProjectFolderNameBy);
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(saveButtonBy);
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

    public void e_Click_template_Checkbox() {

        By templateCheckboxBy = methods.getBy("templateCheckboxInCreateProject");
        methods.checkElementVisible(templateCheckboxBy);
        methods.checkElementClickable(templateCheckboxBy);
        methods.waitByMilliSeconds(500);
        methods.clickElement(templateCheckboxBy);
    }

    public void e_Fill_Site_Url() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        methods.checkElementVisible(templateSiteUrlBy);
        methods.sendKeys(templateSiteUrlBy,"https://testinium.com/");
    }

    public void e_Create_Selenium_Template_Project() {

        String seleniumTestFileType = String.valueOf(methods.getValueInTestMap("seleniumTestFileType"));
        String projectName = "webTemp";
        switch (seleniumTestFileType.trim().split(" ")[1]){
            case "JAVA":
                projectName = projectName + "J";
                break;
            case "GAUGE":
                projectName = projectName + "G";
                break;
            case "CUCUMBER":
                projectName = projectName + "C";
                break;
            default:
        }
        projectName = projectName + methods.randomString(6);
        By projectNameBy = methods.getBy("projectNameInCreateProject");
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.sendKeys(projectNameBy, projectName);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        methods.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        methods.checkElementVisible(templateSiteUrlBy);
        methods.waitByMilliSeconds(300);
        methods.sendKeys(templateSiteUrlBy,"https://testinium.com/");
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        methods.checkElementVisible(gitProjectFolderNameBy);
        methods.sendKeys(gitProjectFolderNameBy, projectName);
        methods.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(saveButtonBy);
        methods.putValueInTestMap("newProject", projectName);
        methods.putValueInTestMap("currentProject", projectName);
        methods.checkElementVisible(methods.getBy("projectSuccessfullyCreated"),120);
    }

    public void v_Verify_Selected_Appium_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFileTypeBy);
        methods.waitByMilliSeconds(200);
        Assert.assertEquals("", methods.getValueInTestMap("appiumTestFileType")
                , methods.getFirstSelectedOption(testFileTypeBy).getText().trim());
    }

    public void e_Upload_Invalid_File() {

        String uploadDir = System.getProperty("user.dir") + "/pom.xml";
        if(DriverCreater.osName.equals("WINDOWS")){
            uploadDir = uploadDir.replace("/","\\") ;
        }
        methods.checkElementVisible(methods.getBy("mobileAppAreaInCreateProject"));
        By uploadIosIpaInputBy = methods.getBy("uploadIosIpaInputInCreateProject");
        methods.checkElementVisible(methods.getBy("uploadIosIpaAreaInCreateProject"));
        //methods.checkElementVisible(uploadIosIpaInputBy);
        methods.sendKeys(uploadIosIpaInputBy, uploadDir);
    }

    public void v_Verify_In_Project_Detail_Summary_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/detail/",75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/summary",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoWithProjectNameInProjectDetailSummary"
                , String.valueOf(methods.getValueInTestMap("currentProject"))));
        methods.checkElementVisible(methods.getBy("createNewSuitePanelInProjectDetailSummary"));
        methods.checkElementVisible(methods.getBy("latestSuiteRunsTableWithTextInProjectDetailSummary"));
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
         */
    }

    public void v_Control_Selenium_Empty_Git_Project_Folder_Name() {

        methods.checkElementVisible(methods.getBy("gitProjectFolderNameBlankErrorBlockInCreateProject"));
    }

    public void e_no_action() {

    }

    public void v_Control_Appium_Empty_Git_Project_Folder_Name() {

        methods.checkElementVisible(methods.getBy("gitProjectFolderNameBlankErrorBlockInCreateProject"));
    }

    public void e_Create_Appium_Template_Project() {

        String appiumTestFileType = String.valueOf(methods.getValueInTestMap("appiumTestFileType"));
        String projectName = "mobileTemp";
        switch (appiumTestFileType.trim().split(" ")[1]){
            case "JAVA":
                projectName = projectName + "J";
                break;
            case "GAUGE":
                projectName = projectName + "G";
                break;
            case "CUCUMBER":
                projectName = projectName + "C";
                break;
            default:
        }
        projectName = projectName + methods.randomString(6);
        By projectNameBy = methods.getBy("projectNameInCreateProject");
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.sendKeys(projectNameBy, projectName);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        methods.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        methods.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        methods.checkElementVisible(gitProjectFolderNameBy);
        methods.waitByMilliSeconds(300);
        methods.sendKeys(gitProjectFolderNameBy, projectName);
        methods.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(saveButtonBy);
        methods.putValueInTestMap("newProject", projectName);
        methods.putValueInTestMap("currentProject", projectName);
        methods.checkElementVisible(methods.getBy("projectSuccessfullyCreated"),120);
    }

    public void e_Click_Save_Empty_Project_Name() {

        By projectNameBy = methods.getBy("projectNameInCreateProject");
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(projectNameBy);
        methods.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(saveButtonBy);
    }

    public void v_Control_Upload_Apk_Invalid_File() {

        methods.checkElementVisible(methods.getBy("uploadApkErrorBlockInCreateProject"));
    }

    public void e_Select_Selenium_Java_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"SELENIUM JAVA");
        methods.putValueInTestMap("seleniumTestFileType","SELENIUM JAVA");
    }

    public void e_Create_Selenium_Project() {

        String seleniumTestFileType = String.valueOf(methods.getValueInTestMap("seleniumTestFileType"));
        String projectName = "web";
        switch (seleniumTestFileType.trim().split(" ")[1]){
            case "JAVA":
                projectName = projectName + "J";
                break;
            case "GAUGE":
                projectName = projectName + "G";
                break;
            case "CUCUMBER":
                projectName = projectName + "C";
                break;
            default:
        }
        projectName = projectName + methods.randomString(6);
        By projectNameBy = methods.getBy("projectNameInCreateProject");
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.sendKeys(projectNameBy, projectName);
        methods.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        methods.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        methods.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        methods.checkElementVisible(gitProjectFolderNameBy);
        methods.waitByMilliSeconds(300);
        methods.sendKeys(gitProjectFolderNameBy, projectName);
        methods.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(saveButtonBy);
        methods.putValueInTestMap("newProject", projectName);
        methods.putValueInTestMap("currentProject", projectName);
        methods.checkElementVisible(methods.getBy("projectSuccessfullyCreated"),120);
    }

    public void v_Control_Appium_Empty_Inputs() {

        By projectNameBlankErrorBlockBy = methods.getBy("projectNameBlankErrorBlockInCreateProject");
        By testFileTypeBlankOptionErrorBlockBy = methods.getBy("testFileTypeBlankOptionErrorBlockInCreateProject");
        By gitProjectFolderNameBlankErrorBlockBy = methods.getBy("gitProjectFolderNameBlankErrorBlockInCreateProject");
        methods.checkElementVisible(projectNameBlankErrorBlockBy);
        methods.checkElementVisible(testFileTypeBlankOptionErrorBlockBy);
        methods.checkElementVisible(gitProjectFolderNameBlankErrorBlockBy);
    }

    public void v_Verify_Selected_Selenium_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFileTypeBy);
        methods.waitByMilliSeconds(200);
        Assert.assertEquals("", methods.getValueInTestMap("seleniumTestFileType")
                , methods.getFirstSelectedOption(testFileTypeBy).getText().trim());
    }

    public void v_Verify_Appium_Framework() {

        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFrameworkNameBy = methods.getBy("testFrameworkNameInCreateProject");
        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFrameworkBy);
        methods.checkElementVisible(testFrameworkNameBy);
        methods.waitByMilliSeconds(200);
        Assert.assertEquals("", "APPIUM", methods.getText(testFrameworkNameBy).trim());
       // if(methods.getFirstSelectedOption(testFileTypeBy).){
            e_Select_Appium_Framework();
            methods.checkElementVisible(testFrameworkBy);
            methods.checkElementVisible(testFrameworkNameBy);
            methods.waitByMilliSeconds(200);
            Assert.assertEquals("", "APPIUM", methods.getText(testFrameworkNameBy).trim());
      //  }
    }

    public void e_Click_Save_With_Invalid_Url() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        methods.checkElementVisible(templateSiteUrlBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(templateSiteUrlBy);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(templateSiteUrlBy);
        methods.sendKeys(templateSiteUrlBy, "testinium.com");
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(saveButtonBy);
    }

    public void v_Control_Site_Url_Area() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        methods.checkElementVisible(templateSiteUrlBy);
        methods.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(templateSiteUrlBy);
        methods.waitByMilliSeconds(300);
    }

    public void v_Control_Selenium_Empty_Project_Name() {

        methods.checkElementVisible(methods.getBy("projectNameBlankErrorBlockInCreateProject"));
    }

    public void e_Select_Selenium_Cucumber_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"SELENIUM CUCUMBER");
        methods.putValueInTestMap("seleniumTestFileType","SELENIUM CUCUMBER");
    }

    public void e_No_Action() {

    }

    public void v_Control_Selenium_Empty_Inputs() {

        By projectNameBlankErrorBlockBy = methods.getBy("projectNameBlankErrorBlockInCreateProject");
        By testFileTypeBlankOptionErrorBlockBy = methods.getBy("testFileTypeBlankOptionErrorBlockInCreateProject");
        By gitProjectFolderNameBlankErrorBlockBy = methods.getBy("gitProjectFolderNameBlankErrorBlockInCreateProject");
        methods.checkElementVisible(projectNameBlankErrorBlockBy);
        methods.checkElementVisible(testFileTypeBlankOptionErrorBlockBy);
        methods.checkElementVisible(gitProjectFolderNameBlankErrorBlockBy);
    }

    public void e_Select_Appium_Framework() {

        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFrameworkButtonBy = methods.getBy("testFrameworkButtonInCreateProject");
        By appiumFrameworkBy = methods.getBy("appiumFrameworkInCreateProject");
        methods.checkElementVisible(testFrameworkBy);
        methods.checkElementVisible(testFrameworkButtonBy);
        methods.checkElementClickable(testFrameworkButtonBy);
        methods.waitByMilliSeconds(200);
        methods.clickElement(testFrameworkButtonBy);
        methods.checkElementVisible(appiumFrameworkBy);
        methods.checkElementClickable(appiumFrameworkBy);
        methods.waitByMilliSeconds(300);
        methods.clickElement(appiumFrameworkBy);
    }

    public void e_NO_Action() {

    }

    public void e_Create_Appium_Project() {

        String appiumTestFileType = String.valueOf(methods.getValueInTestMap("appiumTestFileType"));
        String projectName = "mobile";
        switch (appiumTestFileType.trim().split(" ")[1]){
            case "JAVA":
                projectName = projectName + "J";
                break;
            case "GAUGE":
                projectName = projectName + "G";
                break;
            case "CUCUMBER":
                projectName = projectName + "C";
                break;
            default:
        }
        projectName = projectName + methods.randomString(6);
        By projectNameBy = methods.getBy("projectNameInCreateProject");
        methods.checkElementVisible(projectNameBy);
        methods.waitByMilliSeconds(300);
        methods.sendKeys(projectNameBy, projectName);
        methods.waitByMilliSeconds(300);
        methods.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        methods.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        methods.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        methods.checkElementVisible(gitProjectFolderNameBy);
        methods.waitByMilliSeconds(300);
        methods.sendKeys(gitProjectFolderNameBy, projectName);
        methods.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        methods.checkElementVisible(saveButtonBy);
        methods.checkElementClickable(saveButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(saveButtonBy);
        methods.putValueInTestMap("newProject", projectName);
        methods.putValueInTestMap("currentProject", projectName);
        methods.checkElementVisible(methods.getBy("projectSuccessfullyCreated"),120);
    }

    public void v_Control_Appium_Empty_Project_Name() {

        methods.checkElementVisible(methods.getBy("projectNameBlankErrorBlockInCreateProject"));
    }

    public void e_Select_Appium_Gauge_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"APPIUM GAUGE");
        methods.putValueInTestMap("appiumTestFileType","APPIUM GAUGE");
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInCreateProject");
        methods.checkElementVisible(cancelButtonBy);
        methods.checkElementClickable(cancelButtonBy);
        methods.waitBySeconds(1);
        methods.clickElement(cancelButtonBy);
    }

    public void e_Clear_file() {

        e_Select_Selenium_Framework();
        methods.waitByMilliSeconds(200);
        e_Select_Appium_Framework();
        methods.waitByMilliSeconds(200);
    }

    public void e_Select_Selenium_Gauge_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"SELENIUM GAUGE");
        methods.putValueInTestMap("seleniumTestFileType","SELENIUM GAUGE");
    }

    public void e_Select_Appium_Java_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        methods.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"APPIUM JAVA");
        methods.putValueInTestMap("appiumTestFileType","APPIUM JAVA");
    }
}
