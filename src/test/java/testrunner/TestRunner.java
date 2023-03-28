package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", 
					glue= {"stepdefinitions"},
					tags= {"@sanity or @regression"},
					monochrome=true,
					plugin= {"pretty","html:target/HTMlReports",
							"json:target/JSONReport/report.json",
							"junit:target/XMLReports/report.xml",
							})
public class TestRunner {
	
	
	
}
