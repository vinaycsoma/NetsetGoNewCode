package event_viewer;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import Set.ty.Data;
import Set.ty.ExcelProvider;

public class Device {
	WebDriver driver;
	ExcelProvider ex;
	public Device(WebDriver driver) {
		this.driver=driver;
	}
	public void stop() throws IOException, InterruptedException
	{
		ex= new ExcelProvider();
		driver.findElement(By.xpath("//p[normalize-space()='Device Group']")).click();
		//emsname
		String expectedValue1 = ex.getStringData("Device_Group", 1, 0); 
		WebElement inputfield1=driver.findElement(By.xpath("//input[@ng-reflect-name='groupName']"));
		inputfield1.sendKeys(expectedValue1);
		String actualValue1 = inputfield1.getAttribute("value");
		Assert.assertEquals(actualValue1, expectedValue1, "Entered value is not as expected.");
		


        WebElement pagegruop = driver.findElement(By.xpath("//ng-multiselect-dropdown[@ng-reflect-name='DeviceIDs']"));
		pagegruop.click();
		Assert.assertTrue(pagegruop.isDisplayed());//web element is visible or not on the web page
		driver.findElement(By.xpath("//div[normalize-space()='Device 1']"));
//		String expectedData=ex.getStringData("Device_Group", 1, 1);
//		Assert.assertTrue(Data.dropdown(page, expectedData), "Expected data is not present in the dropdown options.");

	}
}
