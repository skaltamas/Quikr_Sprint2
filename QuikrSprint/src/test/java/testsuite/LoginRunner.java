package testsuite;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featurefiles/login.feature"} /// which feature files to run
		,glue="stepDefinitions"				//package names having the scripts for the feature file
		,tags= "@tag"		// the tags to run.... which are in feature file		
		)

public class LoginRunner {
	
}
