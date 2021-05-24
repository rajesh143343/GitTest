package appHooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.shopping.factory.Driverfactory;
import com.shopping.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private ConfigReader configReader;
	Properties prop;
	private Driverfactory driverfactory;
	private WebDriver driver;

	@Before(order = 0)
	public void getProperty() throws FileNotFoundException {

		configReader = new ConfigReader();
		prop = configReader.init_prop();

	}

	@Before(order = 1)
	public void launchBrowser() {

		String browserName = prop.getProperty("browser");
		driverfactory = new Driverfactory();

		driver = driverfactory.init_driver(browserName);

	}

	@After(order = 0)
	public void browserclose() {
		driver.quit();

	}
	
	// for @After order 1 will be executed first and order 0 will be executed next in case of 
	//@Before order 0 will execute first and order 1 will excute next
	@After(order=1)
	public void screenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			
				
			byte[] srcPath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(srcPath, "image/png", screenshotname);
		}
	}

}
