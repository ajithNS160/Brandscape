package superadmin_ViewUser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS2_ViewUser extends BaseClass {

	public static class BWS1_Login extends BaseClass {

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




			//@Test
			//public static void ViewUser() throws Throwable {



			Thread.sleep(4000);
			ExtentReportName("View user");
			LogInfo("View user is clicked");

			GetWebElementandClick("Viewuser");

			List("UserMail");
			LogInfo("Searching admin email from the list");

			ViewFromList("UserMail1", "UserMail2", SuperAdminExcel(1, 1, "View User"));
			LogInfo("Added admin is found and viewed");

			ViewAll("ViewAllUser");
			WebElement NextButton =		GetWebElement("NextButton");
			if(NextButton.isEnabled()) {
				NextButton.click();
				Thread.sleep(2000);
				ViewAll("ViewAllUser");
			}


		}
	}}
