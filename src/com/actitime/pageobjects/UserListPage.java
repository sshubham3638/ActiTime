package com.actitime.pageobjects;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class UserListPage extends BasePage{

	   WebDriver driver;
	   @FindBy(id="ext-gen22")
	   private WebElement createNewUserBtn;
	   @FindBy(className="successmsg")
	     private WebElement successMsg;
	   @FindBy(css="td[class='listtblcell userNameTableCell userWithoutGroupCell']")
	   private List<WebElement> userListLink;
	   
	   
	   
	public UserListPage(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
     public void clickOnCreateNewusers()
     {
    	 createNewUserBtn.click();
     }
     public void verifyCreateUsers()
     {
    	 String expected = "User account has been successfully created.";
    	 String actual = successMsg.getText();
    	 Assert.assertEquals(actual, expected);
    	 Reporter.log(expected,true);
     }
     
     public void userSearch(String userSelDel)
     {
    	 Iterator<WebElement> itr= userListLink.listIterator();
    	 while (itr.hasNext()) {

       	  try {
			WebElement userLink = itr.next();
			   String user= userLink.getText();

			  if (user.equals(userSelDel)) {
				  userLink.click();
				
			}
			  else {
				  System.out.println("user not found");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	  }
    	 
    	 
    	 
    	 
    	 
    	 
     }}


