package tests;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import appium.core.BaseTest;
import pages.FormPage;
import pages.MenuPage;


public class FormTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private FormPage formPage = new FormPage();
	
	@Before
	public void menuForm() {
		menuPage.accessMenuForm();
	}
	
	@Test
	public void name() throws MalformedURLException {
		formPage.setName();
		Assert.assertEquals("Bruno", formPage.getFieldNameText());			
	}

	@Test
	public void comboBox() throws MalformedURLException {	
		formPage.selectComboOption();
		Assert.assertEquals("Nintendo Switch", formPage.getFieldComboText());
	}
	
	@Test
	public void switchCheckbox () throws MalformedURLException {
		Assert.assertTrue(formPage.getStatusCheckedCheckbox().equals("false"));
		Assert.assertTrue(formPage.getStatusCheckedSwitch().equals("true"));
		formPage.clickSwitch();
		formPage.clickCheckbox();
		Assert.assertFalse(formPage.getStatusCheckedCheckbox().equals("false"));
		Assert.assertFalse(formPage.getStatusCheckedSwitch().equals("true"));
	}
	
	@Test
	public void seekBar() throws MalformedURLException {	
		formPage.clickSeekbar();
		formPage.clickBtnSave();
		Assert.assertEquals("Slider: 51", formPage.getSeekbarText());
	}
	
	@Test
	public void data() throws MalformedURLException {	
		formPage.setData();
		Assert.assertEquals("2/2/2000", formPage.getDataText());
	}
	
	@Test
	public void time() throws MalformedURLException {	
		formPage.setTime();
		Assert.assertEquals("7:20", formPage.getTimeText());
	}
	
	@Test
	public void clean() throws MalformedURLException {	
		formPage.setName();
		formPage.clickBtnClean();
		Assert.assertEquals("Nome", formPage.getFieldNameText());
	}
	
}
