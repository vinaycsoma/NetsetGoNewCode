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

public class Cardtype_slottype {
	WebDriver driver;
	ExcelProvider ex;
	public Cardtype_slottype(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void crsltype() throws IOException
	{
		ex= new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='CardType SlotType']")).click();
		driver.findElement(By.xpath("//ng-select[@id='bind527']//input[@role='combobox']")).click();
		List<WebElement> netype=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(netype,ex.getStringData("CardtypeSlottype", 1, 0));
		
		WebElement slot = driver.findElement(By.xpath("//select[@id='bind762']"));
		Select select = new Select(slot);
		select.selectByVisibleText(ex.getStringData("CardtypeSlottype", 1, 1));
		
		driver.findElement(By.xpath("//ng-select[@ng-reflect-name='SlotTypeID']//input[@role='combobox']")).click();
		List<WebElement> netype1=driver.findElements(By.xpath("//ng-dropdown-panel[@id='a1d988ada165']//div"));
		Data.dropdown(netype1,ex.getStringData("CardtypeSlottype", 1, 2));
		
		driver.findElement(By.xpath("//input[@id='SlotNumber']")).sendKeys(ex.getStringData("CardtypeSlottype", 1, 3));
		driver.findElement(By.xpath("//input[@id='Count']")).sendKeys(ex.getStringData("CardtypeSlottype", 1, 4));
		driver.findElement(By.cssSelector("button[type='submit']")).click();


		
}
}
