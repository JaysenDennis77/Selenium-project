package com.cydeo.tests.day10_Upload_actions_jsexecutor;

import com.cydeo.utilites.ConfigurationReader;
import com.cydeo.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T3_hoverTest {
@BeforeMethod
    public void setup(){
        //1. Go to https://practice.cydeo.com/hovers
    Driver.getDriver().get(ConfigurationReader.getProperty("hoverlink"));
}
    @Test
    public void hover_task(){

    //TC #3: Hover Test
        //Locate all the images here
        WebElement img1 =  Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 =  Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 =  Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //Locate all the user headers here
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        // To be able to hover on images, we need to create action class
        //object, and pass 'driver' in the constructor
        Actions actions = new Actions(Driver.getDriver());

        //2. Hover over to first image
        actions.moveToElement(img1).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed());

        //4. Hover over to second image
        //5. Assert:
        //a. “name: user2” is displayed
        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed());

        //6. Hover over to third image
        //7. Confirm:
        //a. “name: user3” is displayed
        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed());

        Driver.closeDriver();
    }


}
