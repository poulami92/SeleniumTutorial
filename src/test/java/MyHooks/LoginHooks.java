package MyHooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class LoginHooks {
	
//	@Before(order=2)
//	public void setupUrl(Scenario sc)
//	{
//		System.out.println("Launching Url "+sc.getName());
//	}
	
//	@After(order=2)
//	public void tearDownLogOut(Scenario sc)
//	{
//		System.out.println("Logged out application "+sc.getName());
//	}
	
	@Before("@AppLogin")
	public void setUp()
	{
		System.out.println("Setting up browser");
	}
	
	@After("@AppLogin")
	public void tearDown()
	{
		System.out.println("Closing browser");
	}
	
	@Before("@PracticeLogin")
	public void setUpDB()
	{
		System.out.println("Setting up Database");
	}
	
	@BeforeStep()
	public void setupBeforeStep(Scenario sc)
	{
		System.out.println("BeforeStep "+sc.getName());
	}
	
	@AfterStep()
	public void setupAfterStep(Scenario sc)
	{
		System.out.println("AfterStep "+sc.getName());
	}

}
