package admin_ManageSurvey;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS3_ViewSurvey extends BaseClass {


	@Test(priority = 3)
	public static void ViewSurvey() throws Throwable {


		Thread.sleep(3000);
		GetWebElementandClick("ManageSurvey");
		ExtentReportName("View Survey");
		GetWebElementandClick("ManageSurvey");
		

		List("ViewadminSurvey");
		LogInfo("Searching project name from the list");
	
		
		ViewFromList("ViewadminSurvey1", "ViewadminSurvey2", AdminExcel(1, 1, "View Survey"));
		LogInfo("Added survey is found and viewed");

		
	}


	
}