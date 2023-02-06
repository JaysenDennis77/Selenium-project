package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //Setup browser driver
        WebDriverManager.chromedriver().setup();

        // Create instance of Chrome browser
        WebDriver driver = new ChromeDriver();

        // Makes the window full screen (pretty obvious from the name)
        driver.manage().window().maximize();

        // Go to tesla.com
        driver.get("https://www.tesla.com");

        // Current URL for tesla
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


        //Get title of the page
       // System.out.println("driver.getTitle();" + driver.getTitle());
String currentTitle = driver.getTitle();
        System.out.println("CurrentTitle = " + currentTitle);

        //Use navigate back() to go back
        driver.navigate().back();

        // Stop execution for 3 seconds
        Thread.sleep(1000);

        //User navigate forward() to go forward
        driver.navigate().forward();

        // Stop execution for 3 seconds
        Thread.sleep(1000);

        //User refreshes the page using navigate.refresh();
        driver.navigate().refresh();

        // Stop execution for 3 seconds
        Thread.sleep(1000);

        // Navigate to google.com using navigate().to()
        driver.navigate().to("https://www.google.com");

        //use .getCurrentUrl method to print out current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //Get title of the page
       //System.out.println("driver.getTitle();" + driver.getTitle());
         currentTitle = driver.getTitle();
        System.out.println("CurrentTitle = " + currentTitle);

// closes only the focused window
driver.close();

// closes all opened browsers
driver.quit();

    }

}
