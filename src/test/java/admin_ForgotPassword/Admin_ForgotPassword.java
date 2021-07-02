package admin_ForgotPassword;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class Admin_ForgotPassword extends BaseClass{


	@BeforeTest

	public static void ExtentReport() throws Throwable {

		Extentreport("Brandscape", "Brandscape Automation", "Ajith Kumar", "\\ExtentReports\\ExtentReport.html");
	}

	@Test
	public static void ForgotPassword() throws Throwable {

	
		ExtentReportName("Forgot Password");
		
		
		LaunchPWAURLinChromeDriver("URL");
		//LaunchURLinFirefoxDriver("URL");
		LogInfo("Brandscape URL loaded successfully");

		TimeWait();
		
		GetWebElementandClick("ForgotPassword");
		TypeDataInTheElement("ForgotPasswordEmail", "demobrand0101@yopmail.com");
		GetWebElementandClick("ForgotPasswordSubmit");
		
		Thread.sleep(20000);
		TypeDataInTheElement("NewPassword", "Bsw@543210");
		TypeDataInTheElement("ConfirmPassword", "Bsw@543210");
		GetWebElementandClick("ForgotPasswordSubmit");
		
		
		Thread.sleep(5000);
		WebElement Email =	GetWebElement("Email");
		if(Email.isDisplayed()) {
			ConditionPass("Password change successfull");
			LogInfo("Password change successfull");
		}
		else {
			ConditionFail("Password change Failed");
			LogInfo("Password change Failed");
		}
		
		
}
}