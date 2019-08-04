	package com.actitime.generic;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelUtilities 
	{
	       public static String readData
	       (String filepath, String sheet, int row, int cell)
	       {
	    	   String value=null;
	    	   
			try {
				 Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filepath)));
				 value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  
	    	   return value;
	    	   
	       }
	}

	
	

