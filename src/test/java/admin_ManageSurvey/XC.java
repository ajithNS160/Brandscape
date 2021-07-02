package admin_ManageSurvey;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class XC extends BaseClass{
	@BeforeTest

	public static void ExtentReport() throws Throwable {

		Extentreport("Brandscape", "Brandscape Automation", "Ajith Kumar", "\\ExtentReports\\ExtentReport.html");
	}

	@Test()
	public static void Login() throws Throwable {

		ExtentReportName("Login");

		//LaunchURLinChromeDriver("URL");
	LaunchURLinFirefoxDriver("URL");
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
		Thread.sleep(5000);
		GetWebElementandClick("ManageProject");
		GetWebElementandClick("AddProject");
		Thread.sleep(2000);
		
		TypeDataInTheElement("Participants", "5");
		LogInfo("Participants is clicked and value entered as :" + SuperAdminExcel(1, 6, "Add Project"));
	
Dropdown("TypeOfSelect", "Combo");
//GetWebElementandClick("ProjectStatus");
		//Dropdown("ProjectStatus", "NOTSTARTED");




	}}
