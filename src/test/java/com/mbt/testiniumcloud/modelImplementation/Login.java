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

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, start = "v_Start")
public class Login extends ExecutionContext implements org.graphwalker.Login {

    private static final Logger logger = LogManager.getLogger(Login.class);
    Methods methods;
    MethodsUtil methodsUtil;
    CommonProcess commonProcess;
    ExcelMapData excelMapData;

    public Login() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        commonProcess = new CommonProcess();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(Login.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void v_Verify_In_Login_LinkedIn_Page() {
/**
        assertTrue(methods.doesUrl("https://www.linkedin.com/uas/login",75,"startWith");
        commonProcess.checkElementVisible(methods.getBy("usernameInLinkedIn"));
        commonProcess.checkElementVisible(methods.getBy("passwordInLinkedIn"));
        commonProcess.checkElementVisible(methods.getBy("signInInLinkedIn"));
 */
    }

    public void e_Login_Using_Google() {

        /**
        methods.sendKeys(methods.getBy("emailInGoogle")
                , DriverCreater.ConfigurationProp.getString("GOOGLE_USERNAME"));
        commonProcess.checkElementClickable(methods.getBy("nextButtonInGoogle"));
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(methods.getBy("nextButtonInGoogle"));
        commonProcess.checkElementVisible(methods.getBy("profileIdentifierInGoogle"));
        commonProcess.checkElementVisible(methods.getBy("passwordInGoogle"));
        commonProcess.checkElementVisible(methods.getBy("passwordNextInGoogle"));
        methods.sendKeys(methods.getBy("passwordInGoogle")
                , DriverCreater.ConfigurationProp.getString("GOOGLE_PASSWORD"));
        commonProcess.checkElementClickable(methods.getBy("passwordNextInGoogle"));
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(methods.getBy("passwordNextInGoogle"));
         */

    }

    public void v_Verify__In_Login_Google_Page() {

        /**
        assertTrue(methods.doesUrl("https://accounts.google.com/signin/",75,"startWith");
        commonProcess.checkElementVisible(methods.getBy("emailInGoogle"));
        commonProcess.checkElementVisible(methods.getBy("nextButtonInGoogle"));
         */
    }

    public void v_Verify_Sent_Unregistered_Email_Error_Message() {

        commonProcess.checkElementVisible(methods.getBy("unregisteredEmailMessageInForgotPassword"));
        assertTrue(methods.doesUrl("https://account.testinium.com/uaa/send-reminder-mail",
                75,"equal"));
    }

    public void e_Login_Using_LinkedIn() {
/**
        methods.sendKeys(methods.getBy("usernameInLinkedIn")
                , DriverCreater.ConfigurationProp.getString("LINKEDIN_USERNAME"));
        methods.sendKeys(methods.getBy("passwordInLinkedIn")
                , DriverCreater.ConfigurationProp.getString("LINKEDIN_PASSWORD"));
        commonProcess.checkElementClickable(methods.getBy("signInInLinkedIn"));
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(methods.getBy("signInInLinkedIn"));
 */
    }

    public void e_Logout() {

        By userDropDownBy = methods.getBy("btnUserDropdown");
        commonProcess.checkElementVisible(userDropDownBy);
        commonProcess.scrollElementCenter(userDropDownBy);
        commonProcess.clickButton(userDropDownBy);
        By logoutBy = methods.getBy("btnLogOut");
        commonProcess.clickButton(logoutBy);
    }

    public void v_Verify_In_Login_Page() {

        assertTrue(methods.doesUrl("https://account.testinium.com/uaa/login",75,"startWith"));
        commonProcess.checkElementVisible(methods.getBy("userNameInLogin"));
        commonProcess.checkElementVisible(methods.getBy("passwordInLogin"));
        commonProcess.checkElementVisible(methods.getBy("signInInLogin"));
        commonProcess.checkElementClickable(methods.getBy("signInInLogin"));
        commonProcess.checkElementVisible(methods.getBy("forgotPasswordInLogin"));
        commonProcess.checkElementVisible(methods.getBy("linkedInButtonInLogin"));
        commonProcess.checkElementVisible(methods.getBy("googleButtonInLogin"));
        commonProcess.checkElementVisible(methods.getBy("githubButtonInLogin"));
        commonProcess.checkElementVisible(methods.getBy("signUpButtonInLogin"));
    }

    public void e_Click_Signin() {

        By signInForgotPasswordBy = methods.getBy("signInInForgotPassword");
        commonProcess.clickButton(signInForgotPasswordBy);
    }

    public void e_Invalid_Login_Invalid_Email() {

        By userNameBy = methods.getBy("userNameInLogin");
        methods.clearElement(userNameBy);
        methods.sendKeys(userNameBy, "deneme.invalidemail.com");
        By passwordBy = methods.getBy("passwordInLogin");
        methods.clearElement(passwordBy);
        methods.sendKeys(passwordBy,"12345678");
        commonProcess.clickButton(methods.getBy("signInInLogin"));
    }

    public void v_Verify_In_Forgot_Password_Page() {

        assertTrue(methods.doesUrl("https://account.testinium.com/uaa/forgot-password",
                75,"equal"));
        commonProcess.checkElementVisible(methods.getBy("forgotPasswordTitle"));
        assertEquals( "FORGOT PASSWORD ?"
                , methods.getText(methods.getBy("forgotPasswordTitle")).trim());
        commonProcess.checkElementVisible(methods.getBy("emailInForgotPassword"));
        commonProcess.checkElementVisible(methods.getBy("sendPasswordResetEmailInForgotPassword"));
        commonProcess.checkElementVisible(methods.getBy("signInInForgotPassword"));
    }

    public void e_Click_Forgot_Password_Button() {

        By forgotPasswordButtonBy = methods.getBy("forgotPasswordInLogin");
        commonProcess.clickButton(forgotPasswordButtonBy);
    }

    public void e_Click_Continue_With_Google() {
/**
        By googleButtonInLoginBy = methods.getBy("googleButtonInLogin");
        commonProcess.checkElementClickable(googleButtonInLoginBy);
        methods.clickElement(googleButtonInLoginBy);

        ////div[@role="button" and .//span[text()="Onayla"]]
 */
        e_Valid_Login();
    }

    public void v_Verify_Invalid_Password() {

        commonProcess.checkElementVisible(methods.getBy("incorrectEmailorPasswordInLogin"));
    }

    public void v_Verify_In_Login_Github_Page() {

        /**
        assertTrue(methods.doesUrl("https://github.com/login",75,"startWith");
        commonProcess.checkElementVisible(methods.getBy("usernameInGithub"));
        commonProcess.checkElementVisible(methods.getBy("passwordInGithub"));
        commonProcess.checkElementVisible(methods.getBy("signInInGithub"));
         */
    }

    public void e_Go_To_Login_Page() {

        methods.navigateTo("https://account.testinium.com/uaa/login");
    }

    public void e_Click_Continue_With_LinkedIn() {

        e_Valid_Login();
        /**

        By ContinueWithLinkedInButton = methods.getBy("linkedInButtonInLogin");
        commonProcess.checkElementVisible(ContinueWithLinkedInButton);
        methods.isElementClickable(ContinueWithLinkedInButton, 30);
        methods.clickElement(ContinueWithLinkedInButton);
         */
    }

    public void v_Verify_Invalid_Login_Empty() {

        commonProcess.checkElementVisible(methods.getBy("usernameErrorInLogin"));
        commonProcess.checkElementVisible(methods.getBy("passwordErrorInLogin"));
        methodsUtil.waitByMilliSeconds(100);
        assertEquals("This field is required.", methods.getText(methods.getBy("usernameErrorInLogin")).trim());
        assertEquals("This field is required.", methods.getText(methods.getBy("passwordErrorInLogin")).trim());
    }

    public void e_Invalid_Login_Invalid_Password() {

        By userNameBy = methods.getBy("userNameInLogin");
        methods.clearElement(userNameBy);
        methods.sendKeys(userNameBy, Driver.ConfigurationProp.getString("VALID_USERNAME"));
        By passwordBy = methods.getBy("passwordInLogin");
        methods.clearElement(passwordBy);
        methods.sendKeys(passwordBy,"invalidEmail");
        commonProcess.clickButton(methods.getBy("signInInLogin"));
    }

    public void e_Login_Using_Github() {

        /**
        methods.sendKeys(methods.getBy("usernameInGithub")
                , DriverCreater.ConfigurationProp.getString("GITHUB_USERNAME"));
        methods.sendKeys(methods.getBy("passwordInGithub")
                , DriverCreater.ConfigurationProp.getString("GITHUB_PASSWORD"));
        commonProcess.checkElementClickable(methods.getBy("signInInGithub"));
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(methods.getBy("signInInGithub"));

         */
        // https://github.com/sessions/verified-device
    }

    public void e_click_SignIn() {

        By signInForgotPasswordBy = methods.getBy("signInInForgotPassword");
        commonProcess.clickButton(signInForgotPasswordBy);
    }

    public void v_Verify_Invalid_Email() {

        commonProcess.checkElementVisible(methods.getBy("usernameErrorInLogin"));
        assertTrue(methods.isElementInVisible(methods.getBy("passwordErrorInLogin"), 30));
        methodsUtil.waitByMilliSeconds(100);
        assertEquals("Please enter a valid email address.", methods.getText(methods.getBy("usernameErrorInLogin")).trim());
    }

    public void e_Valid_Login() {

        By signInButtonBy = methods.getBy("signInInLogin");
        By userNameBy = methods.getBy("userNameInLogin");
        String userName = Driver.ConfigurationProp.getString("VALID_USERNAME");
        By passwordBy = methods.getBy("passwordInLogin");
        String password = Driver.ConfigurationProp.getString("VALID_PASSWORD");
        commonProcess.checkElementVisible(userNameBy);
        commonProcess.checkElementVisible(passwordBy);
        commonProcess.checkElementVisible(signInButtonBy);
        commonProcess.checkElementClickable(signInButtonBy);
        methods.clearElementWithBackSpace(userNameBy,"a");
        commonProcess.checkElementVisible(userNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(userNameBy, userName);
        commonProcess.checkElementClickable(passwordBy);
        methods.clearElementWithBackSpace(passwordBy,"a");
        commonProcess.checkElementClickable(passwordBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(passwordBy, password);
        commonProcess.clickButton(signInButtonBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Dashboard_Page_SHARED() {

        if(Boolean.parseBoolean(getAttribute("isEverythingDone").toString())) {
            //https://testinium.io/home?code=
            assertTrue(methods.doesUrl("https://testinium.io/home",75,"startWith"));
            commonProcess.checkElementVisible(methods.getBy("logoArea"));
            commonProcess.checkElementVisible(methods.getBy("logoTitle"));
            assertEquals("Dashboard", methods.getText(methods.getBy("logoTitle")).trim());
            commonProcess.checkElementVisible(methods.getBy("dashboardButton"));
            commonProcess.checkElementVisible(methods.getBy("projectsTab"));
            commonProcess.checkElementVisible(methods.getBy("allScenariosTab"));
            commonProcess.checkElementVisible(methods.getBy("allSuitesTab"));
            commonProcess.checkElementVisible(methods.getBy("reportsTab"));
            commonProcess.checkElementVisible(methods.getBy("automatedTestTab"));
            commonProcess.checkElementVisible(methods.getBy("dashboardCreateButton"));
            commonProcess.checkElementVisible(methods.getBy("testiniumTestPlanInDashboard"));
            commonProcess.checkElementVisible(methods.getBy("parallelTestsInDashboard"));
            commonProcess.checkElementVisible(methods.getBy("queuedTestsInDashboard"));
           // commonProcess.checkElementVisible(methods.getBy("activeTestsInDashboard"));
        //    commonProcess.checkElementVisible(methods.getBy("latestTestRunsTableInDashboard"));
        }
    }

    public void e_Input_Unregistered_Email_Forgot_Password() {

        methods.sendKeys(methods.getBy("emailInForgotPassword"),"unregistered.email@testinium.com");
        By sendEmailButtonBy = methods.getBy("sendPasswordResetEmailInForgotPassword");
        commonProcess.clickButton(sendEmailButtonBy);
    }

    public void e_Click_SignIn() {

        By signInForgotPasswordBy = methods.getBy("signInInForgotPassword");
        commonProcess.clickButton(signInForgotPasswordBy);
    }

    public void v_Verify_Sent_Registered_Email_Information_Message() {

        commonProcess.checkElementVisible(methods.getBy("sendEmailMessageInForgotPassword"));
        assertTrue(methods.doesUrl("https://account.testinium.com/uaa/send-reminder-mail",75,"equal"));
    }

    public void e_Input_Registered_Email_Forgot_Password() {

        methods.sendKeys(methods.getBy("emailInForgotPassword"), Driver.ConfigurationProp.getString("VALID_USERNAME"));
        By sendEmailButtonBy = methods.getBy("sendPasswordResetEmailInForgotPassword");
        commonProcess.clickButton(sendEmailButtonBy);
    }

    public void e_Click_Continue_With_Github() {

        /**
        By githubButtonBy = methods.getBy("githubButtonInLogin");
        commonProcess.checkElementVisible(githubButtonBy);
        commonProcess.checkElementClickable(githubButtonBy);
        methods.clickElement(githubButtonBy);
         */
        e_Valid_Login();
    }

    public void v_Start() {

        /**
        // Forgot password kapalı
        setAttribute("isForgotPassword",false);
        setAttribute("isForgotPasswordRegistered",false);
        setAttribute("isForgotPasswordUnregistered",false);
         */
    }

    public void e_Invalid_Login_Empty() {

        methods.clearElementWithBackSpace(methods.getBy("userNameInLogin"),"a");
        methods.clearElementWithBackSpace(methods.getBy("passwordInLogin"),"a");
        methodsUtil.waitByMilliSeconds(500);
        commonProcess.clickButton(methods.getBy("signInInLogin"));
    }

}
