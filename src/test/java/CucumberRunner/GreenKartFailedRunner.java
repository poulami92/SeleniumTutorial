package CucumberRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="@target/failed_scenarios.txt",
tags="@GreenKart",
glue= {"StepDefinitions","MyHooks"},
plugin= {"html:CucumberReports/GreenKart.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		},

monochrome=true
)

public class GreenKartFailedRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
