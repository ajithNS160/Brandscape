package admin_ManageUser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS1_Login extends BaseClass {
	@BeforeTest

	public static void ExtentReport() throws Throwable {

		Extentreport("Brandscape", "Brandscape Automation", "Ajith Kumar", "\\ExtentReports\\Admin_ManageUser.html");
	}

	@Test()
	public static void Login() throws Throwable {

		ExtentReportName("Login");

		LaunchURLinChromeDriver("URL");
		//LaunchURLinFirefoxDriver("URL");
		LogInfo("Brandscape URL loaded successfully");

		TimeWait();

		TypeDataInTheElement("Email", AdminExcel(1, 1, "Admin Login"));
		LogInfo("Email ID is entered as :" + AdminExcel(1, 1, "Admin Login"));

		TypeDataInTheElement("Password", AdminExcel(1, 2 , "Admin Login"));
		LogInfo("Password is entered as :" + AdminExcel(1, 2 , "Admin Login"));

		GetWebElementandClick("LoginButton");
		LogInfo("Login button is clicked");

		WebElement Dashboard =	GetWebElement("Dashboard");
		if(Dashboard.isDisplayed()) {
			ConditionPass("Admin logged in successfully");
			LogInfo("Admin logged in successfully");
		}

		else {
			ConditionFail("Admin log in failed");
			LogInfo("Admin log in failed");
		}


	}
}
