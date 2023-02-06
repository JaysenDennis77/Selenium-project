package com.cydeo.tests.day02_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP1_EtsyTitleVerfication {

    public static void main(String[] args) {

       // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

       // 2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
       // 3. Search for “wooden spoon”
        WebElement EtsySearchBox = driver.findElement(By.id("global-enhancements-search-query"));
        EtsySearchBox.sendKeys("Wooden spoon" + Keys.ENTER);

       // 4. Verify title:
       // Expected: “Wooden spoon - Etsy”
        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else {
            System.err.println("FAILED");
        }




    }

}
