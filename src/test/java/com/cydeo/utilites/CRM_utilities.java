package com.cydeo.utilites;
/*
This class will store the method related to CRM projects
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_utilities {
/*
This method will login using below credentials
@Username: helpdesk1@cydeo.com
@Password: UserUser
 */
    public static void login_crm(WebDriver driver){

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("helpdesk1@cydeo.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();

    }
    public static void login_crm(WebDriver driver,String username,String password){

        WebElement inputUsername = driver.findElement(By.xpath("//input[@type='text']"));
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();

    }
}
