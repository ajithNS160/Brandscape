package endUserProfile;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA_EndUserLogin extends BaseClass{

	@BeforeTest

	public static void ExtentReport() throws Throwable {

		Extentreport("Brandscape", "Brandscape Automation", "Ajith Kumar", "\\ExtentReports\\ExtentReport.html");
	}
	@Test()
	public static void Login() throws Throwable {

		ExtentReportName("Login");

		LaunchPWAURLinChromeDriver("PWAURL");
		//LaunchURLinFirefoxDriver("URL");
		LogInfo("Brandscape URL loaded successfully");

		TimeWait();

		TypeDataInTheElement("PWAEmail", "godhelpus002@yopmail.com");
		LogInfo("Email ID is entered as : godhelpus003@yopmail.com");

		TypeDataInTheElement("PWAPassword", "123");
		LogInfo("Password is entered as: 123");

		GetWebElementandClick("PWASendButton");
		LogInfo("Login button is clicked");

		Thread.sleep(15000);
		GetWebElementandClick("VerifyCode");
		LogInfo("Login button is clicked");
		System.out.println("clicked");
		Thread.sleep(4000);
	WebElement LetsStart = 	GetWebElement("LetsStart");
	if(LetsStart.isDisplayed()) {
		LetsStart.click();
	} else{
		System.out.println("LetsStart is missing");
	}
		Thread.sleep(10000);
		WebElement NotificationIcon =	GetWebElement("NotificationIcon");
		if(NotificationIcon.isDisplayed()) {
			ConditionPass("Login successfull");
			LogInfo("Login successfull");
		}else {
			ConditionFail("Login Failed");
			LogInfo("Login Failed");
		}


	}
}


