package event_viewer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Set.ty.ExcelProvider;

public class SNMP_V3 {
	WebDriver driver;
	ExcelProvider ex;

	public SNMP_V3(WebDriver driver) {
		this.driver=driver;
	}
	public void Hash() throws IOException, InterruptedException
	{
		ex = new ExcelProvider();
		driver.findElement(By.xpath("//p[normalize-space()='SNMP V3']")).click();
		

		String expectedValue2 = ex.getStringData("SNMPV3", 1, 0); 
		WebElement inputfield2=driver.findElement(By.xpath("//input[@ng-reflect-name='securityName']"));
		inputfield2.sendKeys(expectedValue2);
		String actualValue2 = inputfield2.getAttribute("value");
		Assert.assertEquals(actualValue2, expectedValue2, "Entered value is not as expected.");
		
		String expectedValue3 = ex.getStringData("SNMPV3", 1, 1); 
		WebElement inputfield3=driver.findElement(By.xpath("//input[@ng-reflect-name='AuthPassword']"));
		inputfield3.sendKeys(expectedValue3);
		String actualValue3 = inputfield3.getAttribute("value");
		Assert.assertEquals(actualValue3, expectedValue3, "Entered value is not as expected.");
		
		String expectedValue4 = ex.getStringData("SNMPV3", 1, 2); 
		WebElement inputfield4=driver.findElement(By.xpath("//input[@ng-reflect-name='PrivPassword']"));
		inputfield4.sendKeys(expectedValue4);
		String actualValue4 = inputfield4.getAttribute("value");
		Assert.assertEquals(actualValue4, expectedValue4, "Entered value is not as expected.");
		
		String expectedValue5 = ex.getStringData("SNMPV3", 1, 3); 
		WebElement inputfield5=driver.findElement(By.xpath("//input[@ng-reflect-name='emsname']"));
		inputfield5.sendKeys(expectedValue5);
		String actualValue5 = inputfield5.getAttribute("value");
		Assert.assertEquals(actualValue5, expectedValue5, "Entered value is not as expected.");
		
		String expectedValue6 = ex.getStringData("SNMPV3", 1, 4); 
		WebElement inputfield6=driver.findElement(By.xpath("//input[@ng-reflect-name='port']"));
		inputfield6.sendKeys(expectedValue6);
		String actualValue6 = inputfield6.getAttribute("value");
		Assert.assertEquals(actualValue6, expectedValue6, "Entered value is not as expected.");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
	}
}