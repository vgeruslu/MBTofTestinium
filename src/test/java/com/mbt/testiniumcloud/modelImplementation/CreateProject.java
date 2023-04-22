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
public class CreateProject extends ExecutionContext implements org.graphwalker.Create_Project {

    private static final Logger logger = LogManager.getLogger(CreateProject.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public CreateProject() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(CreateProject.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void e_Click_Checked_Template_Checkbox() {

        By templateCheckboxBy = methods.getBy("templateCheckboxInCreateProject");
        commonProcess.checkElementVisible(templateCheckboxBy);
        commonProcess.checkElementClickable(templateCheckboxBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(templateCheckboxBy);
    }

    public void v_Control_Invalid_Create_Project_Empty_Url() {

        commonProcess.checkElementVisible(methods.getBy("templateSiteURLBlankErrorBlockInCreateProject"));
    }

    public void e_click_Save_Empty_Git_Project_Folder_Name() {

        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        commonProcess.checkElementVisible(gitProjectFolderNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(gitProjectFolderNameBy,"a");
        methodsUtil.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Verify_Selenium_Framework() {

        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFrameworkNameBy = methods.getBy("testFrameworkNameInCreateProject");
        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFrameworkBy);
        commonProcess.checkElementVisible(testFrameworkNameBy);
        methodsUtil.waitByMilliSeconds(200);
        assertEquals("SELENIUM", methods.getText(testFrameworkNameBy).trim());
        //if(methods.getSelectedOptionIndexWithJs(testFileTypeBy) != 0){
            e_Select_Selenium_Framework();
            commonProcess.checkElementVisible(testFrameworkBy);
            commonProcess.checkElementVisible(testFrameworkNameBy);
            methodsUtil.waitByMilliSeconds(200);
            assertEquals("SELENIUM", methods.getText(testFrameworkNameBy).trim());
       // }
    }

    public void v_Verify_In_Create_Project_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/project/create",75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("logoTitleInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("projectNameInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("gitProjectFolderNameInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("cancelButtonInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("saveButtonInCreateProject"));

        commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
        commonProcess.checkElementVisible(methods.getBy("projectsTab"));
        commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
        commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
        commonProcess.checkElementVisible(methods.getBy("reportsTab"));
        commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
    }

    public void e_Click_Save_With_Empty_Url() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        commonProcess.checkElementVisible(templateSiteUrlBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(templateSiteUrlBy,"a");
        methodsUtil.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
    }

    public void e_Click_Template_Checkbox() {

        By templateCheckboxBy = methods.getBy("templateCheckboxInCreateProject");
       commonProcess.clickButton(templateCheckboxBy);
    }

    /**
     * TODO: clear file
     */
    public void e_Clear_File() {

        e_Select_Selenium_Framework();
        methodsUtil.waitByMilliSeconds(200);
        e_Select_Appium_Framework();
        methodsUtil.waitByMilliSeconds(200);
    }

    public void v_Control_Invalid_Create_Project_Invalid_Url() {

        commonProcess.checkElementVisible(methods.getBy("templateSiteURLInvalidErrorBlockInCreateProject"));
    }

    public void e_Select_Selenium_Framework() {

        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFrameworkButtonBy = methods.getBy("testFrameworkButtonInCreateProject");
        commonProcess.clickButton(testFrameworkButtonBy);
        By seleniumFrameworkBy = methods.getBy("seleniumFrameworkInCreateProject");
        commonProcess.clickButton(seleniumFrameworkBy);
    }

    public void v_Control_Checked_Template_Checkbox() {

        By templateCheckboxCheckedConditionBy = methods.getBy("templateCheckboxCheckedConditionInCreateProject");
        commonProcess.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        commonProcess.checkElementVisible(templateCheckboxCheckedConditionBy);
        methodsUtil.waitByMilliSeconds(200);
        assertTrue(methods.getAttribute(templateCheckboxCheckedConditionBy,"class").contains("checked"));
    }

    public void v_Control_Upload_Ipa_Invalid_File() {

        commonProcess.checkElementVisible(methods.getBy("uploadIpaErrorBlockInCreateProject"));
    }

    public void e_click_Save_Empty_Project_Name() {

        By projectNameBy = methods.getBy("projectNameInCreateProject");
        commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(projectNameBy,"a");
        methodsUtil.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
    }
    /**
     * TODO Apk Upload
     */
    public void e_upload_Invalid_File() {

        String uploadDir = System.getProperty("user.dir") + "/pom.xml";
        if(Driver.osName.equals("WINDOWS")){
            uploadDir = uploadDir.replace("/","\\") ;
        }
        commonProcess.checkElementVisible(methods.getBy("mobileAppAreaInCreateProject"));
        By uploadAndroidApkInputBy = methods.getBy("uploadAndroidApkInputInCreateProject");
        commonProcess.checkElementVisible(methods.getBy("uploadAndroidApkAreaInCreateProject"));
        //commonProcess.checkElementVisible(uploadAndroidApkInputBy);
        methods.sendKeys(uploadAndroidApkInputBy, uploadDir);
    }

    public void e_Click_Save_Empty_Git_Project_Folder_Name() {

        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        commonProcess.checkElementVisible(gitProjectFolderNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(gitProjectFolderNameBy,"a");
        methodsUtil.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Verify_Site_Url_Value() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        commonProcess.checkElementVisible(templateSiteUrlBy);
        methodsUtil.waitByMilliSeconds(200);
        assertEquals("https://testinium.com/", methods.getAttribute(templateSiteUrlBy, "value").trim());
    }

    public void e_Select_Appium_Cucumber_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"APPIUM CUCUMBER");
        methodsUtil.putValueInTestMap("appiumTestFileType","APPIUM CUCUMBER");
    }

    public void e_Click_Save_Empty_Inputs() {

        By projectNameBy = methods.getBy("projectNameInCreateProject");
        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        By templateCheckboxBy = methods.getBy("templateCheckboxInCreateProject");
        By cancelButtonBy = methods.getBy("cancelButtonInCreateProject");
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");

        commonProcess.checkElementVisible(projectNameBy);
        commonProcess.checkElementVisible(testFrameworkBy);
        commonProcess.checkElementVisible(testFileTypeBy);
        commonProcess.checkElementVisible(gitProjectFolderNameBy);
        commonProcess.checkElementVisible(templateCheckboxBy);
        commonProcess.checkElementVisible(cancelButtonBy);
        commonProcess.checkElementVisible(saveButtonBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(projectNameBy,"a");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(projectNameBy);
        methods.clearElementWithBackSpace(gitProjectFolderNameBy,"a");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(gitProjectFolderNameBy);
        commonProcess.clickButton(saveButtonBy);
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

    public void e_Click_template_Checkbox() {

        By templateCheckboxBy = methods.getBy("templateCheckboxInCreateProject");
        commonProcess.clickButton(templateCheckboxBy);
    }

    public void e_Fill_Site_Url() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        commonProcess.checkElementVisible(templateSiteUrlBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(templateSiteUrlBy,"a");
        methodsUtil.waitByMilliSeconds(200);
        commonProcess.checkElementVisible(templateSiteUrlBy);
        methods.sendKeys(templateSiteUrlBy,"https://testinium.com/");
    }

    public void e_Create_Selenium_Template_Project() {

        String seleniumTestFileType = String.valueOf(methodsUtil.getValueInTestMap("seleniumTestFileType"));
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
        projectName = projectName + methodsUtil.randomString(6);
        By projectNameBy = methods.getBy("projectNameInCreateProject");
        commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(projectNameBy, projectName);
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        commonProcess.checkElementVisible(templateSiteUrlBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(templateSiteUrlBy,"https://testinium.com/");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        commonProcess.checkElementVisible(gitProjectFolderNameBy);
        methods.sendKeys(gitProjectFolderNameBy, projectName);
        methodsUtil.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
        methodsUtil.putValueInTestMap("newProject", projectName);
        methodsUtil.putValueInTestMap("currentProject", projectName);
       // commonProcess.checkElementVisible(methods.getBy("projectSuccessfullyCreated"),120);
    }

    public void v_Verify_Selected_Appium_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFileTypeBy);
        methodsUtil.waitByMilliSeconds(200);
        assertEquals( methodsUtil.getValueInTestMap("appiumTestFileType"), methods.getFirstSelectedOption(testFileTypeBy).getText().trim());
    }

    /**
     * @// TODO: 29.04.2020
     * TODO: Ipa Upload
     */
    public void e_Upload_Invalid_File() {

        String uploadDir = System.getProperty("user.dir") + "/pom.xml";
        if(Driver.osName.equals("WINDOWS")){
            uploadDir = uploadDir.replace("/","\\") ;
        }
        commonProcess.checkElementVisible(methods.getBy("mobileAppAreaInCreateProject"));
        By uploadIosIpaInputBy = methods.getBy("uploadIosIpaInputInCreateProject");
        commonProcess.checkElementVisible(methods.getBy("uploadIosIpaAreaInCreateProject"));
        //commonProcess.checkElementVisible(uploadIosIpaInputBy);
        methods.sendKeys(uploadIosIpaInputBy, uploadDir);
    }

    public void v_Verify_In_Project_Detail_Summary_Page_SHARED() {

        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",150,"startWith"),"Project isn't created");
        /**
        assertTrue(methods.doesUrl("https://testinium.io/project/detail/",75,"startWith"));
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

    public void v_Control_Selenium_Empty_Git_Project_Folder_Name() {

        commonProcess.checkElementVisible(methods.getBy("gitProjectFolderNameBlankErrorBlockInCreateProject"));
    }

    public void e_no_action() {

    }

    public void v_Control_Appium_Empty_Git_Project_Folder_Name() {

        commonProcess.checkElementVisible(methods.getBy("gitProjectFolderNameBlankErrorBlockInCreateProject"));
    }

    public void e_Create_Appium_Template_Project() {

        String appiumTestFileType = String.valueOf(methodsUtil.getValueInTestMap("appiumTestFileType"));
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
        projectName = projectName + methodsUtil.randomString(6);
        By projectNameBy = methods.getBy("projectNameInCreateProject");
        commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(projectNameBy, projectName);
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        commonProcess.checkElementVisible(gitProjectFolderNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(gitProjectFolderNameBy, projectName);
        methodsUtil.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
        methodsUtil.putValueInTestMap("newProject", projectName);
        methodsUtil.putValueInTestMap("currentProject", projectName);
        //commonProcess.checkElementVisible(methods.getBy("projectSuccessfullyCreated"),120);
    }

    public void e_Click_Save_Empty_Project_Name() {

        By projectNameBy = methods.getBy("projectNameInCreateProject");
        commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(projectNameBy,"a");
        methodsUtil.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Control_Upload_Apk_Invalid_File() {

        commonProcess.checkElementVisible(methods.getBy("uploadApkErrorBlockInCreateProject"));
    }

    public void e_Select_Selenium_Java_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"SELENIUM JAVA");
        methodsUtil.putValueInTestMap("seleniumTestFileType","SELENIUM JAVA");
    }

    public void e_Create_Selenium_Project() {

        String seleniumTestFileType = String.valueOf(methodsUtil.getValueInTestMap("seleniumTestFileType"));
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
        projectName = projectName + methodsUtil.randomString(6);
        By projectNameBy = methods.getBy("projectNameInCreateProject");
        commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(projectNameBy, projectName);
        commonProcess.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        commonProcess.checkElementVisible(gitProjectFolderNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(gitProjectFolderNameBy, projectName);
        methodsUtil.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
        methodsUtil.putValueInTestMap("newProject", projectName);
        methodsUtil.putValueInTestMap("currentProject", projectName);
        assertTrue(methods.isElementVisible(methods.getBy("projectSuccessfullyCreated"),120));
    }

    public void v_Control_Appium_Empty_Inputs() {

        By projectNameBlankErrorBlockBy = methods.getBy("projectNameBlankErrorBlockInCreateProject");
        By testFileTypeBlankOptionErrorBlockBy = methods.getBy("testFileTypeBlankOptionErrorBlockInCreateProject");
        By gitProjectFolderNameBlankErrorBlockBy = methods.getBy("gitProjectFolderNameBlankErrorBlockInCreateProject");
        commonProcess.checkElementVisible(projectNameBlankErrorBlockBy);
        commonProcess.checkElementVisible(testFileTypeBlankOptionErrorBlockBy);
        commonProcess.checkElementVisible(gitProjectFolderNameBlankErrorBlockBy);
    }

    public void v_Verify_Selected_Selenium_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFileTypeBy);
        methodsUtil.waitByMilliSeconds(200);
        assertEquals(methodsUtil.getValueInTestMap("seleniumTestFileType"), methods.getFirstSelectedOption(testFileTypeBy).getText().trim());
    }

    /**
     * TODO: kontrol et
     */
    public void v_Verify_Appium_Framework() {

        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFrameworkNameBy = methods.getBy("testFrameworkNameInCreateProject");
        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFrameworkBy);
        commonProcess.checkElementVisible(testFrameworkNameBy);
        methodsUtil.waitByMilliSeconds(200);
        assertEquals("APPIUM", methods.getText(testFrameworkNameBy).trim());
       // if(methods.getFirstSelectedOption(testFileTypeBy).){
            e_Select_Appium_Framework();
            commonProcess.checkElementVisible(testFrameworkBy);
            commonProcess.checkElementVisible(testFrameworkNameBy);
            methodsUtil.waitByMilliSeconds(200);
            assertEquals( "APPIUM", methods.getText(testFrameworkNameBy).trim());
      //  }
    }

    public void e_Click_Save_With_Invalid_Url() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        commonProcess.checkElementVisible(templateSiteUrlBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(templateSiteUrlBy,"a");
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(templateSiteUrlBy);
        methods.sendKeys(templateSiteUrlBy, "testinium.com");
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
    }

    public void v_Control_Site_Url_Area() {

        By templateSiteUrlBy = methods.getBy("templateSiteUrlInCreateProject");
        commonProcess.checkElementVisible(templateSiteUrlBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clearElementWithBackSpace(templateSiteUrlBy,"a");
        methodsUtil.waitByMilliSeconds(300);
    }

    public void v_Control_Selenium_Empty_Project_Name() {

        commonProcess.checkElementVisible(methods.getBy("projectNameBlankErrorBlockInCreateProject"));
    }

    public void e_Select_Selenium_Cucumber_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"SELENIUM CUCUMBER");
        methodsUtil.putValueInTestMap("seleniumTestFileType","SELENIUM CUCUMBER");
    }

    public void e_No_Action() {

    }

    public void v_Control_Selenium_Empty_Inputs() {

        By projectNameBlankErrorBlockBy = methods.getBy("projectNameBlankErrorBlockInCreateProject");
        By testFileTypeBlankOptionErrorBlockBy = methods.getBy("testFileTypeBlankOptionErrorBlockInCreateProject");
        By gitProjectFolderNameBlankErrorBlockBy = methods.getBy("gitProjectFolderNameBlankErrorBlockInCreateProject");
        commonProcess.checkElementVisible(projectNameBlankErrorBlockBy);
        commonProcess.checkElementVisible(testFileTypeBlankOptionErrorBlockBy);
        commonProcess.checkElementVisible(gitProjectFolderNameBlankErrorBlockBy);
    }

    public void e_Select_Appium_Framework() {

        By testFrameworkBy = methods.getBy("testFrameworkInCreateProject");
        By testFrameworkButtonBy = methods.getBy("testFrameworkButtonInCreateProject");
        By appiumFrameworkBy = methods.getBy("appiumFrameworkInCreateProject");
        commonProcess.checkElementVisible(testFrameworkBy);
        commonProcess.clickButton(testFrameworkButtonBy);
        commonProcess.clickButton(appiumFrameworkBy);
    }

    public void e_NO_Action() {

    }

    public void e_Create_Appium_Project() {

        String appiumTestFileType = String.valueOf(methodsUtil.getValueInTestMap("appiumTestFileType"));
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
        projectName = projectName + methodsUtil.randomString(6);
        By projectNameBy = methods.getBy("projectNameInCreateProject");
        commonProcess.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(projectNameBy, projectName);
        methodsUtil.waitByMilliSeconds(300);
        commonProcess.checkElementVisible(methods.getBy("testFrameworkInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("templateCheckboxInCreateProject"));
        commonProcess.checkElementVisible(methods.getBy("testFileTypeInCreateProject"));
        By gitProjectFolderNameBy = methods.getBy("gitProjectFolderNameInCreateProject");
        commonProcess.checkElementVisible(gitProjectFolderNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(gitProjectFolderNameBy, projectName);
        methodsUtil.waitByMilliSeconds(300);
        By saveButtonBy = methods.getBy("saveButtonInCreateProject");
        commonProcess.clickButton(saveButtonBy);
        methodsUtil.putValueInTestMap("newProject", projectName);
        methodsUtil.putValueInTestMap("currentProject", projectName);
        assertTrue(methods.isElementVisible(methods.getBy("projectSuccessfullyCreated"),120));
    }

    public void v_Control_Appium_Empty_Project_Name() {

        commonProcess.checkElementVisible(methods.getBy("projectNameBlankErrorBlockInCreateProject"));
    }

    public void e_Select_Appium_Gauge_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"APPIUM GAUGE");
        methodsUtil.putValueInTestMap("appiumTestFileType","APPIUM GAUGE");
    }

    public void e_Click_Cancel() {

        By cancelButtonBy = methods.getBy("cancelButtonInCreateProject");
        commonProcess.clickButton(cancelButtonBy);
    }

    /**
     * TODO: clear file
     */
    public void e_Clear_file() {

        e_Select_Selenium_Framework();
        methodsUtil.waitByMilliSeconds(200);
        e_Select_Appium_Framework();
        methodsUtil.waitByMilliSeconds(200);
    }

    public void e_Select_Selenium_Gauge_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"SELENIUM GAUGE");
        methodsUtil.putValueInTestMap("seleniumTestFileType","SELENIUM GAUGE");
    }

    public void e_Select_Appium_Java_Test_File_Type() {

        By testFileTypeBy = methods.getBy("testFileTypeInCreateProject");
        commonProcess.checkElementVisible(testFileTypeBy);
        methods.selectByVisibleText(testFileTypeBy,"APPIUM JAVA");
        methodsUtil.putValueInTestMap("appiumTestFileType","APPIUM JAVA");
    }
}
