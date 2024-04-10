package event_viewer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Set.ty.ExcelProvider;

public class SNMP {
	WebDriver driver;
	ExcelProvider ex;
	
	public SNMP(WebDriver driver)
	{
		this.driver=driver;
	}
	public void create() throws IOException, InterruptedException
	{
		ex = new ExcelProvider();
		driver.findElement(By.xpath("//p[normalize-space()='SNMP V1']")).click();
		
		String value=ex.getStringData("SNMP", 1, 0);
		WebElement input=driver.findElement(By.xpath("//input[@ng-reflect-name='emsname']"));
		input.sendKeys(value);
		String actual=input.getAttribute("value");
		Assert.assertEquals(actual, value, "Entered value is not as expected.");

		String value1=ex.getStringData("SNMP", 1, 1);
		WebElement input1=driver.findElement(By.xpath("//input[@ng-reflect-name='port']"));
		input1.sendKeys(value1);
		String actual1=input1.getAttribute("value");
		Assert.assertEquals(actual1, value1, "Entered value is not as expected.");
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}

}
