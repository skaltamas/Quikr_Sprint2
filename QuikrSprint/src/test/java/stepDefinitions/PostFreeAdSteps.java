package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PostFreeAd;

public class PostFreeAdSteps {
	PostFreeAd q=new PostFreeAd();

	    @When("^user clicks on Post Free Ad button$")
	    public void user_clicks_on_post_free_ad_button() throws Throwable {
	        q.post_button();
	    }

	    @Then("^Post Free Ad page displayed$")
	    public void post_free_ad_page_displayed() throws Throwable {
	        q.displayList();
	    }

	    
	 
    }


