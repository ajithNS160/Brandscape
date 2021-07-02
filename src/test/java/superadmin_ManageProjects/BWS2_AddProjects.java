package superadmin_ManageProjects;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS2_AddProjects extends BaseClass {
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







		Thread.sleep(5000);
		GetWebElementandClick("ManageProject");
		GetWebElementandClick("AddProject");



		TypeDataInTheElement("ProjectName", SuperAdminExcel(1, 2, "Add Project"));
		LogInfo("Project Name is clicked and value entered as :" + SuperAdminExcel(1, 2, "Add Project"));

		Thread.sleep(2000);

		TypeDataInTheElement("CompanyName", SuperAdminExcel(1, 3, "Add Project"));
		LogInfo("Company Name is clicked and value entered as :" + SuperAdminExcel(1, 3, "Add Project"));
		Thread.sleep(2000);


		TypeDataInTheElement("Admin", SuperAdminExcel(1, 4, "Add Project"));
		LogInfo("Admin is clicked and value entered as :" + SuperAdminExcel(1, 4, "Add Project"));
		Thread.sleep(3000);
		GetWebElementandClick("SelectAdmin");
		Thread.sleep(2000);


		TypeDataInTheElement("Category", SuperAdminExcel(1, 5, "Add Project"));
		LogInfo("Category is clicked and value entered as :" + SuperAdminExcel(1, 5, "Add Project"));
		Thread.sleep(2000);


		TypeDataInTheElement("Participants", SuperAdminExcel(1, 6, "Add Project"));
		LogInfo("Participants is clicked and value entered as :" + SuperAdminExcel(1, 6, "Add Project"));
		Thread.sleep(2000);


//		Thread.sleep(2000);
//		GetWebElementandClick("StartCalendar");
//		Thread.sleep(2000);
//		GetWebElementandClick("Yearpickerbtn");
//		Thread.sleep(2000);
//		Calendar("StartYearlist", "2021");
//		Calendar("StartMonthlist", "July");
//		Calendar("StartDateList", "1");
//
//
//		Thread.sleep(2000);
//		GetWebElementandClick("EndCalendar");
//		Thread.sleep(2000);
//		GetWebElementandClick("Yearpickerbtn");
//		Thread.sleep(2000);
//		Calendar("EndYearlist", "2021");
//		Calendar("EndMonthlist", "August");
//		Calendar("EndDateList", "15");
//
//		Thread.sleep(2000);
//		GetWebElementandClick("DemoCalendar");
//		Thread.sleep(2000);
//		GetWebElementandClick("Yearpickerbtn");
//		Thread.sleep(2000);
//		Calendar("DemoYearlist", "2021");
//		Calendar("DemoMonthlist", "July");
//		Calendar("DemoDateList", "25");

//
//		Thread.sleep(2000);
//		GetWebElementandClick("ReportCalendar");
//		Thread.sleep(2000);
//		GetWebElementandClick("Yearpickerbtn");
//		Thread.sleep(2000);
//		Calendar("ReportYearlist", "2021");
//		Calendar("ReportMonthlist", "August");
//		Calendar("ReportDateList", "25");

		Dropdown("Projectcon", "NOTSTARTED");

		Dropdown("TypeOfSelect", "Combo");
		Thread.sleep(2000);

		Thread.sleep(5000);
		TypeDataInTheElement("UploadBanner", SuperAdminExcel(1, 1, "Add Project"));


	}
}
