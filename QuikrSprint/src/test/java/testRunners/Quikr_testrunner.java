package testRunners;

import org.junit.runner.RunWith;



import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

                                        
@RunWith(Cucumber.class)
@CucumberOptions( 
		features = {"featurefiles/quikr.feature"}
		,glue= {"stepDefinations"}
		,tags= "@tag"
		)

public class Quikr_testrunner extends AbstractTestNGCucumberTests{

}
