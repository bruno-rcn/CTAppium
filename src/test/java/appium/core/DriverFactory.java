package appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;
	

	private static void creatDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("noReset", true);
		caps.setCapability(MobileCapabilityType.APP, "C:\\Projects - Udemy Java\\AppiumJavaAndroid\\src\\test\\resources\\app\\CTAppium_1_2.apk");
	
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	private static void creatDriverSaucelabs() {
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:app", "storage:filename=CTAppium_2_0.apk");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("deviceName","Samsung Galaxy S9 Plus FHD GoogleAPI Emulator");
		caps.setCapability("platformVersion","8.1");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", "SAUCE_USERNAME");
		sauceOptions.setCapability("accessKey", "SAUCE_ACCESS_KEY");
		caps.setCapability("sauce:options", sauceOptions);
	
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://us1.appium.testobject.com/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
//			creatDriver();
			creatDriverSaucelabs();
		}
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
}
