
	package com.actitime.pageobjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Assert;
	import org.testng.Reporter;

	public abstract class BasePage 
	{
	    @FindBy(css="img[src*='/img/default/top_nav/default-logo.png']")
	    private WebElement logo;
	    @FindBy(xpath="//div[text()='Tasks']")
	    private WebElement task;
	    @FindBy(id="logoutLink")
	    private WebElement Logout;
	    @FindBy(xpath="//div[text()='Users']")
	    private WebElement users;
	    public BasePage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }
	    
	    
	    
	    public WebElement getTask() {
			return task;
		}



		public void verifyLogo() {
	    	
	    	Assert.assertTrue(logo.isDisplayed());
	    	Reporter.log("Home Page displayed", true);
	    }
	    public void clickOnTask()
	    {
	    	task.click();
	    }
	    public void logout()
	    {
	    	Logout.click();
	    }
	    public void clickOnUsers()
	    {
	    	users.click();
	    }



		public WebElement getUsers() {
			return users;
		}
	    
	}

