package com.cydeo.tests.day06_Alert_iframs_windows;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdowns_T6_T7_T8 {
WebDriver driver;
    @BeforeMethod
    public void setupclass(){
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }
@AfterMethod
public void TearDpown(){
        driver.quit();
}

    @Test
    public void dropdowns_task6(){


        //3. Select “December 1st, 1933” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
        yearDropdown.selectByVisibleText("1933");
        //Select month using : value attribute
        monthDropdown.selectByValue("11");
        //Select day using : index number
        dayDropdown.selectByIndex(0);



        // create expected values
        String expectedYear ="1933";
        String expectedMonth = "December";
        String expectedDay = "1";


        // getting actual values from browser

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //create assertions
        Assert.assertEquals(actualDay,expectedDay);
        Assert.assertTrue(actualMonth.equals(expectedMonth));
        Assert.assertEquals(actualYear,expectedYear);
    }

@Test
    public void dropDown_task7(){
    //Use all Select options. (visible text, value, index)
    //1. Select Illinois
    Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
    stateDropdown.selectByVisibleText("Illinois");

    //2. Select Virginia
    stateDropdown.selectByValue("VA");

    //3. Select California
    stateDropdown.selectByIndex(5);

    //4. Verify final selected option is California.
    String expectedSelection = "California";
    String actualSelection = stateDropdown.getFirstSelectedOption().getText();
    Assert.assertEquals(expectedSelection,actualSelection);


}

@Test
    public void dropdown_task8(){
    //TC #8: Selecting value from non-select dropdown
    //3. Click to non-select dropdown
    //locate the non selct dropdown
    WebElement websiteDropdown = driver.findElement(By.linkText("Dropdown link"));
    websiteDropdown.click();

    //4. Select Facebook from dropdown
    WebElement faceBook = driver.findElement(By.linkText("Facebook"));
faceBook.click();

    //5. Verify title is “Facebook - log in or sign up”

    String expectedTitle = "Facebook - log in or sign up";
    String actualTitle = driver.getTitle();

    Assert.assertEquals(expectedTitle,actualTitle);


}





}
