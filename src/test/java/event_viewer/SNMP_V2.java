package event_viewer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Set.ty.ExcelProvider;

public class SNMP_V2 {
WebDriver driver;
ExcelProvider ex;

public SNMP_V2(WebDriver driver) {
	this.driver=driver;
}
public void simple() throws IOException, InterruptedException
{
	ex = new ExcelProvider();
	driver.findElement(By.xpath("//p[normalize-space()='SNMP V2']")).click();
	

	String expectedValue2 = ex.getStringData("SNMPV2", 1, 0); 
	WebElement inputfield2=driver.findElement(By.xpath("//input[@ng-reflect-name='emsname']"));
	inputfield2.sendKeys(expectedValue2);
	String actualValue2 = inputfield2.getAttribute("value");
	Assert.assertEquals(actualValue2, expectedValue2, "Entered value is not as expected.");
	
	String expectedValue3 = ex.getStringData("SNMPV2", 1, 1); 
	WebElement inputfield3=driver.findElement(By.xpath("//input[@ng-reflect-name='port']"));
	inputfield3.sendKeys(expectedValue3);
	String actualValue3 = inputfield3.getAttribute("value");
	Assert.assertEquals(actualValue3, expectedValue3, "Entered value is not as expected.");
	
	String expectedValue4 = ex.getStringData("SNMPV2", 1, 2); 
	WebElement inputfield4=driver.findElement(By.xpath("//input[@ng-reflect-name='communitystring']"));
	inputfield4.sendKeys(expectedValue4);
	String actualValue4 = inputfield4.getAttribute("value");
	Assert.assertEquals(actualValue4, expectedValue4, "Entered value is not as expected.");
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);
	
}
}
