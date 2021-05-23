package com.test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"F:\\eclipse-workspace\\SHOPPINGTEST\\src\\test\\resources\\com\\shopping\\features" },
			glue = {"com.shopping.stepdefinitions", "appHooks" }
			,plugin= {"pretty",
					"json:target/MyReports/report.json",
					"junit:target/MyReports/report.xml",
		 			"html:target/cucumber-html-report",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},// this is the extend plugin that we need for extend report refer pom.xml that plug is confi
			publish = true, 
			monochrome = true)

public class TestRunner {

}
