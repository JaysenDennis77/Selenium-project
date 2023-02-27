package com.cydeo.utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    // create a private constructor to remove acess to thid objecg
    private Driver(){

    }
    // we make WebDriver private because we want to close access from outside the class
    // static because we will use it in static method
    private static WebDriver driver;


    // create a reuseable util method that returns the same driver instance once called
    // if an instance does not exist, it will first create then return the same instance
public static WebDriver getDriver(){

 if(driver == null ){
// since its from the config reader class, we can control from outside the code
     String browserType = ConfigurationReader.getProperty("browser");


     //reads from our config properties file and sets up the browser type according to whats set

switch (browserType){
    case "chrome":
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
break;
}
 }

 return driver;




}
public static void closeDriver(){

    if(driver!=null){
        driver.quit();
        driver = null;
    }
}






}
