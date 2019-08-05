	package com.actitime.generic;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.edge.EdgeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.ITestResult;
	import org.testng.Reporter;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;


	public class BaseLib
	{
		public static WebDriver driver;
		
		@BeforeMethod
		@Parameters({"browser","baseurl"})
		public void setUp(String browserName, String url)
		{
			if (browserName.equalsIgnoreCase("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver","./exeFiles/geckodriver.exe");
				driver= new FirefoxDriver();
				Reporter.log("firefox", true);
			}
			else if (browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","./exeFiles/chromedriver.exe");
				driver= new ChromeDriver();
				Reporter.log("chrome launched", true);
			
			}
			else if (browserName.equalsIgnoreCase("me"))
			{
				System.setProperty("webdriver.edge.driver", "./exeFiles/MicrosoftWebDriver.exe");
				driver= new EdgeDriver();
				Reporter.log("IE launched", true);
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
			Reporter.log("navigated to url"+url, true);
			
			
		}
		@AfterMethod
		public void tearDown(ITestResult result)
		{
			String scriptName = result.getMethod().getMethodName();
			if (result.isSuccess()) //true-->pass
			{
				Reporter.log(scriptName+" script is passed :)", true);
			}
			else //false--.failed
			{
				ScreenShotLib slib= new ScreenShotLib(driver);
				slib.getScreenShot(scriptName);
				Reporter.log("screenshot taken", true);
			}
			//driver.close();
			Reporter.log("browser is closed", true);
		}
		
		

	}



