package pages;

import appium.core.BasePage;

public class MenuPage extends BasePage {
	
	public void accessMenuForm() {
		clickElementOnListByClassName("android.widget.TextView", 1);
	}
	
	public void accessMenuSplash() {
		clickByText("Splash");
	}
	
	public void accessMenuAlert() {
		clickElementOnListByClassName("android.widget.TextView", 4);
	}
	
	public void accessDragAndDrop() {
		waitPresenceElementByXpath("//*[@text='Formulário']");
		scrollByCoord(0.9, 0.1);
		clickByText("Drag and drop");
	}
	
	public void accessSBHybrid() {
		clickByText("SeuBarriga Híbrido");
	}

}
