package common;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Utilities {

	public static WebDriver objTestCaseDriver;
	public static ExcelParser objTestData;

	public static final String USERNAME = "hirenthacker";
	public static final String AUTOMATE_KEY = "pmJAyA4YVTtK3bmZxAto";
	public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	public static int rownum;

	public void setRow()
	{
		rownum=0;
	}
	public void assign()
	{
		rownum++;
	}

	public void LaunchApplication(String BrowserName, String BrowserVersion,String OSName, String OSVersion,String Resolution, String Url) throws BiffException,IOException, InterruptedException, AWTException, ParseException {

		objTestData=new common.ExcelParser();
		DesiredCapabilities caps = new DesiredCapabilities();

	    caps.setCapability("browser", BrowserName);
	    caps.setCapability("browser_version", BrowserVersion);
	    caps.setCapability("os", OSName);
	    caps.setCapability("os_version", OSVersion);
	    caps.setCapability("resolution", Resolution);

	    caps.setCapability("browserstack.debug", "true");

	    objTestCaseDriver = new RemoteWebDriver(new URL(URL), caps);

		//objTestCaseDriver = new FirefoxDriver();
	
		objTestCaseDriver.manage().window().maximize();
		objTestCaseDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		objTestCaseDriver.get(Url);

	}

	public void SignOutEmployer(){

		objTestCaseDriver.findElement(By.xpath("//a[text()='Sign out']")).click();
	}

	public void SignOutSeeker(){

		//objTestCaseDriver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		objTestCaseDriver.findElement(By.xpath("//a[text()='Sign out']")).click();
	}

	public void SignInSeeker(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException{

		objTestCaseDriver.findElement(By.xpath("//a[@id='signIn']")).click();
		objTestCaseDriver.findElement(By.xpath("//input[@id='LoginText']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerMobileOrEmail"));
		objTestCaseDriver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerPassword"));
		objTestCaseDriver.findElement(By.xpath("//a[@id='loginBtn']")).click();
		objTestCaseDriver.findElement(By.xpath("//button[@id='updateModalClose']")).click();
		
		String checkNameSeeker = Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#']")).getText();
		System.out.println(checkNameSeeker);

		Assert.assertEquals(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerName"), checkNameSeeker);


	}
	
	public void SignInSeekerInvalid(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException{

		objTestCaseDriver.findElement(By.xpath("//a[@id='signIn']")).click();
		objTestCaseDriver.findElement(By.xpath("//input[@id='LoginText']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerMobileOrEmail"));
		objTestCaseDriver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerPassword"));
		objTestCaseDriver.findElement(By.xpath("//a[@id='loginBtn']")).click();
		String ErrorMessage = objTestCaseDriver.findElement(By.xpath("//span[@class='help-block']")).getText();
		
		Assert.assertEquals("Sorry, either the username or password is incorrect. Please try again.", ErrorMessage);


	}
	public void SignInEmployer(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		objTestCaseDriver.findElement(By.xpath("//a[@id='signIn']")).click();
		Thread.sleep(3000);
		objTestCaseDriver.findElement(By.xpath("//input[@id='LoginText']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "EmailAdd"));
		objTestCaseDriver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "EmployerPassword"));
		objTestCaseDriver.findElement(By.xpath("//a[@id='loginBtn']")).click();
		
		Thread.sleep(3000);
		String checkNameEmployer = Utilities.objTestCaseDriver.findElement(By.xpath("//div/div/div/ul/li/a[@href='#']")).getText();
		System.out.println(checkNameEmployer);

		Assert.assertEquals(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "EmployerName"), checkNameEmployer);

	}

	public void CloseApplication() {

		objTestCaseDriver.close();
	}
	
	public boolean isElementPresent(String xpath, int timeout) throws InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(objTestCaseDriver, timeout);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			// objTestCaseDriver.findElement(by);
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
}