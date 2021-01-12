package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;

public class LoginSteps {
	Login l = new Login();

    @Given("^user is on login popup$")
    public void user_is_on_login_popup() throws Throwable {
        
    }

    @When("^user clicks on login or register$")
    public void user_clicks_on_login_or_register() throws Throwable {
        l.display_login();
    }

    @When("^user enters invalid (.+) (.+)$")
    public void user_enters_invalid(String userid, String password) throws Throwable {
        l.enter_invalid(userid, password);
    }

    @When("^user enters valid (.+) (.+)$")
    public void user_enters_valid(String useridd, String passwordd) throws Throwable {
        l.enter_valid(useridd, passwordd);
    }

    @Then("^login popup is displayed$")
    public void login_popup_is_displayed() throws Throwable {
        
    }

    @Then("^user is not logged in$")
    public void user_is_not_logged_in() throws Throwable {
        
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        
    }
}
