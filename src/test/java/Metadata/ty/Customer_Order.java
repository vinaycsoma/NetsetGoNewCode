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

public class Customer_Order {
	WebDriver driver;
	ExcelProvider ex;
	public Customer_Order(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void custorder() throws IOException
	{
		ex= new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Customer Order']")).click();
		
		WebElement port = driver.findElement(By.xpath("//select[@id='bind662']"));
		Select select = new Select(port);
		select.selectByVisibleText(ex.getStringData("Customerorder", 1, 0));
		
		WebElement port1 = driver.findElement(By.xpath("//select[@id='bind663']"));
		Select select1 = new Select(port1);
		select1.selectByVisibleText(ex.getStringData("Customerorder", 1, 1));
		
		driver.findElement(By.xpath("//ng-multiselect-dropdown[@class='form-control form-control-sm ng-untouched ng-valid ng-dirty']")).click();
		List<WebElement> netype=driver.findElements(By.xpath("//div[@class='dropdown-list']//div"));
		Data.dropdown(netype,ex.getStringData("Customerorder", 1, 2));
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		
}
}