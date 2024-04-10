package event_viewer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Set.ty.ExcelProvider;

public class Reports {
	WebDriver driver;
	ExcelProvider ex;
	public Reports(WebDriver driver) {
		this.driver=driver;
	}
	public void stop1() throws IOException, InterruptedException
	{
		ex= new ExcelProvider();
		driver.findElement(By.xpath("//p[normalize-space()='Reports']")).click();
		//emsname
		String expectedValue1 = ex.getStringData("Reports", 1, 0); 
		WebElement inputfield1=driver.findElement(By.xpath("//input[@ng-reflect-name='reportName']"));
		inputfield1.sendKeys(expectedValue1);
		String actualValue1 = inputfield1.getAttribute("value");
		Assert.assertEquals(actualValue1, expectedValue1, "Entered value is not as expected.");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
}
}
