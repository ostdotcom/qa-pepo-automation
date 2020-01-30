package com.pepo.steps;

import com.pepo.base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;
import drivers.ApiDrivers;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.JSONObject;
//import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Set;

import static java.time.Duration.ofSeconds;

public class SignupSteps {

    private Base base;
    ApiDrivers apiDrivers = new ApiDrivers();

    public SignupSteps(Base base) {
        this.base = base;
    }


    @Given("User is not part of Pepo")
    public void make_user_ready_to_sign_up() {

        // Need to identify user's current user_name to rotate
        HashMap<String, Object> params = new HashMap<>();
        params.put("token", "1169918663371026433-zDN48wJvmz2snspAH5C3i9q7tBfo78");
        params.put("secret", "J7zgG7LXMCMx6CJCsUBFGo6t2UXlvowky1ecuqudatw3C");
        params.put("twitter_id", "1169918663371026433");
        params.put("handle", "BhavikPepo");
        JSONObject jsonObject =  apiDrivers.loginUsers(params);

        String userId = jsonObject.getJSONObject("data").getJSONObject("logged_in_user").get("user_id").toString();

        String userName = jsonObject.getJSONObject("data").getJSONObject("users").getJSONObject(userId).get("user_name").toString();


        // After getting the user_name rotate that user
        HashMap<String, Object> params1 = new HashMap<>();
        params1.put("user_name",userName);
        apiDrivers.rotateUsers(params1);
    }


    @Given("User is ready to signup in app")
    public void userIsReadyToSignupInApp() throws InterruptedException {

        base.platform.getHomePage().clickOnQuickTip();

        base.platform.getHomePage().clickOnProfileIcon();

        base.platform.getHomePage().clickOnAuthorizeTwitter();

        // To-do : Need to remove
        Thread.sleep(1000);


    }

    @When("User authorised with twitter credentials")
    public void userAuthorisedWithTwitterCredentials() throws InterruptedException {

        base.platform.getHelperPage().switchContext();

        try{
            base.platform.getTwitterConnectPage().loginWithEmailTwitter("bhavik@ost.com","ostkit@1234");
        }
        catch (Exception e)
        {
            base.platform.getHelperPage().scrollToBottom();
            base.platform.getTwitterConnectPage().clickOnOkBtn();
        }
    }

    @And("User will setup and confirm PIN")
    public void userWillSetupAndConfirmPIN() throws InterruptedException {

        Thread.sleep(10000);
        System.out.println("Write email if it is there");

        try
        {
            base.platform.getSignUpPage().enterEmailAndOk("abc@ost.com");

//            base.driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'email@gmail.com')]")).sendKeys("abc@abc.com");
//            base.driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Sign Up')]")).click();
//
//            // Confirm email
//
//            base.driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'OK')]")).click();
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Email is already associated with Twitter account");
        }



        base.platform.getSignUpPage().clickOnAddToWallet();
        //((AndroidDriver)base.driver).findElement(By.xpath("//android.widget.TextView[contains(@text,'Add to Wallet')]")).click();

        //Enter PIN
        base.platform.getSignUpPage().setAndConfirmPin();

//        Thread.sleep(500);
//        //base.driver.pressKey(new KeyEvent());
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//
//        System.out.println("pin digit: " + KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//
//        System.out.println("pin digit: " +KeyEvent.VK_1);
//
//
//        Thread.sleep(500);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);
//        ((AndroidDriver)base.driver).pressKeyCode(KeyEvent.VK_1);

    }

    @Then("User should navigate to feed page")
    public void userShouldNavigateToFeedPage() {


    }

    @And("Wallet activation should start")
    public void walletActivationShouldStart() {

        base.platform.getHomePage().waitTillWalletLoading();
    }

    @When("Wallet activation is completed")
    public void walletActivationIsCompleted() {


    }

    @Then("User has balance of {int} pepos")
    public void userIsHasBalanceOfPepos(int airdropAmnt) throws Exception {

        if(base.platform.getHomePage().getPepoBalance().equalsIgnoreCase(airdropAmnt+""))
        {
            System.out.println("Balance credited");
        }
        else
        {
            throw new Exception("Balance not credited. Something went wrong with Wallet");
        }
    }

    @When("User sends one pepo to video")
    public void userSendsOnePepoToVideo() {
        base.platform.getHomePage().clickOnSendPepoIcon();
    }

    @Then("Transaction should completed successfully")
    public void transactionShouldCompletedSuccessfully() {
        String bal = base.platform.getHomePage().getPepoBalance();

        System.out.println("User's Current bal"+bal);
    }
}
