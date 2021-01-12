package stepDefinitions;

import org.testng.annotations.BeforeMethod;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;
import pages.Register;
 
public class RegisterSteps {
	Register q = new Register();
	
	@Given("^user is on quikr home page$")
    public void user_is_on_quikr_home_page() throws Throwable {
        
    }

    @When("^user is on login or register popup$")
    public void user_is_on_login_or_register_popup() throws Throwable {
        q.open_registration_page();    }

    @Then("^user is registered$")
    public void user_is_registered() throws Throwable {
        
    }

    @And("^user enters (.+) (.+) (.+) (.+)$")
    public void user_enters(String registerid, String name, String email, String pwd) throws Throwable {
        q.registered_credintials(registerid, name, email, pwd);
    }
}
