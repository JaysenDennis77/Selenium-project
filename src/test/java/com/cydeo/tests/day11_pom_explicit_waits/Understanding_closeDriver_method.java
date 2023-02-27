package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilites.Driver;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.testng.annotations.Test;

public class Understanding_closeDriver_method {

    @Test
    public void test1(){
        Driver.getDriver().get("https://google.com");
        //Driver.getDriver().close(); Didnt work gave session ID error
        Driver.closeDriver(); // if driver is not null, terminate session and return null so next class can call driver
    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://google.com");
       // Driver.getDriver().close();
        Driver.closeDriver();
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://google.com");
        //Driver.getDriver().close();
        Driver.closeDriver();
    }


}
