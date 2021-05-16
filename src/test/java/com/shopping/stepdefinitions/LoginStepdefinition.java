package com.shopping.stepdefinitions;

import com.shopping.factory.Driverfactory;
import com.shopping.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepdefinition {

	private LoginPage loginpage = new LoginPage(Driverfactory.getDriver());

	private String loginpagetitle;



	@Given("User is on Login page")
	public void user_is_on_login_page() {

		Driverfactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

	}

	@When("User gets page title")
	public void user_gets_page_title() {

		loginpagetitle = loginpage.getPageTitle();
		System.out.println("page title is" + loginpagetitle);

	}

	@When("Title should be {string}")
	public void title_should_be(String expectedTitle) {

		Assert.assertTrue(loginpagetitle.equalsIgnoreCase(expectedTitle));

	}

	@When("User enters the username as {string}")
	public void user_enters_the_username_as(String username) {
		loginpage.enterUsername(username);

	}

	@When("User enters the password as {string}")
	public void user_enters_the_password_as(String password) {
		loginpage.enterPassword(password);

	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickonSubmit();

	}

	@Then("Title of the home page should be {string}")
	public void title_of_the_home_page_should_be(String homepagetitle) {
		System.out.println("Home page title is " + loginpage.getPageTitle());
		Assert.assertTrue(homepagetitle.equals(loginpage.getPageTitle()));

	}
	
	

}
