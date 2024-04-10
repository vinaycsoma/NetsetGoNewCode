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

public class Locationtype {
	ExcelProvider ex;
	WebDriver driver;
	Actions act;
	public Locationtype(WebDriver driver)
	{
		this.driver=driver;
	}
	public void locate() throws IOException {
		ex = new ExcelProvider();
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		act = new Actions(driver);
		driver.findElement(By.xpath("//p[normalize-space()='Location Type']")).click();
		driver.findElement(By.id("LocationTypeName")).sendKeys(ex.getStringData("Locationtype", 1, 0));
		
		driver.findElement(By.xpath("//ng-select[@id='bind504']//input[@role='combobox']")).click();
		List<WebElement> drop1=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		
		Data.dropdown(drop1, ex.getStringData("device", 1, 1));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
