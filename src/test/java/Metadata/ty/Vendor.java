package Metadata.ty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Set.ty.ExcelProvider;

public class Vendor {
	WebDriver driver;
	ExcelProvider ex;
	public Vendor(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void vtype() throws IOException
	{
		ex =new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Vendor']")).click();
		driver.findElement(By.id("VendorName")).sendKeys(ex.getStringData("Vendor", 1, 0));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
}
