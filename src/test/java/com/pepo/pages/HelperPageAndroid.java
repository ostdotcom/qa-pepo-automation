package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static java.time.Duration.ofSeconds;

public class HelperPageAndroid extends HelperPage {

    public HelperPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void scrollToBottom() {
        new TouchAction(driver).press(new PointOption().withCoordinates(500,500))
                .waitAction(WaitOptions.waitOptions(ofSeconds(1)))
                .moveTo(new PointOption().withCoordinates(0,0)).release().perform();

    }
}
