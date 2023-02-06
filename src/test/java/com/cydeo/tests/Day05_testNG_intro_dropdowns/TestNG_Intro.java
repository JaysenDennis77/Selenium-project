package com.cydeo.tests.Day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setupClass(){
        System.out.println("Before class is running");
    }
    @AfterClass
    public void teardownClass(){
        System.out.println("After class is running");
    }


    @BeforeMethod
    public void setupMethod(){
        System.out.println("--> Before method is running");
    }

@AfterMethod
public void tearDownMethod(){
    System.out.println("--> After method is running");
}

    @Test (priority = 1)
    public void test1(){
        System.out.println("Test 1 is running...");
//Assert equals method will compare two of the same value. if returns true pass, false fail
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual,expected);
    }

    @Test (priority = 2)
public void test2(){
        System.out.println("Test 2 is running...");
}

@Test (priority = 3)
    public void test3(){
    System.out.println("Test 3 is running");

    String actual = "white";
    String expected = "white";

    Assert.assertEquals(actual,expected);


}





}
