package com.cydeo.tests.day03_cssSelector_Xpath;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC2_getText_getAttribute {

    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedResult = "Remember me on this computer";
       String actualResult = driver.findElement(By.className("login-item-checkbox-label")).getText();

        if (actualResult.equals(expectedResult)){
            System.out.println("NICE ONE");
        }else {
            System.err.println("FIX YOUR CODE!!!!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        String expectedResult2 = "Forgot your password?";
        WebElement forgotpasswordlink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPassword = forgotpasswordlink.getText();

        if (actualResult.equals(expectedResult)){
            System.out.println("GOOD ONE");
        }else {
            System.err.println("FAILED");
        }



        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedInHref = "forgot_password=yes";
        String acutalHrefValue = forgotpasswordlink.getAttribute("href");

        if (acutalHrefValue.contains(expectedInHref)){
            System.out.println("GOOD");
        }else {
            System.err.println("BAD");
        }

    }

}
