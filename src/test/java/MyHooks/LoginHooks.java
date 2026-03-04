package MyHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class LoginHooks {
	
	@Before
	public void setUp()
	{
		System.out.println("Setting up browser");
	}
	
	@After
	public void tearDown()
	{
		System.out.println("Closing browser");
	}
	
	@Before("@Smoke")
	public void setUpDB()
	{
		System.out.println("Setting up Database");
	}

}
