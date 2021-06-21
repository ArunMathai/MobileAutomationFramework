package com.qa.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"
				, "html:target/cucumber"
				,"json:target/cucumber.json"
				, "summary"
				, "de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"}
		,features = {"src/test/java/resources"}
		,glue = {"com.qa.stepdefs"}
		,snippets = CAMELCASE
				,dryRun=false
				,monochrome=true
				,tags = "@RegressionSuite"
		)

//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features = {"src/test/java/resources"}
//		,glue = {"com.qa.stepdefs"}
//    ,monochrome = true
//    ,plugin = {"json:target/cucumber-report/cucumber.json"}
//		,tags = "@Regression"
//)






public class MyRunnerTest {

//	@BeforeClass
//	public static void initialize() throws Exception {
//		GlobalParams params = new GlobalParams();
//		params.initializeGlobalParams();
//
//		ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
//				+ params.getDeviceName());
//
//		new ServerManager().startServer();
//		new DriverManager().initializeDriver();
//	}
//
//	@AfterClass
//	public static void quit(){
//		DriverManager driverManager = new DriverManager();
//		if(driverManager.getDriver() != null){
//			driverManager.getDriver().quit();
//			driverManager.setDriver(null);
//		}
//		ServerManager serverManager = new ServerManager();
//		if(serverManager.getServer() != null)
//		{
//			serverManager.getServer().stop();
//		}
//	}
}
