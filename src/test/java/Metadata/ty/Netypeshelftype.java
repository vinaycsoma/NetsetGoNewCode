package Metadata.ty;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Set.ty.Data;
import Set.ty.ExcelProvider;

public class Netypeshelftype {
	WebDriver driver;
	ExcelProvider ex;
	public Netypeshelftype(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void neshtype() throws IOException
	{
		ex= new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		//ng-select[@id='bind557']//input[@role='combobox']
		driver.findElement(By.xpath("//p[normalize-space()='NeType ShelfType']")).click();
		driver.findElement(By.xpath("//ng-select[@id='bind557']//input[@role='combobox']")).click();
		List<WebElement> netype=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(netype,ex.getStringData("NetypeShelftype", 1, 0));
		
		driver.findElement(By.xpath("//ng-select[@ng-reflect-name='ShelfTypeID']//input[@role='combobox']")).click();
		List<WebElement> netype1=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(netype1,ex.getStringData("NetypeShelftype", 1, 1));
		
		driver.findElement(By.xpath("//input[@id='DefaultShelf']")).sendKeys(ex.getStringData("NetypeShelftype", 1, 2));
		driver.findElement(By.xpath("//input[@id='ShelfNumber']")).sendKeys(ex.getStringData("NetypeShelftype", 1, 3));
		driver.findElement(By.xpath("//input[@id='count']")).sendKeys(ex.getStringData("NetypeShelftype", 1, 4));
		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}
}
