package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilites.BrowserUtlis;
import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_loginTask {
WebDriver driver;

    @BeforeMethod
    public void setupmethod(){
        //1. Create new test and make set ups
        //2. Go to : https://www.amazon.com

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://login1.nextbasecrm.com/");
    }


    @Test
    public void LoginScenario(){
        //TC #4: Login scenario
        //3. Enter valid username
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");
        //5. Click to `Log In` button
        WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();
        //6. Verify title is as expected:
        BrowserUtlis.verifyTitleContains(driver,"Portal");

        //Expected: Portal

    }

}
