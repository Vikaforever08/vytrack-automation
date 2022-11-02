package com.vytrack.utilities;

import org.openqa.selenium.WebElement;

import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;


public class BrowserUtils {
    //Methods are static. Because we do not want to create an object to call those methods.
    // We just want to call those methods with class name. That is why they are static type


    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowserUtils.sleep(3);
     * @param seconds
     */
    public static void sleep(int seconds){
        // 1 second = 1000 millis
        // millis = seconds*1000
        try {
            Thread.sleep(seconds*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }


    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    // BrowserUtils.verifyTitle(driver,"Google")
    public static void verifyTitle(String expectedTitle){

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }

//    /**
//     * This method will accept dropdown as a WebElements and return all the option text in a List of String
//     * @return List<String>
//     */
//    public static <Select> List<String> dropdownOptionsAsString(WebElement dropdownElement){
//        Select select = new Select(dropdownElement);
//
//        //List of all ACTUAL month <options> as aWebElement
//        List<WebElement> actualOptionsAsElement = select.getOptions();
//
//        //List of all ACTUAL month <options> as a String
//        List<String> actualOptionsAsString = new LinkedList<>();
//
//        //with using loop we will convert each WebElement of options to String with using getText() method
//        //with using add() method we will add each String option in List<String> actual option as String
//        for (WebElement each : actualOptionsAsElement) {
//            actualOptionsAsString.add(each.getText());
//        }
//        return actualOptionsAsString;
//    }


    /**
     * This method will accept a group of radio buttons as a List<WebElement>
     * it will loop through the List, and click to the radio button with provided attribute value
     * @param radioBtn
     * @param attributeValue
     */
    public static void clickRadioBtn(List<WebElement> radioBtn, String attributeValue) {
        for (WebElement webElement : radioBtn) {
            if (webElement.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                webElement.click();
            }
        }
    }

}