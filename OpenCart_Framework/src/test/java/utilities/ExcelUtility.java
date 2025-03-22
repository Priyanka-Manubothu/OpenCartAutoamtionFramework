package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	String path;
    public ExcelUtility(String path)
    {
    	this.path = path;
    }
    
    public int getRowCount(String SheetName) throws IOException
	{
    	FileInputStream file = new FileInputStream(path);
    	XSSFWorkbook workbook = new XSSFWorkbook(file);
    	XSSFSheet sheet = workbook.getSheet(SheetName); 
    	int rowCount = sheet.getLastRowNum();
    	workbook.close();
    	file.close();
    	return rowCount;
    }
    
    public int getCellCount(String SheetName) throws IOException
	{
    	FileInputStream file = new FileInputStream(path);
    	XSSFWorkbook workbook = new XSSFWorkbook(file);
    	XSSFSheet sheet = workbook.getSheet(SheetName); 
    	XSSFRow row = sheet.getRow(1);
    	int cellCount = row.getLastCellNum();
    	workbook.close();
    	file.close();
    	return cellCount;
    }
    public String getCellData(String SheetName, int row, int col) throws IOException
	{
    	FileInputStream file = new FileInputStream(path);
    	XSSFWorkbook workbook = new XSSFWorkbook(file);
    	XSSFSheet sheet = workbook.getSheet(SheetName); 
        XSSFRow r = sheet.getRow(row);
        XSSFCell c = r.getCell(col);
        
        DataFormatter formatter = new DataFormatter();
        String data;
        try {
        	data = formatter.formatCellValue(c);
        }
        catch(Exception e)
        {
        	data="";
        }
        workbook.close();
    	file.close();
		return data;
    	
	}
}