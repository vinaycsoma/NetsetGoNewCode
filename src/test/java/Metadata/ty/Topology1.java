package Metadata.ty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Set.ty.ExcelProvider;

public class Topology1 {
	ExcelProvider ex;
	WebDriver driver;
	Actions act;

	public Topology1(WebDriver driver) {
		this.driver = driver;
	}
	public void topo() throws IOException, InterruptedException
	{
		ex=new ExcelProvider();

		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		act = new Actions(driver);
		
		driver.findElement(By.xpath("//p[normalize-space()='Topology Type']")).click();

		driver.findElement(By.id("TopologyTypeName")).sendKeys(ex.getStringData("Topology", 1, 0));

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(1000);
	   
	}
}
