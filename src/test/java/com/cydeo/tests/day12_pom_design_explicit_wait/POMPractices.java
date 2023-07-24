package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    LoginPage loginPage;

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://library1.cydeo.com/");
        loginPage = new LoginPage();
    }


    @Test
    public void required_field_error_message_test(){
        //TC #1: Required field error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com/
        //3- Do not enter any information
        //4- Click to “Sign in” button

        loginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(loginPage.fieldRequiredErrorMessage.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void invalid_email_format_error_message_test(){
        //TC #2: Invalid email format error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com/
        //3- Enter invalid email format

        loginPage.inputUsername.sendKeys("somethingwrong");

        loginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(loginPage.enterValidEmailErrorMessage.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void library_negative_login_test()  {
        //TC #3: Library negative login
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter incorrect username or incorrect password

        loginPage.inputUsername.sendKeys("wrong@username.com");
        loginPage.inputPassword.sendKeys("wrongpassword");

        loginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        BrowserUtils.sleep(2);
        Assert.assertTrue(loginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
        Driver.closeDriver();

    }

}
