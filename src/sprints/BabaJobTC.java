package sprints;

import common.Utilities;

public class BabaJobTC {

	BabaJobMod objModules = new BabaJobMod();
	common.Utilities objUtilities = new common.Utilities();


	public void SeekerReflectedInRSE(String TestCaseID, String TestData_FileName,String TestData_SheetName,String BrowserName, String BrowserVersion,String OSName, String OSVersion,String Resolution) throws Exception {

		try {
			objUtilities.LaunchApplication(BrowserName, BrowserVersion, OSName, OSVersion, Resolution, "http://staging.babajob.com");
			objUtilities.SignInEmployer(Utilities.rownum, TestData_FileName, TestData_SheetName);
			//objModules.EmployerPostJob(Utilities.rownum, TestData_FileName, TestData_SheetName);
			//objModules.ApproveJob(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.FetchingJobID(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.SignOutEmployer();
			/*DELETE*/ objUtilities.SignInSeeker(Utilities.rownum, TestData_FileName, TestData_SheetName);
			//objModules.RegisterationSeeker(Utilities.rownum, TestData_FileName, TestData_SheetName);
			//objModules.VerifySeekerMobile(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.SeekerApplyJob(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.SignOutSeeker();
			objUtilities.SignInEmployer(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.EmployerCheckRSE(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.SignOutEmployer();
			//objUtilities.SignInSeeker(Utilities.rownum, TestData_FileName, TestData_SheetName);
			//objModules.DeleteSeeker(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.CloseApplication();

		}

		catch (Exception e) {
			String[] str_Error = e.getMessage().split("\n");
			String ErrorMessage = str_Error[0];

			System.out.println(ErrorMessage);
			objUtilities.CloseApplication();
		}

		Utilities.objTestCaseDriver.quit();
	}

	public void RSEFiltersFunctionalityCheck(String TestCaseID, String TestData_FileName,String TestData_SheetName,String BrowserName, String BrowserVersion,String OSName, String OSVersion,String Resolution) throws Exception {

		try {
			objUtilities.LaunchApplication(BrowserName, BrowserVersion, OSName, OSVersion, Resolution, "http://www.staging.babajob.com");			
			objUtilities.SignInEmployer(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.NavigateToJobDetails(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.FetchingJobID(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSEFiltersCheck(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.CloseApplication();

		}

		catch (Exception e) {
			String[] str_Error = e.getMessage().split("\n");
			String ErrorMessage = str_Error[0];

			System.out.println(ErrorMessage);
			objUtilities.CloseApplication();
		}

		Utilities.objTestCaseDriver.quit();
	}

	public void RSEDeleteEditView(String TestCaseID, String TestData_FileName,String TestData_SheetName,String BrowserName, String BrowserVersion,String OSName, String OSVersion,String Resolution) throws Exception {

		try {
			objUtilities.LaunchApplication(BrowserName, BrowserVersion, OSName, OSVersion, Resolution, "http://www.staging.babajob.com");			
			objUtilities.SignInEmployer(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSEViewButton(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSEEditButton(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.SignOutEmployer();
			objUtilities.SignInSeeker(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.SeekerEditProfileCheck(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.SignOutSeeker();
			objUtilities.SignInEmployer(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSEDeleteButton(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.SignInSeekerInvalid(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.CloseApplication();

		}

		catch (Exception e) {
			String[] str_Error = e.getMessage().split("\n");
			String ErrorMessage = str_Error[0];

			System.out.println(ErrorMessage);
			objUtilities.CloseApplication();
		}

		Utilities.objTestCaseDriver.quit();
	}

	public void RSEEmployerFeaturesCheck(String TestCaseID, String TestData_FileName,String TestData_SheetName,String BrowserName, String BrowserVersion,String OSName, String OSVersion,String Resolution) throws Exception {

		try {
			
			objUtilities.LaunchApplication(BrowserName, BrowserVersion, OSName, OSVersion, Resolution, "http://www.staging.babajob.com");			
			objUtilities.SignInEmployer(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSEUnlockCheck(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSEInterviewCheck(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSEOfferCheck(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSEHireCheck(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSERejectCheck(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objModules.RSESMSCheck(Utilities.rownum, TestData_FileName, TestData_SheetName);
			objUtilities.SignOutEmployer();
			
			objUtilities.CloseApplication();

		}

		catch (Exception e) {
			String[] str_Error = e.getMessage().split("\n");
			String ErrorMessage = str_Error[0];

			System.out.println(ErrorMessage);
			objUtilities.CloseApplication();
		}

		Utilities.objTestCaseDriver.quit();
	}

}
