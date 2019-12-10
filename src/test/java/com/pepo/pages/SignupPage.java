package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class SignupPage {

    AppiumDriver driver;


    public SignupPage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    abstract public void enterEmailAndOk(String email);
    abstract public void clickOnAddToWallet();
    abstract public void setAndConfirmPin();
}
