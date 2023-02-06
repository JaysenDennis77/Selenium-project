package com.cydeo.tests.day06_Alert_iframs_windows;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_Iframe {
WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/iframe");
    }

@Test
    public void iframe_test(){


    //TC #4: Iframe practice
    //we have to switch to iframe to be able to locate the web elements in there

    //option#1- switch "id" attribute value
    driver.switchTo().frame("mce_0_ifr");
    WebElement paragraphText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

    //option#2 switch using index number
    //driver.switchTo().frame(0);

    //option#3 switch using WebElement
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

    //4. Assert: “Your content goes here.” Text is displayed.
    Assert.assertTrue(paragraphText.isDisplayed());

    //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
    driver.switchTo().parentFrame();
    //driver.switchTo().defaultContent();       same idea different method
    WebElement h3 = driver.findElement(By.tagName("h3"));
    Assert.assertTrue(h3.isDisplayed());

}


@AfterMethod
    public void teardown(){
        driver.quit();
}

}
