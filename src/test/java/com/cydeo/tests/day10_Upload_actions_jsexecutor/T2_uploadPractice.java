package com.cydeo.tests.day10_Upload_actions_jsexecutor;

import com.cydeo.utilites.ConfigurationReader;
import com.cydeo.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class T2_uploadPractice {

    @BeforeMethod
    public void setup(){
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get(ConfigurationReader.getProperty("uploadlink"));
    }

    @Test
    public void uploading_Test() throws FileNotFoundException {
        //TC #2 Upload Test
        //2. Find some small file from your computer, and get the path of it.
        String path = "/Users/jaysendennis/Desktop/balls.html";

        //3. Upload the file. Use send keys method and pass the path as a string
            WebElement chooseFileButton = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
            chooseFileButton.sendKeys(path);

            WebElement uploadbutton = Driver.getDriver().findElement(By.id("file-submit"));
            uploadbutton.click();
        //4. Assert:
        WebElement fileuploadheader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileuploadheader.isDisplayed());
        //-File uploaded text is displayed on the page


    }

}
