package com.cydeo.tests.day06_Alert_iframs_windows;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_alertPractices {
WebDriver driver;

    @BeforeMethod
    public void setup(){
       driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }


    @Test
    public void information_alert_test1(){
        //3. Click to “Click for JS Alert” button
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoAlertButton.click();


        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();


        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        // the message is optional but helps clear things up
        Assert.assertTrue(resultText.isDisplayed(),"RESULT TEXT FAILED LMAOOOOOO");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result text is NOT as expected!");
    };


@Test
    public void conformationTest2(){
    //TC #2: Confirmation alert practice
    //3. Click to “Click for JS Confirm” button
    WebElement confirmAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
    confirmAlert.click();
    //4. Click to OK button from the alert
    Alert alert = driver.switchTo().alert();
    alert.accept();

    //5. Verify “You clicked: Ok” text is displayed.
    WebElement resultText = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
    Assert.assertTrue(resultText.isDisplayed(),"TRY AGAIN NERD");

}




}
