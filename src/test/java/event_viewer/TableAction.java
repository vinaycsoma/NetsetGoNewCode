package event_viewer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Set.ty.Data;
import Set.ty.ExcelProvider;

public class TableAction {
	WebDriver driver;
	ExcelProvider ex;
	public TableAction(WebDriver driver) {

		this.driver = driver;
	}
	public void Table() throws IOException, InterruptedException
	{
		ex= new ExcelProvider();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//p[normalize-space()='Table Actions']")).click();
		//Page group
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='bind8']"));
		Select select = new Select(dropdown);
		String expectedData1 = ex.getStringData("TableAction", 1, 0); 
		select.selectByVisibleText(expectedData1);
		// Get Actual Data: Retrieve selected option from the dropdown
		String selectedOption = select.getFirstSelectedOption().getText();
		// Assert: Check if the selected option matches the expected data
		Assert.assertEquals(selectedOption, expectedData1, "Selected option is not as expected.");


		WebElement dropdown11=driver.findElement(By.xpath("//select[@id='bind9']"));
		Select select11= new Select(dropdown11);
		String expect = ex.getStringData("TableAction", 1, 1);
		select11.selectByVisibleText(expect);
		String selectedOption11 = select11.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOption11, expect, "Selected option is not as expected.");


		WebElement dropdown3=driver.findElement(By.xpath("//select[@id='bind10']"));
		Select select2= new Select(dropdown3);
		String expect1 = ex.getStringData("TableAction", 1, 2);
		select2.selectByVisibleText(expect1);
		String selectedOption2 = select2.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOption2, expect1, "Selected option is not as expected.");

		String expectedValue1 = ex.getStringData("TableAction", 1, 3); 
		WebElement inputfield1=driver.findElement(By.xpath("//input[@ng-reflect-name='actionName']"));
		inputfield1.sendKeys(expectedValue1);
		String actualValue1 = inputfield1.getAttribute("value");
		Assert.assertEquals(actualValue1, expectedValue1, "Entered value is not as expected.");


		String expectedValue2 = ex.getStringData("TableAction", 1, 4); 
		WebElement inputfield2=driver.findElement(By.xpath("//input[@ng-reflect-name='actionUrl']"));
		inputfield2.sendKeys(expectedValue2);
		String actualValue2 = inputfield2.getAttribute("value");
		Assert.assertEquals(actualValue2, expectedValue2, "Entered value is not as expected.");

		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).click();

		String expectedValue11 = ex.getStringData("TableAction", 2, 3); 
		WebElement inputfield11=driver.findElement(By.xpath("//input[@class='form-control form-control-sm ng-untouched ng-pristine ng-invalid']"));
		inputfield11.sendKeys(expectedValue11);
		String actualValue11 = inputfield11.getAttribute("value");
		Assert.assertEquals(actualValue11, expectedValue11, "Entered value is not as expected.");


		String expectedValue12 = ex.getStringData("TableAction", 2, 4); 
		WebElement inputfield12=driver.findElement(By.xpath("//input[@class='form-control form-control-sm ng-untouched ng-pristine ng-invalid']"));
		inputfield12.sendKeys(expectedValue12);
		String actualValue12 = inputfield12.getAttribute("value");
		Assert.assertEquals(actualValue12, expectedValue12, "Entered value is not as expected.");

		WebElement button=	driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		Thread.sleep(5000);

	}
}
