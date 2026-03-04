package CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/FeatureFiles/ApplicationLogin.feature",
glue= {"StepDefinitions","LoginHooks"},
//tags="not @Smoke",
monochrome=true

)
public class TestNgRunner extends AbstractTestNGCucumberTests{

}