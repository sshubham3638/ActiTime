
	package com.actitime.scripts;

	import org.testng.annotations.Test;

	import com.actitime.generic.BaseLib;
	import com.actitime.generic.ExcelUtilities;
	import com.actitime.pageobjects.EnterTimeTrackpage;
	import com.actitime.pageobjects.LoginPage;

	public class LoginTest extends BaseLib
	{
	    @Test(priority=1)
	    public void validLogin()
	    {
	    	
	    	String filepath="./testdata/testdata.xlsx";
	    	String username = ExcelUtilities.readData(filepath, "sheet1", 1, 1);
	    	String password= ExcelUtilities.readData(filepath, "sheet1", 1, 2);
	    	LoginPage lp= new LoginPage(driver);
	    	lp.Login(username, password);
	    	EnterTimeTrackpage ettp= new EnterTimeTrackpage(driver);
	    	ettp.verifyLogo();
	    	ettp.verifyHomePageTitle();
	    	
	    }
	    @Test(enabled=false)
	    public void invalidLogin()
	    {
	    	String filepath = "./testdata/testdata.xlsx";
	    	String username = ExcelUtilities.readData(filepath, "sheet1", 2, 1);
	    	String password = ExcelUtilities.readData(filepath, "sheet1", 2,2);
	    	LoginPage lp= new LoginPage(driver);
	    	lp.Login(username, password);
	    	
	    }
	}
	 
