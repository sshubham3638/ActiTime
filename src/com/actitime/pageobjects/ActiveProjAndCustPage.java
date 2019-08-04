	package com.actitime.pageobjects;

	import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
	import org.testng.Reporter;

	public class ActiveProjAndCustPage extends BasePage
	{
	     @FindBy(css="input[value='Create New Customer']")
	     private WebElement createNewCustBtn;
	     @FindBy(className="successmsg")
	     private WebElement successMsg;
	     @FindBy(name="selectedCustomer")
	     private WebElement customerDrpDwn;
	     @FindBy(css="input[value*='Show']")
	     private WebElement showBtn;
	     @FindBy (xpath="//td[starts-with(@id,'customerName')]//a[contains(@href,'customerId')]")
	     private List<WebElement> customerLink;
	     @FindBy(css="input[value='Create New Project']")
	     private WebElement createNewProjBtn;
	     @FindBy(xpath="//td[starts-with(@id,'projectName')]//a[contains(@href,'projects')]")
	     private List<WebElement> projectLink;
	     
	     public ActiveProjAndCustPage(WebDriver driver)
	     {
	    	 super(driver);
	    	 PageFactory.initElements(driver, this);
	     }
	     public void clickOnCreateNewCustBtn() {
	    	 createNewCustBtn.click();
			
		}
	     public void verifyCreateCustomerMsg( String customerName)
	     {
	    	 Assert.assertTrue(successMsg.isDisplayed());
	    	 Assert.assertTrue(successMsg.getText().contains(customerName));
	    	 Reporter.log(successMsg.getText(),true);
	     }
	     public void showCustomer(String customerName)
	     {
	    	 Select sel= new Select(customerDrpDwn);
	    	 sel.selectByVisibleText(customerName);
	    	 showBtn.click();
	    	 if (customerLink.get(0).getText().equals(customerName)) 
	    	 {
				customerLink.get(0).click();
			}
	    	 else {
	    		 Reporter.log(customerName+"customer name doesn't exist ",true);
	    	 }
				
			}
	    	 public void verifyDeleteCustMsg()
	    	 {
	    		 String expMsg = "Customer has been successfully deleted.";
	    		 String actMsg= successMsg.getText();
	    		 Assert.assertEquals(actMsg, expMsg);
	    		 Reporter.log(expMsg,true);
	    	 }
	    	 public void clickOnCreateNewProjBtn()
	    	 {
	    		 createNewProjBtn.click();
	    	 }
	    	 public void verifyCreateProjMsg(String projectName)
	    	 {
	    		 Assert.assertTrue(successMsg.isDisplayed());
	    		 Assert.assertTrue(successMsg.getText().contains(projectName));
	    		 Reporter.log(successMsg.getText(),true);
	    	 }
	    	  public void showProject(String customerName, String projectName)
	 	     {
	 	    	 Select sel= new Select(customerDrpDwn);
	 	    	 sel.selectByVisibleText(customerName);
	 	    	 showBtn.click();
	 	    	 Iterator<WebElement> itr= projectLink.iterator();
	 	    	while (itr.hasNext()) {
	 	    		 WebElement proDelLink = itr.next();
	 	    		 String proDel = proDelLink.getText();
	 	    		 if (proDel.equals(projectName)) {
	 	    			proDelLink.click();
						
					} else {
						Reporter.log(projectName+"does not exist", true);

					}
					
				} 
	 	   }
	    	  
	    	  public void verifyDeleteProjMsg()
		    	 {
		    		 String expMsg = "Project has been successfully deleted.";
		    		 String actMsg= successMsg.getText();
		    		 Assert.assertEquals(actMsg, expMsg);
		    		 Reporter.log(expMsg,true);
		    	 }
	    	  
	}

