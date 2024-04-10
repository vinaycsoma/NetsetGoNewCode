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

public class Netypeporttype {
	WebDriver driver;
	ExcelProvider ex;
	public Netypeporttype(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void neprtype() throws IOException
	{
		ex= new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='NeType PortType']")).click();
		driver.findElement(By.xpath("//ng-select[@id='bind537']//input[@role='combobox']")).click();
		List<WebElement> netype=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(netype,ex.getStringData("NetypePorttype", 1, 0));
		
		WebElement port = driver.findElement(By.xpath("//select[@id='bind604']"));
		Select select = new Select(port);
		select.selectByVisibleText(ex.getStringData("NetypePorttype", 1, 1));
		

		driver.findElement(By.xpath("//ng-select[@ng-reflect-name='PortTypeID']//input[@role='combobox']")).click();
		List<WebElement> netype1=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(netype1,ex.getStringData("NetypePorttype", 1, 2));
		
		driver.findElement(By.xpath("//input[@id='count']")).sendKeys(ex.getStringData("NetypePorttype", 1, 3));
		driver.findElement(By.xpath("//input[@id='PortNumber']")).sendKeys(ex.getStringData("NetypePorttype", 1, 4));
		driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(ex.getStringData("NetypePorttype", 1, 5));
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		
}

}