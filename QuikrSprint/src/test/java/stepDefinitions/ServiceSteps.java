package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ServiceList;

public class Servicerunner{
	ServiceList sl=new ServiceList();
	
	@Given("^quikr url opens$")
    public void quikr_url_opens() throws Throwable {
		sl.openurl();
	}
        

    @When("^validate the homepage$")
    public void validate_the_homepage() throws Throwable {
    	sl.validate_url();
        
    }

    @Then("^display the business list$")
    public void display_the_business_list() throws Throwable {
    	sl.services();
        
    }


}
