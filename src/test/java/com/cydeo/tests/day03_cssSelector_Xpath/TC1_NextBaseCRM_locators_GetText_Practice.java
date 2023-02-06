package com.cydeo.tests.day03_cssSelector_Xpath;

import com.cydeo.utilites.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_NextBaseCRM_locators_GetText_Practice {

    public static void main(String[] args) {

        //1- Open a chrome browser
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("firefox");

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Enter incorrect username: “incorrect”
        WebElement loginBar = driver.findElement(By.name("USER_LOGIN"));
        loginBar.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement passwordBar = driver.findElement(By.className("login-inp"));
        passwordBar.sendKeys("incorrect");
        //5- Click to login button.
        driver.findElement(By.className("login-btn")).click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        String expectedErrorText = "Incorrect login or password";
        String actualErrorText = driver.findElement(By.className("errortext")).getText(); // use get text so it can be stored in the string

        if (actualErrorText.equals(expectedErrorText)){
            System.out.println("PASSED");
        }else {
            System.err.println("FAILED");
        }


    }

}
