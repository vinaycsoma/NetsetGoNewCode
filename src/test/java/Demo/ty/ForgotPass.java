package Demo.ty;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Set.ty.ExcelProvider;

public class ForgotPass {
	WebDriver driver;
	ExcelProvider ex;
	public ForgotPass(WebDriver driver) {

		this.driver = driver;
	}
	public void Test() throws IOException, InterruptedException
	{
		ex= new ExcelProvider();
		driver.findElement(By.tagName("a")).click();
		
}
}