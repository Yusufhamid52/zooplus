package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumSetUp {
	
	protected static AppiumDriver driver;
	public AppiumServiceBuilder builder;
	public AppiumDriverLocalService service;
	
	protected void initialiseAppium() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus");
		cap.setCapability("appPackage", "com.example.android.architecture.blueprints.master.mock");
		cap.setCapability("appActivity", "com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability("noReset", "false");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File("C:/Program Files/nodejs/node.exe"));
		builder.withAppiumJS(new File("C:\\Users\\Danzee\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"));
		builder.withIPAddress("0.0.0.0");
//		builder.usingPort(4890);
		builder.usingAnyFreePort();
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
		builder.withLogFile(new File(System.getProperty("user.dir") + "/target/resources/appium_server_logs" + Thread.currentThread().getId()));
		
//		URL url = new URL("http://0.0.0.0/4723/wd/hub");
		
		// Start the server with the builder
				try {
				service = AppiumDriverLocalService.buildService(builder);
				service.start();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				
				System.out.println("Appium URL " + service.getUrl().toString());
		
				driver = new AppiumDriver<MobileElement>(service.getUrl(), cap);
//		driver = new AppiumDriver<MobileElement> (url,cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

}
