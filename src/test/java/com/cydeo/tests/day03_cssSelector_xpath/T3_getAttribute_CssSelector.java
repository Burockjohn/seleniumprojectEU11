package com.cydeo.tests.day03_cssSelector_xpath;

/*
TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T3_getAttribute_CssSelector {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        String actualValue = driver.findElement(By.className("login-btn")).getAttribute("value");
        String expectedValue = "Log In";

        //LOCATING THE SAME WEB ELEMENT USING DIFFERENT ATTRIBUTE VALUES.
        //	                   tagName[attribute='value']
        //	                   input[class='login-btn']

        // LOCATED USING CLASS ATTRIBUTE
        //WebElement signInButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

        // LOCATED USING TYPE ATTRIBUTE
        //WebElement signInButton = driver.findElement(By.cssSelector("input[type='submit']"));

        //System.out.println("actualValue = " + actualValue);

        if (actualValue.equals(expectedValue)) {
            System.out.println("Verification of \"Log in\" button is PASSED");
        } else {
            System.out.println("Verification of \"Log in\" button is FAILED");
        }

    }
}
