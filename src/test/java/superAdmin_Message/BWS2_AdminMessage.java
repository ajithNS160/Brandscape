package superAdmin_Message;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS2_AdminMessage extends BaseClass {
	
	@BeforeTest
	public static void ExtentReport() throws Throwable {

		Extentreport("Brandscape", "Brandscape Automation", "Ajith Kumar", "\\ExtentReports\\ExtentReport.html");
	}
	@Test()
	public static void Login() throws Throwable {

		ExtentReportName("Login");

		LaunchURLinChromeDriver("URL");
		//LaunchURLinFirefoxDriver("URL");
		LogInfo("Brandscape URL loaded successfully");

		TimeWait();

		TypeDataInTheElement("Email", SuperAdminExcel(1, 1, "SuperAdmin Login"));
		LogInfo("Email ID is entered as : " + SuperAdminExcel(1, 1, "SuperAdmin Login"));

		TypeDataInTheElement("Password", SuperAdminExcel(1, 2, "SuperAdmin Login"));
		LogInfo("Password is entered as : " + SuperAdminExcel(1, 2, "SuperAdmin Login"));

		GetWebElementandClick("LoginButton");
		LogInfo("Login button is clicked");

		WebElement Dashboard =	GetWebElement("Dashboard");
		if(Dashboard.isDisplayed()) {
			ConditionPass("Superadmin logged in successfully");
			LogInfo("Superadmin logged in successfully");
		}

		else {
			ConditionFail("Superadmin log in failed");
			LogInfo("Superadmin log in failed");
		}
	//@Test()
	//public static void Login() throws Throwable {
		Thread.sleep(3000);
		GetWebElementandClick("ViewAdminMessage");
		Thread.sleep(6000);
		TypeDataInTheElement("SearchAdminMessage", SuperAdminExcel(1, 1, "Message"));
		Thread.sleep(4000);
		

		//GetWebElementandClick("AdminSelect");
		Calendar("SelectAdminMessage", "Batman Returns");
		Calendar("SelectFromAdminHistory", "superadmin");
		Thread.sleep(5000);
		TakeScreenshot("F:\\Brandscape\\BrandscapeAutomation\\SS\\mESSAGE.png");
		Thread.sleep(2000);
		GetWebElementandClick("CloseMessage");
		

	}	
}
