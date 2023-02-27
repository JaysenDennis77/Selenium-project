package com.cydeo.tests.day12_review;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilites.BrowserUtlis;
import com.cydeo.utilites.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T2_T3_Explicit_Wait_Practices {
DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    @BeforeMethod
    public void StartUp(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

    }

    @Test
    public void T2_RemoveCheckBox(){

        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        //3- Click to “Remove” button
        dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage.RemoveButton.click();

        //4- Wait until “loading bar disappears”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        //Using custom method to wait for invisibility
        //BrowserUtlis.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        //Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());

        //assertFalse method is expecting a "false" boolean value to PASS the test.
        try {
            Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());
        }catch (NoSuchElementException n ){
            System.out.println("NoSuchElementException is thrown, no checkbox on page ");
            Assert.assertTrue(true);
        }
        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.itsGoneMessage.isDisplayed());

        //NOTE: FOLLOW POM
    }

    @Test
    public void T3_ExplicitWait(){

    //TC #3: Explicit wait practice

        //3- Click to “Enable” button
        //4- Wait until “loading bar disappears”
        //5- Verify:
        //a. Input box is enabled.
        //b. “It’s enabled!” message is displayed.
        //NOTE: FOLLOW POM

    }


    @Test
    public void T3_EnableInputBox(){
//TC #3: Explicit wait practice
//3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();

//4- Wait until “loading bar disappears”
        BrowserUtlis.waitForInvisibilityOf(dynamicControlsPage.loadingBar);
//5- Verify:
//a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());
//b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.itsGoneMessage.isDisplayed());

//NOTE: FOLLOW POM



    }

    @AfterMethod
    public void TearDown(){
Driver.closeDriver();
    }

}
