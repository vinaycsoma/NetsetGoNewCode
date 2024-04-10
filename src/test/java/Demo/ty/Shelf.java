package Demo.ty;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Set.ty.Data;
import Set.ty.ExcelProvider;

public class Shelf{
	WebDriver driver;
	ExcelProvider ex;

	public Shelf(WebDriver driver){
		this.driver = driver;
	}
	public void Screation() throws IOException, InterruptedException {
		ex=new ExcelProvider();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@src='../../../assets/menu-icon-Shelf.png']")).click();//shelf

		driver.findElement(By.xpath("//ng-select[@id='bind21']//input[@role='combobox']")).click();//NE
		List<WebElement> drop1=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(drop1, ex.getStringData("shelf", 1, 0));

		driver.findElement(By.xpath("//ng-select[@id='bind22']//input[@role='combobox']")).click();//Shelf Type
		List<WebElement> Shelf1=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(Shelf1,ex.getStringData("shelf", 1, 1));

		driver.findElement(By.id("shelfName")).sendKeys(ex.getStringData("shelf", 1, 2));//Name 

		driver.findElement(By.id("shelfNumber")).sendKeys(ex.getStringData("shelf",1,3));//Shelf No

		driver.findElement(By.xpath("//ng-select[@id='bind25']//input[@role='combobox']")).click();//Location
		List<WebElement> Shelf2=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(Shelf2,ex.getStringData("shelf", 1, 4));


		driver.findElement(By.id("Description")).sendKeys(ex.getStringData("shelf", 1, 5));

		driver.findElement(By.xpath("//ng-select[@id='bind395']//input[@role='combobox']")).click();
		List<WebElement> oType=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(oType,ex.getStringData("shelf", 1, 6));

		WebElement status = driver.findElement(By.xpath("//select[@id='bind580']"));
		Select sts = new Select(status);
		sts.selectByValue("3");


		driver.findElement(By.id("RollOutDate")).sendKeys("29-06-2023 15:55");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();





	}
}
