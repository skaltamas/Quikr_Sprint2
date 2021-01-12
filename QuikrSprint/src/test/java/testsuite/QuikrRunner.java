package testsuite;

import org.junit.runner.RunWith;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featurefiles/B_login.feature",
				"featurefiles/C_searchbar.feature",
				"featurefiles/D_businesslist.feature",
				"featurefiles/E_visit.feature",
				"featurefiles/F_postfreead.feature",
				"featurefiles/G_form.feature"} /// which feature files to run
		,glue= {"stepDefinitions","base"}			//package names having the scripts for the feature file
		,tags= "@tag"		// the tags to run.... which are in feature file		
		)

public class QuikrRunner extends AbstractTestNGCucumberTests{
}

/*register
login
search
visit store
business list
post ad categories
post ad form*/