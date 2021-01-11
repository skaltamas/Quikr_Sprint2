package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Searchbar;

public class SearchbarSteps {
	
	Searchbar q=new Searchbar();
	
	@Given("^user is on quikr homepage$")
    public void user_is_on_quikr_homepage() throws Throwable {
        q.openurl();
        q.validate_title();
    }

    @When("^enter any (.+) to search and click search$")
    public void enter_any_to_search_and_click_search(String searchword) throws Throwable {
       q.searchbar(searchword);
    }

    @Then("^display result contains (.+)$")
    public void display_result_contains(String searchword) throws Throwable {
        System.out.println(searchword);
    }
    
    @When("^enter space in search bar and click search$")
    public void enter_space_in_search_bar_and_click_search() throws Throwable {
        q.invalidsearch();
    }

    @Then("^display result Search in All India$")
    public void display_result_search_in_All_India() throws Throwable {
        
    }
   
}
