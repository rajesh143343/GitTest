package com.shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	/**
	 * Note in Page class we will be having selenium code ex By locators, and methods for the feature file
	 * Note assertions will not be available inpage file those will be available only in step definition file
	 */
	private WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
		private By emailid = By.id("email");
	
		private By passwrd = By.id("passwd");
		
		private By signinbutton = By.id("SubmitLogin");
		
		private By forgotpassword = By.linkText("Forgot your password?");
		
		
			
		
		
		public String getPageTitle() {
			return driver.getTitle();
		}
		
		public void enterUsername(String username) {
			driver.findElement(emailid).sendKeys(username);
			
		}
		
		
		public void enterPassword(String password) {
			driver.findElement(passwrd).sendKeys(password);
			
		}
		
		
		public void clickonSubmit() {
			driver.findElement(signinbutton).click();
		}
		
		
		/*
		 * As per page object model concept if current page is navigate to next page 
		 * The method of current page should return the object of next page
		 * this is the page chaining concept 
		 */
		public MyAccountHomePage doLogin(String uname, String pswd) {
			
			driver.findElement(emailid).sendKeys(uname);
			driver.findElement(passwrd).sendKeys(pswd);
			driver.findElement(signinbutton).click();
			return new MyAccountHomePage(driver);
			
			
		}
		
	
		
}
