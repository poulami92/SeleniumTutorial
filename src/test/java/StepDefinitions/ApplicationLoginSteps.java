package StepDefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationLoginSteps {
	
	@Given("User is on NetBanking landing page")
	public void user_is_on_net_banking_landing_page() {
	   System.out.println("user landed on net banking page");
	}
	
	@When("User logged in to banking application with {string} and password {string}")
	public void user_logged_in_to_banking_application(String username,String password) {
		System.out.println("Username: "+username+" and Password: "+password);
	}
	
	@Then("Home Page is displayed")
	public void home_page_is_displayed() {
		System.out.println("home page is displayed");
	}
	
	@Then("Cards are displayed")
	public void cards_are_displayed() {
		System.out.println("cards are displayed");
	}
	
	@Given("User is on Practice landing page")
	public void user_is_on_practice_landing_page() {
		System.out.println("user is on practice page");
	}
	
	@When("User Signup into application")
	public void user_signup_into_application(DataTable dataTable) {
		
		List<Map<String,String>> data= dataTable.asMaps();
	    
		System.out.println("FirstName: "+data.get(0).get("FirstName"));
		System.out.println("LastName: "+data.get(0).get("LastName"));
		System.out.println("Email: "+data.get(0).get("Email"));
		System.out.println("PhoneNo: "+data.get(0).get("PhoneNo"));
	    
	}
	
	@Given("setup database entries")
	public void setup_database_entries() {
		System.out.println("setup database entries");
	}
	
	@Given("User launch browser")
	public void user_launch_browser() {
		System.out.println("launch browser");
	}
	
	@Given("Hit banking home page url")
	public void hit_banking_home_page_url() {
		System.out.println("banking home page url");
	}

}
