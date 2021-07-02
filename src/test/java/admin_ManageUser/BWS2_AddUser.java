package admin_ManageUser;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS2_AddUser extends BaseClass {
	//@Test
	//public static void AddUser() throws Throwable {

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


		
		Thread.sleep(3000);
		ExtentReportName("Add User");

		GetWebElementandClick("ManageUser");
		LogInfo("Manage user is clicked");

		GetWebElementandClick("AddUser");
		LogInfo("Add user is clicked");


		TypeDataInTheElement("Userid", AdminExcel(1, 1, "Add User"));
		LogInfo("Userid is entered as : " + AdminExcel(1, 1, "Add User"));
		System.err.println(AdminExcel(1, 1, "Add User"));

		TypeDataInTheElement("UserName", AdminExcel(1, 2, "Add User"));
		LogInfo("UserName is entered as : " + AdminExcel(1, 2, "Add User"));
		
		Thread.sleep(3000);
		GetWebElementandClick("Code");
		LogInfo("Phone number code is selected");

		TypeDataInTheElement("SearchCountry", AdminExcel(1, 3, "Add User"));
		LogInfo("In is typed in search country");

		GetWebElementandClick("Country");
		LogInfo("India is selected");

		TypeDataInTheElement("PhoneNumber", AdminExcel(1, 4, "Add User"));
		System.err.println(AdminExcel(1, 4, "Add User"));
		LogInfo("Phone number is typed as : " + AdminExcel(1, 4, "Add User") );

		Thread.sleep(3000);
		Robot upf = new Robot();
		upf.keyPress(KeyEvent.VK_TAB);
		upf.keyRelease(KeyEvent.VK_TAB);
		upf.keyPress(KeyEvent.VK_ENTER);
		upf.keyRelease(KeyEvent.VK_ENTER);
		//Thread.sleep(3000);
		//TypeDataInTheElement("Sendroles", "user");
		//Mouse("Roles");
//GetWebElementandClick("Roles");
//GetWebElementandClick("Roles");
		//Dropdown("Role", "user");
//		TypeDataInTheElement("Role", "user");
		Calendar("selectuserrole", "user");
//
//
//
//		Thread.sleep(1000);
//
//		GetWebElementandClick("SelectUser");
//		LogInfo("Role is selected as : User");

		

		TypeDataInTheElement("UserEmail", AdminExcel(1, 5, "Add User"));
		LogInfo("Phone number is typed as : " +  AdminExcel(1, 5, "Add User"));

		Thread.sleep(5000);
		//GetWebElementandClick("Role");
		LinkText("user");
//		LogInfo("Role is selected as : User");
		
		
		GetWebElementandClick("SaveUser");

	}

	@AfterTest
	public static void ReportFlush() {
		flush();
	}
}
