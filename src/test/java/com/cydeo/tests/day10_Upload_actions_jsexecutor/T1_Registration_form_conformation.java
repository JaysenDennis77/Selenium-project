package com.cydeo.tests.day10_Upload_actions_jsexecutor;

import com.cydeo.tests.Day09_review_javafaker.Singleton;
import com.cydeo.utilites.BrowserUtlis;
import com.cydeo.utilites.ConfigurationReader;
import com.cydeo.utilites.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T1_Registration_form_conformation {

    @BeforeMethod
    public void setup(){
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

@Test
    public void registration_form() {
    //TC#1: Registration form confirmation

    //3. Enter first name
WebElement inputfirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
inputfirstName.sendKeys("Banana");

    //4. Enter last name
    WebElement inputlastname = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
    inputlastname.sendKeys("Rama");

    //5. Enter username
    WebElement inputusername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
    inputusername.sendKeys("BananaRama");

    //6. Enter email address
    WebElement inputemail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
    inputemail.sendKeys("supermanlover69@cydeo.com");


    //7. Enter password
    WebElement inputpassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
    inputpassword.sendKeys("supersecretpassword");

    //8. Enter phone number
    WebElement inputphonenumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
inputphonenumber.sendKeys("883-838-8737");

    //9. Select a gender from radio buttons
    WebElement radiobutton = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
    radiobutton.click();


    //10.Enter date of birth
    WebElement DOB = Driver.getDriver().findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
    DOB.sendKeys("05/16/2003");

    //11.Select Department/Office
    Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
    select.selectByVisibleText("MPDC");

    //12.Select Job Title
    Select jobTitle = new Select(Driver.getDriver().findElement(By.name("job_title")));
    jobTitle.selectByVisibleText("SDET");

    //13.Select programming language from checkboxes
    WebElement javaCheckBox = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
    javaCheckBox.click();

    //14.Click to sign up button
    WebElement signupbutton = Driver.getDriver().findElement(By.id("wooden_spoon"));
    signupbutton.click();

    //15.Verify success message “You’ve successfully completed registration.” is
  WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
    Assert.assertTrue(successMessage.isDisplayed());
    //displayed.

}

@AfterMethod
    public void Teardown(){
        BrowserUtlis.sleep(10);
       Driver.closeDriver();

}

    }
