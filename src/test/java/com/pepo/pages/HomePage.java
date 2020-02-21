package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HomePage {

    AppiumDriver driver;

    public HomePage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    @FindBy(xpath = "test")
    private MobileElement test;

    @FindBy(xpath = "//*[contains(@text,'Got It!')]")
    private MobileElement quickAcceptTip;


    @FindBy(name = "home-tab")
    private MobileElement home_tab;

    @FindBy(xpath = "//*[contains(@text,'Continue with Twitter')]" )
    private MobileElement twitterConnectBtn;

    @FindBy(xpath = "//*[contains(@text,'Wallet loading')]")
    private MobileElement walletIcn;



    abstract public void getResult();

    public void clickOnQuickTip()
    {
        quickAcceptTip.click();
    }

    abstract public void clickOnHomeIcon();

    public void clickOnProfileIcon()
    {
        driver.findElementByAccessibilityId("custom-navigation-tab-profile").click();
        System.out.println("clicked on profile");
    }

    public void clickOnAuthorizeTwitter()
    {
        twitterConnectBtn.click();
    }

    public void clickOnSendPepoIcon()
    {
        driver.findElementByAccessibilityId("pepo-clap-button").click();
        System.out.println("clicked on pepo icon");
    }

    public String getPepoBalance()
    {
        try {
            System.out.println("In Try block to verify Balance");
            MobileElement walletIcon = (MobileElement) driver.findElementByAccessibilityId("top-status-wallet-balance");
            WebDriverWait wait = new WebDriverWait(driver, 380);
            wait.until(ExpectedConditions.visibilityOf(walletIcon));
            return walletIcon.getText();
        }
        catch (NoSuchElementException ne)
        {
            System.out.println("In Catch block to verify Balance");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MobileElement walletIcon = (MobileElement) driver.findElementByAccessibilityId("top-status-wallet-balance");
            WebDriverWait wait = new WebDriverWait(driver, 380);
            wait.until(ExpectedConditions.visibilityOf(walletIcon));
            return walletIcon.getText();
        }
    }

    abstract public String getSendPepoCoins();

    public void waitTillWalletLoading()
    {
        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.elementToBeClickable(walletIcn));
    }

    abstract public void acceptAlert();
}
