package com.shopping.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

	public static WebDriver driver;

	public static ThreadLocal<WebDriver> thrdDriver = new ThreadLocal<>();
	
	
	/**
	 * 
	 * @param browser
	 * @return
	 */

	public WebDriver init_driver(String browser) {

		System.out.println("Browser name is: " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			thrdDriver.set(new ChromeDriver());
		}

		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			thrdDriver.set(new FirefoxDriver());
		} 
		else {
			System.out.println("Browser not available need to add" +browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
		
		
	}
	
	
	public static synchronized WebDriver getDriver() {
		return thrdDriver.get();
		
	}

}
