package com.qa.stepdefs;

import java.io.IOException;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	 @Before
	    public void initialize() throws Exception {
	        GlobalParams params = new GlobalParams();
	        params.initializeGlobalParams();
	       
	        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
	                + params.getDeviceName());
	      System.out.println("Goinf to start server");
	        new ServerManager().startServer();

	        new DriverManager().initializeDriver();
//	     //   new VideoManager().startRecording();
	    }

	    @After
	    public void quit(Scenario scenario) throws IOException {
	        if(scenario.isFailed()){
	      //     byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
	      //   scenario.attach(screenshot, "image/png", scenario.getName());	        
	        }
	        	
	    
	      //  new VideoManager().stopRecording(scenario.getName());
	     
	    	DriverManager driverManager = new DriverManager();
	        if(driverManager.getDriver() != null){
	            driverManager.getDriver().quit();
	            driverManager.setDriver(null);
	        }
	        ServerManager serverManager = new ServerManager();
	        if(serverManager.getServer() != null){
	            serverManager.getServer().stop();
	        }
	    }
	}

