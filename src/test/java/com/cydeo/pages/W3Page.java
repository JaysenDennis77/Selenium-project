package com.cydeo.pages;

import com.cydeo.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3Page {
    //1 create constructor and initialize the driver instance and object of the current class
    public W3Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    //2 Instead of using findElement method we use @FindBy annotation

    @FindBy(id = "demo")
    public WebElement paragraph;

}
