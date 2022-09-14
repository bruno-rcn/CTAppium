package pages;

import java.util.Set;

import org.openqa.selenium.By;

import appium.core.BasePage;
import appium.core.DriverFactory;

public class WebViewPage extends BasePage {
	
	public void setEmail(String email) {
		DriverFactory.getDriver().findElement(By.id("email")).sendKeys(email);
	}
	
	public void setPassword(String passw) {
		DriverFactory.getDriver().findElement(By.id("senha")).sendKeys(passw);
	}
	
	public void clickBtnLogin() {
		DriverFactory.getDriver().findElement(By.xpath("//button[@type='submit']"));
	}
	
	public void getIntoContextWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
		for(String valor: contextHandles) {
			System.out.println(valor);
		}
		DriverFactory.getDriver().context((String)contextHandles.toArray()[1]);
	}
	
	public void getOutContextWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
		DriverFactory.getDriver().context((String)contextHandles.toArray()[0]);
	}
	
	public void msgSuccess() {
		DriverFactory.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
	}

}
