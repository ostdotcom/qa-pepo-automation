package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.FindBy;

import java.awt.event.KeyEvent;

public class SignupPageAndroid extends SignupPage {


    @FindBy(xpath = "//*[contains(@text,'email@gmail.com')]")
    private MobileElement emailTb;

    @FindBy(xpath = "//*[contains(@text,'Sign Up')]")
    private MobileElement signupBtn;

    @FindBy(xpath = "//*[contains(@text,'OK')]")
    private MobileElement okBtn;

    @FindBy(xpath = "//*[contains(@text,'Add to Wallet')]")
    private MobileElement addWalletBtn;


    public SignupPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void enterEmailAndOk(String email) {
        emailTb.sendKeys(email);
        signupBtn.click();
        okBtn.click();
    }

    @Override
    public void clickOnAddToWallet() {
        addWalletBtn.click();
    }

    @Override
    public void setAndConfirmPin() {

        System.out.println("pin digit: " +KeyEvent.VK_1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);

        System.out.println("pin digit: " +KeyEvent.VK_1);


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
        ((AndroidDriver)driver).pressKeyCode(KeyEvent.VK_1);
    }
}
