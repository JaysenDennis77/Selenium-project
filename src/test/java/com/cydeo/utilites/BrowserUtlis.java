package com.cydeo.utilites;
/*
This class will be storing only the utility methods that can be used across the project
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class BrowserUtlis {

    /*
    This method will accept int in seconds and sleep for given seconds
     */
public static void sleep(int second) {
    second *= 1000;
    try {
        Thread.sleep(second);
    }catch (InterruptedException e){

    }


}
public static void switchWindowAndVerify(WebDriver driver, String expectedUrl,String expectedTitle){

    Set<String> allWindowHandles = driver.getWindowHandles();

    for (String each : allWindowHandles) {

        driver.switchTo().window(each);
        System.out.println("Current URL: " + driver.getCurrentUrl());

        if(driver.getCurrentUrl().contains(expectedUrl)){
            break;
        }

    }

    String actualTitle = driver.getTitle();
    Assert.assertTrue(actualTitle.contains(expectedTitle));
}

public static void verifyTitle(WebDriver driver, String expectedTitle){
    Assert.assertEquals(driver.getTitle(),expectedTitle);

}
    public static void verifyTitleContains(WebDriver driver, String expectedTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

    }

    public static void waitForInvisibilityOf(WebElement target){
        //4- Wait until “loading bar disappears”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));


    }

    public static void waitForTitleOf(WebElement title){
        //4- Wait until “loading bar disappears”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(title));


    }

}
