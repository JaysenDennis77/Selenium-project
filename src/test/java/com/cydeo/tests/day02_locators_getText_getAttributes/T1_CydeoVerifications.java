package com.cydeo.tests.day02_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    //TC #1 Cydeo practice tool verifications

    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //3. Verify URL contains
        // Expected: cydeo
        String excpectedInURL = "cydeo";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(excpectedInURL)){
            System.out.println("Pass");
        }else {
            System.err.println("Failed");
        }

        //4. Verify title:
        //Expected: Practice
        String excpectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(excpectedTitle)){
            System.out.println("PASSED");
        }else {
            System.err.println("FAILED");
        }
        // close the browser
        driver.close();
    }

}




