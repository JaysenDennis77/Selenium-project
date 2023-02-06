package com.cydeo.tests.day06_Alert_iframs_windows;

import com.cydeo.utilites.WebDriverFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_WindowsPractice {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void multiple_windows_test(){
     //TC #5: Window Handle practice
        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        String mainHandle = driver.getWindowHandle();

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        //6. Switch to new Window. Need to use driver.getWindowHandles() method
       for (String each: driver.getWindowHandles()){
           driver.switchTo().window(each);
           System.out.println("Current title while switching windows " + driver.getTitle());
       }


        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitleAfterClick);

        //if we have to go back to main page to continue our test case,
        // we can use mainHandle to switch.
        driver.switchTo().window(mainHandle);
        //code
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
