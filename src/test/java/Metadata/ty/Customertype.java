package Metadata.ty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Set.ty.ExcelProvider;

public class Customertype {
	ExcelProvider ex;
	WebDriver driver;
	public Customertype(WebDriver driver)
	{
		this.driver=driver;
	}
	public void custype() throws IOException	
	{
		ex= new ExcelProvider();
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[normalize-space()='Customer Type']")).click();
		driver.findElement(By.id("CustomerTypeName")).sendKeys(ex.getStringData("Customertype", 1, 0));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
