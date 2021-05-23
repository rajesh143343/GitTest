package com.shopping.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountHomePage {

	private WebDriver driver;
	private List<WebElement> accountsectionslinkslist;
	private By accountsectionlinks = By.xpath(("(//div[@class='row addresses-lists'])//span"));
	private By accountsecHeading = By.className("page-heading");

	/*
	 * Constructor
	 */
	public MyAccountHomePage(WebDriver driver) {
		this.driver = driver;
	}
	



	public int getCountofaccountLinks() {

		return driver.findElements(accountsectionlinks).size();

	}
	
	public String gethomepageSection() {
		String accSecHeading = driver.findElement(accountsecHeading).getText();
		return accSecHeading;
		
	}
	

	public ArrayList<String> getMyAccountList() {
		
		ArrayList<String> listoflinks = new ArrayList<>();
		accountsectionslinkslist=driver.findElements(accountsectionlinks);
		for(WebElement e: accountsectionslinkslist ) {
			String linkname = e.getText();
			listoflinks.add(linkname);
		}
		
		return listoflinks;
		
		}

	

}
