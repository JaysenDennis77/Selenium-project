package com.cydeo.tests.day02_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkText_Practice {
    //TC #2: Back and forth navigation
    public static void main(String[] args) throws InterruptedException {

        // 1- Open a chrome browse
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        // 3- Click to A/B Testing from top of the list.
        //driver.findElement(By.linkText("A/B Testing")).click();

        // the one above dissapeares after one use the one below can be used more than once

        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();

        //  4- Verify title is:
        //  Expected: No A/B Test
        String excpectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(excpectedTitle)){
            System.out.println("PASSED FELLA");
        }else{
            System.err.println("FAILED FELLA");
        }

        //   5- Go back to home page by using the .back();
        driver.navigate().back();

        //  6- Verify title equals:
        //  Expected: Practice
        excpectedTitle = "Practice";
        actualTitle = driver.getTitle();

        if(actualTitle.equals(excpectedTitle)){
            System.out.println("PASSED FELLA");
        }else{
            System.err.println("FAILED FELLA");
        }


    }

}








