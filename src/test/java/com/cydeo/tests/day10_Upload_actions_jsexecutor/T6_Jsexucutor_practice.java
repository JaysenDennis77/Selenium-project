package com.cydeo.tests.day10_Upload_actions_jsexecutor;

import com.cydeo.utilites.BrowserUtlis;
import com.cydeo.utilites.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import javax.swing.*;

public class T6_Jsexucutor_practice {

    @Test
    public void InfintescrollTest(){

        //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll" );

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtlis.sleep(2);
        //window.scrollBy(x,y)

        //3- Use below JavaScript method and scroll
        //a. 750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {

            js.executeScript("window.scrollBy(0,750)");

        }

        //b. 750 pixels up 10 times
        //JavaScript method to use : window.scrollBy(0,0)
        for (int i = 0; i < 10; i++) {

            js.executeScript("window.scrollBy(0,-750)");

        }
    }

}
