package com.cydeo.tests.Day05_testNG_intro_dropdowns;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC2_RadioButtonHandling {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeybutton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeybutton.click();
        //4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("hockeybutton.isSelected() = " + hockeybutton.isSelected());


    }

}
