package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProjInfo
{
    @FindBy(css="input[value='Delete This Project']")
    private WebElement delProjBtn;
    @FindBy(css="input[value='Delete Project']")
    private WebElement delProjCnfrmBtn;
    
    
	public EditProjInfo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	public void clickOnDelProj()
	{
		delProjBtn.click();
		delProjCnfrmBtn.click();
	}

}
