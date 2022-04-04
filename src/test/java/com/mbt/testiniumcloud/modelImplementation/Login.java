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

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, start = "v_Start")
public class Login extends ExecutionContext implements org.graphwalker.Login {

    private static final Logger logger = LogManager.getLogger(Login.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public Login() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
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
        Assert.assertTrue("", methods.doesUrl("https://www.linkedin.com/uas/login",75,"startWith");
        methods.checkElementVisible(methods.getBy("usernameInLinkedIn"));
        methods.checkElementVisible(methods.getBy("passwordInLinkedIn"));
        methods.checkElementVisible(methods.getBy("signInInLinkedIn"));
 */
    }

    public void e_Login_Using_Google() {

        /**
        methods.sendKeys(methods.getBy("emailInGoogle")
                , DriverCreater.ConfigurationProp.getString("GOOGLE_USERNAME"));
        methods.checkElementClickable(methods.getBy("nextButtonInGoogle"));
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(methods.getBy("nextButtonInGoogle"));
        methods.checkElementVisible(methods.getBy("profileIdentifierInGoogle"));
        methods.checkElementVisible(methods.getBy("passwordInGoogle"));
        methods.checkElementVisible(methods.getBy("passwordNextInGoogle"));
        methods.sendKeys(methods.getBy("passwordInGoogle")
                , DriverCreater.ConfigurationProp.getString("GOOGLE_PASSWORD"));
        methods.checkElementClickable(methods.getBy("passwordNextInGoogle"));
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(methods.getBy("passwordNextInGoogle"));
         */

    }

    public void v_Verify__In_Login_Google_Page() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://accounts.google.com/signin/",75,"startWith");
        methods.checkElementVisible(methods.getBy("emailInGoogle"));
        methods.checkElementVisible(methods.getBy("nextButtonInGoogle"));
         */
    }

    public void v_Verify_Sent_Unregistered_Email_Error_Message() {

        methods.checkElementVisible(methods.getBy("unregisteredEmailMessageInForgotPassword"));
        Assert.assertTrue("", methods.doesUrl("https://account.testinium.com/uaa/send-reminder-mail",
                75,"equal"));
    }

    public void e_Login_Using_LinkedIn() {
/**
        methods.sendKeys(methods.getBy("usernameInLinkedIn")
                , DriverCreater.ConfigurationProp.getString("LINKEDIN_USERNAME"));
        methods.sendKeys(methods.getBy("passwordInLinkedIn")
                , DriverCreater.ConfigurationProp.getString("LINKEDIN_PASSWORD"));
        methods.checkElementClickable(methods.getBy("signInInLinkedIn"));
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(methods.getBy("signInInLinkedIn"));
 */
    }

    public void e_Logout() {

        By userDropDownBy = methods.getBy("btnUserDropdown");
        methodsUtil.waitByMilliSeconds(500);
        methods.scrollElementCenterJs(userDropDownBy,"3");
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementVisible(userDropDownBy);
        methods.checkElementClickable(userDropDownBy);
        methods.clickElement(userDropDownBy);
        By logoutBy = methods.getBy("btnLogOut");
        methods.checkElementVisible(logoutBy);
        methods.checkElementClickable(logoutBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(logoutBy);
    }

    public void v_Verify_In_Login_Page() {

        Assert.assertTrue("", methods.doesUrl("https://account.testinium.com/uaa/login",
                75,"startWith"));
        methods.checkElementVisible(methods.getBy("userNameInLogin"));
        methods.checkElementVisible(methods.getBy("passwordInLogin"));
        methods.checkElementVisible(methods.getBy("signInInLogin"));
        methods.checkElementClickable(methods.getBy("signInInLogin"));
        methods.checkElementVisible(methods.getBy("forgotPasswordInLogin"));
        methods.checkElementVisible(methods.getBy("linkedInButtonInLogin"));
        methods.checkElementVisible(methods.getBy("googleButtonInLogin"));
        methods.checkElementVisible(methods.getBy("githubButtonInLogin"));
        methods.checkElementVisible(methods.getBy("signUpButtonInLogin"));
    }

    public void e_Click_Signin() {

        By signInForgotPasswordBy = methods.getBy("signInInForgotPassword");
        methods.checkElementVisible(signInForgotPasswordBy);
        methods.checkElementClickable(signInForgotPasswordBy);
        methods.clickElement(signInForgotPasswordBy);
    }

    public void e_Invalid_Login_Invalid_Email() {

        By userNameBy = methods.getBy("userNameInLogin");
        methods.clearElement(userNameBy);
        methods.sendKeys(userNameBy, "deneme.invalidemail.com");
        By passwordBy = methods.getBy("passwordInLogin");
        methods.clearElement(passwordBy);
        methods.sendKeys(passwordBy,"12345678");
        methods.clickElement(methods.getBy("signInInLogin"));
    }

    public void v_Verify_In_Forgot_Password_Page() {

        Assert.assertTrue("", methods.doesUrl("https://account.testinium.com/uaa/forgot-password",
                75,"equal"));
        methods.checkElementVisible(methods.getBy("forgotPasswordTitle"));
        Assert.assertEquals("", "FORGOT PASSWORD ?"
                , methods.getText(methods.getBy("forgotPasswordTitle")).trim());
        methods.checkElementVisible(methods.getBy("emailInForgotPassword"));
        methods.checkElementVisible(methods.getBy("sendPasswordResetEmailInForgotPassword"));
        methods.checkElementVisible(methods.getBy("signInInForgotPassword"));
    }

    public void e_Click_Forgot_Password_Button() {

        By forgotPasswordButtonBy = methods.getBy("forgotPasswordInLogin");
        methods.checkElementVisible(forgotPasswordButtonBy);
        methods.checkElementClickable(forgotPasswordButtonBy, 30);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(forgotPasswordButtonBy);
    }

    public void e_Click_Continue_With_Google() {
/**
        By googleButtonInLoginBy = methods.getBy("googleButtonInLogin");
        methods.checkElementClickable(googleButtonInLoginBy);
        methods.clickElement(googleButtonInLoginBy);

        ////div[@role="button" and .//span[text()="Onayla"]]
 */
        e_Valid_Login();
    }

    public void v_Verify_Invalid_Password() {

        Assert.assertTrue("",methods.isElementVisible(methods
                .getBy("incorrectEmailorPasswordInLogin"),30));
    }

    public void v_Verify_In_Login_Github_Page() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://github.com/login",75,"startWith");
        methods.checkElementVisible(methods.getBy("usernameInGithub"));
        methods.checkElementVisible(methods.getBy("passwordInGithub"));
        methods.checkElementVisible(methods.getBy("signInInGithub"));
         */
    }

    public void e_Go_To_Login_Page() {

        methods.navigateTo("https://account.testinium.com/uaa/login");
    }

    public void e_Click_Continue_With_LinkedIn() {

        e_Valid_Login();
        /**

        By ContinueWithLinkedInButton = methods.getBy("linkedInButtonInLogin");
        methods.checkElementVisible(ContinueWithLinkedInButton);
        methods.isElementClickable(ContinueWithLinkedInButton, 30);
        methods.clickElement(ContinueWithLinkedInButton);
         */
    }

    public void v_Verify_Invalid_Login_Empty() {

        methods.checkElementVisible(methods.getBy("usernameErrorInLogin"));
        methods.checkElementVisible(methods.getBy("passwordErrorInLogin"));
        methodsUtil.waitByMilliSeconds(100);
        Assert.assertEquals("","This field is required."
                , methods.getText(methods.getBy("usernameErrorInLogin")).trim());
        Assert.assertEquals("","This field is required."
                , methods.getText(methods.getBy("passwordErrorInLogin")).trim());
    }

    public void e_Invalid_Login_Invalid_Password() {

        By userNameBy = methods.getBy("userNameInLogin");
        methods.clearElement(userNameBy);
        methods.sendKeys(userNameBy, Driver.ConfigurationProp.getString("VALID_USERNAME"));
        By passwordBy = methods.getBy("passwordInLogin");
        methods.clearElement(passwordBy);
        methods.sendKeys(passwordBy,"invalidEmail");
        methods.clickElement(methods.getBy("signInInLogin"));
    }

    public void e_Login_Using_Github() {

        /**
        methods.sendKeys(methods.getBy("usernameInGithub")
                , DriverCreater.ConfigurationProp.getString("GITHUB_USERNAME"));
        methods.sendKeys(methods.getBy("passwordInGithub")
                , DriverCreater.ConfigurationProp.getString("GITHUB_PASSWORD"));
        methods.checkElementClickable(methods.getBy("signInInGithub"));
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(methods.getBy("signInInGithub"));

         */
        // https://github.com/sessions/verified-device
    }

    public void e_click_SignIn() {

        By signInForgotPasswordBy = methods.getBy("signInInForgotPassword");
        methods.checkElementVisible(signInForgotPasswordBy);
        methods.checkElementClickable(signInForgotPasswordBy);
        methods.clickElement(signInForgotPasswordBy);
    }

    public void v_Verify_Invalid_Email() {

        methods.checkElementVisible(methods.getBy("usernameErrorInLogin"));
        Assert.assertTrue("", methods.isElementInVisible(methods
                .getBy("passwordErrorInLogin"), 30));
        methodsUtil.waitByMilliSeconds(100);
        Assert.assertEquals("","Please enter a valid email address."
                , methods.getText(methods.getBy("usernameErrorInLogin")).trim());
    }

    public void e_Valid_Login() {

        By signInButtonBy = methods.getBy("signInInLogin");
        By userNameBy = methods.getBy("userNameInLogin");
        String userName = Driver.ConfigurationProp.getString("VALID_USERNAME");
        By passwordBy = methods.getBy("passwordInLogin");
        String password = Driver.ConfigurationProp.getString("VALID_PASSWORD");
        methods.checkElementVisible(userNameBy);
        methods.checkElementVisible(passwordBy);
        methods.checkElementVisible(signInButtonBy);
        methods.checkElementClickable(signInButtonBy);
        methods.clearElementWithBackSpace(userNameBy,"a");
        methods.checkElementVisible(userNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(userNameBy, userName);
        methods.checkElementClickable(passwordBy);
        methods.clearElementWithBackSpace(passwordBy,"a");
        methods.checkElementClickable(passwordBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.sendKeys(passwordBy, password);
        methods.checkElementVisible(signInButtonBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementClickable(signInButtonBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.clickElement(signInButtonBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_In_Dashboard_Page_SHARED() {

        if(Boolean.parseBoolean(getAttribute("isEverythingDone").toString())) {
            //https://testinium.io/home?code=
            Assert.assertTrue(""
                    , methods.doesUrl("https://testinium.io/home", 75, "startWith"));
            methods.checkElementVisible(methods.getBy("logoArea"), 60);
            methods.checkElementVisible(methods.getBy("logoTitle"), 60);
            Assert.assertEquals("", "Dashboard", methods.getText(methods.getBy("logoTitle")).trim());
            methods.checkElementVisible(methods.getBy("dashboardButton"));
            methods.checkElementVisible(methods.getBy("projectsTab"));
            methods.checkElementVisible(methods.getBy("allScenariosTab"));
            methods.checkElementVisible(methods.getBy("allSuitesTab"));
            methods.checkElementVisible(methods.getBy("reportsTab"));
            methods.checkElementVisible(methods.getBy("automatedTestTab"));
            methods.checkElementVisible(methods.getBy("dashboardCreateButton"));
            methods.checkElementVisible(methods.getBy("testiniumTestPlanInDashboard"));
            methods.checkElementVisible(methods.getBy("parallelTestsInDashboard"));
            methods.checkElementVisible(methods.getBy("queuedTestsInDashboard"));
           // methods.checkElementVisible(methods.getBy("activeTestsInDashboard"));
        //    methods.checkElementVisible(methods.getBy("latestTestRunsTableInDashboard"));
        }
    }

    public void e_Input_Unregistered_Email_Forgot_Password() {

        methods.sendKeys(methods.getBy("emailInForgotPassword"),"unregistered.email@testinium.com");
        By sendEmailButtonBy = methods.getBy("sendPasswordResetEmailInForgotPassword");
        methods.checkElementVisible(sendEmailButtonBy);
        methods.checkElementClickable(sendEmailButtonBy);
        methods.clickElement(sendEmailButtonBy);
    }

    public void e_Click_SignIn() {

        By signInForgotPasswordBy = methods.getBy("signInInForgotPassword");
        methods.checkElementVisible(signInForgotPasswordBy);
        methods.checkElementClickable(signInForgotPasswordBy);
        methods.clickElement(signInForgotPasswordBy);
    }

    public void v_Verify_Sent_Registered_Email_Information_Message() {

        methods.checkElementVisible(methods.getBy("sendEmailMessageInForgotPassword"));
        Assert.assertTrue("", methods.doesUrl("https://account.testinium.com/uaa/send-reminder-mail"
                ,75,"equal"));
    }

    public void e_Input_Registered_Email_Forgot_Password() {

        methods.sendKeys(methods.getBy("emailInForgotPassword"), Driver.ConfigurationProp.getString("VALID_USERNAME"));
        By sendEmailButtonBy = methods.getBy("sendPasswordResetEmailInForgotPassword");
        methods.checkElementVisible(sendEmailButtonBy);
        methods.checkElementClickable(sendEmailButtonBy);
        methods.clickElement(sendEmailButtonBy);
    }

    public void e_Click_Continue_With_Github() {

        /**
        By githubButtonBy = methods.getBy("githubButtonInLogin");
        methods.checkElementVisible(githubButtonBy);
        methods.checkElementClickable(githubButtonBy);
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
        methods.clickElement(methods.getBy("signInInLogin"));
    }

}
