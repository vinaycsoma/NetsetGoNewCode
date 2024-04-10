package event_viewer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Set.ty.ExcelProvider;

public class Corba {
	WebDriver driver;
	ExcelProvider ex;
	public Corba(WebDriver driver) {
		this.driver=driver;
	}
	public void add() throws IOException, InterruptedException {
		ex= new ExcelProvider();
		driver.findElement(By.xpath("//p[normalize-space()='CORBA TMF 814']")).click();
		//emsname
		String expectedValue1 = ex.getStringData("CORBA", 1, 0); 
		WebElement inputfield1=driver.findElement(By.xpath("//input[@ng-reflect-name='emsname']"));
		inputfield1.sendKeys(expectedValue1);
		String actualValue1 = inputfield1.getAttribute("value");
		Assert.assertEquals(actualValue1, expectedValue1, "Entered value is not as expected.");

		//ems ip
		String expectedValue2 = ex.getStringData("CORBA", 1, 1); 
		WebElement inputfield2=driver.findElement(By.xpath("//input[@ng-reflect-name='emsip']"));
		Assert.assertTrue(inputfield2.isEnabled(), "Textbox is not enabled");
		inputfield2.sendKeys(expectedValue2);
		String actualValue2 = inputfield2.getAttribute("value");
		Assert.assertEquals(actualValue2, expectedValue2, "Entered value is not as expected.");

		//emsType
		String expecedValue3=ex.getStringData("CORBA", 1, 2);
		WebElement inputfeild3=driver.findElement(By.xpath("//input[@ng-reflect-name='emstype']"));
		inputfeild3.sendKeys(expecedValue3);
		String actualValue3=inputfeild3.getAttribute("value");
		Assert.assertEquals(actualValue3, expecedValue3,"Entered value is not as expected");

		//NBI port
		String expecedValue4=ex.getStringData("CORBA", 1, 3);
		WebElement inputfeild4=driver.findElement(By.xpath("//input[@ng-reflect-name='nbiPort']"));
		inputfeild4.sendKeys(expecedValue4);
		String actualValue4=inputfeild4.getAttribute("value");
		Assert.assertEquals(actualValue4, expecedValue4,"Entered value is not as expected");


		//NBI User
		String expecedValue5=ex.getStringData("CORBA", 1, 4);
		WebElement inputfeild5=driver.findElement(By.xpath("//input[@ng-reflect-name='nbiUser']"));
		inputfeild5.sendKeys(expecedValue5);
		String actualValue5=inputfeild5.getAttribute("value");
		Assert.assertEquals(actualValue5, expecedValue5,"Entered value is not as expected");
		
		//NBI Password
		String expecedValue6=ex.getStringData("CORBA", 1, 5);
		WebElement inputfeild6=driver.findElement(By.xpath("//input[@ng-reflect-name='nbiPassword']"));
		inputfeild6.sendKeys(expecedValue6);
		String actualValue6=inputfeild6.getAttribute("value");
		Assert.assertEquals(actualValue6, expecedValue6,"Entered value is not as expected");

        //NBI Version
		String expecedValue7=ex.getStringData("CORBA", 1, 6);
		WebElement inputfeild7=driver.findElement(By.xpath("//input[@ng-reflect-name='nbiVersion']"));
		inputfeild7.sendKeys(expecedValue7);
		String actualValue7=inputfeild7.getAttribute("value");
		Assert.assertEquals(actualValue7, expecedValue7,"Entered value is not as expected");

		//NBI EMS Instance
		String expecedValue8=ex.getStringData("CORBA", 1, 7);
		WebElement inputfeild8=driver.findElement(By.xpath("//input[@ng-reflect-name='nbiEmsInstance']"));
		inputfeild8.sendKeys(expecedValue8);
		String actualValue8=inputfeild8.getAttribute("value");
		Assert.assertEquals(actualValue8, expecedValue8,"Entered value is not as expected");


		//NBI EMS Session Fact
		String expecedValue9=ex.getStringData("CORBA", 1, 8);
		WebElement inputfeild9=driver.findElement(By.xpath("//input[@ng-reflect-name='nbiEmsSessionFact']"));
		inputfeild9.sendKeys(expecedValue9);
		String actualValue9=inputfeild9.getAttribute("value");
		Assert.assertEquals(actualValue9, expecedValue9,"Entered value is not as expected");
		
        //NBI Vendor
		String expecedValue10=ex.getStringData("CORBA", 1, 9);
		WebElement inputfeild10=driver.findElement(By.xpath("//input[@ng-reflect-name='nbiVendor']"));
		inputfeild10.sendKeys(expecedValue10);
		String actualValue10=inputfeild10.getAttribute("value");
		Assert.assertEquals(actualValue10, expecedValue10,"Entered value is not as expected");
		
		//Used For Faults
		String expecedValue11=ex.getStringData("CORBA", 1, 10);
		WebElement inputfeild11=driver.findElement(By.xpath("//input[@ng-reflect-name='usedforfaults']"));
		inputfeild11.sendKeys(expecedValue11);
		String actualValue11=inputfeild11.getAttribute("value");
		Assert.assertEquals(actualValue11, expecedValue11,"Entered value is not as expected");
		
		//Used For Discovery
		String expecedValue12=ex.getStringData("CORBA", 1, 11);
		WebElement inputfeild12=driver.findElement(By.xpath("//input[@ng-reflect-name='usedfordiscovery']"));
		inputfeild12.sendKeys(expecedValue12);
		String actualValue12=inputfeild12.getAttribute("value");
		Assert.assertEquals(actualValue12, expecedValue12,"Entered value is not as expected");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		
	}

}
