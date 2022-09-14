package appium.core;

import static appium.core.DriverFactory.getDriver;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;

public class BaseTest {
	
	@AfterClass
	public static void killDriver() {
		DriverFactory.killDriver();
	}
	
	@After
	public void resetApp() {
		takeScreenShot();
	}
	
	@Rule
	public TestName testName = new TestName();

	public void takeScreenShot() {
		try {
			File image = ((File) getDriver().getScreenshotAs(OutputType.FILE));
			FileUtils.copyFile(image, new File("target/screenshot/"+testName.getMethodName()+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
