package Metadata.ty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Set.ty.ExcelProvider;

public class Order {
	WebDriver driver;
	ExcelProvider ex;
	public Order(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void order1() throws IOException
	{
		ex= new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Order']")).click();
		driver.findElement(By.id("Description")).sendKeys(ex.getStringData("Order", 1, 0));
		
		driver.findElement(By.id("OrderNo")).sendKeys(ex.getStringData("Order", 1, 1));
		
		WebElement port = driver.findElement(By.xpath("//select[@id='bind650']"));
		Select select = new Select(port);
		select.selectByVisibleText(ex.getStringData("Order", 1, 2));
		
		WebElement dateBox = driver.findElement(By.id("RollOutDate"));
		dateBox.sendKeys("09052013");
		dateBox.sendKeys(Keys.TAB);
		dateBox.sendKeys("0245PM");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}
}
