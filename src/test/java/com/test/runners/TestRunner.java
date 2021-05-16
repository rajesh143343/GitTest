package com.test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = { "F:\\eclipse-workspace\\SHOPPINGTEST\\src\\test\\resources\\com\\shopping\\features"}
 ,glue={"com.shopping.stepdefinitions", "appHooks"}
 ,plugin= {"pretty",
 			"json:target/MyReports/report.json",
 			"junit:target/MyReports/report.xml"},
		 publish = true,
		 monochrome= true  
 )

public class TestRunner {
	

}
