package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUsers 
{
	
	@FindBy(name="username")
	private WebElement userNameBx;
	@FindBy(name="passwordText")
	private WebElement passwrdBx;
	@FindBy(name="passwordTextRetype")
	private WebElement passwrdRetypBx;
	@FindBy(name="firstName")
	private WebElement firstNameBx;
	@FindBy(name="lastName")
	private WebElement lastNameBx;
	@FindBy(name="email")
	private WebElement emailBx;
	@FindBy(css="input[value *='Create User']")
	private WebElement createUserBtn;
	
	
   public CreateNewUsers(WebDriver driver) {
	   
	   PageFactory.initElements(driver, this);
   }
   public void enterUserName(String newusername)
   {
	   userNameBx.sendKeys(newusername);
   }
   public void enterPassword(String newpassword)
   {
	   passwrdBx.sendKeys(newpassword);
	   passwrdRetypBx.sendKeys(newpassword);
   }
   public void enteName(String firstName, String lastName)
   {
	   firstNameBx.sendKeys(firstName);
	   lastNameBx.sendKeys(lastName);
   }
   public void enterEmail(String email)
   {
	   emailBx.sendKeys(email);
   }
   public void clickOnCreateUser()
   {
	   createUserBtn.click();
   }
   
}
