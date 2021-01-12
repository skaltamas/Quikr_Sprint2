package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PostFreeAd;

public class PostFreeAdSteps {
	PostFreeAd q=new PostFreeAd();
	 @Given("^user is on Quikr homepage$")
	    public void user_is_on_quikr_homepage() throws Throwable {
	       q.openurl();
	    }

	    @When("^user clicks on Post Free Ad button$")
	    public void user_clicks_on_post_free_ad_button() throws Throwable {
	        q.post_button();
	    }

	    @Then("^Post Free Ad page displayed$")
	    public void post_free_ad_page_displayed() throws Throwable {
	        q.displayList();
	    }

	    
	 
    }


