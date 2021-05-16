package appHooks;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.shopping.factory.Driverfactory;
import com.shopping.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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

}
