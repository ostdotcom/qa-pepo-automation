package com.pepo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public abstract class HelperPage {

    AppiumDriver driver;

    public HelperPage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void switchContext() throws InterruptedException {
        Set<String> availableContexts = driver.getContextHandles();
        System.out.println("Total No of Context Found After we reach to WebView = " + availableContexts.size());
        System.out.println("Total Context Found After we reach to WebView = " + availableContexts);
        for (String context : availableContexts) {
            if (context.contains("WEBVIEW")) {
                System.out.println("Context Name is " + context);
                // 4.3 Call context() method with the id of the context you want to access and change it to WEBVIEW_1
                //(This puts Appium session into a mode where all commands are interpreted as being intended for automating the web view)
                Thread.sleep(1000);
                driver.context(context);
                break;
            }
        }
    }

    abstract public void scrollToBottom();
}
