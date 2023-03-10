package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilites.BrowserUtlis;
import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_WindowsHandling {
WebDriver driver;


    @BeforeMethod
    public void setupmethod(){
        //1. Create new test and make set ups
        //2. Go to : https://www.amazon.com

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
    }


    @Test
    public void window_handling_test(){

//TC #1: Window Handle practice
//3. Copy and paste the lines from below into your class
// These lines will simply open new tabs using something called JavascriptExecutor
//and get those pages. We will learn JavascriptExecutor later as well.
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

//4. Create a logic to switch to the tab where Etsy.com is open

        //Return and store all window handles in a Set
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if(driver.getCurrentUrl().contains("etsy")){
                break;
            }

        }

//5. Assert: Title contains “Etsy”
String actualTitle = driver.getTitle();
String expectedTitle = "Etsy";

Assert.assertTrue(actualTitle.contains(expectedTitle));

//option[@value='3']/following-sibling::option[2]
// option[@value='3']/preceding-sibling::option[3]

    }

    @AfterMethod
    public void teardown(){
driver.quit();
    }

    @Test
    public void window_handling_test2() {

//TC #1: Window Handle practice
//3. Copy and paste the lines from below into your class
// These lines will simply open new tabs using something called JavascriptExecutor
//and get those pages. We will learn JavascriptExecutor later as well.
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

//4. Create a logic to switch to the tab where Etsy.com is open
        BrowserUtlis.switchWindowAndVerify(driver,"etsy","Etsy");
}}
