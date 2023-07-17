package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    //TC #1: Window Handle practice

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void window_handling_test() {
        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy and paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains("etsy")) {
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        Assert.assertEquals("Etsy", driver.getTitle());
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}
