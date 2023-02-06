package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_pratices {

    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
       WebElement homelink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homnelink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homelink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));

        //b. “Forgot password” header                           //tagName[.='text']  same as //tagName[text()='text']

       WebElement passwordHeader_ex1 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        //WebElement passwordHeader_ex2 = driver.findElement(By.cssSelector("div[class='example'] > h2"));
        WebElement passwordHeader_ex2 = driver.findElement(By.cssSelector("div.example>h2"));


        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.xpath("//label[.='E-mail']"));
        WebElement emailText2 = driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box               //tagName[contains(@attribute, 'value')]
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement inputBox2 = driver.findElement(By.xpath("//input[contains(@pattern,a-z)]"));

        //e. “Retrieve password” button
        WebElement retrivePassword = driver.findElement(By.xpath("//button[@id='form_submit']"));

        //f. “Powered by Cydeo text
        WebElement poweredByCydeo = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("homelink_ex1.isDisplayed() = " + homelink_ex1.isDisplayed());
        System.out.println("passwordHeader_ex1.isDisplayed() = " + passwordHeader_ex1.isDisplayed());
        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("poweredByCydeo.isDisplayed() = " + poweredByCydeo.isDisplayed());
        System.out.println("retrivePassword.isDisplayed() = " + retrivePassword.isDisplayed());

        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible
        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible



    }

}
