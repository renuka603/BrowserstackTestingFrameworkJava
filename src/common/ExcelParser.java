/*
 ClassName		: ExcelParser.java
 Description	: This class is used to implement Data-Driven Testing (TestData.xls)
 Created Date	: 11/5/2014	
 Created By		: Shobhit Talwar
 */

package common;

import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelParser {

	/*
	 * FunctionName : DataProvider() Description : This function is used to
	 * store the TestData into an array and return the array Created Date :
	 * 11/5/2014 Created By : Shobhit Talwar
	 */
	File MyExcelFile;
	Workbook objBook;
	Sheet objSheet;
	int i_TotalColumns;
	int d_TotalColumns;
	int i_TotalRows;
	int d_TotalRows;
	String[][] sa_ParameterArray;
	String[][] driver_ParameterArray;
	int tcol;

	public String[][] TestDataProvider(String FileName,String SheetName) throws BiffException, IOException {

		MyExcelFile = new File(FileName);
		objBook = Workbook.getWorkbook(MyExcelFile);
		objSheet = objBook.getSheet(SheetName);

		i_TotalColumns = objSheet.getColumns();
		i_TotalRows = objSheet.getRows();

		sa_ParameterArray = new String[i_TotalRows - 1][2];

		for (int startRow = 1; startRow < i_TotalRows; startRow++) {
			// String FlagRow=objSheet.getCell(3,startRow).getContents();
			for (int startCol = 1; startCol < 3; startCol++) {
				sa_ParameterArray[startRow - 1][startCol - 1] = objSheet.getCell(startCol, startRow).getContents();
			}
		}
		return sa_ParameterArray;

	}

	public String[][] DriverDataProvider(String dFileName, String dSName)
			throws BiffException, IOException {
		File XLFile = new File(dFileName);
		Workbook book = Workbook.getWorkbook(XLFile);
		Sheet osheet = book.getSheet(dSName);
		d_TotalColumns = osheet.getColumns();
		d_TotalRows = osheet.getRows();

		driver_ParameterArray = new String[d_TotalRows - 1][11];

		for (int sRow = 1; sRow < d_TotalRows; sRow++) {
			for (int startCol = 1; startCol < d_TotalColumns; startCol++) {
				driver_ParameterArray[sRow - 1][startCol - 1] = osheet.getCell(
						startCol, sRow).getContents();
			}
		}
		return driver_ParameterArray;

	}

	/*
	 * FunctionName : DataProvider() Description : This function is used to
	 * store the TestData values into an array and return the array (Parameters
	 * form) Created Date : 11/5/2014 Created By : Shobhit Talwar
	 */

	public String TestDataValue(int i, String FileName, String SheetName,String ParameterName) throws BiffException, IOException {
		String str_ReturnValue = null;
		File MyExcelFile = new File(FileName);
		Workbook objbook = Workbook.getWorkbook(MyExcelFile);
		Sheet objSheet = objbook.getSheet(SheetName);
		int TotalColumns = objSheet.getColumns();

		for (int col = 3; col < TotalColumns; col++) {
			String ReturnParameter = objSheet.getCell(col, 0).getContents();
			if (ReturnParameter.equals(ParameterName))
				str_ReturnValue = objSheet.getCell(col, i).getContents();
		}
		return str_ReturnValue;
	}
}
