package admin_ManageSurvey;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS2_ManageSurvey extends BaseClass {
	@BeforeTest

	public static void ExtentReport() throws Throwable {

		Extentreport("Brandscape", "Brandscape Automation", "Ajith Kumar", "\\ExtentReports\\Admin_ManagesURVEY.html");
	}

	@Test(priority = 1)
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

		ExtentReportName("Manage Survey");
		
		Thread.sleep(2000);
		GetWebElementandClick("SelectProject");
		LinkText("Multiverse");

	//@Test(priority = 2)

	//public static void ManageSurvey() throws Throwable {
	//	ExtentReportName("Manage Survey");

			
			Thread.sleep(5000);
//			GetWebElementandClick("SelectProject");
//			Thread.sleep(3000);
//			Select("Automation");
			GetWebElementandClick("ManageSurvey");
			GetWebElementandClick("AddSurvey");
			Thread.sleep(5000);
			
			TypeDataInTheElement("JSON", AdminExcel(1, 2, "Add Survey"));
			TypeDataInTheElement("SurveyTitle", "Automater");
		
			
		//	GetWebElementandClick("AddGlobalNotification");
			
//			GetWebElementandClick("NotiCalendar");
//			Thread.sleep(2000);
//			GetWebElementandClick("Yearpickerbtn");
//			Thread.sleep(2000);
//			Calendar("NotiYear", "2021");
//			Calendar("NotiMonth", "July");
//			Calendar("NotiDate", "25");
			//GetWebElementandClick("cancelnoti");
//			TypeDataInTheElement("NotificationTitle", "Automate");
//			TypeDataInTheElement("NotificationInput", "Automate");
//			GetWebElementandClick("NotiType");
//			GetWebElementandClick("App");

			

		
			
			
			//Thread.sleep(5000);
		//	Scroll("SaveSurvey");
			Thread.sleep(5000);
			GetWebElementandClick("Savesu");
		
	
			
			
		}
}

