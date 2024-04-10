package event_viewer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Set.ty.Data;
import Set.ty.ExcelProvider;

public class Event1 {
	WebDriver driver;
	ExcelProvider ex;
	public Event1(WebDriver driver) {
		this.driver = driver;
	}
	public void viewer() throws IOException, InterruptedException
	{
		ex= new ExcelProvider();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Event Viewer Metadata')]")).click();	
		driver.findElement(By.xpath("//p[normalize-space()='Tab Element']")).click();

		WebElement pagegruop = driver.findElement(By.xpath("//ng-select[@id='bind2']"));
		pagegruop.click();
		Assert.assertTrue(pagegruop.isDisplayed());//web element is visible or not on the web page
		List<WebElement> page=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
		String expectedData=ex.getStringData("Event_Viewer", 1, 0);
		Assert.assertTrue(Data.dropdown(page, expectedData), "Expected data is not present in the dropdown options.");

		//		driver.findElement(By.xpath("//ng-select[@id='bind2']")).click();
		//		List<WebElement> page=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
		//		String expectedData=ex.getStringData("Event_Viewer", 1, 0);
		//		Assert.assertTrue(Data.dropdown(page, expectedData), "Expected data is not present in the dropdown options.");

		// Select option from dropdown
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='bind1']"));
		Select select = new Select(dropdown);
		String expectedData1 = ex.getStringData("Event_Viewer", 1, 1); // Assuming data is in Sheet1, row 1, column 1
		select.selectByVisibleText(expectedData1);
		// Get Actual Data: Retrieve selected option from the dropdown
		String selectedOption = select.getFirstSelectedOption().getText();
		// Assert: Check if the selected option matches the expected data
		Assert.assertEquals(selectedOption, expectedData1, "Selected option is not as expected.");

		WebElement page2 = driver.findElement(By.xpath("//select[@id='bind252']"));
		Select select2 = new Select(page2);
		String expectedData2 = ex.getStringData("Event_Viewer", 1, 2); //data is in Sheet1, row 1, column 1
		select2.selectByVisibleText(expectedData2);
		String selectedOption1 = select2.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOption1, expectedData2, "Selected option is not as expected.");

		//clicking add button
		driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();

		String expectedValue = ex.getStringData("Event_Viewer", 1, 3); 
		// Enter the fetched value into the input field
		WebElement inputField = driver.findElement(By.xpath("//input[@ng-reflect-name='TabElementId']"));
		inputField.sendKeys(expectedValue);
		// Retrieve the entered value from the input field
		String actualValue = inputField.getAttribute("value");
		//  Check if the entered value matches the expected value
		Assert.assertEquals(actualValue, expectedValue, "Entered value is not as expected.");

		String expectedValue1 = ex.getStringData("Event_Viewer", 1, 4); 
		WebElement inputfield1=driver.findElement(By.xpath("//input[@ng-reflect-name='ElementDisplayName']"));
		inputfield1.sendKeys(expectedValue1);
		String actualValue1 = inputfield1.getAttribute("value");
		Assert.assertEquals(actualValue1, expectedValue1, "Entered value is not as expected.");

		String expectedValue2 = ex.getStringData("Event_Viewer", 1, 5); 
		WebElement inputfield2=driver.findElement(By.xpath("//input[@ng-reflect-name='ElementSelectedValue']"));
		inputfield2.sendKeys(expectedValue2);
		String actualValue2 = inputfield2.getAttribute("value");
		Assert.assertEquals(actualValue2, expectedValue2, "Entered value is not as expected.");


		//        driver.findElement(By.xpath("//ng-select[@id='bindElementType']")).click();
		//		List<WebElement> page8=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
		//		String expectedData3=ex.getStringData("Event_Viewer", 1, 6);
		//		Assert.assertTrue(Data.dropdown(page, expectedData3), "Expected data is not present in the dropdown options.");

		

		driver.findElement(By.xpath("//ng-select[@id='bindElementType']")).click();
		List<WebElement> page3=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
		Data.dropdown(page3,ex.getStringData("Event_Viewer", 1, 6));

		driver.findElement(By.xpath("//ng-select[@id='bindisAction']")).click();
		List<WebElement> page4=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
		Data.dropdown(page4,ex.getStringData("Event_Viewer", 1, 7));

		String expectedValue3 = ex.getStringData("Event_Viewer", 1, 8); 
		WebElement inputfield3=driver.findElement(By.xpath("//input[@ng-reflect-name='elementOrder']"));
		inputfield3.sendKeys(expectedValue3);
		String actualValue3 = inputfield3.getAttribute("value");
		Assert.assertEquals(actualValue3, expectedValue3, "Entered value is not as expected.");

		String expectedValue4 = ex.getStringData("Event_Viewer", 1, 9); 
		WebElement inputfield4=driver.findElement(By.xpath("//input[@ng-reflect-name='defaultValue']"));
		inputfield4.sendKeys(expectedValue4);
		String actualValue4 = inputfield4.getAttribute("value");
		Assert.assertEquals(actualValue4, expectedValue4, "Entered value is not as expected.");
		
		String expectedValue5 = ex.getStringData("Event_Viewer", 1, 10); 
		WebElement inputfield5=driver.findElement(By.xpath("//input[@ng-reflect-name='elementOption']"));
		inputfield5.sendKeys(expectedValue5);
		String actualValue5 = inputfield5.getAttribute("value");
		Assert.assertEquals(actualValue5, expectedValue5, "Entered value is not as expected.");
		
		
		String expectedValue6 = ex.getStringData("Event_Viewer", 1, 11); 
		WebElement inputfield6=driver.findElement(By.xpath("//input[@ng-reflect-name='ElementAction']"));
		inputfield6.sendKeys(expectedValue6);
		String actualValue6 = inputfield6.getAttribute("value");
		Assert.assertEquals(actualValue6, expectedValue6, "Entered value is not as expected.");
		
		String expectedValue7 = ex.getStringData("Event_Viewer", 1, 12); 
		WebElement inputfield7=driver.findElement(By.xpath("//input[@ng-reflect-name='APICall']"));
		inputfield7.sendKeys(expectedValue7);
		String actualValue7 = inputfield7.getAttribute("value");
		Assert.assertEquals(actualValue7, expectedValue7, "Entered value is not as expected.");
		
		
//		WebElement pagegruop1 = driver.findElement(By.xpath("//ng-select[@id='bindisReadOnly']"));
//		pagegruop1.click();
//		Assert.assertTrue(pagegruop1.isDisplayed());//web element is visible or not on the web page
//		List<WebElement> page5=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
//		String expectedData11=ex.getStringData("Event_Viewer", 1, 13);
//		Assert.assertTrue(Data.dropdown(page5, expectedData11), "Expected data is not present in the dropdown options.");
//		
		driver.findElement(By.xpath("//ng-select[@id='bindisReadOnly']")).click();
		List<WebElement> page5=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
		Data.dropdown(page5,ex.getStringData("Event_Viewer", 1, 13));

		String expectedValue8 = ex.getStringData("Event_Viewer", 1, 14); 
		WebElement inputfield8=driver.findElement(By.xpath("//input[@ng-reflect-name='coreAPIAtrribName']"));
		inputfield8.sendKeys(expectedValue8);
		String actualValue8 = inputfield8.getAttribute("value");
		Assert.assertEquals(actualValue8, expectedValue8, "Entered value is not as expected.");
		
		//driver.findElement(By.xpath("//input[@ng-reflect-name='coreAPIAtrribName']")).sendKeys(ex.getStringData("Event_Viewer", 1, 14));

//		WebElement pagegruop12 = driver.findElement(By.xpath("//ng-select[@id='bindisRequired']"));
//		pagegruop12.click();
//		Assert.assertTrue(pagegruop12.isDisplayed());
//		List<WebElement> page51=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
//		String expectedData12=ex.getStringData("Event_Viewer", 1, 15);
//		Assert.assertTrue(Data.dropdown(page51, expectedData12), "Expected data is not present in the dropdown options.");
		
		driver.findElement(By.xpath("//ng-select[@id='bindisRequired']")).click();
		List<WebElement> page6=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
		Data.dropdown(page6,ex.getStringData("Event_Viewer", 1, 15));


		String expectedValue9 = ex.getStringData("Event_Viewer", 1, 16); 
		WebElement inputfield9=driver.findElement(By.xpath("//input[@ng-reflect-name='childTabElementID']"));
		inputfield9.sendKeys(expectedValue9);
		String actualValue9 = inputfield9.getAttribute("value");
		Assert.assertEquals(actualValue9, expectedValue9, "Entered value is not as expected.");
		
		//driver.findElement(By.xpath("//input[@ng-reflect-name='childTabElementID']")).sendKeys(ex.getStringData("Event_Viewer", 1, 16));

		WebElement pagegruop13 = driver.findElement(By.xpath("//ng-select[@id='bindIPOP']"));
		pagegruop13.click();
		Assert.assertTrue(pagegruop13.isDisplayed());
		List<WebElement> page53=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
		String expectedData13=ex.getStringData("Event_Viewer", 1, 17);
		Assert.assertTrue(Data.dropdown(page53, expectedData13), "Expected data is not present in the dropdown options.");
		
//		driver.findElement(By.xpath("//ng-select[@id='bindIPOP']")).click();
//		List<WebElement> page7=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
//		Data.dropdown(page7,ex.getStringData("Event_Viewer", 1, 17));

		String expectedValue10 = ex.getStringData("Event_Viewer", 1, 18); 
		WebElement inputfield10=driver.findElement(By.xpath("//input[@ng-reflect-name='ClickableObjectID']"));
		inputfield10.sendKeys(expectedValue10);
		String actualValue10 = inputfield10.getAttribute("value");
		Assert.assertEquals(actualValue10, expectedValue10, "Entered value is not as expected.");
		
		//driver.findElement(By.xpath("//input[@ng-reflect-name='ClickableObjectID']")).sendKeys(ex.getStringData("Event_Viewer", 1, 18));

		String expectedValue11 = ex.getStringData("Event_Viewer", 1, 19); 
		WebElement inputfield11=driver.findElement(By.xpath("//input[@ng-reflect-name='isFormArray']"));
		inputfield11.sendKeys(expectedValue11);
		String actualValue11 = inputfield11.getAttribute("value");
		Assert.assertEquals(actualValue11, expectedValue11, "Entered value is not as expected.");
		
		//driver.findElement(By.xpath("//input[@ng-reflect-name='isFormArray']")).sendKeys(ex.getStringData("Event_Viewer", 1, 19));


		driver.findElement(By.xpath("//ng-select[@id='bindisMandatory']")).click();
		List<WebElement> page8=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div//div"));
		Data.dropdown(page8,ex.getStringData("Event_Viewer", 1, 20));

		String expectedValue12 = ex.getStringData("Event_Viewer", 1, 21); 
		WebElement inputfield12=driver.findElement(By.xpath("//input[@ng-reflect-name='TriggerVal']"));
		inputfield12.sendKeys(expectedValue12);
		String actualValue12 = inputfield12.getAttribute("value");
		Assert.assertEquals(actualValue12, expectedValue12, "Entered value is not as expected.");
		
		//driver.findElement(By.xpath("//input[@ng-reflect-name='TriggerVal']")).sendKeys(ex.getStringData("Event_Viewer", 1, 21));

		//		driver.findElement(By.xpath("//ng-select[@id='bindisMandatory']//input[@role='combobox']")).click();
		//		List<WebElement> page8=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		//		Data.dropdown(page8,ex.getStringData("Event_Viewer", 1, 19));
		//		
		
		String expectedValue13 = ex.getStringData("Event_Viewer", 1, 22); 
		WebElement inputfield13=driver.findElement(By.xpath("//input[@ng-reflect-name='ObjectTypeName']"));
		inputfield13.sendKeys(expectedValue13);
		String actualValue13 = inputfield13.getAttribute("value");
		Assert.assertEquals(actualValue13, expectedValue13, "Entered value is not as expected.");
		
		//driver.findElement(By.xpath("//input[@ng-reflect-name='ObjectTypeName']")).sendKeys(ex.getStringData("Event_Viewer", 1, 23));


		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Validate the message after clicking the button
		//		String expectedMessage = "Tab Inserted Successfully";
		//		String actualMessage = driver.findElement(By.xpath("//button[@class='notifier__notification-button']")).getText();
		//		System.out.println("actual "+ actualMessage);
		//		Assert.assertEquals(actualMessage, expectedMessage, "Message after clicking the button is not as expected");
Thread.sleep(5000);


	}
}
