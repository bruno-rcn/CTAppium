package pages;

import appium.core.BasePage;

public class SplashPage extends BasePage {
	
	public boolean isSplashExist() {
		return existElementsOnScreenByText("Splash!");
	}

}
