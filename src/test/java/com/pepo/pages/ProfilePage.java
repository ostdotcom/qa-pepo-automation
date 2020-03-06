package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class ProfilePage {

    AppiumDriver driver;







    public ProfilePage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    abstract public void clickOnTopup();
    abstract public void clickOnBackScreen();
    abstract public void clickOnUnicorn();
    abstract public void clickOnEditProfile();
    abstract public void clickOnBackArrow();


}
