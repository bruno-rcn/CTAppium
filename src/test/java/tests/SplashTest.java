package tests;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

import appium.core.BaseTest;
import pages.MenuPage;
import pages.SplashPage;

public class SplashTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private SplashPage splashPage = new SplashPage();
	
	@Test
	public void splash() throws MalformedURLException {
		menuPage.accessMenuSplash();
		Assert.assertTrue(splashPage.isSplashExist());		
	}

}
