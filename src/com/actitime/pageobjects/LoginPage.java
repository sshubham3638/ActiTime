
	package com.actitime.pageobjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Assert;
	import org.testng.Reporter;

	public class LoginPage
	{
	        @FindBy(name="username")
	        private WebElement UntTxtBx;
	        @FindBy(name="pwd")
	        private WebElement PwdTxtBx;
	        @FindBy(id="loginButton")
	        private WebElement LogInBtn;
	        
	        @FindBy(xpath="//span[text()='Username or Password is invalid. Please try again.']")
	        private WebElement invalidLoginMsg;
	        
	        public LoginPage(WebDriver driver)
	        {
	        	PageFactory.initElements(driver, this);
	        }
	        public void Login(String username, String password)
	        {
	        	UntTxtBx.sendKeys(username);
	        	PwdTxtBx.sendKeys(password);
	        	LogInBtn.click();
	        }
	        public void verifyinvalidLogin()
	        {
	        	String expMsg = "//span[text()='Username or Password is invalid. Please try again.']";
	                   String actMsg = invalidLoginMsg.getText();
	             Assert.assertEquals(actMsg, expMsg);
	             Reporter.log("invalid login verified", true);
	                   
	        }
	        
	        
	     
	}
