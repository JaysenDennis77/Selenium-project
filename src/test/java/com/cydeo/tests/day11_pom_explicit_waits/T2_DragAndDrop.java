package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilites.BrowserUtlis;
import com.cydeo.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_DragAndDrop {

    @Test
    public void Test1(){
        //TC2 #: Drag and drop default value verification
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        //2. Verify big circle default text is as below.
        //3. Assert:
        String expectedResult = "Drag the small circle here.";
        WebElement actualResult = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        Assert.assertEquals(actualResult.getText(),expectedResult);
        //-Text in big circle changed to: “Drag the small circle here.”
    }
    @Test
    public void Test2(){
    //TC3 #: Drag and drop into the big circle
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        //2. Drag and drop the small circle to bigger circle.
        Actions action = new Actions(Driver.getDriver());

        WebElement draggable = Driver.getDriver().findElement(By.id("draggable"));
        WebElement circle = Driver.getDriver().findElement(By.id("droptarget"));

        action.dragAndDrop(draggable,circle).perform();

        //3. Assert:
        String expectedResult = "You did great!";
        WebElement actualResult = Driver.getDriver().findElement(By.id("droptarget"));
        Assert.assertEquals(actualResult.getText(),expectedResult);
        //-Text in big circle changed to: “You did great!”
    }

    @Test
    public void Test3(){
        //TC4 #: Click and hold
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        //2. Click and hold the small circle.
        Actions action = new Actions(Driver.getDriver());

        WebElement draggable = Driver.getDriver().findElement(By.id("draggable"));
        WebElement circle = Driver.getDriver().findElement(By.id("droptarget"));

        action.clickAndHold(draggable).moveByOffset(100,200).perform();
        //3. Assert:
        //-Text in big circle changed to: “Drop here.”
        String expectedResult = "Drop here.";
        String actualresult = circle.getText();
        Assert.assertEquals(expectedResult,actualresult);
    }

    @Test
    public void Test4(){
    //TC5 #: Drag and drop outside the big circle
        //1. Go to TC6 #: Drag and hover
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles

       Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        Actions action = new Actions(Driver.getDriver());

        WebElement draggable = Driver.getDriver().findElement(By.id("draggable"));
        WebElement circle = Driver.getDriver().findElement(By.id("droptarget"));

        action.clickAndHold(draggable).moveByOffset(100,200).release().perform();

        String expectedResult = "Try again!";
        String actualresult = circle.getText();

        //3. Assert:
        //-Text in big circle changed to: “Try again!”
        Assert.assertEquals(expectedResult,actualresult);

    }

    @Test
    public void Test5(){
        //TC6 #: Drag and hover
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        //2. Drag the small circle on top of the big circle, hold it, and verify.
        Actions action = new Actions(Driver.getDriver());

        WebElement draggable = Driver.getDriver().findElement(By.id("draggable"));
        WebElement circle = Driver.getDriver().findElement(By.id("droptarget"));

        action.clickAndHold(draggable).moveToElement(circle).perform();


        //3. Assert:
        //-Text in big circle changed to: “Now drop...”
        String expectedResult = "Now drop...";
        String actualresult = circle.getText();
        Assert.assertEquals(expectedResult,actualresult);

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtlis.sleep(3);
        Driver.closeDriver();
    }

}
