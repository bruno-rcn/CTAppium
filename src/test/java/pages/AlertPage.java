package pages;

import appium.core.BasePage;

public class AlertPage extends BasePage {
	
	public void clickBtnAlertConfirm() {
		clickByText("ALERTA CONFIRM");
	}
	
	public String getTextPopUpInfo() {
		return getTextByID("android:id/message");
	}
	
	public String getTextScreenAlerts() {
		return getTextByXpath("//android.widget.TextView[@text='Alerta que pode clicar fora']");
	}
	
	public void clickBtnConfirm() {
		clickByID("android:id/button2");
	}
	
	public void clickBtnExit() {
		clickByText("SAIR");
	}
	
	public void clickSimpleAlert() {
		clickByText("ALERTA SIMPLES");
	}
	
	public void clickBtnOk() {
		clickByText("OK");
	}
	
	public void clickByCoord() {
		try {
			Thread.sleep(1500);
			tap(300, 500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickBtnToDeny() {
		clickByText("NEGAR");
	}

}
