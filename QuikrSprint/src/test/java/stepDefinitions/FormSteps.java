package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Form;
import pages.ServiceList;

public class FormSteps {
	ServiceList sl = new ServiceList();
	Form f = new Form();
	
	@Given("^url opens$")
    public void url_opens() throws Throwable {
		sl.openurl();
        
    }

    @When("^click on postad$")
    public void click_on_postad() throws Throwable {
    	f.postbutton();
    	f.postpage();
        
    }

    @Then("^fill the form to post ad$")
    public void fill_the_form_to_post_ad() throws Throwable {
        f.carform();
    }

    }




