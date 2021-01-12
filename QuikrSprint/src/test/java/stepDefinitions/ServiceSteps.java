package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ServiceList;

public class ServiceSteps{
	ServiceList sl=new ServiceList();  

	@When("^validate the homepage$")
    public void validate_the_homepage() throws Throwable {
        
    }

    @Then("^display the business list$")
    public void display_the_business_list() throws Throwable {
        sl.services();
    }


}
