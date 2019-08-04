package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewTask
{
	@FindBy(name="customerId")
	private WebElement selectCustToAddTaskDrpDwn;
	@FindBy(name="projectId")
	private WebElement selectProjToAddTaskDrpDwn;
	@FindBy(name="task[0].name")
	private WebElement TaskBx;
	@FindBy(xpath="//img[@id='ext-gen7']")
	private WebElement calenderBtn;
	@FindBy(xpath="//button[text()='today']")
	private WebElement calTodayBtn;
	@FindBy(name="task[0].billingType")
	private WebElement billingTypDrpDwn;
	@FindBy(name="task[0].markedToBeAddedToUserTasks")
	private WebElement addToMytimTrkChkBx;
	@FindBy(css="input[onclick='createTasks();']")
	private WebElement createTaskBtn;
	
	
	public CreateNewTask(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selectCustFrmDrpDwnInTask(String customerName)
	{
		Select sel = new Select(selectCustToAddTaskDrpDwn);
		sel.selectByVisibleText(customerName);

	}
	public void selectProjFrmDrpDwnInTask(String projectName)
	{
		Select sel = new Select(selectProjToAddTaskDrpDwn);
		sel.selectByVisibleText(projectName);
	}
	public void enterTaskName(String taskName)
	{
		TaskBx.sendKeys(taskName);
	}
	public void calenderBtnClk()
	{
		calenderBtn.click();
	}
	public void calTodayBtnClk()
	{
		calTodayBtn.click();
	}
	public void billingTypBilabl()
	{
		Select sel= new Select(billingTypDrpDwn);
		sel.selectByVisibleText("Billable");
	}
	public void addToTimeTrkChkBxClk()
	{
		addToMytimTrkChkBx.click();
	}
	public void createTaskBtnClk()
	{
		createTaskBtn.click();
	}
	
}

