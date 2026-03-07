package CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/FeatureFiles/ApplicationLogin.feature",
glue= {"StepDefinitions","MyHooks"},
plugin= {"pretty","html:target/ApplicationLogin.html"},
//tags="not @Smoke",
monochrome=true

)
public class ApplicationLoginRunner extends AbstractTestNGCucumberTests{

}