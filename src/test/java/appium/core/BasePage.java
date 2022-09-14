package appium.core;

import static appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
//	-------> Set value text
	
	public void fillInByAccessibilityId(String valueID, String text) {
		getDriver().findElement(MobileBy.AccessibilityId(valueID)).sendKeys(text);
	}
	
	
//	-------> Get value text
	
	public String getTextByAccessibilityId(String valueID) {
		return getDriver().findElement(MobileBy.AccessibilityId(valueID)).getText();
	}
	
	public String getTextByXpath(String valueXpath) {
		return getDriver().findElement(By.xpath(valueXpath)).getText();
	}
	
	public String getTextByID(String valueID) {
		return getDriver().findElement(By.id(valueID)).getText();
	}
	
	
//	-------> list of elements
	public void clickElementOnListByClassName(String valueClass, int index) {
		List<MobileElement> elementsFound = getDriver().findElements(By.className(valueClass));
		elementsFound.get(index).click();
	}
	
	public boolean existElementsOnScreenByText(String text) {
		List<MobileElement> elementsFound = getDriver().findElements(By.xpath("//*[@text='"+text+"']"));
		return elementsFound.size() > 0;
	}
	
	public String[] getList(String valueClass) {
		List<MobileElement> elementsFound = getDriver().findElements(By.className(valueClass));
		String[] result = new String[elementsFound.size()];
		
		for(int i = 0; i < elementsFound.size(); i++) {
			result[i] = elementsFound.get(i).getText();
			System.out.println("\""+result[i]+"\", ");
		}
		return result;
	}
	
//	-------> Get status checked
	public String getStatusCheckedByAccessibilityId(String valueID) {
		return getDriver().findElement(MobileBy.AccessibilityId(valueID)).getAttribute("checked");
	}
	
	public String getStatusCheckedByClassName(String valueClass) {
		return getDriver().findElement(By.className(valueClass)).getAttribute("checked");
	}
	
//	-------> Click
	public void clickByAccessibilityId(String valueID) {
		getDriver().findElement(MobileBy.AccessibilityId(valueID)).click();
	}
	
	public void clickByClassName(String valueClass) {
		getDriver().findElement(By.className(valueClass)).click();
	}
	
	public void clickByText(String text) {
		getDriver().findElement(By.xpath("//*[@text='"+text+"']")).click();
	}
	
	public void clickByID(String valueID) {
		getDriver().findElement(By.id(valueID)).click();
	}
	
	public void tap(int x, int y) {
		new TouchAction<>(getDriver()).tap(PointOption.point(new Point(x, y))).perform();
	}
	
	public void tapBtnMoreSwipeList(String n2) {
		MobileElement teste = getDriver().findElement(By.xpath("//*[@text='"+n2+"']"));
		new TouchAction<>(getDriver())
		.tap(TapOptions.tapOptions().withElement(ElementOption.element(teste, -50, 0)))
		.perform();
	}
	
	public void clickSeekBarByAccessibilityId(String valueID, double position) {
		int delta = 52;
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId(valueID));
		
		int y = seek.getLocation().y + (seek.getSize().height/2);
		
		int x = (int) ((seek.getLocation().x + delta) + ((seek.getSize().width-2*delta)*position));
		
		tap(x, y);
	}
	
	public void longClick(By by) {
		new TouchAction<>(getDriver())
		.longPress(PointOption.point(getDriver().findElement(by).getCenter())).perform();
	}
	
//	-------> scroll / swipe
	
	public void scrollByCoord(double n1, double n2) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		
		int start_y = (int) (size.height * n1);
		int end_y = (int) (size.height * n2);
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(x, start_y)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(x, end_y)))
		.release()
		.perform();
	}
	
	public void swipe(double n1, double n2) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height / 2;
		
		int start_x = (int) (size.width * n1);
		int end_x = (int) (size.width * n2);
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(start_x, y)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(end_x, y)))
		.release()
		.perform();
	}
	

	
	
//	-------> wait
	public void waitPresenceElementByXpath(String valueXpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(valueXpath)));
	}
	
//	-------> drag and drop
	public void dragAndDrop(String origin, String destiny) {
		
		MobileElement start = getDriver().findElement(By.xpath("//*[@text='"+origin+"']"));
		MobileElement end = getDriver().findElement(By.xpath("//*[@text='"+destiny+"']"));
		
		new TouchAction<>(getDriver())
			.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(start)))
			.moveTo(PointOption.point(end.getCenter()))
			.release()
			.perform();		
	}
	

}
