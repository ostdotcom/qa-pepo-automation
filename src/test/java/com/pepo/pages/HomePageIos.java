package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class HomePageIos extends HomePage {

    public HomePageIos(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(name = "Got It!")
    private MobileElement gotItBtn;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=1 0 18 Supporters @Santhosh #pune test.com/ 4 0 11 Supporters @curepetopeto Aaaaaa 1 0 3 Supporters @dsp_8 In progress 0 1 1 Supporter @Mayu_k3zo669930 In progress 0 0 22 Supporters @sunil_b12 #assurance In progress 10 0 22 Supporters @sunil_b12 @Mayu_k3zjgfz6i8 In progress 0 0 0 Supporter @Mayu_k333 Hi google.com/ In progress 15 15 3 Supporters @good_pepo #reply #test #fddfg #fddg gogle.com/ In progress 3 4 4 Supporters @tiff_k3yannqkxi tes. In progress 1 3 4 Supporters @H github.com/OSTDOTCOM/OST-WALLET-SDK-IOS/BLOB/DEVELOP/OSTWALLETSDK/NETWORK/OSTAPIBASE.SWIFT In progress 1 0 4 Supporters @H pepo.com/])[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]")
    private MobileElement profileIcon;

    @Override
    public void getResult() {

        System.out.println("In LoginIos page");
    }

//    @Override
//    public void clickOnQuickTip() {
//        gotItBtn.click();
//    }

    @Override
    public void clickOnHomeIcon() {

    }

//    @Override
//    public void clickOnProfileIcon() {
//        profileIcon.click();
//    }
//
//    @Override
//    public void clickOnSendPepoIcon() {
//
//    }

//    @Override
//    public String getPepoBalance() {
//        return null;
//    }

    @Override
    public String getSendPepoCoins() {
        return null;
    }

//    @Override
//    public void waitTillWalletLoading() {
//
//    }

    @Override
    public void acceptAlert() {

    }


}
