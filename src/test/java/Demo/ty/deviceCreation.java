package Demo.ty;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Set.ty.Data;
import Set.ty.ExcelProvider;


public class deviceCreation  {
	WebDriver driver;
	ExcelProvider ex;
	public deviceCreation(WebDriver d) {
		this.driver=d;
	}
	public void addDevice() throws InterruptedException, IOException {
		ex=new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("inside");
		driver.findElement(By.xpath("//div[contains(text(),'planning')]")).click();//location
		WebElement drop= driver.findElement(By.xpath("//select[@id='bind1']"));
		Select select = new Select(drop);
		select.selectByVisibleText(ex.getStringData("device", 1, 0));

		driver.findElement(By.xpath("//input[@role='combobox']")).click();
		List<WebElement> drop1=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div"));
		Data.dropdown(drop1, ex.getStringData("device", 1, 1));

		driver.findElement(By.xpath("//ng-select[@id='bind7']//input[@role='combobox']")).click();
		List<WebElement> dType = driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div"));
		Data.dropdown(dType, ex.getStringData("device", 1, 2));

		driver.findElement(By.id("NEName")).sendKeys(ex.getStringData("device", 1, 3));//name of the device
		driver.findElement(By.id("Description")).sendKeys(ex.getStringData("device", 1, 4));//description
		driver.findElement(By.id("serialno")).sendKeys(ex.getStringData("device", 1, 5));//serial no

		driver.findElement(By.xpath("//ng-select[@id='bind394']//input[@role='combobox']")).click();
		List<WebElement> oType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div"));

		Data.dropdown(oType, ex.getStringData("device", 1, 6));

		WebElement status = driver.findElement(By.xpath("//select[@id='bind6']"));
		Select sts = new Select(status);
		sts.selectByValue("3");

		//driver.findElement(By.id("RollOutDate")).sendKeys(ex.getStringData("device", 1, 8));

		WebElement dateBox = driver.findElement(By.id("RollOutDate"));
		dateBox.sendKeys("09052013");
		dateBox.sendKeys(Keys.TAB);
		dateBox.sendKeys("0245PM");
		// dateBox.sendKeys("09-02-2023 12:45");


		driver.findElement(By.xpath("//button[@type='submit']")).click();//save

	}

}
