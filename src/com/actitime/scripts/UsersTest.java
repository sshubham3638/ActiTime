package com.actitime.scripts;
import org.testng.annotations.Test;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.CreateNewUsers;
import com.actitime.pageobjects.EditProjInfo;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.UserListPage;

public class UsersTest extends BaseLib
{
	@Test(enabled=false)
	public void createNewUser()
	{
		String filepath = "./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filepath, "sheet1", 9, 1);
		String password = ExcelUtilities.readData(filepath, "sheet1", 9, 2);
		LoginPage lp = new LoginPage(driver);
		lp.Login(username, password);
		UserListPage ulp=new UserListPage(driver);
		ulp.clickOnUsers();
		ulp.clickOnCreateNewusers();
		String newusername = ExcelUtilities.readData(filepath, "sheet1", 9, 6);
		String newpassword = ExcelUtilities.readData(filepath, "sheet1", 9, 7);
		CreateNewUsers cnu= new CreateNewUsers(driver);
		cnu.enterUserName(newusername);
		cnu.enterPassword(newpassword);
		cnu.enterPassword(newpassword);
		String firstName = ExcelUtilities.readData(filepath, "sheet1", 9, 8);
		String lastName = ExcelUtilities.readData(filepath, "sheet1", 9, 9);
		cnu.enteName(firstName, lastName);
		String email = ExcelUtilities.readData(filepath, "sheet1", 9, 10);		
		cnu.enterEmail(email);
		cnu.clickOnCreateUser();
		ulp.verifyCreateUsers();
	}
	@Test(enabled=false)
	public void NewUserLogin()
	{
		String filepath = "./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filepath, "sheet1", 9, 6);
		String password = ExcelUtilities.readData(filepath, "sheet1", 9, 7);
		LoginPage lp= new LoginPage(driver);
		lp.Login(username, password);
		
		
	}
	@Test()
	public void DeleteUsers() throws InterruptedException
	{
		String filepath = "./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filepath, "sheet1", 9, 1);
		String password = ExcelUtilities.readData(filepath, "sheet1", 9, 2);
		LoginPage lp = new LoginPage(driver);
		lp.Login(username, password);
		UserListPage ulp=new UserListPage(driver);
		ulp.clickOnUsers();
		String firstName = ExcelUtilities.readData(filepath, "sheet1", 9, 8);
		String lastName = ExcelUtilities.readData(filepath, "sheet1", 9, 9);
		String userName = ExcelUtilities.readData(filepath, "sheet1", 9, 6);
		String userSelDel = lastName+", "+firstName+" "+"("+userName+")";
		ulp.userSearch(userSelDel);
		EditProjInfo epi= new EditProjInfo(driver);
		epi.clickOnDelProj();
		
	}
	
}
