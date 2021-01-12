package stepDefinitions;

import org.testng.annotations.BeforeMethod;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Register;
 
public class RegisterSteps {
	Register q = new Register();

	@Given("^user is on quikr home page$")
    public void user_is_on_quikr_home_page() throws Throwable {
		 q.openurl();
    }

	 @Then("^user is on login or register popup$")
    public void user_is_on_login_or_register_popup() throws Throwable {
		 q.open_registration_page();
    }
	
	 @When("^user enters valid (.+) (.+) (.+) (.+)$")
	    public void user_enters_valid(String userid, String name, String email, String password) throws Throwable {
	      q.registered_credintials("9745786373", "Komal", "komal2017@gmail.com", "komal@1234");
	    }
	 
	 
    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        
    }


}
