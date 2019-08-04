package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProjPage
{
	    @FindBy(name="customerId")
	   private WebElement customerNameDrpDwn;
	    @FindBy(name="name")
	    private WebElement projNamBx;
	    @FindBy(name="createProjectSubmit")
	    private WebElement createProjBtn;
	
	    public CreateNewProjPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
   
   public void selectCustName(String customerName)
   {
	   Select sel = new Select(customerNameDrpDwn);
	   sel.selectByVisibleText(customerName);
   }
   
  public void EntrProjNam(String projectName)
  {
	  projNamBx.sendKeys(projectName);
  }
  public void createProjClk()
  {
	  createProjBtn.click();
  }

public WebElement getCustomerNameDrpDwn() {
	return customerNameDrpDwn;
}

public WebElement getProjNamBx() {
	return projNamBx;
}

public WebElement getCreateProjBtn() {
	return createProjBtn;
}
  
}
