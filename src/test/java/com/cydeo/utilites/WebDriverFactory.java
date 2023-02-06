package com.cydeo.utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {
        if(browserType.equalsIgnoreCase("chrome") )
        { WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("fireFox") ) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.err.println("Given string does not represent any browser");
            System.err.println("Either that browser does not exist or not currently supported");
            System.err.println("System = null");
            return null;
        }


        

    }








}
