package com.cydeo.tests.day03_cssSelector_xpath;

/*

TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from

 */

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //WebElement resetButton = driver.findElement(By.cssSelector("button[class = 'login-btn']"));
        WebElement resetButton = driver.findElement(By.cssSelector("button[value = 'Reset password']"));

        String expectedValue = "Reset password";
        String actualValue = resetButton.getText();

        if (actualValue.equals(expectedValue)) {
            System.out.println("Button text verification PASSED!");
        } else {
            System.out.println("Button text verification FAILED!");
        }

    }
}
