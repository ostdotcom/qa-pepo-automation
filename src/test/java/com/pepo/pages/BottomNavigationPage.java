package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BottomNavigationPage {

    AppiumDriver driver;


    public BottomNavigationPage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickOnProfileIcon()
    {
        driver.findElementByAccessibilityId("custom-navigation-tab-profile").click();
        System.out.println("clicked on profile");
    }


    public void clickOSearchIcon()
    {
        driver.findElementByAccessibilityId("custom-navigation-tab-search").click();
        System.out.println("clicked on profile");
    }



    public void clickOnCameraIcon()
    {
        driver.findElementByAccessibilityId("custom-navigation-tab-camera").click();
        System.out.println("clicked on profile");
    }


    public void clickOnNotificationIcon()
    {
        driver.findElementByAccessibilityId("custom-navigation-tab-notifications").click();
        System.out.println("clicked on profile");
    }

    public void clickOnHomeIcon()
    {
        driver.findElementByAccessibilityId("custom-navigation-tab-home").click();
        System.out.println("clicked on profile");
    }





}
