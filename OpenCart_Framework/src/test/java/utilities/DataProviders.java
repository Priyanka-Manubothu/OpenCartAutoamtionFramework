package utilities;

import java.io.IOException;

import org.testng.annotations.*;

public class DataProviders {

	//Data Provider 1
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException
	{
		
		String path=".\\testData\\LoginData_OpenCart.xlsx";
		
		ExcelUtility excel = new ExcelUtility(path);
		int totalrows = excel.getRowCount("Sheet1");
		int totalcol = excel.getCellCount("Sheet1");
		System.out.println(totalrows);
		System.out.println(totalcol);
		//return logindata;
		
		String logindata[][] = new String[totalrows][totalcol];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int c=0;c<totalcol;c++) {
				logindata[i-1][c] = excel.getCellData("Sheet1",i,c);
				System.out.println(logindata[i-1][c]);
			}
		}
		return logindata;
	}
	
}
