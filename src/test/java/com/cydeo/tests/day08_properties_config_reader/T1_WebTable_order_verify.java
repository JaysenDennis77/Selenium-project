package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilites.BrowserUtlis;
import com.cydeo.utilites.WebDriverFactory;
import com.cydeo.utilites.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_order_verify {

    WebDriver driver;


    @BeforeMethod
    public void setupmethod(){
        //1. Create new test and make set ups
        //2. Go to : https://www.amazon.com

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/web-tables");
    }

@Test
    public void T1(){


    //2. Verify Bob’s name is listed as expected.
    //below locate is locating me the bob martins cell as where it is currently stored
    //table[@class='SampleTable']/tbody/tr[7]/td[2]

    //locate bobs cell using its name as the text
    //Expected: “Bob Martin”
    WebElement bobsCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));

    System.out.println("bobsCell.getText() = " + bobsCell.getText());

    String expectedName = "Bob Martin";
    String actualName = bobsCell.getText();

    Assert.assertEquals(actualName,expectedName);

    //3. Verify Bob Martin’s order date is as expected
WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));

    //: 12/31/2021
String excpectedDate = "12/31/2021";
String actualDate = bobsOrderDate.getText();
Assert.assertEquals(actualDate,excpectedDate);
}

@Test
    public void test2(){
    //call the utility method we created
    String alexandraGray = WebOrderUtils.returnOrderDate(driver, "Alexandra Gray");
    System.out.println("alexandraGray = " + alexandraGray);

    String bartFisher = WebOrderUtils.returnOrderDate(driver, "Bart Fisher");
    System.out.println("bartFisher = " + bartFisher);

}

    @Test
    public void test3(){

        WebOrderUtils.orderVerify(driver, "Bob Martin", "12/31/2021");

    }

}
