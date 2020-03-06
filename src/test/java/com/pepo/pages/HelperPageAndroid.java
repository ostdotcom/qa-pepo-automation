package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @Override
    public void scrollDownToText(String text) {

        boolean isPresent = false;
        int pressX = driver.manage().window().getSize().width / 2;

        int bottomY = (int)(driver.manage().window().getSize().height * 0.70);

        int topY = (int)(driver.manage().window().getSize().height * 0.1);
        //int topY = 0;

        int i = 0;

        do{
            try {
                WebDriverWait wait = new WebDriverWait(driver,5);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'" + text + "')]")));
                System.out.println("element with text "+text+ " is visible");
            } catch (TimeoutException e)
            {
                System.out.println("Element is not located. So scrolling down " + i);
                scroll(pressX, bottomY, pressX, topY);

            } catch (WebDriverException we)
            {
                System.out.println("In webdriver exception : Skipping it for now" );
            }
            i++;

        } while(i <= 4);
       }

    @Override
    public void swipeLeft() {

        int startX = (int) (driver.manage().window().getSize().width * 0.90);

        int startY = driver.manage().window().getSize().height /2;

        int endX = (int) (driver.manage().window().getSize().width * 0.05);

        scroll(startX,startY,endX,startY);

    }

    private void scroll(int fromX, int fromY, int toX, int toY) {
        new TouchAction(driver).press(new PointOption().withCoordinates(fromX, fromY))
                .waitAction(WaitOptions.waitOptions(ofSeconds(1)))
                .moveTo(new PointOption().withCoordinates(toX, toY)).release().perform();
    }
}
