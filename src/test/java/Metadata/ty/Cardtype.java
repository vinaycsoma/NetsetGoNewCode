package Metadata.ty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Set.ty.ExcelProvider;

public class Cardtype {
ExcelProvider ex;
WebDriver driver;

public Cardtype(WebDriver driver) {
	this.driver = driver;
}
public void ctype() throws IOException {
  ex=new ExcelProvider();
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
  
  driver.findElement(By.xpath("//p[normalize-space()='CardType']")).click();
  
  driver.findElement(By.id("CardTypeName")).sendKeys(ex.getStringData("CardType", 1, 0));//CardType
  
  driver.findElement(By.id("CardTypeSize")).sendKeys(ex.getStringData("CardType", 1, 1));//CardTypeSize
  
  WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']")); 
  fileInput.sendKeys("C:\\Users\\User\\Desktop\\port1.jpg");
  
  driver.findElement(By.id("PortOrder")).sendKeys(ex.getStringData("CardType", 1, 3));
  
  driver.findElement(By.id("SlotOrder")).sendKeys(ex.getStringData("CardType", 1, 4));
  
  driver.findElement(By.id("Description")).sendKeys(ex.getStringData("CardType", 1, 5));
  
  driver.findElement(By.xpath("//button[@type='submit']")).click();
  
  
  
  
}
}
