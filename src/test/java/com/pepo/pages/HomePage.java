package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class HomePage {

    AppiumDriver driver;

    public HomePage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    @FindBy(xpath = "test")
    private MobileElement test;


    abstract public void getResult();

    abstract public void clickOnQuickTip();

    abstract public void clickOnHomeIcon();

    abstract public void clickOnProfileIcon();

    abstract public void clickOnAuthorizeTwitter();

    abstract public void clickOnSendPepoIcon();

    abstract public String getPepoBalance();

    abstract public String getSendPepoCoins();

    abstract public void waitTillWalletLoading();






}
