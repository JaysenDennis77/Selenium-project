package com.cydeo.tests.Day05_testNG_intro_dropdowns;

import com.cydeo.utilites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class TC3_RadioButtonHandlingPT2 {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        // click and verify hockey button is selected
        clickAndVerifyRadioButton(driver,"sport","hockey");

        clickAndVerifyRadioButton(driver, "sport", "football");

        clickAndVerifyRadioButton(driver,"color","red");

        }

    //Create a utility method to handle above logic.
    //Method name: clickAndVerifyRadioButton
    //Return type: void or boolean
    //Method args:
    //1. WebDriver
    //2. Name attribute as String (for providing which group of radio buttons)
    //3. Id attribute as String (for providing which radio button to be clicked)
    //Method should loop through the given group of radio buttons. When it finds the
    //matching option, it should click and verify option is Selected.
    //Print out verification: true
        private static void clickAndVerifyRadioButton (WebDriver driver, String nameAttribute,String excpectedID) {

            // locate all the 'sports' radio buttons and store them into a list<WebElement>
            //List<WebElement> radioButton = driver.findElements(By.xpath("//input[@name='"+nameAttribute+"']"));
            List<WebElement> radioButton = driver.findElements(By.name(nameAttribute));

            for (WebElement each : radioButton) {
                String actualID = each.getAttribute("id");
                System.out.println("actualID = " + actualID);

                if (actualID.equals(excpectedID)) {
                    each.click();
                    System.out.println(actualID + " is Selected: " + each.isSelected());
                    break;
                }
            }


        }
    }


