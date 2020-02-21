package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitterConnectPage {

    AppiumDriver driver;

    @FindBy(id = "username_or_email")
    private MobileElement userNameTb;

    @FindBy(id = "password")
    private MobileElement passwordTb;

    @FindBy(id = "allow")
    private MobileElement allowCheckBox;

    @FindBy(id = "com.twitter.android:id/ok_button")
    private MobileElement okButton;


    public TwitterConnectPage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void writeUserNameOREmail(String userNameOrEmail)
    {
        driver.findElement(By.id("username_or_email")).sendKeys(userNameOrEmail);
       // userNameTb.sendKeys(userNameOrEmail);
    }


    public void writePassword(String password)
    {
        passwordTb.sendKeys(password);
    }

    public void clickOnAllowCheckBox()
    {
        allowCheckBox.click();
    }

    public void clickOnOkBtn()
    {
        driver.findElementByAccessibilityId("Authorize app").click();
    }


    public void loginWithEmailTwitter(String userNameOrEmail, String password)
    {
//        AndroidDriver driverA = (AndroidDriver)driver;
//        driverA.openNotifications();
//        driverA.navigate().back();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        writeUserNameOREmail(userNameOrEmail);
        writePassword(password);
        clickOnAllowCheckBox();
        //clickOnOkBtn();
    }



}
