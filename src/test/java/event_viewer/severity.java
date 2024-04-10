package event_viewer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Set.ty.ExcelProvider;

public class severity {
	WebDriver driver;
	ExcelProvider ex;
	public severity(WebDriver driver) {

		this.driver = driver;
	}
	public void Test() throws IOException, InterruptedException
	{
		ex= new ExcelProvider();
		driver.findElement(By.xpath("//p[normalize-space()='Severity']")).click();
		
		
		String expectedValue1 = ex.getStringData("Severity", 1, 0); 
		WebElement inputfield1=driver.findElement(By.xpath("//input[@ng-reflect-name='severityName']"));
		inputfield1.sendKeys(expectedValue1);
		String actualValue1 = inputfield1.getAttribute("value");
		Assert.assertEquals(actualValue1, expectedValue1, "Entered value is not as expected.");
		
		String expectedValue2 = ex.getStringData("Severity", 1, 1); 
		WebElement inputfield2=driver.findElement(By.xpath("//input[@ng-reflect-name='severityDesc']"));
		inputfield2.sendKeys(expectedValue2);
		String actualValue2 = inputfield2.getAttribute("value");
		Assert.assertEquals(actualValue2, expectedValue2, "Entered value is not as expected.");
		
		WebElement dropdown11=driver.findElement(By.xpath("//select[@id='bind239']"));
		Select select11= new Select(dropdown11);
		String expect = ex.getStringData("Severity", 1, 2);
		select11.selectByVisibleText(expect);
		String selectedOption11 = select11.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOption11, expect, "Selected option is not as expected.");
		
		
		String expectedValue3 = ex.getStringData("Severity", 1, 3); 
		WebElement inputfield3=driver.findElement(By.xpath("//input[@ng-reflect-name='priority']"));
		inputfield3.sendKeys(expectedValue3);
		String actualValue3 = inputfield3.getAttribute("value");
		Assert.assertEquals(actualValue3, expectedValue3, "Entered value is not as expected.");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
}
}