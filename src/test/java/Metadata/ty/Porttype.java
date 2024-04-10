package Metadata.ty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Set.ty.Data;
import Set.ty.ExcelProvider;

public class Porttype {
	ExcelProvider ex;
	WebDriver driver;
	Actions act;
	public Porttype(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ptype() throws IOException, InterruptedException
	{
		ex = new ExcelProvider();
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		String crurl = driver.getCurrentUrl();
        String expurl = "https://192.168.4.42/#/metadata";
        Assert.assertEquals(crurl, expurl);
		driver.findElement(By.xpath("//p[normalize-space()='PortType']")).click();
		String crurl1 = driver.getCurrentUrl();
        String expurl1 = "https://192.168.4.42/#/metadata/metalist-items/PortType/69";
        Assert.assertEquals(crurl1, expurl1);
		driver.findElement(By.id("PortTypeName")).sendKeys(ex.getStringData("Porttype",1,0));
		driver.findElement(By.xpath("//ng-select[@id='bind514']//input[@role='combobox']")).click();
		List<WebElement> band= driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(band, ex.getStringData("Porttype", 1, 1)); 
		driver.findElement(By.id("Description")).sendKeys(ex.getStringData("Porttype", 1, 2));
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']")); 
		fileInput.sendKeys("C:\\Users\\User\\Desktop\\port1.jpg");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}