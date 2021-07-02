package admin_ManageSurvey;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS6_DeleteSurvey extends BaseClass {



	@Test(priority = 6)
	public static void DeleteSurvey() throws Throwable {


		Thread.sleep(5000);
		ExtentReportName("Delete Survey");
		GetWebElementandClick("ManageSurvey");

		List("SurveyDelete");
		LogInfo("Survey name is searching");

		DeleteFromList("SurveyDelete1", "SurveyDelete2", "SurveyDelete3", "SurveyDelete4", AdminExcel(1, 1, "Delete Survey"));
		LogInfo("Survey name is searched");

		GetWebElementandClick("DeleteSurveyYes");
		LogInfo("Delete yes is clicked");

		
		Thread.sleep(4000);
		WebElement SurveyDeletedSuccessfully =	GetWebElement("SurveyDeletedSuccessfully");

		if(SurveyDeletedSuccessfully.isDisplayed()) {
			ConditionPass("Survey deleted successfully");
			LogInfo("Survey deleted successfully");
		}else {
			ConditionFail("Survey not deleted");
			LogInfo("Survey not deleted");
		}
	}
	
	@AfterTest
	public static void ReportFlush() {
		flush();
	}
}
