package CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/FeatureFiles/OrderSubmit.feature",
glue={"StepDefinitions","MyHooks"},
monochrome=true,
//tags="@Smoke",
//tags="@ErrorValidation",
plugin= {"html:CucumberReports/cucumber.html"}
)
public class E2EOrderSubmitRunner extends AbstractTestNGCucumberTests {

}
