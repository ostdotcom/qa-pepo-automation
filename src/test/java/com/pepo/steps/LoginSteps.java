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

    public LoginSteps(Base base) {
        this.base = base;
    }


    @Given("Launch the Pepo App")
    public void launchThePepoApp() throws Exception {

        // To-do : Need to remove
        Thread.sleep(1000);


        //base.platform.getHomePage().getResult();

        base.platform.getHomePage().clickOnQuickTip();

        base.platform.getHomePage().clickOnProfileIcon();

        base.platform.getHomePage().clickOnAuthorizeTwitter();



        // To-do : Need to remove
        Thread.sleep(1000);

        }

    @When("User login with twitter login")
    public void userLoginWithTwitterLogin() throws InterruptedException {

        base.platform.getHelperPage().switchContext();

        try
        {
            base.platform.getTwitterConnectPage().loginWithEmailTwitter("bhavik@ost.com","ostkit@1234");
        }
        catch (Exception e)
        {
            // Need to scroll to bottom as Twitter connect button is not visible in some of small devices
            base.platform.getHelperPage().scrollToBottom();
            base.platform.getTwitterConnectPage().clickOnOkBtn();
        }
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {

        // To-do : Write to verify user is logged successfully.

    }

    @And("User should able to navigate to profile page")
    public void userShouldAbleToNavigateToProfilePage() throws InterruptedException {
        Thread.sleep(3000);

        base.platform.getHomePage().clickOnProfileIcon();
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
