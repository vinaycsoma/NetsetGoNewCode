package Metadata.ty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Set.ty.ExcelProvider;

public class Ordertype {
	ExcelProvider ex;
	WebDriver driver;
	Actions act;

	public Ordertype(WebDriver driver) {
		this.driver = driver;
	}
	public void Otype() throws IOException
	{
		ex =new ExcelProvider();
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		act = new Actions(driver);
		driver.findElement(By.xpath("//p[normalize-space()='Order Type']")).click();
		driver.findElement(By.id("Description")).sendKeys(ex.getStringData("Ordertype",1, 0));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	    driver.close();



	}
}
