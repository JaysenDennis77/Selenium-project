package com.cydeo.tests.Day05_testNG_intro_dropdowns;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1_StaleElementRefrence {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
     WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));

     addElement.click();
        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());


        //5. Click to “Delete” button.
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
      // Use try/catch to handle and verify

        try {
            System.out.println("deleteButton.isDisplayed() expecting false = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReference happened due to element being deleted from page");
            System.out.println("deleteButton.isDisplayed() = expecting false");
        }


    }

}
