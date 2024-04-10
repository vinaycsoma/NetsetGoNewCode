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

public class Shelftypenetype {
	WebDriver driver;
	ExcelProvider ex;
	public Shelftypenetype(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void shnetype() throws IOException
	{
		ex= new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='ShelfType SlotType']")).click();
		driver.findElement(By.xpath("//ng-select[@id='bind257']//input[@role='combobox']")).click();
		List<WebElement> netype=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(netype,ex.getStringData("ShelftypeNetype", 1, 0));
		
		WebElement slot = driver.findElement(By.xpath("//select[@id='bind761']"));
		Select select = new Select(slot);
		select.selectByVisibleText(ex.getStringData("ShelftypeNetype", 1, 1));
		
		driver.findElement(By.xpath("//ng-select[@ng-reflect-name='SlotTypeID']//input[@role='combobox']")).click();
		List<WebElement> netype1=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(netype1,ex.getStringData("ShelftypeNetype", 1, 2));
		
		driver.findElement(By.xpath("//input[@id='SlotNumber']")).sendKeys(ex.getStringData("ShelftypeNetype", 1, 3));
		driver.findElement(By.xpath("//input[@id='Count']")).sendKeys(ex.getStringData("ShelftypeNetype", 1, 4));
		driver.findElement(By.cssSelector("button[type='submit']")).click();


}
}