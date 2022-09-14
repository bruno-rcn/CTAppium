package tests;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import appium.core.BaseTest;
import pages.AlertPage;
import pages.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private AlertPage alertPage = new AlertPage();
	
	@Before
	public void menuForm() {
		menuPage.accessMenuAlert();
	}
	
	@Test
	public void alertConfirm() throws MalformedURLException {
		alertPage.clickBtnAlertConfirm();
		Assert.assertEquals("Confirma a operação?", alertPage.getTextPopUpInfo());
		alertPage.clickBtnConfirm();
		alertPage.clickBtnExit();
		Assert.assertEquals("Alerta que pode clicar fora", alertPage.getTextScreenAlerts());
	}
	
	@Test
	public void alertDenied() throws MalformedURLException {
		alertPage.clickBtnAlertConfirm();
		Assert.assertEquals("Confirma a operação?", alertPage.getTextPopUpInfo());
		alertPage.clickBtnToDeny();
		alertPage.clickBtnExit();
		Assert.assertEquals("Alerta que pode clicar fora", alertPage.getTextScreenAlerts());
	}
	
	@Test
	public void alertSimple() throws MalformedURLException {
		alertPage.clickSimpleAlert();
		Assert.assertEquals("Pode clicar no OK ou fora da caixa para sair", alertPage.getTextPopUpInfo());
		alertPage.clickBtnOk();
		Assert.assertEquals("Alerta que pode clicar fora", alertPage.getTextScreenAlerts());
	}

}
