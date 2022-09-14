package tests;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Test;

import appium.core.BaseTest;
import pages.MenuPage;
import pages.WebViewPage;

public class WebViewTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private WebViewPage webViewPage = new WebViewPage();
	
	@Test
	public void webView() throws MalformedURLException, InterruptedException {
		menuPage.accessSBHybrid();
		Thread.sleep(3000);
		webViewPage.getIntoContextWeb();
		webViewPage.setEmail("bruno@udemy.com");
		webViewPage.setPassword("123");
		webViewPage.clickBtnLogin();
		
	}
	
	@After
	public void exitContextWeb() {
		webViewPage.getOutContextWeb();
	}

}
