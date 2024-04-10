package Metadata.ty;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Set.ty.Data;
import Set.ty.ExcelProvider;

public class Tabelement {
	WebDriver driver;
	ExcelProvider ex;
	public Tabelement(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void tab() throws IOException
	{
		ex= new ExcelProvider();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Metadata')]")).click();
		driver.findElement(By.xpath("//p[normalize-space()='TabElement']")).click();
		
		driver.findElement(By.xpath("//input[@id='PageName']")).sendKeys(ex.getStringData("TabElement", 1, 0));
		
		driver.findElement(By.xpath("//ng-select[@id='bind680']//input[@role='combobox']")).click();
		List<WebElement> page= driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(page,ex.getStringData("TabElement", 1, 1)); 
        
		driver.findElement(By.xpath("//input[@id='whereClause']")).sendKeys(ex.getStringData("TabElement", 1, 2));
		
		driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();

		driver.findElement(By.xpath("//input[@ng-reflect-name='TabElementId']")).sendKeys(ex.getStringData("TabElement", 1, 3));
		driver.findElement(By.xpath("//input[@ng-reflect-name='ElementDisplayName']")).sendKeys(ex.getStringData("TabElement", 1, 4));
		driver.findElement(By.xpath("//input[@ng-reflect-name='ElementSelectedValue']")).sendKeys(ex.getStringData("TabElement", 1, 5));
		driver.findElement(By.xpath("//ng-select[@id='bindElementType']//input[@role='combobox']")).click();
		List<WebElement> grp=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(grp, ex.getStringData("TabElement", 1, 6));
		
		driver.findElement(By.xpath("//ng-select[@id='bindisAction']//input[@role='combobox']")).click();
		List<WebElement> action1=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(action1, ex.getStringData("TabElement", 1, 7));
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='elementOrder']")).sendKeys(ex.getStringData("TabElement", 1, 8));
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='defaultValue']")).sendKeys(ex.getStringData("TabElement", 1, 9));
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='elementOption']")).sendKeys(ex.getStringData("TabElement", 1, 10));
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='ElementAction']")).sendKeys(ex.getStringData("TabElement", 1,11));
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='APICall']")).sendKeys(ex.getStringData("TabElement", 1, 12));
		
		driver.findElement(By.xpath("//ng-select[@id='bindisReadOnly']//input[@role='combobox']")).click();
		List<WebElement> read=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']"));
		Data.dropdown(read, ex.getStringData("TabElement", 1, 13));
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='coreAPIAtrribName']")).sendKeys(ex.getStringData("TabElement", 1, 14));
		driver.findElement(By.xpath("//ng-select[@id='bindisRequired']//div[@class='ng-select-container']//input[@role='combobox']")).click();
		List<WebElement> req=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(req, ex.getStringData("TabElement", 1, 14));
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='childTabElementID']")).sendKeys(ex.getStringData("TabElement", 1, 15));
		
		driver.findElement(By.xpath("//ng-select[@id='bindIPOP']//input[@role='combobox']")).click();
		List<WebElement> bind=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(bind, ex.getStringData("TabElement", 1, 16));
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='ClickableObjectID']")).sendKeys(ex.getStringData("TabElement", 1, 17));
		driver.findElement(By.xpath("//input[@ng-reflect-name='isFormArray']")).sendKeys(ex.getStringData("TabElement", 1, 18));

		driver.findElement(By.xpath("//ng-select[@id='bindisMandatory']//input[@role='combobox']")).click();
		List<WebElement> bind1=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(bind1, ex.getStringData("TabElement", 1, 18));
		
		driver.findElement(By.xpath("//input[@ng-reflect-name='TriggerVal']")).sendKeys(ex.getStringData("TabElement", 1, 19));
		
		driver.findElement(By.xpath("//ng-select[@id='bindParentColumnName']//input[@role='combobox']")).click();
		List<WebElement> bind2=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		Data.dropdown(bind2, ex.getStringData("TabElement", 1, 20));
		
		driver.findElement(By.xpath("bindParentColumnName")).sendKeys(ex.getStringData("TabElement", 1, 21));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		}
}