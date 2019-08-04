
	package com.actitime.pageobjects;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.Reporter;

	public class EnterTimeTrackpage extends BasePage
	{
		WebDriver driver;
	  public EnterTimeTrackpage (WebDriver driver)
	  {
		  super(driver);
		  this.driver= driver;
	  }
	  public void verifyHomePageTitle()
	  {
		 String expTitle = "actiTIME - Enter Time-Track";
		 String actTitle = driver.getTitle();
		 Assert.assertEquals(actTitle, expTitle);
		 Reporter.log("Home page Title is verified", true);
		
	  }
		
		
	}
