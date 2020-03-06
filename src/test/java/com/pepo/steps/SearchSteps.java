package com.pepo.steps;

import com.pepo.base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps {

    private Base base;



    public SearchSteps(Base base) {
        this.base = base;
    }


    @When("User navigates to Search Tab")
    public void userNavigatesToSearchTab() {
        base.platform.getBottomNavigationPage().clickOSearchIcon();

        //Verify Top page

        /**
         * To do : Scroll is working fine but getting webDriver exception.
         */
        //base.platform.getSearchPage().verifyTrendingThings(base);
    }

    @And("Search with (.+) text")
    public void search_with_text(String search_term) {
        base.platform.getSearchPage().searchWithText(search_term);
    }

    @Then("User should get the relevant results")
    public void userShouldGetTheRelevantResults() {
        System.out.println("To Do : Need to verify search results");
    }

    @When("User navigates to Communities page")
    public void userNavigatesToCommunitiesPage() {
        base.platform.getHelperPage().swipeLeft();
        System.out.println("Should be in Communities page");
        base.platform.getSearchPage().clearSearchBox();
    }

    @When("User navigates to People page")
    public void userNavigatesToPeoplePage() {
        base.platform.getHelperPage().swipeLeft();
        System.out.println("Should be in People page");
        base.platform.getSearchPage().clearSearchBox();

    }

    @When("User navigates to Tags page")
    public void userNavigatesToTagsPage() {
        base.platform.getHelperPage().swipeLeft();
        System.out.println("Should be in Tags page");

    }
}
