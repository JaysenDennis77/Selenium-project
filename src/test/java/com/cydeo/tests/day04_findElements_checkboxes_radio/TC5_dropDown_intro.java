package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC5_dropDown_intro {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
       driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");


    }

@AfterMethod
public void TearDownMethod(){
        driver.quit();
}


    @Test
    public void simpleDropdownTest(){

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        //locating dropdown as a web element
        WebElement simpleDropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        // creating select class object and passing the dropdown web element into the constructor
        Select select = new Select(simpleDropdown);

        //Expected: "Please select an option"
        String expectedDefaultValue = "Please select an option";

        //Actual
        String actualDefaultValue = select.getFirstSelectedOption().getText();

        // Do our assertion
        Assert.assertEquals(actualDefaultValue,expectedDefaultValue);

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        //Create Select object, and also locate the dropdown itself in my constructor
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));


        expectedDefaultValue = "Select a State";

        actualDefaultValue = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedDefaultValue,actualDefaultValue);

    }




}
