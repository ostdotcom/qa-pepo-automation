package com.pepo.pages;

import com.pepo.base.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SearchPage {

    AppiumDriver driver;


    @FindBy(xpath = "//*[contains(@text,'Search communities, people or tags')]")
    private MobileElement searchBox;

    @FindBy(xpath = "//*[contains(@text,'Trending Communities')]")
    private MobileElement trendingCommunitiesTxt;

    @FindBy(xpath = "//*[contains(@text,'Trending People')]")
    private MobileElement trendingPeopleTxt;

    @FindBy(xpath = "//*[contains(@text,'Trending Tags')]")
    private MobileElement trendingTagsTxt;

    @FindBy(xpath = "//*[contains(@text,'Tags')]")
    private MobileElement tagsTab;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.ImageView")
    private MobileElement cancelSearchIcon;



    public SearchPage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void searchWithText(String search_term) {
        searchBox.sendKeys(search_term);
    }

    public void verifyTrendingThings(Base base) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedConditions.visibilityOf(trendingCommunitiesTxt)));
        System.out.println("Trending communities visible");


        base.platform.getHelperPage().scrollDownToText("Trending People");

        wait.until(ExpectedConditions.visibilityOf(trendingPeopleTxt));
        System.out.println("Trending People visible");

        base.platform.getHelperPage().scrollDownToText("Trending Tags");

        wait.until(ExpectedConditions.visibilityOf(trendingTagsTxt));
        System.out.println("Trending Tags visible");

    }

    public void navigateToCommunities()
    {
    }

    public void clearSearchBox() {
        cancelSearchIcon.click();
    }

    public void navigatetoTagsPage() {
        tagsTab.click();
    }
}
