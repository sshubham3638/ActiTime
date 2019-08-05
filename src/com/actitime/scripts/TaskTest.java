
package com.actitime.scripts;
import org.testng.annotations.Test;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.generic.WaitStatementLib;
import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjPage;
import com.actitime.pageobjects.CreateNewTask;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EditProjInfo;
import com.actitime.pageobjects.EnterTimeTrackpage;
	import com.actitime.pageobjects.LoginPage;
	import com.actitime.pageobjects.OpenTaskPage;

	public class TaskTest extends BaseLib
	{
	   @Test(enabled=false)
	   public void createCustomer()
	   {

	   	String filepath="./testdata/testdata.xlsx";
	   	String username = ExcelUtilities.readData(filepath, "sheet1", 3, 1);
	   	String password= ExcelUtilities.readData(filepath, "sheet1", 3, 2);
	   	LoginPage lp= new LoginPage(driver);
	   	lp.Login(username, password);
	   	
	   	EnterTimeTrackpage ettp = new EnterTimeTrackpage(driver);
	   	ettp.clickOnTask();
	   	OpenTaskPage otp= new OpenTaskPage(driver);
	   	otp.clickonProjnCustLink();
	   	ActiveProjAndCustPage apcp= new ActiveProjAndCustPage(driver);
	   	apcp.clickOnCreateNewCustBtn();
	   	
	   	String customerName = ExcelUtilities.readData(filepath, "sheet1", 3, 3);
	   	CreateNewCustPage cncp= new CreateNewCustPage(driver);
	   	cncp.createCustomer(customerName);
	   	apcp.verifyCreateCustomerMsg(customerName);
	   	apcp.logout();
	   }
	   @Test(enabled=false)//(dependsOnMethods= {"createCustomer"})
	   public void deleteCustomer()
	   {
		   
		   String filepath = "./testdata/testdata.xlsx";
		   String username = ExcelUtilities.readData(filepath, "sheet1", 4, 1);
		    String password = ExcelUtilities.readData(filepath, "sheet1", 4, 2);
		   LoginPage lp = new LoginPage(driver);
		   lp.Login(username, password);
		   
		   EnterTimeTrackpage ettp= new EnterTimeTrackpage(driver);
		   WaitStatementLib wlib= new WaitStatementLib(driver);
		   wlib.eWaitforVisible(20, ettp.getTask() );
		   ettp.clickOnTask();
		   OpenTaskPage otp= new OpenTaskPage(driver);
		   otp.clickonProjnCustLink();
		   
		   String customerName = ExcelUtilities.readData(filepath, "sheet1", 4,3 );
		   ActiveProjAndCustPage apcp= new ActiveProjAndCustPage(driver);
		   apcp.showCustomer(customerName);
		   EditCustInfoPage ecip= new EditCustInfoPage(driver);
		   
		   ecip.deleteCustomer();
		   apcp.verifyDeleteCustMsg();
		   apcp.logout();
	   }
	   @Test(enabled=false)
		public void createProject()
		{
			String filepath = "./testdata/testdata.xlsx";
			String username = ExcelUtilities.readData(filepath, "sheet1",7, 1);
			String password = ExcelUtilities.readData(filepath, "sheet1", 7, 2);
			LoginPage lp= new LoginPage(driver);
			lp.Login(username, password);
			EnterTimeTrackpage ettp= new EnterTimeTrackpage(driver);
			ettp.clickOnTask();
			OpenTaskPage otp= new OpenTaskPage(driver);
			otp.clickonProjnCustLink();
			ActiveProjAndCustPage apcp= new ActiveProjAndCustPage(driver);
			apcp.clickOnCreateNewProjBtn();
			String customerName = ExcelUtilities.readData(filepath, "sheet1", 7, 3);
			CreateNewProjPage cnpp= new CreateNewProjPage(driver);
			WaitStatementLib Wlib= new WaitStatementLib(driver);
			Wlib.eWaitforVisible(10, cnpp.getCustomerNameDrpDwn());
			cnpp.selectCustName(customerName);
			String projectName = ExcelUtilities.readData(filepath, "sheet1", 7, 4);
			Wlib.eWaitforVisible(10, cnpp.getProjNamBx());
			cnpp.EntrProjNam(projectName);
			Wlib.eWaitforVisible(10, cnpp.getCreateProjBtn());
			cnpp.createProjClk();
			
			apcp.verifyCreateProjMsg(projectName);
			apcp.logout();
			
		}
		@Test(enabled=false)//(dependsOnMethods= {"createProject"})
		public void DeleteProject()
		{
			String filepath = "./testdata/testdata.xlsx";
			String username = ExcelUtilities.readData(filepath, "sheet1",8, 1);
			String password = ExcelUtilities.readData(filepath, "sheet1", 8, 2);
			LoginPage lp= new LoginPage(driver);
			lp.Login(username, password);
			EnterTimeTrackpage ettp= new EnterTimeTrackpage(driver);
			ettp.clickOnTask();
			OpenTaskPage otp= new OpenTaskPage(driver);
			otp.clickonProjnCustLink();
			String customerName = ExcelUtilities.readData(filepath, "sheet1", 6,3 );
			ActiveProjAndCustPage apcp= new ActiveProjAndCustPage(driver);
			//apcp.showCustomer(customerName);
			String projectName = ExcelUtilities.readData(filepath, "sheet1", 6, 4);
			apcp.showProject(customerName, projectName);
			EditProjInfo epi= new EditProjInfo(driver);
			epi.clickOnDelProj();
			apcp.verifyDeleteProjMsg();
			
			
		}
		@Test(enabled=false)
		  public void CreateTask() 
		  {
			    String filepath = "./testdata/testdata.xlsx";
				String username = ExcelUtilities.readData(filepath, "sheet1",7, 1);
				String password = ExcelUtilities.readData(filepath, "sheet1", 7, 2);
				LoginPage lp= new LoginPage(driver);
				lp.Login(username, password);
				EnterTimeTrackpage ettp= new EnterTimeTrackpage(driver);
				ettp.clickOnTask();
				OpenTaskPage otp= new OpenTaskPage(driver);
				otp.clickOnCreateNewTask();
				String customerName = ExcelUtilities.readData(filepath, "sheet1", 7, 3);
				String projectName = ExcelUtilities.readData(filepath, "sheet1", 7, 4);
				CreateNewTask cnt= new CreateNewTask(driver);
				cnt.selectCustFrmDrpDwnInTask(customerName);
				cnt.selectProjFrmDrpDwnInTask(projectName);
				String taskName = ExcelUtilities.readData(filepath, "sheet1", 7, 5);
				cnt.enterTaskName(taskName);
				cnt.calenderBtnClk();
				cnt.calTodayBtnClk();
				cnt.billingTypBilabl();
				cnt.addToTimeTrkChkBxClk();
				cnt.createTaskBtnClk();
		  }
		@Test(enabled=false)
		public void deleteTask()
		{
			String filepath = "./testdata/testdata.xlsx";
			String username = ExcelUtilities.readData(filepath, "sheet1",8, 1);
			String password = ExcelUtilities.readData(filepath, "sheet1", 8, 2);
			LoginPage lp= new LoginPage(driver);
			lp.Login(username, password);
			EnterTimeTrackpage ettp= new EnterTimeTrackpage(driver);
			ettp.clickOnTask();
			//String projectName = ExcelUtilities.readData(filepath, "sheet1", 8, 4);
			String taskName = ExcelUtilities.readData(filepath, "sheet1", 8, 5);
			OpenTaskPage otp= new OpenTaskPage(driver);
			//otp.selectCustAndProj(projectName);
			otp.filterTaskByName(taskName);
			otp.clickOnApplyFilterBtn();
			WaitStatementLib wlib=new WaitStatementLib(driver);
			wlib.eWaitforVisible(20,otp.getTaskChkBx());
			otp.clickOnChkBxSelectTaskDel();
			otp.clickOnDelTaskBtn();
			otp.deleteTask();
			otp.verifyDeleteTaskMsg();
		}
	

	}
	
	

