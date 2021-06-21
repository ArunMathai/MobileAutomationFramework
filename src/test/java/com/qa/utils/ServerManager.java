package com.qa.utils;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerManager {
	private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
	TestUtils utils = new TestUtils();
	private DesiredCapabilities cap;

	public AppiumDriverLocalService getServer(){
		return server.get();
	}

	//Starting Appium server
	public void startServer(){
		utils.log().info("starting appium server");

		//  AppiumDriverLocalService server = WindowsGetAppiumService();
		AppiumDriverLocalService server = MacGetAppiumService();
		server.start();
		if(server == null || !server.isRunning()){
			utils.log().fatal("Appium server not started. ABORT!!!");
			System.out.println("server not started");
			throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
		}

		//clearing server logs from console
		server.clearOutPutStreams();
		this.server.set(server);
		utils.log().info("Appium server started");
	}

	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}


	public AppiumDriverLocalService WindowsGetAppiumService() {
		GlobalParams params = new GlobalParams();
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingAnyFreePort()
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withLogFile(new File(params.getPlatformName() + "_"
						+ params.getDeviceName() + File.separator + "Server.log")));
	}

	public AppiumDriverLocalService MacGetAppiumService() {
		GlobalParams params = new GlobalParams();
		HashMap<String, String> environment = new HashMap<String, String>();

		environment.put("PATH", " /Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin:/Users/arun.mathai/Library/Android/sdk/tools:/Users/arun.mathai/Library/Android/sdk/platforms-tools:/Users/arun.mathai/Library/Android/sdk/build-tools/28.0.3:/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home" + System.getenv("PATH"));
		environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home");
		environment.put("ANDROID_HOME", "/Users/arun.mathai/Library/Android/sdk");

		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1")
				.usingAnyFreePort()
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withEnvironment(environment)
				.withLogFile(new File(params.getPlatformName() + "_"
						+ params.getDeviceName() + File.separator + "Server.log")));	    }

}
