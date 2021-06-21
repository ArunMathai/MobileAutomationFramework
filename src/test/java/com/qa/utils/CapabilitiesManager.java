package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilitiesManager {
	TestUtils utils = new TestUtils();

	public DesiredCapabilities getCaps() throws IOException {
		GlobalParams params = new GlobalParams();
		Properties props = new PropertyManager().getProps();

		try{
			utils.log().info("getting capabilities");
			//			DesiredCapabilities caps = new DesiredCapabilities();
			//			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
			//			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, params.getPlatformVersion());
			//			caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
			//			caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, params.getPlatformVersion());
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, params.getAutomationName());
			caps.setCapability(MobileCapabilityType.UDID, params.getUDID());


			switch(params.getPlatformName()){
			case "Android":
				// caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));

				//caps.setCapability("automationName", props.getProperty("androidAutomationName"));
				caps.setCapability("chromedriverExecutable", "/Users/arun.mathai/Desktop/Softwares/ChromeDrivers/chromedriver_84");

				caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
				caps.setCapability("appActivity", props.getProperty("androidAppActivity"));

				caps.setCapability("noReset", true);
				//	caps.setCapability("fullReset", true);

				caps.setCapability("systemPort", params.getSystemPort());
				caps.setCapability("chromeDriverPort", params.getChromeDriverPort());

				String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "java" + File.separator + "app" + File.separator + "nectar-preprod.apk";

				utils.log().info("appUrl is" + androidAppUrl);
				caps.setCapability("app", androidAppUrl);

				break;
			case "iOS":
			//	caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));

				String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "java" + File.separator + "app" + File.separator + "Nectar.app";

				utils.log().info("appUrl is" + iOSAppUrl);
				caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
				caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
				caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
				caps.setCapability("noReset", true);
				caps.setCapability("autoGrantPermissions", true);

				//	caps.setCapability("autoDismissAlerts", true);
				caps.setCapability("app", iOSAppUrl);
				break;
			}
			return caps;
		} catch(Exception e){
			e.printStackTrace();
			utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
			throw e;
		}
	}
}
