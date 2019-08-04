
	package com.actitime.pageobjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

	public class OpenTaskPage {
		@FindBy(linkText="Projects & Customers")
		private WebElement projncustLink;
		@FindBy(css="input[value='Create New Tasks']")
		private WebElement createTaskBtn;
		@FindBy(id="cpSelector.cpButton.contentsContainer")
		private WebElement customerAndProjDrpDwn;
		@FindBy(name="visiableFilterString")
		private WebElement filterTaskBx;
		@FindBy(name="searchTasks")
		private WebElement applyFilterBtn;
		@FindBy(css="input[type='checkbox']")
		private WebElement taskChkBx;
		@FindBy(css="input[value='Delete Selected Tasks']")
		private WebElement deleteTaskBtn;
		@FindBy(id="deleteButton")
		private WebElement deleteCnfrmBtn;
		@FindBy(className="successmsg")
	     private WebElement successMsg;
		
		
		public OpenTaskPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		public void clickonProjnCustLink()
		{
			projncustLink.click();
		}
		public void clickOnCreateNewTask()
		{
			createTaskBtn.click();
		}
		/*public void selectCustAndProj(String projectName)
		{
			customerAndProjDrpDwn.click();
			Select sel= new Select(customerAndProjDrpDwn);
			sel.selectByVisibleText(projectName);
			
		}*/
		public void filterTaskByName(String taskName)
		{
			filterTaskBx.sendKeys(taskName);
		}
		public void clickOnApplyFilterBtn()
		{
			applyFilterBtn.click();
		}
		public void clickOnChkBxSelectTaskDel()
		{
			taskChkBx.click();
		}
		public void clickOnDelTaskBtn()
		{
			deleteTaskBtn.click();
		}
		public void deleteTask()
		{
			deleteCnfrmBtn.click();
		}
		 public void verifyDeleteTaskMsg()
    	 {
    		 String expMsg = "Selected tasks have been successfully deleted.";
    		 String actMsg= successMsg.getText();
    		 Assert.assertEquals(actMsg, expMsg);
    		 Reporter.log(expMsg,true);
    	 }
		public WebElement getProjncustLink() {
			return projncustLink;
		}
		public WebElement getCreateTaskBtn() {
			return createTaskBtn;
		}
		public WebElement getCustomerAndProjDrpDwn() {
			return customerAndProjDrpDwn;
		}
		public WebElement getFilterTaskBx() {
			return filterTaskBx;
		}
		public WebElement getApplyFilterBtn() {
			return applyFilterBtn;
		}
		public WebElement getTaskChkBx() {
			return taskChkBx;
		}
		public WebElement getDeleteTaskBtn() {
			return deleteTaskBtn;
		}
		public WebElement getDeleteCnfrmBtn() {
			return deleteCnfrmBtn;
		}
		public WebElement getSuccessMsg() {
			return successMsg;
		}

	}

