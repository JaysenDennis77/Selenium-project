package com.cydeo.pages;

import com.cydeo.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    //1 create constructor and initialize "driver" and "object" of this class
        public DynamicControlsPage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//button[text()='Remove']")
    public WebElement RemoveButton;

        @FindBy(id = "loading")
    public WebElement loadingBar;

        @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkbox;

        @FindBy(id = "message")
    public WebElement itsGoneMessage;

        @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;

@FindBy(xpath = "//button[.='Enable']")
        public WebElement enableButton;
}
