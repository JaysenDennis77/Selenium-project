package com.cydeo.tests.day03_cssSelector_Xpath;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC3NextBaseCRM_locators {

    public static void main(String[] args) {
        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get(" https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        String excpectedLogin = "Log In";
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        String actualLoginText = loginButton.getAttribute("value"); //--> log in


// locating using class value

// WebElement loginButton = driver.findElement(By.className("login-btn"));

// tagName[attribute='value']

        // locating loginButton using cssSelector using type attributes value

if(actualLoginText.equals(excpectedLogin)){
    System.out.println("Passed");
}else {


    System.out.println("FAILED");
}





    }

}
