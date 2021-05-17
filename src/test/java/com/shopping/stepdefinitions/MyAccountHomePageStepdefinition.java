package com.shopping.stepdefinitions;

import com.shopping.factory.Driverfactory;
import com.shopping.pages.LoginPage;
import com.shopping.pages.MyAccountHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class MyAccountHomePageStepdefinition {

	public LoginPage loginpage = new LoginPage(Driverfactory.getDriver());

	private MyAccountHomePage myaccountHomepage;

	@Given("User login into Shopping site")
	public void user_login_into_shopping_site(io.cucumber.datatable.DataTable dataTable) {

		Driverfactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		List<Map<String, String>> credentialslist = dataTable.asMaps();
		String username = credentialslist.get(0).get("username");
		String password = credentialslist.get(0).get("password");
		myaccountHomepage = loginpage.doLogin(username, password);

	}

	@Given("User is on MyAccount details page")
	public void user_is_on_my_account_details_page() {
		
		// Account details
	}

	@When("Account section is available")
	public void account_section_is_available() {
		
	}

	@Then("Options should be available")
	public void options_should_be_available(io.cucumber.datatable.DataTable dataTable) {
		
	}

	@Then("options count should be {int}")
	public void options_count_should_be(Integer actualcountOflinks) {
		System.out.println(myaccountHomepage.getCountofaccountLinks());
		Assert.assertTrue(actualcountOflinks == myaccountHomepage.getCountofaccountLinks());
	}

}
