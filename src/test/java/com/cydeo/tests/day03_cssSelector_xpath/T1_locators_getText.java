package com.cydeo.tests.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {

    public static void main(String[] args) {


        /*

        TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
PS: Inspect and decide which locator you should be using to locate web
elements.

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        WebElement usernameSection = driver.findElement(By.className("login-inp"));
        usernameSection.sendKeys("incorrect");

        WebElement passwordSection = driver.findElement(By.name("USER_PASSWORD"));
        passwordSection.sendKeys("incorrect" + Keys.ENTER);

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("errortext"));

        String expectedResult = "Incorrect login or password";
        String actualResult = errorMessage.getText();

        if (actualResult.equals(expectedResult)) {
            System.out.println("Error message verification PASSED!");
        } else {
            System.out.println("Error message verification FAILED!!!");
        }

    }
}
