package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.VisitStore;

public class VisitStep 
{

	VisitStore v=new VisitStore();
	
	@Given("^user is on quikr homepage$")
    public void user_is_on_quikr_homepage() throws Throwable {
        v.openurl();
    }

    @When("^user clicks on visit our store button$")
    public void user_clicks_on_visit_our_store_button() throws Throwable {
        v.store();
    }

    @Then("^the visit our store page displayed in next tab$")
    public void the_visit_our_store_page_displayed_in_next_tab() throws Throwable {
        v.display();
    }


}
