package com.pepo.base;

import com.pepo.pages.*;
import io.appium.java_client.AppiumDriver;

public class PlatformAndroid  implements PlatformConstants {

    AppiumDriver driver;

    public PlatformAndroid(AppiumDriver<?> driver) {
        this.driver = driver;
    }


    @Override
    public HomePage getHomePage() {
        return new HomePageAndroid(driver);
    }

    @Override
    public ProfilePage getProfilePage() {
        return new ProfilePageAndroid(driver);
    }

    @Override
    public HelperPage getHelperPage() {
        return new HelperPageAndroid(driver);
    }

    @Override
    public TwitterConnectPage getTwitterConnectPage() {
        return new TwitterConnectPage(driver);
    }

    @Override
    public SignupPage getSignUpPage() {
        return new SignupPageAndroid(driver);
    }
}
