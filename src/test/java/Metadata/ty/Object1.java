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

public class Object1 {
	WebDriver driver;
	ExcelProvider ex;
	public Object1(WebDriver driver) {
		this.driver = driver;
	}
	public void otype() throws IOException {
		ex =new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Object Status']")).click();
		driver.findElement(By.id("statusName")).sendKeys(ex.getStringData("Objectstatus", 1, 0));
		WebElement color= driver.findElement(By.xpath("//select[@id='bind521']"));
		Select select = new Select(color);
		select.selectByVisibleText(ex.getStringData("Objectstatus", 1, 1));
		driver.findElement(By.xpath("//ng-multiselect-dropdown[@class='form-control form-control-sm ng-untouched ng-pristine ng-valid']")).click();
		List<WebElement> checkbox=driver.findElements(By.xpath("//div[@class='dropdown-list']//div"));
		Data.dropdown(checkbox, ex.getStringData("Objectstatus", 1, 2));
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		
	}

}

