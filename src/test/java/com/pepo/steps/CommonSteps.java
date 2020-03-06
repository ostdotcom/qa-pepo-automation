package com.pepo.steps;

import com.pepo.base.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CommonSteps {


    private Base base;



    public CommonSteps(Base base) {
        this.base = base;
    }


    @Given("User is on home feed page")
    public void userIsOnHomeFeedPage() {
    }
}
