package tests;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

import appium.core.BaseTest;
import pages.DragAndDropPage;
import pages.MenuPage;

public class DrgaAndDropTest extends BaseTest {
	
	private String[] initialStatus = new String[] {"Esta", 
			"é uma lista", 
			"Drag em Drop!", 
			"Faça um clique longo,", 
			"e arraste para", 
			"qualquer local desejado."};
	
	private String[] intermediateStatus = new String[] { 
			"é uma lista", 
			"Drag em Drop!", 
			"Faça um clique longo,", 
			"e arraste para", 
			"Esta",
			"qualquer local desejado."};
	
	private String[] finalStatus = new String[] { 
			"Faça um clique longo,",
			"é uma lista", 
			"Drag em Drop!", 
			"e arraste para", 
			"Esta",
			"qualquer local desejado."};
	
	private MenuPage menuPage = new MenuPage();
	private DragAndDropPage dragAndDrop = new DragAndDropPage();
	
	@SuppressWarnings("deprecation")
	@Test
	public void dragAndDrop() throws MalformedURLException, InterruptedException {
		menuPage.accessDragAndDrop();
		Thread.sleep(1100);
		dragAndDrop.getList("android.widget.TextView");
		Assert.assertEquals(initialStatus, dragAndDrop.getList("android.widget.TextView"));
		dragAndDrop.dragAndDrop("Esta", "e arraste para");
		Assert.assertEquals(intermediateStatus, dragAndDrop.getList("android.widget.TextView"));
		dragAndDrop.dragAndDrop("Faça um clique longo,", "é uma lista");
		Assert.assertEquals(finalStatus, dragAndDrop.getList("android.widget.TextView"));
	}
}
