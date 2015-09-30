package common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DriverScript 

{
	File MyExcelFile;
	Workbook objbook;
	Sheet objSheet;
	int row=1;
	String Role;
	String DriverFlag;
	String FileName;
	String SheetName;
	String TestCaseName;
	String TestCaseID;
	String Browser;
	String FQClasssName;
	String Browsername,BrowserVersion,OSName, OSVersion,Resolution;


	common.Utilities Utilities=new common.Utilities();


	@DataProvider(name = "DriverDataRetriever")
	public Object[][] DataRetriever() throws BiffException, IOException
	{
		common.ExcelParser exlPrsr=new common.ExcelParser();
		File tstExcl=new File("C:/babajob/Driver/DriverScript.xls");
		Workbook objBook=Workbook.getWorkbook(tstExcl);
		Sheet TstSheet=objBook.getSheet("Driver");
		Object[][] driverdataArray=new Object[TstSheet.getRows()-1][TstSheet.getColumns()-1];
		driverdataArray=exlPrsr.DriverDataProvider("C:/babajob/Driver/DriverScript.xls","Driver");
		return driverdataArray;
	}

	@Test(dataProvider="DriverDataRetriever")

	public void CallingTestCases(String D_TestID,String D_TestCaseName,String D_DriverFlag,String D_FileName,String D_SheetName,String D_FQClasssName,String D_Browsername, String D_BrowserVersion,String D_OSName, String D_OSVersion,String D_Resolution ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, BiffException, IOException 
	{

		this.TestCaseID=D_TestID;
		//this.TestCaseName=D_TestCaseName;
		//this.Role=D_Role;
		this.DriverFlag=D_DriverFlag;
		this.FileName=D_FileName;
		this.SheetName=D_SheetName;
		//this.Browser=D_Browser;
		this.FQClasssName=D_FQClasssName;
		this.Browsername=D_Browsername;
		this.BrowserVersion=D_BrowserVersion;
		this.OSName=D_OSName;
		this.OSVersion=D_OSVersion;
		this.Resolution=D_Resolution;


		/*Class<?> refCls = Class.forName(FQClasssName);
			Object objDriver = refCls.newInstance();
			Method meth=refCls.getDeclaredMethod("setRow");
			Method methIteration=refCls.getDeclaredMethod("setIterationCount");
			Method methStepNumber=refCls.getDeclaredMethod("stepNumber");

			meth.invoke(objDriver);
			methIteration.invoke(objDriver);
			methStepNumber.invoke(objDriver);*/

		Utilities.setRow();

		if(DriverFlag.equalsIgnoreCase("Y"))
		{
			File tstExcl=new File(D_FileName);
			Workbook objBook=Workbook.getWorkbook(tstExcl);
			Sheet TstSheet=objBook.getSheet(D_SheetName);
			String [][] dataArray=new String[TstSheet.getRows()-1][2];
			common.ExcelParser exlPrsr=new common.ExcelParser();
			dataArray=exlPrsr.TestDataProvider(D_FileName, D_SheetName);
			//i_IterationCount = 0;
			for(int i=0;i<dataArray.length;i++)
				executeTest(dataArray[i][0],dataArray[i][1],D_FQClasssName);

		}

	}


	public void executeTest(String TestID,String TestDriverFlag,String D_FQClasssName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		Class<?> refCls = Class.forName(D_FQClasssName);
		Object obj = refCls.newInstance();

		Utilities.assign();

		if(TestDriverFlag.equalsIgnoreCase("Y")) 
		{
			if(TestCaseID.equals(TestID))
			{


				@SuppressWarnings("rawtypes")
				Class[] dataTypeArray={String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
				Object[] actualParameters={TestCaseID, FileName, SheetName,Browsername,BrowserVersion,OSName, OSVersion,Resolution};

				Method method=refCls.getDeclaredMethod(TestCaseID, dataTypeArray);		
				method.invoke(obj,actualParameters);


			}

		}

	}

}

