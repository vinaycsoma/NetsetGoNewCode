package Metadata.ty;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Set.ty.Data;
import Set.ty.ExcelProvider;

public class Customer {
	WebDriver driver;
	ExcelProvider ex;
	public Customer(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void cust() throws IOException
	{
		ex= new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Customer']")).click();

		WebElement port = driver.findElement(By.xpath("//select[@id='bind657']"));
		Select select = new Select(port);
		select.selectByVisibleText(ex.getStringData("Customer1", 1, 0));

		driver.findElement(By.id("CustomerName")).sendKeys(ex.getStringData("Customer1", 1, 1));
		driver.findElement(By.id("Description")).sendKeys(ex.getStringData("Customer1", 1, 2));
		driver.findElement(By.cssSelector("button[type='submit']")).click();


	}


}
