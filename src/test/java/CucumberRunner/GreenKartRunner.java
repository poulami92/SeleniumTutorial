package CucumberRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/FeatureFiles",
tags="@GreenKart",
glue= {"StepDefinitions","MyHooks"},
plugin= {"html:CucumberReports/GreenKart.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"
		},

monochrome=true
)

public class GreenKartRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
