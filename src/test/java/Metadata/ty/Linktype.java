package Metadata.ty;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Set.ty.Data;
import Set.ty.ExcelProvider;

public class Linktype {
	ExcelProvider ex;
	WebDriver driver;
	public Linktype(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ltype() throws IOException
	{
		ex= new ExcelProvider();
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[normalize-space()='LinkType']")).click();
		driver.findElement(By.id("LinkTypeName")).sendKeys(ex.getStringData("Linktype", 1, 0));
		driver.findElement(By.xpath("//ng-select[@id='bind509']//input[@role='combobox']")).click();
		List<WebElement> band= driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(band, ex.getStringData("Linktype", 1, 1)); 
		driver.findElement(By.xpath("//button[@type='submit']")).click();


	}
}
