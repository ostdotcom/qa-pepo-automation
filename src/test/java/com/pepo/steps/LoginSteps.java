package com.pepo.steps;

import com.pepo.base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mamagers.ConfigDataManagers;
import org.openqa.selenium.By;
//import io.appium.java_client.TouchAction;

import java.util.Set;

import static java.time.Duration.ofSeconds;

public class LoginSteps {

    private Base base;
    private static final String twitter = "twitter";
    private static final String gmail = "gmail";
    private static final String apple = "apple";
    private static final String github = "github";


    @Given("User is ready to Login")
    public void userIsReadyToLogin() throws InterruptedException {

        // To-do : Need to remove
        Thread.sleep(1000);

        try {
            base.platform.getHomePage().acceptAlert();
        } catch (Exception e) {
            System.out.println("No Alert present");
        }

        base.platform.getHomePage().clickOnQuickTip();

        base.platform.getBottomNavigationPage().clickOnProfileIcon();

    }

    public LoginSteps(Base base) {
        this.base = base;
    }


    @When("User login with (.+) credentials")
    public void userLoginWithTwitterLogin(String login_platform) throws InterruptedException {


        switch (login_platform.toLowerCase()) {

            case twitter:
                base.platform.getHomePage().clickOnAuthorizeTwitter();
                Thread.sleep(1000);
                base.platform.getHelperPage().switchContext();
                base.platform.getTwitterConnectPage().loginWithEmailTwitter("bhavik@ost.com", "ostkit@1234");
                break;

            case gmail:
                //base.platform.getHomePage().clickOnAuthorizeTwitter();
                break;

            case apple:
                //base.platform.getHomePage().clickOnAuthorizeTwitter();
                break;

            case github:
                //base.platform.getHomePage().clickOnAuthorizeTwitter();
                break;
        }

        // To-do : Need to remove
        Thread.sleep(1000);
        base.platform.getHelperPage().switchToNative();
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {

        // To-do : Write to verify user is logged successfully.

    }

    @And("User should able to navigate to profile page")
    public void userShouldAbleToNavigateToProfilePage() throws InterruptedException {
        Thread.sleep(3000);

        base.platform.getBottomNavigationPage().clickOnProfileIcon();
        base.platform.getProfilePage().clickOnTopup();
        base.platform.getProfilePage().clickOnBackScreen();
        base.platform.getProfilePage().clickOnUnicorn();
        base.platform.getProfilePage().clickOnBackScreen();
        base.platform.getProfilePage().clickOnEditProfile();
        base.platform.getProfilePage().clickOnBackArrow();
    }


    @Then("User should able to navigate to notification page and accept the terms page")
    public void userShouldAbleToNavigateToNotificationPageAndAcceptTheTermsPage() throws InterruptedException {


        //click on activity icon
        base.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.widget.ImageView | /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.ImageView")).click();
        base.driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Turn On Notification')]")).click();

        Thread.sleep(1000);
    }
}