package com.pepo.base;

import com.pepo.pages.*;
import io.appium.java_client.AppiumDriver;

public class PlatformIOS implements PlatformConstants {


    AppiumDriver driver;


    public PlatformIOS(AppiumDriver<?> driver) {

        this.driver = driver;
    }

    @Override
    public HomePage getHomePage() {
        return new HomePageIos(driver);
    }

    @Override
    public ProfilePage getProfilePage() {
        return new ProfilePageIos(driver) {
        };
    }

    @Override
    public HelperPage getHelperPage() {
        return new HelperPageIos(driver) {
        };
    }

    @Override
    public TwitterConnectPage getTwitterConnectPage() {
        return new TwitterConnectPage(driver);
    }

    @Override
    public SignupPage getSignUpPage() {
        return new SignupPageIos(driver);
    }

    @Override
    public BottomNavigationPage getBottomNavigationPage() {
        return new BottomNavigationPage(driver);
    }

    @Override
    public SearchPage getSearchPage() {
        return new SearchPageIos(driver) {
        };
    }
}
