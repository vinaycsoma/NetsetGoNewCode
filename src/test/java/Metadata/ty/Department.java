package Metadata.ty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Set.ty.ExcelProvider;

public class Department {
	ExcelProvider ex;
	WebDriver driver;
	Actions act;
	public Department(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Dtype() throws IOException, InterruptedException
	{
		ex = new ExcelProvider();
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		act = new Actions(driver);
		driver.findElement(By.xpath("//p[normalize-space()='Department']")).click();
		driver.findElement(By.id("name")).sendKeys(ex.getStringData("department", 1, 0));
		driver.findElement(By.cssSelector("button[type='submit']")).click();

}
}
