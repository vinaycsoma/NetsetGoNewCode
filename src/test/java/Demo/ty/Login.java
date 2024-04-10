package Demo.ty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Metadata.ty.Topology1;
import Metadata.ty.Tabelement;
import Metadata.ty.Shelftype_Porttype;
import Metadata.ty.Vendor;
import event_viewer.Corba;
import event_viewer.Dashboard;
import event_viewer.Device;
import event_viewer.Event1;
import event_viewer.PageTab;
import event_viewer.Reports;
import event_viewer.SNMP;
import event_viewer.SNMP_V2;
import event_viewer.SNMP_V3;
import event_viewer.TableAction;
import event_viewer.severity;
import Metadata.ty.Netypeporttype;
import Metadata.ty.Cardtype;
import Metadata.ty.Department;
import Metadata.ty.Porttype;
import Metadata.ty.Customer;
import Metadata.ty.Ordertype;
import Metadata.ty.Circuittype;
import Metadata.ty.Linktype;
import Metadata.ty.Cardtype_porttype;
import Metadata.ty.Customertype;
import Metadata.ty.Locationtype;
import Metadata.ty.Object1;
import Metadata.ty.Order;
import Metadata.ty.Cardtype_slottype;
import Metadata.ty.Netypeshelftype;
import Metadata.ty.Shelftypenetype;
import Metadata.ty.Customer_Order;
import io.github.bonigarcia.wdm.WebDriverManager; 
@Test
public class Login {
	WebDriver driver;
	public ExtentReports extentReports;
	public ExtentTest extent;
	public String report_path="C:\\Users\\User\\Desktop\\PROJECTS\\Nset\\net\\Reports\\";

	@BeforeTest
	public void setup() {
		extentReports=new ExtentReports(report_path + "First.html");
		extent=extentReports.startTest("Test Application");
		// Initialize WebDriver
		ChromeOptions options = new ChromeOptions();
		//EdgeOptions options = new EdgeOptions();
		options.setAcceptInsecureCerts(true);//method to instruct the WebDriver instance to accept insecure SSL certificates without throwing exceptions.
		driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Initialize ExtentReports
		//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/login-report.html");
		//        extent = new ExtentReports();
		//        extent.attachReporter(htmlReporter);
	}

	@Test
	public void loginTest() {
		// Create a new test in the report


		// Open the login page
		driver.get("https://192.168.4.113/#/");

		// Enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("TestUser");

		// Enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Mcts@123");

		// Click login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Validate login
		String expectedTitle = "Netsetgo"; // Change this to the expected title after successful login
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			// Login successful
			extent.log(LogStatus.PASS, "TestCase Pass : Logged in as BUS DRIVER");
		} else {
			// Login failed
			extent.log(LogStatus.PASS, "TestCase Pass : Logged in as BUS DRIVER");
		}

		// Assert login result
		Assert.assertEquals(actualTitle, expectedTitle);
	}



	//	@Test(dependsOnMethods = "login")
	//	public void dCreation() throws InterruptedException, IOException
	//	{
	//		deviceCreation d=new deviceCreation(driver);
	//		d.addDevice();
	//	}
	//	@Test(dependsOnMethods="dCreation")   
	//	public void metacreation() throws IOException, InterruptedException  {
	//		Shelf d1=new Shelf(driver);
	//		d1.Screation();
	//	}
	//	
	//	@Test(dependsOnMethods = "login")
	//	public void ctype() throws IOException, InterruptedException 
	//	{
	//		Cardtype c1=new Cardtype(driver);
	//		c1.ctype();
	//	}
	//	
	//	@Test(dependsOnMethods = "login")
	//	public void topo() throws IOException, InterruptedException
	//	{
	//		Topology1 t1=new Topology1(driver);
	//		t1.topo();
	//
	//	}
	//	@Test(dependsOnMethods = "login")
	//
	//	public void Otype() throws IOException, InterruptedException
	//	{
	//
	//		Ordertype t2=new Ordertype(driver);
	//		t2.Otype();
	//
	//	}
	//
	//	@Test(dependsOnMethods = "login")
	//	public void locate() throws IOException, InterruptedException
	//	{
	//
	//		Locationtype t3=new Locationtype(driver);
	//		t3.locate();
	//
	//	}
	//	@Test(dependsOnMethods = "login",priority =1)
	//	public void ptype() throws IOException, InterruptedException
	//	{
	//
	//		Porttype t3=new Porttype(driver);
	//		t3.ptype();
	//
	//	}
	//	@Test(dependsOnMethods = "login")
	//	public void ltype() throws IOException, InterruptedException
	//	{
	//
	//		Linktype t3=new Linktype(driver);
	//		t3.ltype();
	//
	//	}
	//	@Test(dependsOnMethods = "login")
	//	public void ctype1() throws IOException, InterruptedException
	//	{
	//
	//		Circuittype t3=new Circuittype(driver);
	//		t3.ctype();
	//
	//	}
	//	@Test(dependsOnMethods = "login")
	//	public void custype() throws IOException, InterruptedException
	//	{
	//
	//		Customertype t3=new Customertype(driver);
	//		t3.custype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void obj() throws IOException {
	//		Object1 t4= new Object1(driver);
	//		t4.otype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void vtype() throws IOException {
	//		Vendor t4= new Vendor(driver);
	//		t4.vtype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void neshtype() throws IOException {
	//		Netypeshelftype t4= new Netypeshelftype(driver);
	//		t4.neshtype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void Dtype() throws IOException, InterruptedException {
	//		Department t4= new Department(driver);
	//		t4.Dtype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void shnetype() throws IOException, InterruptedException {
	//		Shelftypenetype t4= new Shelftypenetype(driver);
	//		t4.shnetype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void neprtype() throws IOException, InterruptedException {
	//		Netypeporttype t4= new Netypeporttype(driver);
	//		t4.neprtype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void crsltype() throws IOException, InterruptedException {
	//		Cardtype_slottype t4= new Cardtype_slottype(driver);
	//		t4.crsltype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void neprtype1() throws IOException, InterruptedException {
	//		Cardtype_porttype t4= new Cardtype_porttype(driver);
	//		t4.neprtype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void shprtype() throws IOException, InterruptedException {
	//		Shelftype_Porttype t4= new Shelftype_Porttype(driver);
	//		t4.shprtype();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void order1() throws IOException, InterruptedException {
	//		Order t4= new Order(driver);
	//		t4.order1();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void cust() throws IOException, InterruptedException {
	//		Customer t4= new Customer(driver);
	//		t4.cust();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void custorder() throws IOException, InterruptedException {
	//		Customer_Order t4= new Customer_Order(driver);
	//		t4.custorder();
	//
	//	}
	//	@Test(dependsOnMethods ="login")
	//	public void tab() throws IOException, InterruptedException {
	//		Tabelement t4= new Tabelement(driver);
	//		t4.tab();
	//
	//	}
	//	@Test(dependsOnMethods = "login")
	//	public void Event() throws InterruptedException, IOException
	//	{
	//		Event1 e1=new Event1(driver);
	//		e1.viewer();
	//	}
	//	@Test(dependsOnMethods = "Event")
	//	public void Action() throws InterruptedException, IOException
	//	{
	//		TableAction a1=new TableAction(driver);
	//		a1.Table();
	//	}
	//	@Test(dependsOnMethods="Action")
	//	public void net() throws IOException, InterruptedException
	//	{
	//		Corba c1=new Corba(driver);
	//		c1.add();
	//	}
	//	
	//	@Test(dependsOnMethods="net")
	//	public void New() throws IOException, InterruptedException
	//	{
	//		SNMP s1=new SNMP(driver);
	//		s1.create();
	//	}
	//	@Test(dependsOnMethods="New")
	//	public void old() throws IOException, InterruptedException
	//	{
	//		SNMP_V2 s2=new SNMP_V2(driver);
	//		s2.simple();
	//	}
	//	@Test(dependsOnMethods="old")
	//	public void start() throws IOException, InterruptedException
	//	{
	//		SNMP_V3 s3=new SNMP_V3(driver);
	//		s3.Hash();
	//	}
	//	@Test(dependsOnMethods="start")
	//	public void start1() throws IOException, InterruptedException
	//	{
	//		Device s4=new Device(driver);
	//		s4.stop();
	//	}

	//	@Test(dependsOnMethods="start")
	//	public void start4() throws IOException, InterruptedException
	//	{
	//		Reports s6=new Reports(driver);
	//		s6.stop1();
	//	}
	//	@Test(dependsOnMethods="start4")
	//	public void start3() throws IOException, InterruptedException
	//	{
	//		Dashboard s7=new Dashboard(driver);
	//		s7.stop2();
	//	}
	//	@Test(dependsOnMethods="start3")
	//	public void start2() throws IOException, InterruptedException
	//	{
	//		PageTab s5=new PageTab(driver);
	//		s5.Table1();
	//	}
	//	@Test(dependsOnMethods="start2")
	//	public void save() throws IOException, InterruptedException
	//	{
	//		severity s8=new severity(driver);
	//		s8.Test();
	//	}
}