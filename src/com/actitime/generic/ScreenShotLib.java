	package com.actitime.generic;

	import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.events.EventFiringWebDriver;

	public class ScreenShotLib {
		WebDriver driver;
		/***************Constructor********/
		public ScreenShotLib(WebDriver driver)
		{
			this.driver=driver;
		}
	/***************Method For SS***********/
		public void getScreenShot(String scriptName)
		{
			EventFiringWebDriver efw= new EventFiringWebDriver(driver);
			File srcFile = efw.getScreenshotAs(OutputType.FILE);
			File destFile= new File("./Screenshots/"+scriptName+".png");
			try {
				FileUtils.copyFile(srcFile, destFile);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
			


