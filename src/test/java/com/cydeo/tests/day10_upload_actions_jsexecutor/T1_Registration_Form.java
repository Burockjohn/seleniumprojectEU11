package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test
    public void registration_form_test() {
        //1. Open browser
        //2. Go to website:https://practice.cydeo.com/registration_form
        //Driver.getDriver() --> driver
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        //Create JavaFaker object
        Faker faker = new Faker();

        //3. Enter first name
        //WebElement inputFirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        String fakerFirstName = faker.name().firstName();
        inputFirstName.sendKeys(fakerFirstName);

        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

        //5. Enter username
        //inputUsername.sendKeys(faker.name().username().replaceAll(".", ""));
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));

        String user = faker.bothify("helpdesk###");
        inputUsername.sendKeys(user);

        //6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user + "@email.com");

        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.numerify("########"));
        //System.out.println("faker.internet().password() = " + faker.internet().password());

        //8. Enter phone number
        WebElement inputPhone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhone.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();

        //10.Enter date of birth
        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        //faker.number().numberBetween(2004, 1920)
        inputBirthday.sendKeys("03/08/2000");

        //11.Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1, 9));

        //12.Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("(//select)[2]")));
        jobTitleDropdown.selectByVisibleText("SDET");

        //13.Select programming language from checkboxes
        WebElement javaCheckBox = Driver.getDriver().findElement(By.cssSelector("input#inlineCheckbox2"));
        javaCheckBox.click();

        //14.Click to sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.cssSelector("button#wooden_spoon"));
        signUpButton.click();

        //15.Verify success message “You’ve successfully completed registration.” is
        //displayed.
        String expected = "You've successfully completed registration!";
        String actual = Driver.getDriver().findElement(By.tagName("p")).getText();

        //System.out.println(actual);
        //System.out.println("deneme");

        Assert.assertEquals(expected,actual);

        Driver.closeDriver();
    }
}
