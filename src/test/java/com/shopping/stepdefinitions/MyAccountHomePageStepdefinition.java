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

		System.out.println(myaccountHomepage.gethomepageSection());

	}

	@When("Account section {string} is available")
	public void account_section_is_available(String accountSectionHeading) {
		
		System.out.println("Actual heading: "+accountSectionHeading);
		System.out.println("Expected heading:..."+myaccountHomepage.gethomepageSection());
		Assert.assertTrue(accountSectionHeading.equals(myaccountHomepage.gethomepageSection()));
	}

	@Then("Options should be available")
	public void options_should_be_available(io.cucumber.datatable.DataTable dataTable) {

		List<String> expectedAccountSectOptions = dataTable.asList();

		List<String> actualAccountSectOptions = myaccountHomepage.getMyAccountList();
		
		System.out.println("Expected list is:" +expectedAccountSectOptions);
		System.out.println("Expected list is:" +actualAccountSectOptions);

		// Assert true to compare two array lists containsAll we need to use

		Assert.assertTrue(expectedAccountSectOptions.containsAll(actualAccountSectOptions));

		/*
		 * for (int i = 0; i <= accountSectOptions.size(); i++) { String actuallink =
		 * accountSectOptions.get(i); String expectedlink =
		 * myaccountHomepage.getMyAccountList().get(i);
		 * Assert.assertTrue(actuallink.equals(expectedlink));
		 * 
		 * }
		 */

	}

	@Then("options count should be {int}")
	public void options_count_should_be(Integer actualcountOflinks) {
		System.out.println(myaccountHomepage.getCountofaccountLinks());
		Assert.assertTrue(actualcountOflinks == myaccountHomepage.getCountofaccountLinks());
	}

}
