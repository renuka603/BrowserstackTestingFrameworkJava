package sprints;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import jxl.read.biff.BiffException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.Utilities;


public class BabaJobMod {

	static String JobID;
	common.Utilities objUtil = new common.Utilities();

	public void RegisterationSeeker(int rownum,String ExcelFileName, String SheetName)throws IOException, InterruptedException, AWTException,BiffException, ParseException  {

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='btnJobSeekerRegister']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//label[@id='jobSeekerRegisterButton']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='jobseekerName']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerName"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='jobseekerMobileOrEmail']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerMobileOrEmail"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//select[@id='field-desiredcategory']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "JobPreference"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='jobseekerPassword']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerPassword"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='jobSeekerRegister']")).click();
		Thread.sleep(3000);
		String checkNameSeeker = Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#']")).getText();
		System.out.println(checkNameSeeker);

		Assert.assertEquals(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerName"), checkNameSeeker);
	}

	public void RegisterationEmployer(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='btnJobSeekerRegister']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//label[@id='employerRegisterButton']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//*[@id='EmployerTypeGroup']/label[3]")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='userName']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "EmployerName"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='companyName']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "CompanyName"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='userMobile']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "MobileNumber"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "EmailAdd"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "EmployerPassword"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='submitBtn']")).click();

	}

	public void EmployerPostJob(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='newjob']")).click();
		Thread.sleep(1000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='Title']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "JobTitle"));
		Thread.sleep(1000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//select[@id='JobCategory']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "JobCategory"));
		Thread.sleep(1000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//select[@id='stateList']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "StateList"));
		Thread.sleep(1000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//select[@id='cityList']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "CityList"));
		Thread.sleep(1000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='pinCodes']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "PinCode"));
		Thread.sleep(1000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='Pay']")).clear();
		Thread.sleep(1000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='Pay']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "Salary"));
		Thread.sleep(2000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		Thread.sleep(3000);

		/*Utilities.objTestCaseDriver.findElement(By.xpath("//a[text()='          Skip']")).click();

		Alert alert = Utilities.objTestCaseDriver.switchTo().alert();
        alert.dismiss();*/
	}

	public void DeleteSeeker(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='updateModalClose']")).click();

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[text()='Edit my Profile']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='Delete profile']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='clickedDelete']")).click();

	}

	public void SeekerApplyJob(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='jobs']")).click();
		Thread.sleep(2000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='textSearchBox']")).clear();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='textSearchBox']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "JobCategory"));
		Thread.sleep(2000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='locationSearchBox']")).clear();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='locationSearchBox']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "CityList"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[text()='Search']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='signedInApplyButton-"+JobID+"']")).click();

	}

	public void EmployerCheckRSE(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='job-"+JobID+"']")).click();
		objUtil.isElementPresent("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']", 5);

	}

	public void FetchingJobID(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		JobID=Utilities.objTestCaseDriver.findElement(By.xpath("//div[contains(text(),'Babajob JobId')]/following-sibling::div")).getText();	
		System.out.println(JobID);
	}

	public void VerifySeekerMobile(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//img[@src='/pix/redesign/bj_logo_header_cropped.png']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='updateModalClose']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='mobileVerificationTextBox']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "VerificationCode"));
		Thread.sleep(2000);
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='verificationButton']")).click();
		Thread.sleep(2000);

	}

	public void ApproveJob(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='cp1_grdJobsViewForEmployer_jobHeaderLink_0']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#tabContentJobDetails']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[text()='Approve']")).click();


		WebDriverWait wait = new WebDriverWait(Utilities.objTestCaseDriver, 300 /*timeout in seconds*/);

		if(wait.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert was not present");
		else
			System.out.println("alert was present");
		Alert alert = Utilities.objTestCaseDriver.switchTo().alert();
		alert.accept();
	}

	public void RSEViewButton(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='cp1_grdJobsViewForEmployer_jobHeaderLink_0']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='29 KM away']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[text()='View profile']")).click();
		String profileName = Utilities.objTestCaseDriver.findElement(By.xpath("//h1")).getText();

		Assert.assertEquals(profileName, Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat"));
	}

	public void RSEEditButton(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='cp1_grdJobsViewForEmployer_jobHeaderLink_0']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='29 KM away']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[text()='Edit']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//textarea[@id='field-aboutme']")).sendKeys(Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "AboutMe"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//span[@title='Update']")).click();

	}

	public void RSEDeleteButton(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='cp1_grdJobsViewForEmployer_jobHeaderLink_0']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[text()='Delete']")).click();

		Alert alert = Utilities.objTestCaseDriver.switchTo().alert();
		alert.accept();

	}


	public void SeekerEditProfileCheck(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		String profileEdit = Utilities.objTestCaseDriver.findElement(By.xpath("//div[@class='personValue grid_6']")).getText();

		Assert.assertEquals(profileEdit, Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "AboutMe"));

	}

	public void RSEFiltersCheck(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		System.out.println("//a[@href='job-"+JobID+"']");
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#tabContentCandidates']")).click();

		//-----Score 60%+
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='sixty']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='sixty']")).isSelected();

		if(this.objUtil.isElementPresent("//span[@class='text-primary']", 5)==true){
			Assert.fail("Score 60%_+ validation failed");	
		}
		else {
			System.out.println("Filter Passed");
		}

		//-----Registered by Babajob
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='registered']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='registered']")).isSelected();

		if(this.objUtil.isElementPresent("//span[@class='text-primary']", 5)==true){
			Assert.fail("Score 60%_+ validation failed");	
		}
		else {
			System.out.println("Filter Passed");
		}

		//-----In Rs 10000 - 14000 Salary Range
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='range']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='range']")).isSelected();

		if(this.objUtil.isElementPresent("//span[@class='text-primary']", 5)==true){
			Assert.fail("Score 60%_+ validation failed");	
		}
		else {
			System.out.println("Filter Passed");
		}

		//-----Candidates who called me
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='called']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='called']")).isSelected();

		if(this.objUtil.isElementPresent("//span[@class='text-primary']", 5)==true){
			Assert.fail("Score 60%_+ validation failed");	
		}
		else {
			System.out.println("Filter Passed");
		}

		//-----Within 15 km
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='nearby']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='nearby']")).isSelected();

		if(this.objUtil.isElementPresent("//span[@class='text-primary']", 5)==true){
			System.out.println("Filter Passed");

		}
		else {
			Assert.fail("Score 60%_+ validation failed");	
		}

		//-----Exclude Mobile Users
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='hide_mobile']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='hide_mobile']")).isSelected();

		if(this.objUtil.isElementPresent("//span[@class='text-primary']", 5)==true){
			System.out.println("Filter Passed");

		}
		else {
			Assert.fail("Score 60%_+ validation failed");	
		}

		//-----Only Mobile Users
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='only_mobile']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//input[@id='only_mobile']")).isSelected();

		if(this.objUtil.isElementPresent("//span[@class='text-primary']", 5)==true){
			Assert.fail("Score 60%_+ validation failed");	
		}
		else {
			System.out.println("Filter Passed");
		}

		//-----Interview Date


	}

	public void NavigateToJobDetails(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='cp1_grdJobsViewForEmployer_jobHeaderLink_0']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#tabContentJobDetails']")).click();

	}


	public void RSEUnlockCheck(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#tabContentCandidates']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[text()='Unlock Mobile']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//a/span[text()='Unlocked']")).click();

		objUtil.isElementPresent("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']", 5);
		String check = Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']")).getText();

		Assert.assertEquals(check, Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='Active']")).click();


	}

	public void RSEInterviewCheck(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#tabContentCandidates']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//div[@id='candidates-tab']/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/label")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='bulk-action-schedule-interview']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//form/div/div/div[2]/div/div[2]/input")).sendKeys("09/12/2015 05:00 pm");
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[text()='Schedule']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='Interview']")).click();

		objUtil.isElementPresent("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']", 5);

		String check = Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']")).getText();
		Assert.assertEquals(check, Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='Active']")).click();

	}
	public void RSEOfferCheck(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#tabContentCandidates']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//div[@id='candidates-tab']/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/label")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='bulk-action-offer']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='Offered']")).click();

		objUtil.isElementPresent("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']", 5);

		String check = Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']")).getText();
		Assert.assertEquals(check, Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='Active']")).click();

	}

	public void RSEHireCheck(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#tabContentCandidates']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//div[@id='candidates-tab']/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/label")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='bulk-action-hire']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='Hired']")).click();

		objUtil.isElementPresent("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']", 5);

		String check = Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']")).getText();
		Assert.assertEquals(check, Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='Active']")).click();

	}
	
	public void RSERejectCheck(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#tabContentCandidates']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//div[@id='candidates-tab']/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/label")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='bulk-action-reject']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='Rejected']")).click();

		objUtil.isElementPresent("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']", 5);

		String check = Utilities.objTestCaseDriver.findElement(By.xpath("//span[text()='"+Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat")+"']")).getText();
		Assert.assertEquals(check, Utilities.objTestData.TestDataValue(rownum,ExcelFileName, SheetName, "SeekerNameFormat"));
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='Active']")).click();

	}
	
	public void RSESMSCheck(int rownum,String ExcelFileName, String SheetName) throws BiffException, IOException, InterruptedException{

		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@href='#tabContentCandidates']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//div[@id='candidates-tab']/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/label")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[@id='bulk-action-send-sms']")).click();
		Utilities.objTestCaseDriver.findElement(By.xpath("//div[2]/div[2]/textarea")).sendKeys("Testing.Testing");
		Utilities.objTestCaseDriver.findElement(By.xpath("//button[text()='Send']")).click();

		String check = Utilities.objTestCaseDriver.findElement(By.xpath("//div[@class='bg-success']")).getText();
		Assert.assertEquals(check, "Success. You can close this pop-up now.");
		Utilities.objTestCaseDriver.findElement(By.xpath("//a[@id='Active']")).click();

	}






}










