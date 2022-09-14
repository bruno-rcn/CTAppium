package pages;

import appium.core.BasePage;

public class FormPage extends BasePage {
	
	public void setName() {
		fillInByAccessibilityId("nome", "Bruno");
	}
	
	public void selectComboOption() {
		clickByAccessibilityId("console");
		clickByText("Nintendo Switch");
	}
	
	public String getFieldNameText() {
		return getTextByAccessibilityId("nome");
	}
	
	public String getFieldComboText() {
		return getTextByXpath("//android.widget.Spinner/android.widget.TextView");
	}
	
	public void clickSwitch() {
		clickByClassName("android.widget.Switch");
	}
	
	public String getStatusCheckedSwitch() {
		return getStatusCheckedByClassName("android.widget.Switch");
	}
	
	public void clickCheckbox() {
		clickByAccessibilityId("check");
	}
	
	public String getStatusCheckedCheckbox() {
		return getStatusCheckedByAccessibilityId("check");
	}
	
	public void clickSeekbar() {
		clickSeekBarByAccessibilityId("slid", 0.51);
	}
	
	public String getSeekbarText() {
		return getTextByXpath("//android.widget.TextView[@index='14']");
	}
	
	public void clickBtnSave() {
		clickByText("SALVAR");
	}
	
	public void setData() {
		clickByText("01/01/2000");
		clickByText("2");
		clickByText("OK");
	}
	
	public String getDataText() {
		return getTextByXpath("//android.widget.TextView[@text='2/2/2000']");
	}
	
	public void setTime() {
		clickByText("06:00");
		clickByAccessibilityId("7");
		clickByAccessibilityId("20");
		clickByText("OK");
	}
	
	public String getTimeText() {
		return getTextByXpath("//android.widget.TextView[@text='7:20']");
	}
	
	public void clickBtnClean() {
		clickByText("LIMPAR");
	}

}
