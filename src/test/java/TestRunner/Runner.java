package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/FeatureFiles/products.feature",
		glue="StepApi",
		monochrome=true,
		dryRun=false
		
		)
public class Runner extends AbstractTestNGCucumberTests {

}
